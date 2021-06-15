// This is a generated file. Not intended for manual editing.
package valkyrie.language.psi_node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static valkyrie.language.psi.ValkyrieTypes.*;
import valkyrie.language.mixin.MixinTrait;
import valkyrie.language.psi.*;
import valkyrie.language.ast.ASTMethods;

public class ValkyrieTraitStatementNode extends MixinTrait implements ValkyrieTraitStatement {

  public ValkyrieTraitStatementNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ValkyrieVisitor visitor) {
    visitor.visitTraitStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ValkyrieClassBlock getClassBlock() {
    return findChildByClass(ValkyrieClassBlock.class);
  }

  @Override
  @Nullable
  public ValkyrieGenericType getGenericType() {
    return findChildByClass(ValkyrieGenericType.class);
  }

  @Override
  @NotNull
  public ValkyrieModified getModified() {
    return findNotNullChildByClass(ValkyrieModified.class);
  }

  @Override
  @Nullable
  public ValkyrieTypeExpression getTypeExpression() {
    return findChildByClass(ValkyrieTypeExpression.class);
  }

  @Override
  @NotNull
  public ValkyrieIdentifierNode getIdentifier() {
    return ASTMethods.getIdentifier(this);
  }

  @Override
  @NotNull
  public ValkyrieIdentifierNode[] getModifiers() {
    return ASTMethods.getModifiers(this);
  }

}
