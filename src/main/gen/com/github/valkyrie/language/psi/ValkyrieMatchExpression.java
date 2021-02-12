// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieMatchExpression extends PsiElement {

  @NotNull
  ValkyrieCasePattern getCasePattern();

  @NotNull
  List<ValkyrieDefStatement> getDefStatementList();

  @NotNull
  List<ValkyrieForStatement> getForStatementList();

  @NotNull
  List<ValkyrieIfStatement> getIfStatementList();

  @NotNull
  List<ValkyrieLetStatement> getLetStatementList();

  @NotNull
  List<ValkyrieMatchStatement> getMatchStatementList();

  @NotNull
  List<ValkyrieTypeStatement> getTypeStatementList();

  @NotNull
  List<ValkyrieWhileStatement> getWhileStatementList();

}