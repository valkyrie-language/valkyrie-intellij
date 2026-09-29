package vos.intellij;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static vos.intellij.language.psi.VosTypes.*;

%%

%{
  public _VosLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _VosLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

%state StringSQ
%state StringDQ

EOL=\R
WHITE_SPACE=\s+

COMMENT_DOCUMENT=("///")[^\r\n]*
COMMENT=("//")[^\r\n]*
COMMENT_BLOCK=[/][*][^*]*[*]+([^/*][^*]*[*]+)*[/]
URL= [A-Za-z0-9]+:"//"[\-\p{XID_Continue}./?&#]+
SYMBOL=[\p{XID_Start}_$][\p{XID_Continue}_$]*
BYTE=(0[bBoOxXfF][0-9A-Fa-f][0-9A-Fa-f_]*)
INTEGER=(0|[1-9][0-9_]*)
DECIMAL=([0-9]+\.[0-9]*(([*]{2}|[eE])[+-]?[0-9]+)?)
SIGN=[+-]

ESCAPE_SPECIAL = \\[^xuU]
ESCAPE_UNICODE = \\(x{HEX}{2}|u{HEX}{4}|U\{{HEX}+\})
HEX = [0-9a-fA-F]

KW_LET = let|var|const|object
KW_UNION = union|enum|enumerate|tagged
KW_CLASS = class|table|primitive|struct|structure
KW_DEFINE = define|def|function|fun|fn
KW_NAMESPACE = namespace|package

EQ  = =
LEQ = <=|≤|⩽
GEQ = >=|≥|⩾
RANGE_LE = [.]{2}<
RANGE_EQ = [.]{2}=
ANNOTATION_MARK = [@#]

%%
<YYINITIAL> {
    {WHITE_SPACE}           { return WHITE_SPACE; }
    ";"                     { return SEMICOLON; }
    ","                     { return COMMA; }
    {ANNOTATION_MARK}       { return ANNOTATION_MARK; }
}

<YYINITIAL> {
    {KW_NAMESPACE}        { return KW_NAMESPACE; }
    {KW_LET}              { return KW_LET; }
    {KW_DEFINE}           { return KW_DEFINE; }
    {KW_CLASS}            { return KW_CLASS; }
    {KW_UNION}            { return KW_UNION; }
}


<YYINITIAL> {
    "("                     { return PARENTHESIS_L; }
    ")"                     { return PARENTHESIS_R; }
    "["                     { return BRACKET_L; }
    "]"                     { return BRACKET_R; }
    "{"                     { return BRACE_L; }
    "}"                     { return BRACE_R; }
    "^"                     { return ACCENT; }
    "<"                     { return ANGLE_L; }
    ">"                     { return ANGLE_R; }
    {EQ}                    { return EQ; }
    {LEQ}                   { return LEQ; }
    {GEQ}                   { return GEQ; }
    {RANGE_LE}              { return RANGE_LE; }
    {RANGE_EQ}              { return RANGE_EQ; }
    ":"                     { return COLON; }
    "."                     { return DOT; }
    "*"                     { return STAR; }


    {COMMENT_DOCUMENT}      { return COMMENT_DOCUMENT; }
    {COMMENT}               { return COMMENT; }
    {COMMENT_BLOCK}         { return COMMENT_BLOCK; }
    {URL}                   { return URL; }
    {SYMBOL}                { return SYMBOL; }
    {BYTE}                  { return BYTE; }
    {INTEGER}               { return INTEGER; }
    {DECIMAL}               { return DECIMAL; }
    {SIGN}                  { return SIGN; }
}
// String Mode =========================================================================================================
<YYINITIAL> {
    \'            { yybegin(StringSQ); return STRING_SQ; }
    \"            { yybegin(StringDQ); return STRING_DQ; }
}
<StringSQ, StringDQ, YYINITIAL> {ESCAPE_SPECIAL} {
    return ESCAPE_SPECIAL;
}
<StringSQ, StringDQ, YYINITIAL> {ESCAPE_UNICODE} {
    return ESCAPE_UNICODE;
}
<StringSQ> {
    [^\\\'] {return CHARACTER;}
    \' {yybegin(YYINITIAL);return STRING_SQ;}
}
<StringDQ> {
    [^\\\"] {return CHARACTER;}
    \" {yybegin(YYINITIAL);return STRING_DQ;}
}
[^] { return BAD_CHARACTER; }
