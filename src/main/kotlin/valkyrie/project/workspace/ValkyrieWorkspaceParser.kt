package valkyrie.project.workspace

import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiManager
import com.intellij.json.psi.JsonFile
import com.intellij.json.psi.JsonObject
import com.intellij.json.psi.JsonStringLiteral
import com.intellij.openapi.application.ReadAction
import valkyrie.project.ValkyrieProjectParser

/**
 * Valkyrie Workspace 解析器
 * 负责识别和解析 legions.json 文件，确定 workspace 结构
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
            
            ValkyrieWorkspace(
                root = workspaceRoot,
                name = workspaceRoot.name,
                isPrivate = getBooleanProperty(rootObject, "private") ?: false,
                scripts = parseScripts(rootObject),
                packages = findPackages(workspaceRoot)
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

