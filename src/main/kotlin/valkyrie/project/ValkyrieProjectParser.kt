package valkyrie.project

import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiManager
import com.intellij.json.psi.JsonFile
import com.intellij.json.psi.JsonObject
import com.intellij.json.psi.JsonStringLiteral
import com.intellij.json.psi.JsonArray
import com.intellij.openapi.application.ReadAction

/**
 * Valkyrie Project 解析器
 * 负责识别和解析 legion.json 文件，确定项目结构
 */
class ValkyrieProjectParser {
    
    companion object {
        const val LEGION_JSON = "legion.json"
        const val LIBRARY_DIR = "library"
        const val BINARY_DIR = "binary"
        const val TESTS_DIR = "test"
        const val ENTRY_FILE = "_.vk"
        const val ENTRY_FILE_ALT = "_.valkyrie"
    }
    
    /**
     * 检查给定目录是否为 Valkyrie 项目
     * @param directory 要检查的目录
     * @return 如果是项目返回 true
     */
    fun isValkyrieProject(directory: VirtualFile): Boolean {
        if (!directory.isDirectory) return false
        
        val legionJson = directory.findChild(LEGION_JSON)
        return legionJson != null && legionJson.exists()
    }
    
    /**
     * 解析项目配置
     * @param project IntelliJ 项目实例
     * @param projectRoot 项目根目录
     * @return ValkyrieProject 实例，如果解析失败返回 null
     */
    fun parseProject(project: Project, projectRoot: VirtualFile): ValkyrieProject? {
        val legionJsonFile = projectRoot.findChild(LEGION_JSON) ?: return null
        
        val jsonFile = ReadAction.compute<JsonFile?, RuntimeException> {
            val psiManager = PsiManager.getInstance(project)
            psiManager.findFile(legionJsonFile) as? JsonFile
        } ?: return null
        
        val rootObject = jsonFile.topLevelValue as? JsonObject ?: return null
        
        return ValkyrieProject(
            root = projectRoot,
            packageInfo = parsePackageInfo(rootObject),
            projectType = getStringProperty(rootObject, "type") ?: "library",
            features = parseFeatures(rootObject),
            dependencies = parseDependencies(rootObject),
            buildDependencies = parseBuildDependencies(rootObject),
            devDependencies = parseDevDependencies(rootObject),
            entryPoints = findEntryPoints(projectRoot)
        )
    }
    
    /**
     * 解析包信息
     */
    private fun parsePackageInfo(rootObject: JsonObject): ValkyriePackageInfo {
        val packageProperty = rootObject.findProperty("package")
        val packageObject = packageProperty?.value as? JsonObject ?: rootObject
        
        return ValkyriePackageInfo(
            name = getStringProperty(packageObject, "name") ?: "unknown",
            version = getStringProperty(packageObject, "version") ?: "0.0.0",
            description = getStringProperty(packageObject, "description"),
            authors = parseStringArray(packageObject, "authors"),
            repository = getStringProperty(packageObject, "repository"),
            documentation = getStringProperty(packageObject, "documentation"),
            edition = getStringProperty(packageObject, "edition"),
            license = getStringProperty(packageObject, "license"),
            readme = getStringProperty(packageObject, "readme"),
            publish = getBooleanProperty(packageObject, "publish") ?: true
        )
    }
    
    /**
     * 解析特性配置
     */
    private fun parseFeatures(rootObject: JsonObject): Map<String, List<String>> {
        val featuresProperty = rootObject.findProperty("features") ?: return emptyMap()
        val featuresObject = featuresProperty.value as? JsonObject ?: return emptyMap()
        
        val features = mutableMapOf<String, List<String>>()
        for (property in featuresObject.propertyList) {
            val key = property.name ?: continue
            val value = property.value as? JsonArray
            if (value != null) {
                val featureList = value.valueList.mapNotNull { 
                    (it as? JsonStringLiteral)?.value 
                }
                features[key] = featureList
            }
        }
        return features
    }
    
    /**
     * 解析依赖
     */
    private fun parseDependencies(rootObject: JsonObject): Map<String, String> {
        return parseDependencySection(rootObject, "dependencies")
    }
    
    /**
     * 解析构建依赖
     */
    private fun parseBuildDependencies(rootObject: JsonObject): Map<String, String> {
        return parseDependencySection(rootObject, "build-dependencies")
    }
    
    /**
     * 解析开发依赖
     */
    private fun parseDevDependencies(rootObject: JsonObject): Map<String, String> {
        return parseDependencySection(rootObject, "dev-dependencies")
    }
    
    /**
     * 解析依赖段
     */
    private fun parseDependencySection(rootObject: JsonObject, sectionName: String): Map<String, String> {
        val depsProperty = rootObject.findProperty(sectionName) ?: return emptyMap()
        val depsObject = depsProperty.value as? JsonObject ?: return emptyMap()
        
        val dependencies = mutableMapOf<String, String>()
        for (property in depsObject.propertyList) {
            val key = property.name
            val value = (property.value as? JsonStringLiteral)?.value
            if (key != null && value != null) {
                dependencies[key] = value
            }
        }
        return dependencies
    }
    
    /**
     * 查找入口点
     */
    private fun findEntryPoints(projectRoot: VirtualFile): ValkyrieEntryPoints {
        val libraryDir = projectRoot.findChild(LIBRARY_DIR)
        val binaryDir = projectRoot.findChild(BINARY_DIR)
        
        val libraryEntry = libraryDir?.let { dir ->
            dir.findChild(ENTRY_FILE) ?: dir.findChild(ENTRY_FILE_ALT)
        }
        
        val binaryEntries = mutableListOf<VirtualFile>()
        binaryDir?.children?.forEach { child ->
            when {
                child.name.endsWith(".vk") -> binaryEntries.add(child)
                child.isDirectory -> {
                    val entryFile = child.findChild(ENTRY_FILE) ?: child.findChild(ENTRY_FILE_ALT)
                    if (entryFile != null) {
                        binaryEntries.add(entryFile)
                    }
                }
            }
        }
        
        return ValkyrieEntryPoints(
            library = libraryEntry,
            binaries = binaryEntries
        )
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
    
    /**
     * 解析字符串数组
     */
    private fun parseStringArray(jsonObject: JsonObject, propertyName: String): List<String> {
        val property = jsonObject.findProperty(propertyName) ?: return emptyList()
        val array = property.value as? JsonArray ?: return emptyList()
        
        return array.valueList.mapNotNull { 
            (it as? JsonStringLiteral)?.value 
        }
    }
}

