// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface ValkyrieDeclareClass extends PsiElement {

    @NotNull
    ValkyrieAnnotations getAnnotations();

    @Nullable
    ValkyrieClassBody getClassBody();

    @Nullable
    ValkyrieClassInherit getClassInherit();

    @Nullable
    ValkyrieDeclareGeneric getDeclareGeneric();

    @Nullable
    ValkyrieDeclareInfer getDeclareInfer();

    @Nullable
    ValkyrieIdentifier getIdentifier();

    @Nullable
    ValkyrieTypeHint getTypeHint();

}
