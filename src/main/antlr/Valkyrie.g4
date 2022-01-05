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
    | define_type eos?
    | define_variale eos?
    | if_statement eos?
    | while_statement eos?
    | expression eos?
    ;
eos: SEMICOLON;
// ===========================================================================
define_namespace: KW_NAMESPACE namepath_free;
// ===========================================================================
import_statement: KW_IMPORT namepath_free;
// ===========================================================================
define_extension: KW_EXTENSION;
// ===========================================================================
define_class
    : KW_CLASS namepath class_inherit? BRACE_L class_statements* BRACE_R
    ;
class_statements: define_method eos?;
class_inherit:    PARENTHESES_L namepath? PARENTHESES_R;
// ===========================================================================
define_trait
    : KW_TRAIT namepath BRACE_L trait_statements* BRACE_R
    ;
trait_statements: define_method eos?;
// ===========================================================================
define_union
    : KW_UNION namepath BRACE_L union_statements* BRACE_R
    ;
union_statements: define_function eos?;
// ===========================================================================
define_variale: KW_LET identifier OP_EQ expression;
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
// ===========================================================================
define_method: identifier PARENTHESES_L PARENTHESES_R;
// ===========================================================================
define_type: KW_TYPE identifier OP_EQ identifier;
type_hint:   (COLON | OP_ARROW) type_expression;
// ===========================================================================
if_statement
    : 'if' '(' expression ')' '{' top_statement '}' (
        'else' '{' top_statement '}'
    )?
    ;
// ===========================================================================
while_statement
    : 'while' '(' expression ')' '{' top_statement '}'
    ;
// ===========================================================================
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
// ===========================================================================
type_expression
    : type_expression infix type_expression # TOp
    | '(' type_expression ')'               # TParens
    | term                                  # TTerm
    ;




call_expr: namepath '(' expr_list? ')';

expr_list: expression (COMMA expression)*;

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

// namepath
namepath_free: identifier ((OP_PROPORTION | DOT) identifier)*;
namepath:      identifier (OP_PROPORTION identifier)*;
// identifier
identifier: UNICODE_ID;
// numbewr
number:        INTEGER number_suffix?;
number_suffix: UNICODE_ID;

