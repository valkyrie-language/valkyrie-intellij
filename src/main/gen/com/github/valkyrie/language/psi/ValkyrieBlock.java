// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieBlock extends PsiElement {

  @NotNull
  List<ValkyrieFunctionCall> getFunctionCallList();

  @NotNull
  List<ValkyrieList> getListList();

  @NotNull
  List<ValkyrieNamespace> getNamespaceList();

  @NotNull
  List<ValkyrieNumber> getNumberList();

  @NotNull
  List<ValkyrieTuple> getTupleList();

}
