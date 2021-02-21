// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieTypeStatement extends PsiElement {

  @Nullable
  ValkyrieBoolean getBoolean();

  @NotNull
  List<ValkyrieCallSuffix> getCallSuffixList();

  @Nullable
  ValkyrieList getList();

  @Nullable
  ValkyrieNamespace getNamespace();

  @Nullable
  ValkyrieNumber getNumber();

  @NotNull
  List<ValkyrieSliceSuffix> getSliceSuffixList();

  @Nullable
  ValkyrieString getString();

  @NotNull
  ValkyrieSymbol getSymbol();

  @Nullable
  ValkyrieTuple getTuple();

  @NotNull
  List<ValkyrieTypeAngle> getTypeAngleList();

}
