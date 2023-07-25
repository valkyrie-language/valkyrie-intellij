package valkyrie.ide.project.crate

import com.intellij.openapi.vfs.AsyncFileListener
import com.intellij.openapi.vfs.AsyncFileListener.ChangeApplier
import com.intellij.openapi.vfs.newvfs.events.VFileEvent


class FileTypeRecast : AsyncFileListener {
    override fun prepareChange(events: MutableList<out VFileEvent>): ChangeApplier? {
        // Replaced by LegionFileTypeReinterpret
        return null
    }
}
