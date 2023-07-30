package valkyrie.psi.mixin

import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import valkyrie.psi.ValkyrieDeclaration
import valkyrie.psi.node.*
import javax.swing.Icon

abstract class MixinVariable(node: ASTNode) : ValkyrieDeclaration(node), ValkyrieLetStatement {
    override fun getNameIdentifier(): ValkyrieIdentifierNode? {
        return this.letPattern?.matchBind?.identifier as? ValkyrieIdentifierNode
    }

    override fun getBaseIcon(): Icon {
        return AllIcons.Nodes.Variable
    }
}


class ValkyrieVariableCollector : ValkyrieVisitor() {
    private var list = mutableListOf<ValkyrieIdentifier?>()
    override fun visitLetPattern(o: ValkyrieLetPattern) {
        o.barePattern?.let { visitBarePattern(it) }
        o.matchBind?.let { visitMatchBind(it) }
        o.casePatternTuple?.let { visitCasePatternTuple(it) }
        o.casePatternObject?.let { visitCasePatternObject(it) }
    }

    override fun visitBarePattern(o: ValkyrieBarePattern) {
        for (item in o.barePatternItemList) {
            list.add(item.identifier)
        }
    }

    override fun visitMatchBind(o: ValkyrieMatchBind) {
        list.add(o.identifier)
    }

    override fun visitCasePatternTuple(o: ValkyrieCasePatternTuple) {
        super.visitCasePatternTuple(o)
    }

    override fun visitPatternObject(o: ValkyriePatternObject) {
        super.visitPatternObject(o)
    }

    fun finish(): List<ValkyrieIdentifierNode> {
        return list.filterNotNull().mapNotNull { it as? ValkyrieIdentifierNode }
    }
}
