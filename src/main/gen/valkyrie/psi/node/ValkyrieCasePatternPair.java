// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface ValkyrieCasePatternPair extends PsiElement {

    @NotNull
    ValkyrieAnnotations getAnnotations();

    @Nullable
    ValkyrieCasePattern getCasePattern();

    @Nullable
    ValkyrieCasePatternBind getCasePatternBind();

    @NotNull
    ValkyrieIdentifierSafe getIdentifierSafe();

    @Nullable
    ValkyrieTypeExpression getTypeExpression();

}
