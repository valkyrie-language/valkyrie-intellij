// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface ValkyrieDeclareMacro extends PsiElement {

    @NotNull
    ValkyrieAnnotations getAnnotations();

    @Nullable
    ValkyrieBlockBody getBlockBody();

    @Nullable
    ValkyrieDeclareInfer getDeclareInfer();

    @Nullable
    ValkyrieIdentifierSafe getIdentifierSafe();

    @Nullable
    ValkyrieParameterBody getParameterBody();

    @Nullable
    ValkyrieReturnType getReturnType();

}
