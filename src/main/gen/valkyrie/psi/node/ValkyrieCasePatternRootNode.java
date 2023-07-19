// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static valkyrie.psi.ValkyrieTypes.*;
import valkyrie.psi.mixin.MixinCasePatternRoot;

public class ValkyrieCasePatternRootNode extends MixinCasePatternRoot implements ValkyrieCasePatternRoot {

    public ValkyrieCasePatternRootNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitCasePatternRoot(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public ValkyrieCasePattern getCasePattern() {
        return findNotNullChildByClass(ValkyrieCasePattern.class);
    }

    @Override
    @Nullable
    public ValkyrieIdentifier getIdentifier() {
        return findChildByClass(ValkyrieIdentifier.class);
    }

    @Override
    @NotNull
    public List<ValkyrieModifier> getModifierList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieModifier.class);
    }

}
