// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import valkyrie.psi.mixin.MixinTrait;

public class ValkyrieDeclareTraitNode extends MixinTrait implements ValkyrieDeclareTrait {

    public ValkyrieDeclareTraitNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitDeclareTrait(this);
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
    public ValkyrieIdentifierSafe getIdentifierSafe() {
        return findChildByClass(ValkyrieIdentifierSafe.class);
    }

    @Override
    @Nullable
    public ValkyrieTraitAlias getTraitAlias() {
        return findChildByClass(ValkyrieTraitAlias.class);
    }

    @Override
    @Nullable
    public ValkyrieTraitDefine getTraitDefine() {
        return findChildByClass(ValkyrieTraitDefine.class);
    }

}
