@file:Suppress("PropertyName")

package valkyrie.ide.runner

import com.intellij.codeInsight.daemon.LineMarkerInfo
import com.intellij.codeInsight.daemon.LineMarkerProviderDescriptor
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo
import com.intellij.icons.AllIcons
import com.intellij.java.JavaBundle
import com.intellij.psi.PsiElement
import valkyrie.language.file.ValkyrieIconProvider
import javax.swing.Icon

class ValkyrieRunMarkerProvider : LineMarkerProviderDescriptor() {
    val enums_declaration =
        Option(
            "valkyrie.declare.enums",
            JavaBundle.message("gutter.overridden.method"),
            ValkyrieIconProvider.Instance.Enumeration
        )
    val flags_declaration =
        Option(
            "valkyrie.declare.flags",
            JavaBundle.message("gutter.overridden.method"),
            ValkyrieIconProvider.Instance.Flags
        )
    val unite_declaration =
        Option(
            "valkyrie.declare.unite",
            JavaBundle.message("gutter.overridden.method"),
            ValkyrieIconProvider.Instance.Unite
        )
    val variant_declaration =
        Option(
            "valkyrie.declare.variant",
            JavaBundle.message("gutter.overridden.method"),
            ValkyrieIconProvider.Instance.Variant
        )
    val class_declaration =
        Option(
            "valkyrie.declare.class",
            JavaBundle.message("gutter.sibling.inherited.method"),
            ValkyrieIconProvider.Instance.Attribute
        )
    val field_declaration =
        Option(
            "valkyrie.declare.field",
            JavaBundle.message("gutter.implemented.method"),
            ValkyrieIconProvider.Instance.Field
        )
    val method_declaration = Option(
        "valkyrie.declare.method",
        JavaBundle.message("gutter.overriding.method"),
        ValkyrieIconProvider.Instance.Method
    )
    val domain_declaration =
        Option(
            "valkyrie.declare.domain",
            JavaBundle.message("gutter.implementing.method"),
            AllIcons.Gutter.ImplementingMethod
        )

    val trait_declaration = Option(
        "valkyrie.declare.trait",
        JavaBundle.message("gutter.service"),
        ValkyrieIconProvider.Instance.Trait
    )


    /** Settings > Editor > General > Gutter Icons */
    override fun getOptions(): Array<Option> {
        return arrayOf(
            unite_declaration, variant_declaration,
            enums_declaration, flags_declaration,
            field_declaration, method_declaration, domain_declaration, class_declaration,
            trait_declaration,
        )
    }

    override fun getName(): String {
        return "ValkyrieLineMarkerProvider"
    }

    override fun getId(): String {
        return "super.getId()"
    }

    override fun getIcon(): Icon {
        return ValkyrieIconProvider.Instance.Valkyrie
    }


    override fun collectSlowLineMarkers(elements: MutableList<out PsiElement>, result: MutableCollection<in LineMarkerInfo<*>>) {
        val visitor = ValkyrieRunMarkerVisitor(this, result)
        for (element in elements) {
            element.accept(visitor)
        }
    }

    override fun getLineMarkerInfo(element: PsiElement): RelatedItemLineMarkerInfo<*>? {
        return null
    }
}