// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import valkyrie.psi.ValkyrieElement;

public class ValkyrieLoopTemplateNode extends ValkyrieElement implements ValkyrieLoopTemplate {

    public ValkyrieLoopTemplateNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitLoopTemplate(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @Nullable
    public ValkyrieElseTemplate getElseTemplate() {
        return findChildByClass(ValkyrieElseTemplate.class);
    }

    @Override
    @NotNull
    public ValkyrieLoopTemplateStart getLoopTemplateStart() {
        return findNotNullChildByClass(ValkyrieLoopTemplateStart.class);
    }

    @Override
    @NotNull
    public ValkyrieTemplateEnd getTemplateEnd() {
        return findNotNullChildByClass(ValkyrieTemplateEnd.class);
    }

}
