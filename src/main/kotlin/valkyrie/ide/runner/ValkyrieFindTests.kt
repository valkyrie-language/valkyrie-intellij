package valkyrie.ide.runner

import com.intellij.psi.PsiElement
import com.intellij.testIntegration.TestFinder

class ValkyrieFindTests : TestFinder {
    override fun findSourceElement(from: PsiElement): PsiElement? {
        println("findSourceElement($from)")
        TODO("Not yet implemented")
    }

    override fun findTestsForClass(element: PsiElement): MutableCollection<PsiElement> {
        println("findTestsForClass($element)")
        TODO("Not yet implemented")
    }

    override fun findClassesForTest(element: PsiElement): MutableCollection<PsiElement> {
        println("findClassesForTest($element)")
        TODO("Not yet implemented")

    }

    override fun isTest(element: PsiElement): Boolean {
        println("isTest($element)")
        TODO("Not yet implemented")
    }
}