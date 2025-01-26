// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface ValkyrieExpressionInline extends PsiElement {

    @NotNull
    List<ValkyrieInfix> getInfixList();

    @NotNull
    List<ValkyrieInlineTerm> getInlineTermList();

}
