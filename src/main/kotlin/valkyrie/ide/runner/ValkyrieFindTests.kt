package valkyrie.ide.runner

import com.intellij.psi.PsiElement
import com.intellij.testIntegration.TestFinder
import valkyrie.language.ast.ValkyrieTraitStatement

//import valkyrie.language.psi.valkyrieContext
//import valkyrie.language.psi_node.ValkyrieClassStatementNode
//import valkyrie.language.psi_node.ValkyrieExtendsStatementNode
//import valkyrie.language.psi_node.ValkyrieIdentifierNode
//import valkyrie.language.psi_node.ValkyrieTraitStatementNode

class ValkyrieFindTests : TestFinder {
    override fun findSourceElement(from: PsiElement): PsiElement? {
        val ctx = from.context ?: return null;
        println("findSourceElement($from, $ctx)")
        return ctx
    }

    override fun isTest(element: PsiElement): Boolean {
        val ctx = element.parent.context;
        if (ctx is ValkyrieTraitStatement) {
            return true
        }
        return true
    }

    override fun findTestsForClass(element: PsiElement): MutableCollection<PsiElement> {
        println("findTestsForClass($element)")
        TODO("Not yet implemented")
    }

    override fun findClassesForTest(element: PsiElement): MutableCollection<PsiElement> {
        return when (val ctx = element.context) {
//            is ValkyrieIdentifierNode -> {
//                findClassesForTest(ctx)
//            }
//
//            is ValkyrieClassDeclaration -> {
//                mutableListOf(ctx)
//            }
//
//            is ValkyrieExtendsStatementNode -> {
//                mutableListOf(ctx)
//            }

            else -> mutableListOf()
        }
    }


}