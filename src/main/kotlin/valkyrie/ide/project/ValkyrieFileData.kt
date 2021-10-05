package valkyrie.ide.project

import com.intellij.util.indexing.FileBasedIndex
import kotlinx.serialization.BinaryFormat
import kotlinx.serialization.Serializable
import valkyrie.language.file.ValkyrieFileNode
import valkyrie.language.psi_node.ValkyrieNamespaceStatementNode
import java.io.DataInput
import java.io.DataOutput


@Serializable
class ValkyrieFileData {
    var path = "";
    var namespace: Array<String> = arrayOf();
    var errors: List<String> = listOf();


    constructor(file: ValkyrieFileNode) {
        path = file.virtualFile.path;
        for (child in file.children) {
            if (child is ValkyrieNamespaceStatementNode) {
                if (namespace.isEmpty()) {
                    namespace = child.namespace;
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