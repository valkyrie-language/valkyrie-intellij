// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieBitflagStatement extends PsiElement {

  @NotNull
  ValkyrieBitflagBlock getBitflagBlock();

  @Nullable
  ValkyrieBitflagLayout getBitflagLayout();

  @Nullable
  ValkyrieList getList();

  @NotNull
  ValkyrieModifiers getModifiers();

  @Nullable
  ValkyrieNamespace getNamespace();

  @Nullable
  ValkyrieTuple getTuple();

}
