// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface ValkyrieTypeFunction extends PsiElement {

    @NotNull
    ValkyrieBlockBody getBlockBody();

    @Nullable
    ValkyrieDeclareInfer getDeclareInfer();

    @NotNull
    ValkyrieIdentifier getIdentifier();

    @NotNull
    ValkyrieParameterBody getParameterBody();

    @Nullable
    ValkyrieReturnType getReturnType();

}
