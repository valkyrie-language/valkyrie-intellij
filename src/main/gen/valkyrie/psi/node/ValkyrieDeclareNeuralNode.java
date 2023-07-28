// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static valkyrie.psi.ValkyrieTypes.*;
import valkyrie.psi.mixin.MixinNeural;

public class ValkyrieDeclareNeuralNode extends MixinNeural implements ValkyrieDeclareNeural {

    public ValkyrieDeclareNeuralNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitDeclareNeural(this);
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
    public ValkyrieClassBody getClassBody() {
        return findChildByClass(ValkyrieClassBody.class);
    }

    @Override
    @Nullable
    public ValkyrieClassInherit getClassInherit() {
        return findChildByClass(ValkyrieClassInherit.class);
    }

    @Override
    @Nullable
    public ValkyrieDeclareGeneric getDeclareGeneric() {
        return findChildByClass(ValkyrieDeclareGeneric.class);
    }

    @Override
    @Nullable
    public ValkyrieIdentifier getIdentifier() {
        return findChildByClass(ValkyrieIdentifier.class);
    }

    @Override
    @Nullable
    public ValkyrieTypeHint getTypeHint() {
        return findChildByClass(ValkyrieTypeHint.class);
    }

}
