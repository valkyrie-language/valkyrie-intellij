// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.valkyrie.language.psi_node.*;

public interface ValkyrieTypes {

  IElementType AS = new ValkyrieElementType("AS");
  IElementType AUTO_DERIVE = new ValkyrieElementType("AUTO_DERIVE");
  IElementType BITFLAG_BLOCK = new ValkyrieElementType("BITFLAG_BLOCK");
  IElementType BITFLAG_ITEM = new ValkyrieElementType("BITFLAG_ITEM");
  IElementType BITFLAG_LAYOUT = new ValkyrieElementType("BITFLAG_LAYOUT");
  IElementType BITFLAG_STATEMENT = new ValkyrieElementType("BITFLAG_STATEMENT");
  IElementType BLOCK = new ValkyrieElementType("BLOCK");
  IElementType CASE_PATTERN = new ValkyrieElementType("CASE_PATTERN");
  IElementType CLASS_STATEMENT = new ValkyrieElementType("CLASS_STATEMENT");
  IElementType CONDITION = new ValkyrieElementType("CONDITION");
  IElementType DEF_STATEMENT = new ValkyrieElementType("DEF_STATEMENT");
  IElementType ELSE_IF_STATEMENT = new ValkyrieElementType("ELSE_IF_STATEMENT");
  IElementType ELSE_STATEMENT = new ValkyrieElementType("ELSE_STATEMENT");
  IElementType EXPORT_STATEMENT = new ValkyrieElementType("EXPORT_STATEMENT");
  IElementType EXTENDS_STATEMENT = new ValkyrieElementType("EXTENDS_STATEMENT");
  IElementType FOR_STATEMENT = new ValkyrieElementType("FOR_STATEMENT");
  IElementType FUNCTION_CALL = new ValkyrieElementType("FUNCTION_CALL");
  IElementType IF_GUARD = new ValkyrieElementType("IF_GUARD");
  IElementType IF_STATEMENT = new ValkyrieElementType("IF_STATEMENT");
  IElementType IMPORT_BLOCK_IN = new ValkyrieElementType("IMPORT_BLOCK_IN");
  IElementType IMPORT_BLOCK_OUT = new ValkyrieElementType("IMPORT_BLOCK_OUT");
  IElementType IMPORT_DOT = new ValkyrieElementType("IMPORT_DOT");
  IElementType IMPORT_NAME = new ValkyrieElementType("IMPORT_NAME");
  IElementType IMPORT_RENAME = new ValkyrieElementType("IMPORT_RENAME");
  IElementType IMPORT_STATEMENT = new ValkyrieElementType("IMPORT_STATEMENT");
  IElementType LET_STATEMENT = new ValkyrieElementType("LET_STATEMENT");
  IElementType LIST = new ValkyrieElementType("LIST");
  IElementType MACRO = new ValkyrieElementType("MACRO");
  IElementType MACRO_CALL = new ValkyrieElementType("MACRO_CALL");
  IElementType MATCH_STATEMENT = new ValkyrieElementType("MATCH_STATEMENT");
  IElementType MODIFIERS = new ValkyrieElementType("MODIFIERS");
  IElementType MODULE_STATEMENT = new ValkyrieElementType("MODULE_STATEMENT");
  IElementType NAMESPACE = new ValkyrieElementType("NAMESPACE");
  IElementType PAIR = new ValkyrieElementType("PAIR");
  IElementType PATTERN = new ValkyrieElementType("PATTERN");
  IElementType SYMBOL = new ValkyrieElementType("SYMBOL");
  IElementType TRAIT_STATEMENT = new ValkyrieElementType("TRAIT_STATEMENT");
  IElementType TUPLE = new ValkyrieElementType("TUPLE");
  IElementType TYPE_STATEMENT = new ValkyrieElementType("TYPE_STATEMENT");
  IElementType VARIANT_STATEMENT = new ValkyrieElementType("VARIANT_STATEMENT");
  IElementType WHILE_STATEMENT = new ValkyrieElementType("WHILE_STATEMENT");

  IElementType ACCENT = new ValkyrieTokenType("^");
  IElementType ANGLE_L = new ValkyrieTokenType("<");
  IElementType ANGLE_R = new ValkyrieTokenType(">");
  IElementType AT = new ValkyrieTokenType("@");
  IElementType BANG = new ValkyrieTokenType("!");
  IElementType BITFLAG = new ValkyrieTokenType("bitflag");
  IElementType BRACE_L = new ValkyrieTokenType("{");
  IElementType BRACE_R = new ValkyrieTokenType("}");
  IElementType BRACKET_L = new ValkyrieTokenType("[");
  IElementType BRACKET_R = new ValkyrieTokenType("]");
  IElementType BYTE = new ValkyrieTokenType("Byte");
  IElementType CASE = new ValkyrieTokenType("CASE");
  IElementType CATCH = new ValkyrieTokenType("catch");
  IElementType CLASS = new ValkyrieTokenType("class");
  IElementType COLON = new ValkyrieTokenType(":");
  IElementType COMMA = new ValkyrieTokenType(",");
  IElementType COMMENT = new ValkyrieTokenType("Comment");
  IElementType COMMENT_BLOCK = new ValkyrieTokenType("Comment Block");
  IElementType COMMENT_DOCUMENT = new ValkyrieTokenType("Comment Document");
  IElementType COMMENT_LINE = new ValkyrieTokenType("Comment Line");
  IElementType DECIMAL = new ValkyrieTokenType("DECIMAL");
  IElementType DEF = new ValkyrieTokenType("def");
  IElementType DOLLAR = new ValkyrieTokenType("$");
  IElementType DOT = new ValkyrieTokenType(".");
  IElementType ELSE = new ValkyrieTokenType("else");
  IElementType EQ = new ValkyrieTokenType("=");
  IElementType EXPORT = new ValkyrieTokenType("export");
  IElementType EXTENDS = new ValkyrieTokenType("extends");
  IElementType FOR = new ValkyrieTokenType("for");
  IElementType FORALL = new ValkyrieTokenType("forall");
  IElementType GREATER = new ValkyrieTokenType(">>");
  IElementType HASH = new ValkyrieTokenType("#");
  IElementType HYPHEN = new ValkyrieTokenType("-");
  IElementType IDENTIFIER = new ValkyrieTokenType("IDENTIFIER");
  IElementType IF = new ValkyrieTokenType("if");
  IElementType IMPORT = new ValkyrieTokenType("import");
  IElementType IN = new ValkyrieTokenType("IN");
  IElementType INTEGER = new ValkyrieTokenType("INTEGER");
  IElementType LESS = new ValkyrieTokenType("<<");
  IElementType LET = new ValkyrieTokenType("let");
  IElementType MATCH = new ValkyrieTokenType("match");
  IElementType MODULE = new ValkyrieTokenType("module");
  IElementType PARENTHESIS_L = new ValkyrieTokenType("(");
  IElementType PARENTHESIS_R = new ValkyrieTokenType(")");
  IElementType PLUS = new ValkyrieTokenType("+");
  IElementType PROPORTION = new ValkyrieTokenType("::");
  IElementType SEMICOLON = new ValkyrieTokenType(";");
  IElementType STAR = new ValkyrieTokenType("*");
  IElementType STRING_CHAR = new ValkyrieTokenType("String Character");
  IElementType STRING_ESCAPE = new ValkyrieTokenType("String Escaped");
  IElementType STRING_LITERAL = new ValkyrieTokenType("String Literal");
  IElementType STRING_QUOTE = new ValkyrieTokenType("String Quote");
  IElementType SYMBOL_RAW = new ValkyrieTokenType("Symbol");
  IElementType SYMBOL_XID = new ValkyrieTokenType("SYMBOL_XID");
  IElementType TO = new ValkyrieTokenType("->");
  IElementType TRAIT = new ValkyrieTokenType("trait");
  IElementType TYPE = new ValkyrieTokenType("TYPE");
  IElementType UNTIL = new ValkyrieTokenType("..");
  IElementType URL = new ValkyrieTokenType("Url");
  IElementType VARIANT = new ValkyrieTokenType("variant");
  IElementType VERTICAL = new ValkyrieTokenType("|");
  IElementType WHILE = new ValkyrieTokenType("while");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == AS) {
        return new ValkyrieAsNode(node);
      }
      else if (type == AUTO_DERIVE) {
        return new ValkyrieAutoDeriveNode(node);
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
      else if (type == BLOCK) {
        return new ValkyrieBlockNode(node);
      }
      else if (type == CASE_PATTERN) {
        return new ValkyrieCasePatternNode(node);
      }
      else if (type == CLASS_STATEMENT) {
        return new ValkyrieClassStatementNode(node);
      }
      else if (type == CONDITION) {
        return new ValkyrieConditionNode(node);
      }
      else if (type == DEF_STATEMENT) {
        return new ValkyrieDefStatementNode(node);
      }
      else if (type == ELSE_IF_STATEMENT) {
        return new ValkyrieElseIfStatementNode(node);
      }
      else if (type == ELSE_STATEMENT) {
        return new ValkyrieElseStatementNode(node);
      }
      else if (type == EXPORT_STATEMENT) {
        return new ValkyrieExportStatementNode(node);
      }
      else if (type == EXTENDS_STATEMENT) {
        return new ValkyrieExtendsStatementNode(node);
      }
      else if (type == FOR_STATEMENT) {
        return new ValkyrieForStatementNode(node);
      }
      else if (type == FUNCTION_CALL) {
        return new ValkyrieFunctionCallNode(node);
      }
      else if (type == IF_GUARD) {
        return new ValkyrieIfGuardNode(node);
      }
      else if (type == IF_STATEMENT) {
        return new ValkyrieIfStatementNode(node);
      }
      else if (type == IMPORT_BLOCK_IN) {
        return new ValkyrieImportBlockInNode(node);
      }
      else if (type == IMPORT_BLOCK_OUT) {
        return new ValkyrieImportBlockOutNode(node);
      }
      else if (type == IMPORT_DOT) {
        return new ValkyrieImportDotNode(node);
      }
      else if (type == IMPORT_NAME) {
        return new ValkyrieImportNameNode(node);
      }
      else if (type == IMPORT_RENAME) {
        return new ValkyrieImportRenameNode(node);
      }
      else if (type == IMPORT_STATEMENT) {
        return new ValkyrieImportStatementNode(node);
      }
      else if (type == LET_STATEMENT) {
        return new ValkyrieLetStatementNode(node);
      }
      else if (type == LIST) {
        return new ValkyrieListNode(node);
      }
      else if (type == MACRO) {
        return new ValkyrieMacroNode(node);
      }
      else if (type == MACRO_CALL) {
        return new ValkyrieMacroCallNode(node);
      }
      else if (type == MATCH_STATEMENT) {
        return new ValkyrieMatchStatementNode(node);
      }
      else if (type == MODIFIERS) {
        return new ValkyrieModifiersNode(node);
      }
      else if (type == MODULE_STATEMENT) {
        return new ValkyrieModuleStatementNode(node);
      }
      else if (type == NAMESPACE) {
        return new ValkyrieNamespaceNode(node);
      }
      else if (type == PAIR) {
        return new ValkyriePairNode(node);
      }
      else if (type == PATTERN) {
        return new ValkyriePatternNode(node);
      }
      else if (type == SYMBOL) {
        return new ValkyrieSymbolNode(node);
      }
      else if (type == TRAIT_STATEMENT) {
        return new ValkyrieTraitStatementNode(node);
      }
      else if (type == TUPLE) {
        return new ValkyrieTupleNode(node);
      }
      else if (type == TYPE_STATEMENT) {
        return new ValkyrieTypeStatementNode(node);
      }
      else if (type == VARIANT_STATEMENT) {
        return new ValkyrieVariantStatementNode(node);
      }
      else if (type == WHILE_STATEMENT) {
        return new ValkyrieWhileStatementNode(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
