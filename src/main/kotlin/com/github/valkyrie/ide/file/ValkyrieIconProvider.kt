package com.github.valkyrie.ide.file

import com.intellij.icons.AllIcons
import com.intellij.ide.IconProvider
import com.intellij.openapi.util.IconLoader
import com.intellij.psi.PsiElement
import javax.swing.Icon

class ValkyrieIconProvider : IconProvider() {
    override fun getIcon(psiElement: PsiElement, flags: Int): Icon? {
        val file = psiElement.containingFile
        return when {
            file != null && file.name.endsWith(".vk") -> {
                FILE
            }
            else -> {
                null
            }
        }
    }

    companion object {
        val FILE = IconLoader.getIcon("/icons/vk.svg", ValkyrieIconProvider::class.java)
        val NAMESPACE = AllIcons.Nodes.Artifact
        val KEYWORDS = AllIcons.Nodes.MultipleTypeDefinitions
        // val IMPORT = AllIcons.Welcome.Import
        val IMPORT = AllIcons.Nodes.EntryPoints
        val MODIFIER = AllIcons.Nodes.MethodReference
        val MACRO = AllIcons.Gutter.ExtAnnotation
        val ANNOTATION = AllIcons.Nodes.Annotationtype
        val OPERATOR = AllIcons.Actions.RegexSelected
        val CLASS = AllIcons.Nodes.Class
        val TRAIT = AllIcons.Nodes.Interface

        val FUNCTION = AllIcons.Nodes.Method
        val FIELD = AllIcons.Nodes.Field
    }
}