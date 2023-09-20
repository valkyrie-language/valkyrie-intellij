@file:Suppress("PropertyName")

package valkyrie.ide.line_marker

import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerProvider
import com.intellij.icons.AllIcons
import com.intellij.icons.AllIcons.Actions.Upload
import com.intellij.icons.AllIcons.Toolbar.Filterdups
import com.intellij.java.JavaBundle
import com.intellij.openapi.editor.markup.GutterIconRenderer.Alignment.CENTER
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType
import com.intellij.psi.util.firstLeaf
import valkyrie.ide.line_marker.markers.*
import valkyrie.language.file.ValkyrieFileNode.Companion.definitions
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.language.file.ValkyrieIconProvider.Instance.Attribute
import valkyrie.language.file.ValkyrieIconProvider.Instance.Enumeration
import valkyrie.language.file.ValkyrieIconProvider.Instance.Field
import valkyrie.language.file.ValkyrieIconProvider.Instance.Flags
import valkyrie.language.file.ValkyrieIconProvider.Instance.Method
import valkyrie.language.file.ValkyrieIconProvider.Instance.Stop
import valkyrie.language.file.ValkyrieIconProvider.Instance.Then
import valkyrie.language.file.ValkyrieIconProvider.Instance.Trait
import valkyrie.language.file.ValkyrieIconProvider.Instance.Unite
import valkyrie.language.file.ValkyrieIconProvider.Instance.Variant
import valkyrie.psi.ValkyrieTypes
import valkyrie.psi.childrenWithLeaves
import valkyrie.psi.mixin.superClasses
import valkyrie.psi.node.*
import javax.swing.Icon

class ValkyrieLineMarkerProvider : RelatedItemLineMarkerProvider() {
    val enums_declaration =
        Option("valkyrie.declare.enums", JavaBundle.message("gutter.overridden.method"), Enumeration)
    val flags_declaration =
        Option("valkyrie.declare.flags", JavaBundle.message("gutter.overridden.method"), Flags)
    val unite_declaration =
        Option("valkyrie.declare.unite", JavaBundle.message("gutter.overridden.method"), Unite)
    val variant_declaration =
        Option("valkyrie.declare.variant", JavaBundle.message("gutter.overridden.method"), Variant)
    val class_declaration =
        Option("valkyrie.declare.class", JavaBundle.message("gutter.sibling.inherited.method"), Attribute)
    val field_declaration =
        Option("valkyrie.declare.field", JavaBundle.message("gutter.implemented.method"), Field)
    val method_declaration = Option("valkyrie.declare.method", JavaBundle.message("gutter.overriding.method"), Method)
    val domain_declaration =
        Option("valkyrie.declare.domain", JavaBundle.message("gutter.implementing.method"), AllIcons.Gutter.ImplementingMethod)

    val trait_declaration = Option("valkyrie.declare.trait", JavaBundle.message("gutter.service"), Trait)


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


    override fun collectNavigationMarkers(element: PsiElement, result: MutableCollection<in RelatedItemLineMarkerInfo<*>>) {
        val visitor = ValkyrieMarkerVisitor(this, result)
        element.accept(visitor)
    }

    override fun getLineMarkerInfo(element: PsiElement): RelatedItemLineMarkerInfo<*>? {
        return null
    }
}

private class ValkyrieMarkerVisitor : ValkyrieVisitor {
    val config: ValkyrieLineMarkerProvider
    var result: MutableCollection<in RelatedItemLineMarkerInfo<*>>

    constructor(config: ValkyrieLineMarkerProvider, result: MutableCollection<in RelatedItemLineMarkerInfo<*>>) : super() {
        this.config = config
        this.result = result
    }

    override fun visitDeclareClass(o: ValkyrieDeclareClass) {
        if (!config.class_declaration.isEnabled) return
        o as ValkyrieDeclareClassNode
        val leaf = o.nameIdentifier ?: return
        if (o.superClasses.isEmpty()) {
            result.add(ClassMarker(o))
        } else {
            for (definition in o.containingFile.definitions) {
                when (definition) {
                    is ValkyrieDeclareClassNode -> {
                        result.add(SubtypeMarker(leaf, definition))
                    }

                }
            }
            for (child in o.containingFile?.children ?: arrayOf()) {
                if (child is ValkyrieDeclareImplyNode) {
                    result.add(ImplementMarker(leaf, child))
                }

            }
        }
    }

    override fun visitDeclareNeural(o: ValkyrieDeclareNeural) {
        if (config.class_declaration.isEnabled) {
            result.add(NeuralMarker(o as ValkyrieDeclareNeuralNode))
        }
    }

    override fun visitDeclareSingleton(o: ValkyrieDeclareSingleton) {
        if (config.class_declaration.isEnabled) {
            result.add(SingletonMarker(o as ValkyrieDeclareSingletonNode))
        }
    }

    override fun visitDeclareTrait(o: ValkyrieDeclareTrait) {
//        if (!config.trait_declaration.isEnabled) return
//        o as ValkyrieDeclareTraitNode
//        val leaf = o.nameIdentifier ?: return
//        if (Random.nextBoolean()) {
//            result.add(TraitMarker(o))
//        } else {
//            for (definition in o.containingFile.definitions) {
//                when (definition) {
//                    is ValkyrieDeclareClassNode -> {
//                        result.add(SubtypeMarker(leaf, definition))
//                    }
//
//                    is ValkyrieDeclareTraitNode -> {
//                        result.add(ImplementMarker(leaf, definition))
//                    }
//
//                    is ValkyrieDeclareEnumerateNode -> {
//                        result.add(ImplementMarker(leaf, definition))
//                    }
//
//                    is ValkyrieDeclareFlagsNode -> {
//                        result.add(ImplementMarker(leaf, definition))
//                    }
//                }
//            }
//        }
    }

    override fun visitTraitAlias(o: ValkyrieTraitAlias) {
        if (!config.trait_declaration.isEnabled) return
        result.add(TraitMarker(o as ValkyrieTraitAliasNode))
    }

    override fun visitDeclareUnion(o: ValkyrieDeclareUnion) {
        o as ValkyrieDeclareUnionNode
//        result.add(ValkyrieMarkAny(o))
    }


    override fun visitDeclareEnumerate(o: ValkyrieDeclareEnumerate) {
        if (!config.enums_declaration.isEnabled) return
        result.add(EnumerationMarker(o as ValkyrieDeclareEnumerateNode))
    }

    override fun visitDeclareFlags(o: ValkyrieDeclareFlags) {
        if (!config.flags_declaration.isEnabled) return
        result.add(FlagsMarker(o as ValkyrieDeclareFlagsNode))
    }

    override fun visitDeclareField(o: ValkyrieDeclareField) {
        if (!config.field_declaration.isEnabled) return
        result.add(ValkyrieMarkField(o as ValkyrieDeclareFieldNode))
    }

    override fun visitDeclareMethod(o: ValkyrieDeclareMethod) {
        o as ValkyrieDeclareMethodNode
        if (!config.method_declaration.isEnabled) return
        mark(o.nameIdentifier, o.name, Method)
        createFunctionTest(o, o.annotations)
    }

    override fun visitDeclareDomain(o: ValkyrieDeclareDomain) {
        if (!config.domain_declaration.isEnabled) return
    }

    override fun visitDeclareUnite(o: ValkyrieDeclareUnite) {
        if (!config.unite_declaration.isEnabled) return
        result.add(UniteMarker(o as ValkyrieDeclareUniteNode))
    }

    override fun visitDeclareVariant(o: ValkyrieDeclareVariant) {
        if (!config.variant_declaration.isEnabled) return
        result.add(VariantMarker(o as ValkyrieDeclareVariantNode))
    }

    override fun visitDeclareFunction(o: ValkyrieDeclareFunction) {
        o as ValkyrieDeclareFunctionNode
//        result.add(ValkyrieMarkAny(o))
    }

    override fun visitDeclareMacro(o: ValkyrieDeclareMacro) {
        o as ValkyrieDeclareMacroNode
//        result.add(ValkyrieMarkAny(o))
    }


    override fun visitNewObject(o: ValkyrieNewObject) {

    }

    override fun visitNewLambda(o: ValkyrieNewLambda) {

    }

    override fun visitNewValue(o: ValkyrieNewValue) {

    }


    override fun visitControlYieldSend(o: ValkyrieControlYieldSend) {
        markYieldWith(o)
    }

    override fun visitControlYieldStop(o: ValkyrieControlYieldStop) {
        markYieldWith(o)
    }

    override fun visitControlYieldFrom(o: ValkyrieControlYieldFrom) {
        markYieldWith(o)
    }

    override fun visitControlReturn(o: ValkyrieControlReturn) {
        mark(o.firstChild, "return", Stop)
    }

    override fun visitControlContinue(o: ValkyrieControlContinue) {
        mark(o.firstChild, "continue", Then)
    }

    override fun visitControlBreak(o: ValkyrieControlBreak) {
        mark(o.firstChild, "break", Then)
    }

    override fun visitControlThrough(o: ValkyrieControlThrough) {
        mark(o.firstChild, "through", Then)
    }

    override fun visitControlResume(o: ValkyrieControlResume) {
        mark(o.firstChild, "resume", Filterdups)
    }

    override fun visitControlRaise(o: ValkyrieControlRaise) {
        mark(o.firstChild, "raise", Upload)
    }


    fun markYieldWith(o: PsiElement) {
        for (child in o.childrenWithLeaves) {
            if (child.elementType == ValkyrieTypes.KW_WITH) {
                mark(o.firstChild, "yield with", Then)
                return
            }
        }
        mark(o.firstChild, "yield with", Stop)
    }

    private fun mark(node: PsiElement?, name: String, icon: Icon) {
        if (node == null) {
            return
        }
        val leaf = node.firstLeaf();
        result.add(
            RelatedItemLineMarkerInfo(
                leaf,
                leaf.textRange,
                icon,
                { "tooltipProvider" },
                { name },
                { e, elt -> },
                CENTER,
                { mutableListOf() },
                { "AccessibleNameProvider" }
            ))

    }

    private fun createFunctionTest(source: PsiElement?, annotations: ValkyrieAnnotations?) {
//        val leaf = findTest(annotations)
//        if (source == null || leaf == null) {
//            return
//        }
//        val info =
//            RunLineMarkerContributor.Info(AllIcons.RunConfigurations.TestState.Run_run, { "te" }, RunTest(source), RunTestDebugMode(source));
//
//        result.add(RunLineMarkerProvider.createLineMarker(leaf, info.icon, mutableListOf(info)))
    }

    private fun findTest(annotations: ValkyrieAnnotations?): PsiElement? {
        annotations ?: return null
        for (attr in annotations.attributeBelowList) {
            attr as ValkyrieAttributeBelowNode;
            if (attr.name == "test") {
                return attr.firstChild
            }
        }

        for (mod in annotations.modifierList) {
            mod as ValkyrieModifierNode;
            if (mod.name == "test") {
                return mod.firstChild
            }
        }

        return null
    }

    private fun findTest(body: ValkyrieClassBody?): Boolean {
        body ?: return false
        for (item in body.declareMethodList) {
            val child = item.firstChild;
            if (child is ValkyrieDeclareMethodNode) {
                if (findTest(child.annotations) != null) {
                    return true
                }
            }
        }
        return false
    }
}


