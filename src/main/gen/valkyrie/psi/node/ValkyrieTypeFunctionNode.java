// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import java.util.List;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;

import static valkyrie.psi.ValkyrieTypes.*;

import valkyrie.psi.ValkyrieElement;

public class ValkyrieTypeFunctionNode extends ValkyrieElement implements ValkyrieTypeFunction {

    public ValkyrieTypeFunctionNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitTypeFunction(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public ValkyrieBlockBody getBlockBody() {
        return findNotNullChildByClass(ValkyrieBlockBody.class);
    }

    @Override
    @Nullable
    public ValkyrieDeclareInfer getDeclareInfer() {
        return findChildByClass(ValkyrieDeclareInfer.class);
    }

    @Override
    @Nullable
    public ValkyrieEffectType getEffectType() {
        return findChildByClass(ValkyrieEffectType.class);
    }

    @Override
    @NotNull
    public ValkyrieIdentifier getIdentifier() {
        return findNotNullChildByClass(ValkyrieIdentifier.class);
    }

    @Override
    @NotNull
    public ValkyrieParameterBody getParameterBody() {
        return findNotNullChildByClass(ValkyrieParameterBody.class);
    }

    @Override
    @Nullable
    public ValkyrieReturnType getReturnType() {
        return findChildByClass(ValkyrieReturnType.class);
    }

}
