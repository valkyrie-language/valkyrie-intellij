lexer grammar ValkyrieBasic;
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
GENERIC_L:    '⦓';
GENERIC_R:    '⦔';
OFFSET_L:     '⁅';
OFFSET_R:    '⁆';
// infix
OP_ADD: '+';
OP_INC: '++';
OP_SUB: '-';
OP_DEC: '--';
OP_MUL: '*';
OP_DIV: '/';
// equal
OP_EQ: '==';
OP_NE: '!=';
// compare
OP_LT:  '<';
OP_LL:  '≪' | '<<';
OP_LLL: '⋘' | '<<<';
OP_LEQ: '⩽' | '≤' | '<=';
OP_GT:  '>';
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

// macro call
AT:   '@';
HASH: '#' | '##' | '#!';
// macro slot
LAMBDA_SLOT: '$' | '$$';
MACRO_SLOT: '§' | '§§';
// monadic
OP_OR_ELSE: '??';
OP_THROW: '?';
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
OP_POW:  '^';
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
// 
//
// 
//
// "...", ".." -> pushToken(ValkyrieTypes.KW_DOTS, r) start with + "++" ->
// pushToken(ValkyrieTypes.OP_INC, r) "+=" -> pushToken(ValkyrieTypes.OP_ADD_ASSIGN, r) "+" ->
// pushToken(ValkyrieTypes.OP_ADD, r) // start with - "--" -> pushToken(ValkyrieTypes.OP_DEC, r)
// r) "¶" -> pushToken(ValkyrieTypes.OP_QUOTE, r) "⟦" -> { pushToken(ValkyrieTypes.SLICE_L, r) }
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
KW_FUNCTION:  'function' | 'micro' | 'macro';
KW_LAMBDA:    'lambda';
KW_WITCH:     'which';
KW_WHILE: 'while';
KW_FOR:   'for';
KW_NEW: 'new' | 'object';
// pattern match
KW_TRY: 'try';
KW_MATCH: 'match';
KW_CATCH: 'catch';
KW_WITH: 'with';
KW_CASE: 'case';
KW_WHEN: 'when';
// number
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
//FROM:     'from';
RETURN:   'return';
RESUME:   'resume';
YIELD:    'yield';
BREAK:    'break';
CONTINUE: 'continue';
RAISE:    'raise';
// atom
fragment NULL:  'null';
fragment TRUE:  'true';
fragment FALSE: 'false';
SPECIAL:        NULL | TRUE | FALSE;
// atom
RAW_ID:     '`' ~[`]+ '`';
UNICODE_ID: [_\p{XID_start}] [\p{XID_continue}]*;

// comment
LINE_COMMENT:  '//' .*? ('\n' | EOF) -> channel(HIDDEN);
BLOCK_COMMENT: '/*' .*? '*/' -> channel(HIDDEN);

WHITE_SPACE:     [ \t\n\r]+ -> channel(HIDDEN);
ERROR_CHARACTAR: . -> channel(HIDDEN);

