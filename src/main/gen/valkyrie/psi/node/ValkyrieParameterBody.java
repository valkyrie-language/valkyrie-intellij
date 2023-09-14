// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface ValkyrieParameterBody extends PsiElement {

    @NotNull
    List<ValkyrieParameterDict> getParameterDictList();

    @NotNull
    List<ValkyrieParameterItem> getParameterItemList();

    @NotNull
    List<ValkyrieParameterList> getParameterListList();

}
