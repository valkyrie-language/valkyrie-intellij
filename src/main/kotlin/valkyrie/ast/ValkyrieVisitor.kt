package valkyrie.ast

import com.intellij.openapi.progress.ProgressIndicatorProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.node.*
import valkyrie.ast.node.ValkyrieInheritItemNode
import valkyrie.ast.node.ValkyrieTypeAtomicNode
import valkyrie.ast.node.ValkyrieTypeExpressionNode
import valkyrie.psi.node.*

open class ValkyrieVisitor : PsiElementVisitor() {
    open fun visitAnnotations(o: ValkyrieAnnotations) {
        visitElement(o)
    }

    open fun visitArgument(o: ValkyrieArgument) {
        visitElement(o)
    }

    open fun visitArgumentBody(o: ValkyrieArgumentBody) {
        visitElement(o)
    }

    open fun visitAssociatedType(o: ValkyrieAssociatedType) {
        visitElement(o)
    }

    open fun visitAttributeAbove(o: ValkyrieAttributeAbove) {
        visitElement(o)
    }

    open fun visitAttributeBelow(o: ValkyrieAttributeBelow) {
        visitElement(o)
    }

    open fun visitAttributeItem(o: ValkyrieAttributeItem) {
        visitElement(o)
    }

    open fun visitAttributeList(o: ValkyrieAttributeList) {
        visitElement(o)
    }

    open fun visitBadLl(o: ValkyrieBadLl) {
        visitElement(o)
    }

    open fun visitBadLll(o: ValkyrieBadLll) {
        visitElement(o)
    }

    open fun visitBadRr(o: ValkyrieBadRr) {
        visitElement(o)
    }

    open fun visitBadRrr(o: ValkyrieBadRrr) {
        visitElement(o)
    }

    open fun visitBarePattern(o: ValkyrieBarePattern) {
        visitElement(o)
    }

    open fun visitBarePatternItem(o: ValkyrieBarePatternItem) {
        visitElement(o)
    }

    open fun visitBenchmarkBody(o: ValkyrieBenchmarkBody) {
        visitElement(o)
    }

    open fun visitBenchmarkUnit(o: ValkyrieBenchmarkUnit) {
        visitElement(o)
    }

    open fun visitBlockBare(o: ValkyrieBlockBare) {
        visitElement(o)
    }

    open fun visitBlockBody(o: ValkyrieBlockBody) {
        visitElement(o)
    }

    open fun visitCasePattern(o: ValkyrieCasePattern) {
        visitElement(o)
    }

    open fun visitCasePatternBind(o: ValkyrieCasePatternBind) {
        visitElement(o)
    }

    open fun visitCasePatternDict(o: ValkyrieCasePatternDict) {
        visitElement(o)
    }

    open fun visitCasePatternItem(o: ValkyrieCasePatternItem) {
        visitElement(o)
    }

    open fun visitCasePatternKind(o: ValkyrieCasePatternKind) {
        visitElement(o)
    }

    open fun visitCasePatternList(o: ValkyrieCasePatternList) {
        visitElement(o)
    }

    open fun visitCasePatternMain(o: ValkyrieCasePatternMain) {
        visitElement(o)
    }

    open fun visitCasePatternPair(o: ValkyrieCasePatternPair) {
        visitElement(o)
    }

    open fun visitCasePatternRest(o: ValkyrieCasePatternRest) {
        visitElement(o)
    }

    open fun visitCasePatternTop(o: ValkyrieCasePatternTop) {
        visitElement(o)
    }

    open fun visitClassBody(o: ValkyrieClassBody) {
        visitElement(o)
    }

    open fun visitClassInherit(o: ValkyrieClassInherit) {
        visitElement(o)
    }

    open fun visitControlBreak(o: ValkyrieControlBreak) {
        visitElement(o)
    }

    open fun visitControlContinue(o: ValkyrieControlContinue) {
        visitElement(o)
    }

    open fun visitControlLabel(o: ValkyrieControlLabel) {
        visitElement(o)
    }

    open fun visitControlRaise(o: ValkyrieControlRaise) {
        visitElement(o)
    }

    open fun visitControlResume(o: ValkyrieControlResume) {
        visitElement(o)
    }

    open fun visitControlReturn(o: ValkyrieControlReturn) {
        visitElement(o)
    }

    open fun visitControlStatement(o: ValkyrieControlStatement) {
        visitElement(o)
    }

    open fun visitControlThrough(o: ValkyrieControlThrough) {
        visitElement(o)
    }

    open fun visitControlYieldFrom(o: ValkyrieControlYieldFrom) {
        visitElement(o)
    }

    open fun visitControlYieldSend(o: ValkyrieControlYieldSend) {
        visitElement(o)
    }

    open fun visitControlYieldStop(o: ValkyrieControlYieldStop) {
        visitElement(o)
    }

    open fun visitControlYieldType(o: ValkyrieControlYieldType) {
        visitElement(o)
    }

    open fun visitDeclareClass(o: ValkyrieClassDeclarationNode) {
        visitElement(o)
    }

    open fun visitDeclareComponent(o: ValkyrieDeclareComponent) {
        visitElement(o)
    }

    open fun visitDeclareDomain(o: ValkyrieDeclareDomain) {
        visitElement(o)
    }

    open fun visitDeclareEnums(o: ValkyrieDeclareEnums) {
        visitElement(o)
    }

    open fun visitDeclareField(o: ValkyrieDeclareField) {
        visitElement(o)
    }

    open fun visitDeclareFlags(o: ValkyrieDeclareFlags) {
        visitElement(o)
    }

    open fun visitDeclareFunction(o: ValkyrieDeclareFunction) {
        visitElement(o)
    }

    open fun visitDeclareGeneric(o: ValkyrieDeclareGeneric) {
        visitElement(o)
    }

    open fun visitDeclareImply(o: ValkyrieDeclareImply) {
        visitElement(o)
    }

    open fun visitDeclareInfer(o: ValkyrieDeclareInfer) {
        visitElement(o)
    }

    open fun visitDeclareMacro(o: ValkyrieDeclareMacro) {
        visitElement(o)
    }

    open fun visitDeclareMethod(o: ValkyrieDeclareMethod) {
        visitElement(o)
    }

    open fun visitDeclareMezzo(o: ValkyrieDeclareMezzo) {
        visitElement(o)
    }

    open fun visitDeclareNamespace(o: ValkyrieDeclareNamespace) {
        visitElement(o)
    }

    open fun visitDeclareNeural(o: ValkyrieDeclareNeural) {
        visitElement(o)
    }

    open fun visitDeclareSemantic(o: ValkyrieDeclareSemantic) {
        visitElement(o)
    }

    open fun visitDeclareSingleton(o: ValkyrieDeclareSingleton) {
        visitElement(o)
    }

    open fun visitDeclareTests(o: ValkyrieDeclareTests) {
        visitElement(o)
    }

    open fun visitDeclareTrait(o: ValkyrieDeclareTrait) {
        visitElement(o)
    }

    open fun visitDeclareType(o: ValkyrieDeclareType) {
        visitElement(o)
    }

    open fun visitDeclareUnion(o: ValkyrieDeclareUnion) {
        visitElement(o)
    }

    open fun visitDeclareUnite(o: ValkyrieDeclareUnite) {
        visitElement(o)
    }

    open fun visitDeclareVariant(o: ValkyrieDeclareVariant) {
        visitElement(o)
    }

    open fun visitDeclareWhere(o: ValkyrieDeclareWhere) {
        visitElement(o)
    }

    open fun visitDefaultType(o: ValkyrieDefaultType) {
        visitElement(o)
    }

    open fun visitDefaultValue(o: ValkyrieDefaultValue) {
        visitElement(o)
    }

    open fun visitDotCall(o: ValkyrieDotCall) {
        visitElement(o)
    }

    open fun visitDotCallInline(o: ValkyrieDotCallInline) {
        visitElement(o)
    }

    open fun visitDotCallMacro(o: ValkyrieDotCallMacro) {
        visitElement(o)
    }

    open fun visitDotCallMacroInline(o: ValkyrieDotCallMacroInline) {
        visitElement(o)
    }

    open fun visitDotLoopCall(o: ValkyrieDotLoopCall) {
        visitElement(o)
    }

    open fun visitDotMatchCall(o: ValkyrieDotMatchCall) {
        visitElement(o)
    }

    open fun visitElseIfStatement(o: ValkyrieElseIfStatement) {
        visitElement(o)
    }

    open fun visitElseStatement(o: ValkyrieElseStatement) {
        visitElement(o)
    }

    open fun visitElseTemplate(o: ValkyrieElseTemplate) {
        visitElement(o)
    }

    open fun visitExpression(o: ValkyrieExpression) {
        visitElement(o)
    }

    open fun visitExpressionInline(o: ValkyrieExpressionInline) {
        visitElement(o)
    }

    open fun visitExpressionRoot(o: ValkyrieExpressionRoot) {
        visitElement(o)
    }

    open fun visitFlagsBody(o: ValkyrieFlagsBody) {
        visitElement(o)
    }

    open fun visitFunctionCall(o: ValkyrieFunctionCall) {
        visitElement(o)
    }

    open fun visitFunctionCallInline(o: ValkyrieFunctionCallInline) {
        visitElement(o)
    }

    open fun visitGenericArgument(o: ValkyrieGenericArgument) {
        visitElement(o)
    }

    open fun visitGenericCall(o: ValkyrieGenericCall) {
        visitElement(o)
    }

    open fun visitGenericCallFree(o: ValkyrieGenericCallFree) {
        visitElement(o)
    }

    open fun visitGenericParameter(o: ValkyrieGenericParameter) {
        visitElement(o)
    }

    open fun visitIdentifierFree(o: ValkyrieIdentifierFree) {
        visitElement(o)
    }

    open fun visitIdentifierSafe(o: ValkyrieIdentifierSafe) {
        visitElement(o)
    }

    open fun visitIfCondition(o: ValkyrieIfCondition) {
        visitElement(o)
    }

    open fun visitIfStatement(o: ValkyrieIfStatement) {
        visitElement(o)
    }

    open fun visitInferBody(o: ValkyrieInferBody) {
        visitElement(o)
    }

    open fun visitInfix(o: ValkyrieInfix) {
        visitElement(o)
    }

    open fun visitInfixGreater(o: ValkyrieInfixGreater) {
        visitElement(o)
    }

    open fun visitInfixGreaterEqual(o: ValkyrieInfixGreaterEqual) {
        visitElement(o)
    }

    open fun visitInfixLess(o: ValkyrieInfixLess) {
        visitElement(o)
    }

    open fun visitInfixLessEqual(o: ValkyrieInfixLessEqual) {
        visitElement(o)
    }

    open fun visitInfixLogical(o: ValkyrieInfixLogical) {
        visitElement(o)
    }

    open fun visitInfixMultiple(o: ValkyrieInfixMultiple) {
        visitElement(o)
    }

    open fun visitInheritList(o: ValkyrieInheritListNode) {
        visitElement(o)
    }

    open fun visitInheritItem(o: ValkyrieInheritItemNode) {
        visitElement(o)
    }

    open fun visitInlineAtomic(o: ValkyrieInlineAtomic) {
        visitElement(o)
    }

    open fun visitInlineSuffix(o: ValkyrieInlineSuffix) {
        visitElement(o)
    }

    open fun visitInlineTerm(o: ValkyrieInlineTerm) {
        visitElement(o)
    }

    open fun visitIsExpression(o: ValkyrieIsExpression) {
        visitElement(o)
    }

    open fun visitIsStatement(o: ValkyrieIsStatement) {
        visitElement(o)
    }

    open fun visitLetPattern(o: ValkyrieLetPattern) {
        visitElement(o)
    }

    open fun visitLetStatement(o: ValkyrieLetStatement) {
        visitElement(o)
    }

    open fun visitLocalizeCall(o: ValkyrieLocalizeCall) {
        visitElement(o)
    }

    open fun visitLoopCondition(o: ValkyrieLoopCondition) {
        visitElement(o)
    }

    open fun visitLoopEach(o: ValkyrieLoopEach) {
        visitElement(o)
    }

    open fun visitLoopInline(o: ValkyrieLoopInline) {
        visitElement(o)
    }

    open fun visitLoopMatch(o: ValkyrieLoopMatch) {
        visitElement(o)
    }

    open fun visitLoopStart(o: ValkyrieLoopStart) {
        visitElement(o)
    }

    open fun visitLoopStatement(o: ValkyrieLoopStatement) {
        visitElement(o)
    }

    open fun visitLoopTemplate(o: ValkyrieLoopTemplate) {
        visitElement(o)
    }

    open fun visitLoopTemplateStart(o: ValkyrieLoopTemplateStart) {
        visitElement(o)
    }

    open fun visitLoopUntil(o: ValkyrieLoopUntil) {
        visitElement(o)
    }

    open fun visitLoopUntilNot(o: ValkyrieLoopUntilNot) {
        visitElement(o)
    }

    open fun visitLoopWhile(o: ValkyrieLoopWhile) {
        visitElement(o)
    }

    open fun visitLoopWhileLet(o: ValkyrieLoopWhileLet) {
        visitElement(o)
    }

    open fun visitMacroCall(o: ValkyrieMacroCall) {
        visitElement(o)
    }

    open fun visitMacroCallInline(o: ValkyrieMacroCallInline) {
        visitElement(o)
    }

    open fun visitMacroPath(o: ValkyrieMacroPath) {
        visitNamepathSafe(o)
    }

    open fun visitMatchBind(o: ValkyrieMatchBind) {
        visitElement(o)
    }

    open fun visitMatchBody(o: ValkyrieMatchBody) {
        visitElement(o)
    }

    open fun visitMatchCase(o: ValkyrieMatchCase) {
        visitElement(o)
    }

    open fun visitMatchElse(o: ValkyrieMatchElse) {
        visitElement(o)
    }

    open fun visitMatchKind(o: ValkyrieMatchKind) {
        visitElement(o)
    }

    open fun visitMatchStatement(o: ValkyrieMatchStatement) {
        visitElement(o)
    }

    open fun visitMatchType(o: ValkyrieMatchType) {
        visitElement(o)
    }

    open fun visitMatchWhen(o: ValkyrieMatchWhen) {
        visitElement(o)
    }

    open fun visitMatchWith(o: ValkyrieMatchWith) {
        visitElement(o)
    }

    open fun visitMatchWithControl(o: ValkyrieMatchWithControl) {
        visitElement(o)
    }

    open fun visitMatchWithProvide(o: ValkyrieMatchWithProvide) {
        visitElement(o)
    }

    open fun visitMayLetStatement(o: ValkyrieMayLetStatement) {
        visitElement(o)
    }

    open fun visitModifier(o: ValkyrieModifier) {
        visitElement(o)
    }

    open fun visitNamepathAuto(o: ValkyrieNamepathAuto) {
        visitElement(o)
    }

    open fun visitNamepathFree(o: ValkyrieNamepathFree) {
        visitElement(o)
    }

    open fun visitNamepathSafe(o: ValkyrieNamepathSafe) {
        visitElement(o)
    }

    open fun visitNewBind(o: ValkyrieNewBind) {
        visitElement(o)
    }

    open fun visitNewBody(o: ValkyrieNewBody) {
        visitElement(o)
    }

    open fun visitNewLambda(o: ValkyrieNewLambda) {
        visitElement(o)
    }

    open fun visitNewObject(o: ValkyrieNewObject) {
        visitElement(o)
    }

    open fun visitNewValue(o: ValkyrieNewValue) {
        visitElement(o)
    }

    open fun visitNumberLiteral(o: ValkyrieNumberLiteral) {
        visitElement(o)
    }

    open fun visitOffsetRange(o: ValkyrieOffsetRange) {
        visitElement(o)
    }

    open fun visitOffsetSlice(o: ValkyrieOffsetSlice) {
        visitElement(o)
    }

    open fun visitOrdinalRange(o: ValkyrieOrdinalRange) {
        visitElement(o)
    }

    open fun visitOrdinalSlice(o: ValkyrieOrdinalSlice) {
        visitElement(o)
    }

    open fun visitParameterBody(o: ValkyrieParameterBody) {
        visitElement(o)
    }

    open fun visitParameterDict(o: ValkyrieParameterDict) {
        visitElement(o)
    }

    open fun visitParameterItem(o: ValkyrieParameterItem) {
        visitElement(o)
    }

    open fun visitParameterKind(o: ValkyrieParameterKind) {
        visitElement(o)
    }

    open fun visitParameterList(o: ValkyrieParameterList) {
        visitElement(o)
    }

    open fun visitPrefix(o: ValkyriePrefix) {
        visitElement(o)
    }

    open fun visitPrefixDeref(o: ValkyriePrefixDeref) {
        visitElement(o)
    }

    open fun visitPrefixNot(o: ValkyriePrefixNot) {
        visitElement(o)
    }

    open fun visitPrefixRef(o: ValkyriePrefixRef) {
        visitElement(o)
    }

    open fun visitRangeIndex(o: ValkyrieRangeIndex) {
        visitElement(o)
    }

    open fun visitRangeItem(o: ValkyrieRangeItem) {
        visitElement(o)
    }

    open fun visitRangeLower(o: ValkyrieRangeLower) {
        visitElement(o)
    }

    open fun visitRangeStep(o: ValkyrieRangeStep) {
        visitElement(o)
    }

    open fun visitRangeUpper(o: ValkyrieRangeUpper) {
        visitElement(o)
    }

    open fun visitReturnType(o: ValkyrieReturnType) {
        visitElement(o)
    }

    open fun visitRunBenchmark(o: ValkyrieRunBenchmark) {
        visitElement(o)
    }

    open fun visitRunTestCast(o: ValkyrieRunTestCast) {
        visitElement(o)
    }

    open fun visitSlot(o: ValkyrieSlot) {
        visitElement(o)
    }

    open fun visitSlotFirst(o: ValkyrieSlotFirst) {
        visitElement(o)
    }

    open fun visitSlotIndex(o: ValkyrieSlotIndex) {
        visitElement(o)
    }

    open fun visitSlotNamed(o: ValkyrieSlotNamed) {
        visitElement(o)
    }

    open fun visitSpecial(o: ValkyrieSpecial) {
        visitElement(o)
    }

    open fun visitStatements(o: ValkyrieStatements) {
        visitElement(o)
    }

    open fun visitString(o: ValkyrieString) {
        visitElement(o)
    }

    open fun visitSuffix(o: ValkyrieSuffix) {
        visitElement(o)
    }

    open fun visitTemplateEnd(o: ValkyrieTemplateEnd) {
        visitElement(o)
    }

    open fun visitTermExpression(o: ValkyrieTermExpressionNode) {
        visitElement(o)
    }

    open fun visitTermBinary(o: ValkyrieTermBinaryNode) {
        visitElement(o)
    }

    open fun visitTermUnary(o: ValkyrieTermUnaryNode) {
        visitElement(o)
    }

    open fun visitTermAtomic(o: ValkyrieTermAtomicNode) {
        visitElement(o)
    }

    open fun visitTestsBody(o: ValkyrieTestsBody) {
        visitElement(o)
    }

    open fun visitThenStatement(o: ValkyrieThenStatement) {
        visitElement(o)
    }

    open fun visitTraitAlias(o: ValkyrieTraitAlias) {
        visitElement(o)
    }

    open fun visitTraitDefine(o: ValkyrieTraitDefine) {
        visitElement(o)
    }

    open fun visitTryLetStatement(o: ValkyrieTryLetStatement) {
        visitElement(o)
    }

    open fun visitTryNotStatement(o: ValkyrieTryNotStatement) {
        visitElement(o)
    }

    open fun visitTryStatement(o: ValkyrieTryStatement) {
        visitElement(o)
    }

    open fun visitTupleArgument(o: ValkyrieTupleArgument) {
        visitElement(o)
    }

    open fun visitTypeAlias(o: ValkyrieTypeAlias) {
        visitElement(o)
    }

    open fun visitTypeExpression(o: ValkyrieTypeExpressionNode) {
        visitElement(o)
    }

    open fun visitTypeBinary(o: ValkyrieTypeBinaryNode) {
        visitElement(o)
    }

    open fun visitTypeUnary(o: ValkyrieTypeUnaryNode) {
        visitElement(o)
    }

    open fun visitTypeAtomic(o: ValkyrieTypeAtomicNode) {
        visitElement(o)
    }

    open fun visitTypeFunction(o: ValkyrieTypeFunction) {
        visitElement(o)
    }

    open fun visitTypeHint(o: ValkyrieTypeHint) {
        visitElement(o)
    }

    open fun visitTypeInfix(o: ValkyrieTypeInfix) {
        visitElement(o)
    }

    open fun visitTypePattern(o: ValkyrieTypePattern) {
        visitElement(o)
    }

    open fun visitTypePatternInline(o: ValkyrieTypePatternInline) {
        visitElement(o)
    }

    open fun visitTypePatternItem(o: ValkyrieTypePatternItem) {
        visitElement(o)
    }

    open fun visitTypePatternObject(o: ValkyrieTypePatternObject) {
        visitElement(o)
    }

    open fun visitTypePatternPair(o: ValkyrieTypePatternPair) {
        visitElement(o)
    }

    open fun visitTypePatternTuple(o: ValkyrieTypePatternTuple) {
        visitElement(o)
    }

    open fun visitTypePrefix(o: ValkyrieTypePrefix) {
        visitElement(o)
    }

    open fun visitTypeSuffix(o: ValkyrieTypeSuffix) {
        visitElement(o)
    }

    open fun visitTypeTerm(o: ValkyrieTypeTerm) {
        visitElement(o)
    }

    open fun visitTypeTuple(o: ValkyrieTypeTuple) {
        visitElement(o)
    }

    open fun visitUniteBody(o: ValkyrieUniteBody) {
        visitElement(o)
    }

    open fun visitUnused(o: ValkyrieUnused) {
        visitElement(o)
    }

    open fun visitUsingAlias(o: ValkyrieUsingAlias) {
        visitElement(o)
    }

    open fun visitUsingAny(o: ValkyrieUsingAny) {
        visitElement(o)
    }

    open fun visitUsingBlock(o: ValkyrieUsingBlock) {
        visitElement(o)
    }

    open fun visitUsingBody(o: ValkyrieUsingBody) {
        visitElement(o)
    }

    open fun visitUsingExclude(o: ValkyrieUsingExclude) {
        visitElement(o)
    }

    open fun visitUsingStatement(o: ValkyrieUsingStatement) {
        visitElement(o)
    }

    open fun visitUsingTerm(o: ValkyrieUsingTerm) {
        visitElement(o)
    }

    open fun visitWhereCondition(o: ValkyrieWhereCondition) {
        visitElement(o)
    }

    open fun visitWhereTerm(o: ValkyrieWhereTerm) {
        visitElement(o)
    }

    override fun visitElement(element: PsiElement) {
        ProgressIndicatorProvider.checkCanceled()
    }
}