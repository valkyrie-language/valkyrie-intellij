// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import valkyrie.psi.ValkyrieElement;

public class ValkyrieSlotNamedNode extends ValkyrieElement implements ValkyrieSlotNamed {

    public ValkyrieSlotNamedNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitSlotNamed(this);
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

}
