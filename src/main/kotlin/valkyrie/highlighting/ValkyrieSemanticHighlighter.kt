package valkyrie.highlighting

import com.intellij.codeInsight.daemon.impl.HighlightInfo
import com.intellij.codeInsight.daemon.impl.HighlightInfoType
import com.intellij.codeInsight.daemon.impl.HighlightVisitor
import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import valkyrie.psi.nodes.*

/**
 * Valkyrie 语义高亮访问器
 * 负责常规的语义高亮，如类名、特征名、方法名、域名、修饰符等
 */
class ValkyrieSemanticHighlighter : HighlightVisitor {

    companion object {
        // 语义高亮颜色定义
        val CLASS_NAME = TextAttributesKey.createTextAttributesKey(
            "VALKYRIE_CLASS_NAME",
            DefaultLanguageHighlighterColors.CLASS_NAME
        )

        val TRAIT_NAME = TextAttributesKey.createTextAttributesKey(
            "VALKYRIE_TRAIT_NAME",
            DefaultLanguageHighlighterColors.INTERFACE_NAME
        )

        val UNION_NAME = TextAttributesKey.createTextAttributesKey(
            "VALKYRIE_UNION_NAME",
            DefaultLanguageHighlighterColors.CLASS_NAME
        )

        val VARIANT_NAME = TextAttributesKey.createTextAttributesKey(
            "VALKYRIE_VARIANT_NAME",
            DefaultLanguageHighlighterColors.STATIC_FIELD
        )

        val FIELD_NAME = TextAttributesKey.createTextAttributesKey(
            "VALKYRIE_FIELD_NAME",
            DefaultLanguageHighlighterColors.INSTANCE_FIELD
        )

        val METHOD_NAME = TextAttributesKey.createTextAttributesKey(
            "VALKYRIE_METHOD_NAME",
            DefaultLanguageHighlighterColors.FUNCTION_DECLARATION
        )

        val STATIC_METHOD = TextAttributesKey.createTextAttributesKey(
            "VALKYRIE_STATIC_METHOD",
            DefaultLanguageHighlighterColors.STATIC_METHOD
        )

        val INSTANCE_METHOD = TextAttributesKey.createTextAttributesKey(
            "VALKYRIE_INSTANCE_METHOD",
            DefaultLanguageHighlighterColors.FUNCTION_DECLARATION
        )

        val DOMAIN_NAME = TextAttributesKey.createTextAttributesKey(
            "VALKYRIE_DOMAIN_NAME",
            DefaultLanguageHighlighterColors.METADATA
        )

        val MODIFIER = TextAttributesKey.createTextAttributesKey(
            "VALKYRIE_MODIFIER",
            DefaultLanguageHighlighterColors.KEYWORD
        )
    }

    private var myHolder: HighlightInfoHolder? = null

    override fun suitableForFile(file: PsiFile): Boolean {
        return file.language.id == "valkyrie"
    }

    override fun visit(element: PsiElement) {
        when (element) {
            // Class 声明中的类名
            is ValkyrieClassDeclaration -> {
                highlight(element.nameIdentifier, CLASS_NAME)
            }

            // Union 声明中的联合类型名
            is ValkyrieUnionDeclaration -> {
                highlight(element.nameIdentifier, UNION_NAME)
            }
            // Variant 声明中的变体名
            is ValkyrieVariantDeclaration -> {
                highlight(element.nameIdentifier, VARIANT_NAME)
            }

            // Trait 声明中的特征名和 Modifier 高亮
            is ValkyrieTraitDeclaration -> {
                highlight(element.nameIdentifier, TRAIT_NAME)
            }


            // Field 声明中的字段名
            is ValkyrieFieldDeclaration -> {
                highlight(element.nameIdentifier, FIELD_NAME)
            }

            // Method 声明中的方法名
            is ValkyrieMethodDeclaration -> {
                if (element.isStatic()) {
                    highlight(element.nameIdentifier, STATIC_METHOD)
                } else {
                    highlight(element.nameIdentifier, INSTANCE_METHOD)
                }
            }

            // Domain 声明中的域名
            is ValkyrieDomainDeclaration -> {
                highlight(element.nameIdentifier, DOMAIN_NAME)
            }
        }
    }

    private fun highlight(element: PsiElement?, attributesKey: TextAttributesKey) {
        if (element == null) {
            return
        }

        val info = HighlightInfo.newHighlightInfo(HighlightInfoType.INFORMATION)
            .range(element)
            .textAttributes(attributesKey)
            .create()

        myHolder?.add(info)
    }

    private fun hasSelParameter(method: ValkyrieMethodDeclaration): Boolean {
        // 查找参数列表
        val parameterList = method.children.find { child ->
            child.children.any { it.text == "self" }
        }
        return parameterList != null
    }

    override fun analyze(
        file: PsiFile,
        updateWholeFile: Boolean,
        holder: HighlightInfoHolder,
        action: Runnable
    ): Boolean {
        myHolder = holder
        try {
            action.run()
        } finally {
            myHolder = null
        }
        return true
    }

    override fun clone(): HighlightVisitor {
        return ValkyrieSemanticHighlighter()
    }
}