package com.github.valkyrie.ide.usages

import com.github.valkyrie.language.psi_node.ValkyrieClassStatementNode
import com.intellij.find.findUsages.DefaultFindUsagesHandlerFactory
import com.intellij.find.findUsages.FindUsagesHandler
import com.intellij.find.findUsages.FindUsagesHandlerFactory
import com.intellij.psi.PsiElement

class ValkyrieUsagesFactory : FindUsagesHandlerFactory() {
    override fun canFindUsages(element: PsiElement): Boolean {
        when (element) {
            is ValkyrieClassStatementNode -> return true
            else -> TODO("Not yet implemented")
        }
    }
    override fun createFindUsagesHandler(element: PsiElement, forHighlightUsages: Boolean): FindUsagesHandler? {
        return when (element) {
            is ValkyrieClassStatementNode -> ValkyrieUsagesHandler(element)
            else -> null
        }
    }
}