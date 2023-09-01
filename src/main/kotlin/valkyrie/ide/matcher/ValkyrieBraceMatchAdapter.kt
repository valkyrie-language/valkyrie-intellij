package valkyrie.ide.matcher


import com.intellij.psi.TokenType
import com.intellij.psi.tree.ParentAwareTokenSet
import valkyrie.psi.ValkyrieTypes

private val TYPE_TOKENS: ParentAwareTokenSet = ParentAwareTokenSet.orSet(
    ParentAwareTokenSet.create(
        TokenType.WHITE_SPACE
    ),
    ParentAwareTokenSet.create(
        ValkyrieTypes.COMMENT_LINE
    ),
    ParentAwareTokenSet.create(
        ValkyrieTypes.SYMBOL, ValkyrieTypes.SYMBOW_RAW,
        ValkyrieTypes.COMMA,
        ValkyrieTypes.BRACE_L, ValkyrieTypes.BRACE_R,
//        JavaTokenType.QUEST, JavaTokenType.EXTENDS_KEYWORD, JavaTokenType.SUPER_KEYWORD
    )
)

//class ValkyrieBraceMatchAdapter : PairedBraceAndAnglesMatcher {
//    constructor() : super(ValkyrieBraceMatch(), ValkyrieLanguage, ValkyrieFileType, TYPE_TOKENS)
//
//    override fun lt(): IElementType {
//        return ValkyrieTypes.ANGLE_L
//    }
//
//    override fun gt(): IElementType {
//        return ValkyrieTypes.ANGLE_R
//    }
//}
