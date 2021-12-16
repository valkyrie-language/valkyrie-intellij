package valkyrie.language.mixin

import com.intellij.icons.AllIcons.Nodes.Function
import com.intellij.icons.AllIcons.Nodes.Method
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import valkyrie.ide.view.ValkyrieViewElement
import valkyrie.language.ast.DeclareNode
import valkyrie.language.ast.FunctionKind
import valkyrie.language.ast.addChildrenView
import valkyrie.language.psi.ValkyrieContext
import valkyrie.language.psi_node.*
import javax.swing.Icon

@Suppress("UnstableApiUsage")
open class MixinDefine(node: ASTNode) : DeclareNode(node), ValkyrieContext {

    override fun getOriginalElement() = this as ValkyrieDefineStatementNode

    override fun getNameIdentifier(): ValkyrieIdentifierNode {
        return originalElement.namepathFree.identifierList.last() as ValkyrieIdentifierNode
    }

    override fun getIcon(flags: Int): Icon = when {
        originalElement.isMethod() -> Method
        else -> Function
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    val kind: FunctionKind
        get() {
            val namespace = originalElement.namepathFree;
//            val lastDot = namespace.delimiterList().lastOrNull();
            val firstArg = originalElement.defineTuple?.defineItemList?.firstOrNull()
            return when {
//                lastDot?.text == "::" -> FunctionKind.STATIC_METHOD
//                lastDot?.text == "." -> FunctionKind.METHOD
                firstArg == null -> FunctionKind.FREE_FUNCTION
                else -> FunctionKind.FREE_FUNCTION
            }
        }

    fun isMethod(): Boolean = kind.isMethod
    fun isStatic(): Boolean = kind.isStatic

}

