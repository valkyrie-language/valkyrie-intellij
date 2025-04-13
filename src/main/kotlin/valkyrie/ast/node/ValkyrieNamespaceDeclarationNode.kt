package valkyrie.ast.node

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.DeclareNamespace
import valkyrie.ast.ParserMonad
import valkyrie.ast.ValkyrieVisitor
import valkyrie.cst.KW_NAMESPACE
import valkyrie.cst.SEMICOLON
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.psi.ValkyrieDeclaration
import javax.swing.Icon

class ValkyrieNamespaceDeclarationNode(node: ASTNode) : ValkyrieDeclaration(node) {
    val keyword = findChildByClass(ValkyrieKeywordNode::class.java)!!
    val namepath = findChildByClass(ValkyrieNamePathNode::class.java)

    override fun getNameIdentifier(): ValkyrieIdentifierNode? {
        return this.namepath?.identifier
    }

    override fun getBaseIcon(): Icon {
        return ValkyrieIconProvider.Instance.Namespace
    }

    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitDeclareNamespace(this)
            else -> visitor.visitElement(this)
        }
    }

    override fun toString(): String {
        return "NamespaceDeclaration"
    }

    companion object : ParserMonad {
        /**
        ```vk
        using a;
        using a.@b;
        using a.{a};
        ```
         */
        override fun parse(builder: PsiBuilder): Boolean {
            val marker = builder.mark()
            ValkyrieAnnotationAreaNode.parse(builder)
            if (ValkyrieKeyword(KW_NAMESPACE).parse(builder)) {

            } else {
                marker.rollbackTo()
                return false
            }
            if (!ValkyrieNamePathNode.parse(builder)) {
                builder.error("Expect namespace name")
            }
            SkipSeparator(SEMICOLON).parse(builder)
            marker.done(DeclareNamespace)
            return true

        }
    }
}

