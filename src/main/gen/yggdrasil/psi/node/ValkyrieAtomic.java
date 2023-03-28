// This is a generated file. Not intended for manual editing.
package yggdrasil.psi.node;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieAtomic extends ValkyrieExpression {

    @Nullable
    ValkyrieEscape getEscape();

    @Nullable
    ValkyrieFunctionCall getFunctionCall();

    @Nullable
    ValkyrieIdentifierFree getIdentifierFree();

    @Nullable
    ValkyrieNumber getNumber();

    @Nullable
    ValkyrieRegex getRegex();

    @Nullable
    ValkyrieString getString();

}
