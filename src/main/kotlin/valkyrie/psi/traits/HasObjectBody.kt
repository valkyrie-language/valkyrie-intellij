package valkyrie.psi.traits;

import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import valkyrie.psi.nodes.ValkyrieObjectBodyNode;

public interface HasObjectBody {
    default @NotNull ValkyrieObjectBodyNode getObjectBody() {
        return PsiTreeUtil.findChildOfType((PsiElement) this, ValkyrieObjectBodyNode.class);
    }
}
