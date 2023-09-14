// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface ValkyrieParameterList extends PsiElement {

    @NotNull
    ValkyrieAnnotations getAnnotations();

    @Nullable
    ValkyrieDefaultValue getDefaultValue();

    @Nullable
    ValkyrieIdentifier getIdentifier();

    @Nullable
    ValkyrieTypeHint getTypeHint();

}
