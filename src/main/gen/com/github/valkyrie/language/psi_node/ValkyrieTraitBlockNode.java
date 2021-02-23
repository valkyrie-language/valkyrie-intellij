// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi_node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import com.github.valkyrie.language.mixin.ValkyrieElement;
import com.github.valkyrie.language.psi.*;

public class ValkyrieTraitBlockNode extends ValkyrieElement implements ValkyrieTraitBlock {

  public ValkyrieTraitBlockNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ValkyrieVisitor visitor) {
    visitor.visitTraitBlock(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<ValkyrieDefStatement> getDefStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieDefStatement.class);
  }

  @Override
  @NotNull
  public List<ValkyrieExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieExpression.class);
  }

  @Override
  @NotNull
  public List<ValkyrieForStatement> getForStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieForStatement.class);
  }

  @Override
  @NotNull
  public List<ValkyrieForallStatement> getForallStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieForallStatement.class);
  }

  @Override
  @NotNull
  public List<ValkyrieIfStatement> getIfStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieIfStatement.class);
  }

  @Override
  @NotNull
  public List<ValkyrieLetStatement> getLetStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieLetStatement.class);
  }

  @Override
  @NotNull
  public List<ValkyrieMatchStatement> getMatchStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieMatchStatement.class);
  }

  @Override
  @NotNull
  public List<ValkyrieTypeStatement> getTypeStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieTypeStatement.class);
  }

  @Override
  @NotNull
  public List<ValkyrieWhileStatement> getWhileStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieWhileStatement.class);
  }

}
