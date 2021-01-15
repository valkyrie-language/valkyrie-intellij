// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieMacroCall extends PsiElement {

  @NotNull
  List<ValkyrieFunctionCall> getFunctionCallList();

  @NotNull
  List<ValkyrieList> getListList();

  @NotNull
  ValkyrieMacro getMacro();

  @NotNull
  List<ValkyrieNamespace> getNamespaceList();

  @NotNull
  List<ValkyriePair> getPairList();

  @Nullable
  ValkyrieParenthesis getParenthesis();

  @NotNull
  List<ValkyrieTuple> getTupleList();

}
