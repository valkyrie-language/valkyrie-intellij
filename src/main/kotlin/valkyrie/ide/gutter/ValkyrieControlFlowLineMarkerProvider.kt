package valkyrie.ide.gutter

import com.intellij.codeInsight.daemon.LineMarkerInfo
import com.intellij.codeInsight.daemon.LineMarkerProvider
import com.intellij.codeInsight.navigation.NavigationGutterIconBuilder
import com.intellij.openapi.editor.markup.GutterIconRenderer
import com.intellij.psi.PsiElement
import valkyrie.language.ValkyrieIcons
import valkyrie.psi.nodes.*

/**
 * 控制流语句的行标记提供器
 * 为 loop、return、break、continue、yield、raise、catch 等语句提供左侧图标标记
 */
class ValkyrieControlFlowLineMarkerProvider : LineMarkerProvider {

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
        return NavigationGutterIconBuilder
            .create(ValkyrieIcons.LOOP)
            .setAlignment(GutterIconRenderer.Alignment.LEFT)
            .setTooltipText("Loop statement")
            .createLineMarkerInfo(element)
    }

    private fun createReturnMarker(element: ValkyrieReturnStatement): LineMarkerInfo<PsiElement> {
        return NavigationGutterIconBuilder
            .create(ValkyrieIcons.RETURN)
            .setAlignment(GutterIconRenderer.Alignment.LEFT)
            .setTooltipText("Return statement")
            .createLineMarkerInfo(element)
    }

    private fun createBreakMarker(element: ValkyrieBreakStatement): LineMarkerInfo<PsiElement> {
        return NavigationGutterIconBuilder
            .create(ValkyrieIcons.BREAK)
            .setAlignment(GutterIconRenderer.Alignment.LEFT)
            .setTooltipText("Break statement")
            .createLineMarkerInfo(element)
    }

    private fun createContinueMarker(element: ValkyrieContinueStatement): LineMarkerInfo<PsiElement> {
        return NavigationGutterIconBuilder
            .create(ValkyrieIcons.CONTINUE)
            .setAlignment(GutterIconRenderer.Alignment.LEFT)
            .setTooltipText("Continue statement")
            .createLineMarkerInfo(element)
    }

    private fun createYieldMarker(element: ValkyrieYieldStatement): LineMarkerInfo<PsiElement> {
        return NavigationGutterIconBuilder
            .create(ValkyrieIcons.YIELD)
            .setAlignment(GutterIconRenderer.Alignment.LEFT)
            .setTooltipText("Yield statement")
            .createLineMarkerInfo(element)
    }

    private fun createRaiseMarker(element: ValkyrieRaiseStatement): LineMarkerInfo<PsiElement> {
        return NavigationGutterIconBuilder
            .create(ValkyrieIcons.RAISE)
            .setAlignment(GutterIconRenderer.Alignment.LEFT)
            .setTooltipText("Raise statement")
            .createLineMarkerInfo(element)
    }

    private fun createCatchMarker(element: ValkyrieCatchCase): LineMarkerInfo<PsiElement> {
        return NavigationGutterIconBuilder
            .create(ValkyrieIcons.CATCH)
            .setAlignment(GutterIconRenderer.Alignment.LEFT)
            .setTooltipText("Catch case")
            .createLineMarkerInfo(element)
    }
}