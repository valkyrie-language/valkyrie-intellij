// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface ValkyrieTypusAlias extends PsiElement {

    @NotNull
    ValkyrieAnnotations getAnnotations();

    @Nullable
    ValkyrieDeclareGeneric getDeclareGeneric();

    @Nullable
    ValkyrieIdentifier getIdentifier();

    @Nullable
    ValkyrieTypeExpression getTypeExpression();

}
