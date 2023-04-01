// This is a generated file. Not intended for manual editing.
package yggdrasil.psi.node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import valkyrie.ide.highlight.NodeHighlighter;

public interface ValkyrieDeclareInterface extends PsiElement {

    @NotNull
    ValkyrieAnnotations getAnnotations();

    @Nullable
    ValkyrieGroupBody getGroupBody();

    @Nullable
    ValkyrieIdentifierFree getIdentifierFree();

    void highlight(@NotNull NodeHighlighter visitor);

    //WARNING: createLookup(...) is skipped
    //matching createLookup(ValkyrieDeclareInterface, ...)
    //methods are not found in YggdrasilPsiExtension

}
