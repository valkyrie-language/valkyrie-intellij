// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import valkyrie.psi.ValkyrieElement;

public class ValkyriePatternPairNode extends ValkyrieElement implements ValkyriePatternPair {

    public ValkyriePatternPairNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitPatternPair(this);
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
    @NotNull
    public ValkyrieIdentifier getIdentifier() {
        return findNotNullChildByClass(ValkyrieIdentifier.class);
    }

    @Override
    @Nullable
    public ValkyriePattern getPattern() {
        return findChildByClass(ValkyriePattern.class);
    }

}
