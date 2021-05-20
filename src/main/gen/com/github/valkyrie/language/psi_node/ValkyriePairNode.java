// This is a generated file. Not intended for manual editing.
package com.github.valkyrie.language.psi_node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.valkyrie.language.psi.ValkyrieTypes.*;
import com.github.valkyrie.language.ast.ValkyrieASTBase;
import com.github.valkyrie.language.psi.*;
import com.github.valkyrie.language.ast.ASTMethods;

public class ValkyriePairNode extends ValkyrieASTBase implements ValkyriePair {

  public ValkyriePairNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ValkyrieVisitor visitor) {
    visitor.visitPair(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ValkyrieBoolean getBoolean() {
    return PsiTreeUtil.getChildOfType(this, ValkyrieBoolean.class);
  }

  @Override
  @NotNull
  public ValkyrieExpression getExpression() {
    return notNullChild(PsiTreeUtil.getChildOfType(this, ValkyrieExpression.class));
  }

  @Override
  @Nullable
  public ValkyrieNamepath getNamepath() {
    return PsiTreeUtil.getChildOfType(this, ValkyrieNamepath.class);
  }

  @Override
  @Nullable
  public ValkyrieNumber getNumber() {
    return PsiTreeUtil.getChildOfType(this, ValkyrieNumber.class);
  }

  @Override
  @Nullable
  public ValkyrieString getString() {
    return PsiTreeUtil.getChildOfType(this, ValkyrieString.class);
  }

}
