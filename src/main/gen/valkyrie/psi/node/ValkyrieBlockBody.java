// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieBlockBody extends PsiElement {

    @NotNull
    List<ValkyrieDeclareVariable> getDeclareVariableList();

    @NotNull
    List<ValkyrieExpression> getExpressionList();

    @NotNull
    List<ValkyrieForStatement> getForStatementList();

    @NotNull
    List<ValkyrieIfCaseStatement> getIfCaseStatementList();

    @NotNull
    List<ValkyrieIfStatement> getIfStatementList();

    @NotNull
    List<ValkyrieMatchStatement> getMatchStatementList();

    @NotNull
    List<ValkyrieNewLambda> getNewLambdaList();

    @NotNull
    List<ValkyrieNewObject> getNewObjectList();

    @NotNull
    List<ValkyrieNewValue> getNewValueList();

    @NotNull
    List<ValkyrieTryStatement> getTryStatementList();

    @NotNull
    List<ValkyrieWhileStatement> getWhileStatementList();

}
