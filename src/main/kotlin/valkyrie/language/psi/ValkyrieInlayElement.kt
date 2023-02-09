package valkyrie.language.psi

import valkyrie.ide.hint.ParameterInlayHint
import valkyrie.ide.hint.TypeInlayHint

@Suppress("UnstableApiUsage", "FunctionName")
interface ValkyrieInlayElement {
    fun type_hint(inlay: TypeInlayHint): Boolean {
        return false
    }

    fun parameter_hint(inlay: ParameterInlayHint): Boolean {
        return false
    }
}