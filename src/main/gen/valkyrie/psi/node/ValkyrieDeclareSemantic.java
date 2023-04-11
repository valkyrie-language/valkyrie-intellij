// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import valkyrie.ide.highlight.NodeHighlighter;

public interface ValkyrieDeclareSemantic extends PsiElement {

    @NotNull
    ValkyrieAnnotations getAnnotations();

    @Nullable
    ValkyrieDefaultValue getDefaultValue();

    @NotNull
    ValkyrieIdentifierFree getIdentifierFree();

    void highlight(@NotNull NodeHighlighter highlighter);

}
