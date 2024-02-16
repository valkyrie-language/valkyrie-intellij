package valkyrie.psi.traits;

import org.jetbrains.annotations.NotNull;
import valkyrie.psi.nodes.ValkyrieTermParameterItem;

import java.util.List;

public interface HasTypeParameter {
    /**
     * 惰性返回参数列表
     */
    @NotNull List<@NotNull ValkyrieTermParameterItem> getParameters();
}
