package von.language.psi

import von.language.VonFile
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet
import com.intellij.psi.util.PsiTreeUtil

val Von_COMMENTS = TokenSet.create(VonTypes.BLOCK_COMMENT, VonTypes.COMMENT)

fun tokenSetOf(vararg tokens: IElementType) = TokenSet.create(*tokens)

class VonTableNode(node: ASTNode) : VonNode(node) {
    val pairList: List<VonPairNode> get() = PsiTreeUtil.getChildrenOfTypeAsList(this, VonPairNode::class.java)
    val valueList: List<VonValueNode> get() = PsiTreeUtil.getChildrenOfTypeAsList(this, VonValueNode::class.java)
    val typeHint: PsiElement? get() = token(VonTypes.TYPE_HINT)
    val braceL: PsiElement? get() = token(VonTypes.BRACE_L)
    val braceR: PsiElement? get() = token(VonTypes.BRACE_R)
    val bracketL: PsiElement? get() = token(VonTypes.BRACKET_L)
    val bracketR: PsiElement? get() = token(VonTypes.BRACKET_R)
    val parenthesisL: PsiElement? get() = token(VonTypes.PARENTHESIS_L)
    val parenthesisR: PsiElement? get() = token(VonTypes.PARENTHESIS_R)
}

class VonPairNode(node: ASTNode) : VonNode(node) {
    val symbolPath: VonSymbolPathNode get() = childRequired()
    /** Null when the pair is incomplete (`key:` / `key=` without a value). */
    val value: VonValueNode? get() = child()
}

class VonSymbolPathNode(node: ASTNode) : VonNode(node) {
    val keySymbolList: List<VonNode> get() = childrenOfKind(VonTypes.KEY_SYMBOL)
    val stringInlineList: List<VonNode> get() = childrenOfKind(VonTypes.STRING_INLINE)
}

class VonAnnotationNode(node: ASTNode) : VonNode(node) {
    val valueList: List<VonValueNode> get() = PsiTreeUtil.getChildrenOfTypeAsList(this, VonValueNode::class.java)
}

class VonValueNode(node: ASTNode) : VonNode(node) {
    val annotation: VonAnnotationNode? get() = child()
    val table: VonTableNode? get() = child()
    val ref: VonNode? get() = child(VonTypes.REF)
    val stringInline: VonNode? get() = child(VonTypes.STRING_INLINE)
    val stringMulti: VonNode? get() = child(VonTypes.STRING_MULTI)
    val stringPrefix: VonNode? get() = child(VonTypes.STRING_PREFIX)
    val numberSuffix: VonNode? get() = child(VonTypes.NUMBER_SUFFIX)
    val boolean: PsiElement? get() = token(VonTypes.BOOLEAN)
    val byte: PsiElement? get() = token(VonTypes.BYTE)
    val decimal: PsiElement? get() = token(VonTypes.DECIMAL)
    val decimalBad: PsiElement? get() = token(VonTypes.DECIMAL_BAD)
    val integer: PsiElement? get() = token(VonTypes.INTEGER)
    val sign: PsiElement? get() = token(VonTypes.SIGN)

    fun isNull(): Boolean = token(VonTypes.NULL) != null
}

private inline fun <reified T : VonNode> VonNode.child(): T? =
    PsiTreeUtil.findChildOfType(this, T::class.java)

private inline fun <reified T : VonNode> VonNode.childRequired(): T =
    child<T>() ?: error("Missing ${T::class.java.simpleName} in $this")

private fun VonNode.child(kind: IElementType): VonNode? =
    node.getChildren(null).firstOrNull { it.elementType == kind }?.psi as? VonNode

private fun VonNode.childrenOfKind(kind: IElementType): List<VonNode> =
    node.getChildren(null).mapNotNull { child -> (child.psi as? VonNode)?.takeIf { it.node.elementType == kind } }

fun VonFile.rootTable(): VonTableNode? =
    PsiTreeUtil.findChildrenOfType(this, VonTableNode::class.java)
        .firstOrNull { table ->
            table.braceL != null && PsiTreeUtil.getParentOfType(table, VonTableNode::class.java) == null
        }

fun PsiFile.rootVonTable(): VonTableNode? = (this as? VonFile)?.rootTable()
