// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface ValkyrieDeclareImply extends PsiElement {

    @NotNull
    ValkyrieAnnotations getAnnotations();

    @Nullable
    ValkyrieClassBody getClassBody();

    @Nullable
    ValkyrieDeclareInfer getDeclareInfer();

    @Nullable
    ValkyrieGenericCallFree getGenericCallFree();

    @Nullable
    ValkyrieNamepathSafe getNamepathSafe();

    @Nullable
    ValkyrieTypeExpression getTypeExpression();

}
