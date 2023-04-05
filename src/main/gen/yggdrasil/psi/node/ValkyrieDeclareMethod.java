// This is a generated file. Not intended for manual editing.
package yggdrasil.psi.node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import valkyrie.ide.highlight.NodeHighlighter;

public interface ValkyrieDeclareMethod extends PsiElement {

    @NotNull
    ValkyrieAnnotations getAnnotations();

    @Nullable
    ValkyrieEffectType getEffectType();

    @Nullable
    ValkyrieFunctionBody getFunctionBody();

    @NotNull
    ValkyrieIdentifierFree getIdentifierFree();

    @NotNull
    ValkyrieParameterBody getParameterBody();

    @Nullable
    ValkyrieReturnType getReturnType();

    void highlight(@NotNull NodeHighlighter visitor);

}
