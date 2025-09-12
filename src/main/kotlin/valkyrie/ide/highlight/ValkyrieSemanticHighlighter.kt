package valkyrie.ide.highlight

import com.intellij.codeInsight.daemon.impl.HighlightInfo
import com.intellij.codeInsight.daemon.impl.HighlightInfoType
import com.intellij.codeInsight.daemon.impl.HighlightVisitor
import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.PsiFile
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

            is ValkyrieParameterNode -> {
                // 高亮参数名称
                val paramName = element.getParameterName()
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

            is ValkyrieTestStatement -> {
                // 高亮测试语句的名称标识符
                val nameIdentifier = element.nameIdentifier
                if (nameIdentifier != null) {
                    highlight(nameIdentifier, ValkyrieColor.SYM_FUNCTION_SELF)
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

    override fun clone(): HighlightVisitor = ValkyrieSemanticHighlighter()
}