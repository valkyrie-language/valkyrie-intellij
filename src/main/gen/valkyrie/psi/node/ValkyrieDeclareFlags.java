// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface ValkyrieDeclareFlags extends PsiElement {

    @NotNull
    ValkyrieAnnotations getAnnotations();

    @Nullable
    ValkyrieClassInherit getClassInherit();

    @Nullable
    ValkyrieFlagsBody getFlagsBody();

    @Nullable
    ValkyrieIdentifierFree getIdentifierFree();

    @Nullable
    ValkyrieTypeAtomic getTypeAtomic();

    @NotNull PsiElement getKeyword();

}
