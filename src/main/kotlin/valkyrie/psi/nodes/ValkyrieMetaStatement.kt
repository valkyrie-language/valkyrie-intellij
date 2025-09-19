package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.PsiElement
import valkyrie.psi.nodes.ValkyrieIdentifierNode
import valkyrie.psi.nodes.ValkyrieTermParameterItem
import valkyrie.psi.nodes.ValkyrieTermParameterList
import valkyrie.psi.nodes.ValkyrieTypeReferenceNode
import valkyrie.ide.navigation.MetaType
import valkyrie.psi.ValkyrieElementNode
import valkyrie.psi.ValkyrieElementTypes
import valkyrie.psi.lexers.ValkyrieTokenTypes

/**
 * 元编程语句实现
 * 支持 micro、mezzo、macro 三种元层级的函数声明
 */
class ValkyrieMetaStatement(node: ASTNode) : ValkyrieElementNode(node), PsiNameIdentifierOwner {
    
    override fun getNameIdentifier(): PsiElement? {
        return findChildByClass(ValkyrieIdentifierNode::class.java)
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
     * 获取元编程类型 (micro, mezzo, macro)
     */
    fun getMetaType(): MetaType {
        return when (this.node.elementType) {
            valkyrie.psi.ValkyrieElementTypes.DECLARE_MACRO -> MetaType.MACRO
            valkyrie.psi.ValkyrieElementTypes.DECLARE_MEZZO -> MetaType.MEZZO
            else -> MetaType.MICRO
        }
    }

    /**
     * 检查是否包含指定关键字
     */
    private fun hasKeyword(keyword: String): Boolean {
        return children.any { it.text == keyword }
    }
    
    /**
     * 获取参数列表
     */
    fun getParameterList(): List<ValkyrieTermParameterItem> {
        return findChildByClass(ValkyrieTermParameterList::class.java)?.getParameterItems() ?: emptyList()
    }
    
    /**
     * 获取返回类型文本
     */
    fun getReturnTypeText(): String? {
        return getReturnType()?.text
    }
    
    /**
     * 获取返回类型
     */
    fun getReturnType(): ValkyrieTypeReferenceNode? {
        return findChildByClass(ValkyrieTypeReferenceNode::class.java)
    }
    
    /**
     * 获取函数体
     */
    fun getBodyText(): String? {
        val text = this.text
        val braceStart = text.indexOf("{")
        val braceEnd = text.lastIndexOf("}")
        if (braceStart != -1 && braceEnd != -1 && braceStart < braceEnd) {
            return text.substring(braceStart + 1, braceEnd).trim()
        }
        return null
    }
    
    /**
     * 判断是否为编译期函数 (mezzo, macro)
     */
    fun isCompileTimeFunction(): Boolean {
        val metaType = getMetaType()
        return metaType == MetaType.MEZZO || metaType == MetaType.MACRO
    }
    
    /**
     * 判断是否为运行期函数 (micro)
     */
    fun isRuntimeFunction(): Boolean {
        return getMetaType() == MetaType.MICRO
    }
    
    /**
     * 判断是否为类型内省函数 (mezzo)
     */
    fun isIntrospectionFunction(): Boolean {
        return getMetaType() == MetaType.MEZZO
    }
    
    /**
     * 判断是否为代码生成函数 (macro)
     */
    fun isCodeGenerationFunction(): Boolean {
        return getMetaType() == MetaType.MACRO
    }
    
    /**
     * 获取函数签名字符串
     */
    fun getSignature(): String {
        val metaType = getMetaType().name.lowercase()
        val name = getName() ?: "<unnamed>"
        val returnType = getReturnType()?.text ?: "Unit"
        return "$metaType $name(...) -> $returnType"
    }
}

