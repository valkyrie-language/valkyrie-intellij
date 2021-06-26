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

public class ValkyrieMatchExpressionNode extends ValkyrieASTBase implements ValkyrieMatchExpression {

  public ValkyrieMatchExpressionNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ValkyrieVisitor visitor) {
    visitor.visitMatchExpression(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public ValkyrieCasePattern getCasePattern() {
    return findNotNullChildByClass(ValkyrieCasePattern.class);
  }

  @Override
  @NotNull
  public List<ValkyrieCatchStatement> getCatchStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieCatchStatement.class);
  }

  @Override
  @NotNull
  public List<ValkyrieControlStatement> getControlStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieControlStatement.class);
  }

  @Override
  @NotNull
  public List<ValkyrieExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieExpression.class);
  }

  @Override
  @NotNull
  public List<ValkyrieForStatement> getForStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieForStatement.class);
  }

  @Override
  @NotNull
  public List<ValkyrieForallStatement> getForallStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieForallStatement.class);
  }

  @Override
  @NotNull
  public List<ValkyrieLetStatement> getLetStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieLetStatement.class);
  }

  @Override
  @NotNull
  public List<ValkyrieLoopStatement> getLoopStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieLoopStatement.class);
  }

  @Override
  @NotNull
  public List<ValkyrieMacroCall> getMacroCallList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieMacroCall.class);
  }

  @Override
  @NotNull
  public List<ValkyrieMacroList> getMacroListList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieMacroList.class);
  }

  @Override
  @NotNull
  public List<ValkyrieMatchStatement> getMatchStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieMatchStatement.class);
  }

  @Override
  @NotNull
  public List<ValkyrieTypeStatement> getTypeStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieTypeStatement.class);
  }

}
