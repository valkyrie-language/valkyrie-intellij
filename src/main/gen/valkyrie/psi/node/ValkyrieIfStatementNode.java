// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import valkyrie.psi.ValkyrieElement;

import java.util.List;

public class ValkyrieIfStatementNode extends ValkyrieElement implements ValkyrieIfStatement {

    public ValkyrieIfStatementNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitIfStatement(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public ValkyrieBlockBody getBlockBody() {
        return findNotNullChildByClass(ValkyrieBlockBody.class);
    }

    @Override
    @NotNull
    public List<ValkyrieElseIfStatement> getElseIfStatementList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieElseIfStatement.class);
    }

    @Override
    @Nullable
    public ValkyrieElseStatement getElseStatement() {
        return findChildByClass(ValkyrieElseStatement.class);
    }

    @Override
    @NotNull
    public ValkyrieIfCondition getIfCondition() {
        return findNotNullChildByClass(ValkyrieIfCondition.class);
    }

}
