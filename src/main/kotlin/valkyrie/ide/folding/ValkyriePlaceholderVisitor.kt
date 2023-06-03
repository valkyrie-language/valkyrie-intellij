package valkyrie.ide.folding

import valkyrie.psi.node.*

class ValkyriePlaceholderVisitor : ValkyrieVisitor() {
    var placeholder = "..."

    override fun visitUsingBody(o: ValkyrieUsingBody) {
        placeholder = "${o.usingTermList.size} items"
    }

    override fun visitClassBody(o: ValkyrieClassBody) {
        val fields = o.declareFieldList.count();
        val methods = o.declareMethodList.count();
        val domain = o.declareDomainList.count()
        placeholder = mutableListOf(
            if (fields <= 1) {
                "$fields field"
            } else {
                "$fields fields"
            },
            if (methods <= 1) {
                "$methods method"
            } else {
                "$methods methods"
            },
            if (domain <= 1) {
                "$domain domain"
            } else {
                "$domain domains"
            }
        )
            .joinToString(", ")
    }

    override fun visitEnumerateBody(o: ValkyrieEnumerateBody) {
        var counter = 0;
        for (item in o.enumerateItemList) {
            if (item.firstChild is ValkyrieDeclareSemantic) {
                counter += 1
            }
        }
        placeholder = when (counter) {
            0, 1 -> {
                "$counter variant"
            }

            else -> {
                "$counter variants"
            }
        }
    }

    override fun visitUniteBody(o: ValkyrieUniteBody) {
        var counter = 0;
        for (item in o.uniteItemList) {
            if (item.firstChild is ValkyrieDeclareVariant) {
                counter += 1
            }
        }
        placeholder = when (counter) {
            0, 1 -> {
                "$counter variant"
            }

            else -> {
                "$counter variants"
            }
        }
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