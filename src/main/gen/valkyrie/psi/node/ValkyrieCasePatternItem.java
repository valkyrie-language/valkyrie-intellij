// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface ValkyrieCasePatternItem extends PsiElement {

    @Nullable
    ValkyrieCasePattern getCasePattern();

    @Nullable
    ValkyrieCasePatternBind getCasePatternBind();

    @Nullable
    ValkyrieIdentifier getIdentifier();

    @NotNull
    List<ValkyrieModifier> getModifierList();

    @Nullable
    ValkyrieTypeExpression getTypeExpression();

}
