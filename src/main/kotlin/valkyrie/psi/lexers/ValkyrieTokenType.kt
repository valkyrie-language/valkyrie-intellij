package valkyrie.psi.lexers

import com.intellij.psi.tree.IElementType
import valkyrie.language.dialect_std.ValkyrieLanguage

/**
 * Valkyrie Token 类型定义
 */
class ValkyrieTokenType(debugName: String) : IElementType(debugName, ValkyrieLanguage) {
    override fun toString(): String = "ValkyrieTokenType." + super.toString()
}

