package valkyrie.project.modules

import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.TestSourcesFilter
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiManager
import valkyrie.language.file.ValkyrieFileNode
import kotlin.io.path.exists


class testSourcesFilter : TestSourcesFilter() {
    override fun isTestSource(file: VirtualFile, project: Project): Boolean {
        val psi = PsiManager.getInstance(project).findFile(file) as? ValkyrieFileNode ?: return false
        return false
    }
}

private fun isTestRoot(file: VirtualFile, project: Project): Boolean {
    val path = file.toNioPath()
    val available = setOf("test", "tests", "bench", "benches", "benchmark", "benchmarks", "example")
    val config = path.resolveSibling("legion.json5")
    if (!config.exists()) {
        return false
    }
    return available.contains(file.presentableName)
}