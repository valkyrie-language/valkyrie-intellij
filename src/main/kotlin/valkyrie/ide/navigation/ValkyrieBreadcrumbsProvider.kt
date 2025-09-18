package valkyrie.ide.navigation

import com.intellij.lang.Language
import com.intellij.psi.PsiElement
import com.intellij.ui.breadcrumbs.BreadcrumbsProvider
import valkyrie.language.dialect_std.ValkyrieLanguage
import valkyrie.psi.nodes.*

/**
 * Valkyrie 面包屑导航提供器
 * 为 Valkyrie 文件提供层级导航支持
 */
class ValkyrieBreadcrumbsProvider : BreadcrumbsProvider {
    
    override fun getLanguages(): Array<Language> {
        return arrayOf(ValkyrieLanguage)
    }
    
    override fun acceptElement(element: PsiElement): Boolean {
        return when (element) {
            is ValkyrieNamespaceDeclaration -> true
            is ValkyrieClassDeclaration -> true
            is ValkyrieUnionDeclaration -> true
            is ValkyrieTraitDeclaration -> true
            is ValkyrieDomainDeclaration -> true
            is ValkyrieMethodDeclaration -> true
            is ValkyrieFieldDeclaration -> true
            is ValkyrieVariantDeclaration -> true
            else -> false
        }
    }
    
    override fun getElementInfo(element: PsiElement): String {
        return when (element) {
            is ValkyrieNamespaceDeclaration -> {
                val name = element.getNamespaceName()
                "namespace ${name ?: "<unnamed>"}"
            }
            is ValkyrieClassDeclaration -> {
                "class ${element.name ?: "<unnamed>"}"
            }
            is ValkyrieUnionDeclaration -> {
                "union ${element.name ?: "<unnamed>"}"
            }
            is ValkyrieTraitDeclaration -> {
                "trait ${element.name ?: "<unnamed>"}"
            }
            is ValkyrieDomainDeclaration -> {
                "domain ${element.name ?: "<unnamed>"}"
            }
            is ValkyrieMethodDeclaration -> {
                val name = element.name ?: "<unnamed>"
                "method $name"
            }
            is ValkyrieFieldDeclaration -> {
                val name = element.name ?: "<unnamed>"
                "field $name"
            }
            is ValkyrieVariantDeclaration -> {
                val name = element.name ?: "<unnamed>"
                "variant $name"
            }
            else -> element.text?.take(30) ?: "<unknown>"
        }
    }
    
    override fun getElementTooltip(element: PsiElement): String? {
        return when (element) {
            is ValkyrieNamespaceDeclaration -> {
                val name = element.getNamespaceName()
                "Namespace: ${name ?: "<unnamed>"}"
            }
            is ValkyrieClassDeclaration -> {
                "Class: ${element.name ?: "<unnamed>"}"
            }
            is ValkyrieUnionDeclaration -> {
                "Union: ${element.name ?: "<unnamed>"}"
            }
            is ValkyrieTraitDeclaration -> {
                "Trait: ${element.name ?: "<unnamed>"}"
            }
            is ValkyrieDomainDeclaration -> {
                "Domain: ${element.name ?: "<unnamed>"}"
            }
            is ValkyrieMethodDeclaration -> {
                "Method: ${element.name ?: "<unnamed>"}"
            }
            is ValkyrieFieldDeclaration -> {
                "Field: ${element.name ?: "<unnamed>"}"
            }
            is ValkyrieVariantDeclaration -> {
                "Variant: ${element.name ?: "<unnamed>"}"
            }
            else -> null
        }
    }
}