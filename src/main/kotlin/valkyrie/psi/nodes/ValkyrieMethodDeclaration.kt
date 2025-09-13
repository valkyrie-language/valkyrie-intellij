package valkyrie.psi.nodes

import com.intellij.ide.projectView.PresentationData
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.ide.highlight.ValkyrieColor
import valkyrie.language.ValkyrieIcons
import valkyrie.psi.ValkyrieElementNode
import valkyrie.psi.traits.HasAnnotation
import valkyrie.psi.traits.HasTermParameter
import valkyrie.psi.traits.HasTypeParameter


/**
 * Method 声明实现
 */
class ValkyrieMethodDeclaration(node: ASTNode) : ValkyrieElementNode(node),
    PsiNameIdentifierOwner,// method
    HasAnnotation,         // method()
    HasTypeParameter,      // method<T>()
    HasTermParameter       // method()
{
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

    override val typeParameters: List<ValkyrieTypeParameterItem>
        get() = getGenericParameterList()?.typeParameters ?: emptyList()
    override val termParameters: List<ValkyrieTermParameterItem>
        get() = getParameterList()?.getParameters() ?: emptyList()

    fun isStatic(): Boolean {
        return hasModifier("static")
    }

    fun isMutable(): Boolean {
        return hasModifier("mut")
    }

    fun getModifierList(): Array<out ValkyrieModifierNode?> {
        return findChildrenByClass(ValkyrieModifierNode::class.java)
    }

    fun getParameterList(): ValkyrieTermParameterList? {
        return PsiTreeUtil.findChildOfType(this, ValkyrieTermParameterList::class.java)
    }

    fun getGenericParameterList(): ValkyrieGenericList? {
        return PsiTreeUtil.findChildOfType(this, ValkyrieGenericList::class.java)
    }

    fun getMethodBody(): ValkyrieBlockNode? {
        return PsiTreeUtil.findChildOfType(this, ValkyrieBlockNode::class.java)
    }

    override fun getPresentation(): ItemPresentation {
        val parameterList = getParameterList()
        val parameters = parameterList?.getParameters()?.joinToString(", ") { param ->
            "${param.name ?: "_"}: ${param.getTypeReference()?.text ?: "unknown"}"
        } ?: ""
        
        val genericParams = getGenericParameterList()?.typeParameters?.joinToString(", ") { it.name ?: "_" } ?: ""
        val genericText = if (genericParams.isNotEmpty()) "<$genericParams>" else ""
        
        val modifiers = getModifierList().mapNotNull { it?.text }.joinToString(" ")
        val modifierText = if (modifiers.isNotEmpty()) "$modifiers " else ""
        
        val signature = "$modifierText${name ?: "<anonymous>"}$genericText($parameters)"
        
        return PresentationData(
            "${name ?: "<anonymous-method>"}",
            signature,
            ValkyrieIcons.METHOD,
            null
        )
    }

}