package valkyrie.ide.hint

import com.intellij.lang.parameterInfo.*
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.psi.nodes.*

/**
 * Valkyrie 参数信息处理器
 * 在函数调用时显示参数信息和默认值
 */
class ValkyrieParameterInfoHandler : ParameterInfoHandler<ValkyrieCallExpressionNode, ValkyrieMethodDeclaration> {
    
    override fun findElementForParameterInfo(context: CreateParameterInfoContext): ValkyrieCallExpressionNode? {
        val file = context.file
        val offset = context.offset
        
        // 查找当前位置的函数调用
        val element = file.findElementAt(offset) ?: return null
        return PsiTreeUtil.getParentOfType(element, ValkyrieCallExpressionNode::class.java)
    }
    
    override fun findElementForUpdatingParameterInfo(context: UpdateParameterInfoContext): ValkyrieCallExpressionNode? {
        val file = context.file
        val offset = context.offset
        
        val element = file.findElementAt(offset) ?: return null
        return PsiTreeUtil.getParentOfType(element, ValkyrieCallExpressionNode::class.java)
    }
    
    override fun showParameterInfo(element: ValkyrieCallExpressionNode, context: CreateParameterInfoContext) {
        val function = resolveFunctionDeclaration(element)
        if (function != null) {
            context.itemsToShow = arrayOf(function)
            context.showHint(element, element.textRange.startOffset, this)
        }
    }
    
    override fun updateParameterInfo(parameterOwner: ValkyrieCallExpressionNode, context: UpdateParameterInfoContext) {
        val currentParameterIndex = getCurrentParameterIndex(parameterOwner, context.offset)
        context.setCurrentParameter(currentParameterIndex)
    }
    
    override fun updateUI(p: ValkyrieMethodDeclaration?, context: ParameterInfoUIContext) {
        if (p == null) {
            context.isUIComponentEnabled = false
            return
        }
        
        val parameters = getMethodParameters(p)
        val currentIndex = context.currentParameterIndex
        
        val presentation = buildParameterPresentation(parameters, currentIndex)
        context.setupUIComponentPresentation(
            presentation.text,
            presentation.highlightStartOffset,
            presentation.highlightEndOffset,
            !context.isUIComponentEnabled,
            false,
            false,
            context.defaultParameterColor
        )
    }
    
    private fun resolveFunctionDeclaration(call: ValkyrieCallExpressionNode): ValkyrieMethodDeclaration? {
        // 这里需要实现函数解析逻辑
        // 暂时返回 null，需要配合引用解析功能完善
        val functionName = getFunctionName(call) ?: return null
        
        // 在当前文件中查找函数定义
        val file = call.containingFile
        val functions = PsiTreeUtil.findChildrenOfType(file, ValkyrieMethodDeclaration::class.java)
        
        return functions.find { it.name == functionName }
    }
    
    private fun getFunctionName(call: ValkyrieCallExpressionNode): String? {
        // 获取函数调用的名称
        val nameElement = PsiTreeUtil.findChildOfType(call, ValkyrieIdentifierNode::class.java)
        return nameElement?.text
    }
    
    private fun getCurrentParameterIndex(call: ValkyrieCallExpressionNode, offset: Int): Int {
        val arguments = getCallArguments(call)
        var parameterIndex = 0
        
        for (i in arguments.indices) {
            val arg = arguments[i]
            if (offset <= arg.textRange.endOffset) {
                parameterIndex = i
                break
            }
            if (i == arguments.size - 1) {
                parameterIndex = arguments.size
            }
        }
        
        return parameterIndex
    }
    
    private fun getCallArguments(call: ValkyrieCallExpressionNode): List<PsiElement> {
        // 获取函数调用的参数列表
        return call.children.filter { it.text != "(" && it.text != ")" && it.text != "," }
    }
    
    private fun getMethodParameters(method: ValkyrieMethodDeclaration): List<ParameterInfo> {
        val parameters = PsiTreeUtil.findChildrenOfType(method, ValkyrieTermParameterItem::class.java)
        return parameters.map { param ->
            ParameterInfo(
                name = param.name ?: "<unnamed>",
                type = getParameterType(param),
                defaultValue = getParameterDefaultValue(param)
            )
        }
    }
    
    private fun getParameterType(param: ValkyrieTermParameterItem): String {
        val typeElement = PsiTreeUtil.findChildOfType(param, ValkyrieTypeExpression::class.java)
        return typeElement?.text ?: "Unknown"
    }
    
    private fun getParameterDefaultValue(param: ValkyrieTermParameterItem): String? {
        // 查找参数的默认值
        val children = param.children
        for (i in children.indices) {
            if (children[i].text == "=") {
                return children.getOrNull(i + 1)?.text
            }
        }
        return null
    }
    
    private fun buildParameterPresentation(parameters: List<ParameterInfo>, currentIndex: Int): ParameterPresentation {
        val builder = StringBuilder()
        var highlightStart = -1
        var highlightEnd = -1
        
        builder.append("(")
        
        parameters.forEachIndexed { index, param ->
            if (index > 0) {
                builder.append(", ")
            }
            
            val paramStart = builder.length
            builder.append(param.name)
            builder.append(": ")
            builder.append(param.type)
            
            if (param.defaultValue != null) {
                builder.append(" = ")
                builder.append(param.defaultValue)
            }
            
            val paramEnd = builder.length
            
            if (index == currentIndex) {
                highlightStart = paramStart
                highlightEnd = paramEnd
            }
        }
        
        builder.append(")")
        
        return ParameterPresentation(
            text = builder.toString(),
            highlightStartOffset = highlightStart,
            highlightEndOffset = highlightEnd
        )
    }
    
    private data class ParameterInfo(
        val name: String,
        val type: String,
        val defaultValue: String?
    )
    
    private data class ParameterPresentation(
        val text: String,
        val highlightStartOffset: Int,
        val highlightEndOffset: Int
    )
}