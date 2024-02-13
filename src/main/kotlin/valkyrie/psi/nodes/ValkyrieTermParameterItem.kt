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
 * micro foo(↯attribute modifier name: i32 = 0, <, b: String = "hello", >, kw, ..list, ...) {
 *     # ...
 * }
 * ```
 * 其中 `↯attribute modifier name: Type = default_value` 为标准形式,
 * `name` 为参数名, `Type` 为参数类型, `default_value` 为参数默认值
 * `..d` 为可变参数, `...` 为命名参数
 * - `<` 左侧为位置参数, 例如 name
 * - 中间为自由参数, 例如 b
 * - `>` 右侧为命名参数, 例如 kw
 * - `..list` 为可变参数列表
 * - `...` 为任意参数对象, 且省略名称, 直接丢弃
 *
 * 原则上不能同时存在可变参数列表和任意参数对象
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

    override fun setName(name: String): PsiElement {
        val nameIdentifier = getNameIdentifier()
        if (nameIdentifier is ValkyrieIdentifierNode) {
            return nameIdentifier.setName(name)
        }
        return this
    }

    /**
     * 检查参数是否为仅位置参数
     */
    val isPositionalOnly: Boolean
        get() {
            return hasModifier("positional")
        }

    /**
     * 检查参数是否为自由参数
     */
    val isFreeParameter: Boolean
        get() {
            return hasModifier("free")
        }


    val isNamedOnly: Boolean
        get() {
            return hasModifier("named")
        }

    /**
     * 检查参数是否为 self 参数
     */
    val isSelf: Boolean
        get() {
            return hasModifier("self")
        }

    /**
     * 检查参数是否有mut修饰符
     */
    val isMutable: Boolean
        get() {
            return hasModifier("mut")
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


}