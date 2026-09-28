package valkyrie.project

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.github.voml.voml_intellij.manifest.VomlManifestJson
import com.intellij.openapi.application.ReadAction
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile

object LegionManifestDocuments {
    const val LEGION_JSON = "legion.json"
    const val LEGION_VON = "legion.von"
    const val LEGIONS_JSON = "legions.json"
    const val LEGIONS_VON = "legions.von"
}

object LegionManifestReader {
    private val mapper = ObjectMapper()

    fun findLegionManifest(directory: VirtualFile): VirtualFile? {
        if (!directory.isDirectory) return null
        return sequenceOf(LegionManifestDocuments.LEGION_VON, LegionManifestDocuments.LEGION_JSON)
            .mapNotNull { name -> directory.findChild(name)?.takeIf { it.exists() && !it.isDirectory } }
            .firstOrNull()
    }

    fun findLegionsManifest(directory: VirtualFile): VirtualFile? {
        if (!directory.isDirectory) return null
        return sequenceOf(LegionManifestDocuments.LEGIONS_VON, LegionManifestDocuments.LEGIONS_JSON)
            .mapNotNull { name -> directory.findChild(name)?.takeIf { it.exists() && !it.isDirectory } }
            .firstOrNull()
    }

    fun readRoot(project: Project, manifestFile: VirtualFile): JsonNode? {
        return ReadAction.compute<JsonNode?, RuntimeException> {
            readRootUnsafe(project, manifestFile)
        }
    }

    private fun readRootUnsafe(project: Project, manifestFile: VirtualFile): JsonNode? {
        return try {
            val text = String(manifestFile.contentsToByteArray(), manifestFile.charset)
            when (manifestFile.extension) {
                "json" -> mapper.readTree(text)
                "von" -> VomlManifestJson.readRootUnsafe(project, text, manifestFile.name)
                else -> null
            }
        } catch (_: Exception) {
            null
        }
    }
}

internal fun JsonNode.textOrNull(field: String): String? {
    val node = get(field) ?: return null
    return when {
        node.isNull -> null
        node.isTextual -> node.asText()
        node.isNumber || node.isBoolean -> node.asText()
        else -> null
    }
}

internal fun JsonNode.booleanOrNull(field: String): Boolean? {
    val node = get(field) ?: return null
    return when {
        node.isBoolean -> node.asBoolean()
        node.isTextual -> when (node.asText()) {
            "true" -> true
            "false" -> false
            else -> null
        }
        else -> null
    }
}

internal fun JsonNode.stringList(field: String): List<String> {
    val node = get(field) ?: return emptyList()
    if (!node.isArray) return emptyList()
    return node.mapNotNull { element ->
        when {
            element.isTextual -> element.asText()
            element.isNumber -> element.asText()
            else -> null
        }
    }
}

internal fun JsonNode.stringMap(field: String): Map<String, String> {
    val node = get(field) ?: return emptyMap()
    if (!node.isObject) return emptyMap()
    val values = mutableMapOf<String, String>()
    node.fields().forEachRemaining { entry ->
        val valueNode = entry.value
        val value = when {
            valueNode.isTextual -> valueNode.asText()
            valueNode.isNumber -> valueNode.asText()
            else -> null
        }
        if (value != null) {
            values[entry.key] = value
        }
    }
    return values
}

internal fun JsonNode.objectFields(field: String): Map<String, JsonNode> {
    val node = get(field) ?: return emptyMap()
    if (!node.isObject) return emptyMap()
    val values = linkedMapOf<String, JsonNode>()
    node.fields().forEachRemaining { entry ->
        values[entry.key] = entry.value
    }
    return values
}

internal fun JsonNode.memberPaths(field: String = "members"): List<String> {
    val members = get(field)
    if (members != null && members.isArray) {
        return members.mapNotNull { element -> if (element.isTextual) element.asText() else null }
    }
    return stringList("packages")
}

internal fun resolveMemberPath(workspaceRoot: VirtualFile, member: String): VirtualFile? {
    val trimmed = member.trim().removePrefix("./")
    if (trimmed.isEmpty()) return null

    var current: VirtualFile = workspaceRoot
    for (part in trimmed.split('/')) {
        current = when (part) {
            "." -> current
            ".." -> current.parent ?: return null
            else -> current.findChild(part) ?: return null
        }
    }
    return current
}
