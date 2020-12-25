package com.github.valkyrie.language;

import com.intellij.psi.tree.IElementType;
import com.intellij.util.containers.IntStack;
import com.intellij.lexer.FlexLexer;
import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.github.valkyrie.language.psi.FluentTypes.*;

%%

%{
private static int indent_balance = 0;
private static IntStack brace_stack = new IntStack(9);

public _ValkyrieLexer() {
	this((java.io.Reader)null);
}

public void brace_block(int state) {
    brace_stack.push(state);
    yybegin(CodeContext);
}

public void brace_recover() {
    if (brace_stack.empty()) {
        yybegin(YYINITIAL);
    }
    else {
        yybegin(brace_stack.pop());
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

%state StringQuote
%state TextContext
%state TextContextSpace
//%state TextContextIndent
%state CodeContext
%state SelectionStart
%state SelectionText

WHITE_SPACE=[\s\t\r\n]
COMMENT_DOCUMENT=("///")[^\r\n]*
COMMENT_LINE = #{1,3}[^\r\n]*
COMMENT_BLOCK=[/][*][^*]*[*]+([^/*][^*]*[*]+)*[/]
SYMBOL=[\p{XID_Start}_][\p{XID_Continue}]*
STRING=\"([^\"\\]|\\.)*\"
BYTE=(0[bBoOxXfF][0-9A-Fa-f][0-9A-Fa-f_]*)
INTEGER=(0|[1-9][0-9_]*)
DECIMAL=([0-9]+\.[0-9]*([Ee][0-9]+)?)|(\.[0-9]+([Ee][0-9]+)?)

ESCAPE_SPECIAL= \\[^]
ESCAPE_UNICODE= \\(u{HEX}{4}|U{HEX}{6})
HEX = [0-9a-fA-F]

%%

<YYINITIAL> {
	{COMMENT_DOCUMENT} { return COMMENT_DOCUMENT; }
	{COMMENT_LINE}     { return COMMENT_LINE; }
	{COMMENT_BLOCK}    { return COMMENT_BLOCK; }
    {WHITE_SPACE}+     { return WHITE_SPACE; }
}

<YYINITIAL> {
    "{" { return BRACE_L; }
    "}" { return BRACE_R; }
    "<" { return ANGLE_L; }
    ">" { return ANGLE_R; }
    "^" { return ACCENT; }
    ";" { return SEMICOLON; }
    "$" { return DOLLAR; }
    "." { return DOT; }
    "-" { return HYPHEN; }
}
// 顶级关键词
<YYINITIAL> {
    "if" { return IF; }
    "else" { return ELSE; }
    "for" { return FOR; }
    "in" { return IN; }
    "while" { return WHILE; }
    {SYMBOL} { return SYMBOL; }
}
// =====================================================================================================================
// 文本域, 文本域只出现在代码中
<CodeContext> \" {
	yybegin(StringQuote);
    return STRING_QUOTE;
}
// String escaped highlight
<StringQuote> {
	{ESCAPE_UNICODE} {return STRING_ESCAPE;}
	{ESCAPE_SPECIAL} {return STRING_ESCAPE;}
	[^\"]+ {return STRING_CHAR;}
}

<StringQuote> \" {
	yybegin(CodeContext);
	return STRING_QUOTE;
}
// =====================================================================================================================
[^] { return BAD_CHARACTER; }
