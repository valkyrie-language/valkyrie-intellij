package valkyrie.ide.gutter

import com.intellij.codeInsight.daemon.GutterMark
import com.intellij.openapi.editor.GutterMarkPreprocessor

class ValkyrieGutterMarkPreprocessor : GutterMarkPreprocessor {
    override fun processMarkers(list: MutableList<GutterMark>): MutableList<GutterMark> {
        return list
    }
}
