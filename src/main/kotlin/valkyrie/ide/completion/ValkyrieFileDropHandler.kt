package valkyrie.ide.completion

import com.intellij.codeInsight.lookup.LookupFocusDegree
import com.intellij.codeInsight.template.*
import com.intellij.codeInsight.template.impl.DefaultLiveTemplatesProvider
import com.intellij.openapi.editor.CustomFileDropHandler
import com.intellij.openapi.editor.Document
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.project.Project
import valkyrie.language.ValkyrieBundle
import java.awt.datatransfer.Transferable

class ValkyrieFileDropHandler : CustomFileDropHandler() {
    override fun canHandle(t: Transferable, editor: Editor?): Boolean {
        // TODO: Auto add @include_bytes(path)
        return false
    }

    override fun handleDrop(t: Transferable, editor: Editor?, project: Project?): Boolean {
        println("canHandle: $t")
        return false
    }

}

class ValkyrieLiveTemplate : CustomLiveTemplate {
    override fun computeTemplateKey(callback: CustomTemplateCallback): String? {
        return "computeTemplateKey"
    }

    override fun isApplicable(callback: CustomTemplateCallback, offset: Int, wrapping: Boolean): Boolean {
        return true
    }

    override fun supportsWrapping(): Boolean {
        return true
    }

    override fun expand(key: String, callback: CustomTemplateCallback) {

    }

    override fun wrap(selection: String, callback: CustomTemplateCallback) {

    }

    override fun getTitle(): String {
        return "GetTitle"
    }

    override fun getShortcut(): Char {
        return 'L'
    }
}

class ValkyrieLiveTemplateContext : LiveTemplateContext {
    override fun getContextId(): String {
        return "valkyrie"
    }

    override fun getBaseContextId(): String? {
        return null
    }

    override fun getTemplateContextType(): TemplateContextType {
        return ValkyrieLiveTemplateContextType()
    }
}

class ValkyrieLiveTemplateDefault : DefaultLiveTemplatesProvider {
    override fun getDefaultLiveTemplateFiles(): Array<String> {
        return arrayOf("templates/liveTemplate/bitset.ft", "templates/liveTemplate/class.ft")
    }

    override fun getHiddenLiveTemplateFiles(): Array<String>? {
        return arrayOf("templates/liveTemplate/class_tuple.ft")
    }

}

class ValkyrieLiveTemplateContextProvider : LiveTemplateContextProvider {
    override fun createContexts(): MutableCollection<LiveTemplateContext> {
        return mutableListOf(ValkyrieLiveTemplateContext())
    }

}

class ValkyrieLiveTemplateContextType : TemplateContextType("valkyrie", "ValkyrieLiveTemplateContextType") {
    override fun createHighlighter(): SyntaxHighlighter? {
        return super.createHighlighter()
    }

    override fun createDocument(text: CharSequence?, project: Project?): Document {
        return super.createDocument(text, project)
    }

    override fun getPresentableName(): String {
        return ValkyrieBundle.message("live-template.name")
    }

    override fun isInContext(templateActionContext: TemplateActionContext): Boolean {
        //     return templateActionContext.getFile().getName().endsWith(".md");
        return super.isInContext(templateActionContext)
    }
}

class ValkyrieLiveTemplateMacro : Macro() {
    override fun getName(): String {
        return "ValkyrieLiveTemplateMacro"
    }

    override fun calculateResult(params: Array<out Expression>, context: ExpressionContext?): Result? {
        return null
    }

    override fun getDefaultValue(): String {
        return super.getDefaultValue()
    }

    override fun getLookupFocusDegree(): LookupFocusDegree {
        return super.getLookupFocusDegree()
    }

    override fun getPresentableName(): String {
        return super.getPresentableName()
    }
}