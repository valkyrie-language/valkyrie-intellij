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

public class ValkyrieBlockBodyNode extends ValkyrieElement implements ValkyrieBlockBody {

    public ValkyrieBlockBodyNode(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull ValkyrieVisitor visitor) {
        visitor.visitBlockBody(this);
    }

    @Override
    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof ValkyrieVisitor) accept((ValkyrieVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public List<ValkyrieAttributeAbove> getAttributeAboveList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieAttributeAbove.class);
    }

    @Override
    @NotNull
    public List<ValkyrieControlStatement> getControlStatementList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieControlStatement.class);
    }

    @Override
    @NotNull
    public List<ValkyrieDeclareVariable> getDeclareVariableList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieDeclareVariable.class);
    }

    @Override
    @NotNull
    public List<ValkyrieExpressionRoot> getExpressionRootList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieExpressionRoot.class);
    }

    @Override
    @NotNull
    public List<ValkyrieIfCaseStatement> getIfCaseStatementList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieIfCaseStatement.class);
    }

    @Override
    @NotNull
    public List<ValkyrieIfStatement> getIfStatementList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieIfStatement.class);
    }

    @Override
    @NotNull
    public List<ValkyrieNewLambda> getNewLambdaList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieNewLambda.class);
    }

    @Override
    @NotNull
    public List<ValkyrieNewObject> getNewObjectList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieNewObject.class);
    }

    @Override
    @NotNull
    public List<ValkyrieNewValue> getNewValueList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieNewValue.class);
    }

}
