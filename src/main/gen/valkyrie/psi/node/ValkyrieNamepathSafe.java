// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import valkyrie.psi.mixin.MixinIdentifier;

import java.util.List;

public interface ValkyrieNamepathSafe extends PsiElement {

    @NotNull
    List<ValkyrieIdentifierFree> getIdentifierFreeList();

    @Nullable
    ValkyrieIdentifierSafe getIdentifierSafe();

    @NotNull List<@NotNull MixinIdentifier> getNamepath();

    @NotNull List<@NotNull MixinIdentifier> getNamespace();

    @Nullable MixinIdentifier getIdentifier();

}
