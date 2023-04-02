// This is a generated file. Not intended for manual editing.
package yggdrasil.psi.node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import valkyrie.ide.highlight.NodeHighlighter;

public interface ValkyrieAttribute extends PsiElement {

    @NotNull
    List<ValkyrieIdentifierFree> getIdentifierFreeList();

    @Nullable
    ValkyrieNamepath getNamepath();

    @Nullable
    ValkyrieTuple getTuple();

    void highlight(@NotNull NodeHighlighter visitor);

}