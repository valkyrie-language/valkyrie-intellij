package valkyrie.editing.completion.legion

/**
 * JSON-Schema-like manifest contract for Legion `legion.von` / `legions.von`.
 * Aligned with `valkyrie.rs` `ProjectManifest` / `WorkspaceManifest` and IDE parsers.
 */
enum class LegionManifestKind {
    PROJECT,
    WORKSPACE,
}

enum class VonSchemaValueKind {
    STRING,
    BOOLEAN,
    NUMBER,
    ENUM,
    OBJECT,
    ARRAY,
    /** Map with arbitrary keys; [valueSchema] describes each entry value. */
    MAP,
    /** Scalar or nested object (e.g. dependency version string vs `{ path: ... }`). */
    UNION,
}

data class VonSchemaProperty(
    val name: String,
    val kind: VonSchemaValueKind,
    val description: String? = null,
    val enumValues: List<String> = emptyList(),
    val objectSchema: VonSchemaObject? = null,
    val arrayItemSchema: VonSchemaProperty? = null,
    val mapValueSchema: VonSchemaProperty? = null,
    val unionSchemas: List<VonSchemaProperty> = emptyList(),
    val required: Boolean = false,
)

data class VonSchemaObject(
    val properties: Map<String, VonSchemaProperty>,
)

object LegionManifestSchema {
    private val BOOL = VonSchemaProperty("bool", VonSchemaValueKind.BOOLEAN)
    private val STRING = VonSchemaProperty("string", VonSchemaValueKind.STRING)

    private val AUTO_LINK = VonSchemaObject(
        mapOf(
            "core" to VonSchemaProperty("core", VonSchemaValueKind.BOOLEAN, "Link workspace `core` package"),
            "std" to VonSchemaProperty("std", VonSchemaValueKind.BOOLEAN, "Link workspace `std` package"),
        ),
    )

    private val DEPENDENCY_OBJECT = VonSchemaObject(
        mapOf(
            "version" to VonSchemaProperty("version", VonSchemaValueKind.STRING, "Semver, `workspace`, or `latest`"),
            "path" to VonSchemaProperty("path", VonSchemaValueKind.STRING, "Relative path to local package"),
            "git" to VonSchemaProperty("git", VonSchemaValueKind.STRING, "Git repository URL"),
            "branch" to VonSchemaProperty("branch", VonSchemaValueKind.STRING, "Git branch"),
            "tag" to VonSchemaProperty("tag", VonSchemaValueKind.STRING, "Git tag"),
            "abi" to VonSchemaProperty("abi", VonSchemaValueKind.STRING, "ABI constraint"),
            "source" to VonSchemaProperty(
                "source",
                VonSchemaValueKind.ENUM,
                "Dependency resolution source",
                enumValues = listOf("workspace", "registry", "path", "git", "auto"),
            ),
            "registry" to VonSchemaProperty("registry", VonSchemaValueKind.STRING, "Registry name"),
            "alias" to VonSchemaProperty("alias", VonSchemaValueKind.STRING, "Import alias in workspace"),
        ),
    )

    private val DEPENDENCY = VonSchemaProperty(
        name = "dependency",
        kind = VonSchemaValueKind.UNION,
        description = "Version string or dependency table",
        unionSchemas = listOf(
            STRING,
            VonSchemaProperty("dependency", VonSchemaValueKind.OBJECT, objectSchema = DEPENDENCY_OBJECT),
        ),
    )

    private val BUILD_TARGET = VonSchemaObject(
        mapOf(
            "target" to VonSchemaProperty("target", VonSchemaValueKind.STRING, "Canonical build target id", required = true),
            "msil" to VonSchemaProperty("msil", VonSchemaValueKind.BOOLEAN, "Emit managed MSIL"),
            "source_map" to VonSchemaProperty("source_map", VonSchemaValueKind.BOOLEAN),
            "typescript" to VonSchemaProperty("typescript", VonSchemaValueKind.BOOLEAN),
            "wat" to VonSchemaProperty("wat", VonSchemaValueKind.BOOLEAN),
            "runtime_async" to VonSchemaProperty("runtime_async", VonSchemaValueKind.BOOLEAN, "CLR async state machine"),
            "exclude_directories" to VonSchemaProperty(
                "exclude_directories",
                VonSchemaValueKind.ARRAY,
                arrayItemSchema = STRING,
            ),
            "exclude_files" to VonSchemaProperty(
                "exclude_files",
                VonSchemaValueKind.ARRAY,
                arrayItemSchema = STRING,
            ),
            "publish" to VonSchemaProperty(
                "publish",
                VonSchemaValueKind.ARRAY,
                arrayItemSchema = STRING,
            ),
        ),
    )

    private val PACKAGE_INFO = VonSchemaObject(
        mapOf(
            "name" to VonSchemaProperty("name", VonSchemaValueKind.STRING, required = true),
            "version" to VonSchemaProperty("version", VonSchemaValueKind.STRING),
            "description" to VonSchemaProperty("description", VonSchemaValueKind.STRING),
            "namespace" to VonSchemaProperty("namespace", VonSchemaValueKind.STRING, "Package namespace root"),
            "edition" to VonSchemaProperty("edition", VonSchemaValueKind.STRING),
            "license" to VonSchemaProperty("license", VonSchemaValueKind.STRING),
            "readme" to VonSchemaProperty("readme", VonSchemaValueKind.STRING),
            "repository" to VonSchemaProperty("repository", VonSchemaValueKind.STRING),
            "documentation" to VonSchemaProperty("documentation", VonSchemaValueKind.STRING),
            "publish" to VonSchemaProperty("publish", VonSchemaValueKind.BOOLEAN),
            "authors" to VonSchemaProperty("authors", VonSchemaValueKind.ARRAY, arrayItemSchema = STRING),
            "exports" to VonSchemaProperty("exports", VonSchemaValueKind.ARRAY, arrayItemSchema = STRING),
        ),
    )

    private val PROJECT_ROOT = VonSchemaObject(
        mapOf(
            "name" to VonSchemaProperty("name", VonSchemaValueKind.STRING, "Package name", required = true),
            "version" to VonSchemaProperty("version", VonSchemaValueKind.STRING),
            "description" to VonSchemaProperty("description", VonSchemaValueKind.STRING),
            "type" to VonSchemaProperty(
                "type",
                VonSchemaValueKind.ENUM,
                "Project kind (IDE)",
                enumValues = listOf("application", "library", "binary"),
            ),
            "entry" to VonSchemaProperty("entry", VonSchemaValueKind.STRING, "Library entry `.v` path"),
            "main" to VonSchemaProperty("main", VonSchemaValueKind.STRING, "Binary entry `.v` path"),
            "artifact" to VonSchemaProperty(
                "artifact",
                VonSchemaValueKind.ENUM,
                "Wasm artifact mode",
                enumValues = listOf("binary", "library"),
            ),
            "package" to VonSchemaProperty("package", VonSchemaValueKind.OBJECT, objectSchema = PACKAGE_INFO),
            "auto_link" to VonSchemaProperty("auto_link", VonSchemaValueKind.OBJECT, objectSchema = AUTO_LINK),
            "dependencies" to VonSchemaProperty(
                "dependencies",
                VonSchemaValueKind.MAP,
                mapValueSchema = DEPENDENCY,
            ),
            "build-dependencies" to VonSchemaProperty(
                "build-dependencies",
                VonSchemaValueKind.MAP,
                mapValueSchema = DEPENDENCY,
            ),
            "dev-dependencies" to VonSchemaProperty(
                "dev-dependencies",
                VonSchemaValueKind.MAP,
                mapValueSchema = DEPENDENCY,
            ),
            "features" to VonSchemaProperty(
                "features",
                VonSchemaValueKind.MAP,
                mapValueSchema = VonSchemaProperty("feature", VonSchemaValueKind.ARRAY, arrayItemSchema = STRING),
            ),
            "build" to VonSchemaProperty(
                "build",
                VonSchemaValueKind.ARRAY,
                arrayItemSchema = VonSchemaProperty("build", VonSchemaValueKind.OBJECT, objectSchema = BUILD_TARGET),
            ),
            "publish" to VonSchemaProperty(
                "publish",
                VonSchemaValueKind.ARRAY,
                arrayItemSchema = VonSchemaProperty(
                    "publish",
                    VonSchemaValueKind.OBJECT,
                    objectSchema = VonSchemaObject(
                        mapOf(
                            "target" to VonSchemaProperty("target", VonSchemaValueKind.STRING, required = true),
                            "type" to VonSchemaProperty("type", VonSchemaValueKind.STRING, "npm / jsr / web-app …"),
                            "package_id" to VonSchemaProperty("package_id", VonSchemaValueKind.STRING),
                            "version" to VonSchemaProperty("version", VonSchemaValueKind.STRING),
                        ),
                    ),
                ),
            ),
            "sdk-vendor" to VonSchemaProperty(
                "sdk-vendor",
                VonSchemaValueKind.OBJECT,
                objectSchema = VonSchemaObject(
                    mapOf(
                        "organization" to VonSchemaProperty("organization", VonSchemaValueKind.STRING),
                        "host" to VonSchemaProperty("host", VonSchemaValueKind.STRING),
                        "kind" to VonSchemaProperty("kind", VonSchemaValueKind.STRING),
                        "targets" to VonSchemaProperty("targets", VonSchemaValueKind.ARRAY, arrayItemSchema = STRING),
                        "publish" to VonSchemaProperty("publish", VonSchemaValueKind.ARRAY, arrayItemSchema = STRING),
                    ),
                ),
            ),
            "build_plugin" to VonSchemaProperty(
                "build_plugin",
                VonSchemaValueKind.OBJECT,
                objectSchema = VonSchemaObject(
                    mapOf(
                        "kind" to VonSchemaProperty("kind", VonSchemaValueKind.STRING, required = true),
                        "sdk" to VonSchemaProperty("sdk", VonSchemaValueKind.STRING),
                        "mode" to VonSchemaProperty("mode", VonSchemaValueKind.STRING),
                        "input_directory" to VonSchemaProperty("input_directory", VonSchemaValueKind.STRING),
                        "output_directory" to VonSchemaProperty("output_directory", VonSchemaValueKind.STRING),
                        "next_step" to VonSchemaProperty("next_step", VonSchemaValueKind.STRING),
                    ),
                ),
            ),
        ),
    )

    private val WORKSPACE_ROOT = VonSchemaObject(
        mapOf(
            "name" to VonSchemaProperty("name", VonSchemaValueKind.STRING, "Workspace display name"),
            "version" to VonSchemaProperty("version", VonSchemaValueKind.STRING),
            "private" to VonSchemaProperty("private", VonSchemaValueKind.BOOLEAN),
            "packages" to VonSchemaProperty(
                "packages",
                VonSchemaValueKind.ARRAY,
                description = "Member package paths",
                arrayItemSchema = STRING,
            ),
            "members" to VonSchemaProperty(
                "members",
                VonSchemaValueKind.ARRAY,
                description = "Member package paths (alias of packages)",
                arrayItemSchema = STRING,
            ),
            "dependencies" to VonSchemaProperty(
                "dependencies",
                VonSchemaValueKind.MAP,
                mapValueSchema = DEPENDENCY,
            ),
            "dev-dependencies" to VonSchemaProperty(
                "dev-dependencies",
                VonSchemaValueKind.MAP,
                mapValueSchema = DEPENDENCY,
            ),
            "scripts" to VonSchemaProperty(
                "scripts",
                VonSchemaValueKind.MAP,
                mapValueSchema = STRING,
            ),
            "workspace" to VonSchemaProperty(
                "workspace",
                VonSchemaValueKind.OBJECT,
                objectSchema = VonSchemaObject(
                    mapOf(
                        "version" to VonSchemaProperty("version", VonSchemaValueKind.STRING),
                        "author" to VonSchemaProperty("author", VonSchemaValueKind.STRING),
                        "license" to VonSchemaProperty("license", VonSchemaValueKind.STRING),
                        "auto_link" to VonSchemaProperty("auto_link", VonSchemaValueKind.OBJECT, objectSchema = AUTO_LINK),
                    ),
                ),
            ),
        ),
    )

    fun rootSchema(kind: LegionManifestKind): VonSchemaObject =
        when (kind) {
            LegionManifestKind.PROJECT -> PROJECT_ROOT
            LegionManifestKind.WORKSPACE -> WORKSPACE_ROOT
        }

    fun resolveObjectSchema(
        kind: LegionManifestKind,
        keyPath: List<String>,
    ): VonSchemaObject? {
        if (keyPath.isEmpty()) {
            return rootSchema(kind)
        }
        var currentObject: VonSchemaObject? = rootSchema(kind)
        var currentProperty: VonSchemaProperty? = null
        for (key in keyPath) {
            val property = currentObject?.properties?.get(key)
                ?: currentProperty?.mapValueSchema?.let { mapValueSchemaAt(key, it) }
            if (property == null) {
                return currentObject
            }
            currentProperty = property
            currentObject = property.objectSchema
                ?: property.mapValueSchema?.objectSchema
                ?: property.arrayItemSchema?.objectSchema
                ?: property.unionSchemas.firstOrNull { it.objectSchema != null }?.objectSchema
        }
        return currentObject
    }

    fun resolveValueProperty(
        kind: LegionManifestKind,
        keyPath: List<String>,
    ): VonSchemaProperty? {
        if (keyPath.isEmpty()) {
            return null
        }
        val parentPath = keyPath.dropLast(1)
        val key = keyPath.last()
        val parentObject = resolveObjectSchema(kind, parentPath)
        return parentObject?.properties?.get(key)
            ?: parentPath.lastOrNull()?.let { parentKey ->
                val grandParent = resolveObjectSchema(kind, parentPath.dropLast(1))
                val mapProperty = grandParent?.properties?.get(parentKey)
                mapProperty?.mapValueSchema?.let { mapValueSchemaAt(key, it) }
            }
    }

    private fun mapValueSchemaAt(
        @Suppress("UNUSED_PARAMETER") mapKey: String,
        valueSchema: VonSchemaProperty,
    ): VonSchemaProperty? =
        when (valueSchema.kind) {
            VonSchemaValueKind.UNION -> valueSchema.unionSchemas.firstOrNull { it.objectSchema != null }
            VonSchemaValueKind.OBJECT -> valueSchema
            else -> valueSchema
        }
}
