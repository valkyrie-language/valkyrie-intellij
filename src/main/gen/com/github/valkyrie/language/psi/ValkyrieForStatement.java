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

  @NotNull
  List<ValkyrieFunctionCall> getFunctionCallList();

  @Nullable
  ValkyrieIfGuard getIfGuard();

  @NotNull
  List<ValkyrieList> getListList();

  @NotNull
  List<ValkyrieNamespace> getNamespaceList();

  @NotNull
  ValkyriePattern getPattern();

  @NotNull
  List<ValkyrieTuple> getTupleList();

}
