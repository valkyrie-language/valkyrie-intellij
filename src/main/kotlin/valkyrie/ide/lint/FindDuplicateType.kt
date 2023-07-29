package valkyrie.ide.lint

import com.intellij.codeHighlighting.HighlightDisplayLevel
import com.intellij.codeInspection.InspectionManager
import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemDescriptor
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.PsiFile
import valkyrie.language.ValkyrieBundle
import valkyrie.language.ValkyrieLanguage
import valkyrie.psi.node.ValkyrieDeclareSingleton

class FindDuplicateType : LocalInspectionTool() {
    override fun getID(): String {
        return "inspection.duplicate.type"
    }

    override fun getGroupPath(): Array<String> {
        return arrayOf("Valkyrie")
    }

    override fun getGroupDisplayName(): String {
        return ValkyrieBundle.message("inspection.duplicate.group")
    }

    override fun getDisplayName(): String {
        return ValkyrieBundle.message(id)
    }

    override fun getStaticDescription(): String? {
        return javaClass.getResource("/inspectionDescriptions/FindDuplicateType.html")?.readText()
    }

    override fun getLanguage(): String {
        return ValkyrieLanguage.id
    }

    override fun isEnabledByDefault(): Boolean {
        return true
    }

    override fun getDefaultLevel(): HighlightDisplayLevel {
        return HighlightDisplayLevel.ERROR
    }

    override fun checkFile(file: PsiFile, manager: InspectionManager, isOnTheFly: Boolean): Array<ProblemDescriptor> {
        return arrayOf()
    }

    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return FindDuplicateTypeVisitor(this, holder)
    }
}

private class FindDuplicateTypeVisitor(tool: LocalInspectionTool, holder: ProblemsHolder) : ValkyrieLocalInspectionVisitor(tool, holder) {
    override fun visitDeclareSingleton(o: ValkyrieDeclareSingleton) {
//        o.registerProblem(
//            ValkyrieBundle.message("${tool.id}.detail", o.identifier?.text ?: ""),
//            FindDuplicateTypeFixer(tool, AllIcons.Actions.DependencyAnalyzer, o, mutableListOf()),
//        )
    }
}
