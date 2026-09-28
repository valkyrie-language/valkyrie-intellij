package valkyrie.project

import com.github.voml.voml_intellij.language.VomlFile
import com.github.voml.voml_intellij.language.psi.VomlPsi
import com.intellij.json.psi.JsonArray
import com.intellij.json.psi.JsonBooleanLiteral
import com.intellij.json.psi.JsonNullLiteral
import com.intellij.json.psi.JsonNumberLiteral
import com.intellij.json.psi.JsonObject
import com.intellij.json.psi.JsonStringLiteral
import com.intellij.json.psi.JsonValue
import com.intellij.openapi.vfs.VirtualFile

/**
 * Unified manifest object view over JSON PSI (`JsonObject`) and VOML PSI (`VomlPsi.Table`).
 */
class LegionManifestObject private constructor(
    private val json: JsonObject?,
    private val table: VomlPsi.Table?,
) {
    val isObject: Boolean
        get() = json != null || (table?.braceL != null)

    fun textOrNull(field: String): String? =
        json?.let { jsonScalarText(it.findProperty(field)?.value) }
            ?: table?.findPair(field)?.let { vomlScalarText(it.value) }

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
        val vomlValue = table?.findPair(field)?.value ?: return emptyList()
        val arrayTable = vomlValue.table?.takeIf { it.bracketL != null } ?: return emptyList()
        return arrayTable.valueList.mapNotNull { vomlScalarText(it) }
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
        val vomlChild = table?.findPair(field)?.value?.table?.takeIf { it.braceL != null }
        return vomlChild?.let { fromVoml(it) }
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
                name to LegionManifestValue.fromVoml(pair.value)
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

        fun fromVoml(table: VomlPsi.Table): LegionManifestObject = LegionManifestObject(null, table)

        fun rootTable(file: VomlFile): VomlPsi.Table? = VomlPsi.rootTable(file)
    }
}

class LegionManifestValue private constructor(
    private val json: JsonValue?,
    private val voml: VomlPsi.Value?,
) {
    fun textOrNull(): String? =
        json?.let { jsonScalarText(it) } ?: voml?.let { vomlScalarText(it) }

    fun asObject(): LegionManifestObject? {
        val jsonObject = json as? JsonObject
        if (jsonObject != null) {
            return LegionManifestObject.fromJson(jsonObject)
        }
        val vomlTable = voml?.table?.takeIf { it.braceL != null }
        return vomlTable?.let { LegionManifestObject.fromVoml(it) }
    }

    fun asStringList(): List<String> {
        val jsonArray = json as? JsonArray
        if (jsonArray != null) {
            return jsonArray.valueList.mapNotNull { jsonScalarText(it) }
        }
        val arrayTable = voml?.table?.takeIf { it.bracketL != null }
        return arrayTable?.valueList?.mapNotNull { vomlScalarText(it) } ?: emptyList()
    }

    companion object {
        fun fromJson(value: JsonValue): LegionManifestValue = LegionManifestValue(value, null)

        fun fromVoml(value: VomlPsi.Value): LegionManifestValue = LegionManifestValue(null, value)
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

private fun VomlPsi.Table.findPair(field: String): VomlPsi.Pair? =
    pairList.firstOrNull { pair -> pairKey(pair) == field }

private fun pairKey(pair: VomlPsi.Pair): String? {
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

private fun vomlScalarText(value: VomlPsi.Value): String? {
    value.annotation?.valueList?.firstOrNull()?.let { return vomlScalarText(it) }
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
