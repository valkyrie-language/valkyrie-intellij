package valkyrie.lsp

import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.platform.lang.lsWidget.LanguageServiceWidgetItem
import com.intellij.platform.lsp.api.LspServer
import com.intellij.platform.lsp.api.LspServerSupportProvider
import com.intellij.platform.lsp.api.LspServerSupportProvider.LspServerStarter
import com.intellij.platform.lsp.api.lsWidget.LspServerWidgetItem


class ValkyrieLanguageProtocol : LspServerSupportProvider {
    override fun fileOpened(project: Project, file: VirtualFile, serverStarter: LspServerStarter) {

    }

    override fun createLspServerWidgetItem(lspServer: LspServer, currentFile: VirtualFile?): LspServerWidgetItem? {
        return super.createLspServerWidgetItem(lspServer, currentFile)
    }

    override fun createLspWidgetItems(project: Project, currentFile: VirtualFile?): List<LanguageServiceWidgetItem> {
        return super.createLspWidgetItems(project, currentFile)
    }
}
