// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import java.util.List;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;

import static valkyrie.psi.ValkyrieTypes.*;

import valkyrie.psi.ValkyrieElement;

public class ValkyrieMatchWithNode extends ValkyrieElement implements ValkyrieMatchWith {

    public ValkyrieMatchWithNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitMatchWith(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public ValkyrieMatchWithControl getMatchWithControl() {
        return findChildByClass(ValkyrieMatchWithControl.class);
    }

    @Override
    @Nullable
    public ValkyrieMatchWithProvide getMatchWithProvide() {
        return findChildByClass(ValkyrieMatchWithProvide.class);
    }

}
