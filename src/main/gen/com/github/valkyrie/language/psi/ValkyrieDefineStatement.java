// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieDefineStatement extends PsiElement {

  @Nullable
  ValkyrieDefineBlock getDefineBlock();

  @Nullable
  ValkyrieDefineTuple getDefineTuple();

  @Nullable
  ValkyrieEffectExpression getEffectExpression();

  @Nullable
  ValkyrieGenericDefine getGenericDefine();

  @NotNull
  ValkyrieModified getModified();

  @Nullable
  ValkyrieTypeExpression getTypeExpression();

  //WARNING: getNamepath(...) is skipped
  //matching getNamepath(ValkyrieDefineStatement, ...)
  //methods are not found in ASTMethods

  //WARNING: getModifiers(...) is skipped
  //matching getModifiers(ValkyrieDefineStatement, ...)
  //methods are not found in ASTMethods

}
