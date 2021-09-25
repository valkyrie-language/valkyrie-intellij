// This is a generated file. Not intended for manual editing.
package valkyrie.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface ValkyrieTerm extends PsiElement {

  @NotNull
  ValkyrieAtom getAtom();

  @NotNull
  List<ValkyrieCallSuffix> getCallSuffixList();

  @NotNull
  List<ValkyrieCasePattern> getCasePatternList();

  @NotNull
  List<ValkyrieDotCall> getDotCallList();

  @NotNull
  List<ValkyrieGeneric2> getGeneric2List();

  @NotNull
  List<ValkyrieMatchBlock> getMatchBlockList();

  @NotNull
  List<ValkyrieNormalBlock> getNormalBlockList();

  @NotNull
  List<ValkyrieNormalPattern> getNormalPatternList();

  @NotNull
  List<ValkyrieSlice> getSliceList();

}
