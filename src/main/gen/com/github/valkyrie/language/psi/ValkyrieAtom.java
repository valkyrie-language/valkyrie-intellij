// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieAtom extends PsiElement {

  @Nullable
  ValkyrieBoolean getBoolean();

  @Nullable
  ValkyrieList getList();

  @Nullable
  ValkyrieNamepath getNamepath();

  @Nullable
  ValkyrieNumber getNumber();

  @Nullable
  ValkyrieRange getRange();

  @Nullable
  ValkyrieString getString();

  @Nullable
  ValkyrieTuple getTuple();

}
