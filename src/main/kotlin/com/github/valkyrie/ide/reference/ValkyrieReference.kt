package com.github.valkyrie.ide.reference

import com.github.valkyrie.ide.file.ValkyrieFile
import com.github.valkyrie.ide.file.ValkyrieFileType
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.TextRange
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.*
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.util.PsiTreeUtil


class ValkyrieReference(element: PsiElement, textRange: TextRange) :
    PsiReferenceBase<PsiElement?>(element, textRange),
    PsiPolyVariantReference {
    private val key: String

    init {
        key = element.text.substring(textRange.startOffset, textRange.endOffset)
    }

    override fun resolve(): PsiElement? {
        val resolveResults = multiResolve(false)
        return when (resolveResults.size) {
            1 -> resolveResults[0].element
            else -> null
        }
    }

    override fun multiResolve(incompleteCode: Boolean): Array<ResolveResult> {
        val project = myElement!!.project
        val properties = findProperties(project, key)
        val results: MutableList<ResolveResult> = ArrayList()
        for (property in properties) {
            results.add(PsiElementResolveResult(property))
        }
        return results.toTypedArray()
    }

    fun findProperties(project: Project, key: String): List<PsiElement> {
        val result = ArrayList<PsiElement>()
        val virtualFiles: Collection<VirtualFile> = FileTypeIndex.getFiles(
            ValkyrieFileType.INSTANCE,
            GlobalSearchScope.allScope(project)
        )
        for (virtualFile in virtualFiles) {
            val file: ValkyrieFile? = PsiManager.getInstance(project).findFile(virtualFile) as ValkyrieFile?
            if (file != null) {
                val properties: Array<out PsiElement>? = PsiTreeUtil.getChildrenOfType(file, PsiElement::class.java)
                if (properties != null) {
                    for (property in properties) {
                        result.add(property)
                    }
                }
            }
        }
        return result
    }
}