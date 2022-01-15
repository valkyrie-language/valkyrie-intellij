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

// brackets
PARENTHESES_L: '(';
PARENTHESES_R: ')';
BRACKET_L:     '[';
BRACKET_R:     ']';
BRACE_L:       '{';
BRACE_R:       '}';

// infix
OP_ADD: '+';
OP_SUB: '-';
OP_MUL: '*';
OP_DIV: '/';
// equal
OP_EQ: '==';
OP_NE: '!=';
// compare
OP_LE:  '<';
OP_LL:  '≪' | '<<';
OP_LLL: '⋘' | '<<<';
OP_LEQ: '⩽' | '≤' | '<=';
OP_GE:  '>';
OP_GG:  '≫' | '>>';
OP_GGG: '⋙' | '>>>';
OP_GEQ: '⩾' | '≥' | '>=';
// arrow
OP_ARROW:  '⟶' | '->';
OP_ARROW2: '⇒' | '=>';
OP_ASSIGN: '=';


// "⟧" -> { pushToken(ValkyrieTypes.SLICE_R, r) } -> pushToken(ValkyrieTypes.OP_GEQ, r) "/>" -> {
// pushToken(ValkyrieTypes.OP_GS, r) }
// 
// ">" -> pushToken(ValkyrieTypes.OP_GT, r) -> pushToken(ValkyrieTypes.OP_LEQ, r) "</" -> {
// pushToken(ValkyrieTypes.OP_LS, r) } "⩕" -> { pushToken(ValkyrieTypes.PATTERN_AND, r) } "⩖" -> {
// pushToken(ValkyrieTypes.PATTERN_OR, r) }

LOGIC_OR:  '||';
OP_OR:     '|';
LOGIC_AND: '&&';
OP_AND:    '&';

AT:   '@';
HASH: '#' | '##' | '#!';

// not
OP_NOT: '!';
KW_NOT: 'not';
// in
OP_IN:     '∈' | '∊';
KW_IN:     'in';
OP_NOT_IN: '∉';

// is
KW_IS:     'is';
OP_IS:     '⊑' | '<:';
OP_IS_NOT: '⋢' | '<!';
// as
KW_AS: 'as' | 'as!' | 'as*';
// until
OP_UNTIL: '..<' | '..=';
// suffix
OP_TEMPERATURE: '℃' | '℉';
// standalone
OP_EMPTY: '∅';
// "\\" -> pushToken(ValkyrieTypes.KW_ESCAPING, r) // DOT ":=", "≔" ->
// pushToken(ValkyrieTypes.PATTERN_SET, r) "->", "==", "≡" -> pushToken(ValkyrieTypes.OP_EQ, r)
// 
//
// 
//
// "...", ".." -> pushToken(ValkyrieTypes.KW_DOTS, r) start with + "++" ->
// pushToken(ValkyrieTypes.OP_INC, r) "+=" -> pushToken(ValkyrieTypes.OP_ADD_ASSIGN, r) "+" ->
// pushToken(ValkyrieTypes.OP_ADD, r) // start with - "--" -> pushToken(ValkyrieTypes.OP_DEC, r)
// "-=" -> pushToken(ValkyrieTypes.OP_SUB_ASSIGN, r) "-" -> pushToken(ValkyrieTypes.OP_SUB, r) //
// start with * "*=" -> pushToken(ValkyrieTypes.OP_MUL_ASSIGN, r) "*" ->
// pushToken(ValkyrieTypes.OP_MUL, r) // start with / "/=" -> pushToken(ValkyrieTypes.OP_DIV_ASSIGN,
// r) "/" -> pushToken(ValkyrieTypes.OP_DIV, r) // start with & "&&=" ->
// pushToken(ValkyrieTypes.OP_AND_ASSIGN, r) "&&" -> pushToken(ValkyrieTypes.OP_AND2, r) "&=" ->
// pushToken(ValkyrieTypes.OP_AND_ASSIGN, r) "&" -> pushToken(ValkyrieTypes.OP_AND, r) // // start
// with ! "!!" -> pushToken(ValkyrieTypes.OP_NE, r) "!=" -> pushToken(ValkyrieTypes.OP_NE, r) "!" ->
// pushToken(ValkyrieTypes.OP_NOT, r) "|" -> pushToken(ValkyrieTypes.OP_OR, r) // start with ? "???"
// -> pushToken(ValkyrieTypes.OP_UNIMPLEMENTED, r) "?" -> pushToken(ValkyrieTypes.OP_QUESTION, r) //
// start with ^ "^" -> pushToken(ValkyrieTypes.OP_POW, r)
// 
// slots "$" -> pushToken(ValkyrieTypes.SLOT_LAMBDA, r) "§" -> pushToken(ValkyrieTypes.SLOT_MACRO,
// r) "¶" -> pushToken(ValkyrieTypes.OP_QUOTE, r) "⟦" -> { pushToken(ValkyrieTypes.SLICE_L, r) }
// 
//
// 
//
// 
//
// 
//
// "⤇", "|=>", "⤃", "!=>" -> { pushToken(ValkyrieTypes.OP_EMPTY, r) }

// keywords
KW_NAMESPACE
    : 'namespace'
    | 'namespace!'
    | 'namespace*'
    | 'namespace?'
    ;
KW_IMPORT:    'using' | 'using!' | 'using*' | 'using?';
KW_EXTENSION: 'extension';
KW_EXTENDS:   'extend' | 'extends';
KW_CLASS:     'class' | 'structure';
KW_TRAIT:     'trait' | 'interface';
KW_UNION:     'union';
KW_BITFLAGS:  'flags';
KW_TYPE:      'type';
KW_LET:       'let';
KW_FUNCTION:  'def';
KW_WITCH:     'which';

KW_WHILE: 'while';
KW_FOR:   'for';

// pushToken(ValkyrieTypes.PATTERN_AND, r) "or" -> pushToken(ValkyrieTypes.PATTERN_OR, r) "which" ->
// pushToken(ValkyrieTypes.KW_WHICH, r) "if" -> pushToken(ValkyrieTypes.KW_IF, r) "else" ->
// pushToken(ValkyrieTypes.KW_ELSE, r) "loop" -> pushToken(ValkyrieTypes.KW_LOOP, r) "while" ->
// pushToken(ValkyrieTypes.KW_WHILE, r) "for" -> pushToken(ValkyrieTypes.KW_FOR, r) "match" ->
// pushToken(ValkyrieTypes.KW_MATCH, r) "when" -> pushToken(ValkyrieTypes.KW_WHEN, r) "case" ->
// pushToken(ValkyrieTypes.KW_CASE, r) "with" -> pushToken(ValkyrieTypes.KW_WITH, r) "let" ->
// pushToken(ValkyrieTypes.KW_BREAK, r) "type" -> pushToken(ValkyrieTypes.KW_TYPE, r)
// 
// "class", "structure", "struct" -> pushToken(ValkyrieTypes.KW_CLASS, r) "union", "tagged", "enum",
// "variant" -> pushToken(ValkyrieTypes.KW_TAGGED, r) "trait", "interface", "convention", "protocol"
// -> pushToken(ValkyrieTypes.KW_TRAIT, r) "bitset", "bitflag" ->
// pushToken(ValkyrieTypes.KW_BITFLAG, r) "extend", "extends", "impl", "implements" ->
// pushToken(ValkyrieTypes.KW_EXTENDS, r) "new", "object" -> pushToken(ValkyrieTypes.KW_NEW, r)

INTEGER: [0] | [1-9][0-9]*;
DECIMAL
    : INTEGER DOT INTEGER EXP? // 1.35, 1.35E-9, 0.3, -4.5
    | INTEGER EXP
    ;
fragment EXP: [Ee] [+\-]? INTEGER;

STRING:       '"' (ESC | ~["\\])* '"';
fragment ESC: '\\' ["\bfnrt];

// conditional
KW_IF:        'if';
KW_ELSE:      'else';
KW_OTHERWISE: 'otherwise';
// control goto
FROM:     'from';
RETURN:   'return';
RESUME:   'resume';
YIELD:    'yield';
BREAK:    'break';
CONTINUE: 'continue';
RAISE:    'raise';
CATCH:    'catch';
// atom
fragment NULL:  'null';
fragment TRUE:  'true';
fragment FALSE: 'false';
SPECIAL:        NULL | TRUE | FALSE;
// atom
UNICODE_ID: [\p{XID_start}] [\p{XID_continue}]*;

// comment
LINE_COMMENT:  '//' .*? ('\n' | EOF) -> channel(HIDDEN);
BLOCK_COMMENT: '/*' .*? '*/' -> channel(HIDDEN);




WHITE_SPACE:     [ \t\n\r]+ -> channel(HIDDEN);
ERROR_CHARACTAR: . -> channel(HIDDEN);

