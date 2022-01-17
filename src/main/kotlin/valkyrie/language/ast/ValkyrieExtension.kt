package valkyrie.language.ast


import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.TokenType
import com.intellij.psi.util.parents
import org.antlr.intellij.adaptor.psi.ScopeNode


fun ASTNode?.isWhitespaceOrEmpty(): Boolean {
    return this == null || textLength == 0 || elementType == TokenType.WHITE_SPACE
}

fun PsiElement.findScopeContext(): ScopeNode? {
    for (parent in this.parents(false)) {
        if (parent is ScopeNode) {
            return parent
        }
    }
    return null;
}