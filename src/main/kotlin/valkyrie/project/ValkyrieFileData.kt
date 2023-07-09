package valkyrie.project

import valkyrie.language.file.ValkyrieFileNode
import valkyrie.psi.node.ValkyrieDeclareNamespace
import java.io.DataInput
import java.io.DataOutput

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