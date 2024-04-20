package valkyrie.ide.marker

import com.intellij.codeInsight.daemon.LineMarkerInfo
import com.intellij.codeInsight.daemon.LineMarkerProvider
import com.intellij.codeInsight.navigation.NavigationGutterIconBuilder
import com.intellij.icons.AllIcons
import com.intellij.openapi.editor.markup.GutterIconRenderer
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.psi.nodes.*
import valkyrie.psi.parsers.ValkyrieTypes
import valkyrie.index.ValkyrieSymbolIndex

/**
 * Valkyrie 行标记提供者
 * 用于提供 override、implement 等上下文功能的图标
 */
class ValkyrieLineMarkerProvider : LineMarkerProvider {
    
    override fun getLineMarkerInfo(element: PsiElement): LineMarkerInfo<*>? {
        // 只处理叶子节点
        if (element.firstChild != null) return null
        
        val parent = element.parent ?: return null
        
        return when {
            element.node?.elementType == ValkyrieTypes.CLASS && parent is ValkyrieClassDeclaration ->
                createClassNavigationMarker(element)
            element.node?.elementType == ValkyrieTypes.NAMESPACE && parent is ValkyrieNamespaceDeclaration ->
                createNamespaceNavigationMarker(element)
            element.node?.elementType == ValkyrieTypes.IMPLY && parent is ValkyrieImplyStatement ->
                createImplyNavigationMarker(element)
            isOverrideKeyword(element) -> createOverrideMarker(element)
            isImplementKeyword(element) -> createImplementMarker(element)
            else -> null
        }
    }
    
    /**
     * 检查是否为 override 关键字
     */
    private fun isOverrideKeyword(element: PsiElement): Boolean {
        if (element.text != "override") return false
        
        // 检查父节点是否为方法声明
        val methodDeclaration = PsiTreeUtil.getParentOfType(element, ValkyrieMethodDeclaration::class.java)
        return methodDeclaration != null
    }
    
    /**
     * 检查是否为实现关键字（在 imply 块中的方法）
     */
    private fun isImplementKeyword(element: PsiElement): Boolean {
        // 检查是否为方法名标识符且在 imply 块中
        val methodDeclaration = PsiTreeUtil.getParentOfType(element, ValkyrieMethodDeclaration::class.java)
        if (methodDeclaration == null) return false
        
        val implyBlock = PsiTreeUtil.getParentOfType(methodDeclaration, ValkyrieImplyStatement::class.java)
        return implyBlock != null && element.parent == methodDeclaration
    }
    

    

    
    /**
     * 创建重写标记
     */
    private fun createOverrideMarker(element: PsiElement): LineMarkerInfo<PsiElement> {
        return NavigationGutterIconBuilder
            .create(AllIcons.Gutter.OverridingMethod)
            .setTargets(emptyList<PsiElement>()) // 这里应该查找被重写的方法
            .setTooltipText("Overrides method")
            .setAlignment(GutterIconRenderer.Alignment.LEFT)
            .createLineMarkerInfo(element)
    }
    
    /**
     * 创建实现标记
     */
    private fun createImplementMarker(element: PsiElement): LineMarkerInfo<PsiElement> {
        return NavigationGutterIconBuilder
            .create(AllIcons.Gutter.ImplementingMethod)
            .setTargets(emptyList<PsiElement>()) // 这里应该查找被实现的接口方法
            .setTooltipText("Implements method")
            .setAlignment(GutterIconRenderer.Alignment.LEFT)
            .createLineMarkerInfo(element)
    }
    
    /**
     * 创建继承标记
     */
    private fun createInheritedMarker(element: PsiElement): LineMarkerInfo<PsiElement> {
        return NavigationGutterIconBuilder
            .create(AllIcons.Gutter.OverridenMethod)
            .setTargets(emptyList<PsiElement>()) // 这里应该查找继承的子类
            .setTooltipText("Has implementations")
            .setAlignment(GutterIconRenderer.Alignment.LEFT)
            .createLineMarkerInfo(element)
    }
    
    /**
     * 创建类导航标记
     */
    private fun createClassNavigationMarker(element: PsiElement): LineMarkerInfo<PsiElement> {
        val classElement = element.parent as? ValkyrieClassDeclaration ?: return NavigationGutterIconBuilder
            .create(AllIcons.Gutter.ImplementedMethod)
            .setTargets(emptyList())
            .setTooltipText("Navigate to parent classes, subclasses, and implementations")
            .setAlignment(GutterIconRenderer.Alignment.LEFT)
            .createLineMarkerInfo(element)
        val parentClasses = findParentClasses(classElement)
        val subClasses = findSubClasses(classElement)
        val implementations = findImplementations(classElement)
        
        val targets = mutableListOf<PsiElement>()
        targets.addAll(parentClasses)
        targets.addAll(subClasses)
        targets.addAll(implementations)
        
        return NavigationGutterIconBuilder
            .create(AllIcons.Gutter.ImplementedMethod)
            .setTargets(targets)
            .setTooltipText("Navigate to parent classes, subclasses, and implementations")
            .setAlignment(GutterIconRenderer.Alignment.LEFT)
            .createLineMarkerInfo(element)
    }
    
    /**
     * 创建 namespace 导航标记
     */
    private fun createNamespaceNavigationMarker(element: PsiElement): LineMarkerInfo<PsiElement> {
        val namespaceElement = element.parent as? ValkyrieNamespaceDeclaration ?: return NavigationGutterIconBuilder
            .create(AllIcons.Nodes.Package)
            .setTargets(emptyList())
            .setTooltipText("Navigate to parent and child namespaces")
            .setAlignment(GutterIconRenderer.Alignment.LEFT)
            .createLineMarkerInfo(element)
        val parentNamespaces = findParentNamespaces(namespaceElement)
        val childNamespaces = findChildNamespaces(namespaceElement)
        
        val targets = mutableListOf<PsiElement>()
        targets.addAll(parentNamespaces)
        targets.addAll(childNamespaces)
        
        return NavigationGutterIconBuilder
            .create(AllIcons.Nodes.Package)
            .setTargets(targets)
            .setTooltipText("Navigate to parent and child namespaces")
            .setAlignment(GutterIconRenderer.Alignment.LEFT)
            .createLineMarkerInfo(element)
    }
    
    /**
     * 创建 imply 导航标记
     */
    private fun createImplyNavigationMarker(element: PsiElement): LineMarkerInfo<PsiElement> {
        val implyElement = element as ValkyrieImplyStatement
        val implementedClasses = findImplementedClasses(implyElement)
        
        return NavigationGutterIconBuilder
            .create(AllIcons.Gutter.ImplementingMethod)
            .setTargets(implementedClasses)
            .setTooltipText("Navigate to implemented classes")
            .setAlignment(GutterIconRenderer.Alignment.LEFT)
            .createLineMarkerInfo(element)
    }
    
    /**
     * 查找父类
     */
    private fun findParentClasses(classElement: ValkyrieClassDeclaration): List<PsiElement> {
        val symbolIndex = ValkyrieSymbolIndex.getInstance(classElement.project)
        val parentClassNames = classElement.getParentClasses()
        val parentClasses = mutableListOf<PsiElement>()
        
        for (parentName in parentClassNames) {
            val parentClass = symbolIndex.findClassByName(parentName)
            if (parentClass != null) {
                parentClasses.add(parentClass)
            }
        }
        
        return parentClasses
    }
    
    /**
     * 查找子类
     */
    private fun findSubClasses(classElement: ValkyrieClassDeclaration): List<PsiElement> {
        val symbolIndex = ValkyrieSymbolIndex.getInstance(classElement.project)
        val className = classElement.name ?: return emptyList()
        return symbolIndex.findClassesThatInheritFrom(className).map { it as PsiElement }
    }
    
    /**
     * 查找实现
     */
    private fun findImplementations(classElement: ValkyrieClassDeclaration): List<PsiElement> {
        // 对于类，实现就是子类
        return findSubClasses(classElement)
    }
    
    /**
     * 查找父级 namespace
     */
    private fun findParentNamespaces(namespaceElement: ValkyrieNamespaceDeclaration): List<PsiElement> {
        // TODO: 实现查找父级 namespace 的逻辑
        return emptyList()
    }
    
    /**
     * 查找子级 namespace
     */
    private fun findChildNamespaces(namespaceElement: ValkyrieNamespaceDeclaration): List<PsiElement> {
        // TODO: 实现查找子级 namespace 的逻辑
        return emptyList()
    }
    
    /**
     * 查找被实现的类
     */
    private fun findImplementedClasses(implyElement: ValkyrieImplyStatement): List<PsiElement> {
        // TODO: 实现查找被实现的类的逻辑
        return emptyList()
    }
    
    /**
     * 查找 namespace 相关声明
     */
    private fun findNamespaceDeclarations(namespaceElement: ValkyrieNamespaceDeclaration): List<PsiElement> {
        val symbolIndex = ValkyrieSymbolIndex.getInstance(namespaceElement.project)
        val namespaceName = namespaceElement.name ?: return emptyList()
        
        // 查找在此 namespace 中定义的所有符号
        val declarations = mutableListOf<PsiElement>()
        
        // 查找类
        declarations.addAll(symbolIndex.findClassesInNamespace(namespaceName).map { it as PsiElement })
        
        // 查找函数
        declarations.addAll(symbolIndex.findFunctionsInNamespace(namespaceName).map { it as PsiElement })
        
        return declarations
    }
    
    /**
     * 查找 imply 相关声明
     */
    private fun findImplyDeclarations(implyElement: ValkyrieImplyStatement): List<PsiElement> {
        val symbolIndex = ValkyrieSymbolIndex.getInstance(implyElement.project)
        
        // 获取 imply 的目标类型
        val targetTypeNode = implyElement.getTargetType() ?: return emptyList()
        val targetType = targetTypeNode.text
        
        // 查找相关的类或接口定义
        val targetClass = symbolIndex.findClassByName(targetType)
        if (targetClass != null) {
            return listOf(targetClass)
        }
        
        return emptyList()
    }
}