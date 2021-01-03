// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.valkyrie.language.psi_node.*;

public interface ValkyrieTypes {

  IElementType ANGLE_BLOCK = new ValkyrieElementType("ANGLE_BLOCK");
  IElementType BLOCK = new ValkyrieElementType("BLOCK");
  IElementType BRACE_BLOCK = new ValkyrieElementType("BRACE_BLOCK");
  IElementType BRACKET_BLOCK = new ValkyrieElementType("BRACKET_BLOCK");
  IElementType CLASS_STATEMENT = new ValkyrieElementType("CLASS_STATEMENT");
  IElementType CONDITION = new ValkyrieElementType("CONDITION");
  IElementType DEF_STATEMENT = new ValkyrieElementType("DEF_STATEMENT");
  IElementType FOR_STATEMENT = new ValkyrieElementType("FOR_STATEMENT");
  IElementType IF_STATEMENT = new ValkyrieElementType("IF_STATEMENT");
  IElementType LET_STATEMENT = new ValkyrieElementType("LET_STATEMENT");
  IElementType MATCH_STATEMENT = new ValkyrieElementType("MATCH_STATEMENT");
  IElementType NAMESPACE = new ValkyrieElementType("NAMESPACE");
  IElementType PARENTHESIS = new ValkyrieElementType("PARENTHESIS");
  IElementType PATTERN = new ValkyrieElementType("PATTERN");
  IElementType TRAIT_STATEMENT = new ValkyrieElementType("TRAIT_STATEMENT");
  IElementType WHILE_STATEMENT = new ValkyrieElementType("WHILE_STATEMENT");

  IElementType ACCENT = new ValkyrieTokenType("^");
  IElementType ANGLE_L = new ValkyrieTokenType("<");
  IElementType ANGLE_R = new ValkyrieTokenType(">");
  IElementType AT = new ValkyrieTokenType("@");
  IElementType BRACE_L = new ValkyrieTokenType("{");
  IElementType BRACE_R = new ValkyrieTokenType("}");
  IElementType BRACKET_L = new ValkyrieTokenType("[");
  IElementType BRACKET_R = new ValkyrieTokenType("]");
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
  IElementType FOR = new ValkyrieTokenType("for");
  IElementType HYPHEN = new ValkyrieTokenType("-");
  IElementType IF = new ValkyrieTokenType("if");
  IElementType IN = new ValkyrieTokenType("in");
  IElementType INTEGER = new ValkyrieTokenType("INTEGER");
  IElementType LET = new ValkyrieTokenType("let");
  IElementType MATCH = new ValkyrieTokenType("match");
  IElementType PARENTHESIS_L = new ValkyrieTokenType("(");
  IElementType PARENTHESIS_R = new ValkyrieTokenType(")");
  IElementType SELECTION_LINE = new ValkyrieTokenType("SELECTION_LINE");
  IElementType SEMICOLON = new ValkyrieTokenType(";");
  IElementType STAR = new ValkyrieTokenType("*");
  IElementType STRING_CHAR = new ValkyrieTokenType("String Character");
  IElementType STRING_ESCAPE = new ValkyrieTokenType("String Escaped");
  IElementType STRING_LITERAL = new ValkyrieTokenType("String Literal");
  IElementType STRING_QUOTE = new ValkyrieTokenType("String Quote");
  IElementType SYMBOL = new ValkyrieTokenType("Symbol");
  IElementType TO = new ValkyrieTokenType("->");
  IElementType TRAIT = new ValkyrieTokenType("trait");
  IElementType URL = new ValkyrieTokenType("Url");
  IElementType WHILE = new ValkyrieTokenType("while");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ANGLE_BLOCK) {
        return new ValkyrieAngleBlockNode(node);
      }
      else if (type == BLOCK) {
        return new ValkyrieBlockNode(node);
      }
      else if (type == BRACE_BLOCK) {
        return new ValkyrieBraceBlockNode(node);
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
      else if (type == FOR_STATEMENT) {
        return new ValkyrieForStatementNode(node);
      }
      else if (type == IF_STATEMENT) {
        return new ValkyrieIfStatementNode(node);
      }
      else if (type == LET_STATEMENT) {
        return new ValkyrieLetStatementNode(node);
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
      else if (type == WHILE_STATEMENT) {
        return new ValkyrieWhileStatementNode(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
