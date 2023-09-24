package valkyrie.language.psi

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiFileFactory
import valkyrie.language.ValkyrieLanguage
import valkyrie.psi.node.*

class ValkyrieFactory(project: Project) {
    private val factory: PsiFileFactory = project.getService(PsiFileFactory::class.java)

    /** ↯macro */
    val operatorMacroLower: PsiElement by lazy { createAttributeBelow("↯m class C{}").firstChild }

    /** a × b */
    val operatorMultiplication: PsiElement by lazy { createInfix("×") }

    /** a⸬b⸬c */
    val nameSplit: PsiElement by lazy { createInfix("⸬") }


//    fun createSymbol(kind: IElementType, text: String): LeafElement {
//        return createLeaf(ValkyrieTypes.SYMBOL, text)
//    }

//    fun createLeaf(kind: IElementType, text: String): LeafElement {
//        val manager = PsiManagerEx.getInstanceEx(_project)
//        val holder = DummyHolder(manager, null, null, null, true, ValkyrieLanguage)
//        val leaf = ASTFactory.leaf(kind, holder.treeElement.charTable.intern(text))
//        CodeEditUtil.setNodeGenerated(leaf, true);
//        return leaf
//    }

    fun createInfix(infix: String): PsiElement {
        return createFile("a${infix}b")
            .firstChild  // ValkyrieStatementsNode(ValkyrieElement.STATEMENTS)
            .firstChild  // ValkyrieExpressionRootNode(ValkyrieElement.EXPRESSION_ROOT)
            .firstChild  // ValkyrieExpressionNode(ValkyrieElement.EXPRESSION)
            .children[1] // ValkyrieInfixNode(ValkyrieElement.INFIX)
    }

    fun createFile(text: String): PsiFile {
        return factory.createFileFromText("factory.valkyrie", ValkyrieLanguage, text);
    }

    fun createStatement(text: String): ValkyrieStatementsNode {
        return createFile(text).firstChild as ValkyrieStatementsNode
    }



    fun createClass(text: String): ValkyrieDeclareClassNode {
        val root = createStatement(text)
        return root.declareClass as ValkyrieDeclareClassNode
    }

    fun createAttributeBelow(text: String): ValkyrieAttributeBelowNode {
        val root = createClass(text)
        return root.annotations.attributeBelowList.first() as ValkyrieAttributeBelowNode
    }
    fun createTermExpression(text: String): ValkyrieExpressionNode {
        return createStatement(text).expressionRoot!!.expression as ValkyrieExpressionNode
    }

    fun createTermAtomic(text: String): ValkyrieAtomicNode {
        return createTermExpression(text).termList.first().atomic as ValkyrieAtomicNode
    }

    fun createNamepath(vararg name: String) {
        val root = createStatement(name.joinToString("⸬") { it })
    }

    fun createNumberLiteral(number: String, unit: String?): ValkyrieNumberLiteralNode {;
        val atom: ValkyrieAtomicNode = if (unit == null) {
            createTermAtomic(number)
        } else {
            createTermAtomic("${number}_${unit}")
        }
        return atom.numberLiteral as ValkyrieNumberLiteralNode
    }

//
//    private fun letDefineAtom(atom: String): ValkyrieAtom? {
//        val file = createFile("let target = $atom;");
//        for (child in file.children) {
//            if (child is ValkyrieLetStatementNode) {
//                return child.expression!!.termList.first().atom
//            }
//        }
//        return null
//    }
}