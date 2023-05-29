// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieBlockBare extends PsiElement {

    @NotNull
    List<ValkyrieAttributeAbove> getAttributeAboveList();

    @NotNull
    List<ValkyrieControlStatement> getControlStatementList();

    @NotNull
    List<ValkyrieDeclareVariable> getDeclareVariableList();

    @NotNull
    List<ValkyrieExpressionRoot> getExpressionRootList();

    @NotNull
    List<ValkyrieIfCaseStatement> getIfCaseStatementList();

    @NotNull
    List<ValkyrieIfStatement> getIfStatementList();

    @NotNull
    List<ValkyrieNewLambda> getNewLambdaList();

    @NotNull
    List<ValkyrieNewObject> getNewObjectList();

    @NotNull
    List<ValkyrieNewValue> getNewValueList();

}
