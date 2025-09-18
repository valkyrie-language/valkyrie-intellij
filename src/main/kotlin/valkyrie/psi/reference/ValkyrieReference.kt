package valkyrie.psi.reference

import com.intellij.openapi.util.TextRange
import com.intellij.psi.*
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.IncorrectOperationException
import valkyrie.psi.nodes.ValkyrieIdentifierNode
import valkyrie.psi.nodes.ValkyrieMethodDeclaration
import valkyrie.psi.nodes.ValkyrieLetStatementNode
import valkyrie.psi.nodes.ValkyrieClassDeclaration
import valkyrie.psi.nodes.ValkyrieTraitDeclaration
import valkyrie.psi.parsers.ValkyrieTypes
import valkyrie.psi.parsers.ValkyrieElementNode
import valkyrie.index.ValkyrieSymbolIndex

/**
 * Valkyrie 变量引用解析
 */
class ValkyrieReference(private val element: ValkyrieIdentifierNode) : PsiReferenceBase<ValkyrieIdentifierNode>(element) {
    
    override fun resolve(): PsiElement? {
        val name = element.name ?: return null
        
        // 首先查找函数参数
        val functionDeclaration = PsiTreeUtil.getParentOfType(element, ValkyrieMethodDeclaration::class.java)
        if (functionDeclaration != null) {
            val parameterList = functionDeclaration.getParameterList()
            if (parameterList != null) {
                val parameters = parameterList.getParameters()
                for (parameter in parameters) {
                    if (parameter?.name == name) {
                        return parameter.nameIdentifier ?: parameter
                    }
                }
            }
        }
        
        // 然后查找泛型参数
        val genericParameterDefinition = findGenericParameterDefinition(name)
        if (genericParameterDefinition != null) {
            return genericParameterDefinition
        }
        
        // 然后在当前作用域中查找局部变量定义
        val localVariableDefinition = findLocalVariableDefinition(name)
        if (localVariableDefinition != null) {
            return localVariableDefinition
        }
        
        // 如果在局部作用域中没有找到，使用符号索引查找全局定义（类、函数等）
        val currentFile = element.containingFile.virtualFile ?: return null
        val project = element.project
        val symbolIndex = ValkyrieSymbolIndex.getInstance(project)
        
        // 查找所有符号定义
        val allDefinitions = symbolIndex.findAllSymbolDefinitions(name, currentFile)
        
        // 优先返回类型定义（class、trait等），特别是在类型上下文中
        if (isInTypeContext()) {
            for (symbolInfo in allDefinitions) {
                val element = symbolInfo.element
                if (element != null && isTypeDefinition(element)) {
                    return element
                }
            }
        }
        
        // 如果不在类型上下文中，或者没有找到类型定义，返回第一个定义
        return allDefinitions.firstOrNull()?.element
    }
    
    override fun getVariants(): Array<Any> {
        val variants = mutableListOf<PsiElement>()
        
        // 收集函数参数
        val functionDeclaration = PsiTreeUtil.getParentOfType(element, ValkyrieMethodDeclaration::class.java)
        if (functionDeclaration != null) {
            val parameterList = functionDeclaration.getParameterList()
            if (parameterList != null) {
                val parameters = parameterList.getParameters()
                for (parameter in parameters) {
                    parameter?.nameIdentifier?.let { variants.add(it) }
                }
            }
        }
        
        // 收集当前作用域中的所有变量定义
        var context: PsiElement? = element.parent
        while (context != null) {
            val definitions = PsiTreeUtil.findChildrenOfType(context, ValkyrieIdentifierNode::class.java)
            for (definition in definitions) {
                if (definition.textOffset < element.textOffset) {
                    variants.add(definition)
                }
            }
            context = context.parent
        }
        
        return variants.toTypedArray()
    }
    
    override fun handleElementRename(newElementName: String): PsiElement {
        throw IncorrectOperationException("Rename not implemented")
    }
    
    override fun getRangeInElement(): TextRange {
        val nameIdentifier = element ?: return TextRange.EMPTY_RANGE
        // 使用相对于element自身的范围，而不是相对于父元素的偏移量
        return TextRange(0, nameIdentifier.textLength)
    }
    
    /**
     * 查找泛型参数定义
     */
    private fun findGenericParameterDefinition(name: String): PsiElement? {
        // 向上查找包含泛型参数列表的节点
        var context: PsiElement? = element.parent
        while (context != null) {
            // 查找泛型参数列表
            val genericParameterLists = PsiTreeUtil.findChildrenOfType(context, ValkyrieElementNode::class.java)
                .filter { it.node.elementType == ValkyrieTypes.GENERIC_PARAMETER_LIST }
            
            for (genericList in genericParameterLists) {
                // 在泛型参数列表中查找匹配的参数
                val genericParameters = PsiTreeUtil.findChildrenOfType(genericList, ValkyrieElementNode::class.java)
                    .filter { it.node.elementType == ValkyrieTypes.GENERIC_PARAMETER_ITEM }
                
                for (genericParam in genericParameters) {
                    val identifiers = PsiTreeUtil.findChildrenOfType(genericParam, ValkyrieIdentifierNode::class.java)
                    for (identifier in identifiers) {
                        if (identifier.name == name && identifier.textOffset < element.textOffset) {
                            return identifier
                        }
                    }
                }
            }
            
            context = context.parent
        }
        
        return null
    }
    
    /**
     * 查找局部变量定义，考虑作用域边界
     */
    private fun findLocalVariableDefinition(name: String): PsiElement? {
        var context: PsiElement? = element.parent
        
        while (context != null) {
            // 在当前作用域中查找 let 语句
            val letStatements = PsiTreeUtil.findChildrenOfType(context, ValkyrieLetStatementNode::class.java)
            for (letStatement in letStatements) {
                // 确保 let 语句在当前元素之前定义
                if (letStatement.textOffset < element.textOffset) {
                    val identifier = letStatement.getIdentifier()
                    if (identifier?.text == name) {
                        return identifier
                    }
                }
            }
            
            // 检查是否到达了作用域边界
            if (context is ValkyrieMethodDeclaration) {
                // 函数是一个作用域边界，但我们已经在上面检查了函数参数
                break
            }
            
            // 继续向上查找
            context = context.parent
        }
        
        return null
    }
    
    /**
     * 判断当前引用是否在类型上下文中
     */
    private fun isInTypeContext(): Boolean {
        var parent = element.parent
        while (parent != null) {
            // 检查是否在类型引用节点中
            if (parent.node?.elementType == ValkyrieTypes.TYPE_REFERENCE) {
                return true
            }
            // 检查是否在继承声明中
            if (parent.node?.elementType == ValkyrieTypes.INHERIT_LIST ||
                parent.node?.elementType == ValkyrieTypes.INHERIT_ITEM) {
                return true
            }
            // 检查是否在泛型参数中
            if (parent.node?.elementType == ValkyrieTypes.GENERIC_PARAMETER_LIST) {
                return true
            }
            parent = parent.parent
        }
        return false
    }
    
    /**
     * 判断元素是否为类型定义
     */
    private fun isTypeDefinition(element: PsiElement): Boolean {
        return element is ValkyrieClassDeclaration ||
               element is ValkyrieTraitDeclaration ||
               element.javaClass.simpleName.contains("Union") ||
               element.javaClass.simpleName.contains("Struct")
    }
}