package valkyrie.ide.gutter

import com.intellij.codeInsight.daemon.LineMarkerInfo
import com.intellij.codeInsight.daemon.LineMarkerProvider
import com.intellij.codeInsight.navigation.NavigationGutterIconBuilder
import com.intellij.openapi.editor.markup.GutterIconRenderer
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.language.ValkyrieIcons
import valkyrie.psi.nodes.*
import valkyrie.psi.parsers.ValkyrieTypes

/**
 * 控制流语句的导航提供器
 * 为控制流语句提供左侧图标标记和相互跳转功能
 */
class ValkyrieControlFlowNavigationProvider : LineMarkerProvider {
    
    private val effectAnalyzer = ValkyrieEffectAnalyzer()

    override fun getLineMarkerInfo(element: PsiElement): LineMarkerInfo<*>? {
        // 只处理叶子节点
        if (element.firstChild != null) return null
        
        val parent = element.parent ?: return null
        
        return when {
            element.node?.elementType == ValkyrieTypes.LOOP && parent is ValkyrieControlFlowNodes ->
                createLoopMarker(parent)
            element.node?.elementType == ValkyrieTypes.RETURN && parent is ValkyrieReturnStatement ->
                createReturnMarker(parent)
            element.node?.elementType == ValkyrieTypes.BREAK && parent is ValkyrieBreakStatement ->
                createBreakMarker(parent)
            element.node?.elementType == ValkyrieTypes.CONTINUE && parent is ValkyrieContinueStatement ->
                createContinueMarker(parent)
            element.node?.elementType == ValkyrieTypes.YIELD && parent is ValkyrieYieldStatement ->
                createYieldMarker(parent)
            element.node?.elementType == ValkyrieTypes.RAISE && parent is ValkyrieRaiseStatement ->
                createRaiseMarker(parent)
            element.node?.elementType == ValkyrieTypes.CATCH && parent is ValkyrieCatchCase ->
                createCatchMarker(parent)
            else -> null
        }
    }

    private fun createLoopMarker(element: PsiElement): LineMarkerInfo<PsiElement> {
        val relatedElements = if (element is ValkyrieControlFlowNodes) {
            findRelatedControlFlowElements(element)
        } else {
            emptyList()
        }
        return NavigationGutterIconBuilder
            .create(ValkyrieIcons.LOOP)
            .setAlignment(GutterIconRenderer.Alignment.LEFT)
            .setTooltipText("Loop statement - Click to navigate to related break/continue")
            .setTargets(relatedElements)
            .createLineMarkerInfo(element)
    }

    private fun createReturnMarker(element: PsiElement): LineMarkerInfo<PsiElement> {
        val functionElement = findContainingFunction(element)
        val targets = if (functionElement != null) listOf(functionElement) else emptyList()
        
        return NavigationGutterIconBuilder
            .create(ValkyrieIcons.RETURN)
            .setAlignment(GutterIconRenderer.Alignment.LEFT)
            .setTooltipText("Return statement - Click to navigate to function")
            .setTargets(targets)
            .createLineMarkerInfo(element)
    }

    private fun createBreakMarker(element: PsiElement): LineMarkerInfo<PsiElement> {
        val loopElement = findTargetLoop(element)
        val targets = if (loopElement != null) listOf(loopElement) else emptyList()
        
        return NavigationGutterIconBuilder
            .create(ValkyrieIcons.BREAK)
            .setAlignment(GutterIconRenderer.Alignment.LEFT)
            .setTooltipText("Break statement - Click to navigate to target loop")
            .setTargets(targets)
            .createLineMarkerInfo(element)
    }

    private fun createContinueMarker(element: PsiElement): LineMarkerInfo<PsiElement> {
        val loopElement = findTargetLoop(element)
        val targets = if (loopElement != null) listOf(loopElement) else emptyList()
        
        return NavigationGutterIconBuilder
            .create(ValkyrieIcons.CONTINUE)
            .setAlignment(GutterIconRenderer.Alignment.LEFT)
            .setTooltipText("Continue statement - Click to navigate to target loop")
            .setTargets(targets)
            .createLineMarkerInfo(element)
    }

    private fun createYieldMarker(element: PsiElement): LineMarkerInfo<PsiElement> {
        val functionElement = findContainingFunction(element)
        val targets = if (functionElement != null) listOf(functionElement) else emptyList()
        
        return NavigationGutterIconBuilder
            .create(ValkyrieIcons.YIELD)
            .setAlignment(GutterIconRenderer.Alignment.LEFT)
            .setTooltipText("Yield statement - Click to navigate to generator function")
            .setTargets(targets)
            .createLineMarkerInfo(element)
    }

    private fun createRaiseMarker(element: PsiElement): LineMarkerInfo<PsiElement> {
        val relatedCatches = if (element is ValkyrieRaiseStatement) {
            findRelatedCatchCases(element)
        } else {
            emptyList()
        }
        val targets = relatedCatches.map { it as PsiElement }
        
        return NavigationGutterIconBuilder.create(ValkyrieIcons.RAISE)
            .setAlignment(GutterIconRenderer.Alignment.LEFT)
            .setTooltipText("Raise statement - Jump to catch cases (${targets.size})")
            .setTargets(targets)
            .createLineMarkerInfo(element)
    }

    private fun createCatchMarker(element: PsiElement): LineMarkerInfo<PsiElement> {
        val relatedRaises = if (element is ValkyrieCatchCase) {
            effectAnalyzer.findRelatedRaiseStatements(element)
        } else {
            emptyList()
        }
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