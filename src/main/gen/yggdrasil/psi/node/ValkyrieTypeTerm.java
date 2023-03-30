// This is a generated file. Not intended for manual editing.
package yggdrasil.psi.node;

import java.util.List;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieTypeTerm extends PsiElement {

    @NotNull
    ValkyrieExpression getExpression();

    @NotNull
    List<ValkyrieTypePrefix> getTypePrefixList();

    @NotNull
    List<ValkyrieTypeSuffix> getTypeSuffixList();

}
