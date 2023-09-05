// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import java.util.List;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieParameterBody extends PsiElement {

    @NotNull
    List<ValkyrieParameterDict> getParameterDictList();

    @NotNull
    List<ValkyrieParameterItem> getParameterItemList();

    @NotNull
    List<ValkyrieParameterList> getParameterListList();

}
