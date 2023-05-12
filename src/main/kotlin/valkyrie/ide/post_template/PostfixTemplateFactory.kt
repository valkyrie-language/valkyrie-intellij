package valkyrie.ide.post_template

import com.intellij.codeInsight.template.postfix.templates.PostfixTemplate
import com.intellij.codeInsight.template.postfix.templates.PostfixTemplateProvider
import com.intellij.codeInsight.template.postfix.templates.editable.PostfixTemplateEditor
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiFile
import org.jdom.Element

class PostfixTemplateFactory : PostfixTemplateProvider {
    override fun getTemplates(): MutableSet<PostfixTemplate> {
        return mutableSetOf(
            PostfixTemplateDotIf(),
            PostfixTemplateDotWhile(),
            PostfixTemplateDotUntil()
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

    override fun getPresentableName(): String? {
        return super.getPresentableName()
    }

    override fun readExternalTemplate(id: String, name: String, template: Element): PostfixTemplate? {
        println("readExternalTemplate: ${id} ${name} ${template}")
        return super.readExternalTemplate(id, name, template)
    }

    override fun writeExternalTemplate(template: PostfixTemplate, parentElement: Element) {
        super.writeExternalTemplate(template, parentElement)
    }

    override fun createEditor(templateToEdit: PostfixTemplate?): PostfixTemplateEditor? {
        return super.createEditor(templateToEdit)
    }

}