// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface ValkyrieInlineTerm extends PsiElement {

    @NotNull
    ValkyrieInlineAtomic getInlineAtomic();

    @NotNull
    List<ValkyrieInlineSuffix> getInlineSuffixList();

    @NotNull
    List<ValkyriePrefix> getPrefixList();

}
