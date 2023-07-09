package valkyrie.project

import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.search.ProjectAndLibrariesScope
import com.intellij.util.indexing.*
import com.intellij.util.io.DataExternalizer
import valkyrie.language.file.ValkyrieFileNode
import java.io.DataInput
import java.io.DataOutput

class ValkyrieFileIndex : SingleEntryFileBasedIndexExtension<ValkyrieFileData>() {
    companion object {
        val id = ID.create<Int, ValkyrieFileData>("valkyrie.file.index")
        fun getFileData(project: Project, file: VirtualFile): List<ValkyrieFileData> {
            val output = mutableListOf<ValkyrieFileData>()
            val keys = FileBasedIndex.getInstance().getAllKeys(id, project);
            for (key in keys) {
                val values = FileBasedIndex.getInstance().getValues(id, key, ProjectAndLibrariesScope(project));
                for (value in values) {
                    if (value.path == file.path) {
                        output.add(value)
                    }
                }
            }
            return output
        }
    }

    override fun getName(): ID<Int, ValkyrieFileData> {
        return id
    }

    override fun getIndexer(): SingleEntryIndexer<ValkyrieFileData> {
        return object : SingleEntryIndexer<ValkyrieFileData>(false) {
            override fun computeValue(inputData: FileContent): ValkyrieFileData {
                return ValkyrieFileData(inputData.psiFile as ValkyrieFileNode)
            }
        }
    }

    override fun getValueExternalizer(): DataExternalizer<ValkyrieFileData> {
        return object : DataExternalizer<ValkyrieFileData> {
            override fun save(out: DataOutput, value: ValkyrieFileData) {
                value.save(out)
            }

            override fun read(`in`: DataInput): ValkyrieFileData {
                return ValkyrieFileData(`in`)
            }
        }
    }

    override fun getVersion(): Int {
        return 1
    }

    override fun getInputFilter(): FileBasedIndex.InputFilter {
        return FileBasedIndex.InputFilter { file -> file.extension == "vk" }
    }
}

