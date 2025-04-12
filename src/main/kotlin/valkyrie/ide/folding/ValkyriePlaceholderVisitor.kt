package valkyrie.ide.folding

import valkyrie.ast.ValkyrieVisitor
import valkyrie.ast.node.ValkyrieObjectNode
import valkyrie.ast.node.ValkyrieUsingBodyNode
import valkyrie.psi.node.*

class ValkyriePlaceholderVisitor : ValkyrieVisitor() {
    var placeholder = "..."

    override fun visitUsingBody(o: ValkyrieUsingBodyNode) {
//        placeholder = "${o.usingTermList.size} items"
    }

    override fun visitClassBody(o: ValkyrieObjectNode) {
        val text = PluralJoiner()
        text.add(o.fields.count(), "field", "fields")
        text.add(o.methods.count(), "method", "methods")
        text.add(o.domains.count(), "domain", "domains")
        placeholder = text.finish()
    }

    override fun visitFlagsBody(o: ValkyrieFlagsBody) {
        val text = PluralJoiner()
        if (o.parent is ValkyrieDeclareEnums) {
            text.add(o.declareSemanticList.count(), "enumerate", "enumerates")
        } else {
            text.add(o.declareSemanticList.count(), "flag", "flags")
        }
        text.add(o.declareMethodList.count(), "method", "methods")
        text.add(o.declareDomainList.count(), "domain", "domains")
        placeholder = text.finish()
    }


    override fun visitUniteBody(o: ValkyrieUniteBody) {
        val text = PluralJoiner()
        text.add(o.declareVariantList.count(), "variant", "variants")
        text.add(o.declareMethodList.count(), "method", "methods")
        placeholder = text.finish()
    }

    override fun visitMatchBody(o: ValkyrieMatchBody) {
        val text = PluralJoiner()
        val branches = o.matchCaseList.count() + o.matchWhenList.count() + o.matchWhenList.count() + o.matchElseList.count()
        text.add(branches, "branch", "branches")
        placeholder = text.finish()
    }

}

private class PluralJoiner {
    private var terms: MutableList<Triple<Int, String, String>> = mutableListOf()

    fun add(count: Int, singular: String, plural: String) {
        terms += Triple(count, singular, plural)
    }

    fun finish(): String {
        return if (terms.sumOf { it.first } == 0) {
            "nothing"
        } else {
            terms.filter { it.first != 0 }.joinToString(", ") {
                if (it.first == 1) {
                    "1 ${it.second}"
                } else {
                    "${it.first} ${it.third}"
                }
            }
        }
    }

}