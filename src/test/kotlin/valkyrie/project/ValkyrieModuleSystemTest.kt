package valkyrie.project

import com.intellij.testFramework.fixtures.BasePlatformTestCase
import com.intellij.openapi.vfs.VirtualFile
import valkyrie.project.workspace.ValkyrieWorkspaceParser
import valkyrie.index.ValkyrieEnhancedSymbolIndex

/**
 * Valkyrie 模块系统集成测试
 * 测试包管理、命名空间和跨包符号解析
 */
class ValkyrieModuleSystemTest : BasePlatformTestCase() {

    override fun getTestDataPath(): String {
        return "src/test/resources/testData/workspace"
    }

    fun testWorkspaceParsing() {
        val workspaceRoot = myFixture.copyDirectoryToProject(".", "workspace")
        val workspaceParser = ValkyrieWorkspaceParser()
        
        val workspace = workspaceParser.parseWorkspace(project, workspaceRoot)
        
        assertNotNull("工作空间应该被正确解析", workspace)
        assertEquals("工作空间应该包含3个包", 3, workspace?.packages?.size)
        assertEquals("工作空间应该有2个依赖", 2, workspace?.packageDependencies?.size)
        assertEquals("工作空间应该有2个别名", 2, workspace?.packageAliases?.size)
        
        // 验证别名映射
        assertEquals("core_lib 应该映射到 core", "core", workspace?.resolveAlias("core_lib"))
        assertEquals("util 应该映射到 utils", "utils", workspace?.resolveAlias("util"))
    }

    fun testPackageInfoParsing() {
        val workspaceRoot = myFixture.copyDirectoryToProject(".", "workspace")
        val projectParser = ValkyrieProjectParser()
        
        val coreDir = workspaceRoot.findChild("packages")?.findChild("core")
        assertNotNull("core 包目录应该存在", coreDir)
        
        val coreProject = projectParser.parseProject(project, coreDir!!)
        assertNotNull("core 包应该被正确解析", coreProject)
        
        val packageInfo = coreProject?.packageInfo
        assertEquals("包名应该是 core", "core", packageInfo?.name)
        assertEquals("命名空间应该是 com.valkyrie.core", "com.valkyrie.core", packageInfo?.namespace)
        assertEquals("应该导出2个模块", 2, packageInfo?.exports?.size)
        assertTrue("应该导出 types", packageInfo?.isExported("types") ?: false)
        assertTrue("应该导出 utils", packageInfo?.isExported("utils") ?: false)
    }

    fun testPackageManager() {
        val workspaceRoot = myFixture.copyDirectoryToProject(".", "workspace")
        val workspaceParser = ValkyrieWorkspaceParser()
        val workspace = workspaceParser.parseWorkspace(project, workspaceRoot)!!
        
        val packageManager = ValkyriePackageManager.getInstance(project)
        
        // 测试依赖解析
        val dependencies = packageManager.resolveWorkspaceDependencies(workspace)
        assertEquals("应该解析2个依赖", 2, dependencies.size)
        
        // 验证 core 依赖
        val coreDep = dependencies["core"]
        assertNotNull("core 依赖应该存在", coreDep)
        assertNotNull("core 依赖应该有包信息", coreDep?.packageInfo)
        assertEquals("core 依赖的包名应该是 core", "core", coreDep?.packageInfo?.name)
        
        // 测试包目录查找
        val coreDir = packageManager.findPackageDirectory("core_lib", workspace)
        assertNotNull("通过别名应该能找到 core 包", coreDir)
        
        val utilsDir = packageManager.findPackageDirectory("util", workspace)
        assertNotNull("通过别名应该能找到 utils 包", utilsDir)
        
        // 测试命名空间获取
        val coreNamespace = packageManager.getPackageNamespace("core_lib", workspace)
        assertEquals("core 的命名空间应该是 com.valkyrie.core", "com.valkyrie.core", coreNamespace)
    }

    fun testSymbolResolution() {
        val workspaceRoot = myFixture.copyDirectoryToProject(".", "workspace")
        val workspaceParser = ValkyrieWorkspaceParser()
        val workspace = workspaceParser.parseWorkspace(project, workspaceRoot)!!
        
        // 索引符号
        val symbolIndex = ValkyrieEnhancedSymbolIndex.getInstance(project)
        symbolIndex.rebuildIndex()
        
        // 测试包别名解析
        val alias = symbolIndex.resolvePackageAlias("core_lib")
        assertEquals("core_lib 应该解析到 core", "core", alias)
        
        // 测试命名空间获取
        val coreNamespace = symbolIndex.getPackageNamespace("core")
        assertEquals("core 的命名空间应该是 com.valkyrie.core", "com.valkyrie.core", coreNamespace)
        
        // 测试符号查找（需要在 web 文件中进行）
        val webAppFile = workspaceRoot.findChild("packages")?.findChild("web")?.findChild("app.vk")
        if (webAppFile != null) {
            // User 类应该能被找到
            val userSymbols = symbolIndex.findAllSymbolDefinitions("User", webAppFile)
            assertTrue("应该能找到 User 类定义", userSymbols.isNotEmpty())
            
            // add 函数应该能被找到
            val addSymbols = symbolIndex.findAllSymbolDefinitions("add", webAppFile)
            assertTrue("应该能找到 add 函数定义", addSymbols.isNotEmpty())
        }
    }

    fun testValidation() {
        val workspaceRoot = myFixture.copyDirectoryToProject(".", "workspace")
        val validator = ValkyriePackageValidator(project)
        
        // 验证 legion.json
        val legionFile = workspaceRoot.findChild("packages")?.findChild("core")?.findChild("legion.json")
        assertNotNull("legion.json 应该存在", legionFile)
        
        val legionResult = validator.validateLegionJson(legionFile!!)
        assertTrue("legion.json 应该有效", legionResult.isValid)
        assertFalse("legion.json 不应该有错误", legionResult.hasErrors())
        
        // 验证 legions.json
        val legionsFile = workspaceRoot.findChild("legions.json")
        assertNotNull("legions.json 应该存在", legionsFile)
        
        val legionsResult = validator.validateLegionsJson(legionsFile!!)
        assertTrue("legions.json 应该有效", legionsResult.isValid)
        assertFalse("legions.json 不应该有错误", legionsResult.hasErrors())
        
        // 验证工作空间依赖
        val workspaceParser = ValkyrieWorkspaceParser()
        val workspace = workspaceParser.parseWorkspace(project, workspaceRoot)!!
        val depResult = validator.validateDependencies(workspace)
        assertTrue("工作空间依赖应该有效", depResult.isValid)
    }

    fun testNamespaceConflictDetection() {
        val workspaceRoot = myFixture.copyDirectoryToProject(".", "workspace")
        val workspaceParser = ValkyrieWorkspaceParser()
        val workspace = workspaceParser.parseWorkspace(project, workspaceRoot)!!
        
        val validator = ValkyriePackageValidator(project)
        val result = validator.validateNamespaceConflicts(workspace)
        
        // 当前测试数据中不应该有命名空间冲突
        assertTrue("测试数据中不应该有命名空间冲突", result.isValid)
    }

    fun testCrossPackageImport() {
        val workspaceRoot = myFixture.copyDirectoryToProject(".", "workspace")
        
        // 索引所有符号
        val symbolIndex = ValkyrieEnhancedSymbolIndex.getInstance(project)
        symbolIndex.rebuildIndex()
        
        val webAppFile = workspaceRoot.findChild("packages")?.findChild("web")?.findChild("app.vk")
        assertNotNull("web app.vk 文件应该存在", webAppFile)
        
        // 获取文件的 using 导入
        val usings = symbolIndex.getFileUsings(webAppFile!!)
        assertEquals("应该有3个 using 导入", 3, usings.size)
        
        // 验证导入信息
        val userUsing = usings.find { it.symbolName == "User" }
        assertNotNull("应该有 User 导入", userUsing)
        assertEquals("User 应该来自 core_lib", "core_lib", userUsing?.sourcePackage)
        
        val addUsing = usings.find { it.symbolName == "add" }
        assertNotNull("应该有 add 导入", addUsing)
        assertEquals("add 应该来自 util", "util", addUsing?.sourcePackage)
    }
}