package valkyrie.language.psi

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFileFactory
import valkyrie.language.ValkyrieLanguage
import valkyrie.language.antlr.ValkyrieAntlrParser
import valkyrie.language.antlr.ValkyrieParser
import valkyrie.language.antlr.childrenWithLeaves
import valkyrie.language.ast.ValkyrieNamespaceStatement
import valkyrie.language.ast.ValkyrieNumberNode
import valkyrie.language.file.ValkyrieFileNode


@Suppress("FunctionName")
class ValkyrieFactory {
    private var project: Project;

    constructor(project: Project) {
        this.project = project
    }

    constructor(element: PsiElement) {
        this.project = element.project
    }

    fun create_file(text: String): ValkyrieFileNode {
        val factory = PsiFileFactory.getInstance(project)
        return factory.createFileFromText("factory.vk", ValkyrieLanguage, text) as ValkyrieFileNode
    }

    fun create_namespace(text: String, kind: String = ""): ValkyrieNamespaceStatement {
        val file = create_file("namespace${kind} $text;");
        for (child in file.children) {
            if (child is ValkyrieNamespaceStatement) {
                return child
            }
        }
        throw Exception("unreachable: ValkyrieFactory::createNamespace")
    }

    fun create_number_literal(number: String, unit: String?): ValkyrieNumberNode {
//        return letDefineAtom(number)!!.number as ValkyrieNumberNode
        throw Exception("unreachable: ValkyrieFactory::createNumberLiteral")
    }

    fun create_infix(operator: String): PsiElement? {
        val file = create_file("LHS $operator RHS");
        var node = ValkyrieParser.getChildOfType(file, ValkyrieAntlrParser.RULE_program);
        node = ValkyrieParser.getChildOfType(node, ValkyrieAntlrParser.RULE_expression_root);
        node = ValkyrieParser.getChildOfType(node, ValkyrieAntlrParser.RULE_expression);
        node = node?.childrenWithLeaves?.take(3)?.lastOrNull();
        return node
    }
}
