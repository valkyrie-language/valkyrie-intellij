package vos.intellij.ide.highlight

import com.intellij.codeInsight.daemon.impl.HighlightInfo
import com.intellij.codeInsight.daemon.impl.HighlightInfoType
import com.intellij.codeInsight.daemon.impl.HighlightVisitor
import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.util.elementType
import com.intellij.psi.util.nextLeaf
import vos.intellij.language.file.VosFileNode
import vos.intellij.language.psi.*


class HighlightAST : VosVisitor(), HighlightVisitor {
    private var infoHolder: HighlightInfoHolder? = null

    override fun visitSchemaStatement(o: VosSchemaStatement) {
        //
        val head = o.firstChild;
        highlight(head, VosColor.KEYWORD)
        //
        val prop = head.nextLeaf { it.elementType == VosTypes.SYMBOL }!!
        highlight(prop, VosColor.SYM_SCHEMA)
    }

    override fun visitTypeSymbol(o: VosTypeSymbol) {
        val head = o.text.first();
        if (head.isLowerCase()) {
            highlight(o, VosColor.KEYWORD)
        }
        else {
            highlight(o, VosColor.SYM_CLASS)
        }
    }

    override fun visitAnnotation(o: VosAnnotation) {
        highlight(o, VosColor.SYM_ANNO)
    }

//    override fun visitDefStatement(o: VosDefStatement) {
//        //
//        val head = o.firstChild;
//        when (head.elementType) {
//            VosTypes.SYMBOL -> highlight(head, VosColor.KEYWORD)
//        }
//        //
//        val prop = head.nextLeaf { it.elementType == VosTypes.SYMBOL }!!
//        highlight(prop, VosColor.SYM_FIELD)
//    }

    override fun visitClassStatement(o: VosClassStatement) {
        val head = o.identifier.text.first();
        if (head.isLowerCase()) {
            highlight(o.identifier, VosColor.KEYWORD)
        }
        else {
            highlight(o.identifier, VosColor.SYM_CLASS)
        }
    }

    override fun visitClassField(o: VosClassField) {
        highlight(o.identifier, VosColor.SYM_FIELD)
    }

    override fun visitUnionStatement(o: VosUnionStatement) {
        highlight(o.identifier, VosColor.SYM_CLASS)
    }

    override fun visitUnionField(o: VosUnionField) {
        highlight(o.identifier, VosColor.SYM_FIELD)
    }


    override fun visitKvPair(o: VosKvPair) {
        highlight(o.firstChild, VosColor.SYM_FIELD)
    }

    override fun visitValue(o: VosValue) {
        val head = o.firstChild;
        when (head.elementType) {
            VosTypes.NULL -> highlight(head, VosColor.NULL)
            VosTypes.BOOLEAN -> highlight(head, VosColor.BOOLEAN)
            else -> super.visitValue(o)
        }
    }

    override fun visitModifiers(o: VosModifiers) {
        for (child in o.children) {
            highlight(child, VosColor.MODIFIER)
        }
    }


    private fun highlight(element: PsiElement, color: VosColor) {
        val builder = HighlightInfo.newHighlightInfo(HighlightInfoType.INFORMATION)
        builder.textAttributes(color.textAttributesKey)
        builder.range(element)

        infoHolder?.add(builder.create())
    }

    override fun analyze(
        file: PsiFile, updateWholeFile: Boolean, holder: HighlightInfoHolder, action: Runnable
    ): Boolean {
        infoHolder = holder
        action.run()

        return true
    }

    override fun clone(): HighlightVisitor = HighlightAST()

    override fun suitableForFile(file: PsiFile): Boolean = file is VosFileNode

    override fun visit(element: PsiElement) = element.accept(this)
}