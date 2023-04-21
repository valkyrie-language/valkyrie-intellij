package valkyrie.language.file

import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.psi.PsiNameIdentifierOwner
import valkyrie.psi.node.ValkyrieDeclareClassNode
import valkyrie.psi.node.ValkyrieDeclareUnionNode
import valkyrie.psi.node.ValkyrieDeclareUniteNode
import valkyrie.psi.node.ValkyrieIdentifierNode

class ValkyrieFileCache(val root: ValkyrieFileNode) {
    private fun getCache(): MutableMap<String, PsiNameIdentifierOwner> {
        val cache = mutableMapOf<String, PsiNameIdentifierOwner>()

        for (child in root.children) {
            when (child) {
                is ValkyrieDeclareClassNode -> {
                    cache[child.name] = child
                }

                is ValkyrieDeclareUnionNode -> {
                    cache[child.name] = child
                }

                is ValkyrieDeclareUniteNode -> {
                    cache[child.name] = child
                }
            }
        }
        return cache
    }

    fun getCompletions(): MutableList<LookupElement> {
        val completions = mutableListOf<LookupElement>()
        for (child in root.children) {
            when (child) {
                is ValkyrieDeclareClassNode -> child.createLookup(completions)
                is ValkyrieDeclareUnionNode -> child.createLookup(completions)
                is ValkyrieDeclareUniteNode -> child.createLookup(completions)
            }
        }
        return completions
    }


    fun find(name: ValkyrieIdentifierNode?): PsiNameIdentifierOwner? {
        return getCache()[name?.text]
    }
}