package valkyrie.psi.mixin

import valkyrie.ast.ValkyrieVisitor
import valkyrie.ast.node.ValkyrieIdentifierNode
import valkyrie.psi.node.ValkyrieBarePattern
import valkyrie.psi.node.ValkyrieCasePatternList

class ValkyrieVariableCollector : ValkyrieVisitor() {
    private var list = mutableListOf<MixinIdentifier>()
//    override fun visitLetPattern(o: ValkyrieLetPattern) {
//        o.barePattern?.let { visitBarePattern(it) }
//        o.matchBind?.let { visitMatchBind(it) }
//        o.casePatternDict?.let { visitCasePatternDict(it) }
//        o.casePatternList?.let { visitCasePatternList(it) }
//    }


//    override fun visitTermBarePattern(o: ValkyrieBarePattern) {
//        for (item in o.barePatternItemList) {
//            list.add(item.identifierSafe as MixinIdentifier)
//        }
//    }
//
//    override fun visitMatchBind(o: ValkyrieMatchBind) {
//        list.add(o.identifierSafe as MixinIdentifier)
//    }

    override fun visitCasePatternList(o: ValkyrieCasePatternList) {

    }

    fun finish(): List<ValkyrieIdentifierNode> {
        return list.filterNotNull().mapNotNull { it as? ValkyrieIdentifierNode }
    }
}
