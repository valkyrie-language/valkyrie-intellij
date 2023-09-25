package valkyrie.ide.matcher


import com.intellij.lang.LanguageUtil
import com.intellij.lang.injection.MultiHostInjector
import com.intellij.lang.injection.MultiHostRegistrar
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.util.endOffset
import com.intellij.psi.util.startOffset
import org.intellij.lang.regexp.RegExpLanguage
import org.intellij.plugins.markdown.lang.MarkdownLanguage
import org.toml.lang.TomlLanguage
import valkyrie.psi.mixin.MixinIdentifier
import valkyrie.psi.mixin.MixinString

import valkyrie.psi.node.ValkyrieString
import valkyrie.psi.node.ValkyrieStringNode
import valkyrie.psi.node.ValkyrieVisitor


class ValkyrieLanguageInjector : MultiHostInjector {
    override fun getLanguagesToInject(registrar: MultiHostRegistrar, context: PsiElement) {
        context.accept(LanguageInjectorVisitor(registrar))
    }

    override fun elementsToInjectIn(): MutableList<out Class<out PsiElement>> {
        return mutableListOf(MixinString::class.java)
    }
}

private class LanguageInjectorVisitor(val registrar: MultiHostRegistrar) : ValkyrieVisitor() {


    override fun visitString(o: ValkyrieString) {
        o as ValkyrieStringNode




        when (val id = (o.identifierSafe as? MixinIdentifier)?.name) {
            null -> {
//                DefaultInjectedLanguageBlockBuilder().createInjectedBlock()
            }

//            "json" -> {
//                val range = TextRange(o.stringHead.endOffset - o.startOffset, o.stringTail.startOffset - o.startOffset);
//                registrar.startInjecting(Json5Language.INSTANCE).addPlace(null, null, o, range).doneInjecting()
//            }
//
            "re" -> {
                val range = TextRange(o.stringHead.endOffset - o.startOffset, o.stringTail.startOffset - o.startOffset);
                registrar.startInjecting(RegExpLanguage.INSTANCE).addPlace(null, null, o, range).doneInjecting()
            }

            "regex" -> {
                val range = TextRange(o.stringHead.endOffset - o.startOffset, o.stringTail.startOffset - o.startOffset);
                registrar.startInjecting(RegExpLanguage.INSTANCE).addPlace("(?x)", null, o, range).doneInjecting()
            }

            else -> {
                val language = LanguageUtil.findRegisteredLanguage(id)
                if (language != null) {
                    val range = TextRange(o.stringHead.endOffset - o.startOffset, o.stringTail.startOffset - o.startOffset);
                    registrar.startInjecting(language).addPlace(null, null, o, range).doneInjecting()
                }
            }
        }
    }
}