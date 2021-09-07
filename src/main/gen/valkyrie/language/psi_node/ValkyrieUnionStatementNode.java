// This is a generated file. Not intended for manual editing.
package valkyrie.language.psi_node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static valkyrie.language.psi.ValkyrieTypes.*;
import valkyrie.language.mixin.MixinUnion;
import valkyrie.language.psi.*;
import valkyrie.language.ast.ASTMethods;

public class ValkyrieUnionStatementNode extends MixinUnion implements ValkyrieUnionStatement {

  public ValkyrieUnionStatementNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ValkyrieVisitor visitor) {
    visitor.visitUnionStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ValkyrieClassEffect getClassEffect() {
    return findChildByClass(ValkyrieClassEffect.class);
  }

  @Override
  @Nullable
  public ValkyrieGenericDefine getGenericDefine() {
    return findChildByClass(ValkyrieGenericDefine.class);
  }

  @Override
  @NotNull
  public ValkyrieModified getModified() {
    return findNotNullChildByClass(ValkyrieModified.class);
  }

  @Override
  @Nullable
  public ValkyrieUnionBlock getUnionBlock() {
    return findChildByClass(ValkyrieUnionBlock.class);
  }

}