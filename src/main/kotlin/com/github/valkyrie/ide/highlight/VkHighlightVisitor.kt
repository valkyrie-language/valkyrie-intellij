package com.github.valkyrie.ide.highlight


import com.github.valkyrie.ide.view.VkFile
import com.github.valkyrie.language.psi.*
import com.intellij.codeInsight.daemon.impl.HighlightInfo
import com.intellij.codeInsight.daemon.impl.HighlightInfoType
import com.intellij.codeInsight.daemon.impl.HighlightVisitor
import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.util.nextLeaf
import com.github.valkyrie.ide.highlight.VkHighlightColor as Color

class VkHighlightVisitor : FluentVisitor(), HighlightVisitor {
    private var infoHolder: HighlightInfoHolder? = null


    override fun visitTraitStatement(o: FluentTraitStatement) {
        //
        val head = o.firstChild;
        highlight(head, Color.SYM_TRAIT)
        //
//        val prop = head.nextLeaf { it.elementType == JssTypes.SYMBOL }!!
//        highlight(prop, FluentColor.SYM_SCHEMA)

        super.visitTraitStatement(o)
    }

    override fun visitClassStatement(o: FluentClassStatement) {
        //
        val head = o.firstChild;
        highlight(head, Color.SYM_CLASS)
        //
//        val prop = head.nextLeaf { it.elementType == JssTypes.SYMBOL }!!
//        highlight(prop, FluentColor.SYM_SCHEMA)

        super.visitClassStatement(o)
    }

//    override fun visitMessageID(o: FluentMessageID) {
//        highlight(o, SYM_MESSAGE)
//    }
//
//    override fun visitTermID(o: FluentTermID) {
//        highlight(o, SYM_TERM)
//    }
//
//    override fun visitAttributeID(o: FluentAttributeID) {
//        highlight(o, SYM_ATTRIBUTE)
//    }
//
//    override fun visitVariableID(o: FluentVariableID) {
//        highlight(o, SYM_VARIABLE)
//    }
//
//    override fun visitFunctionID(o: FluentFunctionID) {
//        highlight(o, SYM_FUNCTION)
//    }

//    override fun visitSchemaStatement(o: JssSchemaStatement) {
//        //
//        val head = o.firstChild;
//        highlight(head, FluentColor.KEYWORD)
//        //
//        val prop = head.nextLeaf { it.elementType == JssTypes.SYMBOL }!!
//        highlight(prop, FluentColor.SYM_SCHEMA)
//
//        super.visitSchemaStatement(o)
//    }


    private fun highlight(element: PsiElement, color: Color) {
        val builder = HighlightInfo.newHighlightInfo(HighlightInfoType.INFORMATION)
        builder.textAttributes(color.textAttributesKey)
        builder.range(element)

        infoHolder?.add(builder.create())
    }

    override fun analyze(
        file: PsiFile,
        updateWholeFile: Boolean,
        holder: HighlightInfoHolder,
        action: Runnable,
    ): Boolean {
        infoHolder = holder
        action.run()

        return true
    }

    override fun clone(): HighlightVisitor = VkHighlightVisitor()

    override fun suitableForFile(file: PsiFile): Boolean = file is VkFile

    override fun visit(element: PsiElement) = element.accept(this)
}