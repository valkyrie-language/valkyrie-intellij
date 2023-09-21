// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import valkyrie.psi.ValkyrieElement;

import java.util.List;

public class ValkyrieTypePatternObjectNode extends ValkyrieElement implements ValkyrieTypePatternObject {

    public ValkyrieTypePatternObjectNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitTypePatternObject(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public ValkyrieNamepathSafe getNamepathSafe() {
        return findChildByClass(ValkyrieNamepathSafe.class);
    }

    @Override
    @NotNull
    public List<ValkyrieTypePatternPair> getTypePatternPairList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieTypePatternPair.class);
    }

}
