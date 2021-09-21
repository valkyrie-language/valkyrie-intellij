package valkyrie.ide.doc

import com.intellij.openapi.editor.colors.EditorColorsManager
import com.intellij.openapi.editor.richcopy.HtmlSyntaxInfoUtil
import com.intellij.psi.PsiElement
import com.intellij.ui.ColorUtil
import valkyrie.language.ValkyrieLanguage
import valkyrie.ide.highlight.ValkyrieHighlightColor
import valkyrie.ide.highlight.ValkyrieHighlightColor.*
import valkyrie.language.psi.ValkyrieTokenType
import valkyrie.language.psi_node.ValkyrieClassStatementNode
import valkyrie.language.psi_node.ValkyrieTraitStatementNode
import valkyrie.language.symbol.KeywordData
import valkyrie.language.symbol.ModifierData
import valkyrie.language.symbol.OperatorData
import valkyrie.lsp.RequestDocument

class DocumentationRenderer(var element: PsiElement, private var original: PsiElement?) {
    private val doc = StringBuilder()
    fun onHover(): String {
         when {
            ValkyrieTokenType.isKeyword(element) -> return RequestDocument.keyword(element.text).send()
            ValkyrieTokenType.isOperator(element) -> return RequestDocument.operator(element.text).send()
            else -> {}
        }
        when (element) {
            is ValkyrieTraitStatementNode -> buildDetail(element as ValkyrieTraitStatementNode)
            is ValkyrieClassStatementNode -> buildShort(element as ValkyrieClassStatementNode)
            else -> {
                doc.append(element)
                doc.append("<br/>")
                doc.append(original)
                doc.append("<br/>")
                doc.append("onDetail: ${element.text}")
            }
        }
        return doc.toString()
    }

    fun onDetail(): String {
        when (val tokens = KeywordData.builtinData(element)) {
            null -> {}
            else -> {
                tokens.documentation(this)
                return doc.toString()
            }
        }
        when (val tokens = OperatorData.builtinData(element)) {
            null -> {}
            else -> {
                tokens.documentation(this)
                return doc.toString()
            }
        }
        when (val tokens = ModifierData.builtinData(element)) {
            null -> {}
            else -> {
                tokens.documentation(this)
                return doc.toString()
            }
        }

        when (element) {
            is ValkyrieTraitStatementNode -> buildDetail(element as ValkyrieTraitStatementNode)
            is ValkyrieClassStatementNode -> buildShort(element as ValkyrieClassStatementNode)
            else -> {
                doc.append(element)
                doc.append("<br/>")
                doc.append(original)
                doc.append("<br/>")
                doc.append("onDetail: ${element.text}")
            }
        }
        return doc.toString()
    }

    private fun buildShort(element: ValkyrieTraitStatementNode) {
        append(KEYWORD, "crate ")
        appendNamespace()
        doc.append("<br/>")
        append(KEYWORD, "public ")
        append(KEYWORD, "native ")
        append(KEYWORD, "trait ")
        append(SYM_TRAIT, element.name)
    }

    private fun buildDetail(element: ValkyrieTraitStatementNode) {
        this.buildShort(element)
    }

    private fun buildShort(element: ValkyrieClassStatementNode) {
        append(KEYWORD, "crate ")
        appendNamespace()
        doc.append("<br/>")
        append(KEYWORD, "public ")
        append(KEYWORD, "native ")
        append(KEYWORD, "class ")
        append(SYM_CLASS, element.name)
//        appendNewline()
//        append(KEYWORD, "implements ")
//        append(SYM_TRAIT, "Eq")
//        appendAdd()
//        append(SYM_TRAIT, "Hash")
    }


    /// get the path relative to the project root
    /// FIXME: get real declare module
    private fun appendNamespace() {
        val file = element.containingFile;
        // fake module path
        val path = file.virtualFile.path.substringAfter("src/").replace("/", "::").replace(".vk", "")
        append(path)
    }

    fun append(text: String) {
        doc.append("<span>${text}</span>")
    }

    fun append(key: ValkyrieHighlightColor, text: String) {
        // HtmlSyntaxInfoUtil.getStyledSpan(key.textAttributesKey, text, 1.0f)
        val attr = EditorColorsManager.getInstance().globalScheme.getAttributes(key.textAttributesKey)
        val color = ColorUtil.toHtmlColor(attr.foregroundColor)
        doc.append("<span style='color:${color}'>${text}</span>")
    }

    private fun appendHighlight(code: String) {
        HtmlSyntaxInfoUtil.appendHighlightedByLexerAndEncodedAsHtmlCodeSnippet(
            doc,
            element.project,
            ValkyrieLanguage,
            code.trimIndent(),
            1.0f,
        )
    }

    private fun appendAdd() {
        doc.append("<span>+</span>")
    }
}


