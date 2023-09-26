// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import valkyrie.ide.highlight.NodeHighlighter;
import valkyrie.psi.mixin.MixinIdentifier;

import java.util.List;

public interface ValkyrieNamepathAuto extends PsiElement {

    @NotNull
    List<ValkyrieIdentifierSafe> getIdentifierSafeList();

    @NotNull List<@NotNull MixinIdentifier> getNamepath();

    @NotNull List<@NotNull MixinIdentifier> getNamespace();

    @Nullable MixinIdentifier getIdentifier();

    void highlight(@NotNull NodeHighlighter highlighter);

}
