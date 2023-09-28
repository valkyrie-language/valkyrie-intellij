// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import valkyrie.psi.ValkyrieElement;

public class ValkyrieArgumentNode extends ValkyrieElement implements ValkyrieArgument {

    public ValkyrieArgumentNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitArgument(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public ValkyrieExpressionRoot getExpressionRoot() {
        return findNotNullChildByClass(ValkyrieExpressionRoot.class);
    }

    @Override
    @Nullable
    public ValkyrieIdentifierSafe getIdentifierSafe() {
        return findChildByClass(ValkyrieIdentifierSafe.class);
    }

}
