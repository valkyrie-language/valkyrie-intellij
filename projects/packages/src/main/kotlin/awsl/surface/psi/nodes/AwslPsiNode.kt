package awsl.surface.psi.nodes

import awsl.surface.psi.AwslElementType
import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.tree.IElementType

/**
 * AWSL PSI 节点的基类
 */
open class AwslPsiNode(node: ASTNode) : ASTWrapperPsiElement(node)

/**
 * 大括号代码块节点
 */
class AwslBraceBlockNode(node: ASTNode) : AwslPsiNode(node), awsl.surface.psi.AwslBraceBlock

/**
 * 字典节点
 */
class AwslDictNode(node: ASTNode) : AwslPsiNode(node)

/**
 * Else 语句节点
 */
class AwslElseStatementNode(node: ASTNode) : AwslPsiNode(node)

/**
 * For 语句节点
 */
class AwslForStatementNode(node: ASTNode) : AwslPsiNode(node)

/**
 * 泛型节点
 */
class AwslGenericNode(node: ASTNode) : AwslPsiNode(node)

/**
 * 泛型项节点
 */
class AwslGenericItemNode(node: ASTNode) : AwslPsiNode(node)

/**
 * HTML 代码节点（<\...>...<\/...>）
 */
class AwslHtmlCodeNode(node: ASTNode) : AwslPsiNode(node), awsl.surface.psi.AwslHtmlCode

/**
 * HTML 结束标签节点
 */
class AwslHtmlEndNode(node: ASTNode) : AwslPsiNode(node)

/**
 * HTML 转义序列节点
 */
class AwslHtmlEscapeNode(node: ASTNode) : AwslPsiNode(node), awsl.surface.psi.AwslHtmlEscape

/**
 * HTML 属性键节点
 */
class AwslHtmlKeyNode(node: ASTNode) : AwslPsiNode(node), awsl.surface.psi.AwslHtmlKey, PsiNamedElement {
    override fun getName(): String? {
        return text
    }

    override fun setName(name: String): PsiElement {
        return this
    }
}

/**
 * HTML 键值对节点
 */
class AwslHtmlKvNode(node: ASTNode) : AwslPsiNode(node), awsl.surface.psi.AwslHtmlKv

/**
 * HTML 自闭合标签节点
 */
class AwslHtmlSelfCloseNode(node: ASTNode) : AwslPsiNode(node), awsl.surface.psi.AwslHtmlSelfClose

/**
 * HTML 代码开始标签节点
 */
class AwslHtmlStartCodeNode(node: ASTNode) : AwslPsiNode(node), awsl.surface.psi.AwslHtmlStartCode

/**
 * HTML 文本开始标签节点
 */
class AwslHtmlStartTextNode(node: ASTNode) : AwslPsiNode(node), awsl.surface.psi.AwslHtmlStartText

/**
 * HTML 字符串节点
 */
class AwslHtmlStringNode(node: ASTNode) : AwslPsiNode(node)

/**
 * HTML 标签节点
 */
class AwslHtmlTagNode(node: ASTNode) : AwslPsiNode(node), PsiNamedElement {
    override fun getName(): String? {
        return text
    }

    override fun setName(name: String): PsiElement {
        return this
    }
}

/**
 * `<if (expr)>` / `<if atom>` condition on directive tags.
 */
class AwslHtmlDirectiveCondNode(node: ASTNode) : AwslPsiNode(node)

/**
 * HTML 文本节点（支持语言注入 host）
 */
class AwslHtmlTextNode(node: ASTNode) :
    AwslPsiNode(node),
    awsl.surface.psi.AwslHtmlText,
    com.intellij.psi.PsiLanguageInjectionHost {

    override fun isValidHost(): Boolean = true

    override fun updateText(text: String): com.intellij.psi.PsiLanguageInjectionHost =
        com.intellij.psi.ElementManipulators.handleContentChange(this, text)

    override fun createLiteralTextEscaper(): com.intellij.psi.LiteralTextEscaper<out com.intellij.psi.PsiLanguageInjectionHost> =
        com.intellij.psi.LiteralTextEscaper.createSimple(this)
}/**
 * If 语句节点
 */
class AwslIfStatementNode(node: ASTNode) : AwslPsiNode(node)

/**
 * 键节点
 */
class AwslKeyNode(node: ASTNode) : AwslPsiNode(node), PsiNamedElement {
    override fun getName(): String? {
        return text
    }

    override fun setName(name: String): PsiElement {
        return this
    }
}

/**
 * 列表节点
 */
class AwslListNode(node: ASTNode) : AwslPsiNode(node)

/**
 * 数字字面量节点
 */
class AwslNumberLiteralNode(node: ASTNode) : AwslPsiNode(node)

/**
 * 键值对节点
 */
class AwslPairNode(node: ASTNode) : AwslPsiNode(node)

/**
 * 模式节点（用于 for 循环变量）
 */
class AwslPatternNode(node: ASTNode) : AwslPsiNode(node), PsiNamedElement {
    override fun getName(): String? {
        return text
    }

    override fun setName(name: String): PsiElement {
        return this
    }
}

/**
 * 字符串字面量节点
 */
class AwslStringLiteralNode(node: ASTNode) : AwslPsiNode(node)

/**
 * 值节点
 */
class AwslValueNode(node: ASTNode) : AwslPsiNode(node)
