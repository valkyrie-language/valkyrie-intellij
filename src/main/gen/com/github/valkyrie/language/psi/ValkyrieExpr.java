// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieExpr extends PsiElement {

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

  @Nullable
  ValkyrieTuple getTuple();

  @NotNull
  List<ValkyrieTypeAngle> getTypeAngleList();

}
