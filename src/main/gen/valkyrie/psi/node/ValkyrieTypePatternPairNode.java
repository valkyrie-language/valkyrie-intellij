// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import valkyrie.psi.ValkyrieElement;

public class ValkyrieTypePatternPairNode extends ValkyrieElement implements ValkyrieTypePatternPair {

    public ValkyrieTypePatternPairNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitTypePatternPair(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public ValkyrieIdentifierSafe getIdentifierSafe() {
        return findNotNullChildByClass(ValkyrieIdentifierSafe.class);
    }

    @Override
    @NotNull
    public ValkyrieTypePattern getTypePattern() {
        return findNotNullChildByClass(ValkyrieTypePattern.class);
    }

}
