package valkyrie.ide.completion

import com.intellij.openapi.editor.CustomFileDropHandler
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import java.awt.datatransfer.Transferable

class ValkyrieFileDropHandler : CustomFileDropHandler() {
    override fun canHandle(t: Transferable, editor: Editor?): Boolean {
        // TODO: Auto add @include_bytes(path)
        return false
    }

    override fun handleDrop(t: Transferable, editor: Editor?, project: Project?): Boolean {
        println("canHandle: $t")
        return false
    }

}

