// This is a generated file. Not intended for manual editing.
package yggdrasil.psi.node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import valkyrie.ide.highlight.NodeHighlighter;

public interface ValkyrieDeclareImply extends PsiElement {

    @NotNull
    ValkyrieAnnotations getAnnotations();

    @Nullable
    ValkyrieClassBody getClassBody();

    @Nullable
    ValkyrieIdentifierFree getIdentifierFree();

    void highlight(@NotNull NodeHighlighter highlighter);

}