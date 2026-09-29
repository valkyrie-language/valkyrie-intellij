package valkyrie.psi.lexers

import com.intellij.psi.tree.IElementType
import com.intellij.lang.Language
import valkyrie.language.ValkyrieLanguage

/**
 * Valkyrie Token 类型定义
 */
class ValkyrieTokenType(debugName: String, language: Language = ValkyrieLanguage.INSTANCE) : IElementType(debugName, language) {
    override fun toString(): String = "ValkyrieToken." + super.toString()
}