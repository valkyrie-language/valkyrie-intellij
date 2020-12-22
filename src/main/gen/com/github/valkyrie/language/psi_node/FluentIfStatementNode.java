// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi_node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.valkyrie.language.psi.FluentTypes.*;
import com.github.valkyrie.language.psi.FluentElement;
import com.github.valkyrie.language.psi.*;

public class FluentIfStatementNode extends FluentElement implements FluentIfStatement {

  public FluentIfStatementNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull FluentVisitor visitor) {
    visitor.visitIfStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FluentVisitor) accept((FluentVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<FluentBlock> getBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FluentBlock.class);
  }

  @Override
  @NotNull
  public List<FluentCondition> getConditionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FluentCondition.class);
  }

}
