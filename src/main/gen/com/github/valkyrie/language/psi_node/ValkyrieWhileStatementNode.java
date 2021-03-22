// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi_node;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.github.valkyrie.language.ast.ValkyrieElement;
import com.github.valkyrie.language.psi.*;

public class ValkyrieWhileStatementNode extends ValkyrieElement implements ValkyrieWhileStatement {

  public ValkyrieWhileStatementNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ValkyrieVisitor visitor) {
    visitor.visitWhileStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public ValkyrieBlock getBlock() {
    return findNotNullChildByClass(ValkyrieBlock.class);
  }

  @Override
  @NotNull
  public ValkyrieCondition getCondition() {
    return findNotNullChildByClass(ValkyrieCondition.class);
  }

}
