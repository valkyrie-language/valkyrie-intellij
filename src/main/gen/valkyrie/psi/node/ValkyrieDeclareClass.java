// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

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
    ValkyrieIdentifierSafe getIdentifierSafe();

    @Nullable
    ValkyrieTypeHint getTypeHint();

    @NotNull PsiElement getKeyword();

    @NotNull List<@NotNull ValkyrieInheritItemNode> getSuperClasses();

    @NotNull List<@NotNull ValkyrieDeclareFieldNode> getFields();

}
