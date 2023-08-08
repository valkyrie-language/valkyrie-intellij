package valkyrie.lsp

import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.platform.lsp.api.customization.LspCompletionSupport
import org.eclipse.lsp4j.CompletionItem
import javax.swing.Icon

class VspCompletionAdaptor : LspCompletionSupport() {
    override fun shouldRunCodeCompletion(parameters: CompletionParameters): Boolean {
        return super.shouldRunCodeCompletion(parameters)
    }

    override fun getIcon(item: CompletionItem): Icon? {
        return super.getIcon(item)
    }

    override fun getTailText(item: CompletionItem): String? {
        return super.getTailText(item)
    }

    override fun isBold(item: CompletionItem): Boolean {
        return super.isBold(item)
    }

    override fun getTypeText(item: CompletionItem): String? {
        return super.getTypeText(item)
    }

    override fun isStrikeout(item: CompletionItem): Boolean {
        return super.isStrikeout(item)
    }

    override fun createLookupElement(parameters: CompletionParameters, item: CompletionItem): LookupElement? {
        return super.createLookupElement(parameters, item)
    }
}