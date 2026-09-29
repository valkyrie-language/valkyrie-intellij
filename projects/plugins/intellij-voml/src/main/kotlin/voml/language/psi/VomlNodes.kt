package voml.language.psi

import voml.language.VomlFile
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType
import com.intellij.psi.util.PsiTreeUtil

class VomlTableNode(node: ASTNode) : VomlNode(node) {
    val pairList: List<VomlPairNode> get() = PsiTreeUtil.getChildrenOfTypeAsList(this, VomlPairNode::class.java)
    val valueList: List<VomlValueNode> get() = PsiTreeUtil.getChildrenOfTypeAsList(this, VomlValueNode::class.java)
    val typeHint: PsiElement? get() = token(VomlTypes.TYPE_HINT)
    val braceL: PsiElement? get() = token(VomlTypes.BRACE_L)
    val braceR: PsiElement? get() = token(VomlTypes.BRACE_R)
    val bracketL: PsiElement? get() = token(VomlTypes.BRACKET_L)
    val bracketR: PsiElement? get() = token(VomlTypes.BRACKET_R)
    val parenthesisL: PsiElement? get() = token(VomlTypes.PARENTHESIS_L)
    val parenthesisR: PsiElement? get() = token(VomlTypes.PARENTHESIS_R)
}

class VomlPairNode(node: ASTNode) : VomlNode(node) {
    val symbolPath: VomlSymbolPathNode get() = childRequired()
    val value: VomlValueNode get() = childRequired()
}

class VomlSymbolPathNode(node: ASTNode) : VomlNode(node) {
    val keySymbolList: List<VomlNode> get() = childrenOfKind(VomlTypes.KEY_SYMBOL)
    val stringInlineList: List<VomlNode> get() = childrenOfKind(VomlTypes.STRING_INLINE)
}

class VomlAnnotationNode(node: ASTNode) : VomlNode(node) {
    val valueList: List<VomlValueNode> get() = PsiTreeUtil.getChildrenOfTypeAsList(this, VomlValueNode::class.java)
}

class VomlValueNode(node: ASTNode) : VomlNode(node) {
    val annotation: VomlAnnotationNode? get() = child()
    val table: VomlTableNode? get() = child()
    val ref: VomlNode? get() = child(VomlTypes.REF)
    val stringInline: VomlNode? get() = child(VomlTypes.STRING_INLINE)
    val stringMulti: VomlNode? get() = child(VomlTypes.STRING_MULTI)
    val stringPrefix: VomlNode? get() = child(VomlTypes.STRING_PREFIX)
    val numberSuffix: VomlNode? get() = child(VomlTypes.NUMBER_SUFFIX)
    val boolean: PsiElement? get() = token(VomlTypes.BOOLEAN)
    val byte: PsiElement? get() = token(VomlTypes.BYTE)
    val decimal: PsiElement? get() = token(VomlTypes.DECIMAL)
    val decimalBad: PsiElement? get() = token(VomlTypes.DECIMAL_BAD)
    val integer: PsiElement? get() = token(VomlTypes.INTEGER)
    val sign: PsiElement? get() = token(VomlTypes.SIGN)

    fun isNull(): Boolean = token(VomlTypes.NULL) != null
}

private inline fun <reified T : VomlNode> VomlNode.child(): T? =
    PsiTreeUtil.findChildOfType(this, T::class.java)

private inline fun <reified T : VomlNode> VomlNode.childRequired(): T =
    child<T>() ?: error("Missing ${T::class.java.simpleName} in $this")

private fun VomlNode.child(kind: IElementType): VomlNode? =
    node.getChildren(null).firstOrNull { it.elementType == kind }?.psi as? VomlNode

private fun VomlNode.childrenOfKind(kind: IElementType): List<VomlNode> =
    node.getChildren(null).mapNotNull { child -> (child.psi as? VomlNode)?.takeIf { it.node.elementType == kind } }

fun VomlFile.rootTable(): VomlTableNode? =
    PsiTreeUtil.findChildrenOfType(this, VomlTableNode::class.java)
        .firstOrNull { it.braceL != null }

fun PsiFile.rootVomlTable(): VomlTableNode? = (this as? VomlFile)?.rootTable()
