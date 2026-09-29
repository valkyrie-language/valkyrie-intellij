package valkyrie.project

import com.intellij.notification.Notification
import com.intellij.notification.NotificationType
import com.intellij.notification.Notifications
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import valkyrie.project.workspace.ValkyrieWorkspace

/**
 * Valkyrie 错误通知服务
 * 负责向用户显示配置错误和警告
 */
class ValkyrieErrorNotifier(private val project: Project) {

    companion object {
        private const val NOTIFICATION_GROUP = "Valkyrie Configuration"
    }

    /**
     * 显示配置验证错误
     */
    fun showConfigErrors(
        configFile: VirtualFile,
        errors: List<String>,
        warnings: List<String> = emptyList()
    ) {
        if (errors.isEmpty() && warnings.isEmpty()) return

        val content = buildString {
            if (errors.isNotEmpty()) {
                append("<b>配置错误 (${configFile.name}):</b><br>")
                errors.forEach { append("• $it<br>") }
            }
            
            if (warnings.isNotEmpty()) {
                if (errors.isNotEmpty()) append("<br>")
                append("<b>警告 (${configFile.name}):</b><br>")
                warnings.forEach { append("• $it<br>") }
            }
        }

        val notification = Notification(
            NOTIFICATION_GROUP,
            "Valkyrie 配置问题",
            content,
            if (errors.isEmpty()) NotificationType.WARNING else NotificationType.ERROR
        )

        Notifications.Bus.notify(notification, project)
    }

    /**
     * 显示包解析错误
     */
    fun showPackageResolveError(packageName: String, reason: String) {
        val notification = Notification(
            NOTIFICATION_GROUP,
            "包解析失败",
            "无法解析包 '$packageName': $reason",
            NotificationType.ERROR
        )
        Notifications.Bus.notify(notification, project)
    }

    /**
     * 显示循环依赖错误
     */
    fun showCircularDependencyError(cycle: List<String>) {
        val notification = Notification(
            NOTIFICATION_GROUP,
            "循环依赖检测",
            "检测到循环依赖: ${cycle.joinToString(" -> ")}",
            NotificationType.ERROR
        )
        Notifications.Bus.notify(notification, project)
    }

    /**
     * 显示包冲突警告
     */
    fun showPackageConflictWarning(conflict: String) {
        val notification = Notification(
            NOTIFICATION_GROUP,
            "包名冲突",
            conflict,
            NotificationType.WARNING
        )
        Notifications.Bus.notify(notification, project)
    }

    /**
     * 显示索引构建成功通知
     */
    fun showIndexBuildSuccess(workspaceCount: Int, packageCount: Int) {
        val notification = Notification(
            NOTIFICATION_GROUP,
            "Valkyrie 索引构建完成",
            "已成功索引 $workspaceCount 个工作空间和 $packageCount 个包",
            NotificationType.INFORMATION
        )
        Notifications.Bus.notify(notification, project)
    }

    /**
     * 显示配置验证成功通知
     */
    fun showValidationSuccess(workspace: ValkyrieWorkspace) {
        val notification = Notification(
            NOTIFICATION_GROUP,
            "配置验证通过",
            "工作空间 '${workspace.name}' 配置有效",
            NotificationType.INFORMATION
        )
        Notifications.Bus.notify(notification, project)
    }

    /**
     * 显示导入/重命名建议
     */
    fun showImportSuggestion(
        currentFile: VirtualFile,
        missingSymbol: String,
        availablePackages: List<String>
    ) {
        val suggestions = availablePackages.take(3).joinToString(", ")
        val notification = Notification(
            NOTIFICATION_GROUP,
            "未找到符号 '$missingSymbol'",
            "可能需要导入包: $suggestions<br>使用语法: using package::$missingSymbol",
            NotificationType.INFORMATION
        )
        Notifications.Bus.notify(notification, project)
    }

    /**
     * 显示版本兼容性警告
     */
    fun showVersionCompatibilityWarning(
        packageName: String,
        requiredVersion: String,
        actualVersion: String?
    ) {
        val message = if (actualVersion != null) {
            "包 '$packageName' 版本不兼容: 需要 $requiredVersion，当前 $actualVersion"
        } else {
            "包 '$packageName' 版本不兼容: 需要 $requiredVersion，未找到版本信息"
        }

        val notification = Notification(
            NOTIFICATION_GROUP,
            "版本兼容性警告",
            message,
            NotificationType.WARNING
        )
        Notifications.Bus.notify(notification, project)
    }

    /**
     * 显示环境配置提示
     */
    fun showEnvironmentHint(message: String) {
        val notification = Notification(
            NOTIFICATION_GROUP,
            "环境配置提示",
            message,
            NotificationType.INFORMATION
        )
        Notifications.Bus.notify(notification, project)
    }
}