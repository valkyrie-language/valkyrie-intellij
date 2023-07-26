package valkyrie.ide.completion

import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.icons.AllIcons
import com.intellij.icons.ExpUiIcons
import valkyrie.language.ValkyrieBundle

open class ValkyrieCompletionProvider(val parameters: CompletionParameters, val result: CompletionResultSet) {

    protected fun addClasses() {
        createClass("class", mutableSetOf("class"), ValkyrieBundle.message("completion.class"))
        createClass("structure", mutableSetOf("value-class", "data-class"), ValkyrieBundle.message("completion.class"))
        createClass("abstract class", mutableSetOf("interface"), ValkyrieBundle.message("completion.class"))
        createClass("virtual class", mutableSetOf("virtual"), ValkyrieBundle.message("completion.class"))
        createClass("singleton", mutableSetOf("static-class", "companion-object"), ValkyrieBundle.message("completion.class"))
        createClass("widget", mutableSetOf("component-class"), ValkyrieBundle.message("completion.class"))
        createClass("neural-network", mutableSetOf("neural", "network", "layer"), ValkyrieBundle.message("completion.class"))
    }

    protected fun addFunctions() {
        for (arguments in 0..3) {
            createNormalFunction(
                "function$arguments",
                mutableSetOf("fn$arguments"),
                ValkyrieBundle.message("completion.method.unit", arguments)
            )
            createNormalFunction(
                "function$arguments?",
                mutableSetOf("ff$arguments?"),
                ValkyrieBundle.message("completion.method.result", arguments)
            )
        }
    }

    protected fun addControls() {
        createKeywordControl(
            "yield-send",
            mutableSetOf("yield", "yield-continue", "yield-then", "yield-return"),
            ValkyrieBundle.message("completion.control.yield.send")
        )
        createNormalFunction(
            "yield-from",
            mutableSetOf(),
            ValkyrieBundle.message("completion.control.yield.from")
        )
        createNormalFunction(
            "yield-stop",
            mutableSetOf("yield-break"),
            ValkyrieBundle.message("completion.control.yield.stop")
        )
    }

    protected fun addMethods() {
        for (arguments in 0..3) {
            createNormalMethod("method$arguments", mutableSetOf("fn$arguments"), ValkyrieBundle.message("completion.method.unit", arguments))
            createNormalMethod("method$arguments?", mutableSetOf("ff$arguments"), ValkyrieBundle.message("completion.method.result", arguments))
        }
    }

    protected fun addGetSet() {
        createProperty("getter", mutableSetOf("getter", "gg"), ValkyrieBundle.message("completion.getter"))
        createProperty("setter", mutableSetOf("setter", "ss"), ValkyrieBundle.message("completion.setter"))
        createProperty("get-set", mutableSetOf("get-set", "getset", "gs"), ValkyrieBundle.message("completion.get-set"))
    }

    protected fun addConstructor() {
        createKeywordMethod("constructor", mutableSetOf("ctor"), ValkyrieBundle.message("completion.constructor"))
        createKeywordMethod("constructor?", mutableSetOf("ctrr"), ValkyrieBundle.message("completion.constructor.result"))
        createKeywordMethod("destructor", mutableSetOf("dtor"), ValkyrieBundle.message("completion.constructor"))
        createKeywordMethod("invoker", mutableSetOf("apply"), ValkyrieBundle.message("completion.constructor"))
        createKeywordMethod("extractor", mutableSetOf("unapply"), ValkyrieBundle.message("completion.constructor"))


        createOperatorMethod("plus", mutableSetOf("add", "+"), ValkyrieBundle.message("completion.constructor"))
        createOperatorMethod("plus-assign", mutableSetOf("add=", "+="), ValkyrieBundle.message("completion.constructor"))
        createOperatorMethod("offset-index", mutableSetOf("off"), ValkyrieBundle.message("completion.constructor"))
        createOperatorMethod("ordinal-index", mutableSetOf("ord"), ValkyrieBundle.message("completion.constructor"))
        createOperatorMethod("minus", mutableSetOf("sub"), ValkyrieBundle.message("completion.constructor"))
    }


    private fun createNormalFunction(key: String, word: MutableSet<String>, help: String) {
        val live = getLiveTemplate(key) ?: return
        live.setLookup(key, word)
        live.setIcon(AllIcons.Nodes.Function)
        live.setText(key, help)
        result.addElement(live)
    }

    private fun createClass(key: String, word: MutableSet<String>, help: String) {
        val live = getLiveTemplate(key) ?: return
        live.setLookup(key, word)
        live.setIcon(ExpUiIcons.Nodes.Class)
        live.setText(key, help)
        result.addElement(live)
    }


    private fun createKeywordControl(key: String, word: MutableSet<String>, help: String) {
        val live = getLiveTemplate(key) ?: return
        live.setLookup(key, word)
        live.setIcon(ExpUiIcons.Actions.Deploy)
        live.setText(key, help)
        result.addElement(live)
    }


    private fun createProperty(key: String, word: MutableSet<String>, help: String) {
        val live = getLiveTemplate(key) ?: return
        live.setLookup(key, word)
        live.setIcon(AllIcons.Nodes.Property)
        live.setText(key, help)
        result.addElement(live)
    }

    private fun createKeywordMethod(key: String, word: MutableSet<String>, help: String) {
        val live = getLiveTemplate(key) ?: return
        live.setLookup(key, word)
        live.setIcon(ExpUiIcons.Nodes.MethodReference)
        live.setText(key, help)
        result.addElement(live)
    }

    private fun createNormalMethod(key: String, word: MutableSet<String>, help: String) {
        val live = getLiveTemplate(key) ?: return
        live.setLookup(key, word)
        live.setIcon(ExpUiIcons.Nodes.Method)
        live.setText(key, help)
        result.addElement(live)
    }


    private fun createOperatorMethod(key: String, word: MutableSet<String>, help: String) {
        val live = getLiveTemplate(key) ?: return
        live.setLookup(key, word)
        live.setIcon(ExpUiIcons.Inline.Regex)
        live.setText(key, help)
        result.addElement(live)
    }

    private fun getLiveTemplate(key: String): ValkyrieLiveCompletionTemplate? {
        val template = ValkyrieLookupElement.getTemplate(key) ?: return null
        return ValkyrieLiveCompletionTemplate(template)
    }

}