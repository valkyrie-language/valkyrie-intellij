package valkyrie.ide.matcher

import com.intellij.codeInsight.highlighting.AbstractCodeBlockSupportHandler
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet
import valkyrie.psi.ValkyrieTypes

class ValkyrieCodeBlockSupport : AbstractCodeBlockSupportHandler() {
    override fun getTopLevelElementTypes(): TokenSet {
        return TokenSet.create(ValkyrieTypes.DECLARE_CLASS, ValkyrieTypes.DECLARE_TRAIT)
    }

    override fun getKeywordElementTypes(): TokenSet {
        return TokenSet.create(ValkyrieTypes.KW_IF, ValkyrieTypes.KW_TYPE)
    }

    override fun getBlockElementTypes(): TokenSet {
        return TokenSet.create(ValkyrieTypes.BLOCK_BODY)
    }

    override fun getDirectChildrenElementTypes(parentElementType: IElementType?): TokenSet {
        println("getDirectChildrenElementTypes: $parentElementType")
        return TokenSet.create()
    }

}