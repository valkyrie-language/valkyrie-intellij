// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static valkyrie.psi.ValkyrieTypes.*;
import valkyrie.psi.ValkyrieElement;

public class ValkyrieBlockBareNode extends ValkyrieElement implements ValkyrieBlockBare {

    public ValkyrieBlockBareNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitBlockBare(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
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
    public List<ValkyrieIfCaseStatement> getIfCaseStatementList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieIfCaseStatement.class);
    }

    @Override
    @NotNull
    public List<ValkyrieIfStatement> getIfStatementList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieIfStatement.class);
    }

    @Override
    @NotNull
    public List<ValkyrieMatchStatement> getMatchStatementList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieMatchStatement.class);
    }

    @Override
    @NotNull
    public List<ValkyrieNewLambda> getNewLambdaList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieNewLambda.class);
    }

    @Override
    @NotNull
    public List<ValkyrieNewObject> getNewObjectList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieNewObject.class);
    }

    @Override
    @NotNull
    public List<ValkyrieNewValue> getNewValueList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieNewValue.class);
    }

    @Override
    @NotNull
    public List<ValkyrieTryStatement> getTryStatementList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieTryStatement.class);
    }

    @Override
    @NotNull
    public List<ValkyrieWhileStatement> getWhileStatementList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieWhileStatement.class);
    }

}
