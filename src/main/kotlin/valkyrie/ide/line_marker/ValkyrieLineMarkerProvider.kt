@file:Suppress("PropertyName")

package valkyrie.ide.line_marker

import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerProvider
import com.intellij.icons.AllIcons
import com.intellij.icons.ExpUiIcons
import com.intellij.java.JavaBundle
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType
import valkyrie.ide.line_marker.mark_class.ClassDescendantMarker
import valkyrie.ide.line_marker.mark_class.ClassImplementMarker
import valkyrie.ide.line_marker.mark_class.ClassMarker
import valkyrie.language.file.ValkyrieFileNode.Companion.definitions
import valkyrie.language.file.ValkyrieIconProvider.Instance.Attribute
import valkyrie.language.file.ValkyrieIconProvider.Instance.Enumeration
import valkyrie.language.file.ValkyrieIconProvider.Instance.Field
import valkyrie.language.file.ValkyrieIconProvider.Instance.Method
import valkyrie.language.file.ValkyrieIconProvider.Instance.Stop
import valkyrie.language.file.ValkyrieIconProvider.Instance.Then
import valkyrie.language.file.ValkyrieIconProvider.Instance.Trait
import valkyrie.psi.ValkyrieTypes
import valkyrie.psi.childrenWithLeaves
import valkyrie.psi.mixin.superClasses
import valkyrie.psi.node.*
import javax.swing.Icon
import kotlin.random.Random

class ValkyrieLineMarkerProvider : RelatedItemLineMarkerProvider() {
    val enums_declaration =
        Option("valkyrie.declare.enums", JavaBundle.message("gutter.overridden.method"), Enumeration)
    val field_declaration =
        Option("valkyrie.declare.field", JavaBundle.message("gutter.implemented.method"), Field)
    val method_declaration = Option("valkyrie.declare.method", JavaBundle.message("gutter.overriding.method"), Method)
    val domain_declaration =
        Option("valkyrie.declare.domain", JavaBundle.message("gutter.implementing.method"), AllIcons.Gutter.ImplementingMethod)
    val class_declaration =
        Option("valkyrie.declare.class", JavaBundle.message("gutter.sibling.inherited.method"), Attribute)
    val trait_declaration = Option("valkyrie.declare.trait", JavaBundle.message("gutter.service"), Trait)

    /** Settings > Editor > General > Gutter Icons */
    override fun getOptions(): Array<Option> {
        return arrayOf(enums_declaration, field_declaration, method_declaration, domain_declaration, class_declaration, trait_declaration)
    }

    override fun getName(): String {
        return "ValkyrieLineMarkerProvider"
    }

    override fun getIcon(): Icon? {
        return super.getIcon()
    }


    override fun collectNavigationMarkers(element: PsiElement, result: MutableCollection<in RelatedItemLineMarkerInfo<*>>) {
        val visitor = ValkyrieMarkerVisitor(this, result)
        element.accept(visitor)
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
                        result.add(ClassDescendantMarker(leaf, definition))
                    }

                    is ValkyrieDeclareTraitNode -> {
                        result.add(ClassImplementMarker(leaf, definition))
                    }
                }
            }
        }
    }

    override fun visitDeclareTrait(o: ValkyrieDeclareTrait) {
        if (!config.trait_declaration.isEnabled) return
        o as ValkyrieDeclareTraitNode
        val leaf = o.nameIdentifier?.firstChild ?: return
        if (Random.nextBoolean()) {
            ValkyrieMarkTrait.standalone(o)?.let { result.add(it) }
        } else {
            ValkyrieMarkTrait.descendant(o, o)?.let { result.add(it) }
            ValkyrieMarkTrait.descendant(o, o)?.let { result.add(it) }
            ValkyrieMarkTrait.descendant(o, o)?.let { result.add(it) }
        }
    }

    override fun visitTraitAlias(o: ValkyrieTraitAlias) {

    }

    override fun visitDeclareUnion(o: ValkyrieDeclareUnion) {
        o as ValkyrieDeclareUnionNode
//        result.add(ValkyrieMarkAny(o))
    }

    override fun visitDeclareEnumerate(o: ValkyrieDeclareEnumerate) {
        if (config.enums_declaration.isEnabled) {
            result.add(ValkyrieMarkEnumeration(o as ValkyrieDeclareEnumerateNode))
        }
    }

    override fun visitDeclareFlags(o: ValkyrieDeclareFlags) {
        o as ValkyrieDeclareFlagsNode
//        result.add(ValkyrieMarkAny(o))
    }

    override fun visitDeclareField(o: ValkyrieDeclareField) {
        if (config.field_declaration.isEnabled) {
            result.add(ValkyrieMarkField(o as ValkyrieDeclareFieldNode))
        }
    }

    override fun visitDeclareMethod(o: ValkyrieDeclareMethod) {
        if (config.method_declaration.isEnabled) {
            result.add(ValkyrieMarkMethod(o as ValkyrieDeclareMethodNode))
        }
        createFunctionTest(o, o.annotations)
    }

    override fun visitDeclareDomain(o: ValkyrieDeclareDomain) {
        if (config.domain_declaration.isEnabled) {

        }
    }

    override fun visitDeclareUnite(o: ValkyrieDeclareUnite) {
        o as ValkyrieDeclareUniteNode
//        result.add(ValkyrieMarkAny(o))
    }

    override fun visitDeclareFunction(o: ValkyrieDeclareFunction) {
        o as ValkyrieDeclareFunctionNode
//        result.add(ValkyrieMarkAny(o))
    }

    override fun visitDeclareMacro(o: ValkyrieDeclareMacro) {
        o as ValkyrieDeclareMacroNode
//        result.add(ValkyrieMarkAny(o))
    }

    override fun visitNewLambda(o: ValkyrieNewLambda) {
        o as ValkyrieNewLambdaNode
//        result.add(ValkyrieMarkAny(o.firstChild, o.getIcon(0)))
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
        markLeaf(o.firstChild, Stop)
    }

    override fun visitControlContinue(o: ValkyrieControlContinue) {
        markLeaf(o.firstChild, Then)
    }

    override fun visitControlBreak(o: ValkyrieControlBreak) {
        markLeaf(o.firstChild, Then)
    }

    override fun visitControlThrough(o: ValkyrieControlThrough) {
        markLeaf(o.firstChild, Then)
    }

    override fun visitControlResume(o: ValkyrieControlResume) {
        markLeaf(o.firstChild, ExpUiIcons.Actions.Filterdups)
    }

    override fun visitControlRaise(o: ValkyrieControlRaise) {
        markLeaf(o.firstChild, ExpUiIcons.General.Upload)
    }


    private fun markLeaf(leaf: PsiElement, icon: Icon) {
//        result.add(ValkyrieMarkAny(leaf, icon))
    }

    fun markYieldWith(o: PsiElement) {
        for (child in o.childrenWithLeaves) {
            if (child.elementType == ValkyrieTypes.KW_WITH) {
                markLeaf(o.firstChild, Then)
                return
            }
        }
        markLeaf(o.firstChild, Stop)
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


