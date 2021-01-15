// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyriePair extends PsiElement {

  @Nullable
  ValkyrieFunctionCall getFunctionCall();

  @Nullable
  ValkyrieList getList();

  @NotNull
  List<ValkyrieNamespace> getNamespaceList();

  @Nullable
  ValkyrieTuple getTuple();

}
