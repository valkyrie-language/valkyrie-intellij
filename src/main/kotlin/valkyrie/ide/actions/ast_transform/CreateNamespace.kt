package valkyrie.ide.actions.ast_transform

import com.intellij.codeInsight.intention.PriorityAction
import com.intellij.codeInspection.LocalQuickFixAndIntentionActionOnPsiElement
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Iconable
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.impl.CheckUtil
import valkyrie.language.ValkyrieBundle
import valkyrie.language.file.ValkyrieFileNode
import valkyrie.language.file.ValkyrieIconProvider
import javax.swing.Icon

class CreateNamespace : LocalQuickFixAndIntentionActionOnPsiElement, PriorityAction, Iconable {
    private val element: ValkyrieFileNode

    constructor(element: ValkyrieFileNode) : super(element) {
        this.element = element
    }

    override fun startInWriteAction(): Boolean {
        return true
    }

    override fun getFamilyName(): String {
        return "getFamilyName"
    }

    override fun getText(): String {
        return ValkyrieBundle.message("action.create.namespace.name")
    }

    fun getDescription(): String {
        return ValkyrieBundle.message("action.create.namespace.help")
    }

    override fun invoke(project: Project, file: PsiFile, editor: Editor?, startElement: PsiElement, endElement: PsiElement) {
        if (editor == null) {
            return
        }
        CheckUtil.checkWritable(element)
        if (element.name == "_.vk" || element.name == "index.vk") {
            createIndexNamespace()
        }
        val indexFile = element.containingDirectory?.findFile("_.vk") as? ValkyrieFileNode;
        if (indexFile != null) {
            createElementNamespace(indexFile, editor)
        }
    }

    private fun createIndexNamespace() {

    }

    private fun createElementNamespace(indexFile: ValkyrieFileNode, editor: Editor) {
        val sb = StringBuilder("namespace ");
        val thisFile = element.containingFile as ValkyrieFileNode;
        val indexName = indexFile.namespace ?: return
        val fileName = thisFile.namespace
        if (fileName == null) {
            sb.append(indexName.namepath?.text)
            sb.append(";\n")
            editor.document.insertString(0, sb.toString())
        } else {
            // check name same
        }
    }

    override fun getIcon(flags: Int): Icon {
        return ValkyrieIconProvider.Instance.NAMESPACE
    }

    override fun getPriority(): PriorityAction.Priority {
        return PriorityAction.Priority.LOW
    }
}