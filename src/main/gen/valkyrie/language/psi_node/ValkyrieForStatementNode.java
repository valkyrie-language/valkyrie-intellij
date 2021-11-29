// This is a generated file. Not intended for manual editing.
package valkyrie.language.psi_node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static valkyrie.language.psi.ValkyrieTypes.*;
import valkyrie.language.mixin.MixinFor;
import valkyrie.language.psi.*;
import valkyrie.language.ast.ASTMethods;

public class ValkyrieForStatementNode extends MixinFor implements ValkyrieForStatement {

  public ValkyrieForStatementNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ValkyrieVisitor visitor) {
    visitor.visitForStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ValkyrieCaseBranch getCaseBranch() {
    return findChildByClass(ValkyrieCaseBranch.class);
  }

  @Override
  @Nullable
  public ValkyrieElseStatement getElseStatement() {
    return findChildByClass(ValkyrieElseStatement.class);
  }

  @Override
  @Nullable
  public ValkyrieIfGuard getIfGuard() {
    return findChildByClass(ValkyrieIfGuard.class);
  }

  @Override
  @Nullable
  public ValkyrieInlineExpression getInlineExpression() {
    return findChildByClass(ValkyrieInlineExpression.class);
  }

  @Override
  @Nullable
  public ValkyrieNormalBlock getNormalBlock() {
    return findChildByClass(ValkyrieNormalBlock.class);
  }

  @Override
  @Nullable
  public ValkyrieNormalPattern getNormalPattern() {
    return findChildByClass(ValkyrieNormalPattern.class);
  }

}
