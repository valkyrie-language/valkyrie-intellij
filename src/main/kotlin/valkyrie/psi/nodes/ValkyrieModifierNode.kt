package valkyrie.psi.nodes

import com.intellij.ide.projectView.PresentationData
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import valkyrie.ide.highlight.ValkyrieColor
import valkyrie.psi.ValkyrieElementNode
import valkyrie.psi.lexers.ValkyrieTokenTypes
import valkyrie.psi.traits.HasHighlighter

/**
 * Modifier 节点实现
 */
class ValkyrieModifierNode(node: ASTNode) : ValkyrieElementNode(node), HasHighlighter {
    override val highlightColor: ValkyrieColor
        get() = ValkyrieColor.MODIFIER_NODE

    override val highlightElement: PsiElement?
        get() = findChildByType(ValkyrieTokenTypes.SYMBOL_XID)

    /**
     * 获取修饰符名称
     */
    fun getModifierName(): String? {
        return findChildByType<PsiElement>(ValkyrieTokenTypes.SYMBOL_XID)?.text
    }

    /**
     * 检查是否为特定修饰符
     */
    fun isModifier(name: String): Boolean {
        return getModifierName() == name
    }

    /**
     * 检查是否为可见性修饰符
     */
    fun isVisibilityModifier(): Boolean {
        val name = getModifierName()
        return name in setOf("public", "private", "protected", "internal")
    }

    /**
     * 检查是否为可变性修饰符
     */
    fun isMutabilityModifier(): Boolean {
        val name = getModifierName()
        return name in setOf("mut", "const", "readonly")
    }

    /**
     * 检查是否为静态修饰符
     */
    fun isStaticModifier(): Boolean {
        return getModifierName() == "static"
    }

    override fun getPresentation(): ItemPresentation {
        return PresentationData("mods", null, null, null)
    }

    override fun toString(): String = "ValkyrieModifier(${getModifierName()})"
}
