grammar Valkyrie;
options {
	language = Java;
}

top_statement: define_function;

define_function: vardef* function* statement*;

function: 'func' ID '(' formal_args? ')' (':' type)? block;

formal_args: formal_arg (',' formal_arg)*;

formal_arg: ID ':' type;

type:
	'int'		#IntTypeSpec
	| 'float'	#FloatTypeSpec
	| 'string'	#StringTypeSpec
	| 'boolean'	#BooleanTypeSpec
	| '[' ']'	#VectorTypeSpec;

block: '{' (statement | vardef)* '}';

statement:
	'if' '(' expr ')' statement ('else' statement)?	#If
	| 'while' '(' expr ')' statement				#While
	| ID '=' expr									#Assign
	| ID '[' expr ']' '=' expr						#ElementAssign
	| call_expr										#CallStatement
	| 'print' '(' expr? ')'							#Print
	| 'return' expr									#Return
	| block											#BlockStatement;

vardef: 'var' ID '=' expr;

expr:
	expr operator expr	#Op
	| '-' expr			#Negate
	| '!' expr			#Not
	| call_expr			#Call
	| ID '[' expr ']'	#Index
	| '(' expr ')'		#Parens
	| primary			#Atom;

operator:
	MUL
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
	| DOT; // no implicit precedence

call_expr: ID '(' expr_list? ')';

expr_list: expr (',' expr)*;

primary:
	ID					#Identifier
	| INT				#Integer
	| FLOAT				#Float
	| STRING			#String
	| '[' expr_list ']'	#Vector
	| 'true'			#TrueLiteral
	| 'false'			#FalseLiteral;

LPAREN: '(';
RPAREN: ')';
COLON: ':';
COMMA: ',';
LBRACK: '[';
RBRACK: ']';
LBRACE: '{';
RBRACE: '}';
IF: 'if';
ELSE: 'else';
WHILE: 'while';
VAR: 'var';
EQUAL: '=';
RETURN: 'return';
PRINT: 'print';
FUNC: 'func';
TYPEINT: 'int';
TYPEFLOAT: 'float';
TYPESTRING: 'string';
TYPEBOOLEAN: 'boolean';
TRUE: 'true';
FALSE: 'false';
SUB: '-';
BANG: '!';
MUL: '*';
DIV: '/';
ADD: '+';
LT: '<';
LE: '<=';
EQUAL_EQUAL: '==';
NOT_EQUAL: '!=';
GT: '>';
GE: '>=';
OR: '||';
AND: '&&';
DOT: ' . ';

LINE_COMMENT: '//' .*? ('\n' | EOF) -> channel(HIDDEN);
COMMENT: '/*' .*? '*/' -> channel(HIDDEN);

ID: [a-zA-Z_] [a-zA-Z0-9_]*;
INT: [0-9]+;
FLOAT:
	'-'? INT '.' INT EXP? // 1.35, 1.35E-9, 0.3, -4.5
	| '-'? INT EXP ; // 1e10 -3e4
fragment EXP: [Ee] [+\-]? INT;

STRING: '"' (ESC | ~["\\])* '"';
fragment ESC: '\\' ["\bfnrt];

WS: [ \t\n\r]+ -> channel(HIDDEN);

/** "catch all" rule for any char not matche in a token rule of your grammar. Lexers in Intellij
 * must return all tokens good and bad. There must be a token to cover all characters, which makes
 * sense, for an IDE. The parser however should not see these bad tokens because it just confuses
 * the issue. Hence, the hidden channel.
 */
ERRCHAR: . -> channel(HIDDEN);
