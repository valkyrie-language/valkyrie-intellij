package com.github.valkyrie.language;

import com.intellij.psi.tree.IElementType;
import com.intellij.util.containers.IntStack;
import com.intellij.lexer.FlexLexer;
import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.github.valkyrie.language.psi.ValkyrieTypes.*;

%%

%{
private static int let_balance = 0;
private static boolean case_appearence = false;
private static String quote_balance = "";
private static IntStack brace_stack = new IntStack(9);

public _ValkyrieLexer() {
    this((java.io.Reader)null);
    init();
}
private static void init() {
    let_balance = 0;
    case_appearence = false;
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

%state ImportExport
%state Let
%state For
%state Forall
%state If
%state Class
%state Trait
%state Define
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

DEFINE = "define" | "def" | "func" | "fn";

%%

<YYINITIAL, Class, Trait, ImportExport, Let, For, Forall> {
    {COMMENT_DOCUMENT} { return COMMENT_DOCUMENT; }
    {COMMENT_LINE}     { return COMMENT_LINE; }
//  {COMMENT_BLOCK}    { return COMMENT_BLOCK; }
    {WHITE_SPACE}+     { return WHITE_SPACE; }
}
// 顶级关键词
<YYINITIAL> {
    "if" { return IF; }
    "else" { return ELSE; }
    "while" { return WHILE; }
    "match" { return MATCH; }
    "type" { return TYPE; }
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
// 遇到了 let 关键词
<YYINITIAL> "let" | "var" | "val" {
    yybegin(Let);
    case_appearence = false;
    return LET;
}
<Let, For> {
    "(" { let_balance += 1 ; return PARENTHESIS_L; }
    ")" { let_balance -= 1 ; return PARENTHESIS_R; }
    "[" { let_balance += 1 ; return BRACKET_L; }
    "]" { let_balance -= 1 ; return BRACKET_R; }
    "{" { let_balance += 1 ; return BRACE_L; }
    "}" { let_balance -= 1 ; return BRACE_R; }
}
<Let> "=" {
    if (let_balance == 0) {
        yybegin(YYINITIAL);
        return BIND;
    }
    else {
        return BIND;
    }
}
<Let, For> "case" {
    if (case_appearence == false) {
        case_appearence = true;
        return CASE;
    }
    else {
        return SYMBOL_XID;
    }
}
<Let> ";" {
    brace_block(YYINITIAL);
    return SEMICOLON;
}
// =====================================================================================================================
// 遇到了 def 关键词
<YYINITIAL> {DEFINE} {
    return DEFINE;
}
// =====================================================================================================================
// 遇到了 bitflags 关键词
<YYINITIAL> "for" {
    yybegin(For);
    case_appearence = false;
    return FOR;
}
<For> "in" {
    if (let_balance == 0) {
        yybegin(YYINITIAL);
        return IN;
    }
    else {
        return SYMBOL_XID;
    }
}
// =====================================================================================================================
// 遇到了关键词, 解除关键词捕捉
<YYINITIAL> "forall" | "∀" {
    yybegin(Forall);
    return FORALL;
}
<Forall> {
    "type" {yybegin(Class);return TYPE;}
    "extends" | "impl" {yybegin(Class);return EXTENDS;}
    "class" | "struct" {yybegin(Class);return CLASS;}
    "bitflags" | "bitflag" | "bitset" {yybegin(Class);return BITFLAG;}
    "variant" | "tagged" | "enum" {yybegin(Class);return TAGGED;}
    {DEFINE} {yybegin(Class);return DEFINE;}
    "exists" | "∃" {yybegin(Trait);return EXTENDS;}
    "trait" | "interface" {yybegin(Trait);return TRAIT;}
}
// =====================================================================================================================
<YYINITIAL> "class" | "struct" {
    yybegin(Class);
    return CLASS;
}
<YYINITIAL> "bitflags" | "bitflag" | "bitset" {
    yybegin(Class);
    return BITFLAG;
}
<YYINITIAL> "variant" | "tagged" | "enum" {
    yybegin(Class);
    return TAGGED;
}
<Class> {
    "{" {brace_block(Class); return BRACE_L;}
    "}" {brace_recover();    return BRACE_R;}
    "(" {brace_block(Class); return PARENTHESIS_L;}
    ")" {brace_recover();    return PARENTHESIS_R;}
}
// =====================================================================================================================
<YYINITIAL> "trait" | "interface" {
    yybegin(Trait);
    return TRAIT;
}
<YYINITIAL> "extends" | "impl" {
    yybegin(Trait);
    return EXTENDS;
}
<YYINITIAL> "exists" | "∃" {
    yybegin(Trait);
    return EXTENDS;
}
<Trait> {
    "{" {brace_block(YYINITIAL); return BRACE_L;}
    "}" {brace_recover();    return BRACE_R;}
    "(" {brace_block(YYINITIAL); return PARENTHESIS_L;}
    ")" {brace_recover();    return PARENTHESIS_R;}
}
// =====================================================================================================================
<YYINITIAL, Class,Trait, ImportExport, Let, For, Forall> {
    {BYTE} { return BYTE; }
    {INTEGER} { return INTEGER; }
    {DECIMAL} { return DECIMAL; }
    {SYMBOL_XID} { return SYMBOL_XID; }
    {SYMBOL_RAW} { return SYMBOL_RAW; }
}
<YYINITIAL, Class,Trait, ImportExport, Let, For, Forall> {
    // !
    "!=" { return NE; }
    "!" { return BANG; }
    // < >
    "<<" | "≪" { return LESS; }
    ">>" | "≫" { return GREATER; }
    "{" { return BRACE_L; }
    "}" { return BRACE_R; }
    "<" { return ANGLE_L; }
    ">" { return ANGLE_R; }
    "[" { return BRACKET_L; }
    "]" { return BRACKET_R; }
    "(" { return PARENTHESIS_L; }
    ")" { return PARENTHESIS_R; }
    "^" { return ACCENT; }
    // :
    "∷" | "::" { return PROPORTION; }
    ":" { return COLON; }
    ";" { return SEMICOLON; }
    "|" { return VERTICAL; }
    "$" { return DOLLAR; }
    "@" { return AT; }
    "#" { return HASH; }
    "&" { return AMP; }
    "?" { return QUESTION ; }
    // .
    "..." { return DOT3 ; }
    "..=" { return DOT_EQ; }
    "..<" { return DOT_LESS; }
    ".."  { return DOT2; }
    "." { return DOT; }
    "," { return COMMA; }
    "+" { return PLUS; }
    "->" { return TO; }
    "-" { return MINUS; }
    // =
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
