package valkyrie.language.file

import com.intellij.openapi.fileTypes.FileType
import com.intellij.openapi.fileTypes.FileTypeRegistry.FileTypeDetector
import com.intellij.openapi.util.io.ByteSequence
import com.intellij.openapi.vfs.VirtualFile

class ValkyrieFileTypeDetector : FileTypeDetector {
    override fun detect(file: VirtualFile, firstBytes: ByteSequence, firstCharsIfText: CharSequence?): FileType? {
        // useless, use with [LegionFileTypeDetector]
        return null
    }

    override fun getDesiredContentPrefixLength(): Int {
        return 0
    }
}

