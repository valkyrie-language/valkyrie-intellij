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

public class ValkyrieLetStatementNode extends ValkyrieASTBase implements ValkyrieLetStatement {

  public ValkyrieLetStatementNode(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ValkyrieVisitor visitor) {
    visitor.visitLetStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ValkyrieCasePattern getCasePattern() {
    return findChildByClass(ValkyrieCasePattern.class);
  }

  @Override
  @Nullable
  public ValkyrieCatchStatement getCatchStatement() {
    return findChildByClass(ValkyrieCatchStatement.class);
  }

  @Override
  @Nullable
  public ValkyrieExpression getExpression() {
    return findChildByClass(ValkyrieExpression.class);
  }

  @Override
  @Nullable
  public ValkyrieForStatement getForStatement() {
    return findChildByClass(ValkyrieForStatement.class);
  }

  @Override
  @Nullable
  public ValkyrieForallStatement getForallStatement() {
    return findChildByClass(ValkyrieForallStatement.class);
  }

  @Override
  @Nullable
  public ValkyrieIfStatement getIfStatement() {
    return findChildByClass(ValkyrieIfStatement.class);
  }

  @Override
  @Nullable
  public ValkyrieLetStatement getLetStatement() {
    return findChildByClass(ValkyrieLetStatement.class);
  }

  @Override
  @Nullable
  public ValkyrieLoopStatement getLoopStatement() {
    return findChildByClass(ValkyrieLoopStatement.class);
  }

  @Override
  @Nullable
  public ValkyrieMacroCall getMacroCall() {
    return findChildByClass(ValkyrieMacroCall.class);
  }

  @Override
  @Nullable
  public ValkyrieMacroList getMacroList() {
    return findChildByClass(ValkyrieMacroList.class);
  }

  @Override
  @Nullable
  public ValkyrieMatchStatement getMatchStatement() {
    return findChildByClass(ValkyrieMatchStatement.class);
  }

  @Override
  @Nullable
  public ValkyrieNormalPattern getNormalPattern() {
    return findChildByClass(ValkyrieNormalPattern.class);
  }

  @Override
  @Nullable
  public ValkyrieTryStatement getTryStatement() {
    return findChildByClass(ValkyrieTryStatement.class);
  }

  @Override
  @NotNull
  public List<ValkyrieTypeExpression> getTypeExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieTypeExpression.class);
  }

  @Override
  @Nullable
  public ValkyrieTypeStatement getTypeStatement() {
    return findChildByClass(ValkyrieTypeStatement.class);
  }

}
