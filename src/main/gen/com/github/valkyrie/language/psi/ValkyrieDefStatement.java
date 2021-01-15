// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieDefStatement extends PsiElement {

  @NotNull
  ValkyrieBlock getBlock();

  @Nullable
  ValkyrieFunctionCall getFunctionCall();

  @Nullable
  ValkyrieList getList();

  @Nullable
  ValkyrieNamespace getNamespace();

  @Nullable
  ValkyrieTuple getTuple();

}
