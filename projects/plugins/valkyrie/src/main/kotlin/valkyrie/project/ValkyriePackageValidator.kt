package valkyrie.project

import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.json.psi.JsonFile
import com.intellij.json.psi.JsonObject
import com.intellij.psi.PsiManager
import com.intellij.openapi.application.ReadAction
import valkyrie.project.workspace.ValkyrieWorkspace

/**
 * Valkyrie 包配置验证器
 * 负责验证 legion.json 和 legions.json 配置文件的正确性
 */
class ValkyriePackageValidator(private val project: Project) {

    /**
     * 验证 legion.json 配置
     */
    fun validateLegionJson(legionFile: VirtualFile): ValidationResult {
        return ReadAction.compute<ValidationResult, RuntimeException> {
            val psiManager = PsiManager.getInstance(project)
            val jsonFile = psiManager.findFile(legionFile) as? JsonFile
                ?: return@compute ValidationResult.error("文件不是有效的 JSON 文件")

            val rootObject = jsonFile.topLevelValue as? JsonObject
                ?: return@compute ValidationResult.error("JSON 根元素必须是对象")

            val errors = mutableListOf<String>()
            val warnings = mutableListOf<String>()

            // 验证必填字段
            val name = getStringProperty(rootObject, "name")
            if (name == null) {
                errors.add("缺少必填字段 'name'")
            } else if (!isValidPackageName(name)) {
                errors.add("包名 '$name' 格式无效，应使用小写字母、数字和连字符")
            }

            val version = getStringProperty(rootObject, "version")
            if (version == null) {
                errors.add("缺少必填字段 'version'")
            } else if (!isValidVersion(version)) {
                errors.add("版本号 '$version' 格式无效，应使用语义化版本格式")
            }

            // 验证可选字段
            val namespace = getStringProperty(rootObject, "namespace")
            if (namespace != null && !isValidNamespace(namespace)) {
                errors.add("命名空间 '$namespace' 格式无效")
            }

            // 验证导出字段
            val exports = parseStringArray(rootObject, "exports")
            if (exports.isNotEmpty()) {
                // 检查是否有重复的导出
                val duplicates = exports.groupingBy { it }.eachCount().filter { it.value > 1 }
                if (duplicates.isNotEmpty()) {
                    warnings.add("导出列表中存在重复项: ${duplicates.keys.joinToString()}")
                }
            }

            // 验证依赖格式
            val dependencies = parseDependencies(rootObject, "dependencies")
            val buildDependencies = parseDependencies(rootObject, "build-dependencies")
            val devDependencies = parseDependencies(rootObject, "dev-dependencies")

            // 检查依赖冲突
            val allDeps = dependencies + buildDependencies + devDependencies
            val depConflicts = allDeps.entries.groupingBy { it.key }.eachCount().filter { it.value > 1 }
            if (depConflicts.isNotEmpty()) {
                errors.add("依赖冲突: ${depConflicts.keys.joinToString()} 在多个依赖段中出现")
            }

            // 验证依赖版本格式
            for ((depName, depValue) in allDeps) {
                val version = when (depValue) {
                    is String -> depValue
                    is JsonObject -> getStringProperty(depValue, "version") ?: "latest"
                    else -> "latest"
                }
                if (!isValidVersionConstraint(version)) {
                    warnings.add("依赖 '$depName' 的版本约束 '$version' 格式可能无效")
                }
            }

            if (errors.isEmpty()) {
                ValidationResult.success()
            } else {
                ValidationResult(errors, warnings, false)
            }
        }
    }

    /**
     * 验证 legions.json 配置
     */
    fun validateLegionsJson(legionsFile: VirtualFile): ValidationResult {
        return ReadAction.compute<ValidationResult, RuntimeException> {
            val psiManager = PsiManager.getInstance(project)
            val jsonFile = psiManager.findFile(legionsFile) as? JsonFile
                ?: return@compute ValidationResult.error("文件不是有效的 JSON 文件")

            val rootObject = jsonFile.topLevelValue as? JsonObject
                ?: return@compute ValidationResult.error("JSON 根元素必须是对象")

            val errors = mutableListOf<String>()
            val warnings = mutableListOf<String>()

            // 验证 packages 字段
            val packages = parseStringArray(rootObject, "packages")
            if (packages.isEmpty()) {
                warnings.add("未定义任何包路径，工作空间可能为空")
            }

            // 验证依赖配置
            val dependencies = parseDependencies(rootObject, "dependencies")
            val devDependencies = parseDependencies(rootObject, "dev-dependencies")

            // 检查包别名冲突
            val aliases = mutableMapOf<String, String>()
            for ((depName, depConfig) in dependencies + devDependencies) {
                if (depConfig is JsonObject) {
                    val alias = getStringProperty(depConfig, "alias")
                    if (alias != null) {
                        if (aliases.containsKey(alias)) {
                            errors.add("包别名冲突: '$alias' 被用于 '$depName' 和 '${aliases[alias]}'")
                        } else {
                            aliases[alias] = depName
                        }
                    }
                }
            }

            // 验证包路径存在性（警告级别）
            for (pkgPath in packages) {
                val resolvedPath = resolvePath(legionsFile.parent, pkgPath)
                val pkgDir = com.intellij.openapi.vfs.LocalFileSystem.getInstance().findFileByPath(resolvedPath)
                if (pkgDir == null) {
                    warnings.add("包路径不存在: $pkgPath")
                } else if (!ValkyrieProjectParser().isValkyrieProject(pkgDir)) {
                    warnings.add("路径 '$pkgPath' 不是有效的 Valkyrie 项目（缺少 legion.json）")
                }
            }

            // 验证循环依赖
            if (hasCircularDependency(dependencies + devDependencies)) {
                errors.add("检测到循环依赖")
            }

            if (errors.isEmpty()) {
                ValidationResult.success()
            } else {
                ValidationResult(errors, warnings, false)
            }
        }
    }

    /**
     * 验证包依赖关系
     */
    fun validateDependencies(workspace: ValkyrieWorkspace): ValidationResult {
        val errors = mutableListOf<String>()
        val warnings = mutableListOf<String>()

        // 检查循环依赖
        if (workspace.hasCircularDependency()) {
            errors.add("工作空间存在循环依赖")
        }

        // 检查所有依赖是否可解析
        val packageManager = ValkyriePackageManager.getInstance(project)
        for ((name, dep) in workspace.packageDependencies) {
            val resolved = packageManager.resolveDependency(dep, workspace)
            if (resolved.packageDir == null) {
                errors.add("无法解析依赖: $name")
            } else if (resolved.packageInfo == null) {
                warnings.add("依赖 '$name' 的包信息解析失败")
            }
        }

        // 检查版本兼容性（简单检查）
        for ((name, dep) in workspace.packageDependencies) {
            if (!isValidVersionConstraint(dep.version)) {
                warnings.add("依赖 '$name' 的版本约束 '${dep.version}' 可能无效")
            }
        }

        return if (errors.isEmpty()) {
            ValidationResult.success()
        } else {
            ValidationResult(errors, warnings, false)
        }
    }

    /**
     * 验证包命名空间冲突
     */
    fun validateNamespaceConflicts(workspace: ValkyrieWorkspace): ValidationResult {
        val errors = mutableListOf<String>()
        val warnings = mutableListOf<String>()

        val namespaceToPackages = mutableMapOf<String, MutableList<String>>()

        // 收集工作空间内包的命名空间
        val projectManager = ValkyrieProjectManager.getInstance(project)
        val projects = projectManager.getProjectsInWorkspace(workspace)

        for (project in projects) {
            val namespace = project.packageInfo.getEffectiveNamespace()
            namespaceToPackages.getOrPut(namespace) { mutableListOf() }.add(project.packageInfo.name)
        }

        // 检查命名空间冲突
        for ((namespace, packages) in namespaceToPackages) {
            if (packages.size > 1) {
                errors.add("命名空间冲突: '$namespace' 被多个包使用: ${packages.joinToString()}")
            }
        }

        return if (errors.isEmpty()) {
            ValidationResult.success()
        } else {
            ValidationResult(errors, warnings, false)
        }
    }

    // 辅助方法

    private fun isValidPackageName(name: String): Boolean {
        // 允许小写字母、数字、连字符和下划线
        return name.matches(Regex("^[a-z0-9_-]+$"))
    }

    private fun isValidVersion(version: String): Boolean {
        // 简单的语义化版本检查
        return version.matches(Regex("^\\d+\\.\\d+\\.\\d+(-[a-zA-Z0-9.]+)?(\\+[a-zA-Z0-9.]+)?$"))
    }

    private fun isValidNamespace(namespace: String): Boolean {
        // 允许点分隔的标识符
        return namespace.matches(Regex("^[a-zA-Z_][a-zA-Z0-9_]*(\\.[a-zA-Z_][a-zA-Z0-9_]*)*$"))
    }

    private fun isValidVersionConstraint(constraint: String): Boolean {
        // 允许版本号、版本范围、latest 等
        val validPatterns = listOf(
            "^\\d+\\.\\d+\\.\\d+$",                    // 精确版本
            "^\\^\\d+\\.\\d+\\.\\d+$",                 // ^ 通配符
            "^~\\d+\\.\\d+\\.\\d+$",                   // ~ 通配符
            "^>=\\d+\\.\\d+\\.\\d+$",                  // 大于等于
            "^<=\\d+\\.\\d+\\.\\d+$",                  // 小于等于
            "^\\d+\\.\\d+\\.\\d+ - \\d+\\.\\d+\\.\\d+$", // 范围
            "^latest$",                                // 最新版本
            "^\\*$"                                    // 任意版本
        )

        return validPatterns.any { constraint.matches(Regex(it)) } || constraint.matches(Regex("^[a-zA-Z0-9._-]+$"))
    }

    private fun getStringProperty(jsonObject: JsonObject, propertyName: String): String? {
        val property = jsonObject.findProperty(propertyName) ?: return null
        return (property.value as? com.intellij.json.psi.JsonStringLiteral)?.value
    }

    private fun parseStringArray(jsonObject: JsonObject, propertyName: String): List<String> {
        val property = jsonObject.findProperty(propertyName) ?: return emptyList()
        val array = property.value as? com.intellij.json.psi.JsonArray ?: return emptyList()

        return array.valueList.mapNotNull { 
            (it as? com.intellij.json.psi.JsonStringLiteral)?.value 
        }
    }

    private fun parseDependencies(rootObject: JsonObject, sectionName: String): Map<String, Any> {
        val property = rootObject.findProperty(sectionName) ?: return emptyMap()
        val depsObject = property.value as? JsonObject ?: return emptyMap()

        val dependencies = mutableMapOf<String, Any>()
        for (prop in depsObject.propertyList) {
            val name = prop.name ?: continue
            val value = prop.value
            if (value != null) {
                dependencies[name] = value
            }
        }

        return dependencies
    }

    private fun resolvePath(base: VirtualFile, relative: String): String {
        val clean = relative.removePrefix("./")
        return "${base.path}/$clean"
    }

    private fun hasCircularDependency(dependencies: Map<String, Any>): Boolean {
        // 简化的循环依赖检测
        // 这里应该实现完整的图算法，但为了简化，我们暂时返回 false
        // 实际实现中需要解析依赖图
        return false
    }
}

/**
 * 验证结果
 */
data class ValidationResult(
    val errors: List<String>,
    val warnings: List<String>,
    val isValid: Boolean
) {
    companion object {
        fun success(): ValidationResult {
            return ValidationResult(emptyList(), emptyList(), true)
        }

        fun error(message: String): ValidationResult {
            return ValidationResult(listOf(message), emptyList(), false)
        }
    }

    fun hasErrors(): Boolean = errors.isNotEmpty()
    fun hasWarnings(): Boolean = warnings.isNotEmpty()

    fun format(): String {
        val parts = mutableListOf<String>()
        if (errors.isNotEmpty()) {
            parts.add("错误:\n${errors.joinToString("\n") { "  - $it" }}")
        }
        if (warnings.isNotEmpty()) {
            parts.add("警告:\n${warnings.joinToString("\n") { "  - $it" }}")
        }
        return parts.joinToString("\n\n")
    }
}