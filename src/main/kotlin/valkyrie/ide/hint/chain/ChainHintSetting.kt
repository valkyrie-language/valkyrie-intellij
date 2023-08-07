@file:Suppress("PropertyName")

package valkyrie.ide.hint.chain

import com.intellij.codeInsight.hints.ImmediateConfigurable.Case
import valkyrie.settings.inlayOption

data class ChainHintSetting(
    var show_obvious: Boolean = false,
    var show_dot_loop: Boolean = true,
    var show_dot_match: Boolean = true,
    var show_dot_catch: Boolean = true,
    var show_future: Boolean = true,
    var show_iterator: Boolean = true,
    var show_generator: Boolean = true,
    var show_coroutine: Boolean = true,
) {
    fun buildOptions(): List<Case> {
        return listOf(
            inlayOption("chain.obvious", this::show_obvious),
//            inlayOption("chain.loop", this::show_dot_loop),
//            inlayOption("chain.match", this::show_dot_match),
//            inlayOption("chain.catch", this::show_dot_catch),
//            inlayOption("chain.future", this::show_future),
//            inlayOption("chain.iterator", this::show_iterator),
//            inlayOption("chain.generator", this::show_generator),
//            inlayOption("chain.coroutine", this::show_coroutine),
        )
    }
}