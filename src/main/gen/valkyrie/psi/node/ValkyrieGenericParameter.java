// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieGenericParameter extends PsiElement {

    @NotNull
    ValkyrieAnnotations getAnnotations();

    @Nullable
    ValkyrieDefaultType getDefaultType();

    @NotNull
    ValkyrieIdentifier getIdentifier();

    @Nullable
    ValkyrieTypeHint getTypeHint();

}
