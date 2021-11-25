package valkyrie.language.psi

import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import valkyrie.language.ast.ValkyrieASTBase

interface ValkyrieContext : PsiElement {
}

fun PsiFile?.caretElement(editor: Editor?): PsiElement? {
    val offset = editor?.caretModel?.offset ?: return null
    return this?.findElementAt(offset)
}

fun PsiElement?.valkyrieContext(): ValkyrieContext? {
    if (this == null) return null
    for (node in this.ancestors) {
        if (node is ValkyrieContext) {
            return node
        }
    }
    return null;
}

