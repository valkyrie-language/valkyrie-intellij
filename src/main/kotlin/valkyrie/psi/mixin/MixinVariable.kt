package valkyrie.psi.mixin

import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import valkyrie.psi.ValkyrieDeclaration
import valkyrie.psi.node.*
import javax.swing.Icon

abstract class MixinVariable(node: ASTNode) : ValkyrieDeclaration(node), ValkyrieLetStatement {
    override fun getNameIdentifier(): MixinIdentifier? {
        return this.letPattern?.matchBind?.identifierSafe as? MixinIdentifier
    }

    override fun getBaseIcon(): Icon {
        return AllIcons.Nodes.Variable
    }
}


class ValkyrieVariableCollector : ValkyrieVisitor() {
    private var list = mutableListOf<MixinIdentifier>()
    override fun visitLetPattern(o: ValkyrieLetPattern) {
        o.barePattern?.let { visitBarePattern(it) }
        o.matchBind?.let { visitMatchBind(it) }
        o.casePatternDict?.let { visitCasePatternDict(it) }
        o.casePatternList?.let { visitCasePatternList(it) }
    }

    override fun visitBarePattern(o: ValkyrieBarePattern) {
        for (item in o.barePatternItemList) {
            list.add(item.identifierSafe as MixinIdentifier)
        }
    }

    override fun visitMatchBind(o: ValkyrieMatchBind) {
        list.add(o.identifierSafe as MixinIdentifier)
    }

    override fun visitCasePatternList(o: ValkyrieCasePatternList) {

    }
    override fun visitPatternObject(o: ValkyriePatternObject) {
        super.visitPatternObject(o)
    }

    fun finish(): List<MixinIdentifier> {
        return list.filterNotNull().mapNotNull { it as? MixinIdentifier }
    }
}
