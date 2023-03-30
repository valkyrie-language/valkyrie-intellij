// This is a generated file. Not intended for manual editing.
package yggdrasil.psi.node;

import java.util.List;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.codeInsight.lookup.LookupElement;
import valkyrie.ide.highlight.NodeHighlighter;

public interface ValkyrieDeclareClass extends PsiElement {

    @NotNull
    ValkyrieAnnotations getAnnotations();

    @Nullable
    ValkyrieClassBody getClassBody();

    @Nullable
    ValkyrieClassCast getClassCast();

    @Nullable
    ValkyrieIdentifier getIdentifier();

    void highlight(@NotNull NodeHighlighter visitor);

    void createLookup(@NotNull List<LookupElement> completions);

}
