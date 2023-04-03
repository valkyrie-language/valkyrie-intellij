// This is a generated file. Not intended for manual editing.
package yggdrasil.psi.node;

import java.util.List;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;

import static valkyrie.psi.ValkyrieTypes.*;

import valkyrie.psi.mixin.MixinMethod;
import valkyrie.ide.highlight.NodeHighlighter;

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
    @NotNull
    public List<ValkyrieAttribute> getAttributeList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieAttribute.class);
    }

    @Override
    @Nullable
    public ValkyrieEffectType getEffectType() {
        return findChildByClass(ValkyrieEffectType.class);
    }

    @Override
    @Nullable
    public ValkyrieFunctionBody getFunctionBody() {
        return findChildByClass(ValkyrieFunctionBody.class);
    }

    @Override
    @NotNull
    public List<ValkyrieModifier> getModifierList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieModifier.class);
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
