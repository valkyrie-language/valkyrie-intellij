// This is a generated file. Not intended for manual editing.
package yggdrasil.psi.node;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import valkyrie.psi.mixin.MixinFlags;

public class ValkyrieDeclareFlagsNode extends MixinFlags implements ValkyrieDeclareFlags {

    public ValkyrieDeclareFlagsNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitDeclareFlags(this);
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
    @Nullable
    public ValkyrieEnumerateBody getEnumerateBody() {
        return findChildByClass(ValkyrieEnumerateBody.class);
    }

    @Override
    @Nullable
    public ValkyrieIdentifierFree getIdentifierFree() {
        return findChildByClass(ValkyrieIdentifierFree.class);
    }

}
