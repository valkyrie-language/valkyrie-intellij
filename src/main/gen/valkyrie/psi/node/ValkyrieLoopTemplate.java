// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import java.util.List;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieLoopTemplate extends PsiElement {

    @NotNull
    List<ValkyrieAttributeAbove> getAttributeAboveList();

    @NotNull
    List<ValkyrieControlStatement> getControlStatementList();

    @NotNull
    List<ValkyrieDeclareClass> getDeclareClassList();

    @NotNull
    List<ValkyrieDeclareComponent> getDeclareComponentList();

    @NotNull
    List<ValkyrieDeclareEnumerate> getDeclareEnumerateList();

    @NotNull
    List<ValkyrieDeclareFlags> getDeclareFlagsList();

    @NotNull
    List<ValkyrieDeclareFunction> getDeclareFunctionList();

    @NotNull
    List<ValkyrieDeclareImply> getDeclareImplyList();

    @NotNull
    List<ValkyrieDeclareMacro> getDeclareMacroList();

    @NotNull
    List<ValkyrieDeclareNamespace> getDeclareNamespaceList();

    @NotNull
    List<ValkyrieDeclareNeural> getDeclareNeuralList();

    @NotNull
    List<ValkyrieDeclareSingleton> getDeclareSingletonList();

    @NotNull
    List<ValkyrieDeclareTrait> getDeclareTraitList();

    @NotNull
    List<ValkyrieDeclareUnion> getDeclareUnionList();

    @NotNull
    List<ValkyrieDeclareUnite> getDeclareUniteList();

    @NotNull
    List<ValkyrieExpressionRoot> getExpressionRootList();

    @NotNull
    List<ValkyrieLetStatement> getLetStatementList();

    @NotNull
    ValkyrieLoopTemplateStart getLoopTemplateStart();

    @NotNull
    List<ValkyrieNewLambda> getNewLambdaList();

    @NotNull
    ValkyrieTemplateEnd getTemplateEnd();

    @NotNull
    List<ValkyrieTraitAlias> getTraitAliasList();

    @NotNull
    List<ValkyrieTypeAlias> getTypeAliasList();

    @NotNull
    List<ValkyrieUsingStatement> getUsingStatementList();

}
