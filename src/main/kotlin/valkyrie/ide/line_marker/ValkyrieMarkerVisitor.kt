package valkyrie.ide.line_marker

import com.intellij.codeInsight.daemon.LineMarkerInfo
import com.intellij.execution.lineMarker.RunLineMarkerContributor
import com.intellij.execution.lineMarker.RunLineMarkerProvider
import com.intellij.icons.AllIcons
import com.intellij.psi.PsiElement
import valkyrie.ide.runner.RunTest
import valkyrie.ide.runner.RunTestDebugMode
import valkyrie.psi.node.*

class ValkyrieMarkerVisitor : ValkyrieVisitor {
    var result: MutableCollection<in LineMarkerInfo<*>>

    constructor(result: MutableCollection<in LineMarkerInfo<*>>) : super() {
        this.result = result
    }

    override fun visitDeclareClass(o: ValkyrieDeclareClass) {
        o as ValkyrieDeclareClassNode
        if (o.superClasses.isEmpty()) {
            ValkyrieMarkClass.standalone(o)?.let { result.add(it) }
        } else {
            ValkyrieMarkClass.ancestor(o)?.let { result.add(it) }
            ValkyrieMarkClass.ancestor(o)?.let { result.add(it) }
            ValkyrieMarkClass.descendant(o)?.let { result.add(it) }
            ValkyrieMarkClass.descendant(o)?.let { result.add(it) }
            ValkyrieMarkClass.descendant(o)?.let { result.add(it) }
        }
    }

    override fun visitDeclareTrait(o: ValkyrieDeclareTrait) {
        o as ValkyrieDeclareTraitNode
        if (kotlin.random.Random.nextBoolean()) {
            ValkyrieMarkInterface.standalone(o)?.let { result.add(it) }
        } else {
            ValkyrieMarkInterface.ancestor(o, o)?.let { result.add(it) }
            ValkyrieMarkInterface.ancestor(o, o)?.let { result.add(it) }
            ValkyrieMarkInterface.descendant(o, o)?.let { result.add(it) }
            ValkyrieMarkInterface.descendant(o, o)?.let { result.add(it) }
            ValkyrieMarkInterface.descendant(o, o)?.let { result.add(it) }
        }
    }

    override fun visitTraitAlias(o: ValkyrieTraitAlias) {

    }

    override fun visitDeclareUnion(o: ValkyrieDeclareUnion) {
        o as ValkyrieDeclareUnionNode
        result.add(ValkyrieMarkAny(o))
    }

    override fun visitDeclareEnumerate(o: ValkyrieDeclareEnumerate) {
        o as ValkyrieDeclareEnumerateNode
        result.add(ValkyrieMarkAny(o))
    }

    override fun visitDeclareFlags(o: ValkyrieDeclareFlags) {
        o as ValkyrieDeclareFlagsNode
        result.add(ValkyrieMarkAny(o))
    }

    override fun visitDeclareField(o: ValkyrieDeclareField) {
        o as ValkyrieDeclareFieldNode
        result.add(ValkyrieMarkAny(o))
    }

    override fun visitDeclareMethod(o: ValkyrieDeclareMethod) {
        o as ValkyrieDeclareMethodNode
        result.add(ValkyrieMarkAny(o))
        createFunctionTest(o, o.annotations)
    }

    override fun visitNewObject(o: ValkyrieNewObject) {
        o as ValkyrieNewObjectNode
        result.add(ValkyrieMarkAny(o))
    }

    override fun visitDeclareUnite(o: ValkyrieDeclareUnite) {
        o as ValkyrieDeclareUniteNode
        result.add(ValkyrieMarkAny(o))
    }

    override fun visitNewValue(o: ValkyrieNewValue) {
        o as ValkyrieNewValueNode
        result.add(ValkyrieMarkAny(o))
    }

    override fun visitDeclareFunction(o: ValkyrieDeclareFunction) {
        o as ValkyrieDeclareFunctionNode
        result.add(ValkyrieMarkAny(o))
    }


    override fun visitNewLambda(o: ValkyrieNewLambda) {
        o as ValkyrieNewLambdaNode
        result.add(ValkyrieMarkAny(o))
    }

    private fun createFunctionTest(source: PsiElement?, annotations: ValkyrieAnnotations?) {
        val leaf = findTest(annotations)
        if (source == null || leaf == null) {
            return
        }
        val info =
            RunLineMarkerContributor.Info(AllIcons.RunConfigurations.TestState.Run_run, { "te" }, RunTest(source), RunTestDebugMode(source));

        result.add(RunLineMarkerProvider.createLineMarker(leaf, info.icon, mutableListOf(info)))
    }

    private fun findTest(annotations: ValkyrieAnnotations?): PsiElement? {
        annotations ?: return null
        for (attr in annotations.attributeList) {
            attr as ValkyrieAttributeNode;
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
        for (item in body.classItemList) {
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