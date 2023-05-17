package valkyrie.lsp

import com.intellij.ide.ApplicationInitializedListener
import kotlinx.coroutines.CoroutineScope


class ValkyrieLspRegister : ApplicationInitializedListener {
    override suspend fun execute(asyncScope: CoroutineScope) {
//        IntellijLanguageClient.addServerDefinition(RawCommandServerDefinition("valkyrie-lsp", arrayOf("path/to/launcher-script.sh")))
    }
}