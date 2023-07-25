@file:Suppress("PropertyName")
package valkyrie.ide.hint.chain

data class ChainHintSetting(
    var show_obvious: Boolean = false,
    // .for i j { } ^
    var show_future: Boolean = true,
    var show_iterator: Boolean = true,
    var show_generator: Boolean = true,
    var show_coroutine: Boolean = true,
    var show_dot_for: Boolean = true,
    var show_dot_match: Boolean = true,
    var show_dot_catch: Boolean = true,

    )