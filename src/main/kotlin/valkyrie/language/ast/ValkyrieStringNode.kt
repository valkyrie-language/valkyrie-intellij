package valkyrie.language.ast

import com.intellij.json.json5.Json5Language
import com.intellij.lang.ASTNode
import com.intellij.lang.Language
import com.intellij.lang.html.HTMLLanguage
import com.intellij.lang.injection.MultiHostRegistrar
import com.intellij.lang.xml.XMLLanguage
import com.intellij.openapi.util.TextRange
import com.intellij.psi.LiteralTextEscaper
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiLanguageInjectionHost
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.tree.IElementType
import org.antlr.intellij.adaptor.psi.IdentifierDefSubtree
import org.antlr.intellij.adaptor.psi.ScopeNode
import org.intellij.lang.regexp.RegExpLanguage

class ValkyrieStringNode(node: ASTNode, type: IElementType) : IdentifierDefSubtree(node, type),
    ScopeNode, PsiLanguageInjectionHost {
        private val injectLanguage = "js";
    public val injectRange = TextRange(0, 0)
    override fun resolve(element: PsiNamedElement?): PsiElement? {
        TODO("Not yet implemented")
    }

    override fun isValidHost(): Boolean {
        TODO("Not yet implemented")
    }

    override fun updateText(text: String): PsiLanguageInjectionHost {
        TODO("Not yet implemented")
    }

    override fun createLiteralTextEscaper(): LiteralTextEscaper<out PsiLanguageInjectionHost> {
        TODO("Not yet implemented")
    }

    fun injectPerform(registrar: MultiHostRegistrar) {
        when (injectLanguage.lowercase()) {
            "re" -> registrar.fastRegister(RegExpLanguage.INSTANCE, this)
            "re_x" -> registrar.startInjecting(RegExpLanguage.INSTANCE)
                .addPlace("(?x)", null, this, injectRange)
                .doneInjecting()

            "json5", "jsonp", "json" -> registrar.fastRegister(Json5Language.INSTANCE, this)
//        "jp", "json_path" -> registrar.fastRegister(JsonPathLanguage.INSTANCE, this)
            "xp", "xpath" -> registrar.fastRegister(XMLLanguage.INSTANCE, this)
            "xml" -> registrar.fastRegister(XMLLanguage.INSTANCE, this)
            "html" -> registrar.fastRegister(HTMLLanguage.INSTANCE, this)
            else -> Language.getRegisteredLanguages()
                .filter { it != Language.ANY }
                .firstOrNull { it.id == injectLanguage }
                ?.let { registrar.fastRegister(it, this) }
        }
    }
}

private fun MultiHostRegistrar.fastRegister(language: Language, node: ValkyrieStringNode) {
    this.startInjecting(language)
        .addPlace(null, null, node, node.injectRange)
        .doneInjecting()
}