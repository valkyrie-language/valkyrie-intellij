// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.github.valkyrie.language.psi.FluentTypes.*;
import static com.github.valkyrie.language.psi.FluentParserExtension.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class FluentParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return valkyrie(b, l + 1);
  }

  /* ********************************************************** */
  // "for"
  static boolean FOR(PsiBuilder b, int l) {
    return consumeToken(b, "for");
  }

  /* ********************************************************** */
  // INTEGER | DECIMAL
  public static boolean atoms(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atoms")) return false;
    if (!nextTokenIs(b, "<atoms>", DECIMAL, INTEGER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ATOMS, "<atoms>");
    r = consumeToken(b, INTEGER);
    if (!r) r = consumeToken(b, DECIMAL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // expression
  public static boolean block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block")) return false;
    if (!nextTokenIs(b, SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1);
    exit_section_(b, m, BLOCK, r);
    return r;
  }

  /* ********************************************************** */
  // expression
  public static boolean condition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condition")) return false;
    if (!nextTokenIs(b, SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1);
    exit_section_(b, m, CONDITION, r);
    return r;
  }

  /* ********************************************************** */
  // namespace
  static boolean expression(PsiBuilder b, int l) {
    return namespace(b, l + 1);
  }

  /* ********************************************************** */
  // FOR
  public static boolean for_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FOR_STATEMENT, "<for statement>");
    r = FOR(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (IF condition block) [(ELSE IF condition block)* (ELSE block)]
  public static boolean if_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = if_statement_0(b, l + 1);
    r = r && if_statement_1(b, l + 1);
    exit_section_(b, m, IF_STATEMENT, r);
    return r;
  }

  // IF condition block
  private static boolean if_statement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF);
    r = r && condition(b, l + 1);
    r = r && block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [(ELSE IF condition block)* (ELSE block)]
  private static boolean if_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_1")) return false;
    if_statement_1_0(b, l + 1);
    return true;
  }

  // (ELSE IF condition block)* (ELSE block)
  private static boolean if_statement_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = if_statement_1_0_0(b, l + 1);
    r = r && if_statement_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (ELSE IF condition block)*
  private static boolean if_statement_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_1_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!if_statement_1_0_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "if_statement_1_0_0", c)) break;
    }
    return true;
  }

  // ELSE IF condition block
  private static boolean if_statement_1_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_1_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ELSE, IF);
    r = r && condition(b, l + 1);
    r = r && block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ELSE block
  private static boolean if_statement_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // SYMBOL
  public static boolean namespace(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namespace")) return false;
    if (!nextTokenIs(b, SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SYMBOL);
    exit_section_(b, m, NAMESPACE, r);
    return r;
  }

  /* ********************************************************** */
  // if_statement
  //   | for_statement
  static boolean statements(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statements")) return false;
    boolean r;
    r = if_statement(b, l + 1);
    if (!r) r = for_statement(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // statements*
  static boolean valkyrie(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "valkyrie")) return false;
    while (true) {
      int c = current_position_(b);
      if (!statements(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "valkyrie", c)) break;
    }
    return true;
  }

}
