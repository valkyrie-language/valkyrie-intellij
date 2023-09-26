// This is a generated file. Not intended for manual editing.
package valkyrie.psi.node;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;

public interface ValkyrieStatements extends PsiElement {

    @Nullable
    ValkyrieAttributeAbove getAttributeAbove();

    @Nullable
    ValkyrieControlStatement getControlStatement();

    @Nullable
    ValkyrieDeclareClass getDeclareClass();

    @Nullable
    ValkyrieDeclareComponent getDeclareComponent();

    @Nullable
    ValkyrieDeclareEnums getDeclareEnums();

    @Nullable
    ValkyrieDeclareFlags getDeclareFlags();

    @Nullable
    ValkyrieDeclareFunction getDeclareFunction();

    @Nullable
    ValkyrieDeclareImply getDeclareImply();

    @Nullable
    ValkyrieDeclareMacro getDeclareMacro();

    @Nullable
    ValkyrieDeclareMezzo getDeclareMezzo();

    @Nullable
    ValkyrieDeclareNamespace getDeclareNamespace();

    @Nullable
    ValkyrieDeclareNeural getDeclareNeural();

    @Nullable
    ValkyrieDeclareSingleton getDeclareSingleton();

    @Nullable
    ValkyrieDeclareTests getDeclareTests();

    @Nullable
    ValkyrieDeclareTrait getDeclareTrait();

    @Nullable
    ValkyrieDeclareType getDeclareType();

    @Nullable
    ValkyrieDeclareUnion getDeclareUnion();

    @Nullable
    ValkyrieDeclareUnite getDeclareUnite();

    @Nullable
    ValkyrieExpressionRoot getExpressionRoot();

    @Nullable
    ValkyrieLetStatement getLetStatement();

    @Nullable
    ValkyrieUsingStatement getUsingStatement();

}
