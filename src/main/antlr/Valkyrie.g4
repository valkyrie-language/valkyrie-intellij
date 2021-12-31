grammar Valkyrie;
import ValkyrieOperators, XID;
options {
	language = Java;
}

// $antlr-format useTab false, alignColons hanging, alignSemicolons hanging
// $antlr-format alignFirstTokens true

program: top_statement* EOF;
top_statement
    : define_namespace eos?
    | import_statement eos?
    | define_extension eos?
    | define_class eos?
    | define_union eos?
    | define_trait eos?
    | define_function eos?
    | define_variale eos?
    | expression eos?
    ;
eos: SEMICOLON;
// ===========================================================================
define_namespace: KW_NAMESPACE namepath_free;
KW_NAMESPACE
    : 'namespace'
    | 'namespace!'
    | 'namespace*'
    | 'namespace?'
    ;
// ===========================================================================
import_statement: KW_IMPORT namepath_free;

KW_IMPORT: 'using' | 'using!' | 'using*' | 'using?';
// ===========================================================================
define_extension: KW_EXTENSION;

KW_EXTENSION: 'extension';
// ===========================================================================
define_class
    : KW_CLASS namepath class_inherit? BRACE_L class_statements* BRACE_R
    ;
class_statements: define_method eos?;
class_inherit:    PARENTHESES_L namepath? PARENTHESES_R;

KW_EXTENDS: 'extend' | 'extends';
KW_CLASS:   'class' | 'structure';
// ===========================================================================
define_trait:     KW_TRAIT namepath BRACE_L trait_statements* BRACE_R;
trait_statements: define_method eos?;

KW_TRAIT: 'trait' | 'interface';
// ===========================================================================
define_union:     KW_UNION namepath BRACE_L union_statements* BRACE_R;
union_statements: define_function eos?;

KW_UNION: 'union';
// ===========================================================================
define_variale: KW_LET namepath '=' expression;

KW_LET: 'let';
// ===========================================================================
define_function
    : KW_FUNCTION namepath PARENTHESES_L formal_args? PARENTHESES_R type_hint? function_block
    ;

KW_FUNCTION: 'def';
// ===========================================================================
define_method: identifier PARENTHESES_L PARENTHESES_R;

// ===========================================================================
formal_args: formal_arg (COMMA formal_arg)*;

formal_arg: UNICODE_ID COLON type;

type_hint: (COLON | '->') type;
type
    : 'int'     # IntTypeSpec
    | 'float'   # FloatTypeSpec
    | 'string'  # StringTypeSpec
    | 'boolean' # BooleanTypeSpec
    | '[' ']'   # VectorTypeSpec
    ;

function_block: '{' (statement | define_variale)* '}';

statement
    : 'if' '(' expression ')' statement ('else' statement)? # If
    | 'while' '(' expression ')' statement                  # While
    | identifier '=' expression                             # Assign
    | identifier '[' expression ']' '=' expression                # ElementAssign
    | call_expr                                       # CallStatement
    | 'print' '(' expression? ')'                           # Print
    | 'return' expression                                   # Return
    | function_block                                  # BlockStatement
    ;

type_expression
    : type_expression infix type_expression      # TOp
    | '(' type_expression ')'            # TParens
    | identifier        # TIdentifier
    | number            # TNumber
    | STRING            # String
    | '[' expr_list ']' # Vector
    | SPECIAL            # SpeicalLiteral
    ;

expression
    : expression infix expression      # Op
    | '-' expression                # Negate
    | '!' expression                # Not
    | call_expr               # Call
    | identifier '[' expression ']' # Index
    | '(' expression ')'            # Parens
    | identifier        # EIdentifier
    | number            # ENumber
    | STRING            # EString
    | '[' expr_list ']' # EVector
    | SPECIAL            # ESpeicalLiteral
    ;

infix
    : MUL
    | DIV
    | ADD
    | SUB
    | GT
    | GE
    | LT
    | LE
    | EQUAL_EQUAL
    | OP_NE
    | OR
    | AND
    | DOT
    | KW_IS
    | KW_IS KW_NOT
    ;

KW_AS:  'as' | 'as!' | 'as*';
KW_IS:  'is';
KW_IN:  'in';
KW_NOT: 'not';

call_expr: namepath '(' expr_list? ')';

expr_list: expression (COMMA expression)*;

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
IF:    'if';
ELSE:  'else';
WHILE: 'while';

// controls
RETURN:   'return';
RESUME:   'resume';
YIELD:    'yield';
BREAK:    'break';
CONTINUE: 'continue';
RAISE:    'raise';
CATCH:    'catch';

// namepath
namepath_free: identifier ((OP_PROPORTION|DOT) identifier)*;
namepath:      identifier (OP_PROPORTION identifier)*;
// identifier
identifier: UNICODE_ID;
// numbewr
number: INTEGER number_suffix?;
number_suffix: UNICODE_ID;





INTEGER: [0] | [1-9][0-9]+;
DECIMAL
    : INTEGER '.' INTEGER EXP? // 1.35, 1.35E-9, 0.3, -4.5
    | INTEGER EXP
    ;
fragment EXP: [Ee] [+\-]? INTEGER;

STRING:       '"' (ESC | ~["\\])* '"';
fragment ESC: '\\' ["\bfnrt];

WS: [ \t\n\r]+ -> channel(HIDDEN);

ERRCHAR: . -> channel(HIDDEN);
