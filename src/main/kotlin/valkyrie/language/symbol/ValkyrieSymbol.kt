package valkyrie.language.symbol

//import valkyrie.language.psi_node.ValkyrieClassStatementNode
import com.intellij.model.Pointer
import com.intellij.model.Symbol
import com.intellij.model.psi.PsiSymbolDeclaration
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import valkyrie.language.ast.classes.ValkyrieClassStatement
import valkyrie.language.ast.ValkyrieExtendsStatement
import valkyrie.language.ast.ValkyrieTraitStatement
//import valkyrie.language.psi_node.ValkyrieExtendsStatementNode

//import valkyrie.language.psi_node.ValkyrieTraitStatementNode

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

    fun defineClass(target: ValkyrieClassStatement, packageName: String, namespace: String) {
        val packageManager = packages.getOrPut(packageName) { PackageManager() }
        val namespaceManager = packageManager.namespace.getOrPut(namespace) { NamespaceManager() }
        val define = namespaceManager.classes[target.name];
        val insert = ValkyrieClassDeclare(target, packageName, namespace);
        if (define != null) {
            insert.myExtends.addAll(define.myExtends)
        }
//        namespaceManager.classes[target.name] = insert
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
    val traits = mutableMapOf<String, ValkyrieTraitStatement>()

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
    var myExtends: MutableList<ValkyrieExtendsStatement>;

    constructor(classNode: ValkyrieClassStatement, packageName: String, namespace: String) {
        mySymbol = ValkyrieSymbol(packageName, namespace, classNode.name ?: "[Missing]")
        myDefine = classNode
        myExtends = mutableListOf()
    }

    constructor(extendNode: ValkyrieExtendsStatement, packageName: String, namespace: String) {
        mySymbol = ValkyrieSymbol(packageName, namespace, extendNode.name)
        myDefine = extendNode
        myExtends = mutableListOf(extendNode)
    }

    override fun getDeclaringElement(): ValkyrieClassStatement {
        return myDefine as ValkyrieClassStatement
    }

    override fun getRangeInDeclaringElement(): TextRange {
        return declaringElement.nameIdentifier.textRange ?: declaringElement.textRange
    }

    override fun getSymbol(): ValkyrieSymbol {
        return mySymbol
    }
}