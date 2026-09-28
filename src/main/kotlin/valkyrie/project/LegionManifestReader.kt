package valkyrie.project

import com.github.voml.voml_intellij.language.VonFile
import com.intellij.json.psi.JsonFile
import com.intellij.json.psi.JsonObject
import com.intellij.openapi.application.ReadAction
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiManager

object LegionManifestDocuments {
    const val LEGION_JSON = "legion.json"
    const val LEGION_VON = "legion.von"
    const val LEGIONS_JSON = "legions.json"
    const val LEGIONS_VON = "legions.von"
}

object LegionManifestReader {
    fun findLegionManifest(directory: VirtualFile): VirtualFile? {
        if (!directory.isDirectory) return null
        return sequenceOf(LegionManifestDocuments.LEGION_VON, LegionManifestDocuments.LEGION_JSON)
            .mapNotNull { name -> directory.findChild(name)?.takeIf { it.exists() && !it.isDirectory } }
            .firstOrNull()
    }

    fun findLegionsManifest(directory: VirtualFile): VirtualFile? {
        if (!directory.isDirectory) return null
        return sequenceOf(LegionManifestDocuments.LEGIONS_VON, LegionManifestDocuments.LEGIONS_JSON)
            .mapNotNull { name -> directory.findChild(name)?.takeIf { it.exists() && !it.isDirectory } }
            .firstOrNull()
    }

    fun readRoot(project: Project, manifestFile: VirtualFile): LegionManifestObject? {
        return ReadAction.compute<LegionManifestObject?, RuntimeException> {
            readRootUnsafe(project, manifestFile)
        }
    }

    private fun readRootUnsafe(project: Project, manifestFile: VirtualFile): LegionManifestObject? {
        return try {
            val psiFile = PsiManager.getInstance(project).findFile(manifestFile) ?: return null
            when (psiFile) {
                is JsonFile -> {
                    val root = psiFile.topLevelValue as? JsonObject ?: return null
                    LegionManifestObject.fromJson(root)
                }

                is VonFile -> {
                    val rootTable = LegionManifestObject.rootTable(psiFile) ?: return null
                    LegionManifestObject.fromVon(rootTable)
                }

                else -> null
            }
        } catch (_: Exception) {
            null
        }
    }
}
