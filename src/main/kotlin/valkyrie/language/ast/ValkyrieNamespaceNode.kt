package valkyrie.language.ast

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.icons.AllIcons
import com.intellij.psi.impl.source.tree.CompositeElement
import com.intellij.psi.util.elementType
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode
import valkyrie.ide.codeStyle.ValkyrieCodeStyleSettings
import valkyrie.ide.formatter.ValkyrieRewriter
import valkyrie.ide.highlight.NodeHighlighter
import valkyrie.language.ValkyrieLanguage
import valkyrie.language.antlr.ValkyrieAntlrParser
import valkyrie.language.antlr.childrenWithLeaves
import valkyrie.language.psi.ValkyrieHighlightElement
import valkyrie.language.psi.ValkyrieRewritableElement
import javax.swing.Icon

class ValkyrieNamespaceNode(node: CompositeElement) : ASTWrapperPsiElement(node),
    ValkyrieRewritableElement, ValkyrieHighlightElement {
    val namepath = ValkyrieNamepathNode.find(this)


    override fun getName(): String? {
        return namepath?.identifiers?.joinToString(".") { it.text }
    }


    override fun getBaseIcon(): Icon {
        return AllIcons.Nodes.Module
    }

//    override fun getPresentation(): ItemPresentation {
//        return PresentationData(namepath.namespace, null, baseIcon, null)
//    }

//    override fun resolve(element: PsiNamedElement?): PsiElement? {
//        return SymtabUtils.resolve(this, ValkyrieLanguage, element, "/script/trait/ID");
//    }

    fun isTestFile(): Boolean {
        return false;
    }

    override fun on_rewrite(e: ValkyrieRewriter) {
        val split = PSIElementTypeFactory.createTokenSet(
            ValkyrieLanguage,
            ValkyrieAntlrParser.DOT,
            ValkyrieAntlrParser.OP_PROPORTION
        );
        if (namepath == null) {
            return
        }
        for (leaf in namepath.childrenWithLeaves) {
            if (split.contains(leaf.elementType)) {
                when (e.settings.namespace_delimiter) {
                    ValkyrieCodeStyleSettings.NamespaceDelimiter.Ignore -> break
                    ValkyrieCodeStyleSettings.NamespaceDelimiter.Dot -> e.replace_dot(leaf)
                    ValkyrieCodeStyleSettings.NamespaceDelimiter.Colon -> e.replace_proportion(leaf, false)
                    ValkyrieCodeStyleSettings.NamespaceDelimiter.UnicodeColon -> e.replace_proportion(leaf, true)
                }
            }
        }

        val last = lastChild;
        when (e.settings.namespace_colon) {
            ValkyrieCodeStyleSettings.Triplet.Ignore -> {}
            ValkyrieCodeStyleSettings.Triplet.Always -> if (last !is ANTLRPsiNode) {
                e.insertAfter(this, ";")
            }

            ValkyrieCodeStyleSettings.Triplet.Nothing -> if (last is ANTLRPsiNode) {
                e.delete_node(last)
            }
        }
    }

    override fun on_highlight(e: NodeHighlighter) {
        val pkg = namepath?.identifiers?.firstOrNull();
        if (pkg?.name == "package") {
            e.register_keywords(pkg)
        }
    }
}