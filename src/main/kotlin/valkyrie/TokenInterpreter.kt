@file:OptIn(ExperimentalStdlibApi::class)

package valkyrie

import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import valkyrie.language.lexer.LexerContext
import valkyrie.language.lexer.LexerContext.Coding
import valkyrie.language.lexer.StackItem
import valkyrie.language.psi.ValkyrieTypes

/**
 * keywords in any case, except for macros
 */
private val keywordSP = """(?x)
      \b(namespace|using|as)\b[*!?]?
    | \b(extension)\b
    | \b(if|else|which)\b
    | \b(for|in)\b | \b(while|loop)\b
    | \b(is|not|and|or)\b
    | \b(type|class)\b
    | \b(variant|bitflag)\b
    | \b(trait)\b
    | \b(extend|extends)\b
    | \b(let|def)\b
    | \b(object)\b
    | \b(match|with|case|when)\b
    """.toRegex()
private val punctuations = """(?x)\\
    | [.]{2}[=<]
    | [.]{1,3}
    | [{}\[\]()]
    | [,;$§¶^]
    | @[*!?@]?
    | \#[!]?
    # start with <, >
    | >{1,3} | >= | /> | ≥ | ⩾ | ≫
    | <{1,3} | <= | </ | ≤ | ⩽ | <: | <! 
    # start with :
    | ∷ | :: | :> | := | ≔ | :
    # start with -
    | -= | -> | ⟶ | -{1,2}
    # start with ~
    | ~> | ~
    # start with +
    | [+]= | [+]> | [+]{1,2}
    # start with *
    | [*]=?
    # start with / or % or ÷
    | /=?
    | ÷=?
    | %=?
    # start with &
    | &> | &{1,2} | ≻
    | [|]> | [|]{1,2} | ⊁
    | ⊻=? | ⊼=? | ⊽=? | [⩕⩖]
    # start with !
    | != | ≠ | !
    # start with ?
    | [?]{3} | [?]
    # start with =
    | => | ⇒
    | === | == | =
    # unicode
    | [∈∊∉⊑⋢⨳∀∁∂∃∄¬±√∛∜⊹⋗]
    | [⟦⟧⁅⁆⟬⟭]
    | [℃℉]
    | [↻↺⇆↹⇄⇋⇌⇅]
    #
    """.toRegex()
private val comments = """(?x)
      (?<s2>//)(?<t2>[^\n\r]*)  
    | (?<s3>/[*])(?<t3>[^\00]*?)(?<e3>[*]/)
    """.toRegex()
private val strings = """(?x)
      (?<s1>"{3,}|'{3,})(?<t1>[^\00]*?)(?<e1>\k<s1>)
    | (?<s2>')(?<t2>[^']*)(?<e2>')
    | (?<s3>")(?<t3>[^"]*)(?<e3>")
    """.toRegex()
private val numbers = """(?x)
      (?<s1>[_1-9][_\d]*[.][_\d]+)
    | (?<s2>0[.][_\d]+)
    | (?<s4>0[a-zA-Z][_\da-zA-Z]+)
    | (?<s3>0|[1-9][_\d]*)
    | (?<s5>[©®][0-9a-zA-Z]*)
""".toRegex()

@Suppress("MemberVisibilityCanBePrivate")
class TokenInterpreter(val buffer: CharSequence, var startOffset: Int, val endOffset: Int) {
    var stack: MutableList<StackItem> = mutableListOf()

    var contextStack: MutableList<LexerContext> = mutableListOf()

    val context: LexerContext
        get() = contextStack.lastOrNull() ?: Coding


    private fun codePunctuations(): Boolean {
        val r = tryMatch(punctuations) ?: return false
        when (r.value) {
            "\\" -> pushToken(ValkyrieTypes.KW_ESCAPING, r)
            // DOT
            ":=", "≔" -> pushToken(ValkyrieTypes.PATTERN_SET, r)
            "->", "⟶" -> pushToken(ValkyrieTypes.OP_ARROW, r)
            "=>", "⇒" -> pushToken(ValkyrieTypes.OP_ARROW2, r)
            "==", "≡" -> pushToken(ValkyrieTypes.OP_EQ, r)
            "=" -> pushToken(ValkyrieTypes.OP_SET, r)
            "." -> {
                pushToken(ValkyrieTypes.DOT, r)
            }

            ":", "∶" -> {
                pushToken(ValkyrieTypes.COLON, r)
            }

            "::", "∷" -> {
                pushToken(ValkyrieTypes.OP_PROPORTION, r)
            }

            "..<", "..=" -> pushToken(ValkyrieTypes.OP_UNTIL, r)
            "...", ".." -> pushToken(ValkyrieTypes.KW_DOTS, r)

            ";" -> {
                pushToken(ValkyrieTypes.SEMICOLON, r)
            }


            "@" -> pushToken(ValkyrieTypes.OP_AT, r)
            "#" -> pushToken(ValkyrieTypes.OP_HASH, r)
            "," -> pushToken(ValkyrieTypes.COMMA, r)
            // start with +
            "++" -> pushToken(ValkyrieTypes.OP_INC, r)
            "+=" -> pushToken(ValkyrieTypes.OP_ADD_ASSIGN, r)
            "+" -> pushToken(ValkyrieTypes.OP_ADD, r)
            // start with -
            "--" -> pushToken(ValkyrieTypes.OP_DEC, r)
            "-=" -> pushToken(ValkyrieTypes.OP_SUB_ASSIGN, r)
            "-" -> pushToken(ValkyrieTypes.OP_SUB, r)
            // start with *
            "*=" -> pushToken(ValkyrieTypes.OP_MUL_ASSIGN, r)
            "*" -> pushToken(ValkyrieTypes.OP_MUL, r)
            // start with /
            "/=" -> pushToken(ValkyrieTypes.OP_DIV_ASSIGN, r)
            "/" -> pushToken(ValkyrieTypes.OP_DIV, r)
            // start with &
            "&&=" -> pushToken(ValkyrieTypes.OP_AND_ASSIGN, r)
            "&&" -> pushToken(ValkyrieTypes.OP_AND2, r)
            "&=" -> pushToken(ValkyrieTypes.OP_AND_ASSIGN, r)
            "&" -> pushToken(ValkyrieTypes.OP_AND, r)
            //
            // start with !
            "!!" -> pushToken(ValkyrieTypes.OP_NE, r)
            "!=" -> pushToken(ValkyrieTypes.OP_NE, r)
            "!" -> pushToken(ValkyrieTypes.OP_NOT, r)
            "|" -> pushToken(ValkyrieTypes.OP_OR, r)
            // start with ?
            "???" -> pushToken(ValkyrieTypes.OP_UNIMPLEMENTED, r)
            "?" -> pushToken(ValkyrieTypes.OP_QUESTION, r)
            // start with ^
            "^" -> pushToken(ValkyrieTypes.OP_POW, r)
            // start with =
            "∈", "∊" -> {
                pushToken(ValkyrieTypes.OP_IN, r)
            }

            "∉" -> {
                pushToken(ValkyrieTypes.OP_NOT_IN, r)
            }
            // slots
            "$" -> pushToken(ValkyrieTypes.SLOT_LAMBDA, r)
            "§" -> pushToken(ValkyrieTypes.SLOT_MACRO, r)
            "¶" -> pushToken(ValkyrieTypes.OP_QUOTE, r)
            "⟦" -> {
                pushToken(ValkyrieTypes.SLICE_L, r)
            }

            "⟧" -> {
                pushToken(ValkyrieTypes.SLICE_R, r)
            }
            // start with >
            ">>>", "⋙" -> pushToken(ValkyrieTypes.OP_GGG, r)
            ">>", "≫" -> pushToken(ValkyrieTypes.OP_GG, r)
            ">=", "≥", "⩾" -> pushToken(ValkyrieTypes.OP_GEQ, r)
            "/>" -> {
                pushToken(ValkyrieTypes.OP_GS, r)
            }

            ">" -> pushToken(ValkyrieTypes.OP_GT, r)
            // start with <
            "<<<", "⋘" -> pushToken(ValkyrieTypes.OP_LLL, r)
            "<<", "≪" -> pushToken(ValkyrieTypes.OP_LL, r)
            "<=", "≤", "⩽" -> pushToken(ValkyrieTypes.OP_LEQ, r)
            "</" -> {
                pushToken(ValkyrieTypes.OP_LS, r)
            }
            "⩕" -> {
                pushToken(ValkyrieTypes.PATTERN_AND, r)
            }
            "⩖" -> {
                pushToken(ValkyrieTypes.PATTERN_OR, r)
            }


            "<:", "⊑" -> {
                pushToken(ValkyrieTypes.OP_IS_A, r)
            }

            "<!", "⋢" -> {
                pushToken(ValkyrieTypes.OP_NOT_A, r)
            }

            "<" -> pushToken(ValkyrieTypes.OP_LT, r)
            // surround with ( )
            "(" -> {
                pushToken(ValkyrieTypes.PARENTHESIS_L, r)
            }

            ")" -> {
                pushToken(ValkyrieTypes.PARENTHESIS_R, r)
            }

            "[" -> {
                pushToken(ValkyrieTypes.BRACKET_L, r)
            }

            "]" -> {
                pushToken(ValkyrieTypes.BRACKET_R, r)
            }

            "{" -> {
                pushToken(ValkyrieTypes.BRACE_L, r)
            }

            "}" -> {
                pushToken(ValkyrieTypes.BRACE_R, r)
            }

            "∅", "⤇", "|=>", "⤃", "!=>" -> {
                pushToken(ValkyrieTypes.OP_EMPTY, r)
            }

            "℃", "℉" -> {
                pushToken(ValkyrieTypes.OP_TEMPERATURE, r)
            }

            else -> pushToken(TokenType.BAD_CHARACTER, r)
        }
        return true
    }

    private fun checkRest() {
        if (startOffset < endOffset) {
            pushToken(ValkyrieTypes.COMMENT_BLOCK, startOffset, endOffset)
        }
    }

    private fun tryMatch(pattern: Regex): MatchResult? {
        val r = pattern.matchAt(buffer, startOffset)
        return when {
            r == null -> null
            r.value.isEmpty() -> null
            else -> r
        }
    }

    fun pushToken(token: IElementType, startOffset: Int, endOffset: Int): Boolean {
        stack.add(StackItem(token, startOffset, endOffset, context))
        this.startOffset = endOffset + 1
        return true
    }

    fun pushToken(token: IElementType, match: MatchResult): Boolean {
        stack.add(StackItem(token, match.range.first, match.range.last + 1, context))
        startOffset = match.range.last + 1
        return true
    }

    fun pushToken(token: IElementType, match: MatchGroup): Boolean {
        stack.add(StackItem(token, match.range.first, match.range.last + 1, context))
        startOffset = match.range.last + 1
        return true
    }
}




private fun TokenInterpreter.lastIs(vararg token: IElementType, skipWS: Boolean = true): Boolean {
    for (item in stack.reversed()) {
        if (item.canSkip()) {
            when {
                skipWS -> continue
                else -> return false
            }
        }
        if (item.tokenIs(*token)) return true
    }
    return false
}

