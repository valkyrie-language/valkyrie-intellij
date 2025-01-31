// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import valkyrie.ide.highlight.NodeHighlighter;

public interface ValkyrieTypeExpression extends PsiElement {

    @NotNull
    List<ValkyrieTypeInfix> getTypeInfixList();

    @NotNull
    List<ValkyrieTypeTerm> getTypeTermList();

    //WARNING: highlight_trait(...) is skipped
    //matching highlight_trait(ValkyrieTypeExpression, ...)
    //methods are not found in YggdrasilPsiExtension

    void highlight_class(@NotNull NodeHighlighter visitor);

}
