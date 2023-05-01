package valkyrie.ide.completion

import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.icons.AllIcons
import com.intellij.patterns.PlatformPatterns
import com.intellij.patterns.PsiElementPattern
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LeafPsiElement
import com.intellij.util.ProcessingContext
import valkyrie.language.ValkyrieLanguage
import javax.swing.Icon

class CompletionInFileScope : CompletionProvider<CompletionParameters>() {
    var element: PsiElement? = null;
    override fun addCompletions(parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet) {
        element = parameters.position
        result.addTopMacros()
    }

    private fun CompletionResultSet.addTopMacros() {
        addElement(annotationCall("#derive", "#derive()", 1))
        addElement(annotationCall("#style", "#style()", 1))
        addElement(annotationCall("#railroad", "#railroad()", 1))
        addElement(annotationCall("#atomic", "#atomic", 1))
        addElement(macroCall("@comment_line", "@comment_line", 1))
    }

    private fun macroCall(show: String, replace: String, offset: Int, lookup: Set<String> = setOf()): LookupElementBuilder {
        return buildWithReplace(show, replace, offset, lookup, AllIcons.Gutter.ExtAnnotation)
    }

    private fun annotationCall(show: String, replace: String, offset: Int, lookup: Set<String> = setOf()): LookupElementBuilder {
        return buildWithReplace(show, replace, offset, lookup, AllIcons.Nodes.Annotationtype)
    }

    companion object {
        val Condition = triggerCondition();
        private fun buildWithReplace(show: String, replace: String, offset: Int, lookup: Set<String>, icon: Icon): LookupElementBuilder {
            return LookupElementBuilder.create(show).bold()
                .withLookupStrings(lookup)
                .withIcon(icon)
                .withInsertHandler { context, _ ->
                    val document = context.document
                    document.replaceString(context.startOffset, context.tailOffset, replace)
                    context.editor.caretModel.moveToOffset(context.tailOffset - offset)
                }
        }

        private fun CompletionResultSet.addLinkedTraitMethod(kind: String, trait: String, args: String = "") {
            val element = LookupElementBuilder.create(kind)
                .withIcon(AllIcons.Nodes.Function)
                .withTypeText(trait, AllIcons.Nodes.Interface, false)
                .withInsertHandler { context, _ ->
                    val document = context.document
                    document.replaceString(context.startOffset, context.tailOffset, "$kind($args) {}")
                    context.editor.caretModel.moveToOffset(context.tailOffset - 1)
                }
            this.addElement(element)
        }
    }
}


private fun triggerCondition(): PsiElementPattern.Capture<LeafPsiElement> {
    return PlatformPatterns.psiElement(LeafPsiElement::class.java).withLanguage(ValkyrieLanguage);
}