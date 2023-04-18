package valkyrie.ide.highlight


import com.intellij.codeInsight.daemon.impl.HighlightInfo
import com.intellij.codeInsight.daemon.impl.HighlightInfoType
import com.intellij.codeInsight.daemon.impl.HighlightVisitor
import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import valkyrie.language.file.ValkyrieFileNode
import valkyrie.psi.node.*

class NodeHighlighter : ValkyrieVisitor(), HighlightVisitor {
    private var infoHolder: HighlightInfoHolder? = null


    override fun visitAttribute(o: ValkyrieAttribute) {
        o as ValkyrieAttributeNode
        highlight(o.firstChild, HighlightColor.SYM_MACRO)
        for (id in o.identifiers) {
            highlight(id, HighlightColor.SYM_MACRO)
        }
    }

    override fun visitModifier(o: ValkyrieModifier) {
        highlight(o.identifier, HighlightColor.KEYWORD)
    }

    override fun visitDeclareClass(o: ValkyrieDeclareClass) {
        o as ValkyrieDeclareClassNode
        highlight(o.identifierFree, HighlightColor.SYM_CLASS)
        o.typeHint?.typeExpression?.highlight_trait(this)
    }

    override fun visitClassInherit(o: ValkyrieClassInherit) {
        highlight(o.identifierFree, HighlightColor.SYM_FIELD)
        o.typeExpression.highlight_class(this)
    }


    override fun visitDeclareField(o: ValkyrieDeclareField) {
        o as ValkyrieDeclareFieldNode
        highlight(o.nameIdentifier, HighlightColor.SYM_FIELD)
        o.typeHint?.typeExpression?.highlight_class(this)
    }

    override fun visitDeclareMethod(o: ValkyrieDeclareMethod) {
        o as ValkyrieDeclareMethodNode
        highlight(o.nameIdentifier, HighlightColor.SYM_FUNCTION_FREE)
    }

    override fun visitDeclareUnion(o: ValkyrieDeclareUnion) {
        o as ValkyrieDeclareUnionNode
        highlight(o.nameIdentifier, HighlightColor.SYM_MACRO)
    }

    override fun visitDeclareFlags(o: ValkyrieDeclareFlags) {
        o as ValkyrieDeclareFlagsNode
        highlight(o.nameIdentifier, HighlightColor.SYM_CONSTANT)
    }

    override fun visitDeclareEnumerate(o: ValkyrieDeclareEnumerate) {
        o as ValkyrieDeclareEnumerateNode
        highlight(o.nameIdentifier, HighlightColor.SYM_CONSTANT)
    }

    override fun visitDeclareSemantic(o: ValkyrieDeclareSemantic) {
        o as ValkyrieDeclareSemanticNode
        highlight(o.nameIdentifier, HighlightColor.SYM_FIELD)
    }

    override fun visitDeclareUnite(o: ValkyrieDeclareUnite) {
        o as ValkyrieDeclareUniteNode
        highlight(o.nameIdentifier, HighlightColor.SYM_MACRO)
    }

    override fun visitTraitAlias(o: ValkyrieTraitAlias) {
        o as ValkyrieTraitAliasNode
        highlight(o.nameIdentifier, HighlightColor.SYM_TRAIT)
        o.typeExpression?.highlight_trait(this)
    }

    override fun visitDeclareTrait(o: ValkyrieDeclareTrait) {
        o as ValkyrieDeclareTraitNode
        highlight(o.nameIdentifier, HighlightColor.SYM_TRAIT)
    }

    override fun visitDeclareFunction(o: ValkyrieDeclareFunction) {
        o as ValkyrieDeclareFunctionNode
        highlight(o.nameIdentifier, HighlightColor.SYM_FUNCTION_FREE)
    }


    override fun visitDeclareVariable(o: ValkyrieDeclareVariable) {
        super.visitDeclareVariable(o)
    }

    override fun visitGenericParameter(o: ValkyrieGenericParameter) {
        o as ValkyrieGenericParameterNode
        highlight(o.identifierFree, HighlightColor.SYM_MACRO)
        o.typeHint?.typeExpression?.highlight_trait(this)
    }

    override fun visitGenericArgument(o: ValkyrieGenericArgument) {
        highlight(o.identifierFree, HighlightColor.SYM_CLASS)
        o.typeExpression.highlight_class(this)
    }


    override fun visitDefaultType(o: ValkyrieDefaultType) {
        o.typeExpression.highlight_class(this)
    }

    override fun visitReturnType(o: ValkyrieReturnType) {
        o.typeExpression.highlight_class(this)
    }

    override fun visitArgument(o: ValkyrieArgument) {
        highlight(o.identifierFree, HighlightColor.SYM_ARG)
    }

    override fun visitFunctionCall(o: ValkyrieFunctionCall) {
        o.namepath.highlight_fake(this)
    }

    override fun visitPatternAtomic(o: ValkyriePatternAtomic) {
        highlight(o.identifierFree, HighlightColor.SYM_ARG)
    }


    fun highlight(element: PsiElement?, color: HighlightColor) {
        element ?: return
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