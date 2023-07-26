@file:Suppress("PropertyName")

package valkyrie.ide.hint.type

import com.intellij.codeInsight.hints.ImmediateConfigurable.Case
import valkyrie.settings.inlayOption

data class TypeHintSetting(
    var show_obvious_type: Boolean = false,
    var show_loop_each_types: Boolean = true,
    var show_define_parameter_type: Boolean = true,
    var show_define_return_type: Boolean = true,
    var show_define_effect_type: Boolean = true,
    var show_class_field_type: Boolean = true,
    var show_bitflags_type: Boolean = true,
    var show_enumeration_type: Boolean = true,
) {
    fun buildOptions(): List<Case> {
        return listOf(
            inlayOption("type.obvious", this::show_obvious_type),
            inlayOption("type.loop.each", this::show_loop_each_types),
            inlayOption("type.define.parameter", this::show_define_parameter_type),
            inlayOption("type.define.return", this::show_define_return_type),
            inlayOption("type.define.effect", this::show_define_effect_type),
            inlayOption("type.field", this::show_class_field_type),
            inlayOption("type.flags", this::show_bitflags_type),
            inlayOption("type.enums", this::show_enumeration_type),
        )
    }
}