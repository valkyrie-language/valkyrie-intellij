package valkyrie.ide.gutter

import com.intellij.codeInsight.daemon.GutterIconNavigationHandler
import com.intellij.psi.PsiElement
import java.awt.event.MouseEvent

/**
 * Valkyrie 效果跳转动作处理器
 * 专门处理 raise 和 catch-case 之间的跳转
 */
class ValkyrieEffectNavigationAction(
    private val targets: List<PsiElement>,
    private val title: String
) : GutterIconNavigationHandler<PsiElement> {

    override fun navigate(e: MouseEvent?, elt: PsiElement?) {
        if (targets.isEmpty() || elt == null) return

        // 简化实现：跳转到第一个目标
        val target = targets.first()
        if (target is com.intellij.pom.Navigatable) {
            target.navigate(true)
        }
    }



    companion object {
        /**
         * 创建 raise 到 catch 的跳转动作
         */
        fun createRaiseToCatchAction(catchTargets: List<PsiElement>): ValkyrieEffectNavigationAction {
            return ValkyrieEffectNavigationAction(
                catchTargets,
                "Navigate to Catch Cases"
            )
        }

        /**
         * 创建 catch 到 raise 的跳转动作
         */
        fun createCatchToRaiseAction(raiseTargets: List<PsiElement>): ValkyrieEffectNavigationAction {
            return ValkyrieEffectNavigationAction(
                raiseTargets,
                "Navigate to Raise Statements"
            )
        }
    }
}