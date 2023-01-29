package valkyrie.language.ast

import ai.grazie.utils.isUppercase
import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.tree.IElementType
import com.intellij.psi.util.PsiTreeUtil
import org.antlr.intellij.adaptor.psi.IdentifierDefSubtree
import valkyrie.ide.highlight.ValkyrieHighlightColor
import valkyrie.language.antlr.register
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




    override fun on_highlight(e: HighlightInfoHolder) {
        fakeTypeColor(e, nameIdentifier)
    }

    companion object {
        fun find(node: PsiElement): ValkyrieNamepathNode? {
            return PsiTreeUtil.getChildOfType(node, ValkyrieNamepathNode::class.java)
        }
    }

}


private fun fakeTypeColor(info: HighlightInfoHolder, psi: ValkyrieIdentifierNode) {
    val name = psi.name
    if (keywords.contains(name)) {
        info.register(psi, ValkyrieHighlightColor.KEYWORD)
    } else if (traits.contains(name)) {
        info.register(psi, ValkyrieHighlightColor.SYM_TRAIT)
    } else if (variants.contains(name)) {
        info.register(psi, ValkyrieHighlightColor.SYM_VARIANT)
    } else if (name.isUppercase()) {
        info.register(psi, ValkyrieHighlightColor.SYM_GENERIC)
    } else {
        val first = name.firstOrNull();
        if (first != null && first.isUpperCase()) {
            info.register(psi, ValkyrieHighlightColor.SYM_CLASS)
        }
    }
}

private val keywords = setOf(
    "u8", "u16", "u32", "u64", "int",
    "i8", "i16", "i32", "i64",
    "f32", "f64",
    "bool", "char", "string",
    "unit",
    "pass", "scope", "async", "await", "quote",
    "self", "Self"
)

private val traits = setOf("Iterator", "Iterable", "Sequence", "Debug", "Display")

private val variants = setOf("Some", "None", "Success", "Failure", "Left", "Riht")

