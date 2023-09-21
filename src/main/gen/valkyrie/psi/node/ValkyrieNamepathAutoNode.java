// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import valkyrie.psi.mixin.MixinNamepath;

import java.util.List;

public class ValkyrieNamepathAutoNode extends MixinNamepath implements ValkyrieNamepathAuto {

    public ValkyrieNamepathAutoNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitNamepathAuto(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public List<ValkyrieIdentifierSafe> getIdentifierSafeList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieIdentifierSafe.class);
    }

}
