// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieForStatement extends PsiElement {

  @NotNull
  ValkyrieBlock getBlock();

  @Nullable
  ValkyrieCasePattern getCasePattern();

  @Nullable
  ValkyrieElseStatement getElseStatement();

  @NotNull
  List<ValkyrieExpr> getExprList();

  @Nullable
  ValkyrieIfGuard getIfGuard();

  @Nullable
  ValkyrieNormalPattern getNormalPattern();

}
