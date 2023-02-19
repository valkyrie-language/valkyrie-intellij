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
import org.intellij.lang.regexp.RegExpLanguage
import valkyrie.ide.highlight.NodeHighlighter
import valkyrie.ide.highlight.ValkyrieHighlightColor
import valkyrie.ide.matcher.escaper.StringEscape
import valkyrie.language.antlr.ValkyrieAntlrParser
import valkyrie.language.antlr.ValkyrieParser
import valkyrie.language.psi.ValkyrieHighlightElement

class ValkyrieStringNode(node: ASTNode) : ASTWrapperPsiElement(node), PsiLanguageInjectionHost, ValkyrieHighlightElement {
    val handler by lazy {
        ValkyrieParser.getChildOfType<ValkyrieIdentifierNode>(this)
    }
    private val _text by lazy {
        ValkyrieParser.getChildOfType(this, ValkyrieAntlrParser.RULE_string)!!
    }
    private val injectLanguage = handler?.text?.lowercase();

    override fun isValidHost(): Boolean {
        return true
    }

    override fun updateText(text: String): PsiLanguageInjectionHost {
        TODO("Not yet implemented")
    }

    override fun createLiteralTextEscaper(): LiteralTextEscaper<out PsiLanguageInjectionHost> {
        return StringEscape(this)
    }

    fun injectPerform(r: MultiHostRegistrar) {
        when (injectLanguage) {
            null, "i" -> injectInterpolation(r)
            "r", "raw" -> {}
            "re" -> injectRegex(r)
            "json5", "jsonp", "json" -> inject(r, Json5Language.INSTANCE)
            "xp", "xpath" -> inject(r, XMLLanguage.INSTANCE)
            "xml" -> inject(r, XMLLanguage.INSTANCE)
            "html" -> inject(r, HTMLLanguage.INSTANCE)
            else -> Language.getRegisteredLanguages()
                .filter { it != Language.ANY }
                .firstOrNull { it.id == injectLanguage }
                ?.let { inject(r, it) }
        }
    }

    private fun injectInterpolation(registrar: MultiHostRegistrar) {

        val ranges = mutableListOf<TextRange>()
        val delta = handler?.text?.length ?: 0;
        var balance = 0;
        var start = 0;
        for (char in _text.text.withIndex()) {
            if (char.value == '{') {
                balance += 1;
                if (balance == 1) {
                    start = char.index + delta + 1;
                }
            } else if (char.value == '}') {
                balance -= 1;
                if (balance == 0) {
                    val end = char.index + delta;
                    ranges.add(TextRange(start, end))
                }
            }
        }
        if (ranges.isNotEmpty()) {
            for (range in ranges) {
                registrar.startInjecting(language);
                registrar.addPlace(null, null, this, range)
                registrar.doneInjecting()
            }
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