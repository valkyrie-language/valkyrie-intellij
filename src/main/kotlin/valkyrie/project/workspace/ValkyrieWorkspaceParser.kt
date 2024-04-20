package valkyrie.project.workspace

import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiManager
import com.intellij.json.psi.JsonFile
import com.intellij.json.psi.JsonObject
import com.intellij.json.psi.JsonStringLiteral
import com.intellij.json.psi.JsonArray
import com.intellij.openapi.application.ReadAction
import valkyrie.project.ValkyrieProjectParser
import valkyrie.project.ValkyriePackageDependency
import valkyrie.project.DependencySource

/**
 * Valkyrie Workspace 解析器
 * 负责识别和解析 legions.json 文件，确定 workspace 结构
 * 支持包别名和依赖配置
 */
class ValkyrieWorkspaceParser {
    
    companion object {
        const val LEGIONS_JSON = "legions.json"
        const val PACKAGES_DIR = "packages"
    }
    
    /**
     * 检查给定目录是否为 Valkyrie workspace
     * @param directory 要检查的目录
     * @return 如果是 workspace 返回 true
     */
    fun isValkyrieWorkspace(directory: VirtualFile): Boolean {
        if (!directory.isDirectory) return false
        
        val legionsJson = directory.findChild(LEGIONS_JSON)
        val packagesDir = directory.findChild(PACKAGES_DIR)
        
        return legionsJson != null && legionsJson.exists() && 
               packagesDir != null && packagesDir.isDirectory
    }
    
    /**
     * 解析 workspace 配置
     * @param project IntelliJ 项目实例
     * @param workspaceRoot workspace 根目录
     * @return ValkyrieWorkspace 实例，如果解析失败返回 null
     */
    fun parseWorkspace(project: Project, workspaceRoot: VirtualFile): ValkyrieWorkspace? {
        val legionsJsonFile = workspaceRoot.findChild(LEGIONS_JSON) ?: return null
        
        return ReadAction.compute<ValkyrieWorkspace?, RuntimeException> {
            val psiManager = PsiManager.getInstance(project)
            val jsonFile = psiManager.findFile(legionsJsonFile) as? JsonFile ?: return@compute null
            
            val rootObject = jsonFile.topLevelValue as? JsonObject ?: return@compute null
            
            // 解析包依赖映射
            val packageDependencies = parsePackageDependencies(rootObject, workspaceRoot, project)
            
            // 解析包别名映射
            val packageAliases = parsePackageAliases(rootObject)
            
            ValkyrieWorkspace(
                root = workspaceRoot,
                name = workspaceRoot.name,
                isPrivate = getBooleanProperty(rootObject, "private") ?: false,
                scripts = parseScripts(rootObject),
                packages = findPackages(workspaceRoot),
                packageDependencies = packageDependencies,
                packageAliases = packageAliases
            )
        }
    }
    
    /**
     * 解析脚本配置
     */
    private fun parseScripts(rootObject: JsonObject): Map<String, String> {
        val scriptsProperty = rootObject.findProperty("scripts") ?: return emptyMap()
        val scriptsObject = scriptsProperty.value as? JsonObject ?: return emptyMap()
        
        val scripts = mutableMapOf<String, String>()
        for (property in scriptsObject.propertyList) {
            val key = property.name
            val value = (property.value as? JsonStringLiteral)?.value
            if (key != null && value != null) {
                scripts[key] = value
            }
        }
        return scripts
    }
    
    /**
     * 查找所有包
     */
    private fun findPackages(workspaceRoot: VirtualFile): List<VirtualFile> {
        val packagesDir = workspaceRoot.findChild(PACKAGES_DIR) ?: return emptyList()
        
        return packagesDir.children.filter { child ->
            child.isDirectory && child.findChild(ValkyrieProjectParser.Companion.LEGION_JSON) != null
        }
    }
    
    /**
     * 解析包依赖配置
     * 支持 dependencies 和 dev-dependencies 字段
     */
    private fun parsePackageDependencies(
        rootObject: JsonObject, 
        workspaceRoot: VirtualFile,
        project: Project
    ): Map<String, ValkyriePackageDependency> {
        val dependencies = mutableMapOf<String, ValkyriePackageDependency>()
        
        // 解析主依赖
        dependencies.putAll(parseDependencySection(rootObject, "dependencies", workspaceRoot, project))
        
        // 解析开发依赖
        dependencies.putAll(parseDependencySection(rootObject, "dev-dependencies", workspaceRoot, project))
        
        return dependencies
    }
    
    /**
     * 解析指定的依赖段
     */
    private fun parseDependencySection(
        rootObject: JsonObject,
        sectionName: String,
        workspaceRoot: VirtualFile,
        project: Project
    ): Map<String, ValkyriePackageDependency> {
        val depsProperty = rootObject.findProperty(sectionName) ?: return emptyMap()
        val depsObject = depsProperty.value as? JsonObject ?: return emptyMap()
        
        val dependencies = mutableMapOf<String, ValkyriePackageDependency>()
        
        // 正确遍历 JSON 对象的属性
        for (property in depsObject.propertyList) {
            val name = property.name ?: continue
            val value = property.value
            
            when (value) {
                is JsonStringLiteral -> {
                    // 简单版本字符串： "package-name": "1.0.0"
                    dependencies[name] = ValkyriePackageDependency(
                        name = name,
                        version = value.value,
                        source = DependencySource.External()
                    )
                }
                is JsonObject -> {
                    // 复杂配置： "package-name": { "path": "./relative/path", "alias": "pkg" }
                    val path = getStringProperty(value, "path")
                    val alias = getStringProperty(value, "alias")
                    val version = getStringProperty(value, "version") ?: "latest"
                    val gitUrl = getStringProperty(value, "git")
                    val branch = getStringProperty(value, "branch")
                    val tag = getStringProperty(value, "tag")
                    
                    val source = when {
                        gitUrl != null -> DependencySource.Git(gitUrl, branch, tag)
                        path != null -> {
                            // 解析相对路径为绝对路径
                            val absolutePath = resolvePath(workspaceRoot, path)
                            DependencySource.Local(absolutePath)
                        }
                        else -> DependencySource.External()
                    }
                    
                    dependencies[name] = ValkyriePackageDependency(
                        name = name,
                        version = version,
                        source = source,
                        alias = alias
                    )
                }
            }
        }
        
        return dependencies
    }
    
    /**
     * 解析包别名映射
     * 从 dependencies 字段中提取别名配置
     */
    private fun parsePackageAliases(rootObject: JsonObject): Map<String, String> {
        val aliases = mutableMapOf<String, String>()
        
        val depsProperty = rootObject.findProperty("dependencies") ?: return aliases
        val depsObject = depsProperty.value as? JsonObject ?: return aliases
        
        // 正确遍历 JSON 对象的属性
        for (property in depsObject.propertyList) {
            val name = property.name ?: continue
            val value = property.value
            
            if (value is JsonObject) {
                val alias = getStringProperty(value, "alias")
                if (alias != null) {
                    aliases[alias] = name
                }
            }
        }
        
        return aliases
    }
    
    /**
     * 解析相对路径为绝对路径
     */
    private fun resolvePath(workspaceRoot: VirtualFile, relativePath: String): String {
        // 处理 ./ 开头的相对路径
        val cleanPath = relativePath.removePrefix("./")
        return "${workspaceRoot.path}/$cleanPath"
    }
    
    /**
     * 获取字符串属性值
     */
    private fun getStringProperty(jsonObject: JsonObject, propertyName: String): String? {
        val property = jsonObject.findProperty(propertyName) ?: return null
        return (property.value as? JsonStringLiteral)?.value
    }
    
    /**
     * 获取布尔属性值
     */
    private fun getBooleanProperty(jsonObject: JsonObject, propertyName: String): Boolean? {
        val property = jsonObject.findProperty(propertyName) ?: return null
        return when (val value = property.value?.text?.trim('"')) {
            "true" -> true
            "false" -> false
            else -> null
        }
    }
}

