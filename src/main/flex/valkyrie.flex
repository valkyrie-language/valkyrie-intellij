package valkyrie.psi;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static valkyrie.psi.ValkyrieTypes.*;
import java.util.LinkedList;
%%

%public
%class _ValkyrieLexer
%implements com.intellij.lexer.FlexLexer
%function advance
%type com.intellij.psi.tree.IElementType
%unicode
%{
    private final LinkedList<Integer> states = new LinkedList();

    private void yypushstate(int state) {
        states.addFirst(yystate());
        yybegin(state);
    }
    private void yypopstate() {
        final int state = states.removeFirst();
        yybegin(state);
    }
%}

%state CommentBlock
%state TextCapture6
%state TextCapture3
%state TextCapture2
%state TextCapture1
%state AfterNumber
%state AfterNumberBase
%state AfterNumberExp

%eof{
    return;
%eof}


WHITE_SPACE        = [\s\t]
COMMENT = [⍝#]
COMMENT_LINE       = {COMMENT}[^\r\n]*
ANGLE_L = [<⟨]
ANGLE_R = [>⟩]

COLON    = [:∶：]
STAR     = [*]
DOT      = [.。]
COMMA    = [,，]
BANG     = [!！]
QUESTION = [?？]
TEMPLATE_L = [<⟨][$][._\-~=]?
TEMPLATE_R = [$][>⟩][._\-~=]?
KW_NAMESPACE = namespace({BANG}|{QUESTION})?
KW_USING     = using({BANG}|{QUESTION})?
KW_AS        = as({BANG}|{QUESTION})?
KW_EXCLUDE   = exclude

KW_TYPE      = typus|type
KW_CLASS     = class|struct|structure|interface
KW_UNION     = union
KW_UNITE     = unity|unite|inductive|unity
KW_ENUMERATE = enums?|enumerate
KW_FLAGS     = flags
KW_TRAIT     = trait
KW_DEPENDS   = depends?|dependent|generic|constraint|forall|exists
KW_EXTENDS   = impls?|extends?
KW_WHERE     = where
KW_IMPLEMENT = implements?
KW_MICRO     = micro|function|func|fun|fn|def
KW_MEZZO     = mezzo
KW_MACRO     = macro|template
KW_SINGLETON = singleton
KW_COMPONENT = widget
KW_NEURAL    = neural
KW_LET       = let
KW_NEW       = new
KW_OBJECT    = object
KW_LAMBDA    = lambda

KW_TRY   = try[!?]?
KW_MATCH = match
KW_CATCH = catch
KW_WITH  = with
KW_CASE  = case
KW_WHEN  = when
KW_FROM  = from

KW_FOR   = for
KW_LOOP  = loop
KW_WHILE = while
KW_UNTIL = until
OP_LABEL = [※]|\\l
KW_EACH  = each
KW_END   = end
OP_END   = [<][$][>]

KW_IF    = if
KW_ELSE  = else
KW_IS    = is
KW_NOT   = not

KW_RETURN   = return
KW_RESUME   = resume
KW_YIELD    = yield
KW_BREAK    = break
KW_CONTINUE = continue
KW_THROUGH  = fallthrough
KW_RAISE    = raise

KW_NIL     = [∅]|nil
KW_NULL    = null
KW_BOOLEAN = true|false

SYMBOL=[\p{XID_Start}_][\p{XID_Continue}]*
SYMBOW_RAW = `[^`]*`
ESCAPED = \\.
NAME_SPLIT = [⸬∷]|{COLON}{2}
NAME_SCOPE = [⁜]|\\N

COLOR           = (©|®)[0-9a-zA-Z]*
// decimal number
C_DEC           = [0-9]
C_NUM           = [0-9a-zA-Z]
INTEGER         = {C_DEC}(_?{C_DEC})*
DECIMAL         = {C_DEC}(_?{C_DEC})*(\.{C_DEC}(_?{C_DEC})*)
// number based
O_BASE          = [⁂]|[*]{3}
NUMBER_BASE     = {C_NUM}(_?{C_NUM})*(\.{C_NUM}(_?{C_NUM})*)?
// number exponent
O_EXPONENT      = [⁑]|[*]{2}
NUMBER_EXPONENT = [+-]?[0-9]+

OP_NOT         = [¬]
OP_AND_THEN    = {QUESTION}
OP_SET_THEN    = {QUESTION}[=]
OP_UNWRAP_OR   = {QUESTION}{2}
OP_UNWRAP_ELSE = {COLON}{QUESTION}|{QUESTION}{COLON}

// start with +
OP_ADD           = [+]
OP_ADD_ASSIGN    = [+][=]
// start with -
OP_SUB           = [-]
OP_SUB_ASSIGN    = [-][=]
// start with `*`
OP_MUL           = [×]
OP_MUL_ASSIGN    = [×*][=]
// start with `/`
OP_DIV             = [/⁄∕]
OP_DIV_ASSIGN      = {OP_DIV}[=]
OP_DIV_FLOOR       = {OP_DIV}{DOT}
OP_DIV_CEIL        = {OP_DIV}[\^]
OP_DIV_ROUND_FLOOR = {OP_DIV}({DOT}\^)
OP_DIV_ROUND_CEIL  = {OP_DIV}(\^{DOT})
OP_DIV_REM         = [÷]|[/][%]
OP_MAP             = [⇴⨵]|[/][@]
// start with `%`
OP_REM           = [⁒%]
OP_REM_ASSIGN    = [⁒%][=]
// start with `^`
OP_POW           = \^
OP_POW_ASSIGN    = \^[=]

OP_SQRT       = [√]
OP_SURD3      = [∛]
OP_SURD4      = [∜]

OP_REV = [⅟]
OP_HALF = ½


OP_UNTIL      = {DOT}{2}[<=]

OP_PM = [±]
OP_MP = [∓]

OP_APPLY2 = [⊕] | [@]{2};
OP_APPLY3 = [⟴]| [@]{3};

// equal
BIND   = [←]|<-
EQUAL  = =
OP_EE  = ==
OP_NE  = [≠]|{OP_NOT}=
OP_EEE = [≡]|={3}
OP_NEE = [≢]|{OP_NOT}={2,3}|={OP_NOT}=
// contains/belongs
KW_IN           = in
OP_IN           = [∈∊]|\![∉]
OP_NOT_IN       = [∉]|\![∈]
OP_CONTAINS     = [∋∍]|\![∌]
OP_NOT_CONTAINS = [∌]|\![∋∍]
// compare
LEQ = ⩽|≤|<=
OP_LLL = ⋘
OP_LLE = <<=
OP_LL  = ≪
OP_LE  = {OP_NOT}{GEQ}
OP_LEQ = {LEQ}|{OP_NOT}>

GEQ = ⩾|≥|>=
OP_GGG = ⋙
OP_GGE = >>=
OP_GG  = ≫
OP_GEQ = ⩾|≥|>=|{OP_NOT}<
OP_GE  = {OP_NOT}{LEQ}
// logical
LOGIC_AND  = [∧]|[&]{2}
LOGIC_XAND = [⩟]
LOGIC_NAND = [⊼]
LOGIC_OR   = [∨]|[|]{2}
LOGIC_XOR  = [⊻]
LOGIC_NOR  = [⊽]

// arrow
OP_ARROW1 = ⟶|->
OP_ARROW2 = ⇒|=>
OP_ARROW3 = ==>


OP_DOT2 = [‥]|{DOT}{2}
OP_DOT3 = […]|{DOT}{3}


OP_L10N = ⸿|\\L

OP_CELSIUS    = ℃
OP_FAHRENHEIT = ℉



OP_REFERENCE = [❡¶]
OP_DEREFERENCE = [⁋]

RESERVED = [߷⸖↯⍼♯⟀⟁]
%%
<YYINITIAL> {
    {WHITE_SPACE}+     { return WHITE_SPACE; }
    {COMMENT_LINE}     { return COMMENT_LINE; }
    {ANGLE_L}{COMMENT} {
        yypushstate(CommentBlock);
    }
}

<CommentBlock> {
    {ANGLE_L}{COMMENT} {
        yypushstate(CommentBlock);
    }
    [^<⍝#>]+ { }
    {COMMENT}{ANGLE_R} {
        yypopstate();
        if (yystate() != CommentBlock) {
            return COMMENT_BLOCK;
        }
    }
    [<⍝#>] { }
    . { return BAD_CHARACTER; }
}
//    <<EOF>> {
//        yyclearstack();
//        yybegin(YYINITIAL);
//        return COMMENT_BLOCK;
//    }
// [^] { return COMMENT_BLOCK; }
<YYINITIAL> {
	"(" { return PARENTHESIS_L; }
    ")" { return PARENTHESIS_R; }
    "⦅" { return BUILDER_L; }
    "⦆" { return BUILDER_R; }
    "[" { return BRACKET_L; }
    "]" { return BRACKET_R; }
    "⁅" { return OFFSET_L; }
    "⁆" { return OFFSET_R; }
	"{" { return BRACE_L; }
	"}" { return BRACE_R; }
    '⦃' { return DOMAIN_L; }
    "⦄" { return DOMAIN_R; }
	"<" { return ANGLE_L; }
	">" { return ANGLE_R; }
    "⟨" { return GENERIC_L; }
    "⟩" { return GENERIC_R; }
    "⌊" { return FLOOR_L; }
    "⌋" { return FLOOR_R; }
    "⌈" { return CEIL_L; }
    "⌉" { return CEIL_R; }
}

<YYINITIAL> {
	; { return SEMICOLON; }
    {KW_END} { return KW_END; }
    {OP_END} { return OP_END; }
    {TEMPLATE_L} { return TEMPLATE_L; }
    {TEMPLATE_R} { return TEMPLATE_R; }

    {NAME_SPLIT}     { return NAME_SPLIT; }
    {NAME_SCOPE}     { return NAME_SCOPE; }
	{COLON}          { return COLON; }
    {STAR}           { return STAR; }
    {OP_REFERENCE}   { return OP_REFERENCE;}
    {OP_DEREFERENCE} { return OP_DEREFERENCE;}

    {OP_ARROW1} { return OP_ARROW1; }
    {OP_ARROW2} { return OP_ARROW2; }
    {OP_ARROW3} { return OP_ARROW3; }

    "|"   { return OP_OR;}
    &     { return OP_AND;}
	@\^   { return OP_MACRO_UPPER; }
	@     { return OP_MACRO; }
    @\.|↯ { return OP_MACRO_LOWER;}
    "$"   { return DOLLAR; }

	{OP_DOT3} { return ANY_DICT; }
    {OP_DOT2} { return ANY_LIST; }
	{DOT}     { return DOT; }

	{COMMA}   { return COMMA; }

    {BIND}     { return BIND;}
	{EQUAL}    { return EQUAL; }
    // <
    { OP_LLL } { return OP_LLL; }
    { OP_LL }  { return OP_LL; }
    { OP_LEQ } { return OP_LEQ; }
    // >
    { OP_GGG } { return OP_GGG; }
    { OP_GG }  { return OP_GG; }
    { OP_GEQ } { return OP_GEQ; }

    {OP_EE} { return OP_EE;}
    {OP_NE} { return OP_NE; }

    {OP_ADD}           { return OP_ADD; }
    {OP_ADD_ASSIGN}    { return OP_ADD_ASSIGN; }

    {OP_SUB}           { return OP_SUB; }
    {OP_SUB_ASSIGN}    { return OP_SUB_ASSIGN; }

    {OP_MUL}           { return OP_MUL; }
    {OP_MUL_ASSIGN}    { return OP_MUL_ASSIGN; }


    {OP_DIV_ROUND_FLOOR} { return OP_DIV_ROUND; }
    {OP_DIV_ROUND_CEIL}  { return OP_DIV_ROUND; }
    {OP_DIV_FLOOR}       { return OP_DIV_FLOOR; }
    {OP_DIV_CEIL}        { return OP_DIV_CEIL; }
	{OP_DIV_REM}         { return OP_DIV_REM; }
    {OP_DIV_ASSIGN}      { return OP_DIV_ASSIGN; }
    {OP_MAP}             { return OP_MAP; }
    {OP_DIV}             { return OP_DIV; }

	{OP_REM}           { return OP_REM; }
	{OP_REM_ASSIGN}    { return OP_REM_ASSIGN; }

    {OP_POW}           { return OP_POW; }

    {OP_SQRT}          { return OP_SQRT; }
    {OP_SURD3}         { return OP_SURD3; }
    {OP_SURD4}         { return OP_SURD4; }

    // logical
    {LOGIC_AND}  { return LOGIC_AND; }
    {LOGIC_XAND} { return LOGIC_XAND; }
    {LOGIC_NAND} { return LOGIC_NAND; }
    {LOGIC_OR}   { return LOGIC_OR; }
    {LOGIC_XOR}  { return LOGIC_XOR; }
    {LOGIC_NOR}  { return LOGIC_NOR; }

    {BANG}            { return OP_BANG; }
    {OP_NOT}          { return OP_NOT; }
    {OP_AND_THEN}     { return OP_AND_THEN; }
    {OP_SET_THEN}     { return OP_SET_THEN; }
    {OP_UNWRAP_OR}    { return OP_UNWRAP_OR; }
    {OP_UNWRAP_ELSE}  { return OP_UNWRAP_ELSE; }

    {OP_UNTIL}      { return OP_UNTIL; }
    // Localization
    {OP_L10N}       { return OP_L10N; }
    // Temperature
    {OP_CELSIUS}    { return OP_CELSIUS; }
    {OP_FAHRENHEIT} { return OP_FAHRENHEIT; }
}



<YYINITIAL> {
    [\"]{3} {
          yybegin(TextCapture6);
          return STRING_L;
    }
    [\']{3} {
          yybegin(TextCapture3);
          return STRING_L;
    }
    [\"]{1} {
          yybegin(TextCapture2);
          return STRING_L;
    }
    [\']{1} {
          yybegin(TextCapture1);
          return STRING_L;
    }
    {COLOR} { return COLOR; }
}
// Parsing number with suffix
<YYINITIAL> {
    {DECIMAL} { yybegin(AfterNumber);return DECIMAL; }
    {INTEGER} { yybegin(AfterNumber);return INTEGER; }
}
<AfterNumber> {
    {O_BASE}{NUMBER_BASE}         { yybegin(AfterNumberBase);yypushback(yylength()); }
    {O_EXPONENT}{NUMBER_EXPONENT} { yybegin(AfterNumberExp);yypushback(yylength()); }

    {SYMBOW_RAW} { yybegin(YYINITIAL);return NUMBER_SUFFIX; }
    {SYMBOL}     { yybegin(YYINITIAL);return NUMBER_SUFFIX; }
    [^]          { yybegin(YYINITIAL);yypushback(yylength()); }
}
<AfterNumberBase> {
    {O_BASE}      { return OP_BASE; }
    {NUMBER_BASE} { yybegin(AfterNumber); return NUMBER_BASE;}
}
<AfterNumberExp> {
    {O_EXPONENT}      { return OP_EXPONENT; }
    {NUMBER_EXPONENT} { yybegin(AfterNumber); return NUMBER_EXPONENT;}
}

<YYINITIAL> {
    {KW_NAMESPACE} { return KW_NAMESPACE; }
    {KW_USING}     { return KW_USING; }
    {KW_AS}        { return KW_AS; }
    {KW_EXCLUDE}   { return KW_EXCLUDE; }


    {KW_DEPENDS}   { return KW_DEPENDS; }
    {KW_WHERE}     { return KW_WHERE; }


    {KW_TYPE}      { return KW_TYPE; }
    {KW_FLAGS}     { return KW_FLAGS; }
    {KW_ENUMERATE} { return KW_ENUMERATE; }
    {KW_UNITE}     { return KW_UNITE; }
    {KW_UNION}     { return KW_UNION; }
    {KW_CLASS}     { return KW_CLASS; }
    {KW_TRAIT}     { return KW_TRAIT; }
    {KW_EXTENDS}   { return KW_IMPLY; }
    {KW_WHERE}     { return KW_WHERE; }
    {KW_MICRO}     { return KW_MICRO; }
    {KW_MEZZO}     { return KW_MEZZO; }
    {KW_MACRO}     { return KW_MACRO; }
    {KW_COMPONENT} { return KW_COMPONENT; }
    {KW_SINGLETON} { return KW_SINGLETON; }
    {KW_NEURAL}    { return KW_NEURAL; }


    {KW_LET}       { return KW_LET; }
    {KW_NEW}       { return KW_NEW; }
    {KW_OBJECT}    { return KW_OBJECT; }
    {KW_LAMBDA}    { return KW_LAMBDA; }

    {KW_IF}        { return KW_IF; }
    {KW_ELSE}      { return KW_ELSE; }

    {KW_LOOP}      { return KW_LOOP; }
    {KW_WHILE}     { return KW_WHILE; }
    {KW_UNTIL}     { return KW_UNTIL; }
    {OP_LABEL}     { return OP_LABEL; }
    {KW_FOR}       { return KW_FOR; }
    {KW_EACH}      { return KW_EACH; }
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
    {KW_CATCH} { return KW_CATCH; }
    {KW_WITH}  { return KW_WITH; }
    {KW_WHEN}  { return KW_WHEN; }
    {KW_FROM}  { return KW_FROM; }
    {KW_CASE}  { return KW_CASE; }


    {KW_NULL}    { return KW_NULL; }
    {KW_NIL}     { return KW_NIL; }
    {KW_BOOLEAN} { return KW_BOOLEAN; }
    {KW_IS}      { return KW_IS; }
    {KW_NOT}     { return KW_NOT; }
    {SYMBOW_RAW} { return SYMBOW_RAW; }
    {SYMBOL}     { return SYMBOL; }
}
// =====================================================================================================================
<TextCapture6> {
    [\"]{3} {
        yybegin(YYINITIAL);
        return STRING_R;
    }
    [^\"]+ { return STRING_TEXT; }
    \" { return STRING_TEXT; }
}
<TextCapture3> {
    [\']{3} {
        yybegin(YYINITIAL);
        return STRING_R;
    }
    [^\']+ { return STRING_TEXT; }
    \' { return STRING_TEXT; }
}
<TextCapture2> {
    [\"]{1} {
        yybegin(YYINITIAL);
        return STRING_R;
    }
    [^\"]+ { return STRING_TEXT; }
    \" { return STRING_TEXT; }
}
<TextCapture1> {
    [\']{1} {
        yybegin(YYINITIAL);
        return STRING_R;
    }
    [^\']+ { return STRING_TEXT; }
    \' { return STRING_TEXT; }
}
// =====================================================================================================================
[^] { return BAD_CHARACTER; }
