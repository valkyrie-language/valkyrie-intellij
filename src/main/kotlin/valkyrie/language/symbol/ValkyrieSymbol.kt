package valkyrie.language.symbol

import com.intellij.model.Pointer
import com.intellij.model.Symbol
import com.intellij.model.psi.PsiSymbolDeclaration
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import valkyrie.language.psi_node.ValkyrieClassStatementNode
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

    fun defineClass(target: ValkyrieClassStatementNode, packageName: String, namespace: String) {
        val item = classes.getOrDefault(target.name, ValkyrieClassDeclare())
        item.myDefine = target
        item.packageName = packageName
        item.namespace = namespace
    }

    fun extendClass(target: ValkyrieExtendsStatementNode) {
        val item = classes.getOrDefault(target.name, ValkyrieClassDeclare())
        item.myExtends.add(target)
    }

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
    var packageName: String = "";
    var namespace: String = "";
    var myDefine: ValkyrieClassStatementNode? = null;
    var myExtends: MutableList<ValkyrieExtendsStatementNode> = mutableListOf();

    override fun getDeclaringElement(): ValkyrieClassStatementNode {
        return myDefine!!
    }

    override fun getRangeInDeclaringElement(): TextRange {
        return myDefine!!.nameIdentifier.textRange
    }

    override fun getSymbol(): ValkyrieSymbol {
        return ValkyrieSymbol(packageName, namespace, myDefine!!.name)
    }
}