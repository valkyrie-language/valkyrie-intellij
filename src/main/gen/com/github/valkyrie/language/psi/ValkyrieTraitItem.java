// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieTraitItem extends PsiElement {

  @Nullable
  ValkyrieDefStatement getDefStatement();

  @Nullable
  ValkyrieForStatement getForStatement();

  @Nullable
  ValkyrieForallStatement getForallStatement();

  @Nullable
  ValkyrieIfStatement getIfStatement();

  @Nullable
  ValkyrieLetStatement getLetStatement();

  @Nullable
  ValkyrieMatchStatement getMatchStatement();

  @Nullable
  ValkyrieTypeStatement getTypeStatement();

  @Nullable
  ValkyrieWhileStatement getWhileStatement();

}
