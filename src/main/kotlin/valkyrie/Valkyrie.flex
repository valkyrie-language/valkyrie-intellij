package swarm.intellij.language;

import java.util.Stack;
import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static valkyrie.language.psi.ValkyrieTypes.*;
import static valkyrie.language.SwarmLexerAdapterKt.*;

%%

%{
public boolean xmlTagMode = false;
public Stack<IElementType> tokenStream = new Stack<>();
public final Stack<Integer> contextStack = new Stack<>();

public _ValkyrieLexer() {
    this.zzReader = null;
    xmlTagMode = false;
    contextStack.clear();
    tokenStream.clear();
}
%}

%public
%class _ValkyrieLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

%state StringSQ
%state StringDQ
%state StringEQ

EOL=\R
WHITE_SPACE=\s+

COMMENT_DOC=("///")[^\r\n]*
COMMENT_LINE=("//")[^\r\n]*
COMMENT_BLOCK=[/][*][^*]*[*]+([^/*][^*]*[*]+)*[/]
BOOLEAN=true|false
SYMBOL=[\p{XID_Start}_][\p{XID_Continue}]*
BYTE=(0[bBoOxXfF][0-9A-Fa-f][0-9A-Fa-f_]*)
INTEGER=(0|[1-9][0-9_]*)
DECIMAL=([0-9]+\.[0-9]*([*][*][0-9]+)?)|(\.[0-9]+([Ee][0-9]+)?)
SIGN=[+-]
ESCAPE_SPECIAL = \\[^xuU]
ESCAPE_UNICODE = \\(x{HEX}{2}|u{HEX}{4}|U\{{HEX}+\})
HEX = [0-9a-fA-F]

%%
<YYINITIAL> {
	{WHITE_SPACE}   { return pushToken(this, WHITE_SPACE); }
	{COMMENT_DOC}   { return pushToken(this, COMMENT_DOC); }
	{COMMENT_LINE}  { return pushToken(this, COMMENT_LINE); }
	{COMMENT_BLOCK} { return pushToken(this, COMMENT_BLOCK); }
}

<YYINITIAL> {
	//
	"("  { return pushToken(this, PARENTHESIS_L); }
	")"  { return pushToken(this, PARENTHESIS_R); }
	"["  { return pushToken(this, BRACKET_L); }
	"]"  { return pushToken(this, BRACKET_R); }
	"{"  { return pushToken(this, BRACE_L); }
	"}"  { return pushToken(this, BRACE_R); }
	"->" { return pushToken(this, ARROW); }
	//
	::   { return pushToken(this, DOUBLE_COLON); }
	:    { return pushToken(this, COLON); }
	;    { return pushToken(this, SEMICOLON); }
	,    { return pushToken(this, COMMA); }
	#    { return pushToken(this, HASH); }
	\^   { return pushToken(this, ACCENT); }
	\~   { return pushToken(this, SOFT_CONNECT);}
	\|   { return pushToken(this, CHOOSE);}
	\!   { return pushToken(this, NOT);}
	\\   { return pushToken(this, ESCAPE); }
	\$   { return pushToken(this, DOLLAR); }
	\.   { return pushToken(this, DOT); }

	\?   { return pushToken(this, OPTIONAL);}
	\+   { return pushToken(this, MANY1); }
	\-   { return pushToken(this, HYPHEN); }
	\*   { return pushToken(this, MANY); }

    \< 	 { return pushToken(this, LT); }
	\>   { return pushToken(this, GT); }
}
<YYINITIAL> [\^\]$@]*= {
	return pushToken(this, EQ);
}
<YYINITIAL> {
	// literal
	{BOOLEAN}     { return pushToken(this, BOOLEAN); }
	{BYTE}        { return pushToken(this, BYTE); }
	{INTEGER}     { return pushToken(this, INTEGER); }
    {DECIMAL}     { return pushToken(this, DECIMAL); }
	{SIGN}        { return pushToken(this, SIGN); }
	{SYMBOL}      { return maybeSymbol(this); }
}
// String Mode =========================================================================================================
<YYINITIAL> {
	\' { return enterContext(this, StringSQ, STRING_SQ); }
	\" { return enterContext(this, StringDQ, STRING_DQ); }
	\` { return enterContext(this, StringEQ, STRING_EQ); }
}
<StringSQ, StringDQ, StringEQ, YYINITIAL> {
	{ESCAPE_SPECIAL} { return pushToken(this, ESCAPE_SPECIAL); }
	{ESCAPE_UNICODE} { return pushToken(this, ESCAPE_UNICODE); }
}
<StringSQ> {
	[^\\\']+ {return pushToken(this, STRING_WORD);}
	\' { return leaveContext(this, STRING_SQ); }
}
<StringDQ> {
	[^\\\"]+ {return pushToken(this, STRING_WORD);}
	\" { return leaveContext(this, STRING_DQ); }
}
<StringEQ> {
	[^\\`]+ {return pushToken(this, SYMBOL_WORD);}
	` { return leaveContext(this, STRING_EQ); }
}
// Otherwisw ===========================================================================================================
[^] { return pushToken(this, BAD_CHARACTER); }
