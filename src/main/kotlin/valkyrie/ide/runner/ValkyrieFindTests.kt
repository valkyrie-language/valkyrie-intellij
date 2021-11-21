package valkyrie.ide.runner

import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType
import com.intellij.testIntegration.TestFinder
import valkyrie.language.psi.ValkyrieTypes
import valkyrie.language.psi_node.ValkyrieClassStatementNode
import valkyrie.language.psi_node.ValkyrieExtendsStatementNode
import valkyrie.language.psi_node.ValkyrieIdentifierNode
import valkyrie.language.psi_node.ValkyrieTraitStatementNode

class ValkyrieFindTests : TestFinder {
    override fun findSourceElement(from: PsiElement): PsiElement? {
        if (from.elementType == ValkyrieTypes.SYMBOL_XID) {
            return from
        }
        println("findSourceElement($from)")
        TODO("Not yet implemented")
    }

    override fun findTestsForClass(element: PsiElement): MutableCollection<PsiElement> {
        println("findTestsForClass($element)")
        TODO("Not yet implemented")
    }

    override fun findClassesForTest(element: PsiElement): MutableCollection<PsiElement> {
        return when (val ctx = element.context) {
            is ValkyrieIdentifierNode -> {
                findClassesForTest(ctx)
            }

            is ValkyrieClassStatementNode -> {
                mutableListOf(ctx)
            }

            is ValkyrieExtendsStatementNode -> {
                mutableListOf(ctx)
            }

            else -> mutableListOf()
        }
    }

    override fun isTest(element: PsiElement): Boolean {
        val ctx = element.parent.context;
        if (ctx is ValkyrieTraitStatementNode) {
            return true
        }
        return true
    }
}