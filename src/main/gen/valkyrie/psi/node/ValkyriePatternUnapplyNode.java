// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import valkyrie.psi.ValkyrieElement;

public class ValkyriePatternUnapplyNode extends ValkyrieElement implements ValkyriePatternUnapply {

    public ValkyriePatternUnapplyNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitPatternUnapply(this);
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
    public ValkyrieNamepathAuto getNamepathAuto() {
        return findChildByClass(ValkyrieNamepathAuto.class);
    }

    @Override
    @NotNull
    public ValkyriePatternUnapplyBody getPatternUnapplyBody() {
        return findNotNullChildByClass(ValkyriePatternUnapplyBody.class);
    }

}
