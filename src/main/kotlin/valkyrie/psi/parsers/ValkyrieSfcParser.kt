package valkyrie.psi.parsers

import com.intellij.lang.PsiBuilder
import com.intellij.lang.PsiBuilder.Marker
import valkyrie.language.ValkyrieLanguageConfig

/**
 * Valkyrie SFC 语法分析器
 * 用于解析 Valkyrie 组件文件（.vx）
 */
class ValkyrieSfcParser(config: ValkyrieLanguageConfig = ValkyrieLanguageConfig()) : ValkyrieParser(config) {

    /**
     * 解析 SFC 块
     */
    private fun parseSfcBlock(builder: PsiBuilder): Boolean {
        if (builder.tokenType != ValkyrieTypes.ANGLE_L) {
            return false
        }

        val marker = builder.mark()
        builder.advanceLexer() // 消费 '<'

        // 检查是否是结束标签
        if (builder.tokenType == ValkyrieTypes.SLASH) {
            marker.rollbackTo()
            return false
        }

        // 解析标签名
        if (builder.tokenType != ValkyrieTypes.SYMBOL_XID) {
            marker.rollbackTo()
            return false
        }

        val tagName = builder.tokenText ?: ""
        builder.advanceLexer()

        // 解析属性
        val attributes = mutableMapOf<String, String>()
        while (builder.tokenType != ValkyrieTypes.ANGLE_R &&
               builder.tokenType != ValkyrieTypes.SLASH &&
               !builder.eof()) {
            parseAttribute(builder, attributes)
        }

        // 检查是否是自闭合标签
        if (builder.tokenType == ValkyrieTypes.SLASH) {
            builder.advanceLexer() // 消费 '/'
            if (builder.tokenType == ValkyrieTypes.ANGLE_R) {
                builder.advanceLexer() // 消费 '>'
                doneBlock(marker, tagName)
                return true
            }
        }

        // 消费标签结束符
        if (builder.tokenType != ValkyrieTypes.ANGLE_R) {
            marker.rollbackTo()
            return false
        }
        builder.advanceLexer() // 消费 '>'

        // 解析块内容（包括嵌套标签）
        parseBlockContent(builder, tagName)

        // 解析结束标签
        if (builder.tokenType == ValkyrieTypes.ANGLE_L) {
            builder.advanceLexer() // 消费 '<'
            if (builder.tokenType == ValkyrieTypes.SLASH) {
                builder.advanceLexer() // 消费 '/'
                if (builder.tokenType == ValkyrieTypes.SYMBOL_XID && builder.tokenText == tagName) {
                    builder.advanceLexer() // 消费标签名
                    if (builder.tokenType == ValkyrieTypes.ANGLE_R) {
                        builder.advanceLexer() // 消费 '>'
                        doneBlock(marker, tagName)
                        return true
                    }
                }
            }
        }

        marker.drop()
        return false
    }

    /**
     * 解析属性
     */
    private fun parseAttribute(builder: PsiBuilder, attributes: MutableMap<String, String>) {
        if (builder.tokenType != ValkyrieTypes.SYMBOL_XID) {
            builder.advanceLexer()
            return
        }

        val name = builder.tokenText ?: ""
        builder.advanceLexer()

        var value = ""
        if (builder.tokenType == ValkyrieTypes.ASSIGN) {
            builder.advanceLexer() // 消费 '='
            if (builder.tokenType == ValkyrieTypes.STRING_DQ || builder.tokenType == ValkyrieTypes.STRING_MQ) {
                value = builder.tokenText ?: ""
                builder.advanceLexer()
            }
        }

        attributes[name] = value
    }

    /**
     * 解析块内容
     * 递归解析嵌套标签
     */
    private fun parseBlockContent(builder: PsiBuilder, parentTagName: String) {
        while (!builder.eof()) {
            // 检查是否是当前块的结束标签
            if (builder.tokenType == ValkyrieTypes.ANGLE_L) {
                val marker = builder.mark()
                builder.advanceLexer() // 消费 '<'
                
                if (builder.tokenType == ValkyrieTypes.SLASH) {
                    builder.advanceLexer() // 消费 '/'
                    if (builder.tokenType == ValkyrieTypes.SYMBOL_XID && builder.tokenText == parentTagName) {
                        // 是当前块的结束标签，回退并返回
                        marker.rollbackTo()
                        return
                    }
                }
                
                // 不是当前块的结束标签，回退并继续解析
                marker.rollbackTo()
            }

            // 尝试解析嵌套标签
            if (builder.tokenType == ValkyrieTypes.ANGLE_L) {
                if (parseSfcBlock(builder)) {
                    continue
                }
            }

            // 消费内容
            builder.advanceLexer()
        }
    }

    /**
     * 完成块解析
     */
    private fun doneBlock(marker: Marker, tagName: String) {
        val elementType = when (tagName) {
            "template" -> ValkyrieTypes.SFC_TEMPLATE
            "script" -> ValkyrieTypes.SFC_SCRIPT
            "style" -> ValkyrieTypes.SFC_STYLE
            else -> ValkyrieTypes.SFC_COMPONENT
        }
        marker.done(elementType)
    }

    /**
     * 解析语句扩展
     * 消费所有非标签内容，防止父类报错
     */
    override fun parseStatementExtension(builder: PsiBuilder): Boolean {
        // 如果是标签开始，解析 SFC 块
        if (builder.tokenType == ValkyrieTypes.ANGLE_L) {
            return parseSfcBlock(builder)
        }

        // 对于非标签内容，返回 false，让父类处理
        return false
    }
}