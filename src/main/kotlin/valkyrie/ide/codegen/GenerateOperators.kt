package valkyrie.ide.codegen

import com.intellij.icons.AllIcons
import com.intellij.internal.statistic.collectors.fus.fileTypes.FileTypeUsageCounterCollector
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.LangDataKeys
import com.intellij.openapi.application.WriteAction
import com.intellij.psi.PsiDirectory
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiFileFactory
import valkyrie.language.ValkyrieBundle
import valkyrie.language.ValkyrieLanguage
import valkyrie.language.file.ValkyrieIconProvider

private val name = ValkyrieBundle.message("action.generate.operators.name")
private val description = ValkyrieBundle.message("action.generate.operators.help")

class GenerateOperators : AnAction(name, description, ValkyrieIconProvider.Operator) {
    override fun actionPerformed(e: AnActionEvent) {
        val src = LangDataKeys.PSI_FILE.getData(e.dataContext) ?: return
        if (isValidFile(src)) {
            val file = WriteAction.compute<PsiFile, RuntimeException> {
                createFile(src.containingDirectory, "${src.virtualFile.nameWithoutExtension}.g.vk", src.text)
            }
            FileTypeUsageCounterCollector.triggerCreate(file.project, file.virtualFile)
        }
//        return arrayOf<PsiElement>(file)
    }

    private fun isValidFile(file: PsiFile): Boolean {
        if (file.isDirectory) return false
        if (file.virtualFile.name.endsWith(".g.vk")) return false
        return true
    }

    private fun createFile(dir: PsiDirectory, fileName: String, text: String): PsiFile? {
        val builder = PsiFileFactory.getInstance(dir.project);
        for (child in dir.files) {
            if (child.name == fileName) {
                child.delete()
                break
            }
        }
        val file = builder.createFileFromText(fileName, ValkyrieLanguage, text)
        dir.add(file)
        return file;
    }

}