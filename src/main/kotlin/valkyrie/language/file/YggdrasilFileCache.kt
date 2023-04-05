package valkyrie.language.file

import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.psi.PsiNameIdentifierOwner
import yggdrasil.psi.node.*

class YggdrasilFileCache(val root: ValkyrieFileNode) {
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
                is ValkyrieDeclareClass -> child.createLookup(completions)
                is ValkyrieDeclareUnion -> child.createLookup(completions)
                is ValkyrieDeclareUnite -> child.createLookup(completions)
            }
        }
        return completions
    }


    fun find(name: ValkyrieIdentifierNode?): PsiNameIdentifierOwner? {
        return getCache()[name?.text]
    }
}