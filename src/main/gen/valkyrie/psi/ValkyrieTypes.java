// This is a generated file. Not intended for manual editing.
package valkyrie.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import valkyrie.psi.node.*;

public interface ValkyrieTypes {

    IElementType ANNOTATIONS = new ValkyrieElementType("ANNOTATIONS");
    IElementType ARGUMENT = new ValkyrieElementType("ARGUMENT");
    IElementType ARGUMENT_BODY = new ValkyrieElementType("ARGUMENT_BODY");
    IElementType ATOMIC = new ValkyrieElementType("ATOMIC");
    IElementType ATTRIBUTE = new ValkyrieElementType("ATTRIBUTE");
    IElementType BLOCK_BARE = new ValkyrieElementType("BLOCK_BARE");
    IElementType BLOCK_BODY = new ValkyrieElementType("BLOCK_BODY");
    IElementType BLOCK_STATEMENT = new ValkyrieElementType("BLOCK_STATEMENT");
    IElementType CATCH_STATEMENT = new ValkyrieElementType("CATCH_STATEMENT");
    IElementType CLASS_BODY = new ValkyrieElementType("CLASS_BODY");
    IElementType CLASS_INHERIT = new ValkyrieElementType("CLASS_INHERIT");
    IElementType CLASS_INHERIT_BODY = new ValkyrieElementType("CLASS_INHERIT_BODY");
    IElementType CLASS_ITEM = new ValkyrieElementType("CLASS_ITEM");
    IElementType CONTROL_STATEMENT = new ValkyrieElementType("CONTROL_STATEMENT");
    IElementType DECLARE_CLASS = new ValkyrieElementType("DECLARE_CLASS");
    IElementType DECLARE_ENUMERATE = new ValkyrieElementType("DECLARE_ENUMERATE");
    IElementType DECLARE_FIELD = new ValkyrieElementType("DECLARE_FIELD");
    IElementType DECLARE_FLAGS = new ValkyrieElementType("DECLARE_FLAGS");
    IElementType DECLARE_FUNCTION = new ValkyrieElementType("DECLARE_FUNCTION");
    IElementType DECLARE_GENERIC = new ValkyrieElementType("DECLARE_GENERIC");
    IElementType DECLARE_IMPLY = new ValkyrieElementType("DECLARE_IMPLY");
    IElementType DECLARE_METHOD = new ValkyrieElementType("DECLARE_METHOD");
    IElementType DECLARE_NAMESPACE = new ValkyrieElementType("DECLARE_NAMESPACE");
    IElementType DECLARE_SEMANTIC = new ValkyrieElementType("DECLARE_SEMANTIC");
    IElementType DECLARE_TRAIT = new ValkyrieElementType("DECLARE_TRAIT");
    IElementType DECLARE_UNION = new ValkyrieElementType("DECLARE_UNION");
    IElementType DECLARE_UNITE = new ValkyrieElementType("DECLARE_UNITE");
    IElementType DECLARE_VARIABLE = new ValkyrieElementType("DECLARE_VARIABLE");
    IElementType DEFAULT_TYPE = new ValkyrieElementType("DEFAULT_TYPE");
    IElementType DEFAULT_VALUE = new ValkyrieElementType("DEFAULT_VALUE");
    IElementType DOT_CALL = new ValkyrieElementType("DOT_CALL");
    IElementType DOT_CALL_CATCH = new ValkyrieElementType("DOT_CALL_CATCH");
    IElementType DOT_CALL_MATCH = new ValkyrieElementType("DOT_CALL_MATCH");
    IElementType EFFECT_TYPE = new ValkyrieElementType("EFFECT_TYPE");
    IElementType ELSE_IF_STATEMENT = new ValkyrieElementType("ELSE_IF_STATEMENT");
    IElementType ELSE_STATEMENT = new ValkyrieElementType("ELSE_STATEMENT");
    IElementType ENUMERATE_BODY = new ValkyrieElementType("ENUMERATE_BODY");
    IElementType ENUMERATE_ITEM = new ValkyrieElementType("ENUMERATE_ITEM");
    IElementType EXPRESSION = new ValkyrieElementType("EXPRESSION");
    IElementType FOR_STATEMENT = new ValkyrieElementType("FOR_STATEMENT");
    IElementType FUNCTION_CALL = new ValkyrieElementType("FUNCTION_CALL");
    IElementType GENERIC_ARGUMENT = new ValkyrieElementType("GENERIC_ARGUMENT");
    IElementType GENERIC_CALL = new ValkyrieElementType("GENERIC_CALL");
    IElementType GENERIC_CALL_ASCII_BODY = new ValkyrieElementType("GENERIC_CALL_ASCII_BODY");
    IElementType GENERIC_CALL_FREE = new ValkyrieElementType("GENERIC_CALL_FREE");
    IElementType GENERIC_CALL_STANDARD_BODY = new ValkyrieElementType("GENERIC_CALL_STANDARD_BODY");
    IElementType GENERIC_PARAMETER = new ValkyrieElementType("GENERIC_PARAMETER");
    IElementType IDENTIFIER = new ValkyrieElementType("IDENTIFIER");
    IElementType IDENTIFIER_FREE = new ValkyrieElementType("IDENTIFIER_FREE");
    IElementType IF_CASE_STATEMENT = new ValkyrieElementType("IF_CASE_STATEMENT");
    IElementType IF_CONDITION = new ValkyrieElementType("IF_CONDITION");
    IElementType IF_STATEMENT = new ValkyrieElementType("IF_STATEMENT");
    IElementType INFIX = new ValkyrieElementType("INFIX");
    IElementType INLINE_EXPRESSION = new ValkyrieElementType("INLINE_EXPRESSION");
    IElementType INLINE_STATEMENT = new ValkyrieElementType("INLINE_STATEMENT");
    IElementType IS_NOT = new ValkyrieElementType("IS_NOT");
    IElementType MACRO_CALL = new ValkyrieElementType("MACRO_CALL");
    IElementType MATCH_BODY = new ValkyrieElementType("MATCH_BODY");
    IElementType MATCH_CASE = new ValkyrieElementType("MATCH_CASE");
    IElementType MATCH_ELSE = new ValkyrieElementType("MATCH_ELSE");
    IElementType MATCH_ITEM = new ValkyrieElementType("MATCH_ITEM");
    IElementType MATCH_STATEMENT = new ValkyrieElementType("MATCH_STATEMENT");
    IElementType MATCH_WHEN = new ValkyrieElementType("MATCH_WHEN");
    IElementType MATCH_WITH = new ValkyrieElementType("MATCH_WITH");
    IElementType MODIFIER = new ValkyrieElementType("MODIFIER");
    IElementType NAMEPATH = new ValkyrieElementType("NAMEPATH");
    IElementType NAMEPATH_FREE = new ValkyrieElementType("NAMEPATH_FREE");
    IElementType NEW_LAMBDA = new ValkyrieElementType("NEW_LAMBDA");
    IElementType NEW_OBJECT = new ValkyrieElementType("NEW_OBJECT");
    IElementType NEW_VALUE = new ValkyrieElementType("NEW_VALUE");
    IElementType NUMBER = new ValkyrieElementType("NUMBER");
    IElementType OFFSET_RANGE = new ValkyrieElementType("OFFSET_RANGE");
    IElementType ORDINAL_RANGE = new ValkyrieElementType("ORDINAL_RANGE");
    IElementType OTHERWISE_KIND = new ValkyrieElementType("OTHERWISE_KIND");
    IElementType OTHERWISE_STATEMENT = new ValkyrieElementType("OTHERWISE_STATEMENT");
    IElementType PARAMETER_BODY = new ValkyrieElementType("PARAMETER_BODY");
    IElementType PARAMETER_ITEM = new ValkyrieElementType("PARAMETER_ITEM");
    IElementType PATTERN = new ValkyrieElementType("PATTERN");
    IElementType PATTERN_ATOMIC = new ValkyrieElementType("PATTERN_ATOMIC");
    IElementType PATTERN_BARE = new ValkyrieElementType("PATTERN_BARE");
    IElementType PATTERN_OBJECT = new ValkyrieElementType("PATTERN_OBJECT");
    IElementType PATTERN_OBJECT_BODY = new ValkyrieElementType("PATTERN_OBJECT_BODY");
    IElementType PATTERN_PAIR = new ValkyrieElementType("PATTERN_PAIR");
    IElementType PATTERN_SEQUENCE = new ValkyrieElementType("PATTERN_SEQUENCE");
    IElementType PATTERN_SEQUENCE_BODY = new ValkyrieElementType("PATTERN_SEQUENCE_BODY");
    IElementType PATTERN_UNAPPLY = new ValkyrieElementType("PATTERN_UNAPPLY");
    IElementType PATTERN_UNAPPLY_BODY = new ValkyrieElementType("PATTERN_UNAPPLY_BODY");
    IElementType PREFIX = new ValkyrieElementType("PREFIX");
    IElementType RANGE_INDEX = new ValkyrieElementType("RANGE_INDEX");
    IElementType RANGE_ITEM = new ValkyrieElementType("RANGE_ITEM");
    IElementType RANGE_LOWER = new ValkyrieElementType("RANGE_LOWER");
    IElementType RANGE_STEP = new ValkyrieElementType("RANGE_STEP");
    IElementType RANGE_UPPER = new ValkyrieElementType("RANGE_UPPER");
    IElementType RETURN_TYPE = new ValkyrieElementType("RETURN_TYPE");
    IElementType SPECIAL = new ValkyrieElementType("SPECIAL");
    IElementType STRING = new ValkyrieElementType("STRING");
    IElementType SUFFIX = new ValkyrieElementType("SUFFIX");
    IElementType TAG_BRANCH = new ValkyrieElementType("TAG_BRANCH");
    IElementType TERM = new ValkyrieElementType("TERM");
    IElementType TRAIT_ALIAS = new ValkyrieElementType("TRAIT_ALIAS");
    IElementType TRY_STATEMENT = new ValkyrieElementType("TRY_STATEMENT");
    IElementType TUPLE = new ValkyrieElementType("TUPLE");
    IElementType TYPE_ALIAS = new ValkyrieElementType("TYPE_ALIAS");
    IElementType TYPE_ATOMIC = new ValkyrieElementType("TYPE_ATOMIC");
    IElementType TYPE_EXPRESSION = new ValkyrieElementType("TYPE_EXPRESSION");
    IElementType TYPE_HINT = new ValkyrieElementType("TYPE_HINT");
    IElementType TYPE_INFIX = new ValkyrieElementType("TYPE_INFIX");
    IElementType TYPE_PREFIX = new ValkyrieElementType("TYPE_PREFIX");
    IElementType TYPE_SUFFIX = new ValkyrieElementType("TYPE_SUFFIX");
    IElementType TYPE_TERM = new ValkyrieElementType("TYPE_TERM");
    IElementType UNION_BODY = new ValkyrieElementType("UNION_BODY");
    IElementType UNION_VARIANT = new ValkyrieElementType("UNION_VARIANT");
    IElementType USING = new ValkyrieElementType("USING");
    IElementType USING_ALIAS = new ValkyrieElementType("USING_ALIAS");
    IElementType USING_ANY = new ValkyrieElementType("USING_ANY");
    IElementType USING_BLOCK = new ValkyrieElementType("USING_BLOCK");
    IElementType USING_BODY = new ValkyrieElementType("USING_BODY");
    IElementType USING_EXCLUDE = new ValkyrieElementType("USING_EXCLUDE");
    IElementType USING_TERM = new ValkyrieElementType("USING_TERM");
    IElementType WHILE_KIND = new ValkyrieElementType("WHILE_KIND");
    IElementType WHILE_STATEMENT = new ValkyrieElementType("WHILE_STATEMENT");

    IElementType ANGLE_L = new ValkyrieTokenType("<");
    IElementType ANGLE_R = new ValkyrieTokenType(">");
    IElementType AT = new ValkyrieTokenType("@");
    IElementType BIND = new ValkyrieTokenType("=");
    IElementType BRACE_L = new ValkyrieTokenType("{");
    IElementType BRACE_R = new ValkyrieTokenType("}");
    IElementType BRACKET_L = new ValkyrieTokenType("[");
    IElementType BRACKET_R = new ValkyrieTokenType("]");
    IElementType COLON = new ValkyrieTokenType(":");
    IElementType COLOR = new ValkyrieTokenType("COLOR");
    IElementType COMMA = new ValkyrieTokenType(",");
    IElementType COMMENT_BLOCK = new ValkyrieTokenType("Comment Block");
    IElementType COMMENT_LINE = new ValkyrieTokenType("Comment");
    IElementType DOLLAR = new ValkyrieTokenType("$");
    IElementType DOT = new ValkyrieTokenType(".");
    IElementType EQUAL = new ValkyrieTokenType("EQUAL");
    IElementType ESCAPED = new ValkyrieTokenType("\\escaped");
    IElementType GENERIC_L = new ValkyrieTokenType("GENERIC_L");
    IElementType GENERIC_R = new ValkyrieTokenType("GENERIC_R");
    IElementType HASH = new ValkyrieTokenType("HASH");
    IElementType HYPHEN = new ValkyrieTokenType("-");
    IElementType INTEGER = new ValkyrieTokenType("<<INTEGER>>");
    IElementType KW_AS = new ValkyrieTokenType("as");
    IElementType KW_BREAK = new ValkyrieTokenType("KW_BREAK");
    IElementType KW_CASE = new ValkyrieTokenType("KW_CASE");
    IElementType KW_CATCH = new ValkyrieTokenType("KW_CATCH");
    IElementType KW_CLASS = new ValkyrieTokenType("class");
    IElementType KW_CLIMB = new ValkyrieTokenType("climb");
    IElementType KW_CONTINUE = new ValkyrieTokenType("KW_CONTINUE");
    IElementType KW_ELSE = new ValkyrieTokenType("KW_ELSE");
    IElementType KW_ENUMERATE = new ValkyrieTokenType("KW_ENUMERATE");
    IElementType KW_EXCLUDE = new ValkyrieTokenType("KW_EXCLUDE");
    IElementType KW_FALSE = new ValkyrieTokenType("KW_FALSE");
    IElementType KW_FLAGS = new ValkyrieTokenType("KW_FLAGS");
    IElementType KW_FOR = new ValkyrieTokenType("KW_FOR");
    IElementType KW_FUNCTION = new ValkyrieTokenType("KW_FUNCTION");
    IElementType KW_GRAMMAR = new ValkyrieTokenType("grammar");
    IElementType KW_GROUP = new ValkyrieTokenType("group");
    IElementType KW_IF = new ValkyrieTokenType("KW_IF");
    IElementType KW_IMPLY = new ValkyrieTokenType("KW_IMPLY");
    IElementType KW_IMPORT = new ValkyrieTokenType("import");
    IElementType KW_IN = new ValkyrieTokenType("KW_IN");
    IElementType KW_IS = new ValkyrieTokenType("KW_IS");
    IElementType KW_LAMBDA = new ValkyrieTokenType("KW_LAMBDA");
    IElementType KW_LET = new ValkyrieTokenType("KW_LET");
    IElementType KW_MACRO = new ValkyrieTokenType("macro");
    IElementType KW_MATCH = new ValkyrieTokenType("KW_MATCH");
    IElementType KW_NAMESPACE = new ValkyrieTokenType("KW_NAMESPACE");
    IElementType KW_NEW = new ValkyrieTokenType("KW_NEW");
    IElementType KW_NIL = new ValkyrieTokenType("KW_NIL");
    IElementType KW_NOT = new ValkyrieTokenType("KW_NOT");
    IElementType KW_NULL = new ValkyrieTokenType("KW_NULL");
    IElementType KW_OBJECT = new ValkyrieTokenType("KW_OBJECT");
    IElementType KW_OTHERWISE = new ValkyrieTokenType("KW_OTHERWISE");
    IElementType KW_RAISE = new ValkyrieTokenType("KW_RAISE");
    IElementType KW_RESUME = new ValkyrieTokenType("KW_RESUME");
    IElementType KW_RETURN = new ValkyrieTokenType("KW_RETURN");
    IElementType KW_THROUGH = new ValkyrieTokenType("KW_THROUGH");
    IElementType KW_TRAIT = new ValkyrieTokenType("KW_TRAIT");
    IElementType KW_TRUE = new ValkyrieTokenType("KW_TRUE");
    IElementType KW_TRY = new ValkyrieTokenType("KW_TRY");
    IElementType KW_TYPE = new ValkyrieTokenType("KW_TYPE");
    IElementType KW_UNION = new ValkyrieTokenType("union");
    IElementType KW_UNITE = new ValkyrieTokenType("KW_UNITE");
    IElementType KW_UNTIL = new ValkyrieTokenType("KW_UNTIL");
    IElementType KW_USING = new ValkyrieTokenType("using");
    IElementType KW_WHEN = new ValkyrieTokenType("KW_WHEN");
    IElementType KW_WHILE = new ValkyrieTokenType("KW_WHILE");
    IElementType KW_WITH = new ValkyrieTokenType("KW_WITH");
    IElementType KW_YIELD = new ValkyrieTokenType("KW_YIELD");
    IElementType OFFSET_L = new ValkyrieTokenType("OFFSET_L");
    IElementType OFFSET_R = new ValkyrieTokenType("OFFSET_R");
    IElementType OP_AND = new ValkyrieTokenType("OP_AND");
    IElementType OP_AND_THEN = new ValkyrieTokenType("OP_AND_THEN");
    IElementType OP_ARROW1 = new ValkyrieTokenType("OP_ARROW1");
    IElementType OP_BANG = new ValkyrieTokenType("OP_BANG");
    IElementType OP_CONCAT = new ValkyrieTokenType("~");
    IElementType OP_EQ = new ValkyrieTokenType("OP_EQ");
    IElementType OP_MANY = new ValkyrieTokenType("*");
    IElementType OP_MINUS = new ValkyrieTokenType("OP_MINUS");
    IElementType OP_NE = new ValkyrieTokenType("OP_NE");
    IElementType OP_OR = new ValkyrieTokenType("|");
    IElementType OP_PLUS = new ValkyrieTokenType("OP_PLUS");
    IElementType OP_REMARK = new ValkyrieTokenType("^");
    IElementType OP_UNTIL = new ValkyrieTokenType("OP_UNTIL");
    IElementType PARENTHESIS_L = new ValkyrieTokenType("(");
    IElementType PARENTHESIS_R = new ValkyrieTokenType(")");
    IElementType PLACE_HOLDER = new ValkyrieTokenType("_");
    IElementType PROPORTION = new ValkyrieTokenType("PROPORTION");
    IElementType REFERENCE = new ValkyrieTokenType("$Symbol");
    IElementType SELECTION_LINE = new ValkyrieTokenType("SELECTION_LINE");
    IElementType SEMICOLON = new ValkyrieTokenType(";");
    IElementType SLASH = new ValkyrieTokenType("/");
    IElementType STAR = new ValkyrieTokenType("STAR");
    IElementType SYMBOL = new ValkyrieTokenType("Symbol");
    IElementType SYMBOW_RAW = new ValkyrieTokenType("SYMBOW_RAW");
    IElementType TEXT_DOUBLE = new ValkyrieTokenType("TEXT_DOUBLE");
    IElementType TEXT_SINGLE = new ValkyrieTokenType("TEXT_SINGLE");
    IElementType TO = new ValkyrieTokenType("->");
    IElementType URL = new ValkyrieTokenType("Url");

    class Factory {
        public static PsiElement createElement(ASTNode node) {
            IElementType type = node.getElementType();
            if (type == ANNOTATIONS) {
                return new ValkyrieAnnotationsNode(node);
            } else if (type == ARGUMENT) {
                return new ValkyrieArgumentNode(node);
            } else if (type == ARGUMENT_BODY) {
                return new ValkyrieArgumentBodyNode(node);
            } else if (type == ATOMIC) {
                return new ValkyrieAtomicNode(node);
            } else if (type == ATTRIBUTE) {
                return new ValkyrieAttributeNode(node);
            } else if (type == BLOCK_BARE) {
                return new ValkyrieBlockBareNode(node);
            } else if (type == BLOCK_BODY) {
                return new ValkyrieBlockBodyNode(node);
            } else if (type == BLOCK_STATEMENT) {
                return new ValkyrieBlockStatementNode(node);
            } else if (type == CATCH_STATEMENT) {
                return new ValkyrieCatchStatementNode(node);
            } else if (type == CLASS_BODY) {
                return new ValkyrieClassBodyNode(node);
            } else if (type == CLASS_INHERIT) {
                return new ValkyrieClassInheritNode(node);
            } else if (type == CLASS_INHERIT_BODY) {
                return new ValkyrieClassInheritBodyNode(node);
            } else if (type == CLASS_ITEM) {
                return new ValkyrieClassItemNode(node);
            } else if (type == CONTROL_STATEMENT) {
                return new ValkyrieControlStatementNode(node);
            } else if (type == DECLARE_CLASS) {
                return new ValkyrieDeclareClassNode(node);
            } else if (type == DECLARE_ENUMERATE) {
                return new ValkyrieDeclareEnumerateNode(node);
            } else if (type == DECLARE_FIELD) {
                return new ValkyrieDeclareFieldNode(node);
            } else if (type == DECLARE_FLAGS) {
                return new ValkyrieDeclareFlagsNode(node);
            } else if (type == DECLARE_FUNCTION) {
                return new ValkyrieDeclareFunctionNode(node);
            } else if (type == DECLARE_GENERIC) {
                return new ValkyrieDeclareGenericNode(node);
            } else if (type == DECLARE_IMPLY) {
                return new ValkyrieDeclareImplyNode(node);
            } else if (type == DECLARE_METHOD) {
                return new ValkyrieDeclareMethodNode(node);
            } else if (type == DECLARE_NAMESPACE) {
                return new ValkyrieDeclareNamespaceNode(node);
            } else if (type == DECLARE_SEMANTIC) {
                return new ValkyrieDeclareSemanticNode(node);
            } else if (type == DECLARE_TRAIT) {
                return new ValkyrieDeclareTraitNode(node);
            } else if (type == DECLARE_UNION) {
                return new ValkyrieDeclareUnionNode(node);
            } else if (type == DECLARE_UNITE) {
                return new ValkyrieDeclareUniteNode(node);
            } else if (type == DECLARE_VARIABLE) {
                return new ValkyrieDeclareVariableNode(node);
            } else if (type == DEFAULT_TYPE) {
                return new ValkyrieDefaultTypeNode(node);
            } else if (type == DEFAULT_VALUE) {
                return new ValkyrieDefaultValueNode(node);
            } else if (type == DOT_CALL) {
                return new ValkyrieDotCallNode(node);
            } else if (type == DOT_CALL_CATCH) {
                return new ValkyrieDotCallCatchNode(node);
            } else if (type == DOT_CALL_MATCH) {
                return new ValkyrieDotCallMatchNode(node);
            } else if (type == EFFECT_TYPE) {
                return new ValkyrieEffectTypeNode(node);
            } else if (type == ELSE_IF_STATEMENT) {
                return new ValkyrieElseIfStatementNode(node);
            } else if (type == ELSE_STATEMENT) {
                return new ValkyrieElseStatementNode(node);
            } else if (type == ENUMERATE_BODY) {
                return new ValkyrieEnumerateBodyNode(node);
            } else if (type == ENUMERATE_ITEM) {
                return new ValkyrieEnumerateItemNode(node);
            } else if (type == EXPRESSION) {
                return new ValkyrieExpressionNode(node);
            } else if (type == FOR_STATEMENT) {
                return new ValkyrieForStatementNode(node);
            } else if (type == FUNCTION_CALL) {
                return new ValkyrieFunctionCallNode(node);
            } else if (type == GENERIC_ARGUMENT) {
                return new ValkyrieGenericArgumentNode(node);
            } else if (type == GENERIC_CALL) {
                return new ValkyrieGenericCallNode(node);
            } else if (type == GENERIC_CALL_ASCII_BODY) {
                return new ValkyrieGenericCallAsciiBodyNode(node);
            } else if (type == GENERIC_CALL_FREE) {
                return new ValkyrieGenericCallFreeNode(node);
            } else if (type == GENERIC_CALL_STANDARD_BODY) {
                return new ValkyrieGenericCallStandardBodyNode(node);
            } else if (type == GENERIC_PARAMETER) {
                return new ValkyrieGenericParameterNode(node);
            } else if (type == IDENTIFIER) {
                return new ValkyrieIdentifierNode(node);
            } else if (type == IDENTIFIER_FREE) {
                return new ValkyrieIdentifierFreeNode(node);
            } else if (type == IF_CASE_STATEMENT) {
                return new ValkyrieIfCaseStatementNode(node);
            } else if (type == IF_CONDITION) {
                return new ValkyrieIfConditionNode(node);
            } else if (type == IF_STATEMENT) {
                return new ValkyrieIfStatementNode(node);
            } else if (type == INFIX) {
                return new ValkyrieInfixNode(node);
            } else if (type == INLINE_EXPRESSION) {
                return new ValkyrieInlineExpressionNode(node);
            } else if (type == INLINE_STATEMENT) {
                return new ValkyrieInlineStatementNode(node);
            } else if (type == IS_NOT) {
                return new ValkyrieIsNotNode(node);
            } else if (type == MACRO_CALL) {
                return new ValkyrieMacroCallNode(node);
            } else if (type == MATCH_BODY) {
                return new ValkyrieMatchBodyNode(node);
            } else if (type == MATCH_CASE) {
                return new ValkyrieMatchCaseNode(node);
            } else if (type == MATCH_ELSE) {
                return new ValkyrieMatchElseNode(node);
            } else if (type == MATCH_ITEM) {
                return new ValkyrieMatchItemNode(node);
            } else if (type == MATCH_STATEMENT) {
                return new ValkyrieMatchStatementNode(node);
            } else if (type == MATCH_WHEN) {
                return new ValkyrieMatchWhenNode(node);
            } else if (type == MATCH_WITH) {
                return new ValkyrieMatchWithNode(node);
            } else if (type == MODIFIER) {
                return new ValkyrieModifierNode(node);
            } else if (type == NAMEPATH) {
                return new ValkyrieNamepathNode(node);
            } else if (type == NAMEPATH_FREE) {
                return new ValkyrieNamepathFreeNode(node);
            } else if (type == NEW_LAMBDA) {
                return new ValkyrieNewLambdaNode(node);
            } else if (type == NEW_OBJECT) {
                return new ValkyrieNewObjectNode(node);
            } else if (type == NEW_VALUE) {
                return new ValkyrieNewValueNode(node);
            } else if (type == NUMBER) {
                return new ValkyrieNumberNode(node);
            } else if (type == OFFSET_RANGE) {
                return new ValkyrieOffsetRangeNode(node);
            } else if (type == ORDINAL_RANGE) {
                return new ValkyrieOrdinalRangeNode(node);
            } else if (type == OTHERWISE_KIND) {
                return new ValkyrieOtherwiseKindNode(node);
            } else if (type == OTHERWISE_STATEMENT) {
                return new ValkyrieOtherwiseStatementNode(node);
            } else if (type == PARAMETER_BODY) {
                return new ValkyrieParameterBodyNode(node);
            } else if (type == PARAMETER_ITEM) {
                return new ValkyrieParameterItemNode(node);
            } else if (type == PATTERN) {
                return new ValkyriePatternNode(node);
            } else if (type == PATTERN_ATOMIC) {
                return new ValkyriePatternAtomicNode(node);
            } else if (type == PATTERN_BARE) {
                return new ValkyriePatternBareNode(node);
            } else if (type == PATTERN_OBJECT) {
                return new ValkyriePatternObjectNode(node);
            } else if (type == PATTERN_OBJECT_BODY) {
                return new ValkyriePatternObjectBodyNode(node);
            } else if (type == PATTERN_PAIR) {
                return new ValkyriePatternPairNode(node);
            } else if (type == PATTERN_SEQUENCE) {
                return new ValkyriePatternSequenceNode(node);
            } else if (type == PATTERN_SEQUENCE_BODY) {
                return new ValkyriePatternSequenceBodyNode(node);
            } else if (type == PATTERN_UNAPPLY) {
                return new ValkyriePatternUnapplyNode(node);
            } else if (type == PATTERN_UNAPPLY_BODY) {
                return new ValkyriePatternUnapplyBodyNode(node);
            } else if (type == PREFIX) {
                return new ValkyriePrefixNode(node);
            } else if (type == RANGE_INDEX) {
                return new ValkyrieRangeIndexNode(node);
            } else if (type == RANGE_ITEM) {
                return new ValkyrieRangeItemNode(node);
            } else if (type == RANGE_LOWER) {
                return new ValkyrieRangeLowerNode(node);
            } else if (type == RANGE_STEP) {
                return new ValkyrieRangeStepNode(node);
            } else if (type == RANGE_UPPER) {
                return new ValkyrieRangeUpperNode(node);
            } else if (type == RETURN_TYPE) {
                return new ValkyrieReturnTypeNode(node);
            } else if (type == SPECIAL) {
                return new ValkyrieSpecialNode(node);
            } else if (type == STRING) {
                return new ValkyrieStringNode(node);
            } else if (type == SUFFIX) {
                return new ValkyrieSuffixNode(node);
            } else if (type == TAG_BRANCH) {
                return new ValkyrieTagBranchNode(node);
            } else if (type == TERM) {
                return new ValkyrieTermNode(node);
            } else if (type == TRAIT_ALIAS) {
                return new ValkyrieTraitAliasNode(node);
            } else if (type == TRY_STATEMENT) {
                return new ValkyrieTryStatementNode(node);
            } else if (type == TUPLE) {
                return new ValkyrieTupleNode(node);
            } else if (type == TYPE_ALIAS) {
                return new ValkyrieTypeAliasNode(node);
            } else if (type == TYPE_ATOMIC) {
                return new ValkyrieTypeAtomicNode(node);
            } else if (type == TYPE_EXPRESSION) {
                return new ValkyrieTypeExpressionNode(node);
            } else if (type == TYPE_HINT) {
                return new ValkyrieTypeHintNode(node);
            } else if (type == TYPE_INFIX) {
                return new ValkyrieTypeInfixNode(node);
            } else if (type == TYPE_PREFIX) {
                return new ValkyrieTypePrefixNode(node);
            } else if (type == TYPE_SUFFIX) {
                return new ValkyrieTypeSuffixNode(node);
            } else if (type == TYPE_TERM) {
                return new ValkyrieTypeTermNode(node);
            } else if (type == UNION_BODY) {
                return new ValkyrieUnionBodyNode(node);
            } else if (type == UNION_VARIANT) {
                return new ValkyrieUnionVariantNode(node);
            } else if (type == USING) {
                return new ValkyrieUsingNode(node);
            } else if (type == USING_ALIAS) {
                return new ValkyrieUsingAliasNode(node);
            } else if (type == USING_ANY) {
                return new ValkyrieUsingAnyNode(node);
            } else if (type == USING_BLOCK) {
                return new ValkyrieUsingBlockNode(node);
            } else if (type == USING_BODY) {
                return new ValkyrieUsingBodyNode(node);
            } else if (type == USING_EXCLUDE) {
                return new ValkyrieUsingExcludeNode(node);
            } else if (type == USING_TERM) {
                return new ValkyrieUsingTermNode(node);
            } else if (type == WHILE_KIND) {
                return new ValkyrieWhileKindNode(node);
            } else if (type == WHILE_STATEMENT) {
                return new ValkyrieWhileStatementNode(node);
            }
            throw new AssertionError("Unknown element type: " + type);
        }
    }
}
