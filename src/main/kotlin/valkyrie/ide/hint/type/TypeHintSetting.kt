package valkyrie.ide.hint.type

data class TypeHintSetting(
    var show_obvious_type: Boolean = false,
    var showForLoopType: Boolean = true,
    var showDefineParameterType: Boolean = true,
    var showDefineReturnType: Boolean = true,
    var showDefineEffectType: Boolean = true,
    var showClassFieldType: Boolean = true,
    var showBitFlagType: Boolean = true,
    var showEnumerationType: Boolean = true,
)