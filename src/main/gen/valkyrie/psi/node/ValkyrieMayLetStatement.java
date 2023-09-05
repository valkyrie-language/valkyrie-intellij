// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import java.util.List;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieMayLetStatement extends PsiElement {

    @Nullable
    ValkyrieExpression getExpression();

    @NotNull
    ValkyrieLetPattern getLetPattern();

    @Nullable
    ValkyrieTypeHint getTypeHint();

}
