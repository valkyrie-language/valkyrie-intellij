package valkyrie.ide.hint.lambda

import com.intellij.codeInsight.hints.ImmediateConfigurable.Case
import valkyrie.settings.inlayOption

@Suppress("PropertyName")
data class LambdaHintSetting(
    var show_obvious_type: Boolean = false,
) {
    fun buildOptions(): List<Case> {
        return listOf(
            inlayOption("lambda.obvious", this::show_obvious_type),
        )
    }
}