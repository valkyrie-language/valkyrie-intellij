lexer grammar ValkyrieOperators;
// $antlr-format useTab false, alignColons hanging, alignSemicolons hanging
// $antlr-format alignFirstTokens true
@lexer::members {

}

DOT:       '.';
COMMA:     ',';
SEMICOLON: ';';

// colon
OP_PROPORTION: '∷' | '::';
COLON:         ':' | '∶';
// arrow
OP_ARROW2: '⇒' | '=>';
// brackets
PARENTHESES_L: '(';
PARENTHESES_R: ')';
BRACKET_L:     '[';
BRACKET_R:     ']';
BRACE_L:       '{';
BRACE_R:       '}';

// infix
SUB:  '-';
BANG: '!';
MUL:  '*';
DIV:  '/';
ADD:  '+';
LT:   '<';
LE:   '<=';

GT:  '>';
GE:  '>=';
OR:  '||';
AND: '&&';

AT:   '@';
HASH: '#';

OP_EQ: '=';
OP_EE: '==';
OP_NE: '!=';

OP_NOT_IN: '∉';

OP_IS_A:  '⊑' | '<:';
OP_NOT_A: '⋢' | '<!';

OP_UNTIL: '..<' | '..=';
// suffix
OP_TEMPERATURE: '℃' | '℉';
// standalone
OP_EMPTY: '∅';

// "\\" -> pushToken(ValkyrieTypes.KW_ESCAPING, r) // DOT ":=", "≔" ->
// pushToken(ValkyrieTypes.PATTERN_SET, r) "->", "⟶" -> pushToken(ValkyrieTypes.OP_ARROW, r) "==",
// "≡" -> pushToken(ValkyrieTypes.OP_EQ, r) "=" -> pushToken(ValkyrieTypes.OP_SET, r)
// 
// "..<", "..=" -> pushToken(ValkyrieTypes.OP_UNTIL, r) "...", ".." ->
// pushToken(ValkyrieTypes.KW_DOTS, r) start with + "++" -> pushToken(ValkyrieTypes.OP_INC, r) "+="
// -> pushToken(ValkyrieTypes.OP_ADD_ASSIGN, r) "+" -> pushToken(ValkyrieTypes.OP_ADD, r) // start
// with - "--" -> pushToken(ValkyrieTypes.OP_DEC, r) "-=" -> pushToken(ValkyrieTypes.OP_SUB_ASSIGN,
// r) "-" -> pushToken(ValkyrieTypes.OP_SUB, r) // start with * "*=" ->
// pushToken(ValkyrieTypes.OP_MUL_ASSIGN, r) "*" -> pushToken(ValkyrieTypes.OP_MUL, r) // start with
// / "/=" -> pushToken(ValkyrieTypes.OP_DIV_ASSIGN, r) "/" -> pushToken(ValkyrieTypes.OP_DIV, r) //
// start with & "&&=" -> pushToken(ValkyrieTypes.OP_AND_ASSIGN, r) "&&" ->
// pushToken(ValkyrieTypes.OP_AND2, r) "&=" -> pushToken(ValkyrieTypes.OP_AND_ASSIGN, r) "&" ->
// pushToken(ValkyrieTypes.OP_AND, r) // // start with ! "!!" -> pushToken(ValkyrieTypes.OP_NE, r)
// "!=" -> pushToken(ValkyrieTypes.OP_NE, r) "!" -> pushToken(ValkyrieTypes.OP_NOT, r) "|" ->
// pushToken(ValkyrieTypes.OP_OR, r) // start with ? "???" ->
// pushToken(ValkyrieTypes.OP_UNIMPLEMENTED, r) "?" -> pushToken(ValkyrieTypes.OP_QUESTION, r) //
// start with ^ "^" -> pushToken(ValkyrieTypes.OP_POW, r) // start with = "∈", "∊" -> {
// pushToken(ValkyrieTypes.OP_IN, r) }
// 
// slots "$" -> pushToken(ValkyrieTypes.SLOT_LAMBDA, r) "§" -> pushToken(ValkyrieTypes.SLOT_MACRO,
// r) "¶" -> pushToken(ValkyrieTypes.OP_QUOTE, r) "⟦" -> { pushToken(ValkyrieTypes.SLICE_L, r) }
// 
// "⟧" -> { pushToken(ValkyrieTypes.SLICE_R, r) } // start with > ">>>", "⋙" ->
// pushToken(ValkyrieTypes.OP_GGG, r) ">>", "≫" -> pushToken(ValkyrieTypes.OP_GG, r) ">=", "≥", "⩾"
// -> pushToken(ValkyrieTypes.OP_GEQ, r) "/>" -> { pushToken(ValkyrieTypes.OP_GS, r) }
// 
// ">" -> pushToken(ValkyrieTypes.OP_GT, r) // start with < "<<<", "⋘" ->
// pushToken(ValkyrieTypes.OP_LLL, r) "<<", "≪" -> pushToken(ValkyrieTypes.OP_LL, r) "<=", "≤", "⩽"
// -> pushToken(ValkyrieTypes.OP_LEQ, r) "</" -> { pushToken(ValkyrieTypes.OP_LS, r) } "⩕" -> {
// pushToken(ValkyrieTypes.PATTERN_AND, r) } "⩖" -> { pushToken(ValkyrieTypes.PATTERN_OR, r) } "<"
// -> pushToken(ValkyrieTypes.OP_LT, r) // surround with ( ) "(" -> {
// pushToken(ValkyrieTypes.PARENTHESIS_L, r) }
// 
// ")" -> { pushToken(ValkyrieTypes.PARENTHESIS_R, r) }
// 
// "{" -> { pushToken(ValkyrieTypes.BRACE_L, r) }
// 
// "}" -> { pushToken(ValkyrieTypes.BRACE_R, r) }
// 
// "⤇", "|=>", "⤃", "!=>" -> { pushToken(ValkyrieTypes.OP_EMPTY, r) }
// 
// atom
fragment NULL:  'null';
fragment TRUE:  'true';
fragment FALSE: 'false';
SPECIAL:        NULL | TRUE | FALSE;
// comment
LINE_COMMENT:  '//' .*? ('\n' | EOF) -> channel(HIDDEN);
BLOCK_COMMENT: '/*' .*? '*/' -> channel(HIDDEN);