package valkyrie.ide.hint.lambda

@Suppress("PropertyName")
data class LambdaHintSetting(
    var show_obvious_type: Boolean = false,
    var showForLoopType: Boolean = true,
    var showDefineParameterType: Boolean = true,
    var showDefineReturnType: Boolean = true,
    var showDefineEffectType: Boolean = true,
    var showClassFieldType: Boolean = true,
    var showBitFlagType: Boolean = true,
    var showEnumerationType: Boolean = true,
)