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

public class ValkyrieLetPatternNode extends ValkyrieElement implements ValkyrieLetPattern {

    public ValkyrieLetPatternNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitLetPattern(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public ValkyriePatternBare getPatternBare() {
        return findChildByClass(ValkyriePatternBare.class);
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
