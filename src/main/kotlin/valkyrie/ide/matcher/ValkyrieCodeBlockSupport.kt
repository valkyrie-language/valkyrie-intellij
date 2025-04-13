package valkyrie.ide.matcher

import com.intellij.codeInsight.highlighting.AbstractCodeBlockSupportHandler
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet
import valkyrie.ast.DeclareClass
import valkyrie.ast.DeclareTrait
import valkyrie.ast.MixtureBody
import valkyrie.ast.ObjectBody
import valkyrie.cst.KW_IF
import valkyrie.cst.KW_TYPE

class ValkyrieCodeBlockSupport : AbstractCodeBlockSupportHandler() {
    override fun getTopLevelElementTypes(): TokenSet {
        return TokenSet.create(DeclareClass, DeclareTrait)
    }

    override fun getKeywordElementTypes(): TokenSet {
        return TokenSet.create(KW_IF, KW_TYPE)
    }

    override fun getBlockElementTypes(): TokenSet {
        return TokenSet.create(ObjectBody, MixtureBody)
    }

    override fun getDirectChildrenElementTypes(parentElementType: IElementType?): TokenSet {
        println("getDirectChildrenElementTypes: $parentElementType")
        return TokenSet.create()
    }

}