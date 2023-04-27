package valkyrie.ide.folding

import valkyrie.psi.node.*

class ValkyriePlaceholderVisitor : ValkyrieVisitor() {
    var placeholder = "..."

    override fun visitUsingBody(o: ValkyrieUsingBody) {
        placeholder = "${o.usingTermList.size} items"
    }

    override fun visitClassBody(o: ValkyrieClassBody) {
        var fields = 0;
        var methods = 0;
        for (item in o.classItemList) {
            when (item.firstChild) {
                is ValkyrieDeclareField -> {
                    fields += 1
                }

                is ValkyrieDeclareMethod -> {
                    methods += 1
                }
            }
        }
        if (fields == 0 && methods == 0) {
            return
        }
        val sb = StringBuilder()

        when (fields) {
            0 -> {
            }

            1 -> {
                sb.append("1 field, ")
            }

            else -> {
                sb.append("$fields fields, ")
            }
        }
        when (methods) {
            0 -> {

            }

            1 -> {
                sb.append("1 method")
            }

            else -> {
                sb.append("$methods methods")
            }
        }
        placeholder = sb.toString()
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