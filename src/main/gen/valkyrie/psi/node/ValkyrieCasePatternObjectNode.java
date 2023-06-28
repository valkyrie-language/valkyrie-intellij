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

public class ValkyrieCasePatternObjectNode extends ValkyrieElement implements ValkyrieCasePatternObject {

    public ValkyrieCasePatternObjectNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitCasePatternObject(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public List<ValkyrieCasePatternPair> getCasePatternPairList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieCasePatternPair.class);
    }

    @Override
    @Nullable
    public ValkyrieNamepath getNamepath() {
        return findChildByClass(ValkyrieNamepath.class);
    }

}
