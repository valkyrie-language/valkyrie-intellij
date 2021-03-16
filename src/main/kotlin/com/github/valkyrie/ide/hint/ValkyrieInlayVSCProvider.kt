package com.github.valkyrie.ide.hint

import com.github.valkyrie.language.psi_node.ValkyrieClassStatementNode
import com.github.valkyrie.language.psi_node.ValkyrieTaggedStatementNode
import com.github.valkyrie.language.psi_node.ValkyrieTraitStatementNode
import com.intellij.codeInsight.editorActions.CodeBlockProvider
import com.intellij.codeInsight.hints.VcsCodeVisionLanguageContext
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import java.awt.event.MouseEvent

@Suppress("UnstableApiUsage")
class ValkyrieInlayVSCProvider : VcsCodeVisionLanguageContext {
    /// 额外的点击事件
    /// 本身会打开 Git Blame
    override fun handleClick(mouseEvent: MouseEvent, editor: Editor, element: PsiElement) {

    }

    override fun isAccepted(element: PsiElement): Boolean = when (element) {
        is ValkyrieTaggedStatementNode -> true
        is ValkyrieClassStatementNode -> true
        is ValkyrieTraitStatementNode -> true
        else -> false
    }
}

