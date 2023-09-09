// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import java.util.List;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieDeclareTrait extends PsiElement {

    @NotNull
    ValkyrieAnnotations getAnnotations();

    @Nullable
    ValkyrieClassBody getClassBody();

    @Nullable
    ValkyrieDeclareInfer getDeclareInfer();

    @Nullable
    ValkyrieIdentifier getIdentifier();

    @Nullable
    ValkyrieTypeHint getTypeHint();

}
