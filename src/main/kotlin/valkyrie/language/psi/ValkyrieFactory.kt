package valkyrie.language.psi

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFileFactory
import valkyrie.language.ValkyrieLanguage
import valkyrie.language.ast.ValkyrieNamespaceDeclaration
import valkyrie.language.file.ValkyrieFileNode
import valkyrie.language.psi_node.ValkyrieLetStatementNode
import valkyrie.language.psi_node.ValkyrieNumberNode

class ValkyrieFactory {
    private val project: Project

    constructor(project: Project) {
        this.project = project
    }


    constructor(element: PsiElement) {
        this.project = element.project
    }

    fun createFile(text: String): ValkyrieFileNode {
        val factory = PsiFileFactory.getInstance(project)
        return factory.createFileFromText("factory.vk", ValkyrieLanguage, text) as ValkyrieFileNode
    }

    fun createNamespace(text: String, kind: String = ""): ValkyrieNamespaceDeclaration {
        val file = createFile("namespace${kind} $text;");
        for (child in file.children) {
            if (child is ValkyrieNamespaceDeclaration) {
                return child
            }
        }
        throw Exception("unreachable: ValkyrieFactory::createNamespace")
    }
    fun createNumberLiteral(number: String, unit: String?): ValkyrieNumberNode {
        return letDefineAtom(number)!!.number as ValkyrieNumberNode
    }

    private fun letDefineAtom(atom: String): ValkyrieAtom? {
        val file = createFile("let target = $atom;");
        for (child in file.children) {
            if (child is ValkyrieLetStatementNode) {
                return child.expression!!.termList.first().atom
            }
        }
        return null
    }
}