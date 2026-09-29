package valkyrie.workspace.project.workspace

import com.intellij.openapi.application.ReadAction
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import valkyrie.workspace.project.DependencySource
import valkyrie.workspace.project.LegionManifestDocuments
import valkyrie.workspace.project.LegionManifestObject
import valkyrie.workspace.project.LegionManifestReader
import valkyrie.workspace.project.LegionManifestValue
import valkyrie.workspace.project.ValkyriePackageDependency
import valkyrie.workspace.project.ValkyrieProjectParser
import valkyrie.workspace.project.resolveMemberPath

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

    private fun findPackages(workspaceRoot: VirtualFile, rootObject: LegionManifestObject): List<VirtualFile> {
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
        rootObject: LegionManifestObject,
        workspaceRoot: VirtualFile,
    ): Map<String, ValkyriePackageDependency> {
        val dependencies = mutableMapOf<String, ValkyriePackageDependency>()
        dependencies.putAll(parseDependencySection(rootObject, "dependencies", workspaceRoot))
        dependencies.putAll(parseDependencySection(rootObject, "dev-dependencies", workspaceRoot))
        return dependencies
    }

    private fun parseDependencySection(
        rootObject: LegionManifestObject,
        sectionName: String,
        workspaceRoot: VirtualFile,
    ): Map<String, ValkyriePackageDependency> {
        val section = rootObject.childObject(sectionName) ?: return emptyMap()
        val dependencies = mutableMapOf<String, ValkyriePackageDependency>()
        section.propertyEntries().forEach { (name, value) ->
            dependencies[name] = parsePackageDependency(name, value, workspaceRoot)
        }
        return dependencies
    }

    private fun parsePackageDependency(
        name: String,
        value: LegionManifestValue,
        workspaceRoot: VirtualFile,
    ): ValkyriePackageDependency {
        val scalarVersion = value.textOrNull()
        if (scalarVersion != null) {
            return ValkyriePackageDependency(
                name = name,
                version = scalarVersion,
                source = DependencySource.External(),
            )
        }

        val objectValue = value.asObject()
        val path = objectValue?.textOrNull("path")
        val alias = objectValue?.textOrNull("alias")
        val version = objectValue?.textOrNull("version") ?: "latest"
        val gitUrl = objectValue?.textOrNull("git")
        val branch = objectValue?.textOrNull("branch")
        val tag = objectValue?.textOrNull("tag")

        val source = when {
            gitUrl != null -> DependencySource.Git(gitUrl, branch, tag)
            path != null -> {
                val absolutePath = resolveMemberPath(workspaceRoot, path)?.path ?: "${workspaceRoot.path}/$path"
                DependencySource.Local(absolutePath)
            }

            else -> DependencySource.External()
        }

        return ValkyriePackageDependency(
            name = name,
            version = version,
            source = source,
            alias = alias,
        )
    }

    private fun parsePackageAliases(rootObject: LegionManifestObject): Map<String, String> {
        val aliases = mutableMapOf<String, String>()
        rootObject.childObject("dependencies")?.propertyEntries()?.forEach { (name, value) ->
            val alias = value.asObject()?.textOrNull("alias")
            if (alias != null) {
                aliases[alias] = name
            }
        }
        return aliases
    }
}
