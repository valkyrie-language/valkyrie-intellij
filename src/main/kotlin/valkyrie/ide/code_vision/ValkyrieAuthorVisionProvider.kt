package valkyrie.ide.code_vision

import com.intellij.codeInsight.hints.VcsCodeVisionLanguageContext
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement
import valkyrie.psi.nodes.ValkyrieClassDeclaration
import valkyrie.psi.nodes.ValkyrieMethodDeclaration
import valkyrie.psi.nodes.ValkyrieTraitDeclaration
import valkyrie.psi.nodes.ValkyrieUnionDeclaration
import java.awt.event.MouseEvent

class ValkyrieAuthorVisionProvider : VcsCodeVisionLanguageContext {
    override fun handleClick(
        mouseEvent: MouseEvent,
        editor: Editor,
        element: PsiElement
    ) {
        // 暂时不处理点击事件
    }

    override fun isAccepted(element: PsiElement): Boolean {
        // 只对 Valkyrie 的声明元素显示作者信息
        return element is ValkyrieClassDeclaration ||
            element is ValkyrieMethodDeclaration ||
            element is ValkyrieTraitDeclaration ||
            element is ValkyrieUnionDeclaration
    }
}
