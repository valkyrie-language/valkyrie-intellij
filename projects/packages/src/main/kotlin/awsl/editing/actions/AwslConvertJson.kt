package awsl.editing.actions

import awsl.editing.structure.AwslIconProvider
import awsl.surface.file.AwslBundle
import awsl.surface.file.AwslFileType
import com.intellij.ide.actions.CreateFileAction
import com.intellij.json.psi.JsonFile
import com.intellij.json.psi.JsonObject
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.LangDataKeys
import com.intellij.openapi.application.WriteAction
import com.intellij.psi.PsiDirectory
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiFileFactory
import java.util.function.Supplier

class AwslConvertJson :
    CreateFileAction(
        Supplier { AwslBundle.message("action.convert_html") },
        Supplier { AwslBundle.message("action.convert_html.description") },
        Supplier { AwslIconProvider.AwslFile },
    ) {
    private var sourceFile: PsiFile? = null

    override fun update(event: AnActionEvent) {
        sourceFile = LangDataKeys.PSI_FILE.getData(event.dataContext)
        super.update(event)
    }

    override fun create(newName: String, directory: PsiDirectory): Array<out PsiElement> {
        val mkdirs = MkDirs(newName, directory)
        val array = when (sourceFile) {
            is JsonFile -> createFromJson(sourceFile as JsonFile, newName)
            else -> null
        }
        array?.let {
            mkdirs.directory.add(it.originalElement)
            return arrayOf(WriteAction.compute<PsiFile, RuntimeException> { it })
        }
        return emptyArray()
    }
}

fun createFromJson(source: JsonFile, name: String): PsiFile? {
    val document = tryGetJsonSchema(source) ?: return null
    val buffer = StringBuilder()
    buffer.append(
        """${document.propertyList}
""",
    )
    return PsiFileFactory.getInstance(source.project).createFileFromText(name, AwslFileType.INSTANCE, buffer)
}

fun tryGetJsonSchema(file: PsiFile): JsonObject? {
    if (file is JsonFile) {
        when (val root = file.topLevelValue) {
            is JsonObject -> {
                if (root.findProperty("\$schema") != null) {
                    return root
                }
            }
        }
    }
    return null
}
