package valkyrie.language.antlr


import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.TokenType
import com.intellij.psi.util.parents
import org.antlr.intellij.adaptor.lexer.RuleIElementType
import org.antlr.intellij.adaptor.psi.ScopeNode


fun ASTNode?.isWhitespaceOrEmpty(): Boolean {
    return this == null || textLength == 0 || elementType == TokenType.WHITE_SPACE
}

val PsiElement.parentScope: ScopeNode?
    get() {
        for (parent in this.parents(false)) {
            if (parent is ScopeNode) {
                return parent
            }
        }
        return null;
    }

fun ValkyrieParser.getChildOfType(psi: PsiElement, rule: Int): PsiElement? {
    this;
    for (child in psi.children) {
        val type = child.node.elementType as RuleIElementType;
        if (type.ruleIndex == rule) {
            return child;
        }
    }
    return null;
}