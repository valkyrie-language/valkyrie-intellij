// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import java.util.List;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieCasePatternTop extends PsiElement {

    @Nullable
    ValkyrieCasePattern getCasePattern();

    @Nullable
    ValkyrieIdentifier getIdentifier();

    @NotNull
    List<ValkyrieModifier> getModifierList();

    @Nullable
    ValkyrieTypeExpression getTypeExpression();

}
