// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.codeInsight.lookup.LookupElement;

public interface ValkyrieDeclareEnumerate extends PsiElement {

    @NotNull
    ValkyrieAnnotations getAnnotations();

    @Nullable
    ValkyrieEnumerateBody getEnumerateBody();

    @Nullable
    ValkyrieIdentifier getIdentifier();

    void createLookup(@NotNull List<LookupElement> completions);

}
