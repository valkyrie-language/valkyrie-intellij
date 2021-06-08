// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieLetStatement extends PsiElement {

  @Nullable
  ValkyrieCasePattern getCasePattern();

  @Nullable
  ValkyrieCatchStatement getCatchStatement();

  @Nullable
  ValkyrieExpression getExpression();

  @Nullable
  ValkyrieForStatement getForStatement();

  @Nullable
  ValkyrieForallStatement getForallStatement();

  @Nullable
  ValkyrieIfStatement getIfStatement();

  @Nullable
  ValkyrieLetStatement getLetStatement();

  @Nullable
  ValkyrieLoopStatement getLoopStatement();

  @Nullable
  ValkyrieMacroCall getMacroCall();

  @Nullable
  ValkyrieMacroList getMacroList();

  @Nullable
  ValkyrieMatchStatement getMatchStatement();

  @Nullable
  ValkyrieNormalPattern getNormalPattern();

  @Nullable
  ValkyrieTryStatement getTryStatement();

  @NotNull
  List<ValkyrieTypeExpression> getTypeExpressionList();

  @Nullable
  ValkyrieTypeStatement getTypeStatement();

}
