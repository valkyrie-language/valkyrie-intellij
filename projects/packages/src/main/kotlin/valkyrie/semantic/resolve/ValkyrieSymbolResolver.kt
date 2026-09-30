package valkyrie.semantic.resolve

import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.semantic.index.ValkyrieSymbolIndex
import valkyrie.surface.psi.nodes.ValkyrieClassDeclaration
import valkyrie.surface.psi.nodes.ValkyrieIdentifierNode
import valkyrie.surface.psi.nodes.ValkyrieLetStatementNode
import valkyrie.surface.psi.nodes.ValkyrieMethodDeclaration
import valkyrie.surface.psi.nodes.ValkyrieNamespaceDeclaration
import valkyrie.surface.psi.nodes.ValkyrieTraitDeclaration
import valkyrie.surface.parser.ValkyrieElementNode
import valkyrie.surface.parser.ValkyrieTypes

/**
 * Single resolution pipeline for identifier usages: local scope first, then symbol index.
 */
object ValkyrieSymbolResolver {

    fun resolve(identifier: ValkyrieIdentifierNode): PsiElement? {
        val name = identifier.name ?: return null

        resolveFunctionParameter(name, identifier)?.let { return it }
        resolveGenericParameter(name, identifier)?.let { return it }
        resolveLocalBinding(name, identifier)?.let { return it }

        val currentFile = identifier.containingFile.virtualFile ?: return null
        val symbolIndex = ValkyrieSymbolIndex.getInstance(identifier.project)
        val definitions = symbolIndex.findAllSymbolDefinitions(name, currentFile)

        if (ValkyrieReferenceContext.isInTypeContext(identifier)) {
            definitions.firstOrNull { isTypeDefinition(it.element) }?.element?.let { return it }
        }

        return definitions.firstOrNull()?.element
    }

    fun collectCompletionVariants(identifier: ValkyrieIdentifierNode): Array<Any> {
        val currentFile = identifier.containingFile.virtualFile ?: return emptyArray()
        val symbolIndex = ValkyrieSymbolIndex.getInstance(identifier.project)

        val currentNamespace = PsiTreeUtil.findChildOfType(
            identifier.containingFile,
            ValkyrieNamespaceDeclaration::class.java,
        )?.getNamespaceName() ?: "default"

        val variants = LinkedHashSet<String>()
        variants.addAll(symbolIndex.getNamespaceSymbols(currentNamespace))
        for (usingInfo in symbolIndex.getFileUsings(currentFile)) {
            variants.add(usingInfo.alias ?: usingInfo.symbolName)
        }
        return variants.toTypedArray()
    }

    private fun resolveFunctionParameter(name: String, identifier: ValkyrieIdentifierNode): PsiElement? {
        val functionDeclaration = PsiTreeUtil.getParentOfType(identifier, ValkyrieMethodDeclaration::class.java)
            ?: return null
        val parameterList = functionDeclaration.getParameterList() ?: return null
        for (parameter in parameterList.getParameters()) {
            if (parameter?.name == name) {
                return parameter.nameIdentifier ?: parameter
            }
        }
        return null
    }

    private fun resolveGenericParameter(name: String, identifier: ValkyrieIdentifierNode): PsiElement? {
        var context: PsiElement? = identifier.parent
        while (context != null) {
            val genericParameterLists = PsiTreeUtil.findChildrenOfType(context, ValkyrieElementNode::class.java)
                .filter { it.node.elementType == ValkyrieTypes.GENERIC_PARAMETER_LIST }

            for (genericList in genericParameterLists) {
                val genericParameters = PsiTreeUtil.findChildrenOfType(genericList, ValkyrieElementNode::class.java)
                    .filter { it.node.elementType == ValkyrieTypes.GENERIC_PARAMETER_ITEM }

                for (genericParam in genericParameters) {
                    val identifiers = PsiTreeUtil.findChildrenOfType(genericParam, ValkyrieIdentifierNode::class.java)
                    for (genericIdentifier in identifiers) {
                        if (genericIdentifier.name == name && genericIdentifier.textOffset < identifier.textOffset) {
                            return genericIdentifier
                        }
                    }
                }
            }
            context = context.parent
        }
        return null
    }

    private fun resolveLocalBinding(name: String, identifier: ValkyrieIdentifierNode): PsiElement? {
        var context: PsiElement? = identifier.parent
        while (context != null) {
            val letStatements = PsiTreeUtil.findChildrenOfType(context, ValkyrieLetStatementNode::class.java)
            for (letStatement in letStatements) {
                if (letStatement.textOffset < identifier.textOffset) {
                    val binding = letStatement.getIdentifier() as? ValkyrieIdentifierNode
                    if (binding?.name == name) {
                        return binding
                    }
                }
            }
            if (context is ValkyrieMethodDeclaration) {
                break
            }
            context = context.parent
        }
        return null
    }

    private fun isTypeDefinition(element: PsiElement?): Boolean {
        if (element == null) {
            return false
        }
        if (element is ValkyrieClassDeclaration || element is ValkyrieTraitDeclaration) {
            return true
        }
        val simpleName = element.javaClass.simpleName
        return simpleName.contains("Union") || simpleName.contains("Struct")
    }
}
