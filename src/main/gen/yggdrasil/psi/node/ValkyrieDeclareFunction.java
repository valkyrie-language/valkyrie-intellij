// This is a generated file. Not intended for manual editing.
package yggdrasil.psi.node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.codeInsight.lookup.LookupElement;
import valkyrie.ide.highlight.NodeHighlighter;

public interface ValkyrieDeclareFunction extends PsiElement {

    @NotNull
    ValkyrieAnnotations getAnnotations();

    @Nullable
    ValkyrieFunctionBlock getFunctionBlock();

    @Nullable
    ValkyrieFunctionParameter getFunctionParameter();

    @Nullable
    ValkyrieIdentifierFree getIdentifierFree();

    void highlight(@NotNull NodeHighlighter highlighter);

    void createLookup(@NotNull List<LookupElement> completions);

}
