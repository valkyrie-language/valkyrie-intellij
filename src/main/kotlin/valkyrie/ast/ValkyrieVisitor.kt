package valkyrie.ast

import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.node.ValkyrieClassDeclarationNode
import valkyrie.psi.node.ValkyrieAnnotations
import valkyrie.psi.node.ValkyrieArgument
import valkyrie.psi.node.ValkyrieArgumentBody
import valkyrie.psi.node.ValkyrieAssociatedType
import valkyrie.psi.node.ValkyrieAtomic
import valkyrie.psi.node.ValkyrieAttributeAbove
import valkyrie.psi.node.ValkyrieAttributeBelow
import valkyrie.psi.node.ValkyrieAttributeItem
import valkyrie.psi.node.ValkyrieAttributeList
import valkyrie.psi.node.ValkyrieBadLl
import valkyrie.psi.node.ValkyrieBadLll
import valkyrie.psi.node.ValkyrieBadRr
import valkyrie.psi.node.ValkyrieBadRrr
import valkyrie.psi.node.ValkyrieBarePattern
import valkyrie.psi.node.ValkyrieBarePatternItem
import valkyrie.psi.node.ValkyrieBenchmarkBody
import valkyrie.psi.node.ValkyrieBenchmarkUnit
import valkyrie.psi.node.ValkyrieBlockBare
import valkyrie.psi.node.ValkyrieBlockBody
import valkyrie.psi.node.ValkyrieCasePattern
import valkyrie.psi.node.ValkyrieCasePatternBind
import valkyrie.psi.node.ValkyrieCasePatternDict
import valkyrie.psi.node.ValkyrieCasePatternItem
import valkyrie.psi.node.ValkyrieCasePatternKind
import valkyrie.psi.node.ValkyrieCasePatternList
import valkyrie.psi.node.ValkyrieCasePatternMain
import valkyrie.psi.node.ValkyrieCasePatternPair
import valkyrie.psi.node.ValkyrieCasePatternRest
import valkyrie.psi.node.ValkyrieCasePatternTop
import valkyrie.psi.node.ValkyrieClassBody
import valkyrie.psi.node.ValkyrieClassInherit
import valkyrie.psi.node.ValkyrieControlBreak
import valkyrie.psi.node.ValkyrieControlContinue
import valkyrie.psi.node.ValkyrieControlLabel
import valkyrie.psi.node.ValkyrieControlRaise
import valkyrie.psi.node.ValkyrieControlResume
import valkyrie.psi.node.ValkyrieControlReturn
import valkyrie.psi.node.ValkyrieControlStatement
import valkyrie.psi.node.ValkyrieControlThrough
import valkyrie.psi.node.ValkyrieControlYieldFrom
import valkyrie.psi.node.ValkyrieControlYieldSend
import valkyrie.psi.node.ValkyrieControlYieldStop
import valkyrie.psi.node.ValkyrieControlYieldType
import valkyrie.psi.node.ValkyrieDeclareComponent
import valkyrie.psi.node.ValkyrieDeclareDomain
import valkyrie.psi.node.ValkyrieDeclareEnums
import valkyrie.psi.node.ValkyrieDeclareField
import valkyrie.psi.node.ValkyrieDeclareFlags
import valkyrie.psi.node.ValkyrieDeclareFunction
import valkyrie.psi.node.ValkyrieDeclareGeneric
import valkyrie.psi.node.ValkyrieDeclareImply
import valkyrie.psi.node.ValkyrieDeclareInfer
import valkyrie.psi.node.ValkyrieDeclareMacro
import valkyrie.psi.node.ValkyrieDeclareMethod
import valkyrie.psi.node.ValkyrieDeclareMezzo
import valkyrie.psi.node.ValkyrieDeclareNamespace
import valkyrie.psi.node.ValkyrieDeclareNeural
import valkyrie.psi.node.ValkyrieDeclareSemantic
import valkyrie.psi.node.ValkyrieDeclareSingleton
import valkyrie.psi.node.ValkyrieDeclareTests
import valkyrie.psi.node.ValkyrieDeclareTrait
import valkyrie.psi.node.ValkyrieDeclareType
import valkyrie.psi.node.ValkyrieDeclareUnion
import valkyrie.psi.node.ValkyrieDeclareUnite
import valkyrie.psi.node.ValkyrieDeclareVariant
import valkyrie.psi.node.ValkyrieDeclareWhere
import valkyrie.psi.node.ValkyrieDefaultType
import valkyrie.psi.node.ValkyrieDefaultValue
import valkyrie.psi.node.ValkyrieDotCall
import valkyrie.psi.node.ValkyrieDotCallInline
import valkyrie.psi.node.ValkyrieDotCallMacro
import valkyrie.psi.node.ValkyrieDotCallMacroInline
import valkyrie.psi.node.ValkyrieDotLoopCall
import valkyrie.psi.node.ValkyrieDotMatchCall
import valkyrie.psi.node.ValkyrieElseIfStatement
import valkyrie.psi.node.ValkyrieElseStatement
import valkyrie.psi.node.ValkyrieElseTemplate
import valkyrie.psi.node.ValkyrieExpression
import valkyrie.psi.node.ValkyrieExpressionInline
import valkyrie.psi.node.ValkyrieExpressionRoot
import valkyrie.psi.node.ValkyrieFlagsBody
import valkyrie.psi.node.ValkyrieFunctionCall
import valkyrie.psi.node.ValkyrieFunctionCallInline
import valkyrie.psi.node.ValkyrieGenericArgument
import valkyrie.psi.node.ValkyrieGenericCall
import valkyrie.psi.node.ValkyrieGenericCallFree
import valkyrie.psi.node.ValkyrieGenericParameter
import valkyrie.psi.node.ValkyrieIdentifierFree
import valkyrie.psi.node.ValkyrieIdentifierSafe
import valkyrie.psi.node.ValkyrieIfCondition
import valkyrie.psi.node.ValkyrieIfStatement
import valkyrie.psi.node.ValkyrieInferBody
import valkyrie.psi.node.ValkyrieInfix
import valkyrie.psi.node.ValkyrieInfixGreater
import valkyrie.psi.node.ValkyrieInfixGreaterEqual
import valkyrie.psi.node.ValkyrieInfixLess
import valkyrie.psi.node.ValkyrieInfixLessEqual
import valkyrie.psi.node.ValkyrieInfixLogical
import valkyrie.psi.node.ValkyrieInfixMultiple
import valkyrie.psi.node.ValkyrieInheritItem
import valkyrie.psi.node.ValkyrieInlineAtomic
import valkyrie.psi.node.ValkyrieInlineSuffix
import valkyrie.psi.node.ValkyrieInlineTerm
import valkyrie.psi.node.ValkyrieIsExpression
import valkyrie.psi.node.ValkyrieIsStatement
import valkyrie.psi.node.ValkyrieLetPattern
import valkyrie.psi.node.ValkyrieLetStatement
import valkyrie.psi.node.ValkyrieLocalizeCall
import valkyrie.psi.node.ValkyrieLoopCondition
import valkyrie.psi.node.ValkyrieLoopEach
import valkyrie.psi.node.ValkyrieLoopInline
import valkyrie.psi.node.ValkyrieLoopMatch
import valkyrie.psi.node.ValkyrieLoopStart
import valkyrie.psi.node.ValkyrieLoopStatement
import valkyrie.psi.node.ValkyrieLoopTemplate
import valkyrie.psi.node.ValkyrieLoopTemplateStart
import valkyrie.psi.node.ValkyrieLoopUntil
import valkyrie.psi.node.ValkyrieLoopUntilNot
import valkyrie.psi.node.ValkyrieLoopWhile
import valkyrie.psi.node.ValkyrieLoopWhileLet
import valkyrie.psi.node.ValkyrieMacroCall
import valkyrie.psi.node.ValkyrieMacroCallInline
import valkyrie.psi.node.ValkyrieMacroPath
import valkyrie.psi.node.ValkyrieMatchBind
import valkyrie.psi.node.ValkyrieMatchBody
import valkyrie.psi.node.ValkyrieMatchCase
import valkyrie.psi.node.ValkyrieMatchElse
import valkyrie.psi.node.ValkyrieMatchKind
import valkyrie.psi.node.ValkyrieMatchStatement
import valkyrie.psi.node.ValkyrieMatchType
import valkyrie.psi.node.ValkyrieMatchWhen
import valkyrie.psi.node.ValkyrieMatchWith
import valkyrie.psi.node.ValkyrieMatchWithControl
import valkyrie.psi.node.ValkyrieMatchWithProvide
import valkyrie.psi.node.ValkyrieMayLetStatement
import valkyrie.psi.node.ValkyrieModifier
import valkyrie.psi.node.ValkyrieNamepathAuto
import valkyrie.psi.node.ValkyrieNamepathFree
import valkyrie.psi.node.ValkyrieNamepathSafe
import valkyrie.psi.node.ValkyrieNewBind
import valkyrie.psi.node.ValkyrieNewBody
import valkyrie.psi.node.ValkyrieNewLambda
import valkyrie.psi.node.ValkyrieNewObject
import valkyrie.psi.node.ValkyrieNewValue
import valkyrie.psi.node.ValkyrieNumberLiteral
import valkyrie.psi.node.ValkyrieOffsetRange
import valkyrie.psi.node.ValkyrieOffsetSlice
import valkyrie.psi.node.ValkyrieOrdinalRange
import valkyrie.psi.node.ValkyrieOrdinalSlice
import valkyrie.psi.node.ValkyrieParameterBody
import valkyrie.psi.node.ValkyrieParameterDict
import valkyrie.psi.node.ValkyrieParameterItem
import valkyrie.psi.node.ValkyrieParameterKind
import valkyrie.psi.node.ValkyrieParameterList
import valkyrie.psi.node.ValkyriePrefix
import valkyrie.psi.node.ValkyriePrefixDeref
import valkyrie.psi.node.ValkyriePrefixNot
import valkyrie.psi.node.ValkyriePrefixRef
import valkyrie.psi.node.ValkyrieRangeIndex
import valkyrie.psi.node.ValkyrieRangeItem
import valkyrie.psi.node.ValkyrieRangeLower
import valkyrie.psi.node.ValkyrieRangeStep
import valkyrie.psi.node.ValkyrieRangeUpper
import valkyrie.psi.node.ValkyrieReturnType
import valkyrie.psi.node.ValkyrieRunBenchmark
import valkyrie.psi.node.ValkyrieRunTestCast
import valkyrie.psi.node.ValkyrieSlot
import valkyrie.psi.node.ValkyrieSlotFirst
import valkyrie.psi.node.ValkyrieSlotIndex
import valkyrie.psi.node.ValkyrieSlotNamed
import valkyrie.psi.node.ValkyrieSpecial
import valkyrie.psi.node.ValkyrieStatements
import valkyrie.psi.node.ValkyrieString
import valkyrie.psi.node.ValkyrieSuffix
import valkyrie.psi.node.ValkyrieTemplateEnd
import valkyrie.psi.node.ValkyrieTerm
import valkyrie.psi.node.ValkyrieTestsBody
import valkyrie.psi.node.ValkyrieThenStatement
import valkyrie.psi.node.ValkyrieTraitAlias
import valkyrie.psi.node.ValkyrieTraitDefine
import valkyrie.psi.node.ValkyrieTryLetStatement
import valkyrie.psi.node.ValkyrieTryNotStatement
import valkyrie.psi.node.ValkyrieTryStatement
import valkyrie.psi.node.ValkyrieTupleArgument
import valkyrie.psi.node.ValkyrieTypeAlias
import valkyrie.psi.node.ValkyrieTypeAtomic
import valkyrie.psi.node.ValkyrieTypeExpression
import valkyrie.psi.node.ValkyrieTypeFunction
import valkyrie.psi.node.ValkyrieTypeHint
import valkyrie.psi.node.ValkyrieTypeInfix
import valkyrie.psi.node.ValkyrieTypePattern
import valkyrie.psi.node.ValkyrieTypePatternInline
import valkyrie.psi.node.ValkyrieTypePatternItem
import valkyrie.psi.node.ValkyrieTypePatternObject
import valkyrie.psi.node.ValkyrieTypePatternPair
import valkyrie.psi.node.ValkyrieTypePatternTuple
import valkyrie.psi.node.ValkyrieTypePrefix
import valkyrie.psi.node.ValkyrieTypeSuffix
import valkyrie.psi.node.ValkyrieTypeTerm
import valkyrie.psi.node.ValkyrieTypeTuple
import valkyrie.psi.node.ValkyrieUniteBody
import valkyrie.psi.node.ValkyrieUnused
import valkyrie.psi.node.ValkyrieUsingAlias
import valkyrie.psi.node.ValkyrieUsingAny
import valkyrie.psi.node.ValkyrieUsingBlock
import valkyrie.psi.node.ValkyrieUsingBody
import valkyrie.psi.node.ValkyrieUsingExclude
import valkyrie.psi.node.ValkyrieUsingStatement
import valkyrie.psi.node.ValkyrieUsingTerm
import valkyrie.psi.node.ValkyrieWhereCondition
import valkyrie.psi.node.ValkyrieWhereTerm

open class ValkyrieVisitor : PsiElementVisitor() {
    open fun visitAnnotations(o: ValkyrieAnnotations) {
        visitPsiElement(o)
    }

    open fun visitArgument(o: ValkyrieArgument) {
        visitPsiElement(o)
    }

    open fun visitArgumentBody(o: ValkyrieArgumentBody) {
        visitPsiElement(o)
    }

    open fun visitAssociatedType(o: ValkyrieAssociatedType) {
        visitPsiElement(o)
    }

    open fun visitAtomic(o: ValkyrieAtomic) {
        visitPsiElement(o)
    }

    open fun visitAttributeAbove(o: ValkyrieAttributeAbove) {
        visitPsiElement(o)
    }

    open fun visitAttributeBelow(o: ValkyrieAttributeBelow) {
        visitPsiElement(o)
    }

    open fun visitAttributeItem(o: ValkyrieAttributeItem) {
        visitPsiElement(o)
    }

    open fun visitAttributeList(o: ValkyrieAttributeList) {
        visitPsiElement(o)
    }

    open fun visitBadLl(o: ValkyrieBadLl) {
        visitPsiElement(o)
    }

    open fun visitBadLll(o: ValkyrieBadLll) {
        visitPsiElement(o)
    }

    open fun visitBadRr(o: ValkyrieBadRr) {
        visitPsiElement(o)
    }

    open fun visitBadRrr(o: ValkyrieBadRrr) {
        visitPsiElement(o)
    }

    open fun visitBarePattern(o: ValkyrieBarePattern) {
        visitPsiElement(o)
    }

    open fun visitBarePatternItem(o: ValkyrieBarePatternItem) {
        visitPsiElement(o)
    }

    open fun visitBenchmarkBody(o: ValkyrieBenchmarkBody) {
        visitPsiElement(o)
    }

    open fun visitBenchmarkUnit(o: ValkyrieBenchmarkUnit) {
        visitPsiElement(o)
    }

    open fun visitBlockBare(o: ValkyrieBlockBare) {
        visitPsiElement(o)
    }

    open fun visitBlockBody(o: ValkyrieBlockBody) {
        visitPsiElement(o)
    }

    open fun visitCasePattern(o: ValkyrieCasePattern) {
        visitPsiElement(o)
    }

    open fun visitCasePatternBind(o: ValkyrieCasePatternBind) {
        visitPsiElement(o)
    }

    open fun visitCasePatternDict(o: ValkyrieCasePatternDict) {
        visitPsiElement(o)
    }

    open fun visitCasePatternItem(o: ValkyrieCasePatternItem) {
        visitPsiElement(o)
    }

    open fun visitCasePatternKind(o: ValkyrieCasePatternKind) {
        visitPsiElement(o)
    }

    open fun visitCasePatternList(o: ValkyrieCasePatternList) {
        visitPsiElement(o)
    }

    open fun visitCasePatternMain(o: ValkyrieCasePatternMain) {
        visitPsiElement(o)
    }

    open fun visitCasePatternPair(o: ValkyrieCasePatternPair) {
        visitPsiElement(o)
    }

    open fun visitCasePatternRest(o: ValkyrieCasePatternRest) {
        visitPsiElement(o)
    }

    open fun visitCasePatternTop(o: ValkyrieCasePatternTop) {
        visitPsiElement(o)
    }

    open fun visitClassBody(o: ValkyrieClassBody) {
        visitPsiElement(o)
    }

    open fun visitClassInherit(o: ValkyrieClassInherit) {
        visitPsiElement(o)
    }

    open fun visitControlBreak(o: ValkyrieControlBreak) {
        visitPsiElement(o)
    }

    open fun visitControlContinue(o: ValkyrieControlContinue) {
        visitPsiElement(o)
    }

    open fun visitControlLabel(o: ValkyrieControlLabel) {
        visitPsiElement(o)
    }

    open fun visitControlRaise(o: ValkyrieControlRaise) {
        visitPsiElement(o)
    }

    open fun visitControlResume(o: ValkyrieControlResume) {
        visitPsiElement(o)
    }

    open fun visitControlReturn(o: ValkyrieControlReturn) {
        visitPsiElement(o)
    }

    open fun visitControlStatement(o: ValkyrieControlStatement) {
        visitPsiElement(o)
    }

    open fun visitControlThrough(o: ValkyrieControlThrough) {
        visitPsiElement(o)
    }

    open fun visitControlYieldFrom(o: ValkyrieControlYieldFrom) {
        visitPsiElement(o)
    }

    open fun visitControlYieldSend(o: ValkyrieControlYieldSend) {
        visitPsiElement(o)
    }

    open fun visitControlYieldStop(o: ValkyrieControlYieldStop) {
        visitPsiElement(o)
    }

    open fun visitControlYieldType(o: ValkyrieControlYieldType) {
        visitPsiElement(o)
    }

    open fun visitDeclareClass(o: ValkyrieClassDeclarationNode) {
        visitPsiElement(o)
    }

    open fun visitDeclareComponent(o: ValkyrieDeclareComponent) {
        visitPsiElement(o)
    }

    open fun visitDeclareDomain(o: ValkyrieDeclareDomain) {
        visitPsiElement(o)
    }

    open fun visitDeclareEnums(o: ValkyrieDeclareEnums) {
        visitPsiElement(o)
    }

    open fun visitDeclareField(o: ValkyrieDeclareField) {
        visitPsiElement(o)
    }

    open fun visitDeclareFlags(o: ValkyrieDeclareFlags) {
        visitPsiElement(o)
    }

    open fun visitDeclareFunction(o: ValkyrieDeclareFunction)
    {
        visitPsiElement(o)
    }

    open fun visitDeclareGeneric(o: ValkyrieDeclareGeneric) {
        visitPsiElement(o)
    }

    open fun visitDeclareImply(o: ValkyrieDeclareImply) {
        visitPsiElement(o)
    }

    open fun visitDeclareInfer(o: ValkyrieDeclareInfer) {
        visitPsiElement(o)
    }

    open fun visitDeclareMacro(o: ValkyrieDeclareMacro) {
        visitPsiElement(o)
    }

    open fun visitDeclareMethod(o: ValkyrieDeclareMethod) {
        visitPsiElement(o)
    }

    open fun visitDeclareMezzo(o: ValkyrieDeclareMezzo) {
        visitPsiElement(o)
    }

    open fun visitDeclareNamespace(o: ValkyrieDeclareNamespace) {
        visitPsiElement(o)
    }

    open fun visitDeclareNeural(o: ValkyrieDeclareNeural) {
        visitPsiElement(o)
    }

    open fun visitDeclareSemantic(o: ValkyrieDeclareSemantic) {
        visitPsiElement(o)
    }

    open fun visitDeclareSingleton(o: ValkyrieDeclareSingleton) {
        visitPsiElement(o)
    }

    open fun visitDeclareTests(o: ValkyrieDeclareTests) {
        visitPsiElement(o)
    }

    open fun visitDeclareTrait(o: ValkyrieDeclareTrait) {
        visitPsiElement(o)
    }

    open fun visitDeclareType(o: ValkyrieDeclareType) {
        visitPsiElement(o)
    }

    open fun visitDeclareUnion(o: ValkyrieDeclareUnion) {
        visitPsiElement(o)
    }

    open fun visitDeclareUnite(o: ValkyrieDeclareUnite) {
        visitPsiElement(o)
    }

    open fun visitDeclareVariant(o: ValkyrieDeclareVariant) {
        visitPsiElement(o)
    }

    open fun visitDeclareWhere(o: ValkyrieDeclareWhere) {
        visitPsiElement(o)
    }

    open fun visitDefaultType(o: ValkyrieDefaultType) {
        visitPsiElement(o)
    }

    open fun visitDefaultValue(o: ValkyrieDefaultValue) {
        visitPsiElement(o)
    }

    open fun visitDotCall(o: ValkyrieDotCall) {
        visitPsiElement(o)
    }

    open fun visitDotCallInline(o: ValkyrieDotCallInline) {
        visitPsiElement(o)
    }

    open fun visitDotCallMacro(o: ValkyrieDotCallMacro) {
        visitPsiElement(o)
    }

    open fun visitDotCallMacroInline(o: ValkyrieDotCallMacroInline) {
        visitPsiElement(o)
    }

    open fun visitDotLoopCall(o: ValkyrieDotLoopCall) {
        visitPsiElement(o)
    }

    open fun visitDotMatchCall(o: ValkyrieDotMatchCall) {
        visitPsiElement(o)
    }

    open fun visitElseIfStatement(o: ValkyrieElseIfStatement) {
        visitPsiElement(o)
    }

    open fun visitElseStatement(o: ValkyrieElseStatement) {
        visitPsiElement(o)
    }

    open fun visitElseTemplate(o: ValkyrieElseTemplate) {
        visitPsiElement(o)
    }

    open fun visitExpression(o: ValkyrieExpression) {
        visitPsiElement(o)
    }

    open fun visitExpressionInline(o: ValkyrieExpressionInline) {
        visitPsiElement(o)
    }

    open fun visitExpressionRoot(o: ValkyrieExpressionRoot) {
        visitPsiElement(o)
    }

    open fun visitFlagsBody(o: ValkyrieFlagsBody) {
        visitPsiElement(o)
    }

    open fun visitFunctionCall(o: ValkyrieFunctionCall)
    {
        visitPsiElement(o)
    }

    open fun visitFunctionCallInline(o: ValkyrieFunctionCallInline)
    {
        visitPsiElement(o)
    }

    open fun visitGenericArgument(o: ValkyrieGenericArgument) {
        visitPsiElement(o)
    }

    open fun visitGenericCall(o: ValkyrieGenericCall) {
        visitPsiElement(o)
    }

    open fun visitGenericCallFree(o: ValkyrieGenericCallFree) {
        visitPsiElement(o)
    }

    open fun visitGenericParameter(o: ValkyrieGenericParameter) {
        visitPsiElement(o)
    }

    open fun visitIdentifierFree(o: ValkyrieIdentifierFree) {
        visitPsiElement(o)
    }

    open fun visitIdentifierSafe(o: ValkyrieIdentifierSafe) {
        visitPsiElement(o)
    }

    open fun visitIfCondition(o: ValkyrieIfCondition) {
        visitPsiElement(o)
    }

    open fun visitIfStatement(o: ValkyrieIfStatement) {
        visitPsiElement(o)
    }

    open fun visitInferBody(o: ValkyrieInferBody) {
        visitPsiElement(o)
    }

    open fun visitInfix(o: ValkyrieInfix) {
        visitPsiElement(o)
    }

    open fun visitInfixGreater(o: ValkyrieInfixGreater) {
        visitPsiElement(o)
    }

    open fun visitInfixGreaterEqual(o: ValkyrieInfixGreaterEqual) {
        visitPsiElement(o)
    }

    open fun visitInfixLess(o: ValkyrieInfixLess) {
        visitPsiElement(o)
    }

    open fun visitInfixLessEqual(o: ValkyrieInfixLessEqual) {
        visitPsiElement(o)
    }

    open fun visitInfixLogical(o: ValkyrieInfixLogical) {
        visitPsiElement(o)
    }

    open fun visitInfixMultiple(o: ValkyrieInfixMultiple) {
        visitPsiElement(o)
    }

    open fun visitInheritItem(o: ValkyrieInheritItem) {
        visitPsiElement(o)
    }

    open fun visitInlineAtomic(o: ValkyrieInlineAtomic) {
        visitPsiElement(o)
    }

    open fun visitInlineSuffix(o: ValkyrieInlineSuffix) {
        visitPsiElement(o)
    }

    open fun visitInlineTerm(o: ValkyrieInlineTerm) {
        visitPsiElement(o)
    }

    open fun visitIsExpression(o: ValkyrieIsExpression) {
        visitPsiElement(o)
    }

    open fun visitIsStatement(o: ValkyrieIsStatement) {
        visitPsiElement(o)
    }

    open fun visitLetPattern(o: ValkyrieLetPattern) {
        visitPsiElement(o)
    }

    open fun visitLetStatement(o: ValkyrieLetStatement) {
        visitPsiElement(o)
    }

    open fun visitLocalizeCall(o: ValkyrieLocalizeCall) {
        visitPsiElement(o)
    }

    open fun visitLoopCondition(o: ValkyrieLoopCondition) {
        visitPsiElement(o)
    }

    open fun visitLoopEach(o: ValkyrieLoopEach) {
        visitPsiElement(o)
    }

    open fun visitLoopInline(o: ValkyrieLoopInline) {
        visitPsiElement(o)
    }

    open fun visitLoopMatch(o: ValkyrieLoopMatch) {
        visitPsiElement(o)
    }

    open fun visitLoopStart(o: ValkyrieLoopStart) {
        visitPsiElement(o)
    }

    open fun visitLoopStatement(o: ValkyrieLoopStatement) {
        visitPsiElement(o)
    }

    open fun visitLoopTemplate(o: ValkyrieLoopTemplate) {
        visitPsiElement(o)
    }

    open fun visitLoopTemplateStart(o: ValkyrieLoopTemplateStart) {
        visitPsiElement(o)
    }

    open fun visitLoopUntil(o: ValkyrieLoopUntil) {
        visitPsiElement(o)
    }

    open fun visitLoopUntilNot(o: ValkyrieLoopUntilNot) {
        visitPsiElement(o)
    }

    open fun visitLoopWhile(o: ValkyrieLoopWhile) {
        visitPsiElement(o)
    }

    open fun visitLoopWhileLet(o: ValkyrieLoopWhileLet) {
        visitPsiElement(o)
    }

    open fun visitMacroCall(o: ValkyrieMacroCall) {
        visitPsiElement(o)
    }

    open fun visitMacroCallInline(o: ValkyrieMacroCallInline) {
        visitPsiElement(o)
    }

    open fun visitMacroPath(o: ValkyrieMacroPath) {
        visitNamepathSafe(o)
    }

    open fun visitMatchBind(o: ValkyrieMatchBind) {
        visitPsiElement(o)
    }

    open fun visitMatchBody(o: ValkyrieMatchBody) {
        visitPsiElement(o)
    }

    open fun visitMatchCase(o: ValkyrieMatchCase) {
        visitPsiElement(o)
    }

    open fun visitMatchElse(o: ValkyrieMatchElse) {
        visitPsiElement(o)
    }

    open fun visitMatchKind(o: ValkyrieMatchKind) {
        visitPsiElement(o)
    }

    open fun visitMatchStatement(o: ValkyrieMatchStatement) {
        visitPsiElement(o)
    }

    open fun visitMatchType(o: ValkyrieMatchType) {
        visitPsiElement(o)
    }

    open fun visitMatchWhen(o: ValkyrieMatchWhen) {
        visitPsiElement(o)
    }

    open fun visitMatchWith(o: ValkyrieMatchWith) {
        visitPsiElement(o)
    }

    open fun visitMatchWithControl(o: ValkyrieMatchWithControl) {
        visitPsiElement(o)
    }

    open fun visitMatchWithProvide(o: ValkyrieMatchWithProvide) {
        visitPsiElement(o)
    }

    open fun visitMayLetStatement(o: ValkyrieMayLetStatement) {
        visitPsiElement(o)
    }

    open fun visitModifier(o: ValkyrieModifier) {
        visitPsiElement(o)
    }

    open fun visitNamepathAuto(o: ValkyrieNamepathAuto) {
        visitPsiElement(o)
    }

    open fun visitNamepathFree(o: ValkyrieNamepathFree) {
        visitPsiElement(o)
    }

    open fun visitNamepathSafe(o: ValkyrieNamepathSafe) {
        visitPsiElement(o)
    }

    open fun visitNewBind(o: ValkyrieNewBind) {
        visitPsiElement(o)
    }

    open fun visitNewBody(o: ValkyrieNewBody) {
        visitPsiElement(o)
    }

    open fun visitNewLambda(o: ValkyrieNewLambda) {
        visitPsiElement(o)
    }

    open fun visitNewObject(o: ValkyrieNewObject) {
        visitPsiElement(o)
    }

    open fun visitNewValue(o: ValkyrieNewValue) {
        visitPsiElement(o)
    }

    open fun visitNumberLiteral(o: ValkyrieNumberLiteral) {
        visitPsiElement(o)
    }

    open fun visitOffsetRange(o: ValkyrieOffsetRange) {
        visitPsiElement(o)
    }

    open fun visitOffsetSlice(o: ValkyrieOffsetSlice) {
        visitPsiElement(o)
    }

    open fun visitOrdinalRange(o: ValkyrieOrdinalRange) {
        visitPsiElement(o)
    }

    open fun visitOrdinalSlice(o: ValkyrieOrdinalSlice) {
        visitPsiElement(o)
    }

    open fun visitParameterBody(o: ValkyrieParameterBody) {
        visitPsiElement(o)
    }

    open fun visitParameterDict(o: ValkyrieParameterDict) {
        visitPsiElement(o)
    }

    open fun visitParameterItem(o: ValkyrieParameterItem) {
        visitPsiElement(o)
    }

    open fun visitParameterKind(o: ValkyrieParameterKind) {
        visitPsiElement(o)
    }

    open fun visitParameterList(o: ValkyrieParameterList) {
        visitPsiElement(o)
    }

    open fun visitPrefix(o: ValkyriePrefix) {
        visitPsiElement(o)
    }

    open fun visitPrefixDeref(o: ValkyriePrefixDeref) {
        visitPsiElement(o)
    }

    open fun visitPrefixNot(o: ValkyriePrefixNot) {
        visitPsiElement(o)
    }

    open fun visitPrefixRef(o: ValkyriePrefixRef) {
        visitPsiElement(o)
    }

    open fun visitRangeIndex(o: ValkyrieRangeIndex) {
        visitPsiElement(o)
    }

    open fun visitRangeItem(o: ValkyrieRangeItem) {
        visitPsiElement(o)
    }

    open fun visitRangeLower(o: ValkyrieRangeLower) {
        visitPsiElement(o)
    }

    open fun visitRangeStep(o: ValkyrieRangeStep) {
        visitPsiElement(o)
    }

    open fun visitRangeUpper(o: ValkyrieRangeUpper) {
        visitPsiElement(o)
    }

    open fun visitReturnType(o: ValkyrieReturnType) {
        visitPsiElement(o)
    }

    open fun visitRunBenchmark(o: ValkyrieRunBenchmark) {
        visitPsiElement(o)
    }

    open fun visitRunTestCast(o: ValkyrieRunTestCast) {
        visitPsiElement(o)
    }

    open fun visitSlot(o: ValkyrieSlot) {
        visitPsiElement(o)
    }

    open fun visitSlotFirst(o: ValkyrieSlotFirst) {
        visitPsiElement(o)
    }

    open fun visitSlotIndex(o: ValkyrieSlotIndex) {
        visitPsiElement(o)
    }

    open fun visitSlotNamed(o: ValkyrieSlotNamed) {
        visitPsiElement(o)
    }

    open fun visitSpecial(o: ValkyrieSpecial) {
        visitPsiElement(o)
    }

    open fun visitStatements(o: ValkyrieStatements) {
        visitPsiElement(o)
    }

    open fun visitString(o: ValkyrieString) {
        visitPsiElement(o)
    }

    open fun visitSuffix(o: ValkyrieSuffix) {
        visitPsiElement(o)
    }

    open fun visitTemplateEnd(o: ValkyrieTemplateEnd) {
        visitPsiElement(o)
    }

    open fun visitTerm(o: ValkyrieTerm) {
        visitPsiElement(o)
    }

    open fun visitTestsBody(o: ValkyrieTestsBody) {
        visitPsiElement(o)
    }

    open fun visitThenStatement(o: ValkyrieThenStatement) {
        visitPsiElement(o)
    }

    open fun visitTraitAlias(o: ValkyrieTraitAlias) {
        visitPsiElement(o)
    }

    open fun visitTraitDefine(o: ValkyrieTraitDefine) {
        visitPsiElement(o)
    }

    open fun visitTryLetStatement(o: ValkyrieTryLetStatement) {
        visitPsiElement(o)
    }

    open fun visitTryNotStatement(o: ValkyrieTryNotStatement) {
        visitPsiElement(o)
    }

    open fun visitTryStatement(o: ValkyrieTryStatement) {
        visitPsiElement(o)
    }

    open fun visitTupleArgument(o: ValkyrieTupleArgument) {
        visitPsiElement(o)
    }

    open fun visitTypeAlias(o: ValkyrieTypeAlias) {
        visitPsiElement(o)
    }

    open fun visitTypeAtomic(o: ValkyrieTypeAtomic) {
        visitPsiElement(o)
    }

    open fun visitTypeExpression(o: ValkyrieTypeExpression) {
        visitPsiElement(o)
    }

    open fun visitTypeFunction(o: ValkyrieTypeFunction)
    {
        visitPsiElement(o)
    }

    open fun visitTypeHint(o: ValkyrieTypeHint) {
        visitPsiElement(o)
    }

    open fun visitTypeInfix(o: ValkyrieTypeInfix) {
        visitPsiElement(o)
    }

    open fun visitTypePattern(o: ValkyrieTypePattern) {
        visitPsiElement(o)
    }

    open fun visitTypePatternInline(o: ValkyrieTypePatternInline) {
        visitPsiElement(o)
    }

    open fun visitTypePatternItem(o: ValkyrieTypePatternItem) {
        visitPsiElement(o)
    }

    open fun visitTypePatternObject(o: ValkyrieTypePatternObject) {
        visitPsiElement(o)
    }

    open fun visitTypePatternPair(o: ValkyrieTypePatternPair) {
        visitPsiElement(o)
    }

    open fun visitTypePatternTuple(o: ValkyrieTypePatternTuple) {
        visitPsiElement(o)
    }

    open fun visitTypePrefix(o: ValkyrieTypePrefix) {
        visitPsiElement(o)
    }

    open fun visitTypeSuffix(o: ValkyrieTypeSuffix) {
        visitPsiElement(o)
    }

    open fun visitTypeTerm(o: ValkyrieTypeTerm) {
        visitPsiElement(o)
    }

    open fun visitTypeTuple(o: ValkyrieTypeTuple) {
        visitPsiElement(o)
    }

    open fun visitUniteBody(o: ValkyrieUniteBody) {
        visitPsiElement(o)
    }

    open fun visitUnused(o: ValkyrieUnused) {
        visitPsiElement(o)
    }

    open fun visitUsingAlias(o: ValkyrieUsingAlias) {
        visitPsiElement(o)
    }

    open fun visitUsingAny(o: ValkyrieUsingAny) {
        visitPsiElement(o)
    }

    open fun visitUsingBlock(o: ValkyrieUsingBlock) {
        visitPsiElement(o)
    }

    open fun visitUsingBody(o: ValkyrieUsingBody) {
        visitPsiElement(o)
    }

    open fun visitUsingExclude(o: ValkyrieUsingExclude) {
        visitPsiElement(o)
    }

    open fun visitUsingStatement(o: ValkyrieUsingStatement) {
        visitPsiElement(o)
    }

    open fun visitUsingTerm(o: ValkyrieUsingTerm) {
        visitPsiElement(o)
    }

    open fun visitWhereCondition(o: ValkyrieWhereCondition) {
        visitPsiElement(o)
    }

    open fun visitWhereTerm(o: ValkyrieWhereTerm) {
        visitPsiElement(o)
    }

    open fun visitPsiElement(o: PsiElement) {
        visitElement(o)
    }
}