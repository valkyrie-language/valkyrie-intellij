// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import java.util.List;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieDeclareFunction extends PsiElement {

    @NotNull
    ValkyrieAnnotations getAnnotations();

    @Nullable
    ValkyrieBlockBody getBlockBody();

    @Nullable
    ValkyrieDeclareGeneric getDeclareGeneric();

    @Nullable
    ValkyrieEffectType getEffectType();

    @Nullable
    ValkyrieIdentifier getIdentifier();

    @Nullable
    ValkyrieParameterBody getParameterBody();

    @Nullable
    ValkyrieReturnType getReturnType();

}
