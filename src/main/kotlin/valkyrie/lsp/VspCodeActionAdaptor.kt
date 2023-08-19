package valkyrie.lsp

import com.intellij.platform.lsp.api.LspServer
import com.intellij.platform.lsp.api.customization.LspCodeActionsSupport
import com.intellij.platform.lsp.api.customization.LspIntentionAction
import org.eclipse.lsp4j.CodeAction

class VspCodeActionAdaptor : LspCodeActionsSupport() {
    override fun createIntentionAction(lspServer: LspServer, codeAction: CodeAction): LspIntentionAction? {
        return super.createIntentionAction(lspServer, codeAction)
    }

    override fun createQuickFix(lspServer: LspServer, codeAction: CodeAction): LspIntentionAction? {
        return super.createQuickFix(lspServer, codeAction)
    }
}
