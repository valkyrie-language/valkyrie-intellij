// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface ValkyrieGenericArgument extends PsiElement {

    @Nullable
    ValkyrieAnnotations getAnnotations();

    @Nullable
    ValkyrieIdentifierSafe getIdentifierSafe();

    @NotNull
    List<ValkyrieTypeExpression> getTypeExpressionList();

}
