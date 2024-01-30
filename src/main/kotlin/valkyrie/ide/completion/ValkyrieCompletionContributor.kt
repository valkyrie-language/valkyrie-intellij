package valkyrie.ide.completion

import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.PsiElement
import com.intellij.util.ProcessingContext
import valkyrie.language.ValkyrieLanguage
import valkyrie.psi.ValkyrieTokenTypes
import valkyrie.psi.nodes.ValkyrieIdentifierNode
import valkyrie.psi.nodes.ValkyrieCallExpressionNode
import valkyrie.index.ValkyrieSymbolIndex
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.completion.InsertionContext

/**
 * Valkyrie 语言代码补全贡献者
 */
class ValkyrieCompletionContributor : CompletionContributor() {
    
    init {
        // 关键字补全
        extend(
            CompletionType.BASIC,
            PlatformPatterns.psiElement().withLanguage(ValkyrieLanguage.INSTANCE),
            KeywordCompletionProvider()
        )
        
        // 语句补全
        extend(
            CompletionType.BASIC,
            PlatformPatterns.psiElement().withLanguage(ValkyrieLanguage.INSTANCE),
            StatementCompletionProvider()
        )
        
        // 符号补全
        extend(
            CompletionType.BASIC,
            PlatformPatterns.psiElement(ValkyrieIdentifierNode::class.java),
            SymbolCompletionProvider()
        )
        
        // 函数调用补全
        extend(
            CompletionType.BASIC,
            PlatformPatterns.psiElement().withParent(ValkyrieCallExpressionNode::class.java),
            FunctionCompletionProvider()
        )
    }
    
    /**
     * 关键字补全提供者
     */
    private class KeywordCompletionProvider : CompletionProvider<CompletionParameters>() {
        override fun addCompletions(
            parameters: CompletionParameters,
            context: ProcessingContext,
            result: CompletionResultSet
        ) {
            val keywords = listOf(
                "if", "else", "let", "mut", "fn", "class", "trait", "union",
                "namespace", "import", "export", "return", "break", "continue",
                "match", "case", "default", "for", "while", "until", "try",
                "catch", "finally", "throw", "yield", "async", "await",
                "tests", "test", "micro", "mezzo", "macro", "singleton"
            )
            
            keywords.forEach { keyword ->
                result.addElement(
                    LookupElementBuilder.create(keyword)
                        .withTypeText("keyword")
                        .withBoldness(true)
                )
            }
        }
    }
    
    /**
     * 语句补全提供者
     */
    private class StatementCompletionProvider : CompletionProvider<CompletionParameters>() {
        override fun addCompletions(
            parameters: CompletionParameters,
            context: ProcessingContext,
            result: CompletionResultSet
        ) {
            // if 语句补全
            result.addElement(
                LookupElementBuilder.create("if")
                    .withInsertHandler { context, item ->
                        val document = context.document
                        val startOffset = context.startOffset
                        val tailOffset = context.tailOffset
                        
                        // 替换已输入的文本
                        document.replaceString(startOffset, tailOffset, "if condition {\n    \n}")
                        
                        // 将光标定位到 condition 位置
                        context.editor.caretModel.moveToOffset(startOffset + 3)
                    }
                    .withTypeText("if statement")
                    .withTailText(" condition { ... }")
            )
            
            // if-else 语句补全
            result.addElement(
                LookupElementBuilder.create("ifelse")
                    .withPresentableText("if-else")
                    .withInsertHandler { context, item ->
                        val document = context.document
                        val startOffset = context.startOffset
                        val tailOffset = context.tailOffset
                        
                        document.replaceString(startOffset, tailOffset, "if condition {\n    \n} else {\n    \n}")
                        context.editor.caretModel.moveToOffset(startOffset + 3)
                    }
                    .withTypeText("if-else statement")
                    .withTailText(" condition { ... } else { ... }")
            )
            
            // if let 语句补全
            result.addElement(
                LookupElementBuilder.create("iflet")
                    .withPresentableText("if let")
                    .withInsertHandler { context, item ->
                        val document = context.document
                        val startOffset = context.startOffset
                        val tailOffset = context.tailOffset
                        
                        document.replaceString(startOffset, tailOffset, "if let pattern = expression {\n    \n} else {\n    \n}")
                        context.editor.caretModel.moveToOffset(startOffset + 7)
                    }
                    .withTypeText("if let statement")
                    .withTailText(" pattern = expression { ... } else { ... }")
            )
        }
    }
    
    /**
     * 符号补全提供者
     */
    private class SymbolCompletionProvider : CompletionProvider<CompletionParameters>() {
        override fun addCompletions(
            parameters: CompletionParameters,
            context: ProcessingContext,
            result: CompletionResultSet
        ) {
            val file = parameters.originalFile.virtualFile ?: return
            val project = parameters.originalFile.project
            val symbolIndex = ValkyrieSymbolIndex.getInstance(project)
            
            // 获取当前文件的using导入
            val usings = symbolIndex.getFileUsings(file)
            usings.forEach { usingInfo ->
                val lookupElement = LookupElementBuilder.create(usingInfo.symbolName)
                    .withTailText(" (from ${usingInfo.namespace})")
                
                result.addElement(lookupElement)
            }
        }
    }
    
    /**
     * 函数补全提供者
     */
    private class FunctionCompletionProvider : CompletionProvider<CompletionParameters>() {
        override fun addCompletions(
            parameters: CompletionParameters,
            context: ProcessingContext,
            result: CompletionResultSet
        ) {
            // 添加常用函数
            val printFunction = LookupElementBuilder.create("print")
                .withTailText("(value)")
            result.addElement(printFunction)
            
            val printlnFunction = LookupElementBuilder.create("println")
                .withTailText("(value)")
            result.addElement(printlnFunction)
        }
    }
}