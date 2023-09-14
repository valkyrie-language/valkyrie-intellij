// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import valkyrie.psi.ValkyrieElement;

public class ValkyrieTryNotStatementNode extends ValkyrieElement implements ValkyrieTryNotStatement {

    public ValkyrieTryNotStatementNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitTryNotStatement(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public ValkyrieBlockBody getBlockBody() {
        return findChildByClass(ValkyrieBlockBody.class);
    }

    @Override
    @Nullable
    public ValkyrieExpression getExpression() {
        return findChildByClass(ValkyrieExpression.class);
    }

    @Override
    @Nullable
    public ValkyrieThenStatement getThenStatement() {
        return findChildByClass(ValkyrieThenStatement.class);
    }

    @Override
    @Nullable
    public ValkyrieTypePattern getTypePattern() {
        return findChildByClass(ValkyrieTypePattern.class);
    }

}
