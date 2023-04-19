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
COMMENT_LINE       = (⍝|[\\]{2})[^\r\n]*
COMMENT_BLOCK      = [/][*][^*]*[*]+([^/*][^*]*[*]+)*[/]
TEXT_SINGLE        = '([^'])*'
TEXT_DOUBLE        = \"([^\"]|\\.)*\"

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
KW_EXTENDS   = imply|impliments?|extends?
KW_TEMPLATE  = template|generic|constraint
KW_IMPLEMENT = implement
KW_FUNCTION  = macro|micro|function|func|fun|fn|def
KW_LET       = let|val|var
KW_NEW       = new
KW_OBJECT    = object
KW_LAMBDA    = lambda

KW_TRY   = try[!?]?
KW_MATCH = match|catch
KW_WITH  = with
KW_CASE  = case
KW_WHEN  = when

KW_WHILE     = while|until
KW_FOR       = for
KW_IN        = in
KW_IF        = if
KW_ELSE      = else
KW_OTHERWISE = otherwise
KW_IS        = is
KW_NOT       = not

KW_RETURN   = return
KW_RESUME   = resume
KW_YIELD    = yield
KW_BREAK    = break
KW_CONTINUE = continue
KW_THROUGH  = fallthrough
KW_RAISE    = raise

KW_NIL   = nil|∅
KW_NULL  = null
KW_TRUE  = true
KW_FALSE = false


STAR         = \*
COLON        = :|∶
PROPORTION   = ∷|::




OP_BANG      = [!]
OP_AND_THEN  = [?]
OP_PLUS      = [+]
OP_DIV       = [/⁄∕]
OP_MINUS     = [-]
OP_UNTIL     = [.]{2}[<=]

// equal
OP_EQ  = ==
OP_NE  = ≠|\!=
OP_EEE = ≡|===
OP_NEE = ≢|\!==|=\!=
// compare
OP_LEQ = ⩽|≤|<=
OP_LLE = <<=
OP_LLL = ⋘
OP_LL = ≪
OP_GEQ = ⩾|≥|>=
OP_GGE = >>=
OP_GGG = ⋙
// arrow
OP_ARROW1 = ⟶|->
OP_ARROW2 = ⇒|=>
OP_ARROW3 = ==>

SYMBOL=[\p{XID_Start}_][\p{XID_Continue}]*
SYMBOW_RAW = `[^`]*`
ESCAPED = \\.

BIN = [0-1]
DEC = [0-9]
HEX = [0-9a-fA-F]
COLOR = [©®][0-9a-zA-Z]*
INTEGER = 0|[1-9][_0-9]*

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

    {OP_ARROW1} { return OP_ARROW1; }
    \| { return OP_OR;}

	@ { return AT; }
	# { return HASH; }
	\$ { return DOLLAR; }

	{OP_DIV} { return OP_DIV; }
	"." { return DOT; }
	"," { return COMMA; }

	"="     { return EQUAL; }
    {OP_EQ} { return OP_EQ;}
    {OP_NE} { return OP_NE; }

    {OP_PLUS}     { return OP_PLUS; }
    {OP_MINUS}    { return OP_MINUS; }
    {OP_BANG}     { return OP_BANG; }
    {OP_AND_THEN} { return OP_AND_THEN; }
    {OP_UNTIL}    { return OP_UNTIL; }
}

<YYINITIAL> {
    {COLOR}       { return COLOR; }
    {INTEGER}     { return INTEGER; }
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
    {KW_UNION}     { return KW_UNION; }
    {KW_CLASS}     { return KW_CLASS; }
    {KW_TRAIT}     { return KW_TRAIT; }
    {KW_EXTENDS}   { return KW_IMPLY; }
    {KW_FUNCTION}  { return KW_FUNCTION; }
    {KW_LET}       { return KW_LET; }
    {KW_NEW}       { return KW_NEW; }
    {KW_OBJECT}    { return KW_OBJECT; }
    {KW_LAMBDA}    { return KW_LAMBDA; }

    {KW_IF}        { return KW_IF; }
    {KW_ELSE}      { return KW_ELSE; }
    {KW_OTHERWISE} { return KW_OTHERWISE; }
    {KW_WHILE}     { return KW_WHILE; }
    {KW_FOR}       { return KW_FOR; }
    {KW_IN}        { return KW_IN; }

    {KW_RETURN}   { return KW_RETURN; }
    {KW_RESUME}   { return KW_RESUME; }
    {KW_YIELD}    { return KW_YIELD; }
    {KW_BREAK}    { return KW_BREAK; }
    {KW_CONTINUE} { return KW_CONTINUE; }
    {KW_THROUGH}  { return KW_THROUGH; }
    {KW_RAISE}    { return KW_RAISE; }

    {KW_TRY}   { return KW_TRY; }
    {KW_MATCH} { return KW_MATCH; }
    {KW_WITH}  { return KW_WITH; }
    {KW_WHEN}  { return KW_WHEN; }
    {KW_CASE}  { return KW_CASE; }


    {KW_NULL}    { return KW_NULL; }
    {KW_NIL}     { return KW_NIL; }
    {KW_TRUE}    { return KW_TRUE; }
    {KW_FALSE}   { return KW_FALSE; }
    {KW_IS}      { return KW_IS; }
    {KW_NOT}     { return KW_NOT; }
    {SYMBOW_RAW} { return SYMBOW_RAW; }
    {SYMBOL}     { return SYMBOL; }
}
// =====================================================================================================================
[^] { return BAD_CHARACTER; }
