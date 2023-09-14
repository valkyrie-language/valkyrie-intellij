// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import valkyrie.psi.mixin.MixinValueParameter;

public class ValkyrieParameterItemNode extends MixinValueParameter implements ValkyrieParameterItem {

    public ValkyrieParameterItemNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitParameterItem(this);
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
    public ValkyrieDefaultValue getDefaultValue() {
        return findChildByClass(ValkyrieDefaultValue.class);
    }

    @Override
    @NotNull
    public ValkyrieIdentifierFree getIdentifierFree() {
        return findNotNullChildByClass(ValkyrieIdentifierFree.class);
    }

    @Override
    @Nullable
    public ValkyrieParameterKind getParameterKind() {
        return findChildByClass(ValkyrieParameterKind.class);
    }

    @Override
    @Nullable
    public ValkyrieTypeHint getTypeHint() {
        return findChildByClass(ValkyrieTypeHint.class);
    }

}
