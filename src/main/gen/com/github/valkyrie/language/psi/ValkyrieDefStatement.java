// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieDefStatement extends PsiElement {

  @NotNull
  List<ValkyrieBoolean> getBooleanList();

  @NotNull
  List<ValkyrieCallSuffix> getCallSuffixList();

  @Nullable
  ValkyrieDefBlock getDefBlock();

  @NotNull
  ValkyrieDefTuple getDefTuple();

  @NotNull
  List<ValkyrieList> getListList();

  @NotNull
  ValkyrieModifiers getModifiers();

  @NotNull
  List<ValkyrieNamespace> getNamespaceList();

  @NotNull
  List<ValkyrieNumber> getNumberList();

  @NotNull
  List<ValkyrieSliceSuffix> getSliceSuffixList();

  @NotNull
  List<ValkyrieString> getStringList();

  @NotNull
  List<ValkyrieTuple> getTupleList();

  @NotNull
  List<ValkyrieTypeAngle> getTypeAngleList();

}
