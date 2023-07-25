@file:Suppress("PropertyName")

package valkyrie.ide.hint.type

data class TypeHintSetting(
    var show_obvious_type: Boolean = false,
    var showForLoopType: Boolean = true,
    var showDefineParameterType: Boolean = true,
    var show_define_return_type: Boolean = true,
    var showDefineEffectType: Boolean = true,
    var show_class_field_type: Boolean = true,
    var show_bitflags_type: Boolean = true,
    var show_enumeration_type: Boolean = true,
)