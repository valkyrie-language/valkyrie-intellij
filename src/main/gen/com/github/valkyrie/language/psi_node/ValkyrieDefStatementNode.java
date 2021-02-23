// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi_node;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.github.valkyrie.language.mixin.ValkyrieElement;
import com.github.valkyrie.language.psi.*;

public class ValkyrieDefStatementNode extends ValkyrieElement implements ValkyrieDefStatement {

  public ValkyrieDefStatementNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ValkyrieVisitor visitor) {
    visitor.visitDefStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ValkyrieDefBlock getDefBlock() {
    return findChildByClass(ValkyrieDefBlock.class);
  }

  @Override
  @NotNull
  public ValkyrieDefTuple getDefTuple() {
    return findNotNullChildByClass(ValkyrieDefTuple.class);
  }

  @Override
  @Nullable
  public ValkyrieExpression getExpression() {
    return findChildByClass(ValkyrieExpression.class);
  }

  @Override
  @NotNull
  public ValkyrieModifiers getModifiers() {
    return findNotNullChildByClass(ValkyrieModifiers.class);
  }

  @Override
  @Nullable
  public ValkyrieTypeAngle getTypeAngle() {
    return findChildByClass(ValkyrieTypeAngle.class);
  }

  @Override
  @Nullable
  public ValkyrieTypeExpression getTypeExpression() {
    return findChildByClass(ValkyrieTypeExpression.class);
  }

}
