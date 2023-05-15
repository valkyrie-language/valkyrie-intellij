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

public class ValkyrieControlStatementNode extends ValkyrieElement implements ValkyrieControlStatement {

    public ValkyrieControlStatementNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitControlStatement(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public ValkyrieControlBreak getControlBreak() {
        return findChildByClass(ValkyrieControlBreak.class);
    }

    @Override
    @Nullable
    public ValkyrieControlContinue getControlContinue() {
        return findChildByClass(ValkyrieControlContinue.class);
    }

    @Override
    @Nullable
    public ValkyrieControlResume getControlResume() {
        return findChildByClass(ValkyrieControlResume.class);
    }

    @Override
    @Nullable
    public ValkyrieControlReturn getControlReturn() {
        return findChildByClass(ValkyrieControlReturn.class);
    }

    @Override
    @Nullable
    public ValkyrieControlThrough getControlThrough() {
        return findChildByClass(ValkyrieControlThrough.class);
    }

    @Override
    @Nullable
    public ValkyrieControlYieldFrom getControlYieldFrom() {
        return findChildByClass(ValkyrieControlYieldFrom.class);
    }

    @Override
    @Nullable
    public ValkyrieControlYieldSend getControlYieldSend() {
        return findChildByClass(ValkyrieControlYieldSend.class);
    }

    @Override
    @Nullable
    public ValkyrieControlYieldStop getControlYieldStop() {
        return findChildByClass(ValkyrieControlYieldStop.class);
    }

}
