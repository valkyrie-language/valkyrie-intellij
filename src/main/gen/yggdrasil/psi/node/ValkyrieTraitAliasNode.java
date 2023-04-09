// This is a generated file. Not intended for manual editing.
package yggdrasil.psi.node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static valkyrie.psi.ValkyrieTypes.*;
import valkyrie.psi.mixin.MixinTraitAlias;

public class ValkyrieTraitAliasNode extends MixinTraitAlias implements ValkyrieTraitAlias {

    public ValkyrieTraitAliasNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitTraitAlias(this);
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
    public ValkyrieIdentifierFree getIdentifierFree() {
        return findNotNullChildByClass(ValkyrieIdentifierFree.class);
    }

    @Override
    @Nullable
    public ValkyrieTypeExpression getTypeExpression() {
        return findChildByClass(ValkyrieTypeExpression.class);
    }

}
