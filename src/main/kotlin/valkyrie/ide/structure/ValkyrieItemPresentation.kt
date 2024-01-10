package valkyrie.ide.structure

import com.intellij.navigation.ItemPresentation
import com.intellij.openapi.util.IconLoader
import com.intellij.psi.PsiElement
import valkyrie.psi.nodes.*
import javax.swing.Icon

/**
 * Valkyrie 项目展示
 */
class ValkyrieItemPresentation(private val element: PsiElement) : ItemPresentation {

    override fun getPresentableText(): String? {
        return when (element) {
            is ValkyrieClassDeclaration -> "class ${element.name ?: "<unnamed>"}"
            is ValkyrieUnionDeclaration -> "union ${element.name ?: "<unnamed>"}"
            is ValkyrieTraitDeclaration -> "trait ${element.name ?: "<unnamed>"}"
            is ValkyrieDomainDeclaration -> "domain ${element.name ?: "<unnamed>"}"
            is ValkyrieFieldDeclaration -> element.name ?: "<unnamed field>"
            is ValkyrieMethodDeclaration -> "${element.name ?: "<unnamed method>"}"
            is ValkyrieVariantDeclaration -> element.name ?: "<unnamed variant>"
            is ValkyrieNamespaceDeclaration -> "namespace ${element.getNamespaceName() ?: "<unnamed>"}"
            is ValkyrieLetStatementNode -> {
                val identifier = element.getIdentifier()
                "let ${identifier?.text ?: "<unnamed>"}"
            }
            is ValkyrieFileNode -> element.name
            else -> element.text?.take(50) ?: "<unknown>"
        }
    }

    override fun getLocationString(): String? {
        // 可以返回额外的位置信息，如行号等
        return null
    }

    override fun getIcon(unused: Boolean): Icon? {
        // 根据元素类型返回相应的图标
        return when (element) {
            is ValkyrieClassDeclaration -> IconLoader.getIcon("/icons/class.svg", ValkyrieItemPresentation::class.java)
            is ValkyrieUnionDeclaration -> IconLoader.getIcon("/icons/union.svg", ValkyrieItemPresentation::class.java)
            is ValkyrieTraitDeclaration -> IconLoader.getIcon("/icons/trait.svg", ValkyrieItemPresentation::class.java)
            is ValkyrieDomainDeclaration -> IconLoader.getIcon("/icons/domain.svg", ValkyrieItemPresentation::class.java)
            is ValkyrieFieldDeclaration -> IconLoader.getIcon("/icons/field.svg", ValkyrieItemPresentation::class.java)
            is ValkyrieMethodDeclaration -> IconLoader.getIcon("/icons/method.svg", ValkyrieItemPresentation::class.java)
            is ValkyrieVariantDeclaration -> IconLoader.getIcon("/icons/variant.svg", ValkyrieItemPresentation::class.java)
            is ValkyrieNamespaceDeclaration -> IconLoader.getIcon("/icons/namespace.svg", ValkyrieItemPresentation::class.java)
            is ValkyrieLetStatementNode -> IconLoader.getIcon("/icons/variable.svg", ValkyrieItemPresentation::class.java)
            is ValkyrieFileNode -> IconLoader.getIcon("/icons/vk.svg", ValkyrieItemPresentation::class.java)
            else -> null
        }
    }
}