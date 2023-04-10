// This is a generated file. Not intended for manual editing.
package yggdrasil.psi.node;

import java.util.List;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieWhileStatement extends PsiElement {

    @Nullable
    ValkyrieBlockBody getBlockBody();

    @Nullable
    ValkyrieElseStatement getElseStatement();

    @Nullable
    ValkyrieInlineExpression getInlineExpression();

    @NotNull
    ValkyrieWhileKind getWhileKind();

}
