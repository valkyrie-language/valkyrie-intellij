// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi_node;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.github.valkyrie.language.psi.FluentElement;
import com.github.valkyrie.language.psi.*;

public class FluentBlockPlaceableNode extends FluentElement implements FluentBlockPlaceable {

  public FluentBlockPlaceableNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull FluentVisitor visitor) {
    visitor.visitBlockPlaceable(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FluentVisitor) accept((FluentVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public FluentInlinePlaceable getInlinePlaceable() {
    return findNotNullChildByClass(FluentInlinePlaceable.class);
  }

}
