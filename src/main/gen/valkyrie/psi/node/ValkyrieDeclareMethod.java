// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import java.util.List;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieDeclareMethod extends PsiElement {

    @NotNull
    ValkyrieAnnotations getAnnotations();

    @Nullable
    ValkyrieBlockBody getBlockBody();

    @Nullable
    ValkyrieDeclareInfer getDeclareInfer();

    @Nullable
    ValkyrieEffectType getEffectType();

    @NotNull
    ValkyrieIdentifierFree getIdentifierFree();

    @NotNull
    ValkyrieParameterBody getParameterBody();

    @Nullable
    ValkyrieReturnType getReturnType();

}
