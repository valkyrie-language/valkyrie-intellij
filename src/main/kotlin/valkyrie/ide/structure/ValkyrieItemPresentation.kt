package valkyrie.ide.structure

import com.intellij.navigation.ItemPresentation
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
            is ValkyrieMethodDeclaration -> "${element.name ?: "<unnamed>"}()"
            is ValkyrieVariantDeclaration -> element.name ?: "<unnamed variant>"
            is ValkyrieNamespaceDeclaration -> "namespace ${element.getNamespaceName() ?: "<unnamed>"}"
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
            is ValkyrieClassDeclaration -> null // 可以添加类图标
            is ValkyrieUnionDeclaration -> null // 可以添加union图标
            is ValkyrieTraitDeclaration -> null // 可以添加trait图标
            is ValkyrieDomainDeclaration -> null // 可以添加domain图标
            is ValkyrieFieldDeclaration -> null // 可以添加字段图标
            is ValkyrieMethodDeclaration -> null // 可以添加方法图标
            is ValkyrieVariantDeclaration -> null // 可以添加变体图标
            is ValkyrieNamespaceDeclaration -> null // 可以添加namespace图标
            else -> null
        }
    }
}