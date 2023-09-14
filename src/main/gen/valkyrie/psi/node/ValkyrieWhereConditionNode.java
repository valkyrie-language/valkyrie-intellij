// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import valkyrie.psi.ValkyrieElement;

public class ValkyrieWhereConditionNode extends ValkyrieElement implements ValkyrieWhereCondition {

    public ValkyrieWhereConditionNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitWhereCondition(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public ValkyrieAnnotations getAnnotations() {
        return findNotNullChildByClass(ValkyrieAnnotations.class);
    }

    @Override
    @Nullable
    public ValkyrieDefaultType getDefaultType() {
        return findChildByClass(ValkyrieDefaultType.class);
    }

    @Override
    @Nullable
    public ValkyrieTypeHint getTypeHint() {
        return findChildByClass(ValkyrieTypeHint.class);
    }

    @Override
    @NotNull
    public ValkyrieTypeTerm getTypeTerm() {
        return findNotNullChildByClass(ValkyrieTypeTerm.class);
    }

}
