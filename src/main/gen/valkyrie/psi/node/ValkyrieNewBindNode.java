// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import valkyrie.psi.ValkyrieElement;

public class ValkyrieNewBindNode extends ValkyrieElement implements ValkyrieNewBind {

    public ValkyrieNewBindNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitNewBind(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public ValkyrieExpression getExpression() {
        return findNotNullChildByClass(ValkyrieExpression.class);
    }

    @Override
    @NotNull
    public ValkyrieIdentifierSafe getIdentifierSafe() {
        return findNotNullChildByClass(ValkyrieIdentifierSafe.class);
    }

}
