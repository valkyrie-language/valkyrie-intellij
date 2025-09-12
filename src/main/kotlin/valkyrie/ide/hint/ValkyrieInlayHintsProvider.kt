package valkyrie.ide.hint

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
 * Valkyrie Inlay Hints 提供器
 * 提供函数参数名称和默认值的内联提示
 */
@Suppress("UnstableApiUsage")
class ValkyrieInlayHintsProvider : InlayHintsProvider<ValkyrieInlayHintsProvider.Settings> {

    data class Settings(
        var showParameterNames: Boolean = true,
        var showDefaultValues: Boolean = true,
        var showTypeHints: Boolean = true
    )

    override val key: SettingsKey<Settings> = SettingsKey("valkyrie.inlay.hints")
    override val name: String = "Valkyrie"
    override val previewText: String = """
        function example(name: String = "default", count: Integer = 42) {
            println(name, count)
        }
        
        example("hello", 10)
    """.trimIndent()

    override fun createSettings(): Settings = Settings()

    override fun getCollectorFor(
        file: PsiFile,
        editor: Editor,
        settings: Settings,
        sink: InlayHintsSink
    ): InlayHintsCollector? {
        if (file.language != ValkyrieLanguage.INSTANCE) return null
        return ValkyrieInlayHintsCollector(editor, settings, sink)
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

    private class ValkyrieInlayHintsCollector(
        private val editor: Editor,
        private val settings: Settings,
        private val sink: InlayHintsSink
    ) : FactoryInlayHintsCollector(editor) {

        override fun collect(element: PsiElement, editor: Editor, sink: InlayHintsSink): Boolean {
            when (element) {
                is ValkyrieCallExpressionNode -> collectFunctionCallHints(element)
                is ValkyrieLetStatementNode -> collectVariableTypeHints(element)
            }
            return true
        }

        private fun collectFunctionCallHints(call: ValkyrieCallExpressionNode) {
            if (!settings.showParameterNames) return

            val arguments = call.getArguments()

            // 尝试解析函数定义
            val function = call.resolveFunction()
            if (function != null) {
                collectParameterHintsWithFunction(arguments, function.parameters)
            } else {
                // 如果无法解析函数，尝试基于常见模式推断参数名
                collectParameterHintsWithoutFunction(call, arguments)
            }
        }

        private fun collectParameterHintsWithFunction(
            arguments: List<PsiElement>,
            parameters: List<ValkyrieTermParameterItem>
        ) {
            arguments.forEachIndexed { index, arg ->
                if (index < parameters.size) {
                    val param = parameters[index]
                    val paramName = param.name
                    if (paramName != null && !isObviousParameterName(arg, paramName)) {
                        val presentation = factory.smallText("$paramName: ")
                        sink.addInlineElement(arg.textRange.startOffset, true, presentation, false)
                    }
                }
            }
        }

        private fun collectParameterHintsWithoutFunction(
            call: ValkyrieCallExpressionNode,
            arguments: List<PsiElement>
        ) {
            val functionName = getFunctionName(call)
            if (functionName != null) {
                val suggestedNames = suggestParameterNames(functionName, arguments.size)
                arguments.forEachIndexed { index, arg ->
                    if (index < suggestedNames.size) {
                        val paramName = suggestedNames[index]
                        if (!isObviousParameterName(arg, paramName)) {
                            val presentation = factory.smallText("$paramName: ")
                            sink.addInlineElement(arg.textRange.startOffset, true, presentation, false)
                        }
                    }
                }
            }
        }

        private fun getFunctionName(call: ValkyrieCallExpressionNode): String? {
            // 从调用表达式中提取函数名
            val identifier = PsiTreeUtil.findChildOfType(call, ValkyrieIdentifierNode::class.java)
            return identifier?.text
        }

        private fun suggestParameterNames(functionName: String, argCount: Int): List<String> {
            // 基于函数名和参数数量推断常见的参数名
            return when (functionName.lowercase()) {
                "print", "println" -> listOf("message")
                "max", "min" -> listOf("a", "b")
                "pow", "power" -> listOf("base", "exponent")
                "substring" -> when (argCount) {
                    1 -> listOf("start")
                    2 -> listOf("start", "end")
                    else -> listOf("start", "end")
                }

                "replace" -> listOf("old", "new")
                "split" -> listOf("delimiter")
                "contains" -> listOf("element")
                "indexOf" -> listOf("element")
                "get" -> listOf("index")
                "set" -> listOf("index", "value")
                "add" -> listOf("element")
                "remove" -> listOf("element")
                "map" -> listOf("transform")
                "filter" -> listOf("predicate")
                "reduce" -> listOf("operation")
                "forEach" -> listOf("action")
                else -> (1..argCount).map { "arg$it" }
            }
        }

        private fun collectVariableTypeHints(letStatement: ValkyrieLetStatementNode) {
            if (!settings.showTypeHints) return

            val identifier = letStatement.getIdentifier() ?: return

            // 尝试推断类型
            val inferredType = inferVariableType(letStatement)
            if (inferredType != null && inferredType != "Unknown") {
                val presentation = factory.smallText(": $inferredType")
                sink.addInlineElement(identifier.textRange.endOffset, false, presentation, false)
            }
        }

        private fun collectDefaultValueHints(letStatement: ValkyrieLetStatementNode) {
            if (!settings.showDefaultValues) return

            val identifier = letStatement.getIdentifier() ?: return
            val expression = letStatement.getExpression()

            if (expression != null) {
                val defaultValue = expression.text
                if (defaultValue.isNotEmpty()) {
                    val presentation = factory.smallText(" = $defaultValue")
                    sink.addInlineElement(identifier.textRange.endOffset, false, presentation, false)
                }
            }
        }

        private fun isObviousParameterName(argument: PsiElement, parameterName: String): Boolean {
            val argText = argument.text.lowercase()
            val paramText = parameterName.lowercase()

            // 如果参数名和实参文本相似，则认为是明显的
            return argText.contains(paramText) || paramText.contains(argText)
        }

        private fun inferVariableType(letStatement: ValkyrieLetStatementNode): String? {
            val expression = letStatement.getExpression() ?: return null

            return when {
                expression.text.matches(Regex("\".*\"")) -> "String"
                expression.text.matches(Regex("\\d+")) -> "Integer"
                expression.text.matches(Regex("\\d+\\.\\d+")) -> "Float"
                expression.text in listOf("true", "false") -> "Boolean"
                else -> null
            }
        }
    }
}

// 扩展函数，用于获取函数调用的参数
private fun ValkyrieCallExpressionNode.getArguments(): List<PsiElement> {
    return this.children.filter { it.text != "(" && it.text != ")" && it.text != "," }
}

// 扩展函数，用于解析函数定义
private fun ValkyrieCallExpressionNode.resolveFunction(): ValkyrieMethodDeclaration? {
    // 这里需要实现函数解析逻辑
    // 暂时返回 null，需要配合引用解析功能
    return null
}

// 扩展函数，用于获取方法参数
private fun ValkyrieMethodDeclaration.getParameters(): List<ValkyrieTermParameterItem> {
    return PsiTreeUtil.findChildrenOfType(this, ValkyrieTermParameterItem::class.java).toList()
}