package valkyrie.lsp

import com.intellij.openapi.roots.SyntheticLibrary
import com.intellij.util.containers.toMutableSmartList
import kotlinx.serialization.Serializable
import valkyrie.ide.project.library.DependenceLibrary

@Serializable
data class RequestDependencies(val workspace: String) {
    @Serializable
    data class DependenciesInfo(
        val name: String,
        val version: String,
        val path: String,
        val kind: Int,
    )

    companion object {
        fun request(workspace: String?): MutableList<SyntheticLibrary> {
            val out = LanguageClient.send<RequestDependencies, List<DependenciesInfo>>("workspace/dependencies", RequestDependencies(workspace ?: ""))
            return out.map { DependenceLibrary(it) }.toMutableSmartList()
        }
    }
}

