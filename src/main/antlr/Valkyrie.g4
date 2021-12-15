grammar Valkyrie;
import XID;
options {
	language = Java;
}
// $antlr-format useTab false, alignColons hanging, alignSemicolons hanging
// $antlr-format alignFirstTokens true

program: top_statement* EOF;
top_statement
    : define_class EOS?
    | define_variale EOS?
    | define_function EOS?
    ;
EOS: ';';
// ===========================================================================
define_class
    : KW_CLASS name = UNICODE_ID '{' class_statements* '}'
    ;
class_statements: define_function EOS?;
KW_CLASS: 'class';
// ===========================================================================
define_variale: 'let' name = UNICODE_ID '=' expr;
// ===========================================================================
define_function
    : 'def' UNICODE_ID '(' formal_args? ')' (':' type)? block
    ;
// ===========================================================================
formal_args: formal_arg (',' formal_arg)*;

formal_arg: UNICODE_ID ':' type;

type
    : 'int'     # IntTypeSpec
    | 'float'   # FloatTypeSpec
    | 'string'  # StringTypeSpec
    | 'boolean' # BooleanTypeSpec
    | '[' ']'   # VectorTypeSpec
    ;

block: '{' (statement | define_variale)* '}';

statement
    : 'if' '(' expr ')' statement ('else' statement)? # If
    | 'while' '(' expr ')' statement                  # While
    | UNICODE_ID '=' expr                             # Assign
    | UNICODE_ID '[' expr ']' '=' expr                # ElementAssign
    | call_expr                                       # CallStatement
    | 'print' '(' expr? ')'                           # Print
    | 'return' expr                                   # Return
    | block                                           # BlockStatement
    ;

expr
    : expr operator expr      # Op
    | '-' expr                # Negate
    | '!' expr                # Not
    | call_expr               # Call
    | UNICODE_ID '[' expr ']' # Index
    | '(' expr ')'            # Parens
    | primary                 # Atom
    ;

operator
    : MUL
    | DIV
    | ADD
    | SUB
    | GT
    | GE
    | LT
    | LE
    | EQUAL_EQUAL
    | NOT_EQUAL
    | OR
    | AND
    | DOT
    ;

call_expr: UNICODE_ID '(' expr_list? ')';

expr_list: expr (',' expr)*;

primary
    : UNICODE_ID        # Identifier
    | INTEGER           # Integer
    | DECIMAL           # Float
    | STRING            # String
    | '[' expr_list ']' # Vector
    | 'true'            # TrueLiteral
    | 'false'           # FalseLiteral
    ;

LPAREN: '(';
RPAREN: ')';
COLON:  ':';
COMMA:  ',';
LBRACK: '[';
RBRACK: ']';
LBRACE: '{';
RBRACE: '}';

KW_NAMESPACE
    : 'namespace'
    | 'namespace!'
    | 'namespace*'
    | 'namespace?'
    ;

// "using", "using!", "using*", "using?" -> pushToken(ValkyrieTypes.KW_IMPORT, r) "as", "as?",
// "as!", "as*" -> pushToken(ValkyrieTypes.OP_AS, r) "is" -> pushToken(ValkyrieTypes.OP_IS_A, r)
// "in" -> pushToken(ValkyrieTypes.OP_IN, r) "not" -> pushToken(ValkyrieTypes.OP_NOT, r) "and" ->
// pushToken(ValkyrieTypes.PATTERN_AND, r) "or" -> pushToken(ValkyrieTypes.PATTERN_OR, r) "which" ->
// pushToken(ValkyrieTypes.KW_WHICH, r) "if" -> pushToken(ValkyrieTypes.KW_IF, r) "else" ->
// pushToken(ValkyrieTypes.KW_ELSE, r) "loop" -> pushToken(ValkyrieTypes.KW_LOOP, r) "while" ->
// pushToken(ValkyrieTypes.KW_WHILE, r) "for" -> pushToken(ValkyrieTypes.KW_FOR, r) "match" ->
// pushToken(ValkyrieTypes.KW_MATCH, r) "when" -> pushToken(ValkyrieTypes.KW_WHEN, r) "case" ->
// pushToken(ValkyrieTypes.KW_CASE, r) "with" -> pushToken(ValkyrieTypes.KW_WITH, r) "let" ->
// pushToken(ValkyrieTypes.KW_LET, r) "def" -> pushToken(ValkyrieTypes.KW_DEF, r) ->
// pushToken(ValkyrieTypes.KW_BREAK, r) "type" -> pushToken(ValkyrieTypes.KW_TYPE, r)
// 
// "class", "structure", "struct" -> pushToken(ValkyrieTypes.KW_CLASS, r) "union", "tagged", "enum",
// "variant" -> pushToken(ValkyrieTypes.KW_TAGGED, r) "trait", "interface", "convention", "protocol"
// -> pushToken(ValkyrieTypes.KW_TRAIT, r) "bitset", "bitflag" ->
// pushToken(ValkyrieTypes.KW_BITFLAG, r) "extend", "extends", "impl", "implements" ->
// pushToken(ValkyrieTypes.KW_EXTENDS, r) "new", "object" -> pushToken(ValkyrieTypes.KW_NEW, r)
IF:    'if';
ELSE:  'else';
WHILE: 'while';
VAR:   'var';
//
EQUAL: '=';
// controls
RETURN:   'return';
RESUME:   'resume';
YIELD:    'yield';
BREAK:    'break';
CONTINUE: 'continue';
RAISE:    'raise';
CATCH:    'catch';
// atom
NULL:  'αλφαβητον';
TRUE:  'true';
FALSE: 'false';
// infix
SUB:         '-';
BANG:        '!';
MUL:         '*';
DIV:         '/';
ADD:         '+';
LT:          '<';
LE:          '<=';
EQUAL_EQUAL: '==';
NOT_EQUAL:   '!=';
GT:          '>';
GE:          '>=';
OR:          '||';
AND:         '&&';
DOT:         ' . ';
// comment
LINE_COMMENT: '//' .*? ('\n' | EOF) -> channel(HIDDEN);
COMMENT:      '/*' .*? '*/' -> channel(HIDDEN);
// identifier

INTEGER: [0-9]+;
DECIMAL
    : INTEGER '.' INTEGER EXP? // 1.35, 1.35E-9, 0.3, -4.5
    | INTEGER EXP
    ;
fragment EXP: [Ee] [+\-]? INTEGER;

STRING:       '"' (ESC | ~["\\])* '"';
fragment ESC: '\\' ["\bfnrt];

WS: [ \t\n\r]+ -> channel(HIDDEN);

ERRCHAR: . -> channel(HIDDEN);
