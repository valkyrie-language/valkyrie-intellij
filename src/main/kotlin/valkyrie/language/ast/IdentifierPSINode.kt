package valkyrie.language.ast;

import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.PsiReference
import com.intellij.psi.tree.IElementType
import org.antlr.intellij.adaptor.lexer.RuleIElementType
import org.antlr.intellij.adaptor.psi.ANTLRPsiLeafNode
import org.antlr.intellij.adaptor.psi.Trees
import org.jetbrains.annotations.NonNls
import valkyrie.language.ValkyrieLanguage
import valkyrie.language.lexer.ValkyrieParserDefinition.Companion.ID

class ValkyrieIdentifierAstNode(type: IElementType?, text: CharSequence?) : ANTLRPsiLeafNode(type, text), PsiNamedElement,
    NavigatablePsiElement {
    override fun getName(): String {
        return getText()
    }

    /** Alter this node to have text specified by the argument. Do this by
     * creating a new node through parsing of an ID and then doing a
     * replace.
     */
    override fun setName(name: @NonNls String): PsiElement {
        if (parent == null) return this // weird but it happened once
        /*
		IElementType elType = getParent().getNode().getElementType();
		String kind = "??? ";
		if ( elType instanceof RuleIElementType ) {
			int ruleIndex = ((RuleIElementType) elType).getRuleIndex();
			if ( ruleIndex == RULE_call_expr ) {
				kind = "call ";
			}
			else if ( ruleIndex == RULE_statement ) {
				kind = "assign ";
			}
			else if ( ruleIndex == RULE_function ) {
				kind = "func def ";
			}
		}
		System.out.println("IdentifierPSINode.setName("+name+") on "+
			                   kind+this+" at "+Integer.toHexString(this.hashCode()));
		*/
        val newID = Trees.createLeafFromText(
            getProject(),
            ValkyrieLanguage,
            context,
            name,
            ID
        )
        return if (newID != null) {
            this.replace(newID) // use replace on leaves but replaceChild on ID nodes that are part of defs/decls.
        } else this
    }

    /** Create and return a PsiReference object associated with this ID
     * node. The reference object will be asked to resolve this ref
     * by using the text of this node to identify the appropriate definition
     * site. The definition site is typically a subtree for a function
     * or variable definition whereas this reference is just to this ID
     * leaf node.
     *
     * As the AST factory has no context and cannot create different kinds
     * of PsiNamedElement nodes according to context, every ID node
     * in the tree will be of this type. So, we distinguish references
     * from definitions or other uses by looking at context in this method
     * as we have parent (context) information.
     */
    override fun getReference(): PsiReference? {
        val parent = parent
        val elType = parent.node.elementType
        // do not return a reference for the ID nodes in a definition
        if (elType is RuleIElementType) {
//            switch ( ((RuleIElementType) elType).getRuleIndex() ) {
//                case RULE_statement :
//                case RULE_expr :
//                case RULE_primary :
//                    return new VariableRef(this);
//                case RULE_call_expr :
//                    return new FunctionRef(this);
//            }
        }
        return null
    }
}