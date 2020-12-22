// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi_node;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.github.valkyrie.language.psi.FluentElement;
import com.github.valkyrie.language.psi.*;

public class FluentMessageReferenceNode extends FluentElement implements FluentMessageReference {

  public FluentMessageReferenceNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull FluentVisitor visitor) {
    visitor.visitMessageReference(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FluentVisitor) accept((FluentVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public FluentAttributeID getAttributeID() {
    return findChildByClass(FluentAttributeID.class);
  }

  @Override
  @NotNull
  public FluentMessageID getMessageID() {
    return findNotNullChildByClass(FluentMessageID.class);
  }

}
