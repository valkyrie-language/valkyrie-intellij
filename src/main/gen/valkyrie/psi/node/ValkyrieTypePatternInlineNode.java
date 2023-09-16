// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import valkyrie.psi.ValkyrieElement;

public class ValkyrieTypePatternInlineNode extends ValkyrieElement implements ValkyrieTypePatternInline {

    public ValkyrieTypePatternInlineNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitTypePatternInline(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public ValkyrieNumberLiteral getNumberLiteral() {
        return findChildByClass(ValkyrieNumberLiteral.class);
    }

    @Override
    @Nullable
    public ValkyrieSpecial getSpecial() {
        return findChildByClass(ValkyrieSpecial.class);
    }

    @Override
    @Nullable
    public ValkyrieString getString() {
        return findChildByClass(ValkyrieString.class);
    }

    @Override
    @Nullable
    public ValkyrieTypePatternItem getTypePatternItem() {
        return findChildByClass(ValkyrieTypePatternItem.class);
    }

    @Override
    @Nullable
    public ValkyrieTypePatternTuple getTypePatternTuple() {
        return findChildByClass(ValkyrieTypePatternTuple.class);
    }

}
