package valkyrie.ide.codegen

import com.intellij.ide.util.MemberChooser
import com.intellij.openapi.project.Project
import valkyrie.language.ast.classes.ValkyrieClassStatement

class GenerateClassFieldChooser : MemberChooser<GenerateClassFieldMember> {
    constructor(here: ValkyrieClassStatement, project: Project) : super(arrayOf(), true, true, project) {
        title = "Valkyrie Class Field Chooser";
        setCopyJavadocVisible(false)
        resetElements(here.getFields().map { GenerateClassFieldMember(it, here) }.toTypedArray())
    }
}