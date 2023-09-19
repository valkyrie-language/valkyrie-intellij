package valkyrie.psi.mixin

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiQualifiedNamedElement
import com.intellij.psi.util.elementType
import com.intellij.psi.util.firstLeaf
import valkyrie.ide.highlight.HighlightColor
import valkyrie.ide.highlight.NodeHighlighter
import valkyrie.ide.reference.declaration.ValkyrieNamepathReference
import valkyrie.psi.ValkyrieElement
import valkyrie.psi.ValkyrieTypes
import valkyrie.psi.node.ValkyrieNamepath

abstract class MixinNamepath : ValkyrieElement, PsiQualifiedNamedElement {
    constructor(node: ASTNode) : super(node)

    val namepath: List<MixinIdentifier> by lazy { children.filterIsInstance<MixinIdentifier>() }
    val namespace: List<MixinIdentifier> by lazy {
        if (namepath.size > 1) {
            namepath.subList(0, namepath.size - 1)
        } else {
            emptyList()
        }
    }
    val identifier: MixinIdentifier? by lazy { namepath.lastOrNull() }

    override fun getName(): String {
        return namepath.lastOrNull()?.name ?: "<<Missing Namepath>>"
    }

    override fun getQualifiedName(): String {
        val names: MutableList<String> = mutableListOf()
        for (id in namepath) {
            names.add(id.name)
        }
        return names.joinToString("∷")
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getReference(): ValkyrieNamepathReference? {
        return references.lastOrNull()
    }

    override fun getReferences(): Array<ValkyrieNamepathReference> {
        return ValkyrieNamepathReference.fromList(this, this.namepath)
    }
}

fun ValkyrieNamepath.highlight(highlighter: NodeHighlighter) {
    highlightFake(highlighter, this as MixinNamepath)
    if (this.firstLeaf().elementType == ValkyrieTypes.NAME_SCOPE) {
        highlighter.highlight(this.firstChild, HighlightColor.KEYWORD)
    }
    for (reference in this.references) {
        reference.highlight(highlighter)
    }
}

fun highlightFake(highlighter: NodeHighlighter, namepath: MixinNamepath) {
    val last = namepath.identifier;
    if (last == null) return;
    val second = namepath.namespace.lastOrNull();
    if (second != null) {
        if (second.name.first().isUpperCase()) {
            highlighter.highlight(second, HighlightColor.SYM_CLASS)
            if (last.name.first().isUpperCase()) {
                highlighter.highlight(last, HighlightColor.SYM_VARIANT)
            }
        }
    } else {
        val keywords = setOf("loop", "async", "await", "sequence", "scope");
        val builtin = setOf(
            "_",
            "u8", "u16", "u32", "u64", "u128", "u256", "usize",
            "i8", "i16", "i32", "i64", "i128", "i256", "isize", "int",
            "f16", "f32", "f64", "f128",
            "d128", "dec",
            "bool", "char",
            "string", "str"
        );
        if (keywords.contains(last.name)) {
            highlighter.highlight(last, HighlightColor.KEYWORD)
            return
        }
        if (builtin.contains(last.name)) {
            highlighter.highlight(last, HighlightColor.KEYWORD)
            return
        }
    }

    val variants = setOf("Some", "None", "Fine", "Fail", "Success", "Failure")
    when {
        variants.contains(last.name) -> {
            highlighter.highlight(last, HighlightColor.SYM_FIELD)
        }

        last.name.first().isUpperCase() -> {
            highlighter.highlight(last, HighlightColor.SYM_CLASS)
        }

        else -> {
            highlighter.highlight(last, HighlightColor.SYM_FUNCTION_FREE)
        }
    }
}