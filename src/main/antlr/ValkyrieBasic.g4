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
OP_LEQ: '⩽' | '≤' | '<=';
OP_LLL: '⋘' | '<' '<' '<';
OP_LL:  '≪' | '<' '<';
OP_LT:  '<';
OP_GEQ: '⩾' | '≥' | '>=';
OP_GGG: '⋙' | '>' '>' '>';
OP_GG:  '≫' | '>' '>';
OP_GT:  '>';
// arrow
OP_BIND:   '←' | '<-';
OP_ARROW:  '⟶' | '->';
OP_ARROW2: '⇒' | '=>';
// assign
OP_ASSIGN:     '=';
OP_ADD_ASSIGN: '+=';
OP_SUB_ASSIGN: '-=';
OP_MUL_ASSIGN: '*=';
OP_DIV_ASSIGN: '/=';
// logical
LOGIC_NOT:  '¬';
LOGIC_AND:  '&&' | '∧';
LOGIC_OR:   '||' | '∨';
LOGIC_XOR:  '⊻';
LOGIC_NOR:  '⊽';
LOGIC_NAND: '⊼';
// bitwise
OP_AND:  '&';
OP_OR:   '|';
OP_XOR:  '⊕';
OP_EQV:  '≡';
OP_IMPL: '‽';
OP_IFF:  '⇔';

// macro call
OP_AT:   '@';
OP_HASH: '#' | '##' | '#!';
// macro slot
LAMBDA_SLOT: '$' | '$$';
MACRO_SLOT:  '§' | '§§';
// monadic
OP_UNIMPLEMENTED: '⅏' | '???';
OP_OR_ELSE:       '??';
OP_THROW:         '?';
// not
OP_NOT: '!';
KW_NOT: 'not';
// in
OP_IN:        '∈' | '∊';
KW_IN:        'in';
OP_NOT_IN:    '∉';
OP_CONTINUES: '∋' | '∍';

// is
KW_IS:     'is';
OP_IS:     '⊑' | '<:';
OP_IS_NOT: '⋢' | '<!';
// as
KW_AS: 'as' | 'as!' | 'as*';
// until
OP_DECONSTRUCT: '...' | '..';
OP_UNTIL:       '..<' | '..=';
OP_POW:         '^';
// suffix
OP_TEMPERATURE: '℃' | '℉';
// standalone
OP_REFERENCE: '※';
OP_LABEL:     '¶';

// DOT ":=", "≔" -> pushToken(ValkyrieTypes.PATTERN_SET, r) "->", "==", "≡" ->
// pushToken(ValkyrieTypes.OP_EQ, r) "...", ".." -> pushToken(ValkyrieTypes.KW_DOTS, r) r) "¶" ->
// pushToken(ValkyrieTypes.OP_QUOTE, r) "⤇", "|=>", "⤃", "!=>" -> {
// pushToken(ValkyrieTypes.OP_EMPTY, r) }

// keywords
KW_NAMESPACE: 'namespace' ('!' | '*' | '?')?;
KW_IMPORT:    'using' ('!' | '*' | '?')?;
KW_EXTENSION: 'extension';
// 
KW_CLASS:    'class' | 'structure';
KW_TRAIT:    'trait' | 'interface';
KW_UNION:    'union';
KW_BITFLAGS: 'flags';
KW_TYPE:     'type';
//
KW_TEMPLATE:   'template' | 'generic' | 'forall';
KW_EXTENDS:    'extend' | 'extends';
KW_IMPLEMENTS: 'implement' | 'implements';
KW_WHERE:      'where';
//
KW_WHILE: 'while' | 'until';
KW_FOR:   'for';
//
KW_LET:      'let';
KW_WITCH:    'which';
KW_NEW:      'new';
KW_OBJECT:   'object';
KW_LAMBDA:   'lambda';
KW_FUNCTION: 'function' | 'micro' | 'macro';
// pattern match
KW_TRY:   'try';
KW_MATCH: 'match';
KW_CATCH: 'catch';
KW_WITH:  'with';
KW_CASE:  'case';
KW_WHEN:  'when';
// number
INTEGER: [0] | [1-9][0-9]*;
DECIMAL
    : INTEGER DOT INTEGER EXP? // 1.35, 1.35E-9, 0.3, -4.5
    | INTEGER EXP
    ;
fragment EXP: [Ee] [+\-]? INTEGER;

STRING_SINGLE: '\'' ~[']* '\'';
STRING_DOUBLE: '"' ~["]* '"';

// conditional
KW_IF:        'if';
KW_ELSE:      'else';
KW_OTHERWISE: 'otherwise';
// control goto FROM: 'from';
RETURN:   'return';
RESUME:   'resume';
YIELD:    'yield';
BREAK:    'break';
CONTINUE: 'continue';
RAISE:    'raise';
// atom
SPECIAL: 'true' | 'false' | 'null' | 'nil' | '∅';
// atom
RAW_ID:     '`' ~[`]+ '`';
UNICODE_ID: [_\p{XID_start}] [\p{XID_continue}]*;

// comment
LINE_COMMENT:  '//' ~[\r\n]* -> channel(HIDDEN);
BLOCK_COMMENT: '/*' .*? '*/' -> channel(HIDDEN);

WHITE_SPACE:     [\p{White_Space}]+ -> channel(HIDDEN);
ERROR_CHARACTAR: . -> channel(HIDDEN);
