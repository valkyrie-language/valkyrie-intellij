package yggdrasil.psi;

import com.intellij.psi.search.scope.packageSet.lexer.ScopeTokenTypes;import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static valkyrie.psi.ValkyrieTypes.*;

%%

%public
%class _ValkyrieLexer
%implements com.intellij.lexer.FlexLexer
%function advance
%type com.intellij.psi.tree.IElementType
%unicode

//%state TextContextIndent

WHITE_SPACE        = [\s\t]
REGULAR_EXPRESSION = \/([^\/\\]|\\.)+\/
REGULAR_RANGE      = \[[^\]]*\]
COMMENT_LINE       = (⍝|[\\]{2})[^\r\n]*
COMMENT_BLOCK      = [/][*][^*]*[*]+([^/*][^*]*[*]+)*[/]
TEXT_SINGLE        = '([^'])*'
TEXT_DOUBLE        = \"([^\"]|\\.)*\"


BIN = [0-1]
DEC = [0-9]
HEX = [0-9a-fA-F]


SYMBOL=[\p{XID_Start}_][\p{XID_Continue}_]*
SYMBOW_RAW = `[^`]*`
ESCAPED = \\.

KW_NAMESPACE = namespace
KW_USING     = using
KW_AS        = as
KW_EXCLUDE   = exclude
KW_CLASS     = class|struct|structure
KW_UNION     = union
KW_UNITE     = unite|inductive
KW_ENUMERATE = enumerate|enums?
KW_FLAGS     = flags
KW_INTERFACE = interface|trait
KW_MACRO     = macro|function|func|fun|fn|def

%%

<YYINITIAL> {
    {WHITE_SPACE}+     { return WHITE_SPACE; }
	{COMMENT_LINE}     { return COMMENT_LINE; }
	{COMMENT_BLOCK}    { return COMMENT_BLOCK; }
}

<YYINITIAL> {
	"(" { return PARENTHESIS_L; }
    ")" { return PARENTHESIS_R; }
    "[" { return BRACKET_L; }
    "]" { return BRACKET_R; }
	"{" { return BRACE_L; }
	"}" { return BRACE_R; }
	"<" { return ANGLE_L; }
	">" { return ANGLE_R; }
    "->" { return TO; }
    "|" { return OP_OR;}
    "~" { return OP_CONCAT;}

	":" { return COLON; }
	";" { return SEMICOLON; }
	"#" { return HASH; }
	"$" { return DOLLAR; }
	"@" { return AT; }
	"/" { return SLASH; }
	"." { return DOT; }
	"," { return COMMA; }
	"-" { return HYPHEN; }
	"=" { return EQUAL; }

	"^" { return OP_REMARK; }
    "!" { return OP_NOT; }

    "?" { return OP_OPTIONAL; }
    "*" { return OP_MANY; }
    "+" { return OP_MANY1; }
}

<YYINITIAL> {
    {DEC} { return INTEGER; }
    {TEXT_SINGLE} { return TEXT_SINGLE; }
    {TEXT_DOUBLE} { return TEXT_DOUBLE; }
    {REGULAR_RANGE} { return REGULAR_RANGE; }
    {REGULAR_EXPRESSION} { return REGULAR_EXPRESSION;}
}

<YYINITIAL> {
    {KW_NAMESPACE} { return KW_NAMESPACE; }
    {KW_USING} { return KW_USING; }
    {KW_AS} { return KW_AS; }

    {KW_FLAGS} { return KW_FLAGS;}
    {KW_ENUMERATE} { return KW_ENUMERATE;}
    {KW_UNITE} { return KW_UNITE; }
    {KW_UNITE} { return KW_UNION; }

    {KW_CLASS} { return KW_CLASS; }
    {KW_INTERFACE} { return KW_INTERFACE; }

    {KW_MACRO} { return KW_MACRO; }

    {ESCAPED} { return ESCAPED; }
    {SYMBOW_RAW} { return SYMBOW_RAW; }
    {SYMBOL}  { return SYMBOL; }
}
// =====================================================================================================================
[^] { return BAD_CHARACTER; }
