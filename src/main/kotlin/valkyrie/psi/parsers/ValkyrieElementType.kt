package valkyrie.psi

import com.intellij.psi.tree.IElementType
import valkyrie.language.dialect_std.ValkyrieLanguage

/**
 * Valkyrie PSI 元素类型
 */
class ValkyrieElementType(debugName: String) : IElementType(debugName, ValkyrieLanguage) {
    override fun toString(): String = "ValkyrieElementType." + super.toString()
}

