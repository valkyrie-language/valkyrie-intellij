// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import java.util.List;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;

import static valkyrie.psi.ValkyrieTypes.*;

import valkyrie.psi.mixin.MixinMethod;

public class ValkyrieDeclareMethodNode extends MixinMethod implements ValkyrieDeclareMethod {

    public ValkyrieDeclareMethodNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitDeclareMethod(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public ValkyrieKwFunction getKwFunction() {
        return findChildByClass(ValkyrieKwFunction.class);
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
    @NotNull
    public ValkyrieIdentifierFree getIdentifierFree() {
        return findNotNullChildByClass(ValkyrieIdentifierFree.class);
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
