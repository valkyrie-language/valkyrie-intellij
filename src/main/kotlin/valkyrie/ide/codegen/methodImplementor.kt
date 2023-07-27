package valkyrie.ide.codegen

import com.intellij.codeInsight.MethodImplementor
import com.intellij.codeInsight.generation.GenerationInfo
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiMethod
import com.intellij.util.CollectConsumer
import com.intellij.util.Consumer

class methodImplementor : MethodImplementor {
    override fun getMethodsToImplement(aClass: PsiClass?): Array<PsiMethod> {
        return arrayOf()
    }

    override fun createImplementationPrototypes(inClass: PsiClass?, method: PsiMethod?): Array<PsiMethod> {
        return arrayOf()
    }

    override fun createGenerationInfo(method: PsiMethod?, mergeIfExists: Boolean): GenerationInfo? {
        return null
    }

    override fun createDecorator(
        targetClass: PsiClass?,
        baseMethod: PsiMethod?,
        toCopyJavaDoc: Boolean,
        insertOverrideIfPossible: Boolean,
    ): Consumer<PsiMethod> {
        return CollectConsumer(mutableListOf())
    }
}
