// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import valkyrie.psi.ValkyrieElement;

import java.util.List;

public class ValkyrieLoopTemplateStartNode extends ValkyrieElement implements ValkyrieLoopTemplateStart {

    public ValkyrieLoopTemplateStartNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitLoopTemplateStart(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public ValkyrieLoopStart getLoopStart() {
        return findNotNullChildByClass(ValkyrieLoopStart.class);
    }

    @Override
    @NotNull
    public List<ValkyrieStatements> getStatementsList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieStatements.class);
    }

}
