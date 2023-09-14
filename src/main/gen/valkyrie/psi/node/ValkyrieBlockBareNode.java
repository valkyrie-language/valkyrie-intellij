// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import valkyrie.psi.ValkyrieElement;

import java.util.List;

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
    public List<ValkyrieAttributeAbove> getAttributeAboveList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieAttributeAbove.class);
    }

    @Override
    @NotNull
    public List<ValkyrieControlStatement> getControlStatementList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieControlStatement.class);
    }

    @Override
    @NotNull
    public List<ValkyrieExpressionRoot> getExpressionRootList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieExpressionRoot.class);
    }

    @Override
    @NotNull
    public List<ValkyrieLetStatement> getLetStatementList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieLetStatement.class);
    }

    @Override
    @NotNull
    public List<ValkyrieNewLambda> getNewLambdaList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieNewLambda.class);
    }

}
