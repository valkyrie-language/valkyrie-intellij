package valkyrie.ide.line_marker

import com.intellij.codeInsight.template.postfix.templates.PostfixTemplate
import com.intellij.codeInsight.template.postfix.templates.PostfixTemplateProvider
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiFile

class PostfixTemplateFactory : PostfixTemplateProvider {
    override fun getTemplates(): MutableSet<PostfixTemplate> {
        return mutableSetOf(APostfixTemplateIfAdaptor())
    }

    override fun isTerminalSymbol(currentChar: Char): Boolean {
        return true
    }

    override fun preExpand(file: PsiFile, editor: Editor) {

    }

    override fun afterExpand(file: PsiFile, editor: Editor) {

    }

    override fun preCheck(copyFile: PsiFile, realEditor: Editor, currentOffset: Int): PsiFile {
        return copyFile
    }
}