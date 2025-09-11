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

    /**
     * 获取完整的namespace名称，支持多ID格式（package.cli和package::cli）
     */
    fun getNamespaceName(): String? {
        val namespacePaths = getNamespacePaths()
        return if (namespacePaths.isNotEmpty()) {
            namespacePaths.first()
        } else {
            // 回退到原始实现
            getNamespaceIdentifier()?.text
        }
    }
    
    /**
     * 获取所有namespace路径，支持逗号分隔的多个路径
     */
    fun getNamespacePaths(): List<String> {
        val paths = mutableListOf<String>()
        
        // 查找所有NAMESPACE_PATH子元素
        val namespacePaths = findChildrenByType<PsiElement>(ValkyrieElementTypes.NAMESPACE_PATH)
        
        for (namespacePath in namespacePaths) {
            // 收集所有标识符并用原始分隔符连接
            val identifiers = mutableListOf<String>()
            val separators = mutableListOf<String>()
            
            // 遍历NAMESPACE_PATH的所有子元素
            var child = namespacePath.firstChild
            while (child != null) {
                when {
                    child.node.elementType == ValkyrieElementTypes.IDENTIFIER_NODE -> {
                        identifiers.add(child.text)
                    }
                    child.node.elementType == ValkyrieTokenTypes.DOT -> {
                        separators.add(".")
                    }
                    child.node.elementType == ValkyrieTokenTypes.DOUBLE_COLON -> {
                        separators.add("::")
                    }
                }
                child = child.nextSibling
            }
            
            // 重建完整路径
            if (identifiers.isNotEmpty()) {
                val result = StringBuilder(identifiers[0])
                for (i in 1 until identifiers.size) {
                    if (i - 1 < separators.size) {
                        result.append(separators[i - 1])
                    } else {
                        result.append(".")
                    }
                    result.append(identifiers[i])
                }
                paths.add(result.toString())
            }
        }
        
        return paths
    }
}