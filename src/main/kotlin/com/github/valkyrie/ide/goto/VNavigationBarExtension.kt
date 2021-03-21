package com.github.valkyrie.ide.goto

import com.intellij.codeInsight.CodeInsightBundle
import com.intellij.ide.navigationToolbar.AbstractNavBarModelExtension
import com.intellij.openapi.application.ReadAction
import com.intellij.openapi.module.Module
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.*
import com.intellij.openapi.vfs.VfsUtil
import com.intellij.psi.*
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.util.Processor

/// 重写导航栏
class VNavigationBarExtension : AbstractNavBarModelExtension() {
    override fun getPresentableText(`object`: Any?): String? = when (`object`) {
        is Project -> `object`.name
        is Module -> `object`.name
        is PsiFile -> `object`.virtualFile?.presentableName ?: `object`.name
        is PsiDirectory -> `object`.virtualFile.name
        is JdkOrderEntry -> `object`.jdkName
        is LibraryOrderEntry -> `object`.libraryName ?: CodeInsightBundle.message("package.dependencies.library.node.text")
        is ModuleOrderEntry -> `object`.moduleName
        else -> null
    }


    override fun adjustElement(psiElement: PsiElement): PsiElement {
        val containingFile = psiElement.containingFile
        return containingFile ?: psiElement
    }

    override fun processChildren(`object`: Any?, rootElement: Any?, processor: Processor<Any>): Boolean {
        if (`object` is Project) {
            return processChildren(`object`, processor)
        } else if (`object` is Module) {
            return processChildren(`object`, processor)
        } else if (`object` is PsiDirectoryContainer) {
            val psiPackage = `object`
            val psiDirectories = ReadAction.compute<Array<PsiDirectory>, RuntimeException> {
                if (rootElement is Module) psiPackage.getDirectories(
                    GlobalSearchScope.moduleScope((rootElement as Module?)!!)
                ) else psiPackage.directories
            }
            for (psiDirectory in psiDirectories) {
                if (!Companion.processChildren(psiDirectory, rootElement, processor)) return false
            }
            return true
        } else if (`object` is PsiDirectory) {
            return Companion.processChildren(`object`, rootElement, processor)
        } else if (`object` is PsiFileSystemItem) {
            return processChildren(`object`, processor)
        }
        return true
    }

    override fun getParent(psiElement: PsiElement): PsiElement? {
        val containingFile = psiElement.containingFile
        if (containingFile != null) {
            val containingDirectory = containingFile.containingDirectory
            if (containingDirectory != null) {
                return containingDirectory
            }
        } else if (psiElement is PsiDirectory) {
            val psiDirectory = psiElement
            val project = psiElement.getProject()
            var parentDirectory = psiDirectory.parentDirectory
            if (parentDirectory == null) {
                val jar = VfsUtil.getLocalFile(psiDirectory.virtualFile)
                if (ProjectRootManager.getInstance(project).fileIndex.isInContent(jar)) {
                    parentDirectory = PsiManager.getInstance(project).findDirectory(jar.parent)
                }
            }
            return parentDirectory
        } else if (psiElement is PsiFileSystemItem) {
            val virtualFile = psiElement.virtualFile ?: return null
            val psiManager = psiElement.getManager()
            val resultElement: PsiElement?
            resultElement = if (virtualFile.isDirectory) {
                psiManager.findDirectory(virtualFile)
            } else {
                psiManager.findFile(virtualFile)
            }
            if (resultElement == null) return null
            val parentVFile = virtualFile.parent
            if (parentVFile != null) {
                val parentDirectory = psiManager.findDirectory(parentVFile)
                if (parentDirectory != null) {
                    return parentDirectory
                }
            }
        }
        return null
    }
}
