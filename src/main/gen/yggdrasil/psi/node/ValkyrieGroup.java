// This is a generated file. Not intended for manual editing.
package yggdrasil.psi.node;

import java.util.List;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieGroup extends PsiElement {

    @NotNull
    ValkyrieAnnotations getAnnotations();

    @Nullable
    ValkyrieGroupBody getGroupBody();

    @Nullable
    ValkyrieIdentifierFree getIdentifierFree();

    @NotNull
    List<ValkyrieGroupItemNode> getTokenList();

}
