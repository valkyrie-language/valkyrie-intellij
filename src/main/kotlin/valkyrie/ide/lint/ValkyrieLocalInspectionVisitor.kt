package valkyrie.ide.lint

import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.LocalQuickFix
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.HintedPsiElementVisitor
import com.intellij.psi.PsiElement
import valkyrie.psi.node.ValkyrieVisitor

abstract class ValkyrieLocalInspectionVisitor : ValkyrieVisitor, HintedPsiElementVisitor {
    private val _holder: ProblemsHolder
    protected val tool: LocalInspectionTool

    constructor(tool: LocalInspectionTool, holder: ProblemsHolder) : super() {
        this.tool = tool
        this._holder = holder
    }

    override fun getHintPsiElements(): MutableList<Class<*>> {
        return mutableListOf()
    }

    protected fun PsiElement.registerProblem(description: String, vararg fixes: LocalQuickFix) {
        _holder.registerProblem(
            this,
            description,
            *fixes
        )
    }
}