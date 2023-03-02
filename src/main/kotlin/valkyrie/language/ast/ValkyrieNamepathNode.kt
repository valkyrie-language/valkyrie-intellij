package valkyrie.language.ast

import ai.grazie.utils.isUppercase
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.tree.IElementType
import com.intellij.psi.util.PsiTreeUtil
import org.antlr.intellij.adaptor.psi.IdentifierDefSubtree
import valkyrie.ide.highlight.NodeHighlighter
import valkyrie.ide.highlight.ValkyrieHighlightColor
import valkyrie.language.psi.ValkyrieHighlightElement


class ValkyrieNamepathNode(node: ASTNode, type: IElementType, val free: Boolean = false) : IdentifierDefSubtree(node, type),
    ValkyrieHighlightElement {
    val identifiers = findChildrenByClass(ValkyrieIdentifierNode::class.java)
    val parentIdentifier: Array<ValkyrieIdentifierNode> = identifiers.dropLast(1).toTypedArray()
    val namespace: String = parentIdentifier.joinToString(".") { it.text }

    override fun getName(): String {
        return nameIdentifier.name
    }

    override fun getNameIdentifier(): ValkyrieIdentifierNode {
        return identifiers.last()
    }


    companion object {
        fun find(node: PsiElement): ValkyrieNamepathNode? {
            return PsiTreeUtil.getChildOfType(node, ValkyrieNamepathNode::class.java)
        }
    }

    override fun on_highlight(e: NodeHighlighter) {
        val head = identifiers.firstOrNull();
        if (identifiers.count() == 1) {
            fakeTypeColor(e, head!!)
        } else {
            if (head?.name == "Self") {
                e.register_keywords(head)
            }
            fakeTypeColor(e, identifiers.last())
        }
    }

}


private fun fakeTypeColor(info: NodeHighlighter, psi: ValkyrieIdentifierNode) {
    val name = psi.name
    if (keywords.contains(name)) {
        info.register(psi, ValkyrieHighlightColor.KEYWORD)
    } else if (traits.contains(name)) {
        info.register(psi, ValkyrieHighlightColor.SYM_TRAIT)
    } else if (variants.contains(name)) {
        info.register(psi, ValkyrieHighlightColor.SYM_VARIANT)
    } else if (functions.contains(name)) {
        info.register(psi, ValkyrieHighlightColor.SYM_FUNCTION_FREE)
    } else if (name.startsWith('_')) {
        info.register(psi, ValkyrieHighlightColor.SYM_ARG)
    } else if (name.isUppercase()) {
        info.register(psi, ValkyrieHighlightColor.SYM_GENERIC)
    } else {
        val first = name.firstOrNull();
        if (first != null && first.isUpperCase()) {
            info.register(psi, ValkyrieHighlightColor.SYM_CLASS)
        }
    }
}

private val functions = setOf(
    "print",
)


private val keywords = setOf(
    "u8", "u16", "u32", "u64", "int",
    "i8", "i16", "i32", "i64",
    "f32", "f64",
    "bool", "char", "string",
    "unit", "callcc", "go",
    "scope", "async", "await", "quote",
    "self", "Self",
    "violate", "value"
)

private val traits = setOf(
    "Iterator", "Iterable", "Sequence",
    "Debug", "Display", "Default",
    "Encode", "Decode", "Write"
)

private val variants = setOf("Some", "None", "Success", "Failure", "Left", "Riht")

