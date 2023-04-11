// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import valkyrie.ide.highlight.NodeHighlighter;

public interface ValkyrieNamepath extends PsiElement {

    @NotNull
    List<ValkyrieIdentifier> getIdentifierList();

    void highlight_fake(@NotNull NodeHighlighter highlighter);

}
