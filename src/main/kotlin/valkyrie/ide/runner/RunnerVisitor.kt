package valkyrie.ide.runner

import com.intellij.execution.lineMarker.RunLineMarkerContributor
import com.intellij.execution.testframework.*
import com.intellij.execution.testframework.actions.TestDiffProvider
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.testIntegration.TestFinder
import com.intellij.util.config.BooleanProperty
import valkyrie.psi.node.*

class RunnerVisitor : ValkyrieVisitor() {
    var task: RunLineMarkerContributor.Info? = null

    override fun visitDeclareNamespace(o: ValkyrieDeclareNamespace) {
        task = RunLineMarkerContributor.Info(RunNamespaceGroup(o as ValkyrieDeclareNamespaceNode))
    }

    override fun visitDeclareClass(o: ValkyrieDeclareClass) {
        task = RunLineMarkerContributor.Info(RunClass(listOf("element"), false))
    }

    override fun visitDeclareImply(o: ValkyrieDeclareImply) {
        task = RunLineMarkerContributor.Info(RunClassGroup())
    }

}

private fun ValkyrieAnnotations.hasRunner(): Boolean {
    for (node in attributeList) {
        node as ValkyrieAttributeNode
        return when (node.name) {
            "test" -> true
            "bench" -> true
            else -> continue
        }
    }

    for (node in modifierList) {
        node as ValkyrieModifierNode
        return when (node.name) {
            "test" -> true
            "bench" -> true
            else -> continue
        }
    }
    return false
}

class ValkyrieFindTests : TestFinder {
    override fun findSourceElement(from: PsiElement): PsiElement? {
        println("findSourceElement: $from")
        return null
    }

    override fun findTestsForClass(element: PsiElement): MutableCollection<PsiElement> {
        println("findTestsForClass: $element")
        return mutableSetOf()
    }

    override fun findClassesForTest(element: PsiElement): MutableCollection<PsiElement> {
        println("findClassesForTest: $element")
        return mutableSetOf()
    }

    override fun isTest(element: PsiElement): Boolean {
        println("isTest: $element")
        return true
    }

}

class VTestActionProvider : ToggleModelActionProvider {
    override fun createToggleModelAction(properties: TestConsoleProperties?): ToggleModelAction {
        return object : ToggleModelAction(
            "ToggleModelAction",
            "ToggleModelAction",
            null,
            properties,
            object : BooleanProperty("BooleanProperty", false) {}) {
            override fun isEnabled(): Boolean {
                TODO("Not yet implemented")
            }

            override fun setModel(model: TestFrameworkRunningModel?) {
                TODO("Not yet implemented")
            }

        }
    }
}

class VTestStatusListener : TestStatusListener() {
    override fun testSuiteFinished(root: AbstractTestProxy?) {
        println("testSuiteFinished: $root")
    }
}

class VTestDiffProvider : TestDiffProvider {
    override fun updateExpected(element: PsiElement, actual: String) {
        println("updateExpected: $element")
    }

    override fun findExpected(project: Project, stackTrace: String, expected: String): PsiElement? {
        println("findExpected: $expected")
        return null
    }

}