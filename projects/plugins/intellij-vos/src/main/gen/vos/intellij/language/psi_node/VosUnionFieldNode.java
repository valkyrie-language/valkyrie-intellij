// This is a generated file. Not intended for manual editing.
package vos.intellij.language.psi_node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static vos.intellij.language.psi.VosTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import vos.intellij.language.psi.*;
import vos.intellij.language.mixin.NodeExtension;

public class VosUnionFieldNode extends ASTWrapperPsiElement implements VosUnionField {

  public VosUnionFieldNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull VosVisitor visitor) {
    visitor.visitUnionField(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VosVisitor) accept((VosVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public VosClassBlock getClassBlock() {
    return findChildByClass(VosClassBlock.class);
  }

  @Override
  @NotNull
  public VosIdentifier getIdentifier() {
    return findNotNullChildByClass(VosIdentifier.class);
  }

  @Override
  @Nullable
  public VosIntegerSigned getIntegerSigned() {
    return findChildByClass(VosIntegerSigned.class);
  }

}
