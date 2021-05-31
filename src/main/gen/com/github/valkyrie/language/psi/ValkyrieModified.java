// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.github.valkyrie.ide.view.ValkyrieViewElement;

public interface ValkyrieModified extends PsiElement {

  @Nullable
  ValkyrieModifiers getModifiers();

  void addChildrenView(@NotNull List<ValkyrieViewElement> list);

}
