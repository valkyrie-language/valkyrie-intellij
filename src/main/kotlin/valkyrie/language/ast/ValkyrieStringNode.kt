package valkyrie.language.ast

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.json.json5.Json5Language
import com.intellij.lang.ASTNode
import com.intellij.lang.Language
import com.intellij.lang.html.HTMLLanguage
import com.intellij.lang.injection.MultiHostRegistrar
import com.intellij.lang.xml.XMLLanguage
import com.intellij.openapi.util.TextRange
import com.intellij.psi.LiteralTextEscaper
import com.intellij.psi.PsiLanguageInjectionHost
import com.intellij.psi.util.PsiTreeUtil
import org.intellij.lang.regexp.RegExpLanguage
import valkyrie.ide.highlight.NodeHighlighter
import valkyrie.ide.highlight.ValkyrieHighlightColor
import valkyrie.ide.matcher.escaper.StringEscape
import valkyrie.language.antlr.ValkyrieAntlrParser
import valkyrie.language.antlr.ValkyrieParser
import valkyrie.language.psi.ValkyrieHighlightElement

class ValkyrieStringNode(node: ASTNode) : ASTWrapperPsiElement(node), PsiLanguageInjectionHost, ValkyrieHighlightElement {
    val handler by lazy {
        PsiTreeUtil.getChildOfType(this, ValkyrieIdentifierNode::class.java)
    }
    private val _text by lazy {
        ValkyrieParser.getChildOfType(this, ValkyrieAntlrParser.RULE_string)!!
    }
    private val injectLanguage = handler?.name?.lowercase();

    override fun isValidHost(): Boolean {
        return handler != null
    }

    override fun updateText(text: String): PsiLanguageInjectionHost {
        TODO("Not yet implemented")
    }

    override fun createLiteralTextEscaper(): LiteralTextEscaper<out PsiLanguageInjectionHost> {
        return StringEscape(this)
    }

    fun injectPerform(r: MultiHostRegistrar) {
        when (injectLanguage) {
            "re" -> injectRegex(r)
            "json5", "jsonp", "json" -> inject(r, Json5Language.INSTANCE)
            "xp", "xpath" -> inject(r, XMLLanguage.INSTANCE)
            "xml" -> inject(r, XMLLanguage.INSTANCE)
            "html" -> inject(r, HTMLLanguage.INSTANCE)
            null -> {}
            else -> Language.getRegisteredLanguages()
                .filter { it != Language.ANY }
                .firstOrNull { it.id == injectLanguage }
                ?.let { inject(r, it) }
        }
    }

    private fun inject(registrar: MultiHostRegistrar, language: Language) {
        registrar.startInjecting(language)
            .addPlace(null, null, this, innerRange())
            .doneInjecting()
    }

    private fun injectRegex(registrar: MultiHostRegistrar) {
        registrar.startInjecting(RegExpLanguage.INSTANCE)
            .addPlace("(?x)", null, this, innerRange())
            .doneInjecting()
    }


    private fun innerRange(): TextRange {
        val delta = _text.firstChild.textLength;
        val start = _text.textRange.startOffset - textRange.startOffset + delta;
        val end = _text.textRange.endOffset - textRange.startOffset - delta;
        return TextRange(start, end)
    }


    override fun on_highlight(e: NodeHighlighter) {
        e.register(handler, ValkyrieHighlightColor.SYM_MACRO)
    }
}