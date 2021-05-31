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

  @NotNull
  ValkyrieModified getModified();

  //WARNING: getNamepath(...) is skipped
  //matching getNamepath(ValkyrieDefineStatement, ...)
  //methods are not found in ASTMethods

  @NotNull
  ValkyrieIdentifierNode[] getModifiers();

}
