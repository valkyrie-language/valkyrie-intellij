// This is a generated file. Not intended for manual editing.
package vos.intellij.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface VosClassBlock extends PsiElement {

  @NotNull
  List<VosAnnotation> getAnnotationList();

  @NotNull
  List<VosClassBound> getClassBoundList();

  @NotNull
  List<VosClassField> getClassFieldList();

}
