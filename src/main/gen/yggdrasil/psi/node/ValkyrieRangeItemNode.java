// This is a generated file. Not intended for manual editing.
package yggdrasil.psi.node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static valkyrie.psi.ValkyrieTypes.*;
import valkyrie.psi.ValkyrieElement;

public class ValkyrieRangeItemNode extends ValkyrieElement implements ValkyrieRangeItem {

    public ValkyrieRangeItemNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitRangeItem(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public ValkyrieRangeIndex getRangeIndex() {
        return findChildByClass(ValkyrieRangeIndex.class);
    }

    @Override
    @Nullable
    public ValkyrieRangeLower getRangeLower() {
        return findChildByClass(ValkyrieRangeLower.class);
    }

    @Override
    @Nullable
    public ValkyrieRangeStep getRangeStep() {
        return findChildByClass(ValkyrieRangeStep.class);
    }

    @Override
    @Nullable
    public ValkyrieRangeUpper getRangeUpper() {
        return findChildByClass(ValkyrieRangeUpper.class);
    }

}
