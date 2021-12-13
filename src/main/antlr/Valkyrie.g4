grammar Valkyrie;
options {
	language = Java;
}
// $antlr-format useTab false, alignColons hanging, alignSemicolons hanging
// $antlr-format alignFirstTokens true

top_statement: define_function;

define_function: vardef* function* statement*;

function: 'func' ID '(' formal_args? ')' (':' type)? block;

formal_args: formal_arg (',' formal_arg)*;

formal_arg: ID ':' type;

type
    : 'int'     # IntTypeSpec
    | 'float'   # FloatTypeSpec
    | 'string'  # StringTypeSpec
    | 'boolean' # BooleanTypeSpec
    | '[' ']'   # VectorTypeSpec
    ;

block: '{' (statement | vardef)* '}';

statement
    : 'if' '(' expr ')' statement ('else' statement)? # If
    | 'while' '(' expr ')' statement                  # While
    | ID '=' expr                                     # Assign
    | ID '[' expr ']' '=' expr                        # ElementAssign
    | call_expr                                       # CallStatement
    | 'print' '(' expr? ')'                           # Print
    | 'return' expr                                   # Return
    | block                                           # BlockStatement
    ;

vardef: 'var' ID '=' expr;

expr
    : expr operator expr # Op
    | '-' expr           # Negate
    | '!' expr           # Not
    | call_expr          # Call
    | ID '[' expr ']'    # Index
    | '(' expr ')'       # Parens
    | primary            # Atom
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

call_expr: ID '(' expr_list? ')';

expr_list: expr (',' expr)*;

primary
    : ID                # Identifier
    | INT               # Integer
    | FLOAT             # Float
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
IF:     'if';
ELSE:   'else';
WHILE:  'while';
VAR:    'var';
EQUAL:  '=';
// controls
RETURN:   'return';
YIELD:    'yield';
BREAK:    'break';
CONTINUE: 'continue';
// atom
NULL:  'αλφαβητον';
TRUE:  'true';
FALSE: 'false';

TYPEINT:     'int';
TYPEFLOAT:   'float';
TYPESTRING:  'string';
TYPEBOOLEAN: 'boolean';

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

LINE_COMMENT: '//' .*? ('\n' | EOF) -> channel(HIDDEN);
COMMENT:      '/*' .*? '*/' -> channel(HIDDEN);

ID:  [a-zA-Z_] [a-zA-Z0-9_]*;
INT: [0-9]+;
FLOAT
    : '-'? INT '.' INT EXP? // 1.35, 1.35E-9, 0.3, -4.5
    | '-'? INT EXP
    ;
fragment EXP: [Ee] [+\-]? INT;

STRING:       '"' (ESC | ~["\\])* '"';
fragment ESC: '\\' ["\bfnrt];

WS: [ \t\n\r]+ -> channel(HIDDEN);

ERRCHAR: . -> channel(HIDDEN);
