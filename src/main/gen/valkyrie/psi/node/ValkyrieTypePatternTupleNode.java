// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import valkyrie.psi.ValkyrieElement;

import java.util.List;

public class ValkyrieTypePatternTupleNode extends ValkyrieElement implements ValkyrieTypePatternTuple {

    public ValkyrieTypePatternTupleNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitTypePatternTuple(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public ValkyrieNamepath getNamepath() {
        return findChildByClass(ValkyrieNamepath.class);
    }

    @Override
    @NotNull
    public List<ValkyrieTypePattern> getTypePatternList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieTypePattern.class);
    }

}
