package valkyrie.ide.hint

import com.intellij.codeInsight.hints.VcsCodeVisionLanguageContext
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import yggdrasil.psi.node.ValkyrieClass
import yggdrasil.psi.node.ValkyrieDefineUnion
import java.awt.event.MouseEvent

@Suppress("UnstableApiUsage")
class AuthorAbove : VcsCodeVisionLanguageContext {
    /// 额外的点击事件
    /// 本身会打开 Git Blame
    override fun handleClick(mouseEvent: MouseEvent, editor: Editor, element: PsiElement) {

    }

    override fun isAccepted(element: PsiElement): Boolean {
        return element is ValkyrieClass
            || element is ValkyrieDefineUnion
//            || element is YggdrasilClimbStatement
//            || element is YggdrasilGrammarNode
    }

    override fun isCustomFileAccepted(file: PsiFile): Boolean {
        return false
    }
}


