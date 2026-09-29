package valkyrie.workspace.project

import com.intellij.openapi.application.ReadAction
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile

/**
 * Parses `legion.von` / `legion.json` project manifests.
 */
class ValkyrieProjectParser {

    companion object {
        const val LEGION_JSON = LegionManifestDocuments.LEGION_JSON
        const val LEGION_VON = LegionManifestDocuments.LEGION_VON
        const val LIBRARY_DIR = "library"
        const val BINARY_DIR = "binary"
        const val TESTS_DIR = "test"
        const val SOURCE_DIR = "source"
        const val ENTRY_FILE = "_.valkyrie"
        const val ENTRY_FILE_ALT = "_.v"
    }

    fun isValkyrieProject(directory: VirtualFile): Boolean {
        return LegionManifestReader.findLegionManifest(directory) != null
    }

    fun parseProject(project: Project, projectRoot: VirtualFile): ValkyrieProject? {
        val manifestFile = LegionManifestReader.findLegionManifest(projectRoot) ?: return null

        return ReadAction.compute<ValkyrieProject?, RuntimeException> {
            val rootObject = LegionManifestReader.readRoot(project, manifestFile) ?: return@compute null
            if (!rootObject.isObject) return@compute null

            ValkyrieProject(
                root = projectRoot,
                packageInfo = parsePackageInfo(rootObject, projectRoot),
                projectType = rootObject.textOrNull("type") ?: "library",
                features = parseFeatures(rootObject),
                dependencies = parseDependencySection(rootObject, "dependencies"),
                buildDependencies = parseDependencySection(rootObject, "build-dependencies"),
                devDependencies = parseDependencySection(rootObject, "dev-dependencies"),
                entryPoints = findEntryPoints(projectRoot, rootObject),
            )
        }
    }

    private fun parsePackageInfo(rootObject: LegionManifestObject, projectRoot: VirtualFile): ValkyriePackageInfo {
        val packageObject = rootObject.childObject("package") ?: rootObject

        return ValkyriePackageInfo(
            name = packageObject.textOrNull("name")
                ?: rootObject.textOrNull("name")
                ?: projectRoot.name,
            version = packageObject.textOrNull("version") ?: "0.0.0",
            description = packageObject.textOrNull("description"),
            authors = packageObject.stringList("authors"),
            repository = packageObject.textOrNull("repository"),
            documentation = packageObject.textOrNull("documentation"),
            edition = packageObject.textOrNull("edition"),
            license = packageObject.textOrNull("license"),
            readme = packageObject.textOrNull("readme"),
            publish = packageObject.booleanOrNull("publish") ?: true,
            namespace = packageObject.textOrNull("namespace"),
            exports = packageObject.stringList("exports"),
            alias = null,
        )
    }

    private fun parseFeatures(rootObject: LegionManifestObject): Map<String, List<String>> {
        val featuresObject = rootObject.childObject("features") ?: return emptyMap()
        return featuresObject.propertyEntries().mapValues { (_, value) -> value.asStringList() }
    }

    private fun parseDependencySection(rootObject: LegionManifestObject, sectionName: String): Map<String, String> {
        val section = rootObject.childObject(sectionName) ?: return emptyMap()
        val dependencies = mutableMapOf<String, String>()
        section.propertyEntries().forEach { (name, value) ->
            val version = value.textOrNull() ?: value.asObject()?.textOrNull("version")
            if (version != null) {
                dependencies[name] = version
            }
        }
        return dependencies
    }

    private fun findEntryPoints(projectRoot: VirtualFile, rootObject: LegionManifestObject): ValkyrieEntryPoints {
        val libraryDir = projectRoot.findChild(LIBRARY_DIR) ?: projectRoot.findChild(SOURCE_DIR)
        val binaryDir = projectRoot.findChild(BINARY_DIR)

        val mainPath = rootObject.textOrNull("main")
        val libraryEntry = when {
            mainPath != null -> resolveMemberPath(projectRoot, mainPath)
            else -> libraryDir?.let { dir ->
                dir.findChild(ENTRY_FILE) ?: dir.findChild(ENTRY_FILE_ALT)
            }
        }

        val binaryEntries = mutableListOf<VirtualFile>()
        binaryDir?.children?.forEach { child ->
            when {
                child.name.endsWith(".valkyrie") || child.name.endsWith(".v") -> binaryEntries.add(child)
                child.isDirectory -> {
                    val entryFile = child.findChild(ENTRY_FILE) ?: child.findChild(ENTRY_FILE_ALT)
                    if (entryFile != null) {
                        binaryEntries.add(entryFile)
                    }
                }
            }
        }

        return ValkyrieEntryPoints(
            library = libraryEntry,
            binaries = binaryEntries,
        )
    }
}
