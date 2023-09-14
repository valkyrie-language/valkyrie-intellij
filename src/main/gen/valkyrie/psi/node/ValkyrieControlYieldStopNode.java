// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import valkyrie.psi.ValkyrieElement;

public class ValkyrieControlYieldStopNode extends ValkyrieElement implements ValkyrieControlYieldStop {

    public ValkyrieControlYieldStopNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitControlYieldStop(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public ValkyrieControlLabel getControlLabel() {
        return findChildByClass(ValkyrieControlLabel.class);
    }

    @Override
    @Nullable
    public ValkyrieExpressionRoot getExpressionRoot() {
        return findChildByClass(ValkyrieExpressionRoot.class);
    }

}
