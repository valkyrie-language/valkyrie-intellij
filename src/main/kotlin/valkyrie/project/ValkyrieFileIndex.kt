package valkyrie.project

import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.search.ProjectAndLibrariesScope
import com.intellij.util.indexing.*
import com.intellij.util.io.DataExternalizer
import valkyrie.language.file.ValkyrieFileNode
import valkyrie.psi.node.ValkyrieDeclareNamespace
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

class ValkyrieFileData {
    var path = "";
    var namespace: Array<String> = arrayOf();
    var errors: List<String> = listOf();


    constructor(file: ValkyrieFileNode) {
        path = file.virtualFile.path;
        for (child in file.children) {
            if (child is ValkyrieDeclareNamespace) {
                if (namespace.isEmpty()) {
                    // error, dup namespace
                } else {
                    // error, dup namespace
                }
            }
        }
    }

    override fun hashCode(): Int {
        return path.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        return when (other) {
            is ValkyrieFileData -> this.hashCode() == other.hashCode()
            else -> false
        }
    }

    fun save(data: DataOutput) {
        data.writeUTF(path)
        data.write(namespace.size)
        for (ns in namespace) {
            data.writeUTF(ns)
        }
    }

    constructor(data: DataInput) {
//        BinaryFormat.decodeFromByteArray(data.readUTF())
        path = data.readUTF()
    }

    override fun toString(): String {
        return super.toString()
    }
}