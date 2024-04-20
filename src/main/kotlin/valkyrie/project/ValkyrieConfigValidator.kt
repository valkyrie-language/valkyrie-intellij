package valkyrie.project

import com.intellij.openapi.vfs.VirtualFile
import valkyrie.project.workspace.ValkyrieWorkspace
import java.util.*

/**
 * Valkyrie 配置验证器
 * 负责验证 legion.json 和 legions.json 配置的正确性
 */
object ValkyrieConfigValidator {

    /**
     * 验证 legion.json 配置
     */
    fun validateLegionConfig(config: ValkyriePackageInfo, file: VirtualFile): List<String> {
        val errors = mutableListOf<String>()
        val warnings = mutableListOf<String>()

        // 验证包名格式
        if (config.name.isBlank()) {
            errors.add("包名不能为空")
        } else if (!isValidPackageName(config.name)) {
            errors.add("包名格式无效: ${config.name}，应只包含字母、数字、连字符和下划线")
        }

        // 验证版本号格式
        if (config.version.isBlank()) {
            errors.add("版本号不能为空")
        } else if (!isValidVersion(config.version)) {
            errors.add("版本号格式无效: ${config.version}，应符合语义化版本规范")
        }

        // 验证命名空间格式
        config.namespace?.let { namespace ->
            if (!isValidNamespace(namespace)) {
                errors.add("命名空间格式无效: $namespace")
            }
        }

        // 验证导出模块
        if (config.exports.isNotEmpty()) {
            val duplicateExports = config.exports.groupingBy { it }.eachCount().filter { it.value > 1 }
            if (duplicateExports.isNotEmpty()) {
                errors.add("重复的导出模块: ${duplicateExports.keys.joinToString()}")
            }
        }

        // 验证依赖版本
        // 这里可以添加更多验证逻辑

        return errors + warnings
    }

    /**
     * 验证 legions.json 配置
     */
    fun validateLegionsConfig(workspace: ValkyrieWorkspace, file: VirtualFile): List<String> {
        val errors = mutableListOf<String>()
        val warnings = mutableListOf<String>()

        // 验证工作空间名称
        if (workspace.name.isBlank()) {
            errors.add("工作空间名称不能为空")
        }

        // 验证包路径
        for (pkg in workspace.packages) {
            if (!pkg.exists()) {
                errors.add("包目录不存在: ${pkg.path}")
            } else if (!pkg.isDirectory) {
                errors.add("包路径不是目录: ${pkg.path}")
            }
        }

        // 验证循环依赖
        if (workspace.hasCircularDependency()) {
            errors.add("检测到循环依赖")
        }

        // 验证包别名冲突
        val aliasCounts = workspace.packageAliases.keys.groupingBy { it }.eachCount()
        for ((alias, count) in aliasCounts) {
            if (count > 1) {
                errors.add("包别名冲突: $alias")
            }
        }

        // 验证脚本命令
        for ((scriptName, command) in workspace.scripts) {
            if (scriptName.isBlank()) {
                errors.add("脚本名称不能为空")
            }
            if (command.isBlank()) {
                errors.add("脚本 '$scriptName' 的命令不能为空")
            }
        }

        return errors + warnings
    }

    /**
     * 验证包依赖配置
     */
    fun validateDependency(dependency: ValkyriePackageDependency): List<String> {
        val errors = mutableListOf<String>()

        if (dependency.name.isBlank()) {
            errors.add("依赖名称不能为空")
        }

        if (dependency.version.isBlank()) {
            errors.add("依赖版本不能为空")
        }

        // 验证版本约束格式
        if (!isValidVersionConstraint(dependency.version)) {
            errors.add("版本约束格式无效: ${dependency.version}")
        }

        // 验证别名格式
        dependency.alias?.let { alias ->
            if (!isValidPackageName(alias)) {
                errors.add("依赖别名格式无效: $alias")
            }
        }

        return errors
    }

    /**
     * 检查包名是否有效
     */
    private fun isValidPackageName(name: String): Boolean {
        // 允许字母、数字、连字符、下划线
        return name.matches(Regex("^[a-zA-Z0-9_-]+$"))
    }

    /**
     * 检查版本号是否有效（语义化版本）
     */
    private fun isValidVersion(version: String): Boolean {
        // 支持语义化版本：1.2.3, 1.2.3-alpha, 1.2.3-alpha.1
        return version.matches(Regex("^\\d+\\.\\d+\\.\\d+(-[a-zA-Z0-9.]+)?$"))
    }

    /**
     * 检查命名空间是否有效
     */
    private fun isValidNamespace(namespace: String): Boolean {
        // 命名空间应为点分隔的标识符
        return namespace.split(".").all { part ->
            part.matches(Regex("^[a-zA-Z_][a-zA-Z0-9_]*$"))
        }
    }

    /**
     * 检查版本约束是否有效
     */
    private fun isValidVersionConstraint(constraint: String): Boolean {
        // 支持：1.2.3, ^1.2.3, ~1.2.3, >=1.2.3, 1.x, latest
        val patterns = listOf(
            "^\\d+\\.\\d+\\.\\d+$",                    // 精确版本
            "^[\\^~]?\\d+\\.\\d+\\.\\d+.*$",           // ^1.2.3, ~1.2.3
            "^[><=]+\\s*\\d+\\.\\d+\\.\\d+.*$",        // >=1.2.3
            "^\\d+\\.x$",                              // 1.x
            "^latest$"                                 // latest
        )
        return patterns.any { constraint.matches(Regex(it)) }
    }

    /**
     * 验证文件路径是否为有效的 Valkyrie 项目
     */
    fun isValidValkyrieProject(directory: VirtualFile): Boolean {
        if (!directory.isDirectory) return false
        val legionJson = directory.findChild("legion.json") ?: return false
        return legionJson.exists() && !legionJson.isDirectory
    }

    /**
     * 验证文件路径是否为有效的 Valkyrie 工作空间
     */
    fun isValidValkyrieWorkspace(directory: VirtualFile): Boolean {
        if (!directory.isDirectory) return false
        val legionsJson = directory.findChild("legions.json") ?: return false
        return legionsJson.exists() && !legionsJson.isDirectory
    }

    /**
     * 检查包名是否冲突
     */
    fun checkPackageNameConflict(
        packageName: String,
        currentWorkspace: ValkyrieWorkspace,
        allWorkspaces: List<ValkyrieWorkspace>
    ): String? {
        // 检查当前工作空间内的冲突
        val currentPackages = currentWorkspace.packages.mapNotNull { pkg ->
            // 由于无法获取真实的项目实例，这里只检查目录名作为包名
            pkg.name
        }

        if (currentPackages.count { it == packageName } > 1) {
            return "工作空间内存在同名包: $packageName"
        }

        // 检查跨工作空间的冲突（如果需要）
        // 这里可以根据需要添加更复杂的冲突检测

        return null
    }

    /**
     * 生成建议的包名
     */
    fun suggestPackageName(baseName: String): String {
        return baseName
            .lowercase()
            .replace(Regex("[^a-z0-9_-]"), "-")
            .replace(Regex("-+"), "-")
            .trim('-')
    }

    /**
     * 生成建议的命名空间
     */
    fun suggestNamespace(baseName: String): String {
        return baseName
            .lowercase()
            .replace(Regex("[^a-z0-9_.]"), ".")
            .replace(Regex("[.]+"), ".")
            .trim('.')
    }
}