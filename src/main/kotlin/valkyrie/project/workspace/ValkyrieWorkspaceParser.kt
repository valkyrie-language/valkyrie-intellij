package valkyrie.project.workspace

import com.fasterxml.jackson.databind.JsonNode
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.application.ReadAction
import valkyrie.project.DependencySource
import valkyrie.project.LegionManifestDocuments
import valkyrie.project.LegionManifestReader
import valkyrie.project.ValkyriePackageDependency
import valkyrie.project.ValkyrieProjectParser
import valkyrie.project.booleanOrNull
import valkyrie.project.memberPaths
import valkyrie.project.objectFields
import valkyrie.project.resolveMemberPath
import valkyrie.project.stringMap
import valkyrie.project.textOrNull

/**
 * Parses `legions.von` / `legions.json` workspace manifests.
 */
class ValkyrieWorkspaceParser {

    companion object {
        const val LEGIONS_JSON = LegionManifestDocuments.LEGIONS_JSON
        const val LEGIONS_VON = LegionManifestDocuments.LEGIONS_VON
        const val PACKAGES_DIR = "packages"
    }

    private val projectParser = ValkyrieProjectParser()

    fun isValkyrieWorkspace(directory: VirtualFile): Boolean {
        return LegionManifestReader.findLegionsManifest(directory) != null
    }

    fun parseWorkspace(project: Project, workspaceRoot: VirtualFile): ValkyrieWorkspace? {
        val manifestFile = LegionManifestReader.findLegionsManifest(workspaceRoot) ?: return null

        return ReadAction.compute<ValkyrieWorkspace?, RuntimeException> {
            val rootObject = LegionManifestReader.readRoot(project, manifestFile) ?: return@compute null
            if (!rootObject.isObject) return@compute null

            val packageDependencies = parsePackageDependencies(rootObject, workspaceRoot)
            val packageAliases = parsePackageAliases(rootObject)

            ValkyrieWorkspace(
                root = workspaceRoot,
                name = rootObject.textOrNull("name") ?: workspaceRoot.name,
                isPrivate = rootObject.booleanOrNull("private") ?: false,
                scripts = rootObject.stringMap("scripts"),
                packages = findPackages(workspaceRoot, rootObject),
                packageDependencies = packageDependencies,
                packageAliases = packageAliases,
            )
        }
    }

    private fun findPackages(workspaceRoot: VirtualFile, rootObject: JsonNode): List<VirtualFile> {
        val memberPackages = rootObject.memberPaths()
            .mapNotNull { member -> resolveMemberPath(workspaceRoot, member) }
            .filter { projectParser.isValkyrieProject(it) }

        if (memberPackages.isNotEmpty()) {
            return memberPackages
        }

        val packagesDir = workspaceRoot.findChild(PACKAGES_DIR) ?: return emptyList()
        return packagesDir.children.filter { child ->
            child.isDirectory && projectParser.isValkyrieProject(child)
        }
    }

    private fun parsePackageDependencies(
        rootObject: JsonNode,
        workspaceRoot: VirtualFile,
    ): Map<String, ValkyriePackageDependency> {
        val dependencies = mutableMapOf<String, ValkyriePackageDependency>()
        dependencies.putAll(parseDependencySection(rootObject, "dependencies", workspaceRoot))
        dependencies.putAll(parseDependencySection(rootObject, "dev-dependencies", workspaceRoot))
        return dependencies
    }

    private fun parseDependencySection(
        rootObject: JsonNode,
        sectionName: String,
        workspaceRoot: VirtualFile,
    ): Map<String, ValkyriePackageDependency> {
        val section = rootObject.get(sectionName) ?: return emptyMap()
        if (!section.isObject) return emptyMap()

        val dependencies = mutableMapOf<String, ValkyriePackageDependency>()
        section.fields().forEachRemaining { entry ->
            val name = entry.key
            val value = entry.value
            when {
                value.isTextual || value.isNumber -> {
                    dependencies[name] = ValkyriePackageDependency(
                        name = name,
                        version = value.asText(),
                        source = DependencySource.External(),
                    )
                }

                value.isObject -> {
                    val path = value.textOrNull("path")
                    val alias = value.textOrNull("alias")
                    val version = value.textOrNull("version") ?: "latest"
                    val gitUrl = value.textOrNull("git")
                    val branch = value.textOrNull("branch")
                    val tag = value.textOrNull("tag")

                    val source = when {
                        gitUrl != null -> DependencySource.Git(gitUrl, branch, tag)
                        path != null -> {
                            val absolutePath = resolveMemberPath(workspaceRoot, path)?.path ?: "${workspaceRoot.path}/$path"
                            DependencySource.Local(absolutePath)
                        }

                        else -> DependencySource.External()
                    }

                    dependencies[name] = ValkyriePackageDependency(
                        name = name,
                        version = version,
                        source = source,
                        alias = alias,
                    )
                }
            }
        }
        return dependencies
    }

    private fun parsePackageAliases(rootObject: JsonNode): Map<String, String> {
        val aliases = mutableMapOf<String, String>()
        rootObject.objectFields("dependencies").forEach { (name, value) ->
            val alias = value.textOrNull("alias")
            if (alias != null) {
                aliases[alias] = name
            }
        }
        return aliases
    }
}
