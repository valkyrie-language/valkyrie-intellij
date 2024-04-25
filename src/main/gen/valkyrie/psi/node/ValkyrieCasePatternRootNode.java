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

public class ValkyrieCasePatternRootNode extends ValkyrieElement implements ValkyrieCasePatternRoot {

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
    @Nullable
    public ValkyrieCasePattern getCasePattern() {
        return findChildByClass(ValkyrieCasePattern.class);
    }

    @Override
    @Nullable
    public ValkyrieCasePatternArray getCasePatternArray() {
        return findChildByClass(ValkyrieCasePatternArray.class);
    }

    @Override
    @Nullable
    public ValkyrieCasePatternObject getCasePatternObject() {
        return findChildByClass(ValkyrieCasePatternObject.class);
    }

    @Override
    @Nullable
    public ValkyrieCasePatternTuple getCasePatternTuple() {
        return findChildByClass(ValkyrieCasePatternTuple.class);
    }

    @Override
    @Nullable
    public ValkyrieNamepath getNamepath() {
        return findChildByClass(ValkyrieNamepath.class);
    }

    @Override
    @Nullable
    public ValkyrieNumber getNumber() {
        return findChildByClass(ValkyrieNumber.class);
    }

    @Override
    @Nullable
    public ValkyrieSpecial getSpecial() {
        return findChildByClass(ValkyrieSpecial.class);
    }

    @Override
    @Nullable
    public ValkyrieString getString() {
        return findChildByClass(ValkyrieString.class);
    }

}
