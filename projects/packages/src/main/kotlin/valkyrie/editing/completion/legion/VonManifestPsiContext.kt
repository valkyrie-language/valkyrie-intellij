package valkyrie.editing.completion.legion

import von.surface.psi.VonPairNode
import von.surface.psi.VonSymbolPathNode
import von.surface.psi.VonTableNode
import von.surface.psi.VonTypes
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiWhiteSpace
import com.intellij.psi.util.PsiTreeUtil

enum class VonCompletionSiteKind {
    OBJECT_KEY,
    OBJECT_VALUE,
    MAP_KEY,
    ARRAY_ITEM,
}

data class VonManifestCompletionContext(
    val kind: LegionManifestKind,
    val site: VonCompletionSiteKind,
    val enclosingTable: VonTableNode,
    val keyPath: List<String>,
    val property: VonSchemaProperty?,
    val objectSchema: VonSchemaObject?,
    val existingKeys: Set<String>,
)

object VonManifestPsiContext {
    fun manifestKind(file: PsiFile): LegionManifestKind? {
        val name = file.virtualFile?.name ?: file.name
        return when (name) {
            "legion.von", "legion.json" -> LegionManifestKind.PROJECT
            "legions.von", "legions.json" -> LegionManifestKind.WORKSPACE
            else -> null
        }
    }

    fun resolve(element: PsiElement): VonManifestCompletionContext? {
        val file = element.containingFile
        val manifestKind = manifestKind(file) ?: return null

        val table = enclosingTable(element) ?: return null

        // Prefer a pair that belongs to this table (not an outer pair whose value is this table).
        val pairInTable = pairOwnedByTable(table, element)
        if (pairInTable != null) {
            if (isInPairKey(element, pairInTable)) {
                return keySite(manifestKind, table, pairInTable)
            }
            if (isInPairValuePosition(element, pairInTable)) {
                return valueSite(manifestKind, table, pairInTable)
            }
        }

        // Caret on whitespace after `key:` / `key=` (value missing or not yet typed).
        findIncompleteValuePair(table, element)?.let { pair ->
            return valueSite(manifestKind, table, pair)
        }

        if (table.bracketL != null) {
            val keyPath = keyPathForTable(table, manifestKind)
            val parentProperty = keyPath.lastOrNull()?.let {
                LegionManifestSchema.resolveValueProperty(manifestKind, keyPath)
            }
            val itemSchema = parentProperty?.arrayItemSchema
            return VonManifestCompletionContext(
                kind = manifestKind,
                site = VonCompletionSiteKind.ARRAY_ITEM,
                enclosingTable = table,
                keyPath = keyPath,
                property = itemSchema,
                objectSchema = itemSchema?.objectSchema,
                existingKeys = emptySet(),
            )
        }

        return keySite(manifestKind, table, pair = null)
    }

    private fun keySite(
        manifestKind: LegionManifestKind,
        table: VonTableNode,
        pair: VonPairNode?,
    ): VonManifestCompletionContext {
        val keyPath = keyPathForTable(table, manifestKind)
        val objectSchema = LegionManifestSchema.resolveObjectSchema(manifestKind, keyPath)
        val site = if (isMapTable(manifestKind, keyPath)) {
            VonCompletionSiteKind.MAP_KEY
        } else {
            VonCompletionSiteKind.OBJECT_KEY
        }
        return VonManifestCompletionContext(
            kind = manifestKind,
            site = site,
            enclosingTable = table,
            keyPath = keyPath,
            property = null,
            objectSchema = objectSchema,
            existingKeys = existingKeys(table),
        )
    }

    private fun valueSite(
        manifestKind: LegionManifestKind,
        table: VonTableNode,
        pair: VonPairNode,
    ): VonManifestCompletionContext {
        val keyPath = keyPathForPair(pair, manifestKind)
        val property = LegionManifestSchema.resolveValueProperty(manifestKind, keyPath)
        return VonManifestCompletionContext(
            kind = manifestKind,
            site = VonCompletionSiteKind.OBJECT_VALUE,
            enclosingTable = table,
            keyPath = keyPath,
            property = property,
            objectSchema = property?.objectSchema,
            existingKeys = emptySet(),
        )
    }

    private fun enclosingTable(element: PsiElement): VonTableNode? {
        var current: PsiElement? = element
        while (current != null) {
            if (current is VonTableNode) {
                return current
            }
            current = current.parent
        }
        return null
    }

    /** Pair whose parent is [table] and that contains [element] (or key/value under it). */
    private fun pairOwnedByTable(table: VonTableNode, element: PsiElement): VonPairNode? {
        var current: PsiElement? = element
        while (current != null && current != table) {
            if (current is VonPairNode && current.parent == table) {
                return current
            }
            current = current.parent
        }
        return null
    }

    private fun isInPairKey(element: PsiElement, pair: VonPairNode): Boolean {
        if (isInside(pair.symbolPath, element)) {
            return true
        }
        if (element.node.elementType == VonTypes.KEY_SYMBOL) {
            return true
        }
        if (element.node.elementType == VonTypes.SYMBOL) {
            return PsiTreeUtil.getParentOfType(element, VonSymbolPathNode::class.java) == pair.symbolPath
        }
        if (element.node.elementType == VonTypes.STRING_INLINE || element.node.elementType == VonTypes.STRING) {
            return PsiTreeUtil.getParentOfType(element, VonSymbolPathNode::class.java) == pair.symbolPath
        }
        return false
    }

    private fun isInPairValuePosition(element: PsiElement, pair: VonPairNode): Boolean {
        if (isInPairKey(element, pair)) {
            return false
        }
        val value = pair.value
        if (value != null && isInside(value, element)) {
            // Nested table/array is its own completion scope; only treat leaf values here.
            if (value.table != null && enclosingTable(element) !== pair.parent) {
                return false
            }
            return true
        }
        // Incomplete pair: caret after `:` / `=` but still under the pair node.
        if (isInside(pair, element) && separatorOf(pair) != null) {
            return !isInPairKey(element, pair)
        }
        return false
    }

    /**
     * When the caret sits after an incomplete `key:` / `key=` (missing value),
     * including whitespace / error elements that are siblings under the table.
     */
    private fun findIncompleteValuePair(table: VonTableNode, element: PsiElement): VonPairNode? {
        val offset = element.textRange.startOffset
        for (pair in table.pairList.asReversed()) {
            if (pair.parent != table) {
                continue
            }
            val sep = separatorOf(pair) ?: continue
            if (offset < sep.textRange.endOffset) {
                continue
            }
            val value = pair.value
            if (value != null && value.textLength > 0) {
                continue
            }
            val limit = nextSiblingBound(pair, table)
            if (offset <= limit) {
                return pair
            }
        }

        // Fallback when the parser did not recover a PAIR for `key:`.
        return findValuePairFromPrecedingSeparator(table, element)
    }

    private fun nextSiblingBound(pair: VonPairNode, table: VonTableNode): Int {
        var sibling = pair.nextSibling
        while (sibling != null) {
            if (sibling !is PsiWhiteSpace && sibling.node?.elementType != VonTypes.COMMA) {
                return sibling.textRange.startOffset
            }
            sibling = sibling.nextSibling
        }
        return table.braceR?.textRange?.startOffset
            ?: table.bracketR?.textRange?.startOffset
            ?: Int.MAX_VALUE
    }

    private fun findValuePairFromPrecedingSeparator(
        table: VonTableNode,
        element: PsiElement,
    ): VonPairNode? {
        var leaf: PsiElement? = PsiTreeUtil.prevLeaf(element, true)
        while (leaf != null) {
            if (leaf is PsiWhiteSpace || leaf.node?.elementType == VonTypes.COMMA) {
                leaf = PsiTreeUtil.prevLeaf(leaf, true)
                continue
            }
            break
        }
        val type = leaf?.node?.elementType
        if (type != VonTypes.COLON && type != VonTypes.EQ) {
            return null
        }
        val pair = PsiTreeUtil.getParentOfType(leaf, VonPairNode::class.java) ?: return null
        return pair.takeIf { it.parent == table }
    }

    private fun separatorOf(pair: VonPairNode): PsiElement? {
        var child = pair.firstChild
        while (child != null) {
            val type = child.node?.elementType
            if (type == VonTypes.COLON || type == VonTypes.EQ) {
                return child
            }
            child = child.nextSibling
        }
        return null
    }

    private fun isInside(container: PsiElement?, element: PsiElement): Boolean {
        if (container == null) {
            return false
        }
        var current: PsiElement? = element
        while (current != null && current != container) {
            current = current.parent
        }
        return current == container
    }

    private fun keyPathForPair(pair: VonPairNode, manifestKind: LegionManifestKind): List<String> {
        val parentTable = pair.parent as? VonTableNode ?: return listOfNotNull(pairKey(pair))
        val parentPath = keyPathForTable(parentTable, manifestKind)
        val key = pairKey(pair) ?: return parentPath
        return parentPath + key
    }

    private fun keyPathForTable(table: VonTableNode, manifestKind: LegionManifestKind): List<String> {
        val segments = mutableListOf<String>()
        var current: PsiElement? = table
        while (current != null) {
            val parentPair = PsiTreeUtil.getParentOfType(current, VonPairNode::class.java, true)
            if (parentPair == null) {
                break
            }
            // Only climb through pairs that wrap this table as their value.
            val valueTable = parentPair.value?.table
            if (valueTable != current && !isAncestor(valueTable, current)) {
                current = parentPair.parent
                continue
            }
            val key = pairKey(parentPair)
            if (key != null) {
                segments.add(0, key)
            }
            current = parentPair.parent
        }
        return segments
    }

    private fun isAncestor(ancestor: PsiElement?, element: PsiElement): Boolean {
        if (ancestor == null) {
            return false
        }
        return isInside(ancestor, element)
    }

    private fun existingKeys(table: VonTableNode): Set<String> =
        table.pairList.mapNotNull(::pairKey).toSet()

    private fun isMapTable(
        manifestKind: LegionManifestKind,
        parentKeyPath: List<String>,
    ): Boolean {
        val parentProperty = parentKeyPath.lastOrNull()?.let {
            LegionManifestSchema.resolveValueProperty(manifestKind, parentKeyPath)
        }
        return parentProperty?.kind == VonSchemaValueKind.MAP
    }

    private fun pairKey(pair: VonPairNode): String? {
        val path = pair.symbolPath
        if (path.keySymbolList.isNotEmpty()) {
            return path.keySymbolList.joinToString(".") { it.text }
        }
        val inline = path.stringInlineList.firstOrNull()?.text ?: return null
        return unquoteString(inline)
    }

    private fun unquoteString(raw: String): String {
        if (raw.length >= 2 && raw.first() == '"' && raw.last() == '"') {
            return raw.substring(1, raw.length - 1)
        }
        return raw
    }
}
