package valkyrie.ide.lint

import com.intellij.analysis.AnalysisScope
import com.intellij.codeHighlighting.HighlightDisplayLevel
import com.intellij.codeInspection.GlobalInspectionContext
import com.intellij.codeInspection.GlobalInspectionTool
import com.intellij.codeInspection.InspectionManager
import com.intellij.codeInspection.ProblemDescriptionsProcessor
import com.intellij.codeInspection.reference.*
import com.intellij.openapi.module.ModuleType
import com.intellij.openapi.roots.ModuleRootManager
import valkyrie.project.modules.ValkyrieModuleType


class FindDuplicateMethod : GlobalInspectionTool() {
    override fun getDefaultLevel(): HighlightDisplayLevel {
        return super.getDefaultLevel()
    }

    override fun runInspection(
        scope: AnalysisScope,
        manager: InspectionManager,
        globalContext: GlobalInspectionContext,
        problemDescriptionsProcessor: ProblemDescriptionsProcessor,
    ) {
        globalContext.refManager.iterate(ValkyrieInspectionVisitor(globalContext, this, scope, manager, problemDescriptionsProcessor))
    }
}

open class ValkyrieInspectionVisitor : RefVisitor {
    private val global: GlobalInspectionContext
    private val context: FindDuplicateMethod
    private val scope: AnalysisScope
    protected val manager: InspectionManager
    protected val sink: ProblemDescriptionsProcessor

    constructor(
        global: GlobalInspectionContext,
        context: FindDuplicateMethod,
        scope: AnalysisScope,
        manager: InspectionManager,
        sink: ProblemDescriptionsProcessor,
    ) : super() {
        this.global = global
        this.context = context
        this.scope = scope
        this.manager = manager
        this.sink = sink
    }

    override fun visitElement(refEntity: RefEntity) {
        if (stopProgress(refEntity)) return
    }

    override fun visitModule(module: RefModule) {
        if (!global.shouldCheck(module, context)) return
        if (!scope.containsModule(module.module)) return
        if (ModuleType.get(module.module) !is ValkyrieModuleType) return
        val rootManager = ModuleRootManager.getInstance(module.module)
        val sources = rootManager.sourceRoots


    }

    override fun visitDirectory(directory: RefDirectory) {
        if (stopProgress(directory)) return

    }

    override fun visitFile(file: RefFile) {
        if (stopProgress(file)) return

    }

    private fun stopProgress(refEntity: RefEntity): Boolean {
        if (refEntity is RefElement) {
            val pointer = refEntity.pointer
            if (pointer != null) {
                val virtualFile = pointer.virtualFile
                if (virtualFile != null && !scope.contains(virtualFile)) return true
            } else {
                val owner = refEntity.getOwner()
                return owner != null && !stopProgress(owner)
            }
        }
        return false
    }
}

