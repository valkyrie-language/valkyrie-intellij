package valkyrie.project

import com.intellij.openapi.module.Module
import com.intellij.psi.PsiFile
import com.intellij.util.xml.ModuleContextProvider

class ValkyriePackageContext : ModuleContextProvider() {
    override fun getContextModules(context: PsiFile): Array<Module> {
        return arrayOf()
    }
}
