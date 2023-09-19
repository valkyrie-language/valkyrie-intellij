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
        highlight(o.namepathFree, HighlightColor.SYM_MACRO)
    }

    override fun visitModifier(o: ValkyrieModifier) {
        highlight(o, HighlightColor.KEYWORD)
    }

    override fun visitDeclareInfer(o: ValkyrieDeclareInfer) {
        o.identifierSafeList.forEach {
            highlight(it, HighlightColor.SYM_GENERIC )
        }
    }

    override fun visitDeclareClass(o: ValkyrieDeclareClass) {
        highlight(o.identifierSafe, HighlightColor.SYM_CLASS)
    }

    override fun visitDeclareSingleton(o: ValkyrieDeclareSingleton) {
        highlight(o.identifierSafe, HighlightColor.SYM_CONSTANT)
    }

    override fun visitDeclareNeural(o: ValkyrieDeclareNeural) {
        highlight(o.identifierSafe, HighlightColor.SYM_CLASS)
    }

    override fun visitDeclareComponent(o: ValkyrieDeclareComponent) {
        highlight(o.identifierSafe, HighlightColor.SYM_CLASS)
    }

    override fun visitInheritItem(o: ValkyrieInheritItem) {
        highlight(o.identifierSafe, HighlightColor.SYM_FIELD)
    }

    override fun visitDeclareField(o: ValkyrieDeclareField) {
        highlight(o.identifierFree, HighlightColor.SYM_FIELD)
    }

    override fun visitDeclareMethod(o: ValkyrieDeclareMethod) {
        highlight(o.identifierFree, HighlightColor.SYM_FUNCTION_FREE)
    }

    override fun visitDeclareDomain(o: ValkyrieDeclareDomain) {
        highlight(o.identifierSafe, HighlightColor.SYM_MACRO)
    }

    override fun visitDeclareUnion(o: ValkyrieDeclareUnion) {
        highlight(o.identifierSafe, HighlightColor.SYM_MACRO)
    }

    override fun visitDeclareFlags(o: ValkyrieDeclareFlags) {
        highlight(o.identifierFree, HighlightColor.SYM_CLASS)
    }

    override fun visitDeclareSemantic(o: ValkyrieDeclareSemantic) {
        highlight(o.identifierSafe, HighlightColor.SYM_FIELD)
    }

    override fun visitDeclareEnums(o: ValkyrieDeclareEnums) {
        highlight(o.identifierSafe, HighlightColor.SYM_CONSTANT)
    }

    override fun visitDeclareUnite(o: ValkyrieDeclareUnite) {
        highlight(o.identifierSafe, HighlightColor.SYM_CLASS)
    }

    override fun visitDeclareVariant(o: ValkyrieDeclareVariant) {
        highlight(o.identifierSafe, HighlightColor.SYM_VARIANT)
    }

    override fun visitDeclareTrait(o: ValkyrieDeclareTrait) {
        highlight(o.identifierSafe, HighlightColor.SYM_TRAIT)
    }

    override fun visitDeclareImply(o: ValkyrieDeclareImply) {
        o.namepath?.highlight(this)
    }

    override fun visitDeclareFunction(o: ValkyrieDeclareFunction) {
        highlight(o.identifierSafe, HighlightColor.SYM_FUNCTION_FREE)
    }

    override fun visitDeclareMacro(o: ValkyrieDeclareMacro) {
        highlight(o.identifierSafe, HighlightColor.SYM_MACRO)
    }

    override fun visitMacroCall(o: ValkyrieMacroCall) {
        highlight(o.firstChild, HighlightColor.SYM_MACRO)
        highlight(o.macroPath, HighlightColor.SYM_MACRO)
    }


    override fun visitParameterItem(o: ValkyrieParameterItem) {
        highlight(o.identifierFree, HighlightColor.SYM_ARG)
    }

    override fun visitParameterList(o: ValkyrieParameterList) {
        highlight(o.identifierFree, HighlightColor.SYM_ARG)
    }

    override fun visitParameterDict(o: ValkyrieParameterDict) {
        highlight(o.identifierFree, HighlightColor.SYM_ARG)
    }

    override fun visitGenericParameter(o: ValkyrieGenericParameter) {
        highlight(o.identifierSafe, HighlightColor.SYM_MACRO)

    }


    override fun visitGenericArgument(o: ValkyrieGenericArgument) {
        highlight(o.identifierSafe, HighlightColor.SYM_CLASS)
    }

    override fun visitTypeExpression(o: ValkyrieTypeExpression) {
        for (term in o.typeTermList) {
            term.typeAtomic.namepath?.highlight(this)
        }
    }


    override fun visitBarePatternItem(o: ValkyrieBarePatternItem) {
        highlight(o.identifierSafe, HighlightColor.SYM_LOCAL)
    }

    override fun visitMatchBind(o: ValkyrieMatchBind) {
        highlight(o.identifierSafe, HighlightColor.SYM_LOCAL)
    }

    override fun visitPatternPair(o: ValkyriePatternPair) {
        highlight(o.identifierSafe, HighlightColor.SYM_LOCAL)
    }


    override fun visitTypePatternTuple(o: ValkyrieTypePatternTuple) {
        o.namepath?.highlight(this)
    }

    override fun visitTypePatternObject(o: ValkyrieTypePatternObject) {
        o.namepath?.highlight(this)
    }

    override fun visitTypePatternPair(o: ValkyrieTypePatternPair) {
        highlight(o.identifierSafe, HighlightColor.SYM_LOCAL)
    }

    override fun visitTypePatternItem(o: ValkyrieTypePatternItem) {
        o.namepath.highlight(this)
    }

    override fun visitCasePattern(o: ValkyrieCasePattern) {

        val names = o.namepath?.identifierSafe ?: emptyList();
        if (names.count() == 1) {
            val head = names.firstOrNull() as? ValkyrieIdentifierNode
            val c = head?.name?.firstOrNull()
            if (c?.isLowerCase() == true) {
                highlight(head, HighlightColor.SYM_LOCAL)
            } else if (c?.isUpperCase() == true) {
                highlight(head, HighlightColor.SYM_VARIANT)
            }
        } else {
            o.namepath?.highlight(this)
        }
    }

    override fun visitCasePatternDict(o: ValkyrieCasePatternDict) {
        o.namepath?.highlight(this)
    }

    override fun visitCasePatternList(o: ValkyrieCasePatternList) {
        o.namepath?.highlight(this)
    }

    override fun visitCasePatternPair(o: ValkyrieCasePatternPair) {
        highlight(o.identifierSafe, HighlightColor.SYM_LOCAL)
    }

    override fun visitCasePatternItem(o: ValkyrieCasePatternItem) {
        highlight(o.identifierSafe, HighlightColor.SYM_LOCAL)
    }

    override fun visitTypeAtomic(o: ValkyrieTypeAtomic) {
        o.namepath?.highlight(this)
    }

    override fun visitArgument(o: ValkyrieArgument) {
        highlight(o.identifierSafe, HighlightColor.SYM_ARG)
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

    override fun visitAtomic(o: ValkyrieAtomic) {
        o.namepath?.highlight(this)
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
        for (id in o.identifierSafeList) {
            highlight(id, HighlightColor.SYM_MACRO)
        }
    }

    override fun visitSlot(o: ValkyrieSlot) {
        highlight(o, HighlightColor.KEYWORD)
    }

    override fun visitString(o: ValkyrieString) {
        highlight(o.identifierSafe, HighlightColor.SYM_MACRO)
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

