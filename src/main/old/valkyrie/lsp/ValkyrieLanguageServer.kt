//package valkyrie.lsp
//
//import com.intellij.execution.configurations.GeneralCommandLine
//import com.intellij.openapi.project.Project
//import com.intellij.openapi.vfs.VirtualFile
//import com.intellij.platform.lsp.api.ProjectWideLspServerDescriptor
//import com.intellij.platform.lsp.api.customization.LspDiagnosticsSupport
//import valkyrie.language.ValkyrieLanguage
//import valkyrie.language.file.ValkyrieFileType
//
//
//@Suppress("UnstableApiUsage")
//class ValkyrieLanguageServer(project: Project) : ProjectWideLspServerDescriptor(project, ValkyrieLanguage.id) {
//
//    override fun isSupportedFile(file: VirtualFile) = file.fileType == ValkyrieFileType
//
//    override fun createCommandLine(): GeneralCommandLine {
//        return GeneralCommandLine().apply {
//            withParentEnvironmentType(GeneralCommandLine.ParentEnvironmentType.CONSOLE)
//            withCharset(Charsets.UTF_8)
//            addParameter("lsp.path")
//            addParameter("--stdio")
//        }
//    }
//
//
//    override val lspDiagnosticsSupport: LspDiagnosticsSupport = ValkyrieDiagnosticsProvider()
//
//
//
//    override val lspHoverSupport: Boolean = super.lspHoverSupport
//}
//
