package com.github.valkyrie.ide.highlight


import com.github.valkyrie.ide.view.ValkyrieFile
import com.github.valkyrie.language.ast.hasModifier
import com.github.valkyrie.language.ast.isMutable
import com.github.valkyrie.language.psi.*
import com.intellij.codeInsight.daemon.impl.HighlightInfo
import com.intellij.codeInsight.daemon.impl.HighlightInfoType
import com.intellij.codeInsight.daemon.impl.HighlightVisitor
import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.util.elementType
import com.intellij.psi.util.nextLeaf
import com.github.valkyrie.ide.highlight.ValkyrieHighlightColor as Color

class ValkyrieHighlightVisitor : ValkyrieVisitor(), HighlightVisitor {
    private var infoHolder: HighlightInfoHolder? = null

    override fun visitAs(o: ValkyrieAs) {
        highlight(o, Color.KEYWORD)
    }

    override fun visitExportName(o: ValkyrieExportName) {
        if (o.text.startsWith('@') || o.text.startsWith('#')) {
            highlight(o, Color.SYM_MACRO)
        }
    }

    private fun visitCasePattern(o: ValkyrieCasePattern, mode: ValkyrieVariableHighlightMode, force_mut: Boolean) {
        o.namespace?.let {
            highlight(it.lastChild, Color.SYM_CLASS)
        }
        o.patternTuple?.let {
            this.visitPatternTuple(it, mode, force_mut)
        }
        super.visitCasePattern(o)
    }

    override fun visitCasePattern(o: ValkyrieCasePattern) {
        visitCasePattern(o, ValkyrieVariableHighlightMode.Local, false)
    }

    override fun visitPattern(o: ValkyriePattern) {
        val forceMut = o.modifiers.hasModifier("mut")
        o.modifiers?.let {
            highlight(it, Color.KEYWORD)
        }
        o.patternSequence?.let { out ->
            out.patternItemList.forEach {
                return this.visitPatternItem(it, ValkyrieVariableHighlightMode.Local, forceMut)
            }
        }
        o.patternTuple?.let { out ->
            out.patternItemList.forEach {
                return this.visitPatternItem(it, ValkyrieVariableHighlightMode.Local, forceMut)
            }
        }
        o.patternBracket?.let { out ->
            out.patternItemList.forEach {
                return this.visitPatternItem(it, ValkyrieVariableHighlightMode.Local, forceMut)
            }
        }
    }

    private fun visitPatternItem(o: ValkyriePatternItem, mode: ValkyrieVariableHighlightMode, force_mut: Boolean) {
        o.modifiers?.let {
            return highlightVariableWithModifiers(it, mode, force_mut)
        }
        o.patternRest?.let {
            return highlightPatternLastWithModifiers(it, mode, force_mut)
        }
    }

    private fun visitPatternTuple(o: ValkyriePatternTuple, mode: ValkyrieVariableHighlightMode, force_mut: Boolean) {
//        o.modifiersList.forEach {
//            highlightVariableWithModifiers(it, mode, force_mut)
//        }
        super.visitPatternTuple(o)
    }

    override fun visitTraitStatement(o: ValkyrieTraitStatement) {
        val head = o.firstChild
        val prop = head.nextLeaf { it.elementType == ValkyrieTypes.SYMBOL }!!
        highlight(prop, Color.SYM_TRAIT)
        super.visitTraitStatement(o)
    }

    override fun visitClassStatement(o: ValkyrieClassStatement) {
        val head = o.firstChild
        val prop = head.nextLeaf { it.elementType == ValkyrieTypes.SYMBOL }!!
        highlight(prop, Color.SYM_CLASS)
        super.visitClassStatement(o)
    }

    override fun visitBitflagStatement(o: ValkyrieBitflagStatement) {
        highlightModifiers(o.modifiers, Color.SYM_CLASS)
        super.visitBitflagStatement(o)
    }

    override fun visitBitflagItem(o: ValkyrieBitflagItem) {
        highlight(o.symbol, Color.SYM_VARIANT)
        super.visitBitflagItem(o)
    }

    override fun visitAutoDerive(o: ValkyrieAutoDerive) {
        o.namespaceList.forEach {
            highlight(it.lastChild, Color.SYM_TRAIT)
        }
        super.visitAutoDerive(o)
    }

    override fun visitNumber(o: ValkyrieNumber) {
        o.symbol?.let {
            highlight(it, Color.OP_NUMBER)
        }
    }

    override fun visitString(o: ValkyrieString) {
        o.symbol?.let {
            highlight(it, Color.OP_STRING)
        }
    }

    override fun visitBoolean(o: ValkyrieBoolean) {
        highlight(o, Color.KEYWORD)
    }

    // =================================================================================================================


    private fun highlightModifiers(o: ValkyrieModifiers, last_color: Color) {
        val tail = o.lastChild
        highlight(tail, last_color)
        var node = tail.prevSibling
        while (node != null) {
            highlight(node, Color.KEYWORD)
            node = node.prevSibling
        }
    }

    private fun highlightVariableWithModifiers(
        o: ValkyrieModifiers,
        mode: ValkyrieVariableHighlightMode,
        force_mut: Boolean = false,
    ) {
        val mut = o.isMutable(force_mut)
        val tail = o.lastChild
        var node = tail.prevSibling
        while (node != null) {
            highlight(node, Color.KEYWORD)
            node = node.prevSibling
        }
        mode.render(this, tail, mut)
    }

    private fun highlightPatternLastWithModifiers(
        o: ValkyriePatternRest,
        mode: ValkyrieVariableHighlightMode,
        force_mut: Boolean = false,
    ) {
        val mut = o.isMutable(force_mut)
        val tail = o.lastChild
        var node = tail.prevSibling
        while (node != null) {
            when (node.elementType) {
                ValkyrieTypes.SYMBOL -> highlight(node, Color.KEYWORD)
                else -> {}
            }
            node = node.prevSibling
        }
        mode.render(this, tail, mut)
    }

    fun highlight(element: PsiElement, color: Color) {
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