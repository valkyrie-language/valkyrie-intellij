package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.openapi.util.NlsSafe
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import valkyrie.psi.ValkyrieElementNode

/**
 * 函数参数项节点
 *
 * 函数参数项节点
 *
 * 示例：
 * ```valkyrie
 * macro foo(↯attribute modifier name: i32 = 0, <, b: String = "hello", >, c, ..d, ...) {
 *     // ...
 * }
 * ```
 * 其中 `↯attribute modifier name: Type = default_value` 为标准形式,
 * `name` 为参数名, `Type` 为参数类型, `default_value` 为参数默认值
 * `..d` 为可变参数, `...` 为命名参数
 * - `<` 左侧为位置参数
 * - 中间为自由参数
 * - `>` 右侧为命名参数
 * - `..d` 为可变参数
 * - `...` 为任意参数
 */
class ValkyrieTermParameterItem(node: ASTNode) : ValkyrieElementNode(node), PsiNameIdentifierOwner {

    override fun getNameIdentifier(): PsiElement? {
        return findChildByClass(ValkyrieIdentifierNode::class.java)
    }

    override fun getNavigationElement(): PsiElement {
        return nameIdentifier ?: this
    }

    override fun getName(): String? {
        return nameIdentifier?.text
    }

    override fun setName(name: @NlsSafe String): PsiElement? {
        TODO("Not yet implemented")
    }

    fun getTypeReference(): ValkyrieTypeReferenceNode? {
        return findChildByClass(ValkyrieTypeReferenceNode::class.java)
    }

    /**
     * 获取参数的修饰符节点
     */
    fun getModifierNodes(): List<ValkyrieModifierNode> {
        return findChildrenByClass(ValkyrieModifierNode::class.java).toList()
    }

    /**
     * 检查参数是否有特定修饰符
     */
    fun hasModifier(name: String): Boolean {
        return getModifierNodes().any { it.isModifier(name) }
    }

    /**
     * 检查参数是否有mut修饰符
     */
    fun isMutable(): Boolean {
        return hasModifier("mut")
    }
}