package valkyrie.psi.parsers

import com.intellij.psi.tree.IElementType
import com.intellij.lang.Language
import valkyrie.language.ValkyrieLanguage

/**
 * Valkyrie PSI 元素类型
 */
class ValkyrieElementType(debugName: String, language: Language = ValkyrieLanguage.INSTANCE) : IElementType(debugName, language) {
    override fun toString(): String = "ValkyrieElement." + super.toString()
}

