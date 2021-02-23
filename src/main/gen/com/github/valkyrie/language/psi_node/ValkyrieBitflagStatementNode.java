// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi_node;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.github.valkyrie.language.mixin.ValkyrieElement;
import com.github.valkyrie.language.psi.*;

public class ValkyrieBitflagStatementNode extends ValkyrieElement implements ValkyrieBitflagStatement {

  public ValkyrieBitflagStatementNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ValkyrieVisitor visitor) {
    visitor.visitBitflagStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public ValkyrieBitflagBlock getBitflagBlock() {
    return findNotNullChildByClass(ValkyrieBitflagBlock.class);
  }

  @Override
  @Nullable
  public ValkyrieBitflagLayout getBitflagLayout() {
    return findChildByClass(ValkyrieBitflagLayout.class);
  }

  @Override
  @NotNull
  public ValkyrieModifiers getModifiers() {
    return findNotNullChildByClass(ValkyrieModifiers.class);
  }

}
