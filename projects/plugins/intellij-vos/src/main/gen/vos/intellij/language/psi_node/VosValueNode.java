// This is a generated file. Not intended for manual editing.
package vos.intellij.language.psi_node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static vos.intellij.language.psi.VosTypes.*;
import vos.intellij.language.mixin.MixinValue;
import vos.intellij.language.psi.*;
import vos.intellij.language.mixin.NodeExtension;


public class VosValueNode extends MixinValue implements VosValue {

  public VosValueNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull VosVisitor visitor) {
    visitor.visitValue(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VosVisitor) accept((VosVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public VosArray getArray() {
    return findChildByClass(VosArray.class);
  }

  @Override
  @Nullable
  public VosBoolean getBoolean() {
    return findChildByClass(VosBoolean.class);
  }

  @Override
  @Nullable
  public VosNamespace getNamespace() {
    return findChildByClass(VosNamespace.class);
  }

  @Override
  @Nullable
  public VosNull getNull() {
    return findChildByClass(VosNull.class);
  }

  @Override
  @Nullable
  public VosObject getObject() {
    return findChildByClass(VosObject.class);
  }

  @Override
  @Nullable
  public VosStringLiteral getStringLiteral() {
    return findChildByClass(VosStringLiteral.class);
  }

  @Override
  @Nullable
  public VosUrlMaybeValid getUrlMaybeValid() {
    return findChildByClass(VosUrlMaybeValid.class);
  }

}
