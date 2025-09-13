package valkyrie.ide.highlight

import com.intellij.codeInsight.daemon.impl.HighlightInfo
import com.intellij.codeInsight.daemon.impl.HighlightInfoType
import com.intellij.codeInsight.daemon.impl.HighlightVisitor
import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.PsiFile
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.ide.navigation.MetaType
import valkyrie.psi.nodes.*
import valkyrie.psi.ValkyrieTokenTypes
import valkyrie.psi.ValkyrieElementTypes

class ValkyrieSemanticHighlighter : HighlightVisitor, PsiElementVisitor() {
    private var infoHolder: HighlightInfoHolder? = null

    //
    override fun suitableForFile(file: PsiFile): Boolean = file is ValkyrieFileNode

    override fun visit(element: PsiElement) {
        when (element) {
            is ValkyrieClassDeclaration -> {
                // 检查元素类型并应用相应的高亮
                when (element.node.elementType) {
                    ValkyrieElementTypes.CLASS_STATEMENT,
                    ValkyrieElementTypes.NEURAL_STATEMENT,
                    ValkyrieElementTypes.WIDGET_STATEMENT,
                    ValkyrieElementTypes.SINGLETON_STATEMENT -> {
                        highlight(element.nameIdentifier, ValkyrieColor.SYM_CLASS)
                    }
                }
            }

            is ValkyrieTraitDeclaration -> {
                highlight(element.nameIdentifier, ValkyrieColor.SYM_TRAIT)
            }

            is ValkyrieUnionDeclaration -> {
                highlight(element.nameIdentifier, ValkyrieColor.SYM_VARIANT)
            }

            is ValkyrieVariantDeclaration -> {
                highlight(element.nameIdentifier, ValkyrieColor.SYM_VARIANT)
            }

            is ValkyrieFieldDeclaration -> {
                highlight(element.nameIdentifier, ValkyrieColor.SYM_FIELD)
            }

            is ValkyrieMethodDeclaration -> {
                if (element.isMutable()) {
                    highlight(element.nameIdentifier, ValkyrieColor.SYM_METHOD_MUT)
                } else if (element.isStatic()) {
                    highlight(element.nameIdentifier, ValkyrieColor.SYM_FUNCTION_SELF)
                } else {
                    highlight(element.nameIdentifier, ValkyrieColor.SYM_MICRO)
                }
            }

            is ValkyrieDomainDeclaration -> {
                highlight(element.nameIdentifier, ValkyrieColor.SYM_DOMAIN)
            }

            is ValkyrieModifierNode -> {
                highlight(element, ValkyrieColor.SYM_MODIFIER)
            }

            is ValkyrieTermParameterItem -> {
                // 高亮参数名称
                val paramName = element.name
                if (paramName != null) {
                    // 查找标识符节点
                    var child = element.firstChild
                    while (child != null) {
                        if (child.node.elementType == ValkyrieTokenTypes.IDENTIFIER_STD && child.text == paramName) {
                            highlight(child, ValkyrieColor.SYM_ARG)
                            break
                        }
                        child = child.nextSibling
                    }
                }
            }

            is ValkyrieGenericCallExpressionNode -> {
                // 高亮泛型参数
                val genericArgs = element.getGenericArguments()
                for (arg in genericArgs) {
                    if (arg.node.elementType == ValkyrieTokenTypes.IDENTIFIER_STD) {
                        highlight(arg, ValkyrieColor.SYM_GENERIC)
                    }
                }
            }

            is ValkyrieMetaStatement -> {
                // 高亮元编程函数的名称标识符
                val nameIdentifier = element.nameIdentifier
                if (nameIdentifier != null) {
                    val color = when (element.getMetaType()) {
                        MetaType.MICRO -> ValkyrieColor.SYM_FUNCTION_SELF
                        MetaType.MEZZO -> ValkyrieColor.SYM_MICRO
                        MetaType.MACRO -> ValkyrieColor.SYM_MACRO
                        else -> ValkyrieColor.SYM_FUNCTION_SELF
                    }
                    highlight(nameIdentifier, color)
                }
            }

            is ValkyrieCompileTimeBlock -> {
                // 高亮编译期表达式块的边界
                val startToken = element.getStartToken()
                val endToken = element.getEndToken()
                if (startToken != null) {
                    highlight(startToken, ValkyrieColor.BRACES)
                }
                if (endToken != null) {
                    highlight(endToken, ValkyrieColor.BRACES)
                }
            }

            is ValkyrieTemplateBlock -> {
                // 高亮模板语法块的边界
                val startToken = element.getStartToken()
                val endToken = element.getEndToken()
                if (startToken != null) {
                    highlight(startToken, ValkyrieColor.BRACES)
                }
                if (endToken != null) {
                    highlight(endToken, ValkyrieColor.BRACES)
                }
            }

            is ValkyrieIdentifierNode -> {
                // 处理标识符的引用解析和颜色传播
                highlightIdentifierReference(element)
            }

            is ValkyrieCallExpressionNode -> {
                // 处理函数调用表达式的颜色传播
                highlightCallExpression(element)
            }

            is ValkyrieTypeReferenceNode -> {
                // 处理类型引用的颜色传播
                highlightTypeReference(element)
            }

            is ValkyrieNamepathNode -> {
                // 处理限定名表达式的颜色传播
                highlightQualifiedName(element)
            }

            is ValkyriePostfixExpressionNode -> {
                // 处理后缀表达式（方法调用）的颜色传播
                highlightPostfixExpression(element)
            }
        }
        
        // 处理泛型参数列表（如 class A<T, U> 中的 T, U）
        if (element.node.elementType == ValkyrieElementTypes.GENERIC_PARAMETER_LIST) {
            var child = element.firstChild
            while (child != null) {
                if (child.node.elementType == ValkyrieTokenTypes.IDENTIFIER_STD) {
                    highlight(child, ValkyrieColor.SYM_GENERIC)
                }
                child = child.nextSibling
            }
        }
    }

    private fun highlight(element: PsiElement?, color: ValkyrieColor) {
        if (element == null) {
            return
        }

        val builder = HighlightInfo.newHighlightInfo(HighlightInfoType.INFORMATION)
        builder.textAttributes(color.textAttributesKey)
        builder.range(element)

        infoHolder?.add(builder.create())
    }

    override fun analyze(
        file: PsiFile,
        updateWholeFile: Boolean,
        holder: HighlightInfoHolder,
        action: Runnable,
    ): Boolean {
        infoHolder = holder
        action.run()

        return true
    }

    /**
     * 高亮标识符引用，根据引用的目标类型应用相应颜色
     */
    private fun highlightIdentifierReference(element: ValkyrieIdentifierNode) {
        // 跳过已经在声明中处理的标识符
        if (isInDeclarationContext(element)) {
            return
        }

        val reference = element.getReference()
        val resolved = reference?.resolve()
        
        if (resolved != null) {
            val color = getColorForResolvedElement(resolved)
            if (color != null) {
                highlight(element, color)
            }
        }
    }

    /**
     * 高亮函数调用表达式
     */
    private fun highlightCallExpression(element: ValkyrieCallExpressionNode) {
        val callee = element.getCallee()
        if (callee is ValkyrieIdentifierNode) {
            val reference = element.getReference()
            val resolved = reference?.resolve()
            
            if (resolved != null) {
                val color = getColorForResolvedElement(resolved)
                if (color != null) {
                    highlight(callee, color)
                }
            }
        }
    }

    /**
     * 高亮类型引用
     */
    private fun highlightTypeReference(element: ValkyrieTypeReferenceNode) {
        val reference = element.getReference()
        val resolved = reference?.resolve()
        
        if (resolved != null) {
            val color = getColorForResolvedElement(resolved)
            if (color != null) {
                val identifier = PsiTreeUtil.findChildOfType(element, ValkyrieIdentifierNode::class.java)
                if (identifier != null) {
                    highlight(identifier, color)
                }
            }
        }
    }

    /**
     * 高亮限定名表达式，如 package::module::Union::Variant::method
     */
    private fun highlightQualifiedName(element: ValkyrieNamepathNode) {
        val identifiers = element.getIdentifiers()
        
        // 对限定名的每个部分尝试解析引用
        for (identifier in identifiers) {
            if (identifier is ValkyrieIdentifierNode) {
                val reference = identifier.getReference()
                val resolved = reference?.resolve()
                
                if (resolved != null) {
                    val color = getColorForResolvedElement(resolved)
                    if (color != null) {
                        highlight(identifier, color)
                    }
                }
            }
        }
    }

    /**
     * 高亮后缀表达式（方法调用）
     */
    private fun highlightPostfixExpression(element: ValkyriePostfixExpressionNode) {
        // 查找方法名标识符
        val methodIdentifier = PsiTreeUtil.findChildOfType(element, ValkyrieIdentifierNode::class.java)
        if (methodIdentifier != null) {
            val reference = methodIdentifier.getReference()
            val resolved = reference?.resolve()
            
            if (resolved != null) {
                val color = getColorForResolvedElement(resolved)
                if (color != null) {
                    highlight(methodIdentifier, color)
                }
            }
        }
    }

    /**
     * 检查标识符是否在声明上下文中（避免重复高亮声明本身）
     */
    private fun isInDeclarationContext(element: ValkyrieIdentifierNode): Boolean {
        val parent = element.parent
        return when (parent) {
            is ValkyrieClassDeclaration -> parent.nameIdentifier == element
            is ValkyrieTraitDeclaration -> parent.nameIdentifier == element
            is ValkyrieUnionDeclaration -> parent.nameIdentifier == element
            is ValkyrieVariantDeclaration -> parent.nameIdentifier == element
            is ValkyrieFieldDeclaration -> parent.nameIdentifier == element
            is ValkyrieMethodDeclaration -> parent.nameIdentifier == element
            is ValkyrieDomainDeclaration -> parent.nameIdentifier == element
            is ValkyrieMetaStatement -> parent.nameIdentifier == element
            else -> false
        }
    }

    /**
     * 根据解析到的元素类型返回相应的颜色
     */
    private fun getColorForResolvedElement(resolved: PsiElement): ValkyrieColor? {
        return when (resolved) {
            is ValkyrieClassDeclaration -> ValkyrieColor.SYM_CLASS
            is ValkyrieTraitDeclaration -> ValkyrieColor.SYM_TRAIT
            is ValkyrieUnionDeclaration -> ValkyrieColor.SYM_UNION
            is ValkyrieVariantDeclaration -> ValkyrieColor.SYM_VARIANT
            is ValkyrieFieldDeclaration -> ValkyrieColor.SYM_FIELD
            is ValkyrieMethodDeclaration -> {
                when {
                    resolved.isMutable() -> ValkyrieColor.SYM_METHOD_MUT
                    resolved.isStatic() -> ValkyrieColor.SYM_FUNCTION_SELF
                    else -> ValkyrieColor.SYM_MICRO
                }
            }
            is ValkyrieDomainDeclaration -> ValkyrieColor.SYM_DOMAIN
            is ValkyrieMetaStatement -> {
                when (resolved.getMetaType()) {
                    MetaType.MICRO -> ValkyrieColor.SYM_FUNCTION_SELF
                    MetaType.MEZZO -> ValkyrieColor.SYM_MICRO
                    MetaType.MACRO -> ValkyrieColor.SYM_MACRO
                    else -> ValkyrieColor.SYM_FUNCTION_SELF
                }
            }
            is ValkyrieTermParameterItem -> ValkyrieColor.SYM_ARG
            is ValkyrieLetStatementNode -> ValkyrieColor.SYM_LOCAL
            else -> {
                // 尝试从父元素推断类型
                val parent = resolved.parent
                when (parent) {
                    is ValkyrieClassDeclaration -> ValkyrieColor.SYM_CLASS
                    is ValkyrieTraitDeclaration -> ValkyrieColor.SYM_TRAIT
                    is ValkyrieUnionDeclaration -> ValkyrieColor.SYM_UNION
                    is ValkyrieVariantDeclaration -> ValkyrieColor.SYM_VARIANT
                    else -> null
                }
            }
        }
    }

    override fun clone(): HighlightVisitor = ValkyrieSemanticHighlighter()
}