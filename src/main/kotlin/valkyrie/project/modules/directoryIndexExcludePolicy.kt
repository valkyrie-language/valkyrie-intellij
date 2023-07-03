package valkyrie.project.modules

import com.intellij.openapi.projectRoots.Sdk
import com.intellij.openapi.roots.ModuleRootModel
import com.intellij.openapi.roots.impl.DirectoryIndexExcludePolicy
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.pointers.VirtualFilePointer
import com.intellij.util.Function

class directoryIndexExcludePolicy : DirectoryIndexExcludePolicy {
    override fun getExcludeSdkRootsStrategy(): Function<Sdk, MutableList<VirtualFile>>? {
        return super.getExcludeSdkRootsStrategy()
    }

    override fun getExcludeUrlsForProject(): Array<String> {
        return super.getExcludeUrlsForProject()
    }

    override fun getExcludeRootsForModule(rootModel: ModuleRootModel): Array<VirtualFilePointer> {
        return super.getExcludeRootsForModule(rootModel)
    }
}
