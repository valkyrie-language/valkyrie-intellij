// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import valkyrie.ide.highlight.NodeHighlighter;

public interface ValkyrieAttribute extends PsiElement {

    @Nullable
    ValkyrieArgumentBody getArgumentBody();

    @Nullable
    ValkyrieNamepath getNamepath();

    void highlight(@NotNull NodeHighlighter visitor);

}
