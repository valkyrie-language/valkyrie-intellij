// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieParameterItem extends PsiElement {

    @NotNull
    ValkyrieAnnotations getAnnotations();

    @Nullable
    ValkyrieDefaultValue getDefaultValue();

    @NotNull
    ValkyrieIdentifier getIdentifier();

    @Nullable
    ValkyrieParameterKind getParameterKind();

    @Nullable
    ValkyrieTypeHint getTypeHint();

}
