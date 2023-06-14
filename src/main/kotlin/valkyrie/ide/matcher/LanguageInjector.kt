package valkyrie.ide.matcher


import com.intellij.json.json5.Json5Language
import com.intellij.lang.injection.MultiHostInjector
import com.intellij.lang.injection.MultiHostRegistrar
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import org.intellij.lang.regexp.RegExpLanguage
import valkyrie.psi.mixin.MixinString
import valkyrie.psi.node.ValkyrieIdentifierNode
import valkyrie.psi.node.ValkyrieString
import valkyrie.psi.node.ValkyrieStringNode
import valkyrie.psi.node.ValkyrieVisitor


class LanguageInjector : MultiHostInjector {
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




        when (val id = (o.identifier as? ValkyrieIdentifierNode)?.name) {
            null -> {

            }

            "json" -> {
                val range = TextRange(1, o.textLength - 1);
                registrar.startInjecting(Json5Language.INSTANCE).addPlace(null, null, o, range).doneInjecting()
            }

            "re" -> {
                val range = TextRange(1, o.textLength - 1);
                registrar.startInjecting(RegExpLanguage.INSTANCE).addPlace(null, null, o, range).doneInjecting()
            }

            "regex" -> {
                val range = TextRange(1, o.textLength - 1);
                registrar.startInjecting(RegExpLanguage.INSTANCE).addPlace("(?x)", null, o, range).doneInjecting()
            }
        }
    }
}