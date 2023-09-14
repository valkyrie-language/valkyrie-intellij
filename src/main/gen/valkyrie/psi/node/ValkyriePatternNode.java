// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import valkyrie.psi.ValkyrieElement;

public class ValkyriePatternNode extends ValkyrieElement implements ValkyriePattern {

    public ValkyriePatternNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitPattern(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public ValkyriePatternLiteral getPatternLiteral() {
        return findChildByClass(ValkyriePatternLiteral.class);
    }

    @Override
    @Nullable
    public ValkyriePatternObject getPatternObject() {
        return findChildByClass(ValkyriePatternObject.class);
    }

    @Override
    @Nullable
    public ValkyriePatternSequence getPatternSequence() {
        return findChildByClass(ValkyriePatternSequence.class);
    }

    @Override
    @Nullable
    public ValkyriePatternUnapply getPatternUnapply() {
        return findChildByClass(ValkyriePatternUnapply.class);
    }

}
