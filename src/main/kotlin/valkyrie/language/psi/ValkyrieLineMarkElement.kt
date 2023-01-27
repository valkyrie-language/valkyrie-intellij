package valkyrie.language.psi

import com.intellij.codeInsight.daemon.LineMarkerInfo

interface ValkyrieLineMarkElement {
    public fun getLineMark(): LineMarkerInfo<*>
}