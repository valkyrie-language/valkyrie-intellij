// This is a generated file. Not intended for manual editing.
package yggdrasil.psi.node;

import java.util.List;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import valkyrie.ide.highlight.NodeHighlighter;

public interface ValkyrieDeclareField extends PsiElement {

    @NotNull
    List<ValkyrieAttribute> getAttributeList();

    @Nullable
    ValkyrieDefaultValue getDefaultValue();

    @NotNull
    List<ValkyrieModifier> getModifierList();

    @Nullable
    ValkyrieTypeHint getTypeHint();

    void highlight(@NotNull NodeHighlighter visitor);

}
