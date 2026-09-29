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

public class VosClassBlockNode extends ASTWrapperPsiElement implements VosClassBlock {

  public VosClassBlockNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull VosVisitor visitor) {
    visitor.visitClassBlock(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VosVisitor) accept((VosVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<VosAnnotation> getAnnotationList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, VosAnnotation.class);
  }

  @Override
  @NotNull
  public List<VosClassBound> getClassBoundList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, VosClassBound.class);
  }

  @Override
  @NotNull
  public List<VosClassField> getClassFieldList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, VosClassField.class);
  }

}
