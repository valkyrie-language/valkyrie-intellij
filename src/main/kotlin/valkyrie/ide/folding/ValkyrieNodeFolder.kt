package valkyrie.ide.folding

import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.refactoring.suggested.endOffset
import com.intellij.refactoring.suggested.startOffset
import valkyrie.language.antlr.childrenWithLeaves


class ValkyrieNodeFolder {

    private val descriptors: MutableList<FoldingDescriptor>

    constructor(descriptors: MutableList<FoldingDescriptor>) : super() {
        this.descriptors = descriptors
    }

    fun fold(node: PsiElement, range: TextRange) {
        fold(node, range.startOffset, range.endOffset)
    }

    fun fold(node: PsiElement, start: Int, end: Int) {
        if (end > start) {
            descriptors += FoldingDescriptor(node, TextRange(start, end))
        }
    }

    fun findBrace(element: PsiElement): TextRange {
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
}


