package valkyrie.language.ast

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.icons.AllIcons
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.impl.source.tree.CompositeElement
import com.intellij.psi.tree.IElementType
import com.intellij.psi.util.elementType
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode
import valkyrie.ide.codeStyle.ValkyrieCodeStyleSettings
import valkyrie.ide.formatter.ValkyrieRewriter
import valkyrie.language.ValkyrieLanguage
import valkyrie.language.antlr.ValkyrieAntlrParser
import valkyrie.language.antlr.childrenWithLeaves
import valkyrie.language.psi.ValkyrieRewritableElement
import javax.swing.Icon

class ValkyrieNamespaceStatement(node: CompositeElement, type: IElementType) : ASTWrapperPsiElement(node),
    PsiNameIdentifierOwner,
    ValkyrieRewritableElement {
    val namepath by lazy { ValkyrieNamepathNode.find(this)!! }

    override fun getName(): String {
        return namepath.identifiers.joinToString(".") { it.text }
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    val namespace: Array<String>
        get() {
            return arrayOf()
        }


    override fun getNameIdentifier(): ValkyrieIdentifierNode {
        return namepath.nameIdentifier
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
}