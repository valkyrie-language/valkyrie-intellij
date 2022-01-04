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
    | if_statement eos?
    | while_statement eos?
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
define_trait
    : KW_TRAIT namepath BRACE_L trait_statements* BRACE_R
    ;
trait_statements: define_method eos?;

KW_TRAIT: 'trait' | 'interface';
// ===========================================================================
define_union
    : KW_UNION namepath BRACE_L union_statements* BRACE_R
    ;
union_statements: define_function eos?;

KW_UNION: 'union';
// ===========================================================================
define_variale: KW_LET identifier OP_EQ expression;

KW_LET: 'let';
// ===========================================================================
define_function
    : KW_FUNCTION namepath function_parameters type_hint? BRACE_L function_statements* BRACE_R
    ;
function_parameters
    : PARENTHESES_L function_parameter_item (
        COMMA function_parameter_item
    )* PARENTHESES_R
    | PARENTHESES_L PARENTHESES_R
    ;
function_parameter_item: identifier type_hint?;

function_statements: top_statement | define_variale;

KW_FUNCTION: 'def';
// ===========================================================================
define_method: identifier PARENTHESES_L PARENTHESES_R;

// ===========================================================================

type_hint: (COLON | OP_ARROW) type;
type
    : 'int'     # IntTypeSpec
    | 'float'   # FloatTypeSpec
    | 'string'  # StringTypeSpec
    | 'boolean' # BooleanTypeSpec
    | '[' ']'   # VectorTypeSpec
    ;

if_statement
    : 'if' '(' expression ')' '{' top_statement '}' (
        'else' '{' top_statement '}'
    )?
    ;

while_statement
    : 'while' '(' expression ')' '{' top_statement '}'
    ;

type_expression
    : type_expression infix type_expression # TOp
    | '(' type_expression ')'               # TParens
    | term                                  # TTerm
    ;

expression
    : expression infix expression   # Op
    | '-' expression                # Negate
    | call_expr                     # Call
    | identifier '[' expression ']' # Index
    | '(' expression ')'            # Parens
    | control_expression            # Control
    | term                          # ETerm
    ;

term
    : identifier        # EIdentifier
    | number            # ENumber
    | STRING            # EString
    | '[' expr_list ']' # EVector
    | SPECIAL           # ESpeicalLiteral
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
    // | OP_EE | OP_NE
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
control_expression
    : RETURN expression
    | RESUME expression
    | BREAK
    | CONTINUE
    | RAISE expression
    | YIELD RETURN? expression
    | YIELD BREAK expression
    | YIELD FROM expression
    ;

FROM:     'from';
RETURN:   'return';
RESUME:   'resume';
YIELD:    'yield';
BREAK:    'break';
CONTINUE: 'continue';
RAISE:    'raise';
CATCH:    'catch';

// namepath
namepath_free: identifier ((OP_PROPORTION | DOT) identifier)*;
namepath:      identifier (OP_PROPORTION identifier)*;
// identifier
identifier: UNICODE_ID;
// numbewr
number:        INTEGER number_suffix?;
number_suffix: UNICODE_ID;

INTEGER: [0] | [1-9][0-9]+;
DECIMAL
    : INTEGER DOT INTEGER EXP? // 1.35, 1.35E-9, 0.3, -4.5
    | INTEGER EXP
    ;
fragment EXP: [Ee] [+\-]? INTEGER;

STRING:       '"' (ESC | ~["\\])* '"';
fragment ESC: '\\' ["\bfnrt];



