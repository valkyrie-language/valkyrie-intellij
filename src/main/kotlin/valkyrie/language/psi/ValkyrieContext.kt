package valkyrie.language.psi

import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile

interface ValkyrieContext : PsiElement {
}

fun PsiFile?.caretElement(editor: Editor?): PsiElement? {
    val offset = editor?.caretModel?.offset ?: return null
    return this?.findElementAt(offset)
}