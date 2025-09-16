package valkyrie.ide.hint.chain

import com.intellij.codeInsight.hints.*
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.language.ValkyrieLanguage
import valkyrie.psi.nodes.*
import javax.swing.JComponent
import javax.swing.JPanel

/**
 * Valkyrie 方法链提示提供器
 * 为方法链调用提供中间结果类型的内联提示
 */
@Suppress("UnstableApiUsage")
class ChainHintProvider : InlayHintsProvider<ChainHintProvider.Settings> {
    
    data class Settings(
        var showChainTypes: Boolean = true,
        var showObviousChains: Boolean = false,
        var minChainLength: Int = 2
    )
    
    override val key: SettingsKey<Settings> = SettingsKey("valkyrie.inlay.chain")
    override val name: String = "Valkyrie Chain Hints"
    override val previewText: String = """
        let numbers = [1, 2, 3, 4, 5]
        let result = numbers
            .filter(x => x > 2)     // : [Integer]
            .map(x => x * 2)        // : [Integer]
            .sum()                  // : Integer
            
        let text = "hello world"
            .split(" ")             // : [String]
            .join("-")              // : String
    """.trimIndent()
    
    override fun createSettings(): Settings = Settings()
    
    override fun getCollectorFor(
        file: PsiFile,
        editor: Editor,
        settings: Settings,
        sink: InlayHintsSink
    ): InlayHintsCollector? {
        if (file.language != ValkyrieLanguage) return null
        return ChainHintsCollector(editor, settings, sink)
    }
    
    override fun createConfigurable(settings: Settings): ImmediateConfigurable {
        return object : ImmediateConfigurable {
            override fun createComponent(listener: ChangeListener): JComponent {
                val panel = JPanel()
                // 这里可以添加设置界面组件
                return panel
            }
        }
    }
    
    private class ChainHintsCollector(
        private val editor: Editor,
        private val settings: Settings,
        private val sink: InlayHintsSink
    ) : FactoryInlayHintsCollector(editor) {
        
        override fun collect(element: PsiElement, editor: Editor, sink: InlayHintsSink): Boolean {
            if (element is ValkyrieCallExpressionNode) {
                collectChainHint(element)
            } else if (element.node.elementType.toString() == "DOT_EXPRESSION") {
                collectDotChainHint(element)
            }
            return true
        }
        
        private fun collectChainHint(call: ValkyrieCallExpressionNode) {
            if (!settings.showChainTypes) return
            
            // 检查是否是方法链的一部分
            if (isPartOfMethodChain(call)) {
                val chainType = inferChainResultType(call)
                if (chainType != null && chainType != "Unknown") {
                    // 检查是否是显而易见的类型
                    if (!settings.showObviousChains && isObviousChainType(call, chainType)) {
                        return
                    }
                    
                    val presentation = factory.smallText(" // : $chainType")
                    sink.addInlineElement(call.textRange.endOffset, false, presentation, false)
                }
            }
        }
        
        private fun collectDotChainHint(dotExpression: PsiElement) {
            if (!settings.showChainTypes) return
            
            val chainLength = calculateChainLength(dotExpression)
            if (chainLength >= settings.minChainLength) {
                val chainType = inferDotChainType(dotExpression)
                if (chainType != null && chainType != "Unknown") {
                    val presentation = factory.smallText(" // : $chainType")
                    sink.addInlineElement(dotExpression.textRange.endOffset, false, presentation, false)
                }
            }
        }
        
        private fun isPartOfMethodChain(call: ValkyrieCallExpressionNode): Boolean {
            // 检查调用是否是方法链的一部分
            val parent = call.parent
            val hasChainParent = parent?.node?.elementType?.toString() == "DOT_EXPRESSION"
            val hasChainChild = call.children.any { it.node.elementType.toString() == "DOT_EXPRESSION" }
            
            return hasChainParent || hasChainChild
        }
        
        private fun calculateChainLength(dotExpression: PsiElement): Int {
            var length = 1
            var current: PsiElement? = dotExpression
            
            // 向上计算链长度
            while (current?.parent?.node?.elementType?.toString() == "DOT_EXPRESSION") {
                length++
                current = current.parent
            }
            
            // 向下计算链长度
            current = dotExpression
            while (current?.children?.any { it.node.elementType.toString() == "DOT_EXPRESSION" } == true) {
                length++
                current = current?.children?.find { it.node.elementType.toString() == "DOT_EXPRESSION" }
            }
            
            return length
        }
        
        private fun inferChainResultType(call: ValkyrieCallExpressionNode): String? {
            // 根据方法名推断返回类型
            val methodName = getMethodName(call)
            return when (methodName) {
                "filter" -> inferFilterResultType(call)
                "map" -> inferMapResultType(call)
                "flatMap" -> inferFlatMapResultType(call)
                "reduce", "fold" -> inferReduceResultType(call)
                "sum", "count", "length", "size" -> "Integer"
                "join", "toString" -> "String"
                "first", "last" -> inferElementType(call)
                "take", "drop", "skip" -> inferCollectionType(call)
                else -> null
            }
        }
        
        private fun inferDotChainType(dotExpression: PsiElement): String? {
            // 从点表达式推断类型
            val rightSide = getRightSideOfDot(dotExpression)
            if (rightSide is ValkyrieCallExpressionNode) {
                return inferChainResultType(rightSide)
            }
            return null
        }
        
        private fun getMethodName(call: ValkyrieCallExpressionNode): String? {
            // 获取方法调用的名称
            val identifier = PsiTreeUtil.findChildOfType(call, ValkyrieIdentifierNode::class.java)
            return identifier?.text
        }
        
        private fun getRightSideOfDot(dotExpression: PsiElement): PsiElement? {
            // 获取点表达式右侧的元素
            val children = dotExpression.children
            return if (children.size >= 2) children[1] else null
        }
        
        private fun inferFilterResultType(call: ValkyrieCallExpressionNode): String? {
            // filter 保持原集合类型
            val receiverType = inferReceiverType(call)
            return receiverType
        }
        
        private fun inferMapResultType(call: ValkyrieCallExpressionNode): String? {
            // map 需要推断 lambda 的返回类型
            val lambda = findLambdaArgument(call)
            if (lambda != null) {
                val lambdaReturnType = inferLambdaReturnType(lambda)
                return if (lambdaReturnType != null) "[$lambdaReturnType]" else null
            }
            return null
        }
        
        private fun inferFlatMapResultType(call: ValkyrieCallExpressionNode): String? {
            // flatMap 展平一层集合
            val lambda = findLambdaArgument(call)
            if (lambda != null) {
                val lambdaReturnType = inferLambdaReturnType(lambda)
                // 如果 lambda 返回集合，则展平一层
                return if (lambdaReturnType?.startsWith("[") == true) {
                    lambdaReturnType.removeSurrounding("[", "]")
                } else lambdaReturnType
            }
            return null
        }
        
        private fun inferReduceResultType(call: ValkyrieCallExpressionNode): String? {
            // reduce/fold 返回元素类型
            return inferElementType(call)
        }
        
        private fun inferReceiverType(call: ValkyrieCallExpressionNode): String? {
            // 推断接收者的类型
            val parent = call.parent
            if (parent?.node?.elementType?.toString() == "DOT_EXPRESSION") {
                val leftSide = parent.children.firstOrNull()
                return inferExpressionType(leftSide)
            }
            return null
        }
        
        private fun inferElementType(call: ValkyrieCallExpressionNode): String? {
            val receiverType = inferReceiverType(call)
            return if (receiverType?.startsWith("[") == true) {
                receiverType.removeSurrounding("[", "]")
            } else receiverType
        }
        
        private fun inferCollectionType(call: ValkyrieCallExpressionNode): String? {
            return inferReceiverType(call)
        }
        
        private fun findLambdaArgument(call: ValkyrieCallExpressionNode): PsiElement? {
            // 查找 lambda 参数
            return PsiTreeUtil.findChildOfType(call, PsiElement::class.java)
        }
        
        private fun inferLambdaReturnType(lambda: PsiElement): String? {
            // 推断 lambda 的返回类型
            val body = PsiTreeUtil.findChildOfType(lambda, PsiElement::class.java)
            return if (body != null) inferExpressionType(body) else null
        }
        
        private fun inferExpressionType(expression: PsiElement?): String? {
            if (expression == null) return null
            
            return when {
                expression.text.matches(Regex("\".*\"")) -> "String"
                expression.text.matches(Regex("\\d+")) -> "Integer"
                expression.text.matches(Regex("\\d+\\.\\d+")) -> "Float"
                expression.text in listOf("true", "false") -> "Boolean"
                expression.text.startsWith("[") && expression.text.endsWith("]") -> "Array"
                else -> null
            }
        }
        
        private fun isObviousChainType(call: ValkyrieCallExpressionNode, chainType: String): Boolean {
            val methodName = getMethodName(call)
            return when (methodName) {
                "toString" -> chainType == "String"
                "count", "length", "size" -> chainType == "Integer"
                else -> false
            }
        }
    }
}