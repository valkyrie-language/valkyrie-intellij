package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import valkyrie.psi.parsers.ValkyrieElementNode


/**
 * Annotation 节点实现
 * 提供注解相关的接口方法
 */
class ValkyrieAnnotationNode(node: ASTNode) : ValkyrieElementNode(node) {

    /**
     * 获取注解
     * @return 注解节点列表
     */
    fun getAttributeLists(): List<ValkyrieAttributeList> {
        return findChildrenByClass(ValkyrieAttributeList::class.java).toList()
    }

    /**
     * 获取注解
     * @return 注解节点列表
     */
    fun getAttributeNodes(): List<ValkyrieAttributeNode> {
        return findChildrenByClass(ValkyrieAttributeNode::class.java).toList()
    }

    /**
     * 获取修饰符索引
     * @param modifierName 修饰符名称
     * @return 修饰符在列表中的索引，如果不存在返回-1
     */
    fun getModifierIndex(modifierName: String): Int {
        val modifiers = getModifiers()
        return modifiers.indexOfFirst { it.isModifier(modifierName) }
    }

    /**
     * 获取修饰符列表
     * @return 修饰符节点列表
     */
    fun getModifiers(): List<ValkyrieModifierNode> {
        return findChildrenByClass(ValkyrieModifierNode::class.java).toList()
    }

    /**
     * 检查是否有特定修饰符
     * @param modifierName 修饰符名称
     * @return 是否存在该修饰符
     */
    fun hasModifier(modifierName: String): Boolean {
        return getModifiers().any { it.isModifier(modifierName) }
    }

    /**
     * 获取注解名称
     * @return 注解名称，如果没有则返回null
     */
    fun getAnnotationName(): String? {
        return findChildByClass(ValkyrieIdentifierNode::class.java)?.name
    }

    /**
     * 获取注解参数
     * @return 注解参数列表
     */
    fun getAnnotationArgs(): List<ValkyrieElementNode> {
        return findChildrenByClass(ValkyrieElementNode::class.java)
            .filter { it.node.elementType.toString() == "ATTRIBUTE_ARGS" }
    }

    override fun toString(): String {
        val name = getAnnotationName()
        return if (name != null) {
            "ValkyrieAnnotation($name)"
        } else {
            // 检查是否有任何子节点
            if (children.isEmpty()) {
                "ValkyrieAnnotation(empty)"
            } else {
                "ValkyrieAnnotation(null)"
            }
        }
    }
}