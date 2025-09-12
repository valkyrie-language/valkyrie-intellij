package valkyrie.ide.marker

import com.intellij.codeInsight.daemon.LineMarkerInfo
import com.intellij.codeInsight.daemon.LineMarkerProvider
import com.intellij.codeInsight.navigation.NavigationGutterIconBuilder
import com.intellij.icons.AllIcons
import com.intellij.openapi.editor.markup.GutterIconRenderer
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.psi.nodes.*
import valkyrie.index.ValkyrieSymbolIndex

/**
 * Valkyrie 行标记提供者
 * 用于提供 override、implement 等上下文功能的图标
 */
class ValkyrieLineMarkerProvider : LineMarkerProvider {
    
    override fun getLineMarkerInfo(element: PsiElement): LineMarkerInfo<*>? {
        return when {
            isOverrideMethod(element) -> createOverrideMarker(element)
            isImplementMethod(element) -> createImplementMarker(element)
            isInheritedMethod(element) -> createInheritedMarker(element)
            isClassDeclaration(element) -> createClassNavigationMarker(element)
            isNamespaceDeclaration(element) -> createNamespaceNavigationMarker(element)
            isImplyDeclaration(element) -> createImplyNavigationMarker(element)
            else -> null
        }
    }
    
    /**
     * 检查是否为重写方法
     */
    private fun isOverrideMethod(element: PsiElement): Boolean {
        if (element !is ValkyrieMethodDeclaration) return false
        
        // 检查是否有 override 修饰符
        val modifiers = PsiTreeUtil.findChildrenOfType(element, ValkyrieModifierNode::class.java)
        return modifiers.any { it.text == "override" }
    }
    
    /**
     * 检查是否为实现方法
     */
    private fun isImplementMethod(element: PsiElement): Boolean {
        if (element !is ValkyrieMethodDeclaration) return false
        
        // 检查是否在 imply 块中
        val implyBlock = PsiTreeUtil.getParentOfType(element, ValkyrieImplyStatement::class.java)
        return implyBlock != null
    }
    
    /**
     * 检查是否为继承方法
     */
    private fun isInheritedMethod(element: PsiElement): Boolean {
        if (element !is ValkyrieMethodDeclaration) return false
        
        // 检查是否在 trait 或 class 中定义
        val parent = PsiTreeUtil.getParentOfType(element, ValkyrieTraitDeclaration::class.java)
            ?: PsiTreeUtil.getParentOfType(element, ValkyrieClassDeclaration::class.java)
        return parent != null
    }
    
    /**
     * 检查是否为类声明
     */
    private fun isClassDeclaration(element: PsiElement): Boolean {
        return element is ValkyrieClassDeclaration
    }
    
    /**
     * 检查是否为 namespace 声明
     */
    private fun isNamespaceDeclaration(element: PsiElement): Boolean {
        return element is ValkyrieNamespaceDeclaration
    }
    
    /**
     * 检查是否为 imply 声明
     */
    private fun isImplyDeclaration(element: PsiElement): Boolean {
        return element is ValkyrieImplyStatement
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
        val classElement = element as ValkyrieClassDeclaration
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
        val namespaceElement = element as ValkyrieNamespaceDeclaration
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