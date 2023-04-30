package valkyrie.ide.completion

import com.intellij.codeInsight.template.LiveTemplateContext
import com.intellij.codeInsight.template.TemplateActionContext
import com.intellij.codeInsight.template.TemplateContextType
import com.intellij.openapi.editor.Document
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.project.Project
import valkyrie.language.ValkyrieBundle

class ValkyrieLiveTemplateContextAll : LiveTemplateContext {
    override fun getContextId(): String {
        return "valkyrie"
    }

    override fun getBaseContextId(): String? {
        return null
    }

    override fun getTemplateContextType(): TemplateContextType {
        return ContextType(contextId)
    }

    private class ContextType : TemplateContextType {
        constructor(id: String) : super(id, ValkyrieBundle.message("live-template.scope.all"))

        override fun createHighlighter(): SyntaxHighlighter? {
            return super.createHighlighter()
        }

        override fun createDocument(text: CharSequence?, project: Project?): Document {
            return super.createDocument(text, project)
        }

        override fun isInContext(templateActionContext: TemplateActionContext): Boolean {
            return templateActionContext.file.name.endsWith(".vk");
        }
    }
}


