package valkyrie.ide.runner

import com.intellij.psi.PsiElement
import com.intellij.testIntegration.TestFinder

class FindTests : TestFinder {
    override fun findSourceElement(from: PsiElement): PsiElement? {
        TODO("Not yet implemented")
    }

    override fun findTestsForClass(element: PsiElement): MutableCollection<PsiElement> {
        TODO("Not yet implemented")
    }

    override fun findClassesForTest(element: PsiElement): MutableCollection<PsiElement> {
        TODO("Not yet implemented")
    }

    override fun isTest(element: PsiElement): Boolean {
        TODO("Not yet implemented")
    }
}