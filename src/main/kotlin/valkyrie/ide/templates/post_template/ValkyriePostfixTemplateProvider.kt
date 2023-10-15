package valkyrie.ide.templates.post_template

import com.intellij.codeInsight.template.postfix.templates.PostfixTemplate
import com.intellij.codeInsight.template.postfix.templates.PostfixTemplateProvider
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiFile
import org.jdom.Element

class ValkyriePostfixTemplateProvider : PostfixTemplateProvider {
    override fun getTemplates(): MutableSet<PostfixTemplate> {
        return mutableSetOf(
            PostfixTemplateDotIf(),
            PostfixTemplateDotWhile(),
            PostfixTemplateDotUntil(),
        )
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

    override fun readExternalTemplate(id: String, name: String, template: Element): PostfixTemplate? {
        println("readExternalTemplate: $id $name $template")
        return super.readExternalTemplate(id, name, template)
    }

}


