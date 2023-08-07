package valkyrie.lsp

import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.platform.lsp.api.LspServer
import com.intellij.platform.lsp.api.LspServerSupportProvider
import com.intellij.platform.lsp.api.LspServerSupportProvider.LspServerStarter
import com.intellij.platform.lsp.api.lsWidget.LspServerWidgetItem
import valkyrie.language.file.ValkyrieFileType
import valkyrie.language.file.ValkyrieIconProvider


class ValkyrieLanguageProtocol : LspServerSupportProvider {
    override fun fileOpened(project: Project, file: VirtualFile, serverStarter: LspServerStarter) {
        if (file.fileType is ValkyrieFileType) {
            serverStarter.ensureServerStarted(ValkyrieLanguageServerDescriptor(project))
        }
    }

    override fun createLspServerWidgetItem(lspServer: LspServer, currentFile: VirtualFile?): LspServerWidgetItem? {
        return LspServerWidgetItem(
            lspServer,
            currentFile,
            ValkyrieIconProvider.Instance.Valkyrie,
            ValkyrieLanguageServerConfiguration::class.java
        )
    }

}

