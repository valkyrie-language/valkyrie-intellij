package valkyrie.language.file

import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.psi.PsiNameIdentifierOwner
import yggdrasil.psi.node.ValkyrieDeclareClassNode
import yggdrasil.psi.node.ValkyrieIdentifierNode

class YggdrasilFileCache(val root: YggdrasilFileNode) {
    private fun getCache(): MutableMap<String, PsiNameIdentifierOwner> {
        val cache = mutableMapOf<String, PsiNameIdentifierOwner>()

        for (child in root.children) {
            when (child) {
                is ValkyrieDeclareClassNode -> {
                    cache[child.name] = child
                }

//                is ValkyrieDefineUnionNode -> {
//                    cache[child.name] = child
//                }
//
//                is ValkyrieGroupNode -> {
//                    for (item in child.tokenList) {
//                        cache[item.name] = item
//                    }
//                }
            }
        }
        return cache
    }

    fun getCompletions(): MutableList<LookupElement> {
        val completions = mutableListOf<LookupElement>()
        for (child in root.children) {
            when (child) {
                is ValkyrieDeclareClassNode -> {
                    child.createLookup(completions)
                }

//                is ValkyrieDefineUnion -> {
//                    child.createLookup(completions)
//                }
//
//                is ValkyrieGroupNode -> {
//                    for (item in child.tokenList) {
//                        item.createLookup(completions)
//                    }
//                }
            }
        }
        return completions
    }


    fun find(name: ValkyrieIdentifierNode?): PsiNameIdentifierOwner? {
        return getCache()[name?.text]
    }
}