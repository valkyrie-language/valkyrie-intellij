// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieBitflagItem extends PsiElement {

  @NotNull
  List<ValkyrieFunctionCall> getFunctionCallList();

  @NotNull
  List<ValkyrieList> getListList();

  @Nullable
  ValkyrieMacro getMacro();

  @NotNull
  List<ValkyrieNamespace> getNamespaceList();

  @NotNull
  List<ValkyrieTuple> getTupleList();

}
