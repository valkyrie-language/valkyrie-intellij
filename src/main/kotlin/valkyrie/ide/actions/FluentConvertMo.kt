package valkyrie.ide.actions

import valkyrie.language.ValkyrieBundle


private val name = ValkyrieBundle.message("action.convert_prop")
private val description = ValkyrieBundle.message("action.convert_prop.description")

//class FluentConvertMo : CreateFileAction(name, description, ValkyrieIconProvider.Instance.Valkyrie) {
//    private var sourceFile: PsiFile? = null;
//
//    override fun update(event: AnActionEvent) {
//        sourceFile = LangDataKeys.PSI_FILE.getData(event.dataContext)
//        super.update(event)
//    }
//
//    override fun create(newName: String, directory: PsiDirectory): Array<PsiElement> {
//        return super.create(newName, directory)
//    }
//}
