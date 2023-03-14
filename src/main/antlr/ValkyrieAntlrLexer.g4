lexer grammar ValkyrieAntlrLexer;
// $antlr-format useTab false, alignColons hanging, alignSemicolons hanging
// $antlr-format alignFirstTokens true
@lexer::members {

} 

DOT:        '.';
COMMA:      ',' | '，';
SEMICOLON:  ';';
FAKE_COLON: '⁏' | ';;';

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
GENERIC_L:     '⟨';
GENERIC_R:     '⟩';
OFFSET_L:      '⁅';
OFFSET_R:      '⁆';
RANGE_L:       '⟦';
RANGE_R:       '⟧';
CEILING_L:     '⌈';
CEILING_R:     '⌉';
FLOOR_L:       '⌊';
FLOOR_R:       '⌋';
COLLECTION_L:  '⦃';
COLLECTION_R:  '⦄';

// add
OP_ADD: '+';
OP_SUB: '-';
// append
OP_INC: '++';
OP_DEC: '--';
// mul
OP_MUL:     '*';
OP_DIV:     '⁄' | '∕' | '/';
OP_REM:     '⁒';
OP_DIV_REM: '/%' | '÷';

// equal
OP_EQ:  '==';
OP_NE:  '≠' | '!=';
OP_NEE: '≢' | '!==' | '=!=';
OP_EEE: '≡' | '===';
// compare
OP_LEQ: '⩽' | '≤' | '<=';
OP_LLE: '<<=';
OP_LLL: '⋘' ;
OP_LL:  '≪' ;
OP_LT:  '<';
OP_GEQ: '⩾' | '≥' | '>=';
OP_GGE: '>>=';
OP_GGG: '⋙' ;
OP_GG:  '≫' ;
OP_GT:  '>';
// arrow
OP_ARROW:  '⟶' | '->';
OP_ARROW2: '⇒' | '=>';
OP_ARROW3: '==>';

// assign
OP_ASSIGN:     '=';
OP_BIND:       '←' | '<-';
OP_MAY_ASSIGN: '?=';
OP_ADD_ASSIGN: '+=';
OP_SUB_ASSIGN: '-=';
OP_MUL_ASSIGN: '*=';
OP_DIV_ASSIGN: '/=';
// not
OP_BANG: '!';
OP_NOT:  '¬';
KW_NOT:  'not';
// logical
LOGIC_AND:  '&&' | '∧';
LOGIC_XAND: '⩟';
LOGIC_NAND: '⊼';
LOGIC_OR:   '||' | '∨';
LOGIC_XOR:  '⊻';
LOGIC_NOR:  '⊽';
// set
SET_INTERSECTION: '∩';
SET_UNION:        '∪';
// bitwise
OP_AND:    '&';
OP_OR:     '|';
OP_IMPL:   '‽';
OP_IFF:    '⇔';
OP_MAP:    '/@' | '⇴' | '⨵';
OP_APPLY2: '@@' | '⊕';
OP_APPLY3: '@@@' | '⟴';

// macro call
OP_AT:   '@';
OP_HASH: '#' | '##' | '#!';
// macro slot
LAMBDA_SLOT: '$' | '$$';
MACRO_SLOT:  '§' | '§§';
// monadic
OP_UNIMPLEMENTED: '⅏' | '⍼' | '⟁' | '???';
OP_OR_DEFAULT:    '??';
OP_OR_ELSE:       '?:';
OP_AND_THEN:      '?';
// in
OP_IN:        '∈' | '∊';
KW_IN:        'in';
OP_NOT_IN:    '∉';
OP_CONTINUES: '∋' | '∍';
// is
KW_IS:       'is';
OP_SUP_TYPE: ':>';
OP_IS:       '⊑' | '<:';
OP_IS_NOT:   '⋢' | '<!';
// as
KW_AS: 'as' [!?]?;
// until
OP_DOT3:  '…' | '...';
OP_DOT2:  '‥' | '..';
OP_UNTIL: '..<' | '..=';
OP_POW:   '^';
// prefix
MAIN_PREFIX: [⅟∛∜];
OP_ROOT2:    '√';
// suffix
MAIN_SUFFIX:  [℃℉‰‱′″‴⁗];
OP_TRANSPOSE: '⊤' | '†' | '⊹'; // ᵀ,ᴴ are XIDs
OP_PERCENT:   '%';
// standalone
OP_REFERENCE: '※';
OP_LABEL:     '¶';
OP_OUTPUT:    '⛤' | '⛥' | '⛦';
OP_LAST:      '⛧' | '%%';
// keywords
KW_NAMESPACE: 'namespace' [!*?]?;
KW_IMPORT:    'using' [!*?]?;
KW_EXTENSION: 'extension';
// 
KW_CLASS: 'class' | 'structure' | 'vague' | 'fluid';
KW_TRAIT: 'trait' | 'interface';
KW_FLAGS: 'flags' | 'enumerate';
KW_UNION: 'unite' | 'union' | 'variant' | 'inductive';
KW_TYPE:  'typus';
//
KW_TEMPLATE:   'template' | 'generic' | 'constraint';
KW_EXTENDS:    'extends' | 'extend' | 'imply';
KW_IMPLEMENTS: 'implements';
//
KW_WHILE: 'while' | 'until';
KW_FOR:   'for';
//
KW_LET:      'let';
KW_NEW:      'new';
KW_OBJECT:   'object';
KW_LAMBDA:   'lambda';
KW_FUNCTION: 'function' | 'func' | 'fun' | 'fn' | 'micro' | 'macro';
// pattern match
KW_TRY:   'try';
KW_MATCH: 'match' | 'catch';
KW_SWITCH: 'switch';
KW_WITH:  'with';
KW_CASE:  'case';
KW_WHEN:  'when';
KW_WHERE: 'where';
// number
INTEGER: [0] | [1-9]([_]?[0-9])*;
DECIMAL
    : INTEGER DOT INTEGER EXP? // 1.35, 1.35E-9, 0.3, -4.5
    | INTEGER EXP
    ;
fragment EXP: [Ee] [+\-]? INTEGER;
              // $antlr-format off
STRING_START: '\'' -> pushMode(IN_STRING1);
STRING_DOUBLE: '"' -> type(STRING_START), pushMode(IN_STRING2);
STRING_TRIPLE:  '\'\'\'' -> type(STRING_START), pushMode(IN_STRING3);
STRING_SIXFOLD: '"""' -> type(STRING_START), pushMode(IN_STRING6);
// $antlr-format on
// conditional
KW_IF:        'if';
KW_ELSE:      'else';
KW_OTHERWISE: 'otherwise';
// control goto FROM: 'from';
RETURN:       'return';
RESUME:       'resume';
YIELD:        'yield';
BREAK:        'break';
CONTINUE:     'continue';
FALL_THROUGH: 'fallthrough';
RAISE:        'raise';
// atom
SPECIAL: 'true' | 'false' | 'null' | 'nil' | [∅∞⧝⧞];
// atom
RAW_ID:     '`' ~[`]+ '`';
UNICODE_ID: [_\p{XID_start}\p{Emoji_Presentation}] [\p{XID_continue}\p{Emoji}]*;

// comment
LINE_COMMENT:  ([🗨⍝]|[\\][\\]) ~[\r\n]* -> channel(HIDDEN);
BLOCK_COMMENT: '🗨🗨🗨' .*? '🗩🗩🗩' -> channel(HIDDEN);

WHITE_SPACE:     [\p{White_Space}]+ -> channel(HIDDEN);
ERROR_CHARACTAR: . -> channel(HIDDEN);

// $antlr-format off
mode IN_STRING1;
STRING_TEXT: ~[']+;
STRING_END:  '\'' -> popMode;

mode IN_STRING2;
STRING_TEXT2: ~["]+ -> type(STRING_TEXT);
STRING_OUT2:  '"' -> type(STRING_END), popMode;

mode IN_STRING3;
STRING_TEXT3: ~[']+ -> type(STRING_TEXT);
ESCAPE_TEXT:  '\'' -> type(STRING_TEXT);
STRING_OUT3:  '\'\'\'' -> type(STRING_END), popMode;

mode IN_STRING6;
STRING_TEXT6: ~["]+ -> type(STRING_TEXT);
ESCAPE_TEXT6: '"' -> type(STRING_TEXT);
STRING_OUT6:  '"""' -> type(STRING_END), popMode;
