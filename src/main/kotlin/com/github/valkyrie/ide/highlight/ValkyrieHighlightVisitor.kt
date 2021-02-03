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

    override fun visitPattern(o: ValkyriePattern) {
        o.modifiersList.forEach {
            highlightModifiers(it, Color.KEYWORD)
        }
        super.visitPattern(o)
    }

    override fun visitCasePattern(o: ValkyrieCasePattern) {
        // TODO: maybe variant
        o.namespace.let {
            if (it != null) {
                highlight(it.lastChild, Color.SYM_CLASS)
            }
        }
        super.visitCasePattern(o)
    }

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
        highlight(o.symbol, Color.SYM_VARIANT);
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


    private fun highlightModifiers(o: ValkyrieModifiers, last: Color) {
        val tail = o.lastChild;
        highlight(tail, last);
        var node = tail.prevSibling;
        while (node != null) {
            when (node) {
                is ValkyrieNamespace -> {
                    highlight(node.lastChild, Color.KEYWORD);
                }
                else -> {}
            }
            node = node.prevSibling;
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