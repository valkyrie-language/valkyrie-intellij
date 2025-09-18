package valkyrie.ide.hint.type

import com.intellij.codeInsight.hints.*
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.language.dialect_std.ValkyrieLanguage
import valkyrie.psi.nodes.*
import javax.swing.JComponent
import javax.swing.JPanel

/**
 * Valkyrie 类型提示提供器
 * 为变量声明提供类型推断的内联提示
 */
@Suppress("UnstableApiUsage")
class TypeHintProvider : InlayHintsProvider<TypeHintProvider.Settings> {
    
    data class Settings(
        var showVariableTypes: Boolean = true,
        var showObviousTypes: Boolean = false,
        var showReturnTypes: Boolean = true
    )
    
    override val key: SettingsKey<Settings> = SettingsKey("valkyrie.inlay.type")
    override val name: String = "Valkyrie Type Hints"
    override val previewText: String = """
        let name = "Alice"  // : String
        let age = 25        // : Integer
        let pi = 3.14       // : Float
        let active = true   // : Boolean
        
        function calculate() {
            let result = 42 * 2  // : Integer
            result
        }
    """.trimIndent()
    
    override fun createSettings(): Settings = Settings()
    
    override fun getCollectorFor(
        file: PsiFile,
        editor: Editor,
        settings: Settings,
        sink: InlayHintsSink
    ): InlayHintsCollector? {
        if (file.language != ValkyrieLanguage) return null
        return TypeHintsCollector(editor, settings, sink)
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
    
    private class TypeHintsCollector(
        private val editor: Editor,
        private val settings: Settings,
        private val sink: InlayHintsSink
    ) : FactoryInlayHintsCollector(editor) {
        
        override fun collect(element: PsiElement, editor: Editor, sink: InlayHintsSink): Boolean {
            when (element) {
                is ValkyrieLetStatementNode -> collectVariableTypeHint(element)
                is ValkyrieMethodDeclaration -> collectReturnTypeHint(element)
            }
            return true
        }
        
        private fun collectVariableTypeHint(letStatement: ValkyrieLetStatementNode) {
            if (!settings.showVariableTypes) return
            
            val identifier = letStatement.getIdentifier() ?: return
            val expression = letStatement.getExpression() ?: return
            
            // 如果已经有显式类型注解，跳过
            if (letStatement.hasExplicitType()) return
            
            val inferredType = inferExpressionType(expression)
            if (inferredType != null && inferredType != "Unknown") {
                // 检查是否是显而易见的类型
                if (!settings.showObviousTypes && isObviousType(expression, inferredType)) {
                    return
                }
                
                val presentation = factory.smallText(": $inferredType")
                sink.addInlineElement(identifier.textRange.endOffset, false, presentation, false)
            }
        }
        
        private fun collectReturnTypeHint(method: ValkyrieMethodDeclaration) {
            if (!settings.showReturnTypes) return
            
            // 如果已经有显式返回类型，跳过
            if (method.hasExplicitReturnType()) return
            
            val returnType = inferMethodReturnType(method)
            if (returnType != null && returnType != "Unknown" && returnType != "Unit") {
                val nameIdentifier = method.getNameIdentifier() ?: return
                val presentation = factory.smallText(" -> $returnType")
                sink.addInlineElement(nameIdentifier.textRange.endOffset, false, presentation, false)
            }
        }
        
        private fun inferExpressionType(expression: PsiElement): String? {
            return when {
                // 字符串字面量
                expression.text.matches(Regex("\".*\"")) -> "String"
                // 整数字面量
                expression.text.matches(Regex("\\d+")) -> "Integer"
                // 浮点数字面量
                expression.text.matches(Regex("\\d+\\.\\d+")) -> "Float"
                // 布尔字面量
                expression.text in listOf("true", "false") -> "Boolean"
                // 数组字面量
                expression.text.startsWith("[") && expression.text.endsWith("]") -> {
                    val elementType = inferArrayElementType(expression)
                    if (elementType != null) "[$elementType]" else "Array"
                }
                // 函数调用
                expression is ValkyrieCallExpressionNode -> {
                    inferFunctionCallReturnType(expression)
                }
                // 变量引用
                expression is ValkyrieIdentifierNode -> {
                    resolveVariableType(expression)
                }
                else -> null
            }
        }
        
        private fun inferArrayElementType(arrayExpression: PsiElement): String? {
            // 简化实现：从第一个元素推断类型
            val elements = PsiTreeUtil.findChildrenOfType(arrayExpression, PsiElement::class.java)
            return if (elements.isNotEmpty()) {
                inferExpressionType(elements.first())
            } else null
        }
        
        private fun inferFunctionCallReturnType(call: ValkyrieCallExpressionNode): String? {
            // 这里需要实现函数调用的返回类型推断
            // 暂时返回 null，需要配合类型系统实现
            return null
        }
        
        private fun resolveVariableType(identifier: ValkyrieIdentifierNode): String? {
            // 这里需要实现变量类型解析
            // 暂时返回 null，需要配合符号解析实现
            return null
        }
        
        private fun inferMethodReturnType(method: ValkyrieMethodDeclaration): String? {
            // 从方法体的最后一个表达式推断返回类型
            val body = method.getBody() ?: return null
            val lastExpression = getLastExpression(body)
            return if (lastExpression != null) {
                inferExpressionType(lastExpression)
            } else "Unit"
        }
        
        private fun getLastExpression(body: PsiElement): PsiElement? {
            val expressions = PsiTreeUtil.findChildrenOfType(body, PsiElement::class.java)
            return expressions.lastOrNull()
        }
        
        private fun isObviousType(expression: PsiElement, inferredType: String): Boolean {
            return when (inferredType) {
                "String" -> expression.text.startsWith("\"") && expression.text.endsWith("\"")
                "Integer" -> expression.text.matches(Regex("\\d+"))
                "Float" -> expression.text.matches(Regex("\\d+\\.\\d+"))
                "Boolean" -> expression.text in listOf("true", "false")
                else -> false
            }
        }
    }
}

// 扩展函数
private fun ValkyrieLetStatementNode.hasExplicitType(): Boolean {
    // 检查是否有类型注解
    return PsiTreeUtil.findChildOfType(this, ValkyrieTypeReferenceNode::class.java) != null
}

private fun ValkyrieMethodDeclaration.hasExplicitReturnType(): Boolean {
    // 检查是否有显式返回类型声明
    return text.contains("->")
}

private fun ValkyrieMethodDeclaration.getBody(): PsiElement? {
    return PsiTreeUtil.findChildOfType(this, ValkyrieBlockNode::class.java)
}
