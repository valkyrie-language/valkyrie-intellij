// This is a generated file. Not intended for manual editing.
package valkyrie.language.psi_node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static valkyrie.language.psi.ValkyrieTypes.*;
import valkyrie.language.ast.ValkyrieASTBase;
import valkyrie.language.psi.*;
import valkyrie.language.ast.ASTMethods;

public class ValkyrieCaseExpressionNode extends ValkyrieASTBase implements ValkyrieCaseExpression {

  public ValkyrieCaseExpressionNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ValkyrieVisitor visitor) {
    visitor.visitCaseExpression(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ValkyrieExtractor getExtractor() {
    return findChildByClass(ValkyrieExtractor.class);
  }

  @Override
  @Nullable
  public ValkyrieInlineExpression getInlineExpression() {
    return findChildByClass(ValkyrieInlineExpression.class);
  }

}
