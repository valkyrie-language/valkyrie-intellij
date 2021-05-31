// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.github.valkyrie.language.psi_node.ValkyrieIdentifierNode;

public interface ValkyrieClassStatement extends PsiElement {

  @Nullable
  ValkyrieClassBlock getClassBlock();

  @Nullable
  ValkyrieClassInherit getClassInherit();

  @Nullable
  ValkyrieClassTuple getClassTuple();

  @Nullable
  ValkyrieGenericDefine getGenericDefine();

  @NotNull
  ValkyrieModified getModified();

  @NotNull
  ValkyrieIdentifierNode getIdentifier();

  @NotNull
  ValkyrieIdentifierNode[] getModifiers();

}
