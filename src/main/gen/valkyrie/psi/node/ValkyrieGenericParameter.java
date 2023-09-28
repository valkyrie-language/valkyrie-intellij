// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface ValkyrieGenericParameter extends PsiElement {

    @NotNull
    ValkyrieAnnotations getAnnotations();

    @Nullable
    ValkyrieDefaultType getDefaultType();

    @NotNull
    ValkyrieIdentifierSafe getIdentifierSafe();

    @Nullable
    ValkyrieTypeHint getTypeHint();

}
