// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import java.util.List;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.codeInsight.lookup.LookupElement;
import valkyrie.ide.highlight.NodeHighlighter;

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
    ValkyrieIdentifierFree getIdentifierFree();

    @Nullable
    ValkyrieParameterBody getParameterBody();

    @Nullable
    ValkyrieReturnType getReturnType();

    void highlight(@NotNull NodeHighlighter highlighter);

    void createLookup(@NotNull List<LookupElement> completions);

}
