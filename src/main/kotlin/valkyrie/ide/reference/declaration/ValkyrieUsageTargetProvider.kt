package valkyrie.ide.reference.declaration

import com.intellij.ide.projectView.PresentationData
import com.intellij.navigation.ItemPresentation
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.usages.PsiElementUsageTarget
import com.intellij.usages.UsageTarget
import com.intellij.usages.UsageTargetProvider
import valkyrie.language.file.ValkyrieFileNode.Companion.definitions
import valkyrie.psi.node.*

class ValkyrieUsageTargetProvider : UsageTargetProvider {
    override fun getTargets(psiElement: PsiElement): Array<UsageTarget> {
        val visitor = ValkyrieUsageTargetVisitor()
        psiElement.accept(visitor)
        return visitor.targets.toTypedArray()
    }

    override fun getTargets(editor: Editor, file: PsiFile): Array<UsageTarget> {
        return arrayOf()
    }
}


private class ValkyrieUsageTargetVisitor : ValkyrieVisitor() {
    val targets: MutableList<UsageTarget> = mutableListOf()
    override fun visitDeclareMethod(o: ValkyrieDeclareMethod) {
        o as ValkyrieDeclareMethodNode
        for (item in o.containingFile.definitions) {
            targets.add(object : PsiElementUsageTarget {
                override fun getName(): String? {
                    return item.name
                }

                override fun getPresentation(): ItemPresentation? {
                    return PresentationData(item.name, null, item.getIcon(0), null)
                }

                override fun isValid(): Boolean {
                    return true
                }

                override fun findUsages() {

                }

                override fun getElement(): PsiElement {
                    return item
                }
            })
        }
    }

    override fun visitDeclareClass(o: ValkyrieDeclareClass) {
        o as ValkyrieDeclareClassNode
        for (item in o.containingFile.definitions) {
            targets.add(object : PsiElementUsageTarget {
                override fun getName(): String? {
                    return item.name
                }

                override fun getPresentation(): ItemPresentation {
                    return PresentationData(item.name, null, item.getIcon(0), null)
                }

                override fun isValid(): Boolean {
                    return true
                }

                override fun findUsages() {

                }

                override fun getElement(): PsiElement {
                    return item
                }
            })
        }
    }


}

