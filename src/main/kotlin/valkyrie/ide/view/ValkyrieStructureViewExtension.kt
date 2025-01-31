package valkyrie.ide.view

import com.intellij.ide.structureView.StructureViewExtension
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement

class ValkyrieStructureViewExtension : StructureViewExtension {
    override fun getType(): Class<out PsiElement> {
        return PsiElement::class.java
    }

    override fun getChildren(parent: PsiElement?): Array<StructureViewTreeElement> {
        return arrayOf()
    }

    override fun getCurrentEditorElement(editor: Editor?, parent: PsiElement?): Any? {
        return null
    }
}