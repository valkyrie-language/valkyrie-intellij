// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import valkyrie.psi.mixin.MixinDomain;

public class ValkyrieDeclareDomainNode extends MixinDomain implements ValkyrieDeclareDomain {

    public ValkyrieDeclareDomainNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitDeclareDomain(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public ValkyrieAnnotations getAnnotations() {
        return findNotNullChildByClass(ValkyrieAnnotations.class);
    }

    @Override
    @NotNull
    public ValkyrieClassBody getClassBody() {
        return findNotNullChildByClass(ValkyrieClassBody.class);
    }

    @Override
    @NotNull
    public ValkyrieIdentifier getIdentifier() {
        return findNotNullChildByClass(ValkyrieIdentifier.class);
    }

}
