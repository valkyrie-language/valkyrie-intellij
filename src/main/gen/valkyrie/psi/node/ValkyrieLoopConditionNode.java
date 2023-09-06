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

public class ValkyrieLoopConditionNode extends ValkyrieElement implements ValkyrieLoopCondition {

    public ValkyrieLoopConditionNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitLoopCondition(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public ValkyrieLoopEach getLoopEach() {
        return findChildByClass(ValkyrieLoopEach.class);
    }

    @Override
    @Nullable
    public ValkyrieLoopMatch getLoopMatch() {
        return findChildByClass(ValkyrieLoopMatch.class);
    }

    @Override
    @Nullable
    public ValkyrieLoopUntil getLoopUntil() {
        return findChildByClass(ValkyrieLoopUntil.class);
    }

    @Override
    @Nullable
    public ValkyrieLoopUntilNot getLoopUntilNot() {
        return findChildByClass(ValkyrieLoopUntilNot.class);
    }

    @Override
    @Nullable
    public ValkyrieLoopWhile getLoopWhile() {
        return findChildByClass(ValkyrieLoopWhile.class);
    }

    @Override
    @Nullable
    public ValkyrieLoopWhileLet getLoopWhileLet() {
        return findChildByClass(ValkyrieLoopWhileLet.class);
    }

}
