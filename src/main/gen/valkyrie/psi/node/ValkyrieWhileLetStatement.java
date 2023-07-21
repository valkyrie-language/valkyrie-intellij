// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import java.util.List;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieWhileLetStatement extends PsiElement {

    @Nullable
    ValkyrieBlockBody getBlockBody();

    @Nullable
    ValkyrieCasePattern getCasePattern();

    @Nullable
    ValkyrieControlLabel getControlLabel();

    @Nullable
    ValkyrieExpressionInline getExpressionInline();

    @Nullable
    ValkyrieIfCondition getIfCondition();

}
