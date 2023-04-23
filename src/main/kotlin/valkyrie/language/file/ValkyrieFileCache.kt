package valkyrie.language.file

import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.psi.PsiNameIdentifierOwner
import valkyrie.psi.node.*

class ValkyrieFileCache(val root: ValkyrieFileNode) {
    fun getCache(): MutableMap<String, PsiNameIdentifierOwner> {
        val cache = mutableMapOf<String, PsiNameIdentifierOwner>()

        for (child in root.children) {
            when (child) {
                is ValkyrieDeclareClassNode -> {
                    cache[child.name!!] = child
                }
                is ValkyrieDeclareTraitNode -> {
                    cache[child.name!!] = child
                }

                is ValkyrieTraitAliasNode -> {
                    cache[child.name!!] = child
                }
                is ValkyrieDeclareUnionNode -> {
                    cache[child.name!!] = child
                }

                is ValkyrieDeclareUniteNode -> {
                    cache[child.name!!] = child
                }
            }
        }
        return cache
    }

    fun getCompletions(): MutableList<LookupElement> {
        val completions = mutableListOf<LookupElement>()
        for (child in root.children) {
            when (child) {
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