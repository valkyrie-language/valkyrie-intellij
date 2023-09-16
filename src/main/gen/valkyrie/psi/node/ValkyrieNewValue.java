// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface ValkyrieNewValue extends PsiElement {

    @Nullable
    ValkyrieArgumentBody getArgumentBody();

    @NotNull
    List<ValkyrieModifier> getModifierList();

    @Nullable
    ValkyrieNewBody getNewBody();

    @Nullable
    ValkyrieTypeExpression getTypeExpression();

}
