package valkyrie.ide.structure

import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.psi.nodes.ValkyrieFileNode
import valkyrie.psi.nodes.*

/**
 * Valkyrie 结构视图元素
 * 表示结构视图中的一个节点
 */
class ValkyrieStructureViewElement(
    private val element: PsiElement
) : StructureViewTreeElement, SortableTreeElement {
    
    override fun getValue(): Any = element
    
    override fun getPresentation(): ItemPresentation {
        return ValkyrieItemPresentation(element)
    }
    
    override fun getChildren(): Array<StructureViewTreeElement> {
        val children = mutableListOf<StructureViewTreeElement>()
        
        when (element) {
            // 文件级别 - 显示所有顶级声明
            is ValkyrieFileNode -> {
                // 查找所有类声明
                val classDeclarations = PsiTreeUtil.findChildrenOfType(element, ValkyrieClassDeclaration::class.java)
                classDeclarations.forEach { classDecl ->
                    children.add(ValkyrieStructureViewElement(classDecl))
                }
                
                // 查找所有union声明
                val unionDeclarations = PsiTreeUtil.findChildrenOfType(element, ValkyrieUnionDeclaration::class.java)
                unionDeclarations.forEach { unionDecl ->
                    children.add(ValkyrieStructureViewElement(unionDecl))
                }
                
                // 查找所有trait声明
                val traitDeclarations = PsiTreeUtil.findChildrenOfType(element, ValkyrieTraitDeclaration::class.java)
                traitDeclarations.forEach { traitDecl ->
                    children.add(ValkyrieStructureViewElement(traitDecl))
                }
                
                // 查找所有domain声明
                val domainDeclarations = PsiTreeUtil.findChildrenOfType(element, ValkyrieDomainDeclaration::class.java)
                domainDeclarations.forEach { domainDecl ->
                    children.add(ValkyrieStructureViewElement(domainDecl))
                }
                
                // 查找所有namespace声明
                val namespaceDeclarations = PsiTreeUtil.findChildrenOfType(element, ValkyrieNamespaceDeclaration::class.java)
                namespaceDeclarations.forEach { nsDecl ->
                    children.add(ValkyrieStructureViewElement(nsDecl))
                }
            }
            
            // 类声明 - 显示字段和方法
            is ValkyrieClassDeclaration -> {
                // 查找字段
                val fields = PsiTreeUtil.findChildrenOfType(element, ValkyrieFieldDeclaration::class.java)
                fields.forEach { field ->
                    children.add(ValkyrieStructureViewElement(field))
                }
                
                // 查找方法
                val methods = PsiTreeUtil.findChildrenOfType(element, ValkyrieMethodDeclaration::class.java)
                methods.forEach { method ->
                    children.add(ValkyrieStructureViewElement(method))
                }
            }
            
            // Union声明 - 显示变体
            is ValkyrieUnionDeclaration -> {
                val variants = PsiTreeUtil.findChildrenOfType(element, ValkyrieVariantDeclaration::class.java)
                variants.forEach { variant ->
                    children.add(ValkyrieStructureViewElement(variant))
                }
            }
            
            // Trait声明 - 显示方法签名
            is ValkyrieTraitDeclaration -> {
                val methods = PsiTreeUtil.findChildrenOfType(element, ValkyrieMethodDeclaration::class.java)
                methods.forEach { method ->
                    children.add(ValkyrieStructureViewElement(method))
                }
            }
        }
        
        return children.toTypedArray()
    }
    
    override fun navigate(requestFocus: Boolean) {
        if (element is NavigatablePsiElement) {
            element.navigate(requestFocus)
        }
    }
    
    override fun canNavigate(): Boolean {
        return element is NavigatablePsiElement && element.canNavigate()
    }
    
    override fun canNavigateToSource(): Boolean {
        return element is NavigatablePsiElement && element.canNavigateToSource()
    }
    
    override fun getAlphaSortKey(): String {
        return when (element) {
            is ValkyrieClassDeclaration -> element.name ?: "<unnamed>"
            is ValkyrieUnionDeclaration -> element.name ?: "<unnamed>"
            is ValkyrieTraitDeclaration -> element.name ?: "<unnamed>"
            is ValkyrieDomainDeclaration -> element.name ?: "<unnamed>"
            is ValkyrieFieldDeclaration -> element.name ?: "<unnamed>"
            is ValkyrieMethodDeclaration -> element.name ?: "<unnamed>"
            is ValkyrieVariantDeclaration -> element.name ?: "<unnamed>"
            is ValkyrieNamespaceDeclaration -> element.getNamespaceName() ?: "<unnamed>"
            else -> element.text ?: "<unknown>"
        }
    }
    
    /**
     * 判断是否为叶子节点
     */
    fun isLeaf(): Boolean {
        return when (element) {
            is ValkyrieFieldDeclaration,
            is ValkyrieVariantDeclaration,
            is ValkyrieNamespaceDeclaration -> true
            is ValkyrieDomainDeclaration,
            is ValkyrieMethodDeclaration -> {
                // Domain和方法通常是叶子节点，除非有嵌套声明
                true
            }
            else -> false
        }
    }
}

