// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieForStatement extends PsiElement {

  @NotNull
  ValkyrieBlock getBlock();

  @Nullable
  ValkyrieElseStatement getElseStatement();

  @Nullable
  ValkyrieIfGuard getIfGuard();

  @Nullable
  ValkyrieNamespace getNamespace();

  @NotNull
  ValkyriePattern getPattern();

}
