package valkyrie.lsp

import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.platform.lsp.api.Lsp4jClient
import com.intellij.platform.lsp.api.LspServerNotificationsHandler
import com.intellij.platform.lsp.api.ProjectWideLspServerDescriptor
import valkyrie.language.file.ValkyrieFileType

class ValkyrieLanguageServerDescriptor(project: Project) : ProjectWideLspServerDescriptor(project, "Valkyrie LSP") {
    override val lspHoverSupport = true

    override val lspServerListener = VspListener()
    override val lspCodeActionsSupport = VspCodeActionAdaptor()

    override fun isSupportedFile(file: VirtualFile): Boolean {
        return file.fileType is ValkyrieFileType
    }

    override fun createCommandLine(): GeneralCommandLine {
        return GeneralCommandLine("valkyrie-lsp")
    }
}

