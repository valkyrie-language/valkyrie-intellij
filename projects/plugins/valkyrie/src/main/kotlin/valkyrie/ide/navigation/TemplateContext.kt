package valkyrie.ide.navigation

/**
 * 模板上下文信息
 */
data class TemplateContext(
    val type: TemplateType,
    val isComplete: Boolean,
    val innerText: String,
    val generatedPreview: String
)