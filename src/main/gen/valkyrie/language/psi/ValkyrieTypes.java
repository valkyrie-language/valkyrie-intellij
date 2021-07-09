// This is a generated file. Not intended for manual editing.
package valkyrie.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import valkyrie.language.psi_node.*;

public interface ValkyrieTypes {

  IElementType ATOM = new ValkyrieTokenType("ATOM");
  IElementType BITFLAG_BLOCK = new ValkyrieTokenType("BITFLAG_BLOCK");
  IElementType BITFLAG_ITEM = new ValkyrieTokenType("BITFLAG_ITEM");
  IElementType BITFLAG_LAYOUT = new ValkyrieTokenType("BITFLAG_LAYOUT");
  IElementType BITFLAG_STATEMENT = new ValkyrieTokenType("BITFLAG_STATEMENT");
  IElementType BOOLEAN = new ValkyrieTokenType("BOOLEAN");
  IElementType CALL_SUFFIX = new ValkyrieTokenType("CALL_SUFFIX");
  IElementType CASE_ELSE = new ValkyrieTokenType("CASE_ELSE");
  IElementType CASE_PATTERN = new ValkyrieTokenType("CASE_PATTERN");
  IElementType CASE_WITH = new ValkyrieTokenType("CASE_WITH");
  IElementType CATCH_STATEMENT = new ValkyrieTokenType("CATCH_STATEMENT");
  IElementType CLASS_BLOCK = new ValkyrieTokenType("CLASS_BLOCK");
  IElementType CLASS_DEFINE = new ValkyrieTokenType("CLASS_DEFINE");
  IElementType CLASS_EFFECT = new ValkyrieTokenType("CLASS_EFFECT");
  IElementType CLASS_INHERIT = new ValkyrieTokenType("CLASS_INHERIT");
  IElementType CLASS_ITEM = new ValkyrieTokenType("CLASS_ITEM");
  IElementType CLASS_STATEMENT = new ValkyrieTokenType("CLASS_STATEMENT");
  IElementType CONDITION = new ValkyrieTokenType("CONDITION");
  IElementType CONTROL_STATEMENT = new ValkyrieTokenType("CONTROL_STATEMENT");
  IElementType DEFINE_BLOCK = new ValkyrieTokenType("DEFINE_BLOCK");
  IElementType DEFINE_ITEM = new ValkyrieTokenType("DEFINE_ITEM");
  IElementType DEFINE_STATEMENT = new ValkyrieTokenType("DEFINE_STATEMENT");
  IElementType DEFINE_TUPLE = new ValkyrieTokenType("DEFINE_TUPLE");
  IElementType DOT_CALL = new ValkyrieTokenType("DOT_CALL");
  IElementType EF_STATEMENT = new ValkyrieTokenType("EF_STATEMENT");
  IElementType ELSE_STATEMENT = new ValkyrieTokenType("ELSE_STATEMENT");
  IElementType EXPRESSION = new ValkyrieTokenType("EXPRESSION");
  IElementType EXTENDS_STATEMENT = new ValkyrieTokenType("EXTENDS_STATEMENT");
  IElementType EXTENSION_STATEMENT = new ValkyrieTokenType("EXTENSION_STATEMENT");
  IElementType FORALL_BLOCK = new ValkyrieTokenType("FORALL_BLOCK");
  IElementType FORALL_STATEMENT = new ValkyrieTokenType("FORALL_STATEMENT");
  IElementType FOR_STATEMENT = new ValkyrieTokenType("FOR_STATEMENT");
  IElementType GENERIC_CALL = new ValkyrieTokenType("GENERIC_CALL");
  IElementType GENERIC_DEFINE = new ValkyrieTokenType("GENERIC_DEFINE");
  IElementType GENERIC_TYPE = new ValkyrieTokenType("GENERIC_TYPE");
  IElementType IDENTIFIER = new ValkyrieTokenType("IDENTIFIER");
  IElementType IF_GUARD = new ValkyrieTokenType("IF_GUARD");
  IElementType IF_STATEMENT = new ValkyrieTokenType("IF_STATEMENT");
  IElementType IMPORT_BLOCK = new ValkyrieTokenType("IMPORT_BLOCK");
  IElementType IMPORT_ITEM = new ValkyrieTokenType("IMPORT_ITEM");
  IElementType IMPORT_STATEMENT = new ValkyrieTokenType("IMPORT_STATEMENT");
  IElementType INLINE_EXPRESSION = new ValkyrieTokenType("INLINE_EXPRESSION");
  IElementType INLINE_TERM = new ValkyrieTokenType("INLINE_TERM");
  IElementType JUMP_LABEL = new ValkyrieTokenType("JUMP_LABEL");
  IElementType KW_ELSE_IF = new ValkyrieTokenType("KW_ELSE_IF");
  IElementType LET_STATEMENT = new ValkyrieTokenType("LET_STATEMENT");
  IElementType LIST = new ValkyrieTokenType("LIST");
  IElementType LOOP_STATEMENT = new ValkyrieTokenType("LOOP_STATEMENT");
  IElementType MACRO_BLOCK = new ValkyrieTokenType("MACRO_BLOCK");
  IElementType MACRO_CALL = new ValkyrieTokenType("MACRO_CALL");
  IElementType MACRO_LIST = new ValkyrieTokenType("MACRO_LIST");
  IElementType MATCH_BLOCK = new ValkyrieTokenType("MATCH_BLOCK");
  IElementType MATCH_EXPRESSION = new ValkyrieTokenType("MATCH_EXPRESSION");
  IElementType MATCH_STATEMENT = new ValkyrieTokenType("MATCH_STATEMENT");
  IElementType MODIFIED = new ValkyrieTokenType("MODIFIED");
  IElementType MODIFIERS = new ValkyrieTokenType("MODIFIERS");
  IElementType NAMEPATH = new ValkyrieTokenType("NAMEPATH");
  IElementType NAMEPATH_FREE = new ValkyrieTokenType("NAMEPATH_FREE");
  IElementType NAMEPATH_STAR = new ValkyrieTokenType("NAMEPATH_STAR");
  IElementType NAMESPACE_STATEMENT = new ValkyrieTokenType("NAMESPACE_STATEMENT");
  IElementType NEW_STATEMENT = new ValkyrieTokenType("NEW_STATEMENT");
  IElementType NORMAL_BLOCK = new ValkyrieTokenType("NORMAL_BLOCK");
  IElementType NORMAL_PATTERN = new ValkyrieTokenType("NORMAL_PATTERN");
  IElementType NUMBER = new ValkyrieTokenType("NUMBER");
  IElementType OBJECT = new ValkyrieTokenType("OBJECT");
  IElementType OBJECT_KEY = new ValkyrieTokenType("OBJECT_KEY");
  IElementType OBJECT_PAIR = new ValkyrieTokenType("OBJECT_PAIR");
  IElementType OBJECT_STATEMENT = new ValkyrieTokenType("OBJECT_STATEMENT");
  IElementType PATTERN_ITEM = new ValkyrieTokenType("PATTERN_ITEM");
  IElementType PATTERN_PAIR = new ValkyrieTokenType("PATTERN_PAIR");
  IElementType PATTERN_VALUE = new ValkyrieTokenType("PATTERN_VALUE");
  IElementType RANGE = new ValkyrieTokenType("RANGE");
  IElementType SLICE = new ValkyrieTokenType("SLICE");
  IElementType SLICE_ITEM = new ValkyrieTokenType("SLICE_ITEM");
  IElementType STRING = new ValkyrieTokenType("STRING");
  IElementType TERM = new ValkyrieTokenType("TERM");
  IElementType TOP_BLOCK = new ValkyrieTokenType("TOP_BLOCK");
  IElementType TRAIT_STATEMENT = new ValkyrieTokenType("TRAIT_STATEMENT");
  IElementType TRY_STATEMENT = new ValkyrieTokenType("TRY_STATEMENT");
  IElementType TUPLE = new ValkyrieTokenType("TUPLE");
  IElementType TYPE_ATOM = new ValkyrieTokenType("TYPE_ATOM");
  IElementType TYPE_EXPRESSION = new ValkyrieTokenType("TYPE_EXPRESSION");
  IElementType TYPE_STATEMENT = new ValkyrieTokenType("TYPE_STATEMENT");
  IElementType TYPE_TERM = new ValkyrieTokenType("TYPE_TERM");
  IElementType UNION_BLOCK = new ValkyrieTokenType("UNION_BLOCK");
  IElementType UNION_ITEM = new ValkyrieTokenType("UNION_ITEM");
  IElementType UNION_STATEMENT = new ValkyrieTokenType("UNION_STATEMENT");

  IElementType AMP = new ValkyrieTokenType("AMP");
  IElementType BANG = new ValkyrieTokenType("BANG");
  IElementType BRACE_L = new ValkyrieTokenType("{");
  IElementType BRACE_R = new ValkyrieTokenType("}");
  IElementType BRACKET_L = new ValkyrieTokenType("[");
  IElementType BRACKET_R = new ValkyrieTokenType("]");
  IElementType BYTE = new ValkyrieTokenType("Byte");
  IElementType COLON = new ValkyrieTokenType(":");
  IElementType COMMA = new ValkyrieTokenType("COMMA");
  IElementType COMMENT = new ValkyrieTokenType("Comment");
  IElementType DECIMAL = new ValkyrieTokenType("DECIMAL");
  IElementType DOT = new ValkyrieTokenType(".");
  IElementType DOT2 = new ValkyrieTokenType("DOT2");
  IElementType DOT3 = new ValkyrieTokenType("DOT3");
  IElementType DOT_EQ = new ValkyrieTokenType("DOT_EQ");
  IElementType DOT_LESS = new ValkyrieTokenType("DOT_LESS");
  IElementType ID_WITH_MOD = new ValkyrieTokenType("id_with_mod");
  IElementType INTEGER = new ValkyrieTokenType("INTEGER");
  IElementType KW_BITFLAG = new ValkyrieTokenType("KW_BITFLAG");
  IElementType KW_BREAK = new ValkyrieTokenType("KW_BREAK");
  IElementType KW_CASE = new ValkyrieTokenType("KW_CASE");
  IElementType KW_CATCH = new ValkyrieTokenType("KW_CATCH");
  IElementType KW_CLASS = new ValkyrieTokenType("KW_CLASS");
  IElementType KW_CONTINUE = new ValkyrieTokenType("KW_CONTINUE");
  IElementType KW_DEF = new ValkyrieTokenType("KW_DEF");
  IElementType KW_DOTS = new ValkyrieTokenType("KW_DOTS");
  IElementType KW_ELSE = new ValkyrieTokenType("KW_ELSE");
  IElementType KW_ESCAPING = new ValkyrieTokenType("KW_WAITING_INPUT");
  IElementType KW_EXTENDS = new ValkyrieTokenType("KW_EXTENDS");
  IElementType KW_EXTENSION = new ValkyrieTokenType("KW_EXTENSION");
  IElementType KW_FOR = new ValkyrieTokenType("KW_FOR");
  IElementType KW_IF = new ValkyrieTokenType("KW_IF");
  IElementType KW_IMPORT = new ValkyrieTokenType("KW_IMPORT");
  IElementType KW_LET = new ValkyrieTokenType("KW_LET");
  IElementType KW_LOOP = new ValkyrieTokenType("KW_LOOP");
  IElementType KW_MACRO = new ValkyrieTokenType("KW_MACRO");
  IElementType KW_MATCH = new ValkyrieTokenType("KW_MATCH");
  IElementType KW_NAMESPACE = new ValkyrieTokenType("KW_NAMESPACE");
  IElementType KW_NEW = new ValkyrieTokenType("KW_NEW");
  IElementType KW_OBJECT = new ValkyrieTokenType("KW_OBJECT");
  IElementType KW_RAISE = new ValkyrieTokenType("KW_RAISE");
  IElementType KW_RESUME = new ValkyrieTokenType("KW_RESUME");
  IElementType KW_RETURN = new ValkyrieTokenType("KW_RETURN");
  IElementType KW_TAGGED = new ValkyrieTokenType("KW_TAGGED");
  IElementType KW_TRAIT = new ValkyrieTokenType("KW_TRAIT");
  IElementType KW_TRY = new ValkyrieTokenType("KW_TRY");
  IElementType KW_TYPE = new ValkyrieTokenType("KW_TYPE");
  IElementType KW_WHILE = new ValkyrieTokenType("KW_WHILE");
  IElementType KW_WITH = new ValkyrieTokenType("KW_WITH");
  IElementType KW_YIELD = new ValkyrieTokenType("KW_YIELD");
  IElementType OP_ADD = new ValkyrieTokenType("+");
  IElementType OP_ADD_ASSIGN = new ValkyrieTokenType("+=");
  IElementType OP_AND = new ValkyrieTokenType("&");
  IElementType OP_AND2 = new ValkyrieTokenType("&&");
  IElementType OP_AND_ASSIGN = new ValkyrieTokenType("&=");
  IElementType OP_AND_THEN = new ValkyrieTokenType("OP_AND_THEN");
  IElementType OP_ARROW = new ValkyrieTokenType("->");
  IElementType OP_ARROW2 = new ValkyrieTokenType("=>");
  IElementType OP_AS = new ValkyrieTokenType("OP_AS");
  IElementType OP_AT = new ValkyrieTokenType("@");
  IElementType OP_BIND = new ValkyrieTokenType(":=");
  IElementType OP_DEC = new ValkyrieTokenType("--");
  IElementType OP_DIV = new ValkyrieTokenType("/");
  IElementType OP_DIV_ASSIGN = new ValkyrieTokenType("/=");
  IElementType OP_EMPTY = new ValkyrieTokenType("(!)");
  IElementType OP_EQ = new ValkyrieTokenType("=");
  IElementType OP_FORALL = new ValkyrieTokenType("forall");
  IElementType OP_GEQ = new ValkyrieTokenType(">=");
  IElementType OP_GG = new ValkyrieTokenType(">>");
  IElementType OP_GGG = new ValkyrieTokenType(">>>");
  IElementType OP_GS = new ValkyrieTokenType("/>");
  IElementType OP_GT = new ValkyrieTokenType(">");
  IElementType OP_HASH = new ValkyrieTokenType("#");
  IElementType OP_IN = new ValkyrieTokenType("OP_IN");
  IElementType OP_INC = new ValkyrieTokenType("++");
  IElementType OP_IS_A = new ValkyrieTokenType("is");
  IElementType OP_LEQ = new ValkyrieTokenType("<=");
  IElementType OP_LL = new ValkyrieTokenType("<<");
  IElementType OP_LLL = new ValkyrieTokenType("<<<");
  IElementType OP_LS = new ValkyrieTokenType("</");
  IElementType OP_LT = new ValkyrieTokenType("<");
  IElementType OP_MOD = new ValkyrieTokenType("%");
  IElementType OP_MOD_ASSIGN = new ValkyrieTokenType("%=");
  IElementType OP_MUL = new ValkyrieTokenType("*");
  IElementType OP_MUL_ASSIGN = new ValkyrieTokenType("*=");
  IElementType OP_NE = new ValkyrieTokenType("!=");
  IElementType OP_NOT = new ValkyrieTokenType("!");
  IElementType OP_NOT_A = new ValkyrieTokenType("is not");
  IElementType OP_NOT_IN = new ValkyrieTokenType("not_in");
  IElementType OP_OR = new ValkyrieTokenType("|");
  IElementType OP_OR2 = new ValkyrieTokenType("||");
  IElementType OP_OR_ASSIGN = new ValkyrieTokenType("|=");
  IElementType OP_OR_ELSE = new ValkyrieTokenType("OP_OR_ELSE");
  IElementType OP_POW = new ValkyrieTokenType("^");
  IElementType OP_POW_ASSIGN = new ValkyrieTokenType("OP_POW_ASSIGN");
  IElementType OP_PROPORTION = new ValkyrieTokenType("::");
  IElementType OP_QUESTION = new ValkyrieTokenType("?");
  IElementType OP_SET = new ValkyrieTokenType("OP_SET");
  IElementType OP_SUB = new ValkyrieTokenType("-");
  IElementType OP_SUB_ASSIGN = new ValkyrieTokenType("-=");
  IElementType OP_TO = new ValkyrieTokenType("OP_TO");
  IElementType OP_UNIMPLEMENTED = new ValkyrieTokenType("???");
  IElementType OP_UNTIL = new ValkyrieTokenType("OP_UNTIL");
  IElementType PARENTHESIS_L = new ValkyrieTokenType("(");
  IElementType PARENTHESIS_R = new ValkyrieTokenType(")");
  IElementType SEMICOLON = new ValkyrieTokenType(";");
  IElementType SLICE_L = new ValkyrieTokenType("[[");
  IElementType SLICE_R = new ValkyrieTokenType("]]");
  IElementType STRING_END = new ValkyrieTokenType("StringEnd");
  IElementType STRING_START = new ValkyrieTokenType("StringStart");
  IElementType STRING_TEXT = new ValkyrieTokenType("StringText");
  IElementType SYMBOL_RAW = new ValkyrieTokenType("Symbol");
  IElementType SYMBOL_XID = new ValkyrieTokenType("SYMBOL_XID");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ATOM) {
        return new ValkyrieAtomNode(node);
      }
      else if (type == BITFLAG_BLOCK) {
        return new ValkyrieBitflagBlockNode(node);
      }
      else if (type == BITFLAG_ITEM) {
        return new ValkyrieBitflagItemNode(node);
      }
      else if (type == BITFLAG_LAYOUT) {
        return new ValkyrieBitflagLayoutNode(node);
      }
      else if (type == BITFLAG_STATEMENT) {
        return new ValkyrieBitflagStatementNode(node);
      }
      else if (type == BOOLEAN) {
        return new ValkyrieBooleanNode(node);
      }
      else if (type == CALL_SUFFIX) {
        return new ValkyrieCallSuffixNode(node);
      }
      else if (type == CASE_ELSE) {
        return new ValkyrieCaseElseNode(node);
      }
      else if (type == CASE_PATTERN) {
        return new ValkyrieCasePatternNode(node);
      }
      else if (type == CASE_WITH) {
        return new ValkyrieCaseWithNode(node);
      }
      else if (type == CATCH_STATEMENT) {
        return new ValkyrieCatchStatementNode(node);
      }
      else if (type == CLASS_BLOCK) {
        return new ValkyrieClassBlockNode(node);
      }
      else if (type == CLASS_DEFINE) {
        return new ValkyrieClassDefineNode(node);
      }
      else if (type == CLASS_EFFECT) {
        return new ValkyrieClassEffectNode(node);
      }
      else if (type == CLASS_INHERIT) {
        return new ValkyrieClassInheritNode(node);
      }
      else if (type == CLASS_ITEM) {
        return new ValkyrieClassItemNode(node);
      }
      else if (type == CLASS_STATEMENT) {
        return new ValkyrieClassStatementNode(node);
      }
      else if (type == CONDITION) {
        return new ValkyrieConditionNode(node);
      }
      else if (type == CONTROL_STATEMENT) {
        return new ValkyrieControlStatementNode(node);
      }
      else if (type == DEFINE_BLOCK) {
        return new ValkyrieDefineBlockNode(node);
      }
      else if (type == DEFINE_ITEM) {
        return new ValkyrieDefineItemNode(node);
      }
      else if (type == DEFINE_STATEMENT) {
        return new ValkyrieDefineStatementNode(node);
      }
      else if (type == DEFINE_TUPLE) {
        return new ValkyrieDefineTupleNode(node);
      }
      else if (type == DOT_CALL) {
        return new ValkyrieDotCallNode(node);
      }
      else if (type == EF_STATEMENT) {
        return new ValkyrieEfStatementNode(node);
      }
      else if (type == ELSE_STATEMENT) {
        return new ValkyrieElseStatementNode(node);
      }
      else if (type == EXPRESSION) {
        return new ValkyrieExpressionNode(node);
      }
      else if (type == EXTENDS_STATEMENT) {
        return new ValkyrieExtendsStatementNode(node);
      }
      else if (type == EXTENSION_STATEMENT) {
        return new ValkyrieExtensionStatementNode(node);
      }
      else if (type == FORALL_BLOCK) {
        return new ValkyrieForallBlockNode(node);
      }
      else if (type == FORALL_STATEMENT) {
        return new ValkyrieForallStatementNode(node);
      }
      else if (type == FOR_STATEMENT) {
        return new ValkyrieForStatementNode(node);
      }
      else if (type == GENERIC_CALL) {
        return new ValkyrieGenericCallNode(node);
      }
      else if (type == GENERIC_DEFINE) {
        return new ValkyrieGenericDefineNode(node);
      }
      else if (type == GENERIC_TYPE) {
        return new ValkyrieGenericTypeNode(node);
      }
      else if (type == IDENTIFIER) {
        return new ValkyrieIdentifierNode(node);
      }
      else if (type == IF_GUARD) {
        return new ValkyrieIfGuardNode(node);
      }
      else if (type == IF_STATEMENT) {
        return new ValkyrieIfStatementNode(node);
      }
      else if (type == IMPORT_BLOCK) {
        return new ValkyrieImportBlockNode(node);
      }
      else if (type == IMPORT_ITEM) {
        return new ValkyrieImportItemNode(node);
      }
      else if (type == IMPORT_STATEMENT) {
        return new ValkyrieImportStatementNode(node);
      }
      else if (type == INLINE_EXPRESSION) {
        return new ValkyrieInlineExpressionNode(node);
      }
      else if (type == INLINE_TERM) {
        return new ValkyrieInlineTermNode(node);
      }
      else if (type == JUMP_LABEL) {
        return new ValkyrieJumpLabelNode(node);
      }
      else if (type == KW_ELSE_IF) {
        return new ValkyrieKwElseIfNode(node);
      }
      else if (type == LET_STATEMENT) {
        return new ValkyrieLetStatementNode(node);
      }
      else if (type == LIST) {
        return new ValkyrieListNode(node);
      }
      else if (type == LOOP_STATEMENT) {
        return new ValkyrieLoopStatementNode(node);
      }
      else if (type == MACRO_BLOCK) {
        return new ValkyrieMacroBlockNode(node);
      }
      else if (type == MACRO_CALL) {
        return new ValkyrieMacroCallNode(node);
      }
      else if (type == MACRO_LIST) {
        return new ValkyrieMacroListNode(node);
      }
      else if (type == MATCH_BLOCK) {
        return new ValkyrieMatchBlockNode(node);
      }
      else if (type == MATCH_EXPRESSION) {
        return new ValkyrieMatchExpressionNode(node);
      }
      else if (type == MATCH_STATEMENT) {
        return new ValkyrieMatchStatementNode(node);
      }
      else if (type == MODIFIED) {
        return new ValkyrieModifiedNode(node);
      }
      else if (type == MODIFIERS) {
        return new ValkyrieModifiersNode(node);
      }
      else if (type == NAMEPATH) {
        return new ValkyrieNamepathNode(node);
      }
      else if (type == NAMEPATH_FREE) {
        return new ValkyrieNamepathFreeNode(node);
      }
      else if (type == NAMEPATH_STAR) {
        return new ValkyrieNamepathStarNode(node);
      }
      else if (type == NAMESPACE_STATEMENT) {
        return new ValkyrieNamespaceStatementNode(node);
      }
      else if (type == NEW_STATEMENT) {
        return new ValkyrieNewStatementNode(node);
      }
      else if (type == NORMAL_BLOCK) {
        return new ValkyrieNormalBlockNode(node);
      }
      else if (type == NORMAL_PATTERN) {
        return new ValkyrieNormalPatternNode(node);
      }
      else if (type == NUMBER) {
        return new ValkyrieNumberNode(node);
      }
      else if (type == OBJECT) {
        return new ValkyrieObjectNode(node);
      }
      else if (type == OBJECT_KEY) {
        return new ValkyrieObjectKeyNode(node);
      }
      else if (type == OBJECT_PAIR) {
        return new ValkyrieObjectPairNode(node);
      }
      else if (type == OBJECT_STATEMENT) {
        return new ValkyrieObjectStatementNode(node);
      }
      else if (type == PATTERN_ITEM) {
        return new ValkyriePatternItemNode(node);
      }
      else if (type == PATTERN_PAIR) {
        return new ValkyriePatternPairNode(node);
      }
      else if (type == PATTERN_VALUE) {
        return new ValkyriePatternValueNode(node);
      }
      else if (type == RANGE) {
        return new ValkyrieRangeNode(node);
      }
      else if (type == SLICE) {
        return new ValkyrieSliceNode(node);
      }
      else if (type == SLICE_ITEM) {
        return new ValkyrieSliceItemNode(node);
      }
      else if (type == STRING) {
        return new ValkyrieStringNode(node);
      }
      else if (type == TERM) {
        return new ValkyrieTermNode(node);
      }
      else if (type == TOP_BLOCK) {
        return new ValkyrieTopBlockNode(node);
      }
      else if (type == TRAIT_STATEMENT) {
        return new ValkyrieTraitStatementNode(node);
      }
      else if (type == TRY_STATEMENT) {
        return new ValkyrieTryStatementNode(node);
      }
      else if (type == TUPLE) {
        return new ValkyrieTupleNode(node);
      }
      else if (type == TYPE_ATOM) {
        return new ValkyrieTypeAtomNode(node);
      }
      else if (type == TYPE_EXPRESSION) {
        return new ValkyrieTypeExpressionNode(node);
      }
      else if (type == TYPE_STATEMENT) {
        return new ValkyrieTypeStatementNode(node);
      }
      else if (type == TYPE_TERM) {
        return new ValkyrieTypeTermNode(node);
      }
      else if (type == UNION_BLOCK) {
        return new ValkyrieUnionBlockNode(node);
      }
      else if (type == UNION_ITEM) {
        return new ValkyrieUnionItemNode(node);
      }
      else if (type == UNION_STATEMENT) {
        return new ValkyrieUnionStatementNode(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
