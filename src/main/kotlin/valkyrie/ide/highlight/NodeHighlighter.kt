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

    override fun visitAttribute(o: ValkyrieAttribute) {
        o.highlight(this)
    }

    override fun visitDeclareClass(o: ValkyrieDeclareClass) {
        o.highlight(this)
    }

    override fun visitDeclareField(o: ValkyrieDeclareField) {
        o.highlight(this)
    }

    override fun visitDeclareUnion(o: ValkyrieDeclareUnion) {
        o.highlight(this)
    }

    override fun visitDeclareFlags(o: ValkyrieDeclareFlags) {
        o.highlight(this)
    }

    override fun visitDeclareEnumerate(o: ValkyrieDeclareEnumerate) {
        o.highlight(this)
    }

    override fun visitDeclareSemantic(o: ValkyrieDeclareSemantic) {
        o.highlight(this)
    }

    override fun visitDeclareUnite(o: ValkyrieDeclareUnite) {
        o.highlight(this)
    }

    override fun visitDeclareFunction(o: ValkyrieDeclareFunction) {
        o.highlight(this)
    }


    override fun visitArgument(o: ValkyrieArgument) {
        o.identifierFree?.let { highlight(it, HighlightColor.SYM_FIELD) }
    }

    override fun visitPair(o: ValkyriePair) {
        highlight(o.key, HighlightColor.SYM_FIELD)
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