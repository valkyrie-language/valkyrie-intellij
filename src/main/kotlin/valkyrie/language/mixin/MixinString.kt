package valkyrie.language.mixin

import valkyrie.ide.matcher.escaper.LiteralNoEscape
import valkyrie.language.ast.ValkyrieASTBase
import valkyrie.language.psi.ValkyrieTypes
import valkyrie.language.psi.childrenWithLeaves
import valkyrie.language.psi.endOffset
import valkyrie.language.psi.startOffset
import valkyrie.language.psi_node.ValkyrieIdentifierNode
import valkyrie.language.psi_node.ValkyrieStringNode
import com.intellij.json.json5.Json5Language
import com.intellij.lang.ASTNode
import com.intellij.lang.Language
import com.intellij.lang.injection.MultiHostRegistrar
import com.intellij.openapi.util.TextRange
import com.intellij.psi.LiteralTextEscaper
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiLanguageInjectionHost
import com.intellij.psi.util.elementType
import org.intellij.lang.regexp.RegExpLanguage

// PsiReference
open class MixinString(node: ASTNode) : ValkyrieASTBase(node), PsiLanguageInjectionHost {
    override fun getOriginalElement(): ValkyrieStringNode {
        return this as ValkyrieStringNode
    }

    fun stringStartOffset(): Int {
        return stringTextRaw().startOffset
    }

    fun stringEndOffset(): Int {
        return stringTextRaw().endOffset
    }


    fun stringTextRaw(): PsiElement {
        return this.childrenWithLeaves.last {
            it.elementType == ValkyrieTypes.STRING_TEXT
        }
    }

    val injectLanguage: String
        get() {
            val identifier = originalElement.identifier as? ValkyrieIdentifierNode ?: return ""
            return identifier.name
        }

    val injectRange: TextRange
        get() {
            return stringTextRaw().textRangeInParent
        }

    override fun isValidHost(): Boolean = true

    override fun updateText(text: String): PsiLanguageInjectionHost {
        return this
    }

    override fun createLiteralTextEscaper(): LiteralTextEscaper<out PsiLanguageInjectionHost> {
        return when (injectLanguage) {
            else -> LiteralNoEscape(originalElement)
        }
    }


}

