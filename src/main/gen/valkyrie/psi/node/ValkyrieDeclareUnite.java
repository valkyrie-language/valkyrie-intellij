// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.codeInsight.lookup.LookupElement;

public interface ValkyrieDeclareUnite extends PsiElement {

    @NotNull
    ValkyrieAnnotations getAnnotations();

    @Nullable
    ValkyrieIdentifier getIdentifier();

    @Nullable
    ValkyrieUnionBody getUnionBody();

    void createLookup(@NotNull List<LookupElement> completions);

}
