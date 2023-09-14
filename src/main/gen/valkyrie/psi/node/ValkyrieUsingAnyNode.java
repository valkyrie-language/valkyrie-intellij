// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import valkyrie.psi.ValkyrieElement;

public class ValkyrieUsingAnyNode extends ValkyrieElement implements ValkyrieUsingAny {

    public ValkyrieUsingAnyNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitUsingAny(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public ValkyrieNamepathAuto getNamepathAuto() {
        return findNotNullChildByClass(ValkyrieNamepathAuto.class);
    }

    @Override
    @Nullable
    public ValkyrieUsingExclude getUsingExclude() {
        return findChildByClass(ValkyrieUsingExclude.class);
    }

}
