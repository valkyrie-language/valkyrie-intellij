package valkyrie.language.ast.classes

import com.intellij.codeInsight.daemon.LineMarkerInfo
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo
import com.intellij.icons.AllIcons
import com.intellij.navigation.GotoRelatedItem
import com.intellij.navigation.ItemPresentation
import com.intellij.openapi.editor.markup.GutterIconRenderer
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.impl.source.tree.CompositeElement
import com.intellij.refactoring.suggested.endOffset
import valkyrie.ide.highlight.NodeHighlighter
import valkyrie.ide.highlight.ValkyrieHighlightColor
import valkyrie.ide.hint.ParameterInlayHint
import valkyrie.ide.hint.TypeInlayHint
import valkyrie.ide.view.IdentifierPresentation
import valkyrie.language.antlr.ValkyrieAntlrParser
import valkyrie.language.antlr.ValkyrieParser
import valkyrie.language.ast.ValkyrieFunctionParameter
import valkyrie.language.ast.ValkyrieIdentifierNode
import valkyrie.language.ast.ValkyrieModifiedNode
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.language.psi.*
import javax.swing.Icon


class ValkyrieClassMethodNode : ValkyrieScopeNode, PsiNameIdentifierOwner, ValkyrieLineMarkElement,
    ValkyrieHighlightElement, ValkyrieInlayElement {
    constructor(node: CompositeElement) : super(node)

    val method by lazy { ValkyrieModifiedNode.findIdentifier(this) }
    val modifiers by lazy { ValkyrieModifiedNode.findModifiers(this) };

    override fun getName(): String {
        return method?.name ?: ""
    }

    override fun setName(name: String): ValkyrieIdentifierNode {
        return ValkyrieFactory(this.project).create_identifier(name)!!
    }

    override fun getBaseIcon(): Icon {
        if (method?.name == "constructor") {
            return AllIcons.Nodes.ClassInitializer
        }
        if (method?.name == "+") {
            return AllIcons.Gutter.ImplementingMethod
        }
        for (m in modifiers) {
            if (m.name == "get" || m.name == "set") {
                return AllIcons.Nodes.Property
            }
        }
        return ValkyrieIconProvider.Instance.Method
    }


    override fun getPresentation(): ItemPresentation {
        return IdentifierPresentation(method, this.baseIcon)
    }


    override fun getNameIdentifier(): PsiElement? {
        return method
    }

    override fun on_highlight(e: NodeHighlighter) {
        if (name == "constructor") {
            e.register(nameIdentifier, ValkyrieHighlightColor.KEYWORD)
        } else {
            e.register(nameIdentifier, ValkyrieHighlightColor.SYM_FUNCTION_SELF)
        }
        e.register_modifiers(modifiers)
    }

    override fun on_line_mark(e: MutableCollection<in LineMarkerInfo<*>>) {
        if (nameIdentifier == null) {
            return
        }
        val info = RelatedItemLineMarkerInfo(
            nameIdentifier!!.firstChild,
            nameIdentifier!!.textRange,
            baseIcon,
            null,
            null,
            GutterIconRenderer.Alignment.RIGHT // 上
        ) { mutableListOf(GotoRelatedItem(this)) }
        e.add(info)
    }


    override fun type_hint(inlay: TypeInlayHint): Boolean {
        val typeHint = ValkyrieParser.getChildOfType(this, ValkyrieAntlrParser.RULE_return_type);
        val argument = ValkyrieParser.getChildOfType(this, ValkyrieAntlrParser.RULE_function_parameters);

        if (typeHint == null && argument != null) {
            if (name == "constructor") {
                inlay.inline(argument.endOffset, ": Self")
            }
            inlay.inline(argument.endOffset, ": Any?")
        }
        return true
    }

    override fun parameter_hint(inlay: ParameterInlayHint): Boolean {
        val argument = ValkyrieParser.getChildOfType(this, ValkyrieAntlrParser.RULE_function_parameters);
        val parameter = ValkyrieParser.getChildrenOfType<ValkyrieFunctionParameter>(argument)
        if (argument != null && parameter.isEmpty()) {
            for (m in modifiers) {
                if (m.name == "get") {
                    inlay.inline(argument.firstChild.endOffset, "self")
                } else if (m.name == "set") {
                    inlay.inline(argument.firstChild.endOffset, "mut self")
                }
            }
        }
        return false
    }
}

