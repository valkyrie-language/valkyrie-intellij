package valkyrie.psi.parsers

import com.intellij.lang.PsiBuilder
import com.intellij.psi.xml.XmlTokenType
import valkyrie.psi.ValkyrieElementTypes
import valkyrie.psi.lexers.ValkyrieTokenTypes

/**
 * 解析 SFC template 语句
 */
fun parseSfcTemplateStatement(builder: PsiBuilder): Boolean {
    if (builder.tokenType != XmlTokenType.XML_START_TAG_START && builder.lookAhead(1) != ValkyrieTokenTypes.XML_TEMPLATE) {
        return false
    }

    val marker = builder.mark()
    builder.advanceLexer() // consume <
    builder.advanceLexer() // consume template

    // 解析模板内容
    while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.SEMICOLON) {
        builder.advanceLexer()
    }

    builder.consumeSemicolon()
    marker.done(ValkyrieElementTypes.SFC_TEMPLATE)
    return true
}

/**
 * 解析 SFC style 语句
 */
fun parseSfcStyleStatement(builder: PsiBuilder): Boolean {
    if (builder.tokenType != XmlTokenType.XML_START_TAG_START && builder.lookAhead(1) != ValkyrieTokenTypes.XML_STYLE) {
        return false
    }

    val marker = builder.mark()
    builder.advanceLexer() // consume XML_STYLE

    // 解析样式内容
    while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.SEMICOLON) {
        builder.advanceLexer()
    }

    builder.consumeSemicolon()
    marker.done(ValkyrieElementTypes.SFC_STYLE)
    return true
}

/**
 * 解析 SFC script 语句
 */
fun parseSfcScriptStatement(builder: PsiBuilder): Boolean {
    if (builder.tokenType != XmlTokenType.XML_START_TAG_START && builder.lookAhead(1) != ValkyrieTokenTypes.XML_SCRIPT) {
        return false
    }

    val marker = builder.mark()
    builder.advanceLexer() // consume XML_SCRIPT

    // 解析脚本内容
    while (!builder.eof() && builder.tokenType != ValkyrieTokenTypes.SEMICOLON) {
        builder.advanceLexer()
    }

    builder.consumeSemicolon()
    marker.done(ValkyrieElementTypes.SFC_SCRIPT)
    return true
}