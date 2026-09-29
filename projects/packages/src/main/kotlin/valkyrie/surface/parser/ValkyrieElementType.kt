package valkyrie.surface.parser

import com.intellij.psi.tree.IElementType
import com.intellij.lang.Language
import valkyrie.surface.file.ValkyrieLanguage

/**
 * Valkyrie PSI 元素类型
 */
class ValkyrieElementType(debugName: String, language: Language = ValkyrieLanguage.INSTANCE) : IElementType(debugName, language) {
    override fun toString(): String = "ValkyrieElement." + super.toString()
}

