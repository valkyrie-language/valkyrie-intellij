package valkyrie.ide.structure

import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import valkyrie.language.ValkyrieIcons
import valkyrie.psi.nodes.*
import javax.swing.Icon

/**
 * Valkyrie 项目展示
 */
class ValkyrieItemPresentation(private val element: PsiElement) : ItemPresentation {

    override fun getPresentableText(): String? {
        return when (element) {
            is ValkyrieClassDeclaration -> "${element.name ?: "<anonymous-class>"}"
            is ValkyrieUnionDeclaration -> "${element.name ?: "<anonymous-union>"}"
            is ValkyrieTraitDeclaration -> "${element.name ?: "<anonymous-trait>"}"
            is ValkyrieDomainDeclaration -> "${element.name ?: "<anonymous-domain>"}"
            is ValkyrieFieldDeclaration -> "${element.name ?: "<anonymous-field>"}"
            is ValkyrieMethodDeclaration -> "${element.name ?: "<anonymous-method>"}"
            is ValkyrieVariantDeclaration -> "${element.name ?: "<anonymous-variant>"}"
            is ValkyrieNamespaceDeclaration -> "${element.getNamespaceName() ?: "<anonymous-namespace>"}"
            is ValkyrieLetStatementNode -> {
                val identifier = element.getIdentifier()
                "${identifier?.text ?: "<anonymous-let>"}"
            }

            is ValkyrieFileNode -> element.name
            else -> element.text?.take(50) ?: "<unknown>"
        }
    }

    override fun getLocationString(): String? {
        return when (element) {
            is ValkyrieFileNode -> element.name
            else -> null
        }
    }

    override fun getIcon(unused: Boolean): Icon? {
        // 根据元素类型返回相应的图标
        return when (element) {
            is ValkyrieFileNode -> ValkyrieIcons.FILE
            else -> null
        }
    }
}