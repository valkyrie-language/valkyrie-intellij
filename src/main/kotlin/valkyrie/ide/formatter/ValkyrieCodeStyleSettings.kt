package valkyrie.ide.formatter

import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.codeStyle.CustomCodeStyleSettings

/**
 * Valkyrie 代码样式设置
 */
class ValkyrieCodeStyleSettings(settings: CodeStyleSettings) : CustomCodeStyleSettings("ValkyrieCodeStyleSettings", settings) {
    
    // 空格设置
    @JvmField
    var SPACE_BEFORE_COLON = false
    
    @JvmField
    var SPACE_AFTER_COLON = true
    
    @JvmField
    var SPACE_AROUND_ARROW = true
    
    @JvmField
    var SPACE_BEFORE_COMMA = false
    
    @JvmField
    var SPACE_AFTER_COMMA = true
    
    @JvmField
    var SPACE_AROUND_DOT = false
    
    // 大括号设置
    @JvmField
    var BRACE_STYLE = 1 // END_OF_LINE
    
    @JvmField
    var CLASS_BRACE_STYLE = 1 // END_OF_LINE
    
    @JvmField
    var METHOD_BRACE_STYLE = 1 // END_OF_LINE
    
    // 换行设置
    @JvmField
    var KEEP_LINE_BREAKS = true
    
    @JvmField
    var KEEP_BLANK_LINES_IN_CODE = 2
    
    @JvmField
    var KEEP_BLANK_LINES_IN_DECLARATIONS = 2
    
    @JvmField
    var KEEP_BLANK_LINES_BEFORE_RBRACE = 1
    
    // 对齐设置
    @JvmField
    var ALIGN_MULTILINE_PARAMETERS = true
    
    @JvmField
    var ALIGN_MULTILINE_PARAMETERS_IN_CALLS = true
    
    @JvmField
    var ALIGN_MULTILINE_BINARY_OPERATION = false
    
    @JvmField
    var ALIGN_MULTILINE_ASSIGNMENT = false
    
    // 包装设置
    @JvmField
    var CALL_PARAMETERS_WRAP = 0 // DO_NOT_WRAP
    
    @JvmField
    var METHOD_PARAMETERS_WRAP = 0 // DO_NOT_WRAP
    
    @JvmField
    var BINARY_OPERATION_WRAP = 0 // DO_NOT_WRAP
    
    @JvmField
    var ASSIGNMENT_WRAP = 0 // DO_NOT_WRAP
    
    // 其他设置
    @JvmField
    var BLANK_LINES_AROUND_CLASS = 1
    
    @JvmField
    var BLANK_LINES_AROUND_METHOD = 1
    
    @JvmField
    var BLANK_LINES_AROUND_FIELD = 0
    
    @JvmField
    var BLANK_LINES_AFTER_CLASS_HEADER = 0
    
    @JvmField
    var BLANK_LINES_AFTER_IMPORTS = 1
    
    @JvmField
    var BLANK_LINES_BEFORE_IMPORTS = 1
}