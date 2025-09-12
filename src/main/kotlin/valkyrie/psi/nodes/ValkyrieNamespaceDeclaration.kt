package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.psi.ValkyrieElementNode
import valkyrie.psi.ValkyrieElementTypes
import valkyrie.psi.ValkyrieTokenTypes

/**
 * Namespace 语句实现
 */
class ValkyrieNamespaceDeclaration(node: ASTNode) : ValkyrieElementNode(node) {

    fun getNamespaceIdentifier(): PsiElement? {
        return findChildByType<PsiElement>(ValkyrieTokenTypes.IDENTIFIER_STD)
    }

    fun getNamespaceName(): String? {
        val paths = getNamespacePaths()
        return if (paths.isNotEmpty()) {
            paths.joinToString(".")
        } else {
            null
        }
    }

    fun getNamespacePaths(): List<String> {
        val paths = mutableListOf<String>()
        
        // 查找所有 NAMESPACE_PATH 子元素
        val namespacePaths = findChildrenByType<PsiElement>(ValkyrieElementTypes.NAMESPACE_PATH)
        
        for (namespacePath in namespacePaths) {
            val pathBuilder = StringBuilder()
            
            // 遍历 NAMESPACE_PATH 的子元素
            var child = namespacePath.firstChild
            while (child != null) {
                when (child.node.elementType) {
                    ValkyrieTokenTypes.IDENTIFIER_STD -> {
                        pathBuilder.append(child.text)
                    }
                    ValkyrieTokenTypes.DOT -> {
                        pathBuilder.append(".")
                    }
                    ValkyrieTokenTypes.DOUBLE_COLON -> {
                        pathBuilder.append("::")
                    }
                }
                child = child.nextSibling
            }
            
            if (pathBuilder.isNotEmpty()) {
                paths.add(pathBuilder.toString())
            }
        }
        
        return paths
    }

    fun getNamespaceType(): String {
        // 查找namespace关键字token来确定类型
        var child = firstChild
        while (child != null) {
            when (child.node.elementType) {
                ValkyrieTokenTypes.NAMESPACE -> return "namespace"
                ValkyrieTokenTypes.NAMESPACE_MAIN -> return "namespace!"
                ValkyrieTokenTypes.NAMESPACE_TEST -> return "namespace?"
                ValkyrieTokenTypes.NAMESPACE_HIDE -> return "namespace*"
            }
            child = child.nextSibling
        }
        return "namespace" // 默认类型
    }
}