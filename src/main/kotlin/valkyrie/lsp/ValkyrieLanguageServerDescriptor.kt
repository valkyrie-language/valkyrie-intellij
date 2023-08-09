package valkyrie.lsp

import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.platform.lsp.api.ProjectWideLspServerDescriptor
import valkyrie.language.file.ValkyrieFileType

class ValkyrieLanguageServerDescriptor : ProjectWideLspServerDescriptor {
    override val lspServerListener = VspListener()
    override val lspCodeActionsSupport = VspCodeActionAdaptor()
    override val lspDiagnosticsSupport = VspDiagnosticsAdaptor()
    override val lspCompletionSupport = VspCompletionAdaptor()

    constructor(project: Project) : super(project, "Valkyrie LSP")

    override fun isSupportedFile(file: VirtualFile): Boolean {
        return file.fileType is ValkyrieFileType
    }

    override fun createCommandLine(): GeneralCommandLine {
        return GeneralCommandLine("valkyrie-lsp")
    }
}

