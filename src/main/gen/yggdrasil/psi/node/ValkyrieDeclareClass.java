// This is a generated file. Not intended for manual editing.
package yggdrasil.psi.node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.codeInsight.lookup.LookupElement;

public interface ValkyrieDeclareClass extends PsiElement {

    @NotNull
    ValkyrieAnnotations getAnnotations();

    @Nullable
    ValkyrieClassBody getClassBody();

    @Nullable
    ValkyrieClassImplement getClassImplement();

    @Nullable
    ValkyrieClassInherit getClassInherit();

    @Nullable
    ValkyrieIdentifierFree getIdentifierFree();

    void createLookup(@NotNull List<LookupElement> completions);

}
