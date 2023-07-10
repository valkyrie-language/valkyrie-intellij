package valkyrie.ide.project.crate

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.vfs.AsyncFileListener
import com.intellij.openapi.vfs.AsyncFileListener.ChangeApplier
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.newvfs.events.VFileCreateEvent
import com.intellij.openapi.vfs.newvfs.events.VFileEvent


class FileTypeRecast : AsyncFileListener {
    override fun prepareChange(events: MutableList<out VFileEvent>): ChangeApplier {
        return FileTypeRecastApplier(events)
    }
}

private class FileTypeRecastApplier : ChangeApplier {
    private val events: MutableList<out VFileEvent>

    constructor(events: MutableList<out VFileEvent>) {
        this.events = events
    }

    override fun beforeVfsChange() {
        for (event in events) {
            if (event is VFileCreateEvent) {
                if (event.file?.name == "legion.json") {

                }
            }
        }

    }

    override fun afterVfsChange() {
        // 在文件变更完成后,可以执行其他操作
    }

    private fun recastJson5(file: VirtualFile?, target: String) {
        if (file?.name == target) {
            ApplicationManager.getApplication().runWriteAction {
//                FileContentUtil.reparseFiles(file)
//                file.putUserData(FILE_TYPE_ATTRIBUTE, "JSON5")
            }
        }
    }
}