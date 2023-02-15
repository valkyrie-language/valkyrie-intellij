package valkyrie.language.psi

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.util.descendants
import valkyrie.language.ValkyrieLanguage
import valkyrie.language.antlr.ValkyrieAntlrParser
import valkyrie.language.antlr.ValkyrieParser
import valkyrie.language.antlr.childrenWithLeaves
import valkyrie.language.ast.ValkyrieIdentifierNode
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

    private fun create_file(text: String): ValkyrieFileNode {
        val factory = PsiFileFactory.getInstance(project)
        return factory.createFileFromText("factory.vk", ValkyrieLanguage, text) as ValkyrieFileNode
    }

    private fun create_expression(operator: String): PsiElement? {
        val file = create_file(operator);
        var node = ValkyrieParser.getChildOfType(file, ValkyrieAntlrParser.RULE_program);
        node = ValkyrieParser.getChildOfType(node, ValkyrieAntlrParser.RULE_expression_root);
        return ValkyrieParser.getChildOfType(node, ValkyrieAntlrParser.RULE_expression);
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

    fun create_identifier(name: String): ValkyrieIdentifierNode? {
        val file = create_file(name);
        for (child in file.descendants()) {
            if (child is ValkyrieIdentifierNode) {
                return child
            }
        }
        return null;
    }

    fun create_number_literal(number: String, unit: String?): ValkyrieNumberNode {
//        return letDefineAtom(number)!!.number as ValkyrieNumberNode
        throw Exception("unreachable: ValkyrieFactory::createNumberLiteral")
    }


    fun create_infix(operator: String): PsiElement? {
        val node = create_expression("LHS $operator RHS");
        return node?.childrenWithLeaves?.take(3)?.lastOrNull();
    }

    fun replace_generic(lhs: PsiElement, rhs: PsiElement) {
        val file = create_expression("G⟨⟩")
        val node = ValkyrieParser.getChildOfType(file, ValkyrieAntlrParser.RULE_generic_call);
        node?.firstChild?.let { lhs.replace(it) }
        node?.lastChild?.let { rhs.replace(it) }
    }

    fun replace_dot(node: PsiElement) {
        val root = create_expression("a.0");
    }

    fun replace_comma(node: PsiElement) {
        val root = create_expression("(1,)");
    }

    fun replace_proportion(node: PsiElement, unicode: Boolean) {
        val root = if (unicode) {
            create_expression("a∷b");
        } else {
            create_expression("a::b");
        }
    }

    fun replace_colon(node: PsiElement) {
        val root = create_expression("0;");
    }

    fun replace_semicolon(node: PsiElement) {
        val root = create_expression("a: T");
    }

    fun replace_arrow(node: PsiElement, unicode: Boolean) {
        val root = if (unicode) {
            create_expression("lambda() ⟶ b {}");
        } else {
            create_expression("lambda() -> b {}");
        }
    }


}
