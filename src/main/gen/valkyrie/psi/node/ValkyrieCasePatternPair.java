// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface ValkyrieCasePatternPair extends PsiElement {

    @Nullable
    ValkyrieCasePattern getCasePattern();

    @Nullable
    ValkyrieCasePatternBind getCasePatternBind();

    @NotNull
    ValkyrieIdentifierSafe getIdentifierSafe();

    @NotNull
    List<ValkyrieModifier> getModifierList();

    @Nullable
    ValkyrieTypeExpression getTypeExpression();

}
