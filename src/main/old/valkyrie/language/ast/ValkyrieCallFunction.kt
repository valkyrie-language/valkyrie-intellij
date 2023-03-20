package valkyrie.language.ast

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.psi.impl.source.tree.CompositeElement
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.refactoring.suggested.startOffset
import valkyrie.ide.hint.ParameterInlayHint
import valkyrie.language.antlr.ValkyrieAntlrParser
import valkyrie.language.antlr.ValkyrieParser
import valkyrie.language.psi.ValkyrieInlayElement

class ValkyrieCallFunction(node: CompositeElement) : ASTWrapperPsiElement(node), ValkyrieInlayElement {

    override fun parameter_hint(inlay: ParameterInlayHint): Boolean {
        val body = ValkyrieParser.getChildOfType(this, ValkyrieAntlrParser.RULE_tuple_call_body);
        val items = PsiTreeUtil.getChildrenOfTypeAsList(body, ValkyrieCallArgument::class.java)
        var id = 0;
        for (item in items) {
            val key = item.getNameIdentifier();
            if (key == null) {
                inlay.inline(item.startOffset, "${'a' + id}: ")
            }
            id += 1
        }
        return true
    }
}