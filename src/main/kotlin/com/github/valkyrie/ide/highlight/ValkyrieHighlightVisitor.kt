package com.github.valkyrie.ide.highlight


import com.github.valkyrie.ide.view.ValkyrieFile
import com.github.valkyrie.language.psi.*
import com.intellij.codeInsight.daemon.impl.HighlightInfo
import com.intellij.codeInsight.daemon.impl.HighlightInfoType
import com.intellij.codeInsight.daemon.impl.HighlightVisitor
import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.util.elementType
import com.intellij.psi.util.nextLeaf
import com.intellij.psi.util.prevLeaf
import com.github.valkyrie.ide.highlight.ValkyrieHighlightColor as Color

class ValkyrieHighlightVisitor : ValkyrieVisitor(), HighlightVisitor {
    private var infoHolder: HighlightInfoHolder? = null


    override fun visitTraitStatement(o: ValkyrieTraitStatement) {
        val head = o.firstChild;
        val prop = head.nextLeaf { it.elementType == ValkyrieTypes.SYMBOL }!!
        highlight(prop, Color.SYM_TRAIT)

        super.visitTraitStatement(o)
    }

    override fun visitClassStatement(o: ValkyrieClassStatement) {
        val head = o.firstChild;
        val prop = head.nextLeaf { it.elementType == ValkyrieTypes.SYMBOL }!!
        highlight(prop, Color.SYM_CLASS)

        super.visitClassStatement(o)
    }

    override fun visitBitflagStatement(o: ValkyrieBitflagStatement) {
        highlightModifiers(o.modifiers, Color.SYM_CLASS);

        super.visitBitflagStatement(o)
    }

    override fun visitBitflagItem(o: ValkyrieBitflagItem) {
        super.visitBitflagItem(o)
    }

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
    private fun highlightModifiers(o: ValkyrieModifiers, last: Color) {
        val tail = o.lastChild;
        highlight(tail, last);
        var cur = tail.prevLeaf();
        while (cur != null) {
            highlight(cur, Color.KEYWORD);
            cur = cur.prevLeaf();
        }
    }

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

    override fun clone(): HighlightVisitor = ValkyrieHighlightVisitor()

    override fun suitableForFile(file: PsiFile): Boolean = file is ValkyrieFile

    override fun visit(element: PsiElement) = element.accept(this)
}