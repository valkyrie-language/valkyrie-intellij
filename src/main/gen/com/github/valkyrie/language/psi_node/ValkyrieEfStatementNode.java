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

public class ValkyrieEfStatementNode extends ValkyrieASTBase implements ValkyrieEfStatement {

  public ValkyrieEfStatementNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ValkyrieVisitor visitor) {
    visitor.visitEfStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public ValkyrieCondition getCondition() {
    return findNotNullChildByClass(ValkyrieCondition.class);
  }

  @Override
  @NotNull
  public ValkyrieKwElseIf getKwElseIf() {
    return findNotNullChildByClass(ValkyrieKwElseIf.class);
  }

  @Override
  @NotNull
  public ValkyrieNormalBlock getNormalBlock() {
    return findNotNullChildByClass(ValkyrieNormalBlock.class);
  }

}
