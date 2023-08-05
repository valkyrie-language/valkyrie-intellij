package valkyrie.lsp

import com.intellij.platform.lsp.api.LspServerListener
import org.eclipse.lsp4j.InitializeResult

class VspListener : LspServerListener {
    override fun serverInitialized(params: InitializeResult) {
        super.serverInitialized(params)
    }
}