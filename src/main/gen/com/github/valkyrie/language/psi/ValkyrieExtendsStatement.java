// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.github.valkyrie.language.psi_node.ValkyrieIdentifierNode;

public interface ValkyrieExtendsStatement extends PsiElement {

  @Nullable
  ValkyrieClassBlock getClassBlock();

  @NotNull
  List<ValkyrieGenericCall> getGenericCallList();

  @NotNull
  ValkyrieModified getModified();

  @Nullable
  ValkyrieTypeExpression getTypeExpression();

  @NotNull
  ValkyrieIdentifierNode getIdentifier();

  @NotNull
  ValkyrieIdentifierNode[] getModifiers();

}
