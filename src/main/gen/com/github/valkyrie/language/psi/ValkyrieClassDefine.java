// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieClassDefine extends PsiElement {

  @Nullable
  ValkyrieDefineBlock getDefineBlock();

  @NotNull
  ValkyrieDefineTuple getDefineTuple();

  @Nullable
  ValkyrieExpression getExpression();

  @NotNull
  ValkyrieModified getModified();

  //WARNING: getIdentifier(...) is skipped
  //matching getIdentifier(ValkyrieClassDefine, ...)
  //methods are not found in ASTMethods

  //WARNING: getModifiers(...) is skipped
  //matching getModifiers(ValkyrieClassDefine, ...)
  //methods are not found in ASTMethods

}
