// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import valkyrie.psi.mixin.MixinMacro;

public class ValkyrieDeclareMacroNode extends MixinMacro implements ValkyrieDeclareMacro {

    public ValkyrieDeclareMacroNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitDeclareMacro(this);
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
    public ValkyrieBlockBody getBlockBody() {
        return findChildByClass(ValkyrieBlockBody.class);
    }

    @Override
    @Nullable
    public ValkyrieDeclareGeneric getDeclareGeneric() {
        return findChildByClass(ValkyrieDeclareGeneric.class);
    }

    @Override
    @Nullable
    public ValkyrieEffectType getEffectType() {
        return findChildByClass(ValkyrieEffectType.class);
    }

    @Override
    @Nullable
    public ValkyrieIdentifier getIdentifier() {
        return findChildByClass(ValkyrieIdentifier.class);
    }

    @Override
    @Nullable
    public ValkyrieParameterBody getParameterBody() {
        return findChildByClass(ValkyrieParameterBody.class);
    }

    @Override
    @Nullable
    public ValkyrieReturnType getReturnType() {
        return findChildByClass(ValkyrieReturnType.class);
    }

}
