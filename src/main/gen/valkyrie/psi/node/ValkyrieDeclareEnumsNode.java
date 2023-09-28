// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import valkyrie.psi.mixin.MixinEnumerate;

public class ValkyrieDeclareEnumsNode extends MixinEnumerate implements ValkyrieDeclareEnums {

    public ValkyrieDeclareEnumsNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitDeclareEnums(this);
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
    public ValkyrieClassInherit getClassInherit() {
        return findChildByClass(ValkyrieClassInherit.class);
    }

    @Override
    @Nullable
    public ValkyrieFlagsBody getFlagsBody() {
        return findChildByClass(ValkyrieFlagsBody.class);
    }

    @Override
    @Nullable
    public ValkyrieIdentifierSafe getIdentifierSafe() {
        return findChildByClass(ValkyrieIdentifierSafe.class);
    }

    @Override
    @Nullable
    public ValkyrieTypeAtomic getTypeAtomic() {
        return findChildByClass(ValkyrieTypeAtomic.class);
    }

}
