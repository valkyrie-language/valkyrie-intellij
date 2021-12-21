package valkyrie.language.symbol

import com.intellij.model.Pointer
import com.intellij.model.Symbol
import com.intellij.model.psi.PsiSymbolDeclaration
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.util.indexing.FileBasedIndex
import io.ktor.util.reflect.*
import valkyrie.language.ast.ValkyrieClassDeclaration
import valkyrie.language.file.ValkyrieFileType
//import valkyrie.language.psi_node.ValkyrieClassStatementNode
import valkyrie.language.psi_node.ValkyrieExtendsStatementNode
import valkyrie.language.psi_node.ValkyrieTraitStatementNode

@Suppress("UnstableApiUsage")
class ValkyrieSymbol(val packageName: String = "", val namespace: String = "", val name: String = "") : Pointer<ValkyrieSymbol>, Symbol {
    override fun dereference(): ValkyrieSymbol? {
        return this
    }

    override fun createPointer(): Pointer<out Symbol> {
        return this
    }
}

object WorkspaceManager {
    private val packages = mutableMapOf<String, PackageManager>()

    fun findDefinition(symbol: ValkyrieSymbol): PsiElement? {
        val packageManager = packages[symbol.packageName]
        return packageManager?.findDefinition(symbol)
    }

    fun defineClass(target: ValkyrieClassDeclaration, packageName: String, namespace: String) {
        val packageManager = packages.getOrPut(packageName) { PackageManager() }
        val namespaceManager = packageManager.namespace.getOrPut(namespace) { NamespaceManager() }
        val define = namespaceManager.classes[target.name];
        val insert = ValkyrieClassDeclare(target, packageName, namespace);
        if (define != null) {
            insert.myExtends.addAll(define.myExtends)
        }
        namespaceManager.classes[target.name] = insert
    }

}

class PackageManager {
    val namespace = mutableMapOf<String, NamespaceManager>()
    fun findDefinition(symbol: ValkyrieSymbol): PsiElement? {
        val namespace = namespace[symbol.namespace]
        return namespace?.findDefinition(symbol)
    }
}

class NamespaceManager {
    val classes = mutableMapOf<String, ValkyrieClassDeclare>()
    val traits = mutableMapOf<String, ValkyrieTraitStatementNode>()

    fun findDefinition(symbol: ValkyrieSymbol): PsiElement? {
        val findClass = classes[symbol.name];
        if (findClass != null) {
            return findClass.myDefine
        }
        val findTrait = traits[symbol.name];
        if (findTrait != null) {
            return findTrait
        }
        return null
    }
}

@Suppress("UnstableApiUsage")
class ValkyrieClassDeclare : PsiSymbolDeclaration {
    var mySymbol: ValkyrieSymbol;
    var myDefine: PsiElement;
    var myExtends: MutableList<ValkyrieExtendsStatementNode>;

    constructor(classNode: ValkyrieClassDeclaration, packageName: String, namespace: String) {
        mySymbol = ValkyrieSymbol(packageName, namespace, classNode.name)
        myDefine = classNode
        myExtends = mutableListOf()
    }

    constructor(extendNode: ValkyrieExtendsStatementNode, packageName: String, namespace: String) {
        mySymbol = ValkyrieSymbol(packageName, namespace, extendNode.name)
        myDefine = extendNode
        myExtends = mutableListOf(extendNode)
    }

    override fun getDeclaringElement(): ValkyrieClassDeclaration {
        return myDefine as ValkyrieClassDeclaration
    }

    override fun getRangeInDeclaringElement(): TextRange {
        return declaringElement.nameIdentifier.textRange
    }

    override fun getSymbol(): ValkyrieSymbol {
        return mySymbol
    }
}