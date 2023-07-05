// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieIfCaseStatement extends PsiElement {

    @NotNull
    ValkyrieBlockBody getBlockBody();

    @Nullable
    ValkyrieCasePattern getCasePattern();

    @Nullable
    ValkyrieElseStatement getElseStatement();

    @NotNull
    ValkyrieExpressionInline getExpressionInline();

    @Nullable
    ValkyrieTypePattern getTypePattern();

}
