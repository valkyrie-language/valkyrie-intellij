grammar Valkyrie;
import ValkyrieBasic;
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
    | define_bitflags eos?
    | define_trait eos?
    | define_extends eos?
    | define_function eos?
    | define_type eos?
    | define_variale eos?
    | if_statement eos?
    | while_statement eos?
    | for_statement eos?
    | expression eos?
    ;
eos:      SEMICOLON;
eos_free: COMMA | SEMICOLON;
// ===========================================================================
define_namespace: KW_NAMESPACE namepath_free;
// ===========================================================================
import_statement: KW_IMPORT namepath_free;
// ===========================================================================
define_extension: KW_EXTENSION;
// ===========================================================================
define_class
    : macro_call* KW_CLASS namepath class_inherit? BRACE_L class_statements* BRACE_R
    ;
class_statements: class_method | class_field | eos_free;
class_inherit:    PARENTHESES_L namepath? PARENTHESES_R;
class_field
    : macro_call* modified_identifier type_hint? parameter_default?
    ;
class_method
    : macro_call* modified_namepath function_parameters type_hint? effect_hint? function_block?
    ;
// ===========================================================================
define_trait
    : KW_TRAIT namepath BRACE_L class_statements* BRACE_R
    ;
// ===========================================================================
define_extends
    : KW_EXTENDS namepath BRACE_L class_statements* BRACE_R
    ;
// ===========================================================================
define_union
    : KW_UNION namepath BRACE_L union_statements* BRACE_R
    ;
union_statements: define_function eos?;
// ===========================================================================
define_bitflags
    : KW_BITFLAGS namepath BRACE_L bitflags_statements* BRACE_R
    ;
bitflags_statements: bitflags_item | eos_free;
bitflags_item:       identifier (OP_ASSIGN expression)?;
// ===========================================================================
define_variale: KW_LET identifier OP_ASSIGN expression;
// ===========================================================================
define_function
    : KW_FUNCTION namepath function_parameters type_hint? effect_hint? function_block
    ;
function_parameters
    : PARENTHESES_L parameter_item (COMMA parameter_item)* PARENTHESES_R
    | PARENTHESES_L PARENTHESES_R
    ;
parameter_item
    : macro_call* identifier* type_hint? parameter_default?
    ;
parameter_default: OP_ASSIGN expression;
// ===========================================================================
function_block: BRACE_L function_statements* BRACE_R;

function_statements
    : if_statement eos?
    | while_statement eos?
    | for_statement eos?
    | expression eos?
    ;
// ===========================================================================
define_type: KW_TYPE identifier OP_ASSIGN identifier;
type_hint:   (COLON | OP_ARROW) type_expression;
effect_hint: OP_DIV type_expression;
// ===========================================================================
if_statement
    : KW_IF expression '{' top_statement '}' (
        KW_ELSE '{' top_statement '}'
    )?
    ;
// ===========================================================================
while_statement: KW_WHILE inline_expression function_block;
// ===========================================================================
for_statement
    : KW_FOR for_pattern infix_in inline_expression function_block
    ;
for_pattern: modified_identifier+ (COMMA modified_identifier+)*;


// ===========================================================================
expression
    : expression op_multiple expression
    | expression op_plus expression
    | expression op_logic expression
    | expression op_compare expression
    | expression infix_is type_expression
    | control_expression
    | namepath '(' expr_list? ')'
    | namepath '[' expression ']'
    | term
    ;
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
inline_expression
    : inline_expression op_multiple inline_expression
    | inline_expression op_plus inline_expression
    | inline_expression op_logic inline_expression
    | inline_expression op_compare inline_expression
    | inline_expression infix_is inline_expression
    | term
    ;
term
    : identifier         # EIdentifier
    | number             # ENumber
    | STRING             # EString
    | '(' expression ')' # EParens
    | '[' expr_list ']'  # EVector
    | SPECIAL            # ESpeicalLiteral
    ;

op_compare:  OP_LE | OP_LEQ | OP_GE | OP_GEQ | OP_EQ | OP_NE;
op_pattern:  OP_AND | OP_OR;
op_multiple: OP_MUL | OP_DIV;
op_plus:     OP_ADD | OP_SUB;
op_logic:    LOGIC_OR | LOGIC_AND;
infix_is:    KW_IS | KW_IS KW_NOT;
infix_in:    KW_IN | OP_IN;
// ===========================================================================
type_expression
    : type_expression op_pattern type_expression # TPattern
    | '(' type_expression ')'                    # TParens
    | term                                       # TTerm
    ;

expr_list: expression (COMMA expression)*;

// ===========================================================================
macro_call
    : HASH macro_call_item
    | HASH BRACKET_L macro_call_item (COMMA macro_call_item)* BRACKET_R
    ;
macro_call_item: namepath function_parameters?;
// ===========================================================================
modified_identifier: identifier+;
modified_namepath: identifier+ (OP_PROPORTION identifier)*;
// namepath
namepath_free: identifier ((OP_PROPORTION | DOT) identifier)*;
namepath:      identifier (OP_PROPORTION identifier)*;
// identifier
identifier: UNICODE_ID;
// numbewr
number:        INTEGER number_suffix?;
number_suffix: UNICODE_ID;

