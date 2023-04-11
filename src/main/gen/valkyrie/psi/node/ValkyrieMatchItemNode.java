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

public class ValkyrieMatchItemNode extends ValkyrieElement implements ValkyrieMatchItem {

    public ValkyrieMatchItemNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitMatchItem(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public ValkyrieMatchCase getMatchCase() {
        return findChildByClass(ValkyrieMatchCase.class);
    }

    @Override
    @Nullable
    public ValkyrieMatchElse getMatchElse() {
        return findChildByClass(ValkyrieMatchElse.class);
    }

    @Override
    @Nullable
    public ValkyrieMatchWhen getMatchWhen() {
        return findChildByClass(ValkyrieMatchWhen.class);
    }

    @Override
    @Nullable
    public ValkyrieMatchWith getMatchWith() {
        return findChildByClass(ValkyrieMatchWith.class);
    }

}
