// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.valkyrie.language.psi_node.*;

public interface FluentTypes {

  IElementType ATOMS = new FluentElementType("ATOMS");
  IElementType BLOCK = new FluentElementType("BLOCK");
  IElementType CONDITION = new FluentElementType("CONDITION");
  IElementType FOR_STATEMENT = new FluentElementType("FOR_STATEMENT");
  IElementType IF_STATEMENT = new FluentElementType("IF_STATEMENT");
  IElementType NAMESPACE = new FluentElementType("NAMESPACE");
  IElementType PATTERN = new FluentElementType("PATTERN");

  IElementType ACCENT = new FluentTokenType("^");
  IElementType ANGLE_L = new FluentTokenType("<");
  IElementType ANGLE_R = new FluentTokenType(">");
  IElementType AT = new FluentTokenType("@");
  IElementType BRACE_L = new FluentTokenType("{");
  IElementType BRACE_R = new FluentTokenType("}");
  IElementType BRACKET_L = new FluentTokenType("[");
  IElementType BRACKET_R = new FluentTokenType("]");
  IElementType COLON = new FluentTokenType(":");
  IElementType COMMA = new FluentTokenType(",");
  IElementType COMMENT = new FluentTokenType("Comment");
  IElementType COMMENT_BLOCK = new FluentTokenType("Comment Block");
  IElementType COMMENT_DOCUMENT = new FluentTokenType("Comment Document");
  IElementType COMMENT_LINE = new FluentTokenType("Comment Line");
  IElementType DECIMAL = new FluentTokenType("DECIMAL");
  IElementType DOLLAR = new FluentTokenType("$");
  IElementType DOT = new FluentTokenType(".");
  IElementType ELSE = new FluentTokenType("else");
  IElementType EQ = new FluentTokenType("=");
  IElementType FOR = new FluentTokenType("for");
  IElementType HYPHEN = new FluentTokenType("-");
  IElementType IF = new FluentTokenType("if");
  IElementType IN = new FluentTokenType("in");
  IElementType INTEGER = new FluentTokenType("INTEGER");
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
  IElementType URL = new FluentTokenType("Url");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ATOMS) {
        return new FluentAtomsNode(node);
      }
      else if (type == BLOCK) {
        return new FluentBlockNode(node);
      }
      else if (type == CONDITION) {
        return new FluentConditionNode(node);
      }
      else if (type == FOR_STATEMENT) {
        return new FluentForStatementNode(node);
      }
      else if (type == IF_STATEMENT) {
        return new FluentIfStatementNode(node);
      }
      else if (type == NAMESPACE) {
        return new FluentNamespaceNode(node);
      }
      else if (type == PATTERN) {
        return new FluentPatternNode(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
