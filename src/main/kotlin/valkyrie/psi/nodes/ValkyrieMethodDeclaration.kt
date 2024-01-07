package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.openapi.util.NlsSafe
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.psi.ValkyrieElementNode
import valkyrie.psi.ValkyrieTokenTypes

/**
 * Method 声明实现
 */
class ValkyrieMethodDeclaration(node: ASTNode) : ValkyrieElementNode(node), PsiNameIdentifierOwner {

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

    fun isStatic(): Boolean {
        // 检查参数列表中是否有self参数
        val parameterList = getParameterList()
        val parameters = parameterList?.getParameters() ?: return true
        
        // 如果第一个参数是self或mut self，则不是静态方法
        val firstParam = parameters.firstOrNull()
        val firstParamName = firstParam?.getParameterName()
        
        return firstParamName != "self"
    }
    
    fun isMutable(): Boolean {
        // 检查第一个参数是否为mut self
        val parameterList = getParameterList()
        val parameters = parameterList?.getParameters() ?: return false
        
        val firstParam = parameters.firstOrNull()
        val firstParamName = firstParam?.getParameterName()
        
        if (firstParamName != "self") return false
        
        // 检查self参数是否有mut修饰符
        return firstParam?.isMutable() == true
    }

    fun getModifiers(): ValkyrieModifierListNode? {
        return PsiTreeUtil.findChildOfType(this, ValkyrieModifierListNode::class.java)
    }

    fun getParameterList(): ValkyrieParameterListNode? {
        return PsiTreeUtil.findChildOfType(this, ValkyrieParameterListNode::class.java)
    }

    fun getMethodBody(): ValkyrieBlockNode? {
        return PsiTreeUtil.findChildOfType(this, ValkyrieBlockNode::class.java)
    }
}