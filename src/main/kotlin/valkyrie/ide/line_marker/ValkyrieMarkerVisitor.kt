package valkyrie.ide.line_marker

import com.intellij.codeInsight.daemon.LineMarkerInfo
import com.intellij.execution.lineMarker.RunLineMarkerContributor
import com.intellij.execution.lineMarker.RunLineMarkerProvider
import com.intellij.icons.AllIcons
import com.intellij.icons.ExpUiIcons
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType
import valkyrie.ide.runner.RunTest
import valkyrie.ide.runner.RunTestDebugMode
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.psi.ValkyrieTypes
import valkyrie.psi.childrenWithLeaves
import valkyrie.psi.mixin.superClasses
import valkyrie.psi.node.*
import javax.swing.Icon
import kotlin.random.Random

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
        if (Random.nextBoolean()) {
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
        result.add(ValkyrieMarkAny(o.firstChild, o.getIcon(0)))
    }

    override fun visitDeclareUnite(o: ValkyrieDeclareUnite) {
        o as ValkyrieDeclareUniteNode
        result.add(ValkyrieMarkAny(o))
    }

    override fun visitNewValue(o: ValkyrieNewValue) {
        o as ValkyrieNewValueNode
        result.add(ValkyrieMarkAny(o.firstChild, o.getIcon(0)))
    }

    override fun visitDeclareFunction(o: ValkyrieDeclareFunction) {
        o as ValkyrieDeclareFunctionNode
        result.add(ValkyrieMarkAny(o))
    }

    override fun visitDeclareMacro(o: ValkyrieDeclareMacro) {
        o as ValkyrieDeclareMacroNode
        result.add(ValkyrieMarkAny(o))
    }

    override fun visitNewLambda(o: ValkyrieNewLambda) {
        o as ValkyrieNewLambdaNode
        result.add(ValkyrieMarkAny(o.firstChild, o.getIcon(0)))
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
        markLeaf(o.firstChild, ValkyrieIconProvider.Instance.Stop)
    }

    override fun visitControlContinue(o: ValkyrieControlContinue) {
        markLeaf(o.firstChild, ValkyrieIconProvider.Instance.Then)
    }

    override fun visitControlBreak(o: ValkyrieControlBreak) {
        markLeaf(o.firstChild, ValkyrieIconProvider.Instance.Then)
    }

    override fun visitControlThrough(o: ValkyrieControlThrough) {
        markLeaf(o.firstChild, ValkyrieIconProvider.Instance.Then)
    }

    override fun visitControlResume(o: ValkyrieControlResume) {
        markLeaf(o.firstChild, ExpUiIcons.Actions.Filterdups)
    }

    override fun visitControlRaise(o: ValkyrieControlRaise) {
        markLeaf(o.firstChild, ExpUiIcons.General.Upload)
    }


    private fun markLeaf(leaf: PsiElement, icon: Icon) {
        result.add(ValkyrieMarkAny(leaf, icon))
    }

    fun markYieldWith(o: PsiElement) {
        for (child in o.childrenWithLeaves) {
            if (child.elementType == ValkyrieTypes.KW_WITH) {
                markLeaf(o.firstChild, ValkyrieIconProvider.Instance.Then)
                return
            }
        }
        markLeaf(o.firstChild, ValkyrieIconProvider.Instance.Stop)
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
