package valkyrie.psi.mixin

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiQualifiedNamedElement
import com.intellij.psi.impl.source.tree.SharedImplUtil
import valkyrie.ide.highlight.HighlightColor
import valkyrie.ide.highlight.NodeHighlighter
import valkyrie.ide.reference.declaration.ValkyrieReference
import valkyrie.language.file.ValkyrieFileNode
import valkyrie.psi.ValkyrieElement
import valkyrie.psi.node.*

abstract class MixinIdentifier(node: ASTNode) : ValkyrieElement(node), ValkyrieIdentifier {
    override fun getContainingFile(): ValkyrieFileNode {
        return SharedImplUtil.getContainingFile(node) as ValkyrieFileNode
    }

    override fun getName(): String {
        return this.text.trim('`')
    }


    override fun getReference(): ValkyrieReference? {
        if (this.parent is ValkyrieDeclareClass) {
            return null
        }
        if (this.parent is ValkyrieDeclareUnion) {
            return null
        }
        return ValkyrieReference(this as ValkyrieIdentifierNode)
    }


    override fun highlight(highlighter: NodeHighlighter) {
        return when (this.text) {
            "HIDE", "ANY", "INDENT", "DEDENT" -> highlighter.highlight(this, HighlightColor.SYM_MACRO)
            "SOI", "START_OF_INPUT",
            "EOI", "END_OF_INPUT",
            "EOF", "END_OF_FILE",
            "EOL", "END_OF_LINE",
            "ROL", "REST_OF_LINE",
            -> highlighter.highlight(this, HighlightColor.SYM_CONSTANT)

            else -> {
                if (this.reference != null) {
                    this.reference!!.highlight(highlighter)
                } else {

                }


            }
        }
    }


}


abstract class MixinNamepath(node: ASTNode) : ValkyrieElement(node), ValkyrieNamepath, PsiQualifiedNamedElement {
    val identifier: ValkyrieIdentifierNode = identifierList.last() as ValkyrieIdentifierNode;

    override fun getContainingFile(): ValkyrieFileNode {
        return SharedImplUtil.getContainingFile(node) as ValkyrieFileNode
    }

    override fun getName(): String {
        return identifier.name
    }

    override fun getQualifiedName(): String {
        val names: MutableList<String> = mutableListOf()
        for (i in identifierList) {
            val id = i as ValkyrieIdentifierNode;
            names.add(id.name)
        }
        return names.joinToString("∷")
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }


    override fun highlight_fake(highlighter: NodeHighlighter) {
        val last = identifierList.last() as ValkyrieIdentifierNode;
        val second = identifierList.getOrNull(identifierList.size - 2) as? ValkyrieIdentifierNode?;
        if (second != null) {
            if (second.name.first().isUpperCase()) {
                highlighter.highlight(second, HighlightColor.SYM_CLASS)
                if (last.name.first().isUpperCase()) {
                    highlighter.highlight(last, HighlightColor.SYM_FIELD)
                }
            }
        }
        val variants = setOf("Some", "None", "Success", "Failure")
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


}