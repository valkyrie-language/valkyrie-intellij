// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import valkyrie.psi.mixin.MixinNamepath;

import java.util.List;

public class ValkyrieNamepathNode extends MixinNamepath implements ValkyrieNamepath {

    public ValkyrieNamepathNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitNamepath(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public List<ValkyrieIdentifier> getIdentifierList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieIdentifier.class);
    }

}
