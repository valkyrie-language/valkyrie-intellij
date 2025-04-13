package valkyrie.ide.codegen

//import valkyrie.language.psi_node.ValkyrieClassStatementNode
import com.intellij.codeInsight.intention.FileModifier
import com.intellij.lang.LanguageCodeInsightActionHandler
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.util.parents
import valkyrie.ast.node.ValkyrieClassNode
import valkyrie.ast.node.ValkyrieDeclareImplyNode
import valkyrie.ast.node.ValkyrieTraitNode
import valkyrie.psi.caretElement


class GenerateOverrides : LanguageCodeInsightActionHandler {
    private var _current: PsiElement? = null
    override fun isValidFor(editor: Editor?, file: PsiFile?): Boolean {
        val here = file.caretElement(editor) ?: return false

        for (parent in here.parents(true)) {
            when (parent) {
                is ValkyrieClassNode -> true
                is ValkyrieTraitNode -> true
                is ValkyrieDeclareImplyNode -> true
                else -> {
                    _current = parent
                    return true
                }
            }
        }
        return false
    }


    override fun invoke(project: Project, editor: Editor, file: PsiFile) {
        when (_current) {
            is ValkyrieClassNode -> {
                val here = _current as ValkyrieClassNode


                val ui = GenerateClassFieldChooser(
                    here, project
                )
                ui.pack()
                ui.show()
                println(ui.selectedElements)
            }
        }


    }

    override fun getFileModifierForPreview(target: PsiFile): FileModifier? {
        val mods = super.getFileModifierForPreview(target)
        println("getFileModifierForPreview: ${mods}")
        return mods
    }

}


