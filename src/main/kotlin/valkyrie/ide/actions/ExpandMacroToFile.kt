package valkyrie.ide.actions

import com.intellij.icons.AllIcons
import com.intellij.internal.statistic.collectors.fus.fileTypes.FileTypeUsageCounterCollector
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.LangDataKeys
import com.intellij.openapi.application.WriteAction
import com.intellij.psi.PsiFile
import valkyrie.language.ValkyrieBundle
import java.nio.file.Files
import java.nio.file.Paths

private val name = ValkyrieBundle.message("action.macro.expand_file")
private val description = ValkyrieBundle.message("action.convert_prop.description")

class ExpandMacroToFile : AnAction(name, description, AllIcons.Actions.Preview) {
    override fun actionPerformed(e: AnActionEvent) {
        val src = LangDataKeys.PSI_FILE.getData(e.dataContext) ?: return
        val dir = src.containingDirectory;
        val name = src.virtualFile.nameWithoutExtension;
        val filePath = dir.virtualFile.path + "/" + name + ".g.vk"
        print("${src.virtualFile}: ${src.virtualFile.extension},  $name")
        if (src.virtualFile.extension == "g.vk") return
//        val mkdirs = MkDirs(name, src.containingDirectory)
        val file = WriteAction.compute<PsiFile, RuntimeException> {
            Files.deleteIfExists(Paths.get(filePath))
            src.containingDirectory.createFile("$name.g.vk")
        }


        FileTypeUsageCounterCollector.triggerCreate(file.project, file.virtualFile)
//        return arrayOf<PsiElement>(file)
    }
}
