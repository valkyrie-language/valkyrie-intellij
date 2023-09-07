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

public class ValkyrieDeclareConNode extends ValkyrieElement implements ValkyrieDeclareCon {

    public ValkyrieDeclareConNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitDeclareCon(this);
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
    @NotNull
    public List<ValkyrieIdentifier> getIdentifierList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieIdentifier.class);
    }

    @Override
    @Nullable
    public ValkyrieTemplateBody getTemplateBody() {
        return findChildByClass(ValkyrieTemplateBody.class);
    }

}
