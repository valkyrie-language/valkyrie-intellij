package valkyrie.ast

import com.intellij.lang.ASTNode
import com.intellij.lang.LightPsiParser
import com.intellij.lang.PsiBuilder
import com.intellij.lang.PsiParser
import com.intellij.psi.tree.IElementType
import valkyrie.ast.node.ValkyrieProgramNode
import valkyrie.cst.ValkyrieCST

class ValkyrieParser : PsiParser, LightPsiParser {
    override fun parse(root: IElementType, builder: PsiBuilder): ASTNode {
        parseLight(root, builder)
        return builder.treeBuilt
    }

    override fun parseLight(root: IElementType?, builder: PsiBuilder?) {
        if (root == null || builder == null) return
        val rootMarker = builder.mark()
        ValkyrieProgramNode.parse(builder)
        val unknown = builder.mark();
        while (!builder.eof()) {
            builder.advanceLexer()
        }
        unknown.done(Unknown)
        rootMarker.done(root)
    }
}

// 按顺序解析全部节点, 中间有一个失败就都失败
fun PsiBuilder.advanceSequence(vararg parsers: ParserMonad, ignore: Boolean): Boolean {
    val marker = mark()
    for (parser in parsers) {
        if (parser.parse(this)) {
            if (ignore) {
                this.advanceIgnore()
            }
            continue
        } else {
            marker.rollbackTo()
            return false
        }
    }
    marker.drop()
    return true
}

// 尝试多个解析函数，选择第一个匹配的
fun PsiBuilder.advanceChoice(vararg parsers: ParserMonad): Boolean {
    for (parser in parsers) {
        val marker = mark()
        if (parser.parse(this)) {
            marker.drop()
            return true
        } else if (parser == parsers.last()) {
            marker.error("Expected ${parser}");
            return false
        } else {
            marker.drop()
        }
    }
    return false
}

// 尝试解析, 无论是否成功都返回 true
fun PsiBuilder.advanceOption(parser: ParserMonad): Boolean {
    val marker = mark()
    parser.parse(this)
    marker.drop()
    return true
}

// 循环解析，直到失败, 最终解析个数必须在 min, max 之间
fun PsiBuilder.advanceRepeat(parser: ParserMonad, min: Int = 0, max: Int = Int.MAX_VALUE): Boolean {
    val marker = mark()
    var count = 0
    while (count < max && parser.parse(this)) {
        count++
    }
    if (count >= min && count <= max) {
        marker.drop()
        return true
    } else {
        marker.rollbackTo()
        return false
    }
}

// 跳过空白和注释
fun PsiBuilder.advanceIgnore() {
    while (!this.eof()) {
        val tokenType = this.tokenType
        when {
            tokenType === ValkyrieCST.Companion.WHITE_SPACE -> this.advanceLexer()
            tokenType === ValkyrieCST.Companion.COMMENT_LINE -> this.advanceLexer()
            tokenType === ValkyrieCST.Companion.COMMENT_BLOCK -> this.advanceLexer()
            else -> break
        }
    }
}


fun PsiBuilder.parsePaired(
    type: IElementType,
    left: IElementType,
    right: IElementType,
    split: IElementType,
    element: ParserMonad,
): Boolean {
    val marker = this.mark()
    assert(this.tokenType === left)
    // 消费左括号
    this.advanceLexer()
    this.advanceIgnore()
    // 无元素
    if (this.tokenType === right) {
        this.advanceLexer() // 消费 ']'
        marker.done(type)
        return true
    }
    // 解析值列表
    var first = true
    while (!this.eof() && this.tokenType !== right) {
        if (!first) {
            // 检查是否有逗号分隔符
            if (this.tokenType !== split) {
                // 如果下一个token是右括号，则允许省略逗号
                this.advanceIgnore()
                if (this.tokenType === right) {
                    break
                }
                this.error("Expected ${split}")
                break
            }
            // 消费分隔符
            this.advanceLexer()
            this.advanceIgnore()

            // 处理尾随逗号情况
            if (this.tokenType === right) {
                break
            }
        }
        element.parse(this)
        first = false
        this.advanceIgnore()
    }

    // 消费结束的右括号
    if (this.tokenType === right) {
        this.advanceLexer() // 消费 ']'
    } else {
        this.error("Expected ']'")
    }

    marker.done(type)
    return true
}