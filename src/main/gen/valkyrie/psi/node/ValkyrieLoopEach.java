// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;

public interface ValkyrieLoopEach extends PsiElement {

    @Nullable
    ValkyrieBarePattern getBarePattern();

    @Nullable
    ValkyrieCasePattern getCasePattern();

    @Nullable
    ValkyrieExpressionInline getExpressionInline();

    @Nullable
    ValkyrieIfCondition getIfCondition();

    @Nullable
    ValkyrieMatchBind getMatchBind();

}
