grammar ValkyrieAntlr;
import ValkyrieBasic;
options {
	language = Java;
}

// $antlr-format useTab false, columnLimit 144
// $antlr-format alignColons hanging, alignSemicolons hanging, alignFirstTokens true
program
    : (
        define_namespace
        | import_statement
        | define_extension
        | define_class
        | define_union
        | define_bitflags
        | define_trait
        | define_extends
        | define_function
        | define_type
        | define_variale
        | if_statement
        | while_statement
        | for_statement
        | expression
        | eos
    )* EOF
    ;
function_statements
    : define_lambda
    | define_variale
    | while_statement
    | for_statement
    | expression
    | eos
    ;
eos:      SEMICOLON;
eos_free: COMMA | SEMICOLON;
// ===========================================================================
define_namespace: KW_NAMESPACE namepath_free eos?;
// ===========================================================================
import_statement: KW_IMPORT import_term;
import_as:        KW_AS (OP_AT | OP_HASH)? identifier;
import_term
    : import_block
    | OP_AT namepath_free import_as?
    | OP_AT namepath_free ((OP_PROPORTION | DOT)? import_block)?
    | OP_HASH namepath_free import_as?
    | OP_HASH namepath_free ((OP_PROPORTION | DOT)? import_block)?
    | namepath_free import_as?
    | namepath_free ((OP_PROPORTION | DOT)? import_block)?
    | eos_free
    ;
import_block: BRACE_L BRACE_R | BRACE_L import_term* BRACE_R;
// ===========================================================================
define_extension: KW_EXTENSION;
// ===========================================================================
define_class
    : template_call? annotation* modifiers KW_CLASS identifier define_generic? class_inherit? type_hint? class_block eos?
    ;
class_block:      BRACE_L class_statements* BRACE_R;
class_statements: class_method | class_field | eos_free;
class_inherit
    : PARENTHESES_L PARENTHESES_R
    | PARENTHESES_L class_inherit_item (COMMA class_inherit_item)* COMMA? PARENTHESES_R
    ;
class_inherit_item: modified_namepath;
class_field:        annotation* modified_identifier type_hint? parameter_default?;
class_method
    : annotation* modified_namepath define_generic? function_parameters type_hint? effect_hint? function_block?
    ;
// ===========================================================================
define_trait
    : template_call? annotation* modifiers KW_TRAIT identifier define_generic? impliments? trait_block eos?
    ;
trait_block:       BRACE_L trait_statements* BRACE_R;
trait_statements:  define_trait_type | class_method | class_field | eos_free;
define_trait_type: KW_TYPE identifier (OP_ASSIGN type_expression)?;
// ===========================================================================
define_extends
    : template_call? annotation* modifiers KW_EXTENDS namepath define_generic? impliments? trait_block
    ;
impliments: (COLON | KW_IMPLEMENTS) type_expression;
// ===========================================================================
define_union:       KW_UNION identifier union_block;
union_block:        BRACE_L union_statements* BRACE_R;
union_statements:   class_method | define_variant | eos_free;
define_variant:     identifier variant_block?;
variant_block:      BRACE_L variant_statements* BRACE_R;
variant_statements: class_field | eos_free;
// ===========================================================================
define_bitflags: KW_BITFLAGS namepath bitflags_layout? type_hint? bitflags_block;
bitflags_layout: PARENTHESES_L type_expression? PARENTHESES_R;
bitflags_block:  BRACE_L (bitflags_item | eos_free)* BRACE_R;
bitflags_item:   annotation* identifier (OP_ASSIGN expression)?;
// ===========================================================================
define_function
    : template_call? annotation* modifiers KW_FUNCTION namepath generic_call? function_parameters type_hint? effect_hint? function_block
    ;
function_parameters
    : PARENTHESES_L PARENTHESES_R
    | PARENTHESES_L parameter_item (COMMA parameter_item)* PARENTHESES_R
    ;
parameter_item:    annotation* modified_identifier type_hint? parameter_default?;
parameter_default: OP_ASSIGN expression;
// ===========================================================================
function_call
    : OP_THROW? tuple_call_body // method?(b)
    ;
dot_call
    : OP_THROW? DOT identifier tuple_call_body? // ?.method()
    ;
tuple_call_body
    : PARENTHESES_L PARENTHESES_R
    | PARENTHESES_L tuple_call_item (COMMA tuple_call_item)* COMMA? PARENTHESES_R
    ;
tuple_call_item: identifier COLON expression | expression;
// ===========================================================================
define_lambda: annotation* KW_LAMBDA function_parameters type_hint? function_block;
lambda_call:   OP_THROW? function_block;
// ===========================================================================
function_block: BRACE_L function_statements* BRACE_R;
// ===========================================================================
define_variale:    KW_LET let_pattern type_hint? (OP_ASSIGN expression)?;
let_pattern:       let_pattern_tuple | let_pattern_block | let_pattern_plain;
let_pattern_plain: modified_identifier (COMMA modified_identifier)* COMMA?;
let_pattern_tuple
    : namepath? PARENTHESES_L PARENTHESES_R
    | namepath? PARENTHESES_L let_pattern_item (COMMA let_pattern_item)* COMMA? PARENTHESES_R
    ;
let_pattern_block
    : namepath? BRACE_L BRACE_R
    | namepath? BRACE_L let_pattern_pair (COMMA let_pattern_pair)* COMMA? BRACE_R
    ;
let_pattern_item
    : (bind = identifier OP_BIND)? let_pattern_tuple
    | (bind = identifier OP_BIND)? let_pattern_block
    | (modifier += identifier)* OP_DECONSTRUCT bind = identifier?
    | (modifier += identifier)* bind = identifier
    ;
let_pattern_pair
    : (modified_identifier COLON)? (identifier OP_BIND)? let_pattern_tuple
    | (modified_identifier COLON)? (identifier OP_BIND)? let_pattern_block
    | (modified_identifier COLON)? OP_DECONSTRUCT bind = identifier?
    | (modified_identifier COLON)? bind = identifier
    ;
// ===========================================================================
define_type: KW_TYPE identifier OP_ASSIGN identifier;
type_hint:   (COLON | OP_ARROW) type_expression;
effect_hint: OP_DIV type_expression;
// ===========================================================================
if_statement:      KW_IF inline_expression function_block else_if_statement* else_statement?;
else_if_statement: KW_ELSE KW_IF inline_expression function_block;
else_statement:    KW_ELSE function_block;
// ===========================================================================
while_statement
    : annotation* KW_WHILE inline_expression function_block                              # WhileExpression
    | annotation* KW_WHILE KW_LET let_pattern OP_ASSIGN inline_expression function_block # WhileLet
    ;
for_statement
    : annotation* KW_FOR let_pattern infix_in inline_expression if_guard? function_block
    ;
if_guard: KW_IF inline_expression;
// ===========================================================================
expression
    : expression suffix_call
    | expression op_multiple expression
    | expression op_plus expression
    | expression op_logic expression
    | expression op_compare expression
    | expression OP_UNTIL expression
    | expression infix_is type_expression
    | expression op_assign type_expression
    | control_expression
    | prefix_call expression
    | PARENTHESES_L expression PARENTHESES_R
    | try_statement
    | if_statement
    | match_statement
    | catch_statement
    | new_call
    | macro_call
    | function_call
    | define_label
    | collection_literal
    | string_literal
    | number_literal
    | namepath
    | SPECIAL
    ;
inline_expression
    : inline_expression dot_call
    | inline_expression op_multiple inline_expression
    | inline_expression op_plus inline_expression
    | inline_expression op_logic inline_expression
    | inline_expression op_compare inline_expression
    | inline_expression infix_is inline_expression
    | inline_expression OP_UNTIL inline_expression
    | prefix_call inline_expression
    | inline_expression slice_call
    | try_statement
    | if_statement
    | match_statement
    | catch_statement
    | new_call
    | macro_call
    | function_call
    | collection_literal
    | string_literal
    | number_literal
    | namepath
    | SPECIAL
    ;
type_expression
    : type_expression op_pattern type_expression   # TPattern
    | type_expression infix_arrows type_expression # TArrows
    | type_expression OP_ADD type_expression       # TAdd
    | type_expression generic_call_in_type         # TGeneric
    | string_literal                               # TStrig
    | number_literal                               # TNumber
    | namepath                                     # TNamepath
    | SPECIAL                                      # TSpecial
    ;
// ===========================================================================
prefix_call: OP_NOT | OP_ADD | OP_SUB | OP_AND | OP_REFERENCE | OP_DECONSTRUCT;
suffix_call
    : OP_NOT
    | OP_TEMPERATURE
    | slice_call
    | offset_call
    | generic_call
    | lambda_call
    | match_call
    | catch_call
    | function_call
    | dot_call
    ;
control_expression
    : RETURN expression?
    | RESUME expression
    | BREAK (OP_LABEL identifier)?
    | CONTINUE (OP_LABEL identifier)?
    | RAISE expression
    | YIELD (OP_LABEL identifier)? expression?
    | YIELD BREAK
    | YIELD KW_WITH expression
    ;
// 带返回值的表达式, 能作为表达式的开头

op_compare:   OP_LT | OP_LEQ | OP_GT | OP_GEQ | OP_EQ | OP_NE;
op_pattern:   OP_AND | OP_OR;
infix_arrows: OP_ARROW | OP_ARROW2;
op_multiple:  OP_MUL | OP_DIV;
op_plus:      OP_ADD | OP_SUB;
op_logic:     LOGIC_OR | LOGIC_AND | LOGIC_XOR | LOGIC_NOR | LOGIC_NAND;
op_assign:    OP_ASSIGN | OP_ADD_ASSIGN | OP_SUB_ASSIGN | OP_MUL_ASSIGN | OP_DIV_ASSIGN;
infix_is:     KW_IS | KW_IS KW_NOT;
infix_in:     KW_IN | OP_IN;
// ===========================================================================
define_generic
    : GENERIC_L GENERIC_R
    | GENERIC_L generic_item (COMMA generic_item)* COMMA? GENERIC_R
    | OP_PROPORTION? OP_LT OP_GT
    | OP_PROPORTION? OP_LT generic_item (COMMA generic_item)* COMMA? OP_GT
    ;
generic_item: (identifier COLON)? type_expression;
generic_call
    : OP_PROPORTION OP_LT OP_GT
    | OP_PROPORTION OP_LT type_expression (COMMA type_expression)* COMMA? OP_GT
    | GENERIC_L GENERIC_R
    | GENERIC_L type_expression (COMMA type_expression)* COMMA? GENERIC_R
    ;
generic_call_in_type
    : OP_PROPORTION? OP_LT type_expression OP_GT
    | GENERIC_L type_expression GENERIC_R
    ;
define_label: OP_LABEL identifier;
// ===========================================================================
offset_call: OP_PROPORTION BRACKET_L expression BRACKET_R | OFFSET_L expression OFFSET_R;
// ===========================================================================
template_call
    : annotation* modifiers KW_TEMPLATE template_block
    | annotation* modifiers KW_TEMPLATE identifier (COMMA identifier)* COMMA? template_block
    ;
template_block: BRACE_L tempalte_terms* BRACE_R;
tempalte_terms: KW_WHERE where_block | eos_free;
where_block:    BRACE_L where_bound* BRACE_R;
where_bound:    identifier COLON type_expression | eos_free;
// ===========================================================================
macro_call: OP_AT macro_call_name function_parameters?;
annotation
    : OP_HASH annotation_call_item
    | OP_HASH BRACKET_L annotation_call_item (COMMA annotation_call_item)* BRACKET_R
    ;
annotation_call_item: macro_call_name function_parameters?;
// ===========================================================================
try_statement: KW_TRY type_expression? function_block;
// ===========================================================================
match_statement: KW_MATCH inline_expression match_block;
catch_statement: KW_CATCH inline_expression match_block;
// ===========================================================================
match_call:  OP_THROW? DOT KW_MATCH type_expression? match_block;
catch_call:  OP_THROW? DOT KW_CATCH type_expression? match_block;
match_block: BRACE_L match_terms* BRACE_R;
match_terms
    : annotation* KW_WITH identifier                                    # MatchWith
    | annotation* KW_WITH BRACKET_L identifier? BRACKET_R               # MatchWithMany
    | annotation* KW_WHEN inline_expression match_case_block            # MatchWhen
    | annotation* KW_ELSE match_case_block                              # MatchElse
    | annotation* KW_CASE pattern_expression if_guard? match_case_block # MatchCase
    | eos_free                                                          # MatchSkip
    ;
match_case_block: COLON expression*;
pattern_expression
    : pattern_expression OP_BIND pattern_expression
    | pattern_expression OP_UNTIL pattern_expression
    | case_term
    | number_literal
    | string_literal
    ;
case_term
    : PARENTHESES_L (case_pair (COMMA case_pair)* COMMA?) PARENTHESES_R
    | namepath PARENTHESES_L (case_pair (COMMA case_pair)* COMMA?) PARENTHESES_R
    | BRACKET_L (case_pair (COMMA case_pair)* COMMA?) BRACKET_R
    ;
case_pair: identifier+;
// ===========================================================================
new_call: annotation* KW_NEW modified_namepath generic_call_in_type? new_body;
new_body
    : tuple_call_body? new_block // 可选
    | tuple_call_body // 必选
    ;
new_block:     BRACE_L new_statement* BRACE_R;
new_statement: tuple_call_item | eos_free;
// ===========================================================================
collection_literal
    : BRACKET_L BRACKET_R
    | BRACKET_L collection_pair (COMMA collection_pair)* COMMA? BRACKET_R
    | PARENTHESES_L PARENTHESES_R
    | PARENTHESES_L collection_pair (COMMA collection_pair)+ COMMA? PARENTHESES_R
    | PARENTHESES_L collection_pair COMMA PARENTHESES_R
    ;
collection_pair: (identifier COLON)? expression;
// ===========================================================================

// ===========================================================================
slice_call: OP_THROW? range_literal;
range_literal
    : BRACKET_L (range_axis (COMMA range_axis)* COMMA?)? BRACKET_R # Ordinal
    | OFFSET_L (range_axis (COMMA range_axis)* COMMA?)? OFFSET_R   # Offset
    ;
range_axis
    : COLON // [:]
    | OP_PROPORTION // [::]
    | range_start (COLON range_end)? (COLON range_step)?
    ;
range_start: inline_expression;
range_end:   inline_expression;
range_step:  inline_expression;
// ===========================================================================
modifiers:           identifier*;
modified_identifier: identifier+;
modified_namepath:   identifier+ (OP_PROPORTION identifier)*;
// namepath
macro_call_name: identifier (OP_PROPORTION identifier)* (DOT identifier)?;
namepath_free:   identifier ((OP_PROPORTION | DOT) identifier)*;
namepath:        identifier (OP_PROPORTION identifier)*;
// identifier
identifier: UNICODE_ID | RAW_ID;
// numbewr
number:         DECIMAL | INTEGER;
number_literal: number identifier?;
// string
string:         STRING_SINGLE | STRING_DOUBLE;
string_literal: identifier? string;
