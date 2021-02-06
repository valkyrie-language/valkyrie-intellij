package com.github.valkyrie.ide.view

import com.intellij.ide.IconProvider
import com.intellij.openapi.util.IconLoader
import com.intellij.psi.PsiElement
import javax.swing.Icon

class ValkyrieIconProvider : IconProvider() {
    override fun getIcon(psiElement: PsiElement, flags: Int): Icon? {
        val fileName = psiElement.containingFile.name

        return when {
            fileName.endsWith(".vk") -> IconSVG
            else -> null
        }
    }

    companion object {
        val IconSVG = IconLoader.getIcon("/icons/vk.svg", ValkyrieIconProvider::class.java)
    }
}