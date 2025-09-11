package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.PsiElement
import valkyrie.psi.ValkyrieElementNode
import valkyrie.psi.ValkyrieTokenTypes

/**
 * 元编程语句实现
 * 支持 micro、mezzo、macro 三种元层级的函数声明
 */
class ValkyrieMetaStatement(node: ASTNode) : ValkyrieElementNode(node), PsiNameIdentifierOwner {
    
    override fun getNameIdentifier(): PsiElement? {
        return findChildByType(ValkyrieTokenTypes.IDENTIFIER_STD)
    }
    
    override fun getName(): String? {
        return nameIdentifier?.text
    }
    
    override fun setName(name: String): PsiElement {
        // TODO: 实现名称设置逻辑
        return this
    }
    
    /**
     * 获取元编程类型 (micro, mezzo, macro)
     */
    fun getMetaType(): MetaType {
        return when {
            hasKeyword("micro") -> MetaType.MICRO
            hasKeyword("mezzo") -> MetaType.MEZZO  
            hasKeyword("macro") -> MetaType.MACRO
            else -> MetaType.UNKNOWN
        }
    }
    
    /**
     * 检查是否包含指定关键字
     */
    private fun hasKeyword(keyword: String): Boolean {
        return text.contains(keyword)
    }
    
    /**
     * 获取参数列表
     */
    fun getParameterList(): List<PsiElement> {
        return children.filter { it.text.contains("(") || it.text.contains(")") }
    }
    
    /**
     * 获取返回类型文本
     */
    fun getReturnTypeText(): String? {
        val text = this.text
        val arrowIndex = text.indexOf("->")
        if (arrowIndex != -1) {
            return text.substring(arrowIndex + 2).trim().split("{").first().trim()
        }
        return null
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
        val returnType = getReturnTypeText() ?: "Unit"
        return "$metaType $name(...) -> $returnType"
    }
}

/**
 * 元编程类型枚举
 */
enum class MetaType {
    MICRO,    // 计算层 - 运行期执行
    MEZZO,    // 内省层 - 编译期类型查询
    MACRO,    // 构造层 - 编译期代码生成
    UNKNOWN   // 未知类型
}