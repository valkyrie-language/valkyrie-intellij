package valkyrie.psi;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
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


SYMBOL=[\p{XID_Start}_][\p{XID_Continue}]*
SYMBOW_RAW = `[^`]*`
ESCAPED = \\.

KW_NAMESPACE = namespace[!?]?
KW_USING     = using[!?]?
KW_AS        = as[!?]?
KW_EXCLUDE   = exclude

KW_TYPE      = typus|type
KW_CLASS     = class|struct|structure|interface
KW_UNION     = union
KW_UNITE     = unite|inductive
KW_ENUMERATE = enumerate|enums?
KW_FLAGS     = flags
KW_TRAIT     = trait
KW_FUNCTION  = macro|micro|function|func|fun|fn|def
KW_IMPLY     = imply|impliments?|extends?

STAR         = \*
COLON        = :|∶
PROPORTION   = ∷|::

OP_BANG      = [!]
OP_AND_THEN  = [?]
OP_PLUS      = [+]
OP_MINUS     = [-]
%%

<YYINITIAL> {
    {WHITE_SPACE}+     { return WHITE_SPACE; }
	{COMMENT_LINE}     { return COMMENT_LINE; }
	{COMMENT_BLOCK}    { return COMMENT_BLOCK; }
}

   //RANGE_L:       '⟦';
   //RANGE_R:       '⟧';
   //CEILING_L:     '⌈';
   //CEILING_R:     '⌉';
   //FLOOR_L:       '⌊';
   //FLOOR_R:       '⌋';
   //COLLECTION_L:  '⦃';
   //COLLECTION_R:  '⦄';
<YYINITIAL> {
	"(" { return PARENTHESIS_L; }
    ")" { return PARENTHESIS_R; }
    "[" { return BRACKET_L; }
    "]" { return BRACKET_R; }
    "⁅" { return OFFSET_L; }
    "⁆" { return OFFSET_R; }
	"{" { return BRACE_L; }
	"}" { return BRACE_R; }
	"<" { return ANGLE_L; }
	">" { return ANGLE_R; }
    "⟨" { return GENERIC_L; }
    "⟩" { return GENERIC_R; }
}

<YYINITIAL> {
	; { return SEMICOLON; }

    {PROPORTION} { return PROPORTION; }
	{COLON}      { return COLON; }
    {STAR}       { return STAR; }

    -> { return OP_TO; }
    \| { return OP_OR;}
    \~ { return OP_CONCAT;}


	@ { return AT; }
	# { return HASH; }
	\$ { return DOLLAR; }

	"/" { return SLASH; }
	"." { return DOT; }
	"," { return COMMA; }

	"=" { return EQUAL; }

	"^" { return OP_REMARK; }
    {OP_PLUS}     { return OP_PLUS; }
    {OP_MINUS}    { return OP_MINUS; }
    {OP_BANG}     { return OP_BANG; }
    {OP_AND_THEN} { return OP_AND_THEN; }
}

<YYINITIAL> {
    {DEC}         { return INTEGER; }
    {TEXT_SINGLE} { return TEXT_SINGLE; }
    {TEXT_DOUBLE} { return TEXT_DOUBLE; }
}

<YYINITIAL> {
    {KW_NAMESPACE} { return KW_NAMESPACE; }
    {KW_USING}     { return KW_USING; }
    {KW_AS}        { return KW_AS; }
    {KW_EXCLUDE}   { return KW_EXCLUDE; }

    {KW_TYPE}      { return KW_TYPE; }
    {KW_FLAGS}     { return KW_FLAGS; }
    {KW_ENUMERATE} { return KW_ENUMERATE; }
    {KW_UNITE}     { return KW_UNITE; }
    {KW_UNITE}     { return KW_UNION; }
    {KW_CLASS}     { return KW_CLASS; }
    {KW_TRAIT}     { return KW_TRAIT; }
    {KW_IMPLY}     { return KW_IMPLY; }
    {KW_FUNCTION}  { return KW_FUNCTION; }

    {ESCAPED} { return ESCAPED; }
    {SYMBOW_RAW} { return SYMBOW_RAW; }
    {SYMBOL}  { return SYMBOL; }
}
// =====================================================================================================================
[^] { return BAD_CHARACTER; }
