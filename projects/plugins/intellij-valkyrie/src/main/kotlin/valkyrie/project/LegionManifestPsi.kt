package valkyrie.project

import von.surface.psi.VonPairNode
import von.surface.psi.VonTableNode
import von.surface.psi.VonValueNode
import von.surface.psi.rootTable
import von.surface.file.VonFile
import com.intellij.json.psi.JsonArray
import com.intellij.json.psi.JsonBooleanLiteral
import com.intellij.json.psi.JsonNullLiteral
import com.intellij.json.psi.JsonNumberLiteral
import com.intellij.json.psi.JsonObject
import com.intellij.json.psi.JsonStringLiteral
import com.intellij.json.psi.JsonValue
import com.intellij.openapi.vfs.VirtualFile

/**
 * Unified manifest object view over JSON PSI (`JsonObject`) and VON PSI (`VonTableNode`).
 */
class LegionManifestObject private constructor(
    private val json: JsonObject?,
    private val table: VonTableNode?,
) {
    val isObject: Boolean
        get() = json != null || (table?.braceL != null)

    fun textOrNull(field: String): String? =
        json?.let { jsonScalarText(it.findProperty(field)?.value) }
            ?: table?.findPair(field)?.value?.let { vonScalarText(it) }

    fun booleanOrNull(field: String): Boolean? {
        val text = textOrNull(field) ?: return null
        return when (text) {
            "true" -> true
            "false" -> false
            else -> null
        }
    }

    fun stringList(field: String): List<String> {
        val jsonArray = json?.findProperty(field)?.value as? JsonArray
        if (jsonArray != null) {
            return jsonArray.valueList.mapNotNull { jsonScalarText(it) }
        }
        val vonValue = table?.findPair(field)?.value ?: return emptyList()
        val arrayTable = vonValue.table?.takeIf { it.bracketL != null } ?: return emptyList()
        return arrayTable.valueList.mapNotNull { vonScalarText(it) }
    }

    fun stringMap(field: String): Map<String, String> {
        val child = childObject(field) ?: return emptyMap()
        return child.propertyEntries().mapValues { (_, value) -> value.textOrNull() ?: "" }
            .filterValues { it.isNotEmpty() }
    }

    fun childObject(field: String): LegionManifestObject? {
        val jsonChild = json?.findProperty(field)?.value as? JsonObject
        if (jsonChild != null) {
            return fromJson(jsonChild)
        }
        val vonChild = table?.findPair(field)?.value?.table?.takeIf { it.braceL != null }
        return vonChild?.let { fromVon(it) }
    }

    fun propertyEntries(): Map<String, LegionManifestValue> {
        if (json != null) {
            return json.propertyList.mapNotNull { property ->
                val name = property.name ?: return@mapNotNull null
                val value = property.value ?: return@mapNotNull null
                name to LegionManifestValue.fromJson(value)
            }.toMap()
        }
        if (table != null) {
            return table.pairList.mapNotNull { pair ->
                val name = pairKey(pair) ?: return@mapNotNull null
                val value = pair.value ?: return@mapNotNull null
                name to LegionManifestValue.fromVon(value)
            }.toMap()
        }
        return emptyMap()
    }

    fun memberPaths(field: String = "members"): List<String> {
        val members = stringList(field)
        if (members.isNotEmpty()) {
            return members
        }
        return stringList("packages")
    }

    companion object {
        fun fromJson(json: JsonObject): LegionManifestObject = LegionManifestObject(json, null)

        fun fromVon(table: VonTableNode): LegionManifestObject = LegionManifestObject(null, table)

        fun rootTable(file: VonFile): VonTableNode? = file.rootTable()
    }
}

class LegionManifestValue private constructor(
    private val json: JsonValue?,
    private val von: VonValueNode?,
) {
    fun textOrNull(): String? =
        json?.let { jsonScalarText(it) } ?: von?.let { vonScalarText(it) }

    fun asObject(): LegionManifestObject? {
        val jsonObject = json as? JsonObject
        if (jsonObject != null) {
            return LegionManifestObject.fromJson(jsonObject)
        }
        val vonTable = von?.table?.takeIf { it.braceL != null }
        return vonTable?.let { LegionManifestObject.fromVon(it) }
    }

    fun asStringList(): List<String> {
        val jsonArray = json as? JsonArray
        if (jsonArray != null) {
            return jsonArray.valueList.mapNotNull { jsonScalarText(it) }
        }
        val arrayTable = von?.table?.takeIf { it.bracketL != null }
        return arrayTable?.valueList?.mapNotNull { vonScalarText(it) } ?: emptyList()
    }

    companion object {
        fun fromJson(value: JsonValue): LegionManifestValue = LegionManifestValue(value, null)

        fun fromVon(value: VonValueNode): LegionManifestValue = LegionManifestValue(null, value)
    }
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

private fun VonTableNode.findPair(field: String): VonPairNode? =
    pairList.firstOrNull { pair -> pairKey(pair) == field }

private fun pairKey(pair: VonPairNode): String? {
    val path = pair.symbolPath
    if (path.keySymbolList.isNotEmpty()) {
        return path.keySymbolList.joinToString(".") { it.text }
    }
    val inline = path.stringInlineList.firstOrNull()?.text ?: return null
    return unquoteString(inline)
}

private fun jsonScalarText(value: JsonValue?): String? {
    return when (value) {
        is JsonStringLiteral -> value.value
        is JsonNumberLiteral -> value.value.toString()
        is JsonBooleanLiteral -> value.value.toString()
        is JsonNullLiteral -> null
        else -> null
    }
}

private fun vonScalarText(value: VonValueNode): String? {
    value.annotation?.valueList?.firstOrNull()?.let { return vonScalarText(it) }
    if (value.isNull()) {
        return null
    }
    value.boolean?.text?.let { return it }
    value.integer?.let { token ->
        return buildSignedNumber(value.sign?.text, token.text)
    }
    value.decimal?.let { token ->
        return buildSignedNumber(value.sign?.text, token.text)
    }
    value.byte?.text?.let { return it }
    value.stringInline?.text?.let { return unquoteString(it) }
    value.stringMulti?.text?.let { raw ->
        if (raw.length >= 2 && raw.first() == '"' && raw.last() == '"') {
            return raw.substring(1, raw.length - 1)
        }
        return raw
    }
    value.ref?.text?.let { return it }
    return null
}

private fun buildSignedNumber(sign: String?, raw: String): String {
    val normalized = raw.replace("_", "")
    return when (sign) {
        "-" -> "-$normalized"
        else -> normalized
    }
}

private fun unquoteString(raw: String): String {
    if (raw.length >= 2 && raw.first() == '"' && raw.last() == '"') {
        return raw.substring(1, raw.length - 1)
            .replace("\\\"", "\"")
            .replace("\\n", "\n")
            .replace("\\r", "\r")
            .replace("\\t", "\t")
            .replace("\\\\", "\\")
    }
    return raw
}
