package valkyrie.ide.runner

import com.intellij.psi.PsiElement
import com.intellij.testIntegration.TestFinder

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