package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import valkyrie.psi.parsers.ValkyrieElementNode

/**
 * 函数参数项节点
 *
 * 函数参数项节点
 *
 * 示例：
 * ```valkyrie
 * micro foo(↯annotation name: i32 = 0, <, b: String = "hello", >, kw, ..list, ...) {
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
    fun getIsPositionalOnly(): Boolean {
        return hasModifier("positional")
    }

    /**
     * 检查参数是否为关键字参数
     */
    fun getIsKeywordOnly(): Boolean {
        return hasModifier("named")
    }

    /**
     * 检查参数是否为自由参数
     */
    fun getIsFreeParameter(): Boolean {
        return hasModifier("free")
    }

    /**
     * 检查参数是否为 self 参数
     */
    fun getIsSelf(): Boolean {
        return hasModifier("self")
    }

    /**
     * 检查参数是否有mut修饰符
     */
    fun getIsMutable(): Boolean {
        return hasModifier("mut")
    }

    /**
     * 检查参数是否有ref修饰符
     */
    fun getIsReference(): Boolean {
        return hasModifier("ref")
    }

    /**
     * 检查参数是否为可变参数列表 (varargs)
     * 形如 ..list
     */
    fun getIsVarargs(): Boolean {
        val text = this.text
        return text.startsWith("..") && !text.startsWith("...")
    }

    /**
     * 检查参数是否为任意参数对象 (varkws)
     * 形如 ...
     */
    fun getIsVarkws(): Boolean {
        return this.text.startsWith("...")
    }

    /**
     * 检查参数是否为左分隔符 <
     */
    fun getIsLeftSeparator(): Boolean {
        return this.text.trim() == "<"
    }

    /**
     * 检查参数是否为右分隔符 >
     */
    fun getIsRightSeparator(): Boolean {
        return this.text.trim() == ">"
    }

    /**
     * 检查参数是否为分隔符（< 或 >）
     */
    fun getIsSeparator(): Boolean {
        return getIsLeftSeparator() || getIsRightSeparator()
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


