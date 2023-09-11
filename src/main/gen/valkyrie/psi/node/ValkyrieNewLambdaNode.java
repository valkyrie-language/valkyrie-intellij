// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import java.util.List;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;

import static valkyrie.psi.ValkyrieTypes.*;

import valkyrie.psi.mixin.MixinLambda;

public class ValkyrieNewLambdaNode extends MixinLambda implements ValkyrieNewLambda {

    public ValkyrieNewLambdaNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitNewLambda(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public ValkyrieDeclareDepends getDeclareDepends() {
        return findChildByClass(ValkyrieDeclareDepends.class);
    }

    @Override
    @Nullable
    public ValkyrieEffectType getEffectType() {
        return findChildByClass(ValkyrieEffectType.class);
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
