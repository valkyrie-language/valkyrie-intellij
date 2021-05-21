// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.github.valkyrie.language.psi_node.ValkyrieIdentifierNode;

public interface ValkyrieDefineStatement extends PsiElement {

  @Nullable
  ValkyrieDefineBlock getDefineBlock();

  @NotNull
  ValkyrieDefineTuple getDefineTuple();

  @Nullable
  ValkyrieExpression getExpression();

  @Nullable
  ValkyrieGenericDefine getGenericDefine();

  @Nullable
  ValkyrieMaybeModifier getMaybeModifier();

  @NotNull
  ValkyrieNamepathFree getNamepathFree();

  @NotNull
  ValkyrieIdentifierNode[] getModifiers();

}
