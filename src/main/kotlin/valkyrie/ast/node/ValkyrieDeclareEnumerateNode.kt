package valkyrie.ast.node

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.*
import valkyrie.cst.KW_TRAIT
import valkyrie.ide.highlight.HighlightColor
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.psi.ValkyrieDeclaration
import javax.swing.Icon

class ValkyrieDeclareEnumerateNode(node: ASTNode) : ValkyrieDeclaration(node) {
    val keyword = findChildByClass(ValkyrieKeywordNode::class.java)!!
    val identifier = findChildByClass(ValkyrieIdentifierNode::class.java)
    val superTraits = findChildByClass(ValkyrieInheritListNode::class.java)?.items ?: arrayOf()
    val body = findChildByClass(ValkyrieObjectNode::class.java)

    override val color: HighlightColor?
        get() = HighlightColor.SYM_TRAIT

    override fun getBaseIcon(): Icon {
        return ValkyrieIconProvider.Instance.Enumeration
    }

    override fun getNameIdentifier(): ValkyrieIdentifierNode? {
        return identifier
    }

    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitDeclareEnums(this)
            else -> visitor.visitElement(this)
        }
    }

    override fun toString(): String {
        return "TraitDeclaration"
    }

    companion object : ParserMonad {
        override fun parse(builder: PsiBuilder): Boolean {
            return parseEnumerate(builder, false)
        }
    }
}

fun parseEnumerate(builder: PsiBuilder, anonymous: Boolean): Boolean {
    val marker = builder.mark()
    // 解析注解, 匿名对象不能使用注解
    when {
        anonymous -> {}
        else -> {
            ValkyrieAnnotationAreaNode.parse(builder)
            builder.advanceIgnore()
        }
    }
    // 检查是否有 class 关键字
    if (ValkyrieKeyword(KW_TRAIT).parse(builder)) {
        builder.advanceIgnore()
    } else {
        marker.drop()
        return false
    }
    // 解析类名
    if (ValkyrieIdentifierNode.parse(builder)) {
        builder.advanceIgnore()
    } else {
        marker.drop()
        return false
    }
    // 解析继承列表
    ValkyrieInheritListNode.parse(builder)
    builder.advanceIgnore()
    // 解析类体
    if (!ValkyrieObjectNode.parse(builder)) {
        marker.drop()
        return false
    }
    if (anonymous) {
        marker.done(AnonymousClass)
    } else {
        marker.done(DeclareTrait)
    }

    return true
}