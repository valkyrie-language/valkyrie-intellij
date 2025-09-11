package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import valkyrie.psi.ValkyrieElementNode

/**
 * 泛型函数调用表达式节点
 * 支持 call⟨T⟩(args) 和 call::<T>(args) 两种形式
 */
class ValkyrieGenericCallExpressionNode(node: ASTNode) : ValkyrieElementNode(node) {
    
    /**
     * 获取被调用的表达式
     */
    fun getCallee(): PsiElement? {
        return this.firstChild
    }
    
    /**
     * 获取泛型参数列表
     */
    fun getGenericArguments(): List<PsiElement> {
        val result = mutableListOf<PsiElement>()
        var child = this.firstChild?.nextSibling
        
        while (child != null) {
            if (child.text == "⟨" || child.text == "<") {
                // 找到泛型参数开始
                child = child.nextSibling
                while (child != null && child.text != "⟩" && child.text != ">") {
                    if (child.text != "," && child.text.trim().isNotEmpty()) {
                        result.add(child)
                    }
                    child = child.nextSibling
                }
                break
            }
            child = child.nextSibling
        }
        
        return result
    }
    
    /**
     * 获取参数列表
     */
    fun getArgumentList(): PsiElement? {
        var child = this.firstChild
        while (child != null) {
            if (child.text == "(") {
                return child.parent
            }
            child = child.nextSibling
        }
        return null
    }
    
    /**
     * 检查是否使用双冒号语法 (call::<T>)
     */
    fun isDoubleColonSyntax(): Boolean {
        var child = this.firstChild
        while (child != null) {
            if (child.text == "::") {
                return true
            }
            child = child.nextSibling
        }
        return false
    }
    
    /**
     * 检查是否使用角括号语法 (call⟨T⟩)
     */
    fun isAngleBracketSyntax(): Boolean {
        var child = this.firstChild
        while (child != null) {
            if (child.text == "⟨") {
                return true
            }
            child = child.nextSibling
        }
        return false
    }
    
    /**
     * 获取泛型语法类型
     */
    fun getGenericSyntaxType(): String {
        return when {
            isDoubleColonSyntax() -> "double_colon"
            isAngleBracketSyntax() -> "angle_bracket"
            else -> "unknown"
        }
    }
    
    /**
     * 检查语法是否合法
     * 只允许 call⟨T⟩ 和 call::<T> 形式，不允许 call<T>
     */
    fun isValidSyntax(): Boolean {
        var child = this.firstChild
        while (child != null) {
            // 检查是否有非法的 < 符号（不是 :: 后面的）
            if (child.text == "<" && child.prevSibling?.text != "::") {
                return false
            }
            child = child.nextSibling
        }
        return true
    }
    
    override fun toString(): String = "ValkyrieGenericCallExpression"
}