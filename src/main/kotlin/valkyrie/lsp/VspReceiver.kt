package valkyrie.lsp

import com.intellij.platform.lsp.api.Lsp4jClient
import com.intellij.platform.lsp.api.LspServerNotificationsHandler

class VspReceiver(handler: LspServerNotificationsHandler) : Lsp4jClient(handler) {

}