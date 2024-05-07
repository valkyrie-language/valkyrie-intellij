package valkyrie.ide.hint

import com.intellij.codeInsight.hint.ParameterInfoControllerBase
import com.intellij.codeInsight.hint.ParameterInfoControllerProvider
import com.intellij.lang.parameterInfo.ParameterInfoHandler
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement

class ParameterInfoController : ParameterInfoControllerProvider() {
    override fun doCreate(
        project: Project,
        editor: Editor,
        lbraceOffset: Int,
        descriptors: Array<out Any>?,
        highlighted: Any?,
        parameterOwner: PsiElement?,
        handler: ParameterInfoHandler<out PsiElement, *>,
        showHint: Boolean,
        requestFocus: Boolean,
    ): ParameterInfoControllerBase? {
        return null
    }
}
