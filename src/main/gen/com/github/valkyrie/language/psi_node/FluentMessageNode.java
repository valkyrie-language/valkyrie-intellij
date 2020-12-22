// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi_node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import com.github.valkyrie.language.psi.FluentElement;
import com.github.valkyrie.language.psi.*;

public class FluentMessageNode extends FluentElement implements FluentMessage {

  public FluentMessageNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull FluentVisitor visitor) {
    visitor.visitMessage(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FluentVisitor) accept((FluentVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<FluentAttribute> getAttributeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, FluentAttribute.class);
  }

  @Override
  @NotNull
  public FluentMessageID getMessageID() {
    return findNotNullChildByClass(FluentMessageID.class);
  }

  @Override
  @Nullable
  public FluentPattern getPattern() {
    return findChildByClass(FluentPattern.class);
  }

}
