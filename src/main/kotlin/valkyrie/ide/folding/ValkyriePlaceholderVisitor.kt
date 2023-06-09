package valkyrie.ide.folding

import valkyrie.psi.node.*

class ValkyriePlaceholderVisitor : ValkyrieVisitor() {
    var placeholder = "..."

    override fun visitUsingBody(o: ValkyrieUsingBody) {
        placeholder = "${o.usingTermList.size} items"
    }

    override fun visitClassBody(o: ValkyrieClassBody) {
        val text = PluralJoiner()
        text.add(o.declareFieldList.count(), "field", "fields")
        text.add(o.declareMethodList.count(), "method", "methods")
        text.add(o.declareDomainList.count(), "domain", "domains")
        placeholder = text.finish()
    }

    override fun visitEnumerateBody(o: ValkyrieEnumerateBody) {
        val text = PluralJoiner()
        text.add(o.declareSemanticList.count(), "enumerate", "enumerates")
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
        var counter = 0;
        for (item in o.matchItemList) {
            when (item.firstChild) {
                is ValkyrieMatchWith, is ValkyrieMatchCase, is ValkyrieMatchElse -> {
                    counter += 1
                }
            }
        }
        placeholder = when (counter) {
            0, 1 -> {
                "$counter branch"
            }

            else -> {
                "$counter branches"
            }
        }
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