package valkyrie.psi.lexers

/**
 * 标准 Valkyrie 词法分析器
 * 
 * 用于解析纯 Valkyrie 代码文件 (.vk)
 * 这是最基础的方言，只包含 Valkyrie 语言本身的语法结构
 */
class ValkyrieStandardLexer : ValkyrieLexerBase(LexerFlavor.STANDARD) {

    /**
     * 标准方言不需要特殊的文本处理逻辑
     * 所有解析都在基类的 processLanguage() 方法中完成
     */
}