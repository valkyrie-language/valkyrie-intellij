// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import valkyrie.psi.ValkyrieElement;

public class ValkyrieUsingTermNode extends ValkyrieElement implements ValkyrieUsingTerm {

    public ValkyrieUsingTermNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitUsingTerm(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public ValkyrieNamepathAuto getNamepathAuto() {
        return findChildByClass(ValkyrieNamepathAuto.class);
    }

    @Override
    @Nullable
    public ValkyrieUsingAlias getUsingAlias() {
        return findChildByClass(ValkyrieUsingAlias.class);
    }

    @Override
    @Nullable
    public ValkyrieUsingAny getUsingAny() {
        return findChildByClass(ValkyrieUsingAny.class);
    }

    @Override
    @Nullable
    public ValkyrieUsingBlock getUsingBlock() {
        return findChildByClass(ValkyrieUsingBlock.class);
    }

}
