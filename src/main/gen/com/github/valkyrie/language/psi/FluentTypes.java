// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.valkyrie.language.psi_node.*;

public interface FluentTypes {

  IElementType ATOMS = new FluentElementType("ATOMS");
  IElementType BLOCK = new FluentElementType("BLOCK");
  IElementType BRACE_BLOCK = new FluentElementType("BRACE_BLOCK");
  IElementType BRACKET_BLOCK = new FluentElementType("BRACKET_BLOCK");
  IElementType CLASS_STATEMENT = new FluentElementType("CLASS_STATEMENT");
  IElementType CONDITION = new FluentElementType("CONDITION");
  IElementType DEF_STATEMENT = new FluentElementType("DEF_STATEMENT");
  IElementType FOR_STATEMENT = new FluentElementType("FOR_STATEMENT");
  IElementType IF_STATEMENT = new FluentElementType("IF_STATEMENT");
  IElementType LET_STATEMENT = new FluentElementType("LET_STATEMENT");
  IElementType MATCH_STATEMENT = new FluentElementType("MATCH_STATEMENT");
  IElementType NAMESPACE = new FluentElementType("NAMESPACE");
  IElementType PARENTHESIS = new FluentElementType("PARENTHESIS");
  IElementType PATTERN = new FluentElementType("PATTERN");
  IElementType TRAIT_STATEMENT = new FluentElementType("TRAIT_STATEMENT");
  IElementType WHILE_STATEMENT = new FluentElementType("WHILE_STATEMENT");

  IElementType ACCENT = new FluentTokenType("^");
  IElementType ANGLE_L = new FluentTokenType("<");
  IElementType ANGLE_R = new FluentTokenType(">");
  IElementType AT = new FluentTokenType("@");
  IElementType BRACE_L = new FluentTokenType("{");
  IElementType BRACE_R = new FluentTokenType("}");
  IElementType BRACKET_L = new FluentTokenType("[");
  IElementType BRACKET_R = new FluentTokenType("]");
  IElementType CATCH = new FluentTokenType("catch");
  IElementType CLASS = new FluentTokenType("class");
  IElementType COLON = new FluentTokenType(":");
  IElementType COMMA = new FluentTokenType(",");
  IElementType COMMENT = new FluentTokenType("Comment");
  IElementType COMMENT_BLOCK = new FluentTokenType("Comment Block");
  IElementType COMMENT_DOCUMENT = new FluentTokenType("Comment Document");
  IElementType COMMENT_LINE = new FluentTokenType("Comment Line");
  IElementType DECIMAL = new FluentTokenType("DECIMAL");
  IElementType DEF = new FluentTokenType("def");
  IElementType DOLLAR = new FluentTokenType("$");
  IElementType DOT = new FluentTokenType(".");
  IElementType ELSE = new FluentTokenType("else");
  IElementType EQ = new FluentTokenType("=");
  IElementType FOR = new FluentTokenType("for");
  IElementType HYPHEN = new FluentTokenType("-");
  IElementType IF = new FluentTokenType("if");
  IElementType IN = new FluentTokenType("in");
  IElementType INTEGER = new FluentTokenType("INTEGER");
  IElementType LET = new FluentTokenType("let");
  IElementType MATCH = new FluentTokenType("match");
  IElementType PARENTHESIS_L = new FluentTokenType("(");
  IElementType PARENTHESIS_R = new FluentTokenType(")");
  IElementType SELECTION_LINE = new FluentTokenType("SELECTION_LINE");
  IElementType SEMICOLON = new FluentTokenType(";");
  IElementType STAR = new FluentTokenType("*");
  IElementType STRING_CHAR = new FluentTokenType("String Character");
  IElementType STRING_ESCAPE = new FluentTokenType("String Escaped");
  IElementType STRING_LITERAL = new FluentTokenType("String Literal");
  IElementType STRING_QUOTE = new FluentTokenType("String Quote");
  IElementType SYMBOL = new FluentTokenType("Symbol");
  IElementType TO = new FluentTokenType("->");
  IElementType TRAIT = new FluentTokenType("trait");
  IElementType URL = new FluentTokenType("Url");
  IElementType WHILE = new FluentTokenType("while");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ATOMS) {
        return new FluentAtomsNode(node);
      }
      else if (type == BLOCK) {
        return new FluentBlockNode(node);
      }
      else if (type == BRACE_BLOCK) {
        return new FluentBraceBlockNode(node);
      }
      else if (type == BRACKET_BLOCK) {
        return new FluentBracketBlockNode(node);
      }
      else if (type == CLASS_STATEMENT) {
        return new FluentClassStatementNode(node);
      }
      else if (type == CONDITION) {
        return new FluentConditionNode(node);
      }
      else if (type == DEF_STATEMENT) {
        return new FluentDefStatementNode(node);
      }
      else if (type == FOR_STATEMENT) {
        return new FluentForStatementNode(node);
      }
      else if (type == IF_STATEMENT) {
        return new FluentIfStatementNode(node);
      }
      else if (type == LET_STATEMENT) {
        return new FluentLetStatementNode(node);
      }
      else if (type == MATCH_STATEMENT) {
        return new FluentMatchStatementNode(node);
      }
      else if (type == NAMESPACE) {
        return new FluentNamespaceNode(node);
      }
      else if (type == PARENTHESIS) {
        return new FluentParenthesisNode(node);
      }
      else if (type == PATTERN) {
        return new FluentPatternNode(node);
      }
      else if (type == TRAIT_STATEMENT) {
        return new FluentTraitStatementNode(node);
      }
      else if (type == WHILE_STATEMENT) {
        return new FluentWhileStatementNode(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
