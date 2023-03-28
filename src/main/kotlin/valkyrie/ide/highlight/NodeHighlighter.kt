package valkyrie.ide.highlight


import com.intellij.codeInsight.daemon.impl.HighlightInfo
import com.intellij.codeInsight.daemon.impl.HighlightInfoType
import com.intellij.codeInsight.daemon.impl.HighlightVisitor
import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import valkyrie.language.file.YggdrasilFileNode
import yggdrasil.psi.node.*

class NodeHighlighter : ValkyrieVisitor(), HighlightVisitor {
    private var infoHolder: HighlightInfoHolder? = null


    override fun visitUsing(o: ValkyrieUsing) {
        o.identifierFree?.let { highlight(it, HighlightColor.SYM_MACRO) }
    }


    override fun visitModifier(o: ValkyrieModifier) {
        highlight(o.identifier, HighlightColor.KEYWORD)
    }


    override fun visitAttribute(o: ValkyrieAttribute) {
        o.highlight(this)
    }

    override fun visitClass(o: ValkyrieClass) {
        o.identifier?.let { highlight(it, HighlightColor.RULE_CLASS) }
    }

    override fun visitDefineUnion(o: ValkyrieDefineUnion) {
        o.identifier?.let { highlight(it, HighlightColor.RULE_UNION) }
    }

    override fun visitDefineFunction(o: ValkyrieDefineFunction) {
        o.identifierFree?.let { highlight(it, HighlightColor.SYM_FUNCTION) }
    }

    override fun visitGroupItem(o: ValkyrieGroupItem) {
        o.highlight(this)
    }

    override fun visitExpressionTag(o: ValkyrieExpressionTag) {
        o.identifierFree?.let { highlight(it, HighlightColor.TAG_NODE) }
    }

    override fun visitTagBranch(o: ValkyrieTagBranch) {
        highlight(o, HighlightColor.TAG_BRANCH)
    }

    override fun visitArgument(o: ValkyrieArgument) {
        o.identifierFree?.let { highlight(it, HighlightColor.SYM_FIELD) }
    }

    override fun visitPair(o: ValkyriePair) {
        highlight(o.key, HighlightColor.SYM_FIELD)
    }

    override fun visitFunctionCall(o: ValkyrieFunctionCall) {
        highlight(o.firstChild, HighlightColor.SYM_FUNCTION)
        highlight(o.identifierFree, HighlightColor.SYM_FUNCTION)
    }

    override fun visitAtomic(o: ValkyrieAtomic) {
        o.identifierFree?.highlight(this)
    }

    override fun visitCategory(o: ValkyrieCategory) {
        o.key?.let { highlight(it, HighlightColor.SYM_FIELD) }
        highlight(o.identifierFree, HighlightColor.SYM_CONSTANT)
    }

    override fun visitRange(o: ValkyrieRange) {
        highlight(o.firstChild, HighlightColor.OPERATION)
        highlight(o.lastChild, HighlightColor.OPERATION)
    }

    fun highlight(element: PsiElement, color: HighlightColor) {
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

    override fun suitableForFile(file: PsiFile): Boolean = file is YggdrasilFileNode

    override fun visit(element: PsiElement) = element.accept(this)
}