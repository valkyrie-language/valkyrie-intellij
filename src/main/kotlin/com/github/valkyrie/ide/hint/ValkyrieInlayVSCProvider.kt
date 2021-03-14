package com.github.valkyrie.ide.hint

import com.intellij.codeInsight.hints.VcsCodeVisionLanguageContext
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement
import java.awt.event.MouseEvent

@Suppress("UnstableApiUsage")
class ValkyrieInlayVSCProvider: VcsCodeVisionLanguageContext {
    override fun handleClick(mouseEvent: MouseEvent, editor: Editor, element: PsiElement) {
        TODO("Not yet implemented")
    }

    override fun isAccepted(element: PsiElement): Boolean {
        return true
    }
}