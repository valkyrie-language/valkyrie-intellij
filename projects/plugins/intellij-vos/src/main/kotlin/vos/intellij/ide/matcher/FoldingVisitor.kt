package vos.intellij.ide.matcher


import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.refactoring.suggested.endOffset
import com.intellij.refactoring.suggested.startOffset
import vos.intellij.language.psi.*

class FoldingVisitor(private val descriptors: MutableList<FoldingDescriptor>) : VosRecursiveVisitor() {

//    override fun visitSchemaStatement(o: JssSchemaStatement) {
//        val block = o.childOfType<Br>()!!
//        fold(block)
//        super.visitSchemaStatement(o)
//    }

    override fun visitBraceBlock(o: VosBraceBlock) {
        fold(o)
//        super.visitBraceBlock(o)
    }

    override fun visitBracketBlock(o: VosBracketBlock) {
        fold(o)
//        super.visitBracketBlock(o)
    }

    override fun visitClassBlock(o: VosClassBlock) {
        val field = o.classFieldList.count()
        val placeholder = if (field > 1) {
            "$field fields"
        }
        else {
            "$field field"
        }
        fold(o, o.firstChild.endOffset, o.lastChild.startOffset, placeholder)
    }

    override fun visitUnionBlock(o: VosUnionBlock) {
        val variant = o.unionInnerList.count { it.unionField != null }
        val placeholder = if (variant > 1) {
            "$variant variants"
        }
        else {
            "$variant variant"
        }
        fold(o, o.firstChild.endOffset, o.lastChild.startOffset, placeholder)
    }

    private fun fold(element: PsiElement, placeholder: String = "...", collapse: Boolean = false) {
        descriptors += FoldingDescriptor(element.node, element.textRange, null, setOf(), false, placeholder, collapse)
    }

    private fun fold(
        element: PsiElement, start: Int, end: Int, placeholder: String = "...", collapse: Boolean = false
    ) {
        if (end < start) return
        descriptors += FoldingDescriptor(
            element.node, TextRange.create(start, end), null, setOf(), false, placeholder, collapse
        )
    }
}
