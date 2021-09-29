package valkyrie.ide.highlight


import com.intellij.codeInsight.daemon.impl.HighlightInfo
import com.intellij.codeInsight.daemon.impl.HighlightInfoType
import com.intellij.codeInsight.daemon.impl.HighlightVisitor
import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import valkyrie.ide.file.ValkyrieFileNode
import valkyrie.language.psi.*
import valkyrie.language.psi_node.*
import valkyrie.ide.highlight.ValkyrieHighlightColor as Color

class NodeHighlighter : ValkyrieVisitor(), HighlightVisitor {
    private var infoHolder: HighlightInfoHolder? = null

    override fun visitNamespaceStatement(o: ValkyrieNamespaceStatement) {

    }

    override fun visitImportItem(o: ValkyrieImportItem) {
        //TODO: get real symbol color
    }


    override fun visitTraitStatement(o: ValkyrieTraitStatement) {
        highlight(o.modified.lastChild, Color.SYM_TRAIT)
    }

    override fun visitNormalPattern(o: ValkyrieNormalPattern) {


    }

    override fun visitGenericDefine(o: ValkyrieGenericDefine) {

    }

    override fun visitDefineStatement(o: ValkyrieDefineStatement) {
        o as ValkyrieDefineStatementNode;
        highlight(o.nameIdentifier, o.kind.color)
    }

    override fun visitTypeStatement(o: ValkyrieTypeStatement) {
        highlight(o.genericType.identifier, Color.SYM_CLASS)
    }

    override fun visitClassStatement(o: ValkyrieClassStatement) {
        o as ValkyrieClassStatementNode
        highlight(o.modified.lastChild, Color.SYM_CLASS)
    }

    override fun visitClassMethod(o: ValkyrieClassMethod) {
        o as ValkyrieClassMethodNode;
        highlight(o.nameIdentifier, Color.SYM_FUNCTION_SELF)
    }


    override fun visitUnionStatement(o: ValkyrieUnionStatement) {
        o as ValkyrieUnionStatementNode
        highlight(o.modified.lastChild, Color.SYM_CLASS)
    }

    override fun visitUnionItem(o: ValkyrieUnionItem) {
        highlight(o.identifier, Color.SYM_VARIANT)
    }

    override fun visitDefineItem(o: ValkyrieDefineItem) {
        val id = o.identifier;
        when {
            id == null -> return
            id.text == "self" -> highlight(id, Color.KEYWORD)
            else -> highlight(o.identifier, Color.SYM_FIELD)
        }
    }


    override fun visitForallStatement(o: ValkyrieForallStatement) {
//        o.identifierList.forEach {
//            highlight(it, Color.SYM_GENERIC)
//        }
//        super.visitForallStatement(o)
    }


    override fun visitExtendsStatement(o: ValkyrieExtendsStatement) {
        o as ValkyrieExtendsStatementNode
        highlight(o.identifier, Color.SYM_CLASS)
    }


    override fun visitBitflagStatement(o: ValkyrieBitflagStatement) {
        highlight(o.identifier, Color.SYM_CLASS)
    }

    override fun visitBitflagItem(o: ValkyrieBitflagItem) {
        highlight(o.identifier, Color.SYM_VARIANT)
    }

    override fun visitMacroCall(o: ValkyrieMacroCall) {
        highlight(o.namepathFree, Color.SYM_MACRO)
    }

    override fun visitMacroList(o: ValkyrieMacroList) {
        for (i in o.namepathFreeList) {
            for (j in i.identifierList) {
                highlight(j, Color.SYM_MACRO)
            }
        }
    }

    override fun visitModifiers(o: ValkyrieModifiers) {
        o.identifierList.forEach {
            highlight(it, Color.MODIFIER)
        }
    }


    override fun visitElseStatement(o: ValkyrieElseStatement) {
        highlight(o.firstChild, Color.KEYWORD)
    }

    override fun visitJumpLabel(o: ValkyrieJumpLabel) {
        highlight(o.identifier, Color.SYM_MACRO)
    }


    override fun visitIdentifier(o: ValkyrieIdentifier) {
        // TODO: real syntax resolve
    }

    override fun visitObjectKey(o: ValkyrieObjectKey) {
        when (o.text) {
            "get", "set" -> {
                highlight(o, Color.KEYWORD)
                return
            }
        }

        if (!o.text.first().isDigit()) {
            highlight(o, Color.SYM_FIELD)
        }
    }


    override fun visitNumber(o: ValkyrieNumber) {
        // lexer color
    }

    override fun visitString(o: ValkyrieString) {
        o.identifier?.let {
            highlight(it, Color.OP_STRING)
        }
    }

    override fun visitBoolean(o: ValkyrieBoolean) {
        highlight(o, Color.KEYWORD)
    }

    // =================================================================================================================

    private fun highlightSymbolList(
        symbols: List<ValkyrieIdentifier>,
        last: Color,
        rest: Color = Color.KEYWORD,
    ) {
        var first = true;
        for (symbol in symbols.reversed()) {
            if (first) {
                first = false
                highlight(symbol, last)
            } else {
                highlight(symbol, rest)
            }
        }
    }

    fun highlight(element: PsiElement?, color: Color) {
        if (element == null) return
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

    override fun clone(): HighlightVisitor = NodeHighlighter()

    override fun suitableForFile(file: PsiFile): Boolean = file is ValkyrieFileNode

    override fun visit(element: PsiElement) = element.accept(this)
}
