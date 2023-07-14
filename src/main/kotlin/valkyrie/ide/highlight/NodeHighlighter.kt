package valkyrie.ide.highlight


import com.intellij.codeInsight.daemon.impl.HighlightInfo
import com.intellij.codeInsight.daemon.impl.HighlightInfoType
import com.intellij.codeInsight.daemon.impl.HighlightVisitor
import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.util.elementType
import valkyrie.language.file.ValkyrieFileNode
import valkyrie.psi.ValkyrieTypes
import valkyrie.psi.childrenWithLeaves
import valkyrie.psi.mixin.getHighlightColor
import valkyrie.psi.mixin.highlight
import valkyrie.psi.node.*


class NodeHighlighter : ValkyrieVisitor(), HighlightVisitor {
    private var infoHolder: HighlightInfoHolder? = null

    override fun visitAttributeBelow(o: ValkyrieAttributeBelow) {
        highlight(o.firstChild, HighlightColor.SYM_MACRO)
    }

    override fun visitAttributeAbove(o: ValkyrieAttributeAbove) {
        highlight(o.firstChild, HighlightColor.SYM_MACRO)
    }


    override fun visitAttributeItem(o: ValkyrieAttributeItem) {
        highlight(o.namepath, HighlightColor.SYM_MACRO)
    }

    override fun visitModifier(o: ValkyrieModifier) {
        highlight(o, HighlightColor.KEYWORD)
    }

    override fun visitDeclareClass(o: ValkyrieDeclareClass) {
        highlight(o.identifier, HighlightColor.SYM_CLASS)
    }

    override fun visitDeclareComponent(o: ValkyrieDeclareComponent) {
        highlight(o.identifier, HighlightColor.SYM_CLASS)
    }


    override fun visitInheritItem(o: ValkyrieInheritItem) {
        highlight(o.identifier, HighlightColor.SYM_FIELD)
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

    override fun visitDeclareDomain(o: ValkyrieDeclareDomain) {
        o as ValkyrieDeclareDomainNode
        highlight(o.nameIdentifier, HighlightColor.SYM_MACRO)
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
        highlight(o.identifier, HighlightColor.SYM_CLASS)
    }

    override fun visitDeclareVariant(o: ValkyrieDeclareVariant) {
        highlight(o.identifier, HighlightColor.SYM_VARIANT)
    }

    override fun visitTraitAlias(o: ValkyrieTraitAlias) {
        o as ValkyrieTraitAliasNode
        highlight(o.nameIdentifier, HighlightColor.SYM_TRAIT)
    }

    override fun visitDeclareTrait(o: ValkyrieDeclareTrait) {
        o as ValkyrieDeclareTraitNode
        highlight(o.nameIdentifier, HighlightColor.SYM_TRAIT)
    }

    override fun visitDeclareImply(o: ValkyrieDeclareImply) {
        o.namepath?.highlight(this)
    }

    override fun visitDeclareFunction(o: ValkyrieDeclareFunction) {
        o as ValkyrieDeclareFunctionNode
        highlight(o.nameIdentifier, HighlightColor.SYM_FUNCTION_FREE)
    }

    override fun visitDeclareMacro(o: ValkyrieDeclareMacro) {
        o as ValkyrieDeclareMacroNode
        highlight(o.nameIdentifier, HighlightColor.SYM_MACRO)
    }

    override fun visitMacroCall(o: ValkyrieMacroCall) {
        highlight(o.firstChild, HighlightColor.SYM_MACRO)
        highlight(o.namepath, HighlightColor.SYM_MACRO)
    }


    override fun visitParameterItem(o: ValkyrieParameterItem) {
        highlight(o.identifier, HighlightColor.SYM_ARG)
        o.typeHint?.typeExpression?.highlight_class(this)
    }

    override fun visitGenericParameter(o: ValkyrieGenericParameter) {
        o as ValkyrieGenericParameterNode
        highlight(o.identifier, HighlightColor.SYM_MACRO)

    }


    override fun visitGenericArgument(o: ValkyrieGenericArgument) {
        highlight(o.identifier, HighlightColor.SYM_CLASS)
        o.typeExpression.highlight_class(this)
    }

    override fun visitTypeExpression(o: ValkyrieTypeExpression) {
        for (term in o.typeTermList) {
            term.typeAtomic.namepath?.highlight(this)
        }
    }

    override fun visitLetPatternItem(o: ValkyrieLetPatternItem) {
        highlight(o.identifier, o.getHighlightColor())
    }

    override fun visitTypePatternTuple(o: ValkyrieTypePatternTuple) {
        o.namepath?.highlight(this)
    }

    override fun visitTypePatternObject(o: ValkyrieTypePatternObject) {
        o.namepath?.highlight(this)
    }

    override fun visitPatternPair(o: ValkyriePatternPair) {
        highlight(o.identifier, HighlightColor.SYM_ARG)
    }

    override fun visitTypePatternItem(o: ValkyrieTypePatternItem) {
        o.namepath.highlight(this)
    }

    override fun visitCasePatternTuple(o: ValkyrieCasePatternTuple) {
        o.namepath?.highlight(this)
    }

    override fun visitCasePatternObject(o: ValkyrieCasePatternObject) {
        o.namepath?.highlight(this)
    }

    override fun visitCasePatternPair(o: ValkyrieCasePatternPair) {
        highlight(o.identifier, HighlightColor.SYM_ARG)
    }

    override fun visitCasePatternItem(o: ValkyrieCasePatternItem) {
        highlight(o.identifier, HighlightColor.SYM_ARG)
    }

    override fun visitDefaultType(o: ValkyrieDefaultType) {
        o.typeExpression.highlight_class(this)
    }

    override fun visitReturnType(o: ValkyrieReturnType) {
        o.typeExpression.highlight_class(this)
    }

    override fun visitArgument(o: ValkyrieArgument) {
        highlight(o.identifier, HighlightColor.SYM_ARG)
    }

    override fun visitFunctionCall(o: ValkyrieFunctionCall) {
        o.namepath.highlight(this)
    }


    override fun visitDotCall(o: ValkyrieDotCall) {
        highlight(o.namepath.lastChild, HighlightColor.SYM_FUNCTION_SELF)
    }

    override fun visitDotCallInline(o: ValkyrieDotCallInline) {
        highlight(o.namepath.lastChild, HighlightColor.SYM_FUNCTION_SELF)
    }

    override fun visitNewValue(o: ValkyrieNewValue) {

    }

    override fun visitRangeItem(o: ValkyrieRangeItem) {
        for (child in o.childrenWithLeaves) {
            if (child.elementType == ValkyrieTypes.NAME_SPLIT) {
                highlight(child, HighlightColor.OPERATION)
                break
            }
        }
    }

    override fun visitLocalizeCall(o: ValkyrieLocalizeCall) {
        highlight(o.firstChild, HighlightColor.SYM_MACRO)
        for (id in o.identifierList) {
            highlight(id, HighlightColor.SYM_MACRO)
        }
    }

    override fun visitSlot(o: ValkyrieSlot) {
        highlight(o, HighlightColor.KEYWORD)
    }

    override fun visitNumber(o: ValkyrieNumber) {
        highlight(o.identifier, HighlightColor.SYM_MACRO)
    }

    override fun visitString(o: ValkyrieString) {
        highlight(o.identifier, HighlightColor.SYM_MACRO)
    }


    fun highlight(element: PsiElement?, color: HighlightColor) {
        element ?: return
        val builder = HighlightInfo.newHighlightInfo(HighlightInfoType.INFORMATION)
        builder.textAttributes(color.textAttributesKey)
        builder.range(element)

        infoHolder?.add(builder.create())
    }

    override fun analyze(file: PsiFile, updateWholeFile: Boolean, holder: HighlightInfoHolder, action: Runnable): Boolean {
        infoHolder = holder
        action.run()
        return true
    }

    override fun clone(): HighlightVisitor = NodeHighlighter()

    override fun suitableForFile(file: PsiFile): Boolean = file is ValkyrieFileNode

    override fun visit(element: PsiElement) = element.accept(this)
}

