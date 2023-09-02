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
    public List<ValkyrieDeclareClass> getDeclareClassList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieDeclareClass.class);
    }

    @Override
    @NotNull
    public List<ValkyrieDeclareComponent> getDeclareComponentList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieDeclareComponent.class);
    }

    @Override
    @NotNull
    public List<ValkyrieDeclareEnumerate> getDeclareEnumerateList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieDeclareEnumerate.class);
    }

    @Override
    @NotNull
    public List<ValkyrieDeclareFlags> getDeclareFlagsList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieDeclareFlags.class);
    }

    @Override
    @NotNull
    public List<ValkyrieDeclareFunction> getDeclareFunctionList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieDeclareFunction.class);
    }

    @Override
    @NotNull
    public List<ValkyrieDeclareImply> getDeclareImplyList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieDeclareImply.class);
    }

    @Override
    @NotNull
    public List<ValkyrieDeclareMacro> getDeclareMacroList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieDeclareMacro.class);
    }

    @Override
    @NotNull
    public List<ValkyrieDeclareNamespace> getDeclareNamespaceList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieDeclareNamespace.class);
    }

    @Override
    @NotNull
    public List<ValkyrieDeclareNeural> getDeclareNeuralList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieDeclareNeural.class);
    }

    @Override
    @NotNull
    public List<ValkyrieDeclareSingleton> getDeclareSingletonList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieDeclareSingleton.class);
    }

    @Override
    @NotNull
    public List<ValkyrieDeclareTrait> getDeclareTraitList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieDeclareTrait.class);
    }

    @Override
    @NotNull
    public List<ValkyrieDeclareUnion> getDeclareUnionList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieDeclareUnion.class);
    }

    @Override
    @NotNull
    public List<ValkyrieDeclareUnite> getDeclareUniteList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieDeclareUnite.class);
    }

    @Override
    @NotNull
    public List<ValkyrieExpressionRoot> getExpressionRootList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieExpressionRoot.class);
    }

    @Override
    @NotNull
    public List<ValkyrieLetStatement> getLetStatementList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieLetStatement.class);
    }

    @Override
    @NotNull
    public ValkyrieLoopTemplateStart getLoopTemplateStart() {
        return findNotNullChildByClass(ValkyrieLoopTemplateStart.class);
    }

    @Override
    @NotNull
    public List<ValkyrieNewLambda> getNewLambdaList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieNewLambda.class);
    }

    @Override
    @NotNull
    public ValkyrieTemplateEnd getTemplateEnd() {
        return findNotNullChildByClass(ValkyrieTemplateEnd.class);
    }

    @Override
    @NotNull
    public List<ValkyrieTraitAlias> getTraitAliasList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieTraitAlias.class);
    }

    @Override
    @NotNull
    public List<ValkyrieTypeAlias> getTypeAliasList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieTypeAlias.class);
    }

    @Override
    @NotNull
    public List<ValkyrieUsingStatement> getUsingStatementList() {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, ValkyrieUsingStatement.class);
    }

}
