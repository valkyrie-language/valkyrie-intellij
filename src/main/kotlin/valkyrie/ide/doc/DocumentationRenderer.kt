package valkyrie.ide.doc

//import valkyrie.language.psi_node.ValkyrieClassStatementNode
//import valkyrie.language.psi_node.ValkyrieTraitStatementNode
import com.intellij.openapi.editor.colors.EditorColorsManager
import com.intellij.openapi.editor.richcopy.HtmlSyntaxInfoUtil
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType
import com.intellij.ui.ColorUtil
import valkyrie.ide.highlight.ValkyrieHighlightColor
import valkyrie.ide.highlight.ValkyrieHighlightColor.*
import valkyrie.language.ValkyrieLanguage
import valkyrie.language.ast.classes.ValkyrieClassStatement
import valkyrie.language.ast.ValkyrieTraitStatement
import valkyrie.language.antlr.ValkyrieLexer
import valkyrie.lsp.RequestDocument

class DocumentationRenderer(var element: PsiElement, private var original: PsiElement?) {
    private val doc = StringBuilder()
    fun onHover(): String {
         when {
            ValkyrieLexer.Keywords.contains(element.elementType) -> return RequestDocument.keyword(element.text).send()
             ValkyrieLexer.Operators.contains(element.elementType) -> return RequestDocument.operator(element.text).send()
            else -> {}
        }
        when (element) {
            is ValkyrieTraitStatement -> buildDetail(element as ValkyrieTraitStatement)
            is ValkyrieClassStatement -> buildShort(element as ValkyrieClassStatement)
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

    private fun buildShort(element: ValkyrieTraitStatement) {
        append(KEYWORD, "crate ")
        appendNamespace()
        doc.append("<br/>")
        append(KEYWORD, "public ")
        append(KEYWORD, "native ")
        append(KEYWORD, "trait ")
        append(SYM_TRAIT, element.name)
    }

    private fun buildDetail(element: ValkyrieTraitStatement) {
        this.buildShort(element)
    }

    private fun buildShort(element: ValkyrieClassStatement) {
        append(KEYWORD, "crate ")
        appendNamespace()
        doc.append("<br/>")
        append(KEYWORD, "public ")
        append(KEYWORD, "native ")
        append(KEYWORD, "class ")
        append(SYM_CLASS, element.name ?: "[Unknown]")
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


