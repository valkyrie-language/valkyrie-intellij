// This is a generated file. Not intended for manual editing.
package yggdrasil.psi.node;

import java.util.List;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import valkyrie.ide.highlight.NodeHighlighter;

public interface ValkyrieDeclareMethod extends PsiElement {

    @NotNull
    List<ValkyrieAttribute> getAttributeList();

    @Nullable
    ValkyrieEffectType getEffectType();

    @Nullable
    ValkyrieFunctionBody getFunctionBody();

    @NotNull
    List<ValkyrieModifier> getModifierList();

    @NotNull
    ValkyrieParameterBody getParameterBody();

    @Nullable
    ValkyrieReturnType getReturnType();

    void highlight(@NotNull NodeHighlighter visitor);

}
