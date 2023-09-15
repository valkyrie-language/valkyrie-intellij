// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface ValkyrieNewValue extends PsiElement {

    @NotNull
    ValkyrieAnnotations getAnnotations();

    @Nullable
    ValkyrieArgumentBody getArgumentBody();

    @Nullable
    ValkyrieNewBody getNewBody();

    @NotNull
    ValkyrieNewNavigate getNewNavigate();

    @Nullable
    ValkyrieTypeExpression getTypeExpression();

}
