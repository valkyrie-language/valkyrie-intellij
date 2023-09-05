// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import java.util.List;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

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
