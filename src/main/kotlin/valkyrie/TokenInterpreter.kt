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
    | \b(is|not)\b
    | \b(type|class)\b
    | \b(variant|bitflag)\b
    | \b(trait)\b
    | \b(extend|extends)\b
    | \b(let|def)\b
    | \b(object)\b
    | \b(match|with|case|when)\b
    | \b(try|catch)\b
    | \b(raise|continue|return|resume)\b
    | \b(yield|break)\b
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
    | ∷ | :: | :> | :
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
    | ⊻=? | ⊼=? | ⊽=?
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
    | (?<s3>/[*])(?<t3>[^\00]*?)(?<e3>/[*])
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

    fun interpreter(): Array<StackItem> {
        while (startOffset < endOffset) {
            if (matchesWhitespace()) continue
            if (codeComment()) continue
            if (codeString()) continue
            if (codeNumber()) continue
            if (codePunctuations()) continue
            if (codeKeywords()) continue
            if (codeIdentifier()) continue
            break
        }
        checkRest()
        return stack.toTypedArray()
    }

    private fun matchesWhitespace(): Boolean {
        val r = tryMatch("\\s+".toRegex()) ?: return false
        pushToken(TokenType.WHITE_SPACE, r)
        return true
    }

    private fun codeComment(): Boolean {
        val r = tryMatch(comments) ?: return false
        pushToken(ValkyrieTypes.COMMENT, r)
        return true
    }

    private fun codeString(): Boolean {
        val r = tryMatch(strings) ?: return false
        val slots = arrayOf(
            arrayOf("s1", "t1", "e1"),
            arrayOf("s2", "t2", "e2"),
            arrayOf("s3", "t3", "e3"),
        )
        for (slot in slots) {
            val start = r.groups[slot[0]]
            val text = r.groups[slot[1]]
            val end = r.groups[slot[2]]
            if (text != null) {
                pushToken(ValkyrieTypes.STRING_START, start!!)
                pushToken(ValkyrieTypes.STRING_TEXT, text)
                pushToken(ValkyrieTypes.STRING_END, end!!)
                break
            }

        }
        return true
    }

    private fun codeNumber(): Boolean {
        val r = tryMatch(numbers) ?: return false
        when {
            r.groups["s1"] != null -> {
                pushToken(ValkyrieTypes.DECIMAL, r)
            }

            r.groups["s2"] != null -> {
                pushToken(ValkyrieTypes.DECIMAL, r)
            }

            r.groups["s3"] != null -> {
                pushToken(ValkyrieTypes.INTEGER, r)
            }

            r.groups["s4"] != null -> {
                pushToken(ValkyrieTypes.BYTE, r)
            }

            r.groups["s5"] != null -> {
                pushToken(ValkyrieTypes.COLOUR, r)
            }
        }
        return true
    }

    private fun codeKeywords(): Boolean {
        val r = tryMatch(keywordSP) ?: return false
        when (r.value) {
            "namespace", "namespace!", "namespace*", "namespace?" -> pushToken(ValkyrieTypes.KW_NAMESPACE, r)
            "using", "using!", "using*", "using?" -> pushToken(ValkyrieTypes.KW_IMPORT, r)
            "as", "as?", "as!", "as*" -> pushToken(ValkyrieTypes.OP_AS, r)
            "is" -> pushToken(ValkyrieTypes.OP_IS_A, r)
            "in" -> pushToken(ValkyrieTypes.OP_IN, r)
            "not" -> pushToken(ValkyrieTypes.OP_NOT, r)
            "which" -> pushToken(ValkyrieTypes.KW_WHICH, r)
            "if" -> pushToken(ValkyrieTypes.KW_IF, r)
            "else" -> pushToken(ValkyrieTypes.KW_ELSE, r)

            "loop" -> pushToken(ValkyrieTypes.KW_LOOP, r)
            "while" -> pushToken(ValkyrieTypes.KW_WHILE, r)
            "for" -> pushToken(ValkyrieTypes.KW_FOR, r)

            "match" -> pushToken(ValkyrieTypes.KW_MATCH, r)
            "when" -> pushToken(ValkyrieTypes.KW_WHEN, r)
            "case" -> pushToken(ValkyrieTypes.KW_CASE, r)
            "with" -> pushToken(ValkyrieTypes.KW_WITH, r)

            "let" -> pushToken(ValkyrieTypes.KW_LET, r)
            "def" -> pushToken(ValkyrieTypes.KW_DEF, r)

            "try" -> pushToken(ValkyrieTypes.KW_TRY, r)
            "catch" -> pushToken(ValkyrieTypes.KW_CATCH, r)
            "continue" -> pushToken(ValkyrieTypes.KW_CONTINUE, r)
            "return" -> pushToken(ValkyrieTypes.KW_RETURN, r)
            "resume" -> pushToken(ValkyrieTypes.KW_RESUME, r)
            "raise" -> pushToken(ValkyrieTypes.KW_RAISE, r)
            "yield" -> pushToken(ValkyrieTypes.KW_YIELD, r)
            "break" -> pushToken(ValkyrieTypes.KW_BREAK, r)
            "type" -> pushToken(ValkyrieTypes.KW_TYPE, r)

            "class", "structure", "struct" -> pushToken(ValkyrieTypes.KW_CLASS, r)
            "union", "tagged", "enum", "variant" -> pushToken(ValkyrieTypes.KW_TAGGED, r)
            "trait", "interface", "convention", "protocol" -> pushToken(ValkyrieTypes.KW_TRAIT, r)
            "bitset", "bitflag" -> pushToken(ValkyrieTypes.KW_BITFLAG, r)
            "extend", "extends", "impl", "implements" -> pushToken(ValkyrieTypes.KW_EXTENDS, r)

            "new", "object" -> pushToken(ValkyrieTypes.KW_NEW, r)

            else -> pushToken(TokenType.BAD_CHARACTER, r)
        }
        return true
    }

    private fun codeIdentifier(): Boolean {
        val xid = """(?x)
        [\p{L}_][\p{L}_\d]*
        | (`)((?:[^`\\]|\\.)*)(\1)
        """.toRegex()
        val r = tryMatch(xid) ?: return false
        when {
            lastIs(ValkyrieTypes.INTEGER, ValkyrieTypes.DECIMAL, skipWS = false) -> {
                pushToken(ValkyrieTypes.NUMBER_SUFFIX, r)
            }

            else -> {
                pushToken(ValkyrieTypes.SYMBOL_XID, r)
            }
        }

        return true
    }

    private fun codePunctuations(): Boolean {
        val r = tryMatch(punctuations) ?: return false
        when (r.value) {
            "\\" -> pushToken(ValkyrieTypes.KW_ESCAPING, r)
            // DOT
            ":=", "≔" -> pushToken(ValkyrieTypes.OP_BIND, r)
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
            pushToken(ValkyrieTypes.COMMENT, startOffset, endOffset)
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

private fun TokenInterpreter.resetToken(token: IElementType) {
    for (item in stack.asReversed()) {
        when {
            item.canSkip() -> continue
            else -> {
                item.token = token
                break
            }
        }
    }
}

private fun TokenInterpreter.resetContext(context: LexerContext) {
    contextStack.removeLastOrNull()
    contextStack.add(context)
}

private fun TokenInterpreter.enterContext(context: LexerContext) {
    contextStack.add(context)
}

private fun TokenInterpreter.endContext() {
    contextStack.removeLastOrNull()
}

private fun TokenInterpreter.contextIs(vararg check: LexerContext): Boolean {
    for (c in check) {
        if (context == c) {
            return true
        }
    }
    return false
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

private fun TokenInterpreter.lastNot(vararg token: IElementType, skipWS: Boolean = true): Boolean {
    for (item in stack.reversed()) {
        if (item.tokenIs(TokenType.WHITE_SPACE, ValkyrieTypes.COMMENT)) {
            when {
                skipWS -> continue
                else -> return false
            }
        }
        if (item.tokenIs(*token)) return false
    }
    return true
}
