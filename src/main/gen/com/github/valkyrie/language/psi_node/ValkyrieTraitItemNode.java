// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi_node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.valkyrie.language.psi.ValkyrieTypes.*;
import com.github.valkyrie.language.psi.ValkyrieElement;
import com.github.valkyrie.language.psi.*;

public class ValkyrieTraitItemNode extends ValkyrieElement implements ValkyrieTraitItem {

  public ValkyrieTraitItemNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ValkyrieVisitor visitor) {
    visitor.visitTraitItem(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ValkyrieDefStatement getDefStatement() {
    return findChildByClass(ValkyrieDefStatement.class);
  }

  @Override
  @Nullable
  public ValkyrieForStatement getForStatement() {
    return findChildByClass(ValkyrieForStatement.class);
  }

  @Override
  @Nullable
  public ValkyrieForallStatement getForallStatement() {
    return findChildByClass(ValkyrieForallStatement.class);
  }

  @Override
  @Nullable
  public ValkyrieIfStatement getIfStatement() {
    return findChildByClass(ValkyrieIfStatement.class);
  }

  @Override
  @Nullable
  public ValkyrieLetStatement getLetStatement() {
    return findChildByClass(ValkyrieLetStatement.class);
  }

  @Override
  @Nullable
  public ValkyrieMatchStatement getMatchStatement() {
    return findChildByClass(ValkyrieMatchStatement.class);
  }

  @Override
  @Nullable
  public ValkyrieTypeStatement getTypeStatement() {
    return findChildByClass(ValkyrieTypeStatement.class);
  }

  @Override
  @Nullable
  public ValkyrieWhileStatement getWhileStatement() {
    return findChildByClass(ValkyrieWhileStatement.class);
  }

}
