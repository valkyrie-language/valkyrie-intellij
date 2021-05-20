// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi_node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.valkyrie.language.psi.ValkyrieTypes.*;
import com.github.valkyrie.language.mixin.MixinExtends;
import com.github.valkyrie.language.psi.*;
import com.github.valkyrie.language.ast.ASTMethods;

public class ValkyrieExtendsStatementNode extends MixinExtends implements ValkyrieExtendsStatement {

  public ValkyrieExtendsStatementNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ValkyrieVisitor visitor) {
    visitor.visitExtendsStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public ValkyrieClassBlock getClassBlock() {
    return notNullChild(PsiTreeUtil.getChildOfType(this, ValkyrieClassBlock.class));
  }

  @Override
  @NotNull
  public ValkyrieIdentifier getIdentifier() {
    return notNullChild(PsiTreeUtil.getChildOfType(this, ValkyrieIdentifier.class));
  }

  @Override
  @Nullable
  public ValkyrieMaybeModifier getMaybeModifier() {
    return PsiTreeUtil.getChildOfType(this, ValkyrieMaybeModifier.class);
  }

  @Override
  @Nullable
  public ValkyrieTypeExpression getTypeExpression() {
    return PsiTreeUtil.getChildOfType(this, ValkyrieTypeExpression.class);
  }

  @Override
  @NotNull
  public List<ValkyrieTypeGeneric> getTypeGenericList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieTypeGeneric.class);
  }

}
