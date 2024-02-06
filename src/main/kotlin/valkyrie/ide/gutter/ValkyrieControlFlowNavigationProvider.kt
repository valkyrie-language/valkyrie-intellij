package valkyrie.ide.gutter

import com.intellij.codeInsight.daemon.LineMarkerInfo
import com.intellij.codeInsight.daemon.LineMarkerProvider
import com.intellij.codeInsight.navigation.NavigationGutterIconBuilder
import com.intellij.openapi.editor.markup.GutterIconRenderer
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.language.ValkyrieIcons
import valkyrie.psi.nodes.*

/**
 * 控制流语句的导航提供器
 * 为控制流语句提供左侧图标标记和相互跳转功能
 */
class ValkyrieControlFlowNavigationProvider : LineMarkerProvider {
    
    private val effectAnalyzer = ValkyrieEffectAnalyzer()

    override fun getLineMarkerInfo(element: PsiElement): LineMarkerInfo<*>? {
        return when (element) {
            is ValkyrieControlFlowNodes -> createLoopMarker(element)
            is ValkyrieReturnStatement -> createReturnMarker(element)
            is ValkyrieBreakStatement -> createBreakMarker(element)
            is ValkyrieContinueStatement -> createContinueMarker(element)
            is ValkyrieYieldStatement -> createYieldMarker(element)
            is ValkyrieRaiseStatement -> createRaiseMarker(element)
            is ValkyrieCatchCase -> createCatchMarker(element)
            else -> null
        }
    }

    private fun createLoopMarker(element: ValkyrieControlFlowNodes): LineMarkerInfo<PsiElement> {
        val relatedElements = findRelatedControlFlowElements(element)
        return NavigationGutterIconBuilder
            .create(ValkyrieIcons.LOOP)
            .setAlignment(GutterIconRenderer.Alignment.LEFT)
            .setTooltipText("Loop statement - Click to navigate to related break/continue")
            .setTargets(relatedElements)
            .createLineMarkerInfo(element)
    }

    private fun createReturnMarker(element: ValkyrieReturnStatement): LineMarkerInfo<PsiElement> {
        val functionElement = findContainingFunction(element)
        val targets = if (functionElement != null) listOf(functionElement) else emptyList()
        
        return NavigationGutterIconBuilder
            .create(ValkyrieIcons.RETURN)
            .setAlignment(GutterIconRenderer.Alignment.LEFT)
            .setTooltipText("Return statement - Click to navigate to function")
            .setTargets(targets)
            .createLineMarkerInfo(element)
    }

    private fun createBreakMarker(element: ValkyrieBreakStatement): LineMarkerInfo<PsiElement> {
        val loopElement = findTargetLoop(element)
        val targets = if (loopElement != null) listOf(loopElement) else emptyList()
        
        return NavigationGutterIconBuilder
            .create(ValkyrieIcons.BREAK)
            .setAlignment(GutterIconRenderer.Alignment.LEFT)
            .setTooltipText("Break statement - Click to navigate to target loop")
            .setTargets(targets)
            .createLineMarkerInfo(element)
    }

    private fun createContinueMarker(element: ValkyrieContinueStatement): LineMarkerInfo<PsiElement> {
        val loopElement = findTargetLoop(element)
        val targets = if (loopElement != null) listOf(loopElement) else emptyList()
        
        return NavigationGutterIconBuilder
            .create(ValkyrieIcons.CONTINUE)
            .setAlignment(GutterIconRenderer.Alignment.LEFT)
            .setTooltipText("Continue statement - Click to navigate to target loop")
            .setTargets(targets)
            .createLineMarkerInfo(element)
    }

    private fun createYieldMarker(element: ValkyrieYieldStatement): LineMarkerInfo<PsiElement> {
        val functionElement = findContainingFunction(element)
        val targets = if (functionElement != null) listOf(functionElement) else emptyList()
        
        return NavigationGutterIconBuilder
            .create(ValkyrieIcons.YIELD)
            .setAlignment(GutterIconRenderer.Alignment.LEFT)
            .setTooltipText("Yield statement - Click to navigate to generator function")
            .setTargets(targets)
            .createLineMarkerInfo(element)
    }

    private fun createRaiseMarker(element: ValkyrieRaiseStatement): LineMarkerInfo<PsiElement> {
        val relatedCatches = findRelatedCatchCases(element)
        val targets = relatedCatches.map { it as PsiElement }
        
        return NavigationGutterIconBuilder.create(ValkyrieIcons.RAISE)
            .setAlignment(GutterIconRenderer.Alignment.LEFT)
            .setTooltipText("Raise statement - Jump to catch cases (${targets.size})")
            .setTargets(targets)
            .createLineMarkerInfo(element)
    }

    private fun createCatchMarker(element: ValkyrieCatchCase): LineMarkerInfo<PsiElement> {
        val relatedRaises = effectAnalyzer.findRelatedRaiseStatements(element)
        val targets = relatedRaises.map { it as PsiElement }
        
        return NavigationGutterIconBuilder.create(ValkyrieIcons.CATCH)
            .setAlignment(GutterIconRenderer.Alignment.LEFT)
            .setTooltipText("Catch case - Jump to raise statements (${targets.size})")
            .setTargets(targets)
            .createLineMarkerInfo(element)
    }

    /**
     * 查找与循环相关的控制流元素（break/continue）
     */
    private fun findRelatedControlFlowElements(loopElement: ValkyrieControlFlowNodes): List<PsiElement> {
        val relatedElements = mutableListOf<PsiElement>()
        
        // 查找循环体内的 break 和 continue 语句
        val loopBody = loopElement.getBody()
        if (loopBody != null) {
            val breakStatements = PsiTreeUtil.findChildrenOfType(loopBody, ValkyrieBreakStatement::class.java)
            val continueStatements = PsiTreeUtil.findChildrenOfType(loopBody, ValkyrieContinueStatement::class.java)
            
            relatedElements.addAll(breakStatements)
            relatedElements.addAll(continueStatements)
        }
        
        return relatedElements
    }

    /**
     * 查找包含当前元素的函数
     */
    private fun findContainingFunction(element: PsiElement): PsiElement? {
        return PsiTreeUtil.getParentOfType(element, ValkyrieMethodDeclaration::class.java)
    }

    /**
     * 查找 break/continue 语句的目标循环
     */
    private fun findTargetLoop(element: PsiElement): PsiElement? {
        // 简单实现：查找最近的包含循环
        return PsiTreeUtil.getParentOfType(element, ValkyrieControlFlowNodes::class.java)
    }

    /**
     * 查找与 raise 语句相关的 catch case
     */
    private fun findRelatedCatchCases(raiseElement: ValkyrieRaiseStatement): List<ValkyrieCatchCase> {
        // 使用效果分析器进行精确匹配
        val containingFunction = PsiTreeUtil.getParentOfType(raiseElement, ValkyrieMethodDeclaration::class.java)
        return if (containingFunction != null) {
            val effectPairs = effectAnalyzer.analyzeEffects(containingFunction)
            effectPairs.find { it.raiseElement == raiseElement }?.catchElements ?: emptyList()
        } else {
            emptyList()
        }
    }

    /**
     * 查找与 catch case 相关的 raise 语句
     */
    private fun findRelatedRaiseStatements(catchElement: ValkyrieCatchCase): List<PsiElement> {
        val relatedRaises = mutableListOf<PsiElement>()
        
        // 查找包含当前 catch 的函数或代码块
        val containingFunction = findContainingFunction(catchElement)
        if (containingFunction != null) {
            val raiseStatements = PsiTreeUtil.findChildrenOfType(containingFunction, ValkyrieRaiseStatement::class.java)
            relatedRaises.addAll(raiseStatements)
        }
        
        return relatedRaises
    }
}