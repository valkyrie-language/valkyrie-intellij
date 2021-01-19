// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;

import com.intellij.psi.NavigatablePsiElement;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieBitflagStatement extends PsiElement, NavigatablePsiElement {

  @Nullable
  ValkyrieAutoDerive getAutoDerive();

  @NotNull
  ValkyrieBitflagBlock getBitflagBlock();

  @Nullable
  ValkyrieBitflagLayout getBitflagLayout();

  @NotNull
  ValkyrieModifiers getModifiers();

}
