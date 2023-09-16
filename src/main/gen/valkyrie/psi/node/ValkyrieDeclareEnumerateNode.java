// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import valkyrie.psi.mixin.MixinEnumerate;

public class ValkyrieDeclareEnumerateNode extends MixinEnumerate implements ValkyrieDeclareEnumerate {

    public ValkyrieDeclareEnumerateNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitDeclareEnumerate(this);
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
    public ValkyrieEnumerateBody getEnumerateBody() {
        return findChildByClass(ValkyrieEnumerateBody.class);
    }

    @Override
    @Nullable
    public ValkyrieIdentifier getIdentifier() {
        return findChildByClass(ValkyrieIdentifier.class);
    }

    @Override
    @Nullable
    public ValkyrieTypeAtomic getTypeAtomic() {
        return findChildByClass(ValkyrieTypeAtomic.class);
    }

}
