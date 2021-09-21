package valkyrie.ide.project

import com.intellij.util.indexing.*
import com.intellij.util.io.DataExternalizer
import com.intellij.util.io.KeyDescriptor
import valkyrie.ide.file.ValkyrieFileType
import java.io.DataInput
import java.io.DataOutput

class ValkyrieFileIndex : FileBasedIndexExtension<String, String>() {
    override fun getName(): ID<String, String> {
        return ID.create("valkyrie.file.index")
    }

    override fun getIndexer(): DataIndexer<String, String, FileContent> {
        return DataIndexer {
            val map = mutableMapOf<String, String>()
            map["key"] = "value"
            map
        }
    }

    override fun getKeyDescriptor(): KeyDescriptor<String> {
        return object : KeyDescriptor<String> {
            override fun getHashCode(value: String): Int {
                return value.hashCode()
            }

            override fun isEqual(val1: String, val2: String): Boolean {
                return val1 == val2
            }

            override fun save(out: DataOutput, value: String) {
                out.writeUTF(value)
            }

            override fun read(`in`: DataInput): String {
                return `in`.readUTF()
            }
        }
    }

    override fun getValueExternalizer(): DataExternalizer<String> {
        return object : DataExternalizer<String> {
            override fun save(out: DataOutput, value: String) {
                out.writeUTF(value)
            }

            override fun read(`in`: DataInput): String {
                return `in`.readUTF()
            }
        }
    }

    override fun getVersion(): Int {
        return 0
    }

    override fun getInputFilter(): FileBasedIndex.InputFilter {
        return DefaultFileTypeSpecificInputFilter(ValkyrieFileType)
    }

    override fun dependsOnFileContent(): Boolean {
        return true
    }
}