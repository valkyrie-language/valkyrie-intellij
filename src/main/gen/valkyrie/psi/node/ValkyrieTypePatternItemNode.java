// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import valkyrie.psi.ValkyrieElement;

public class ValkyrieTypePatternItemNode extends ValkyrieElement implements ValkyrieTypePatternItem {

    public ValkyrieTypePatternItemNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitTypePatternItem(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public ValkyrieGenericCallFree getGenericCallFree() {
        return findChildByClass(ValkyrieGenericCallFree.class);
    }

    @Override
    @NotNull
    public ValkyrieNamepathSafe getNamepathSafe() {
        return findNotNullChildByClass(ValkyrieNamepathSafe.class);
    }

}
