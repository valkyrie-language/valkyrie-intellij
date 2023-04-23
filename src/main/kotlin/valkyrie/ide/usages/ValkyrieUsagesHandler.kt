package valkyrie.ide.usages

import com.intellij.find.findUsages.FindUsagesHandler
import com.intellij.find.findUsages.FindUsagesHandlerFactory.OperationMode
import com.intellij.psi.PsiElement

class ValkyrieUsagesHandler : FindUsagesHandler {
    private var forHighlightUsages: Boolean = false;
    private var operationMode: OperationMode = OperationMode.DEFAULT;

    constructor(element: PsiElement, forHighlightUsages: Boolean) : super(element) {
        this.forHighlightUsages = forHighlightUsages
    }

    constructor(element: PsiElement, operationMode: OperationMode) : super(element) {
        this.operationMode = operationMode
    }


    override fun getPrimaryElements(): Array<PsiElement> {
        return super.getPrimaryElements()
    }

    override fun getSecondaryElements(): Array<PsiElement> {
        return super.getSecondaryElements()
    }

    override fun getStringsToSearch(element: PsiElement): MutableCollection<String>? {

        return super.getStringsToSearch(element)
    }


}