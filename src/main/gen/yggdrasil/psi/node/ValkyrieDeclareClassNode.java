// This is a generated file. Not intended for manual editing.
package yggdrasil.psi.node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static valkyrie.psi.ValkyrieTypes.*;
import valkyrie.psi.mixin.MixinClass;
import com.intellij.codeInsight.lookup.LookupElement;

public class ValkyrieDeclareClassNode extends MixinClass implements ValkyrieDeclareClass {

    public ValkyrieDeclareClassNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitDeclareClass(this);
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
    public ValkyrieClassImplement getClassImplement() {
        return findChildByClass(ValkyrieClassImplement.class);
    }

    @Override
    @Nullable
    public ValkyrieClassInheritBody getClassInheritBody() {
        return findChildByClass(ValkyrieClassInheritBody.class);
    }

    @Override
    @Nullable
    public ValkyrieDeclareGeneric getDeclareGeneric() {
        return findChildByClass(ValkyrieDeclareGeneric.class);
    }

    @Override
    @Nullable
    public ValkyrieIdentifierFree getIdentifierFree() {
        return findChildByClass(ValkyrieIdentifierFree.class);
    }

}
