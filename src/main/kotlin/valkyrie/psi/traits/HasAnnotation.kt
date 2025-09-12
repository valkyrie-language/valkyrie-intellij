package valkyrie.psi.traits;

import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import valkyrie.psi.nodes.ValkyrieAnnotationNode;
import valkyrie.psi.nodes.ValkyrieModifierNode;
import valkyrie.psi.nodes.ValkyrieObjectBodyNode;

import java.util.List;

public interface HasAnnotation {
    default @NotNull ValkyrieAnnotationNode getAnnotation() {
        return PsiTreeUtil.findChildOfType((PsiElement) this, ValkyrieAnnotationNode.class);
    }

    default @NotNull List<@NotNull ValkyrieModifierNode> getModifiers() {
        return getAnnotation().getModifiers();
    }

    default Boolean hasModifier(@NotNull String name) {
        return getAnnotation().hasModifier(name);
    }
}

