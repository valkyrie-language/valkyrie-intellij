package valkyrie.reference

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.index.ValkyrieSymbolIndex
import valkyrie.psi.nodes.ValkyrieIdentifierNode
import valkyrie.psi.nodes.ValkyriePostfixExpressionNode
import valkyrie.psi.nodes.ValkyrieMethodDeclaration
import valkyrie.psi.nodes.ValkyrieClassDeclaration
import valkyrie.psi.nodes.ValkyrieTraitDeclaration
import valkyrie.psi.nodes.ValkyrieLetStatementNode

/**
 * 后缀表达式引用解析器
 * 专门处理点表达式中的方法调用引用解析，如 obj.method()
 */
class ValkyriePostfixReference(
    element: ValkyrieIdentifierNode,
    textRange: TextRange
) : PsiReferenceBase<ValkyrieIdentifierNode>(element, textRange) {

    override fun resolve(): PsiElement? {
        val methodName = element.text
        val postfixExpression = PsiTreeUtil.getParentOfType(element, ValkyriePostfixExpressionNode::class.java)
            ?: return null
        
        // 获取基础表达式（点号左边的部分）
        val baseExpression = postfixExpression.getBaseExpression() ?: return null
        
        // 尝试推断基础表达式的类型
        val baseType = inferExpressionType(baseExpression)
        if (baseType != null) {
            // 在该类型中查找方法
            val methodDefinition = findMethodInType(baseType, methodName)
            if (methodDefinition != null) {
                return methodDefinition
            }
        }
        
        // 如果无法推断类型，回退到全局符号查找
        val currentFile = element.containingFile.virtualFile ?: return null
        val project = element.project
        val symbolIndex = ValkyrieSymbolIndex.getInstance(project)
        
        // 查找所有同名的方法定义
        val allDefinitions = symbolIndex.findAllSymbolDefinitions(methodName, currentFile)
        
        // 优先返回方法定义
        for (definition in allDefinitions) {
            val element = definition.element
            if (element != null && isMethodDefinition(element)) {
                return element
            }
        }
        
        return allDefinitions.firstOrNull()?.element
    }
    
    /**
     * 推断表达式的类型
     */
    private fun inferExpressionType(expression: PsiElement): String? {
        // 如果是标识符，尝试查找其定义并推断类型
        if (expression is ValkyrieIdentifierNode) {
            val name = expression.name ?: return null
            
            // 查找变量定义
            val definition = findVariableDefinition(name)
            if (definition != null) {
                return extractTypeFromDefinition(definition)
            }
        }
        
        // TODO: 添加更多类型推断逻辑
        // - 字面量类型推断
        // - 函数调用返回类型推断
        // - 复杂表达式类型推断
        
        return null
    }
    
    /**
     * 查找变量定义
     */
    private fun findVariableDefinition(name: String): PsiElement? {
        // 在当前作用域中查找局部变量
        var current = element.parent
        while (current != null) {
            // 检查let语句
            val letStatements = PsiTreeUtil.findChildrenOfType(current, ValkyrieLetStatementNode::class.java)
            for (letStatement in letStatements) {
                val identifier = PsiTreeUtil.findChildOfType(letStatement, ValkyrieIdentifierNode::class.java)
                if (identifier?.name == name) {
                    return identifier
                }
            }
            
            // 检查函数参数
            val methodDeclaration = PsiTreeUtil.getParentOfType(current, ValkyrieMethodDeclaration::class.java)
            if (methodDeclaration != null) {
                val parameterList = methodDeclaration.getParameterList()
                if (parameterList != null) {
                    val parameters = parameterList.getParameters()
                    for (parameter in parameters) {
                        if (parameter?.name == name) {
                            return parameter.nameIdentifier ?: parameter
                        }
                    }
                }
            }
            
            current = current.parent
        }
        
        return null
    }
    
    /**
     * 从定义中提取类型信息
     */
    private fun extractTypeFromDefinition(definition: PsiElement): String? {
        val definitionText = definition.parent?.text ?: definition.text
        
        // 尝试从let语句中提取类型
        // 格式: let name: Type = value 或 let name = value
        val typePattern = Regex(":\\s*([A-Za-z_][A-Za-z0-9_]*(?:<[^>]*>)?)")
        val typeMatch = typePattern.find(definitionText)
        if (typeMatch != null) {
            return typeMatch.groupValues[1]
        }
        
        // TODO: 添加更多类型提取逻辑
        // - 从初始化表达式推断类型
        // - 从函数参数类型注解提取
        
        return null
    }
    
    /**
     * 在指定类型中查找方法
     */
    private fun findMethodInType(typeName: String, methodName: String): PsiElement? {
        val currentFile = element.containingFile.virtualFile ?: return null
        val project = element.project
        val symbolIndex = ValkyrieSymbolIndex.getInstance(project)
        
        // 查找类型定义
        val typeDefinitions = symbolIndex.findAllSymbolDefinitions(typeName, currentFile)
        
        for (typeDefinition in typeDefinitions) {
            val typeElement = typeDefinition.element
            
            // 在类中查找方法
            if (typeElement is ValkyrieClassDeclaration) {
                val methods = PsiTreeUtil.findChildrenOfType(typeElement, ValkyrieMethodDeclaration::class.java)
                for (method in methods) {
                    if (method.name == methodName) {
                        return method.nameIdentifier ?: method
                    }
                }
            }
            
            // 在trait中查找方法
            if (typeElement is ValkyrieTraitDeclaration) {
                val methods = PsiTreeUtil.findChildrenOfType(typeElement, ValkyrieMethodDeclaration::class.java)
                for (method in methods) {
                    if (method.name == methodName) {
                        return method.nameIdentifier ?: method
                    }
                }
            }
        }
        
        return null
    }
    
    /**
     * 判断元素是否为方法定义
     */
    private fun isMethodDefinition(element: PsiElement): Boolean {
        return element is ValkyrieMethodDeclaration ||
               PsiTreeUtil.getParentOfType(element, ValkyrieMethodDeclaration::class.java) != null
    }
    
    override fun getVariants(): Array<Any> {
        // TODO: 提供方法名补全建议
        return emptyArray()
    }
    
    override fun handleElementRename(newElementName: String): PsiElement {
        return element
    }
}