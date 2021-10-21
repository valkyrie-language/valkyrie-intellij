package valkyrie.ide.project

import com.intellij.openapi.module.Module
import com.intellij.psi.PsiFile
import com.intellij.util.xml.ModuleContextProvider

class ValkyriePackageContext : ModuleContextProvider() {
    override fun getContextModules(context: PsiFile): Array<Module> {
        println("getContextModules($context)")
        return arrayOf()
    }
}