// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieForStatement extends PsiElement {

  @NotNull
  ValkyrieBlock getBlock();

  @NotNull
  List<ValkyrieBoolean> getBooleanList();

  @NotNull
  List<ValkyrieCallSuffix> getCallSuffixList();

  @Nullable
  ValkyrieCasePattern getCasePattern();

  @Nullable
  ValkyrieElseStatement getElseStatement();

  @Nullable
  ValkyrieIfGuard getIfGuard();

  @NotNull
  List<ValkyrieList> getListList();

  @NotNull
  List<ValkyrieNamespace> getNamespaceList();

  @NotNull
  List<ValkyrieNumber> getNumberList();

  @Nullable
  ValkyriePattern getPattern();

  @NotNull
  List<ValkyrieSliceSuffix> getSliceSuffixList();

  @NotNull
  List<ValkyrieString> getStringList();

  @NotNull
  List<ValkyrieTuple> getTupleList();

  @NotNull
  List<ValkyrieTurboSuffix> getTurboSuffixList();

}
