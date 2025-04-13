package valkyrie.ide.hint

import com.intellij.codeInsight.hints.VcsCodeVisionLanguageContext
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import valkyrie.ast.node.ValkyrieClassNode
import valkyrie.ast.node.ValkyrieEnumsNode
import valkyrie.ast.node.ValkyrieFlagsNode
import valkyrie.ast.node.ValkyrieUniteNode

import valkyrie.psi.node.ValkyrieDeclareTrait
import java.awt.event.MouseEvent


class VisionAuthor : VcsCodeVisionLanguageContext {
    /// 额外的点击事件
    /// 本身会打开 Git Blame
    override fun handleClick(mouseEvent: MouseEvent, editor: Editor, element: PsiElement) {

    }

    override fun isAccepted(element: PsiElement): Boolean {
        return element is ValkyrieClassNode
            || element is ValkyrieEnumsNode
            || element is ValkyrieFlagsNode
            || element is ValkyrieUniteNode
            || element is ValkyrieDeclareTrait
    }

    override fun isCustomFileAccepted(file: PsiFile): Boolean {
        return false
    }
}