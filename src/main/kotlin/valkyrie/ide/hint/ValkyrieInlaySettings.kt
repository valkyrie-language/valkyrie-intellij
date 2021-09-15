package valkyrie.ide.hint

data class ValkyrieInlaySettings(
    var showBitFlagType : Boolean = true,
    var showForVariables: Boolean = true,
    var showForLambdas: Boolean = true,
    var showForIterators: Boolean = true,
    var showForPlaceholders: Boolean = true,
    var showObviousTypes: Boolean = false,
)