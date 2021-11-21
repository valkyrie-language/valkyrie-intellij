package valkyrie.ide.navigation

import com.intellij.psi.PsiElement
import com.intellij.usages.Usage
import com.intellij.usages.UsageTarget
import com.intellij.usages.rules.ImportFilteringRule
import com.intellij.usages.rules.PsiElementUsage
import valkyrie.language.psi.ancestors
import valkyrie.language.psi_node.ValkyrieIdentifierNode
import valkyrie.language.psi_node.ValkyrieImportStatementNode

class ValkyrieImportFilter : ImportFilteringRule() {

    override fun isVisible(usage: Usage, targets: Array<out UsageTarget>): Boolean {
        for (target in targets) {
            println("isVisible3(${target})")
        }

        return super.isVisible(usage, targets)
    }

    override fun isVisible(usage: Usage): Boolean {
        if (usage is PsiElementUsage) {
            when (val element = usage.element) {
                is ValkyrieIdentifierNode -> {
                    return !inImport(element)
                }
                else -> println("isVisible4(${element})")
            }
        }
        return true
    }

    private fun inImport(id: ValkyrieIdentifierNode): Boolean {
        for (node in id.ancestors) {
            if (node is ValkyrieImportStatementNode) {
                return true
            }
        }
        return false
    }
}