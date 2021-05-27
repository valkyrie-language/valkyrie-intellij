// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieLetStatement extends PsiElement {

  @Nullable
  ValkyrieCasePattern getCasePattern();

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
  ValkyrieLetTypeHint getLetTypeHint();

  @Nullable
  ValkyrieMacroCall getMacroCall();

  @Nullable
  ValkyrieMatchStatement getMatchStatement();

  @Nullable
  ValkyrieNewStatement getNewStatement();

  @Nullable
  ValkyrieNormalPattern getNormalPattern();

  @Nullable
  ValkyrieTypeStatement getTypeStatement();

  @Nullable
  ValkyrieWhileStatement getWhileStatement();

}
