// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.valkyrie.language.psi_node.*;

public interface ValkyrieTypes {

  IElementType ANGLE_BLOCK = new ValkyrieElementType("ANGLE_BLOCK");
  IElementType BITFLAG_BLOCK = new ValkyrieElementType("BITFLAG_BLOCK");
  IElementType BITFLAG_ITEM = new ValkyrieElementType("BITFLAG_ITEM");
  IElementType BITFLAG_STATEMENT = new ValkyrieElementType("BITFLAG_STATEMENT");
  IElementType BLOCK = new ValkyrieElementType("BLOCK");
  IElementType BRACKET_BLOCK = new ValkyrieElementType("BRACKET_BLOCK");
  IElementType CLASS_STATEMENT = new ValkyrieElementType("CLASS_STATEMENT");
  IElementType CONDITION = new ValkyrieElementType("CONDITION");
  IElementType DEF_STATEMENT = new ValkyrieElementType("DEF_STATEMENT");
  IElementType ELSE_IF_STATEMENT = new ValkyrieElementType("ELSE_IF_STATEMENT");
  IElementType ELSE_STATEMENT = new ValkyrieElementType("ELSE_STATEMENT");
  IElementType EXTENDS_STATEMENT = new ValkyrieElementType("EXTENDS_STATEMENT");
  IElementType FOR_STATEMENT = new ValkyrieElementType("FOR_STATEMENT");
  IElementType IF_GUARD = new ValkyrieElementType("IF_GUARD");
  IElementType IF_STATEMENT = new ValkyrieElementType("IF_STATEMENT");
  IElementType LET_STATEMENT = new ValkyrieElementType("LET_STATEMENT");
  IElementType LIST = new ValkyrieElementType("LIST");
  IElementType MATCH_STATEMENT = new ValkyrieElementType("MATCH_STATEMENT");
  IElementType NAMESPACE = new ValkyrieElementType("NAMESPACE");
  IElementType PARENTHESIS = new ValkyrieElementType("PARENTHESIS");
  IElementType PATTERN = new ValkyrieElementType("PATTERN");
  IElementType TRAIT_STATEMENT = new ValkyrieElementType("TRAIT_STATEMENT");
  IElementType TYPE_STATEMENT = new ValkyrieElementType("TYPE_STATEMENT");
  IElementType VARIANT_STATEMENT = new ValkyrieElementType("VARIANT_STATEMENT");
  IElementType WHILE_STATEMENT = new ValkyrieElementType("WHILE_STATEMENT");

  IElementType ACCENT = new ValkyrieTokenType("^");
  IElementType ANGLE_L = new ValkyrieTokenType("<");
  IElementType ANGLE_R = new ValkyrieTokenType(">");
  IElementType AT = new ValkyrieTokenType("@");
  IElementType BITFLAG = new ValkyrieTokenType("bitflag");
  IElementType BRACE_L = new ValkyrieTokenType("{");
  IElementType BRACE_R = new ValkyrieTokenType("}");
  IElementType BRACKET_L = new ValkyrieTokenType("[");
  IElementType BRACKET_R = new ValkyrieTokenType("]");
  IElementType BYTE = new ValkyrieTokenType("Byte");
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
  IElementType EXTENDS = new ValkyrieTokenType("extends");
  IElementType FOR = new ValkyrieTokenType("for");
  IElementType HYPHEN = new ValkyrieTokenType("-");
  IElementType IF = new ValkyrieTokenType("if");
  IElementType IN = new ValkyrieTokenType("in");
  IElementType INTEGER = new ValkyrieTokenType("INTEGER");
  IElementType LET = new ValkyrieTokenType("let");
  IElementType MATCH = new ValkyrieTokenType("match");
  IElementType PARENTHESIS_L = new ValkyrieTokenType("(");
  IElementType PARENTHESIS_R = new ValkyrieTokenType(")");
  IElementType SEMICOLON = new ValkyrieTokenType(";");
  IElementType STAR = new ValkyrieTokenType("*");
  IElementType STRING_CHAR = new ValkyrieTokenType("String Character");
  IElementType STRING_ESCAPE = new ValkyrieTokenType("String Escaped");
  IElementType STRING_LITERAL = new ValkyrieTokenType("String Literal");
  IElementType STRING_QUOTE = new ValkyrieTokenType("String Quote");
  IElementType SYMBOL = new ValkyrieTokenType("Symbol");
  IElementType TO = new ValkyrieTokenType("->");
  IElementType TRAIT = new ValkyrieTokenType("trait");
  IElementType TYPE = new ValkyrieTokenType("TYPE");
  IElementType URL = new ValkyrieTokenType("Url");
  IElementType VARIANT = new ValkyrieTokenType("variant");
  IElementType WHILE = new ValkyrieTokenType("while");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ANGLE_BLOCK) {
        return new ValkyrieAngleBlockNode(node);
      }
      else if (type == BITFLAG_BLOCK) {
        return new ValkyrieBitflagBlockNode(node);
      }
      else if (type == BITFLAG_ITEM) {
        return new ValkyrieBitflagItemNode(node);
      }
      else if (type == BITFLAG_STATEMENT) {
        return new ValkyrieBitflagStatementNode(node);
      }
      else if (type == BLOCK) {
        return new ValkyrieBlockNode(node);
      }
      else if (type == BRACKET_BLOCK) {
        return new ValkyrieBracketBlockNode(node);
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
      else if (type == EXTENDS_STATEMENT) {
        return new ValkyrieExtendsStatementNode(node);
      }
      else if (type == FOR_STATEMENT) {
        return new ValkyrieForStatementNode(node);
      }
      else if (type == IF_GUARD) {
        return new ValkyrieIfGuardNode(node);
      }
      else if (type == IF_STATEMENT) {
        return new ValkyrieIfStatementNode(node);
      }
      else if (type == LET_STATEMENT) {
        return new ValkyrieLetStatementNode(node);
      }
      else if (type == LIST) {
        return new ValkyrieListNode(node);
      }
      else if (type == MATCH_STATEMENT) {
        return new ValkyrieMatchStatementNode(node);
      }
      else if (type == NAMESPACE) {
        return new ValkyrieNamespaceNode(node);
      }
      else if (type == PARENTHESIS) {
        return new ValkyrieParenthesisNode(node);
      }
      else if (type == PATTERN) {
        return new ValkyriePatternNode(node);
      }
      else if (type == TRAIT_STATEMENT) {
        return new ValkyrieTraitStatementNode(node);
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
