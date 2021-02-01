package com.github.valkyrie.language;

import com.intellij.psi.tree.IElementType;
import com.intellij.util.containers.IntStack;
import com.intellij.lexer.FlexLexer;
import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.github.valkyrie.language.psi.ValkyrieTypes.*;

%%

%{
private static String quote_balance = "";
private static IntStack brace_stack = new IntStack(9);

public _ValkyrieLexer() {
    this((java.io.Reader)null);
    init();
}
private static void init() {
    quote_balance = "";
    brace_stack.clear();
}
public void brace_block(int state) {
    brace_stack.push(state);
    yybegin(state);
}

public void brace_recover() {
    if (brace_stack.size() == 0) {
        yybegin(YYINITIAL);
    }
    else if (brace_stack.size() == 1) {
        brace_stack.pop();
        yybegin(YYINITIAL);
    }
    else {
        brace_stack.pop();
        yybegin(brace_stack.peek());
    }
}

public void count_indent() {
    // yytext().last_line.count_indent
}
public void match_indent() {
    // length may < indent_balance
    // t = yytext().length() - indent_balance - Length of Newline
    // yypushback(t);
}
%}

%public
%class _ValkyrieLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode
%eof{
    init();
%eof}

%state Bitflag
%state ImportExport
%state StringInside

WHITE_SPACE=[\s\t\r\n]
COMMENT_DOCUMENT=("///")[^\r\n]*
COMMENT_LINE = ("//")[^\r\n]*
//COMMENT_BLOCK=[/][*][^*]*[*]+([^/*][^*]*[*]+)*[/]
SYMBOL_XID=[\p{XID_Start}_][\p{XID_Continue}]*
SYMBOL_RAW=`([^`\\]|\\.)*`
BYTE=(0[bBoOxXfF][0-9A-Fa-f][0-9A-Fa-f_]*)
INTEGER=0|[1-9][0-9_]*
DECIMAL=[0-9]+\.[0-9]+

ESCAPE_SPECIAL= \\.
ESCAPE_UNICODE= \\(u{HEX}{4}|U{HEX}{6})
HEX = [0-9a-fA-F]

%%

<YYINITIAL, Bitflag, ImportExport> {
    {COMMENT_DOCUMENT} { return COMMENT_DOCUMENT; }
    {COMMENT_LINE}     { return COMMENT_LINE; }
//  {COMMENT_BLOCK}    { return COMMENT_BLOCK; }
    {WHITE_SPACE}+     { return WHITE_SPACE; }
}


<YYINITIAL> {
    "{" { return BRACE_L; }
    "}" { return BRACE_R; }
}
// 顶级关键词
<YYINITIAL> {
    "forall" { return FORALL; }
    "if" { return IF; }
    "else" { return ELSE; }
    "for" { return FOR; }
    "in" { return IN; }
    "while" { return WHILE; }
    "match" { return MATCH; }
    "let" | "var" | "val" { return LET; }
    "def" | "func" | "fn" { return DEF; }
    "type" { return TYPE; }
    "class" | "struct" { return CLASS; }
    "trait" | "interface" { return TRAIT; }
    "variant" | "tagged" | "enum" { return VARIANT; }
    "extends"| "extend" | "impl" { return EXTENDS; }
}
// =====================================================================================================================
<YYINITIAL> "import" {
    yybegin(ImportExport);
    return IMPORT;
}
<YYINITIAL> "export" {
    yybegin(ImportExport);
    return EXPORT;
}
<ImportExport> "*" {
    return SYMBOL_RAW;
}
<ImportExport> ";" {
    yybegin(YYINITIAL);
    return SEMICOLON;
}
<ImportExport> "{" {
    brace_block(ImportExport);
    return BRACE_L;
}
<ImportExport> "}" {
    brace_recover();
    return BRACE_R;
}
// =====================================================================================================================
// 遇到了 bitflags 关键词
<YYINITIAL> "bitflags" | "bitflag" | "bitset" {
    yybegin(Bitflag);
    return BITFLAG;
}
<Bitflag> "{" {
    brace_block(Bitflag);
    return BRACE_L;
}
<Bitflag> "}" {
    brace_recover();
    return BRACE_R;
}
// =====================================================================================================================
<YYINITIAL, Bitflag, ImportExport> {
    {BYTE} { return BYTE; }
    {INTEGER} { return INTEGER; }
    {DECIMAL} { return DECIMAL; }
    {SYMBOL_XID} { return SYMBOL_XID; }
    {SYMBOL_RAW} { return SYMBOL_RAW; }
}
<YYINITIAL, Bitflag, ImportExport> {
    // !
    "!=" { return NE; }
    "!" { return BANG; }
    // < >
    "<<" | "≪" { return LESS; }
    ">>" | "≫" { return GREATER; }
    "<" { return ANGLE_L; }
    ">" { return ANGLE_R; }
    "[" { return BRACKET_L; }
    "]" { return BRACKET_R; }
    "(" { return PARENTHESIS_L; }
    ")" { return PARENTHESIS_R; }
    "^" { return ACCENT; }
    // :
    "∷<" | "::<" { return TURBOFISH; }
    "∷" | "::" { return PROPORTION; }
    ":" { return COLON; }
    ";" { return SEMICOLON; }
    "|" { return VERTICAL; }
    "$" { return DOLLAR; }
    "@" { return AT; }
    "#" { return HASH; }
    // .
    "..=" | "..<" | ".."  { return UNTIL; }
    "." { return DOT; }
    "," { return COMMA; }
    "+" { return PLUS; }
    "-" { return MINUS; }
    "==" { return EQ; }
    "=" { return BIND; }
}
// =====================================================================================================================
// String escaped highlight
//<StringQuote> {
//{ESCAPE_UNICODE} {return STRING_ESCAPE;}
//{ESCAPE_SPECIAL} {return STRING_ESCAPE;}
//[^\"]+ {return STRING_CHAR;}
//}
<YYINITIAL> \'+ | \"+ {
    if (yylength()==2) {
        return STRING_EMPTY;
    }
    quote_balance = yytext().toString();
    yybegin(StringInside);
    return STRING_START;
}
<StringInside> \'+ | \"+ {
    if(quote_balance.equals(yytext().toString())) {
        yybegin(YYINITIAL);
        return STRING_END;
    }
    return STRING_CHAR;
}
<StringInside> [^\'\"]+ {
    return STRING_CHAR;
}
// =====================================================================================================================
[^] { return BAD_CHARACTER; }
