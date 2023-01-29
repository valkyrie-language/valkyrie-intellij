package valkyrie.language.psi

import com.intellij.codeInsight.daemon.LineMarkerInfo

interface ValkyrieLineMarkElement {
    @Suppress("FunctionName")
    fun getLineMark(): LineMarkerInfo<*>
}