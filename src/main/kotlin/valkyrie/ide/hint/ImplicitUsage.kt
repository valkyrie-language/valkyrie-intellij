package valkyrie.ide.hint

import com.intellij.codeInsight.daemon.ImplicitUsageProvider
import com.intellij.psi.PsiElement

class ImplicitUsage : ImplicitUsageProvider {
    override fun isImplicitUsage(element: PsiElement): Boolean {
        TODO("Not yet implemented")
    }

    override fun isImplicitRead(element: PsiElement): Boolean {
        TODO("Not yet implemented")
    }

    override fun isImplicitWrite(element: PsiElement): Boolean {
        TODO("Not yet implemented")
    }

    override fun isClassWithCustomizedInitialization(element: PsiElement): Boolean {
        return super.isClassWithCustomizedInitialization(element)
    }

    override fun isImplicitlyNotNullInitialized(element: PsiElement): Boolean {
        return super.isImplicitlyNotNullInitialized(element)
    }
}
