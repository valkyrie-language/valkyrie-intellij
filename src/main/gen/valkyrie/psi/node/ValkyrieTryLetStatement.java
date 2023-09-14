// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;

public interface ValkyrieTryLetStatement extends PsiElement {

    @Nullable
    ValkyrieElseStatement getElseStatement();

    @Nullable
    ValkyrieExpression getExpression();

    @Nullable
    ValkyrieIfCondition getIfCondition();

    @Nullable
    ValkyrieLetPattern getLetPattern();

    @Nullable
    ValkyrieTypeHint getTypeHint();

}
