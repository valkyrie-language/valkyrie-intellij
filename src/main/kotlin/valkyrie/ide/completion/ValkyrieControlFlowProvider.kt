package valkyrie.ide.completion

import com.intellij.codeInsight.controlflow.ControlFlow
import com.intellij.codeInsight.controlflow.ControlFlowProvider
import com.intellij.codeInsight.controlflow.Instruction
import com.intellij.psi.PsiElement

class ValkyrieControlFlowProvider : ControlFlowProvider {
    override fun getControlFlow(element: PsiElement): ControlFlow? {
        return null
    }

    override fun getAdditionalInfo(instruction: Instruction): String? {
        return null
    }
}