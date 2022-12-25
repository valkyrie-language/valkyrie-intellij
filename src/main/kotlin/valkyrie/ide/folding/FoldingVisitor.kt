package valkyrie.ide.folding

import com.intellij.lang.ASTNode
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.refactoring.suggested.endOffset
import com.intellij.refactoring.suggested.startOffset
import valkyrie.language.ast.ValkyrieClassStatement
import valkyrie.language.ast.ValkyrieFlagsStatement
import valkyrie.language.ast.ValkyrieFunctionStatement
import valkyrie.language.ast.ValkyrieTraitStatement
import valkyrie.language.psi.ValkyrieVisitor
import valkyrie.language.antlr.childrenWithLeaves

class FoldingVisitor(private val descriptors: MutableList<FoldingDescriptor>) : ValkyrieVisitor() {

    override fun visitClassDeclaration(o: ValkyrieClassStatement) {
        fold(o.node, findBrace(o))
    }

    override fun visitTraitDeclaration(o: ValkyrieTraitStatement) {
        fold(o.node, findBrace(o))
    }

    override fun visitFlagsDeclaration(o: ValkyrieFlagsStatement) {
        fold(o.node, findBrace(o))
    }

    override fun visitFunctionDeclaration(o: ValkyrieFunctionStatement) {
        fold(o.node, findBrace(o))
    }

    private fun fold(node: ASTNode, range: TextRange) {
        fold(node, range.startOffset, range.endOffset)
    }

    private fun fold(node: ASTNode, start: Int, end: Int) {
        if (end > start) {
            descriptors += FoldingDescriptor(node, TextRange(start, end))
        }
    }
}

private fun findBrace(element: PsiElement): TextRange {
    var start = element.startOffset;
    var end = element.endOffset;
    for (leaf in element.childrenWithLeaves) {
        if (leaf.text == "{") {
            start = leaf.endOffset;
            continue
        }
        if (leaf.text == "}") {
            end = leaf.startOffset;
            break
        }
    }
    return TextRange(start, end)
}


