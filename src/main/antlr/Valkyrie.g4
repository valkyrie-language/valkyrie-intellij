grammar Valkyrie;
import ValkyrieBasic;
options {
	language = Java;
}

// $antlr-format useTab false, alignColons hanging, alignSemicolons hanging
// $antlr-format alignFirstTokens true

program: top_statement* EOF;
top_statement
    : define_namespace
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
function_statements
    : define_lambda eos?
    | while_statement eos?
    | for_statement eos?
    | expression eos?
    ;
eos:      SEMICOLON;
eos_free: COMMA | SEMICOLON;
// ===========================================================================
define_namespace: KW_NAMESPACE namepath_free eos?;
// ===========================================================================
import_statement: KW_IMPORT namepath_free;
// ===========================================================================
define_extension: KW_EXTENSION;
// ===========================================================================
define_class
    : macro_call* modifiers KW_CLASS identifier define_generic? class_inherit? class_block
    ;
class_block:      BRACE_L class_statements* BRACE_R;
class_statements: class_method | class_field | eos_free;
class_inherit:    PARENTHESES_L namepath? PARENTHESES_R;
class_field
    : macro_call* modified_identifier type_hint? parameter_default?
    ;
class_method
    : macro_call* modified_namepath function_parameters type_hint? effect_hint? function_block?
    ;
// ===========================================================================
define_trait: KW_TRAIT identifier class_block;
// ===========================================================================
define_extends
    : KW_EXTENDS namepath (COLON type_expression) class_block
    ;
// ===========================================================================
define_union:       KW_UNION identifier union_block;
union_block:        BRACE_L union_statements* BRACE_R;
union_statements:   class_method | define_variant | eos_free;
define_variant:     identifier variant_block?;
variant_block:      BRACE_L variant_statements* BRACE_R;
variant_statements: class_field | eos_free;
// ===========================================================================
define_bitflags:     KW_BITFLAGS namepath bitflags_block;
bitflags_block:      BRACE_L bitflags_statements* BRACE_R;
bitflags_statements: bitflags_item | eos_free;
bitflags_item:       identifier (OP_ASSIGN expression)?;
// ===========================================================================
define_type: KW_TYPE identifier OP_ASSIGN identifier;
type_hint:   (COLON | OP_ARROW) type_expression;
effect_hint: OP_DIV type_expression;
// ===========================================================================
define_function
    : macro_call* modifiers KW_FUNCTION namepath function_parameters type_hint? effect_hint? function_block
    ;
function_parameters
    : PARENTHESES_L parameter_item (COMMA parameter_item)* PARENTHESES_R
    | PARENTHESES_L PARENTHESES_R
    ;
parameter_item
    : macro_call* modified_identifier type_hint? parameter_default?
    ;
parameter_default: OP_ASSIGN expression;
function_call:     OP_THROW? '(' function_call_terms? ')';
// ===========================================================================
define_lambda
    : macro_call* KW_LAMBDA function_parameters type_hint? effect_hint? function_block
    ;
lambda_call: OP_THROW? function_block;
// ===========================================================================
function_block: BRACE_L function_statements* BRACE_R;
// ===========================================================================
define_variale: KW_LET identifier OP_ASSIGN expression;
// ===========================================================================
if_statement
    : KW_IF inline_expression function_block else_if_statement* else_statement?
    ;
else_if_statement
    : KW_ELSE KW_IF inline_expression function_block
    ;
else_statement: KW_ELSE function_block;
// ===========================================================================
while_statement: KW_WHILE inline_expression function_block;
// ===========================================================================
for_statement
    : KW_FOR for_pattern infix_in inline_expression if_guard? function_block
    ;
for_pattern
    : for_parameter (COMMA for_parameter)*
    | PARENTHESES_L for_parameter (COMMA for_parameter)* PARENTHESES_R
    ;
for_parameter: identifier+;
if_guard:      KW_IF inline_expression;
// ===========================================================================
expression
    : expression suffix_call
    | expression op_multiple expression
    | expression op_plus expression
    | expression op_logic expression
    | expression op_compare expression
    | expression infix_is type_expression
    | control_expression
    | prefix_call expression
    | term
    ;
inline_expression
    : inline_expression dot_call
    | inline_expression op_multiple inline_expression
    | inline_expression op_plus inline_expression
    | inline_expression op_logic inline_expression
    | inline_expression op_compare inline_expression
    | inline_expression infix_is inline_expression
    | prefix_call inline_expression
    | term
    ;
type_expression
    : type_expression op_pattern type_expression # TPattern
    | type_expression generic_call_in_type       # TParens
    | term                                       # TTerm
    ;
// ===========================================================================
prefix_call: OP_NOT | OP_ADD | OP_SUB;
suffix_call
    : OP_NOT
    | OP_TEMPERATURE
    | slice_call
    | offset_call
    | generic_call
    | lambda_call
    | match_call
    | catch_call
    | dot_call
    | function_call
    ;
control_expression
    : RETURN expression
    | RESUME expression
    | BREAK
    | CONTINUE
    | RAISE expression
    | YIELD RETURN? expression
    | YIELD BREAK expression
    | YIELD KW_WITH expression
    ;
// 带返回值的表达式
term
    : try_statement
    | if_statement
    | new_call
    | namepath
    | number
    | STRING
    | '(' expression ')'
    | '[' expression ']'
    | SPECIAL
    ;

op_compare:  OP_LT | OP_LEQ | OP_GT | OP_GEQ | OP_EQ | OP_NE;
op_pattern:  OP_AND | OP_OR;
op_multiple: OP_MUL | OP_DIV;
op_plus:     OP_ADD | OP_SUB;
op_logic:    LOGIC_OR | LOGIC_AND;
infix_is:    KW_IS | KW_IS KW_NOT;
infix_in:    KW_IN | OP_IN;
// ===========================================================================
function_call_terms: expression (COMMA expression)*;
define_generic
    : OP_PROPORTION? OP_LT identifier OP_GT
    | GENERIC_L identifier GENERIC_R
    ;

generic_call
    : OP_PROPORTION OP_LT identifier OP_GT
    | GENERIC_L identifier GENERIC_R
    ;
generic_call_in_type
    : OP_PROPORTION? OP_LT identifier OP_GT
    | GENERIC_L identifier GENERIC_R
    ;
// ===========================================================================
dot_call: OP_THROW? DOT identifier;
// ===========================================================================
slice_call: BRACKET_L expression BRACKET_R;
offset_call
    : OP_PROPORTION BRACKET_L expression BRACKET_R
    | OFFSET_L expression OFFSET_R
    ;
// ===========================================================================
macro_call
    : HASH macro_call_item
    | HASH BRACKET_L macro_call_item (COMMA macro_call_item)* BRACKET_R
    ;
macro_call_item: namepath function_parameters?;
// ===========================================================================
try_statement: KW_TRY type_expression function_block;

// ===========================================================================
match_call:  OP_THROW? DOT KW_MATCH type_expression match_block;
catch_call:  OP_THROW? DOT KW_CATCH type_expression match_block;
match_block: BRACE_L match_statement* BRACE_R;
match_statement
    : when_block
    | else_pattern
    | case_pattern
    | eos_free
    ;
with_block
    : macro_call* KW_WITH identifier
    | KW_WITH '[' identifier? ']'
    ;
when_block
    : macro_call* KW_WHEN inline_expression COLON expression*
    ;
else_pattern: macro_call* KW_ELSE COLON expression*;
case_pattern
    : macro_call* KW_CASE identifier '(' identifier? ')' if_guard? COLON expression*
    ;
// ===========================================================================
new_call
    : macro_call* KW_NEW modified_namepath generic_call_in_type? new_body
    ;
new_body
    : '(' function_call_terms? ')' new_block
    | '(' function_call_terms? ')'
    | new_block
    ;
new_block:     BRACE_L new_statement* BRACE_R;
new_statement: new_kv | eos_free;
new_kv:        identifier (COLON expression)?;
// ===========================================================================
modifiers:           identifier*;
modified_identifier: identifier+;
modified_namepath:   identifier+ (OP_PROPORTION identifier)*;
// namepath
namepath_free: identifier ((OP_PROPORTION | DOT) identifier)*;
namepath:      identifier (OP_PROPORTION identifier)*;
// identifier
identifier: UNICODE_ID | RAW_ID;
// numbewr
number: DECIMAL identifier? | INTEGER identifier?;
