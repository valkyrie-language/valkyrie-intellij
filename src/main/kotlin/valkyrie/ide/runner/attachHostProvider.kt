package valkyrie.ide.runner

import com.intellij.openapi.project.Project
import com.intellij.xdebugger.attach.XAttachHost
import com.intellij.xdebugger.attach.XAttachHostProvider
import com.intellij.xdebugger.attach.XAttachPresentationGroup

class attachHostProvider : XAttachHostProvider<Any?> {
    override fun getPresentationGroup(): XAttachPresentationGroup<out XAttachHost> {
        TODO("Not yet implemented")
    }

    override fun getAvailableHosts(project: Project?): MutableList<Any?> {
        TODO("Not yet implemented")
    }
}