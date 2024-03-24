package valkyrie.ide.documentation

import com.intellij.lang.documentation.AbstractDocumentationProvider
import com.intellij.lang.documentation.DocumentationMarkup
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.DefaultActionGroup
import com.intellij.openapi.util.IconLoader
import com.intellij.psi.PsiElement
import com.intellij.psi.TokenType.WHITE_SPACE
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.psi.nodes.*
import valkyrie.psi.ValkyrieTokenTypes
import javax.swing.Icon

/**
 * Valkyrie 文档提供者
 * 支持左侧小图标切换渲染和文本模式
 */
class ValkyrieDocumentationProvider : AbstractDocumentationProvider() {
    
    companion object {
        private val RENDER_ICON: Icon = IconLoader.getIcon("/icons/showCacheable.svg", ValkyrieDocumentationProvider::class.java)
        private val TEXT_ICON: Icon = IconLoader.getIcon("/icons/untyped.svg", ValkyrieDocumentationProvider::class.java)
    }
    
    override fun generateDoc(element: PsiElement?, originalElement: PsiElement?): String? {
        if (element == null) return null
        
        // 检查是否为关键词
        val keywordDoc = getKeywordDocumentation(element)
        if (keywordDoc != null) {
            return keywordDoc
        }
        
        // 为变量、类型、函数等生成基础文档
        val basicDoc = generateBasicDocumentation(element)
        if (basicDoc != null) {
            return basicDoc
        }
        
        // 查找关联的doc comment
        val docComment = findDocComment(element)
        if (docComment != null) {
            val content = docComment.getMergedDocComment()
            return when (DocumentRenderModeManager.getCurrentMode()) {
                DocumentRenderMode.RENDERED -> formatAsRendered(content, element)
                DocumentRenderMode.TEXT -> formatAsText(content)
            }
        }
        
        return null
    }
    
    /**
     * 格式化为渲染模式
     */
    private fun formatAsRendered(content: String, element: PsiElement): String {
        val elementInfo = getElementInfo(element)
        
        return buildString {
            append(DocumentationMarkup.DEFINITION_START)
            append(elementInfo)
            append(DocumentationMarkup.DEFINITION_END)
            append(DocumentationMarkup.CONTENT_START)
            append(renderMarkdown(content))
            append(DocumentationMarkup.CONTENT_END)
        }
    }
    
    /**
     * 格式化为文本模式
     */
    private fun formatAsText(content: String): String {
        return buildString {
            append(DocumentationMarkup.CONTENT_START)
            append("<pre>")
            append(content.replace("<", "&lt;").replace(">", "&gt;"))
            append("</pre>")
            append(DocumentationMarkup.CONTENT_END)
        }
    }
    
    /**
     * 生成基础文档
     */
    private fun generateBasicDocumentation(element: PsiElement): String? {
        return when (element) {
            is ValkyrieLetStatementNode -> generateVariableDocumentation(element)
            is ValkyrieClassDeclaration -> generateTypeDocumentation(element, "class")
            is ValkyrieUnionDeclaration -> generateTypeDocumentation(element, "union")
            is ValkyrieTraitDeclaration -> generateTypeDocumentation(element, "trait")
            is ValkyrieNeuralDeclaration -> generateTypeDocumentation(element, "neural")
            is ValkyrieWidgetDeclaration -> generateTypeDocumentation(element, "widget")
            is ValkyrieSingletonDeclaration -> generateTypeDocumentation(element, "singleton")
            is ValkyrieMethodDeclaration -> generateFunctionDocumentation(element)
            is ValkyrieFieldDeclaration -> generateFieldDocumentation(element)
            is ValkyrieVariantDeclaration -> generateVariantDocumentation(element)
            is ValkyrieIdentifierNode -> generateIdentifierDocumentation(element)
            else -> null
        }
    }
    
    /**
     * 生成变量文档
     */
    private fun generateVariableDocumentation(element: ValkyrieLetStatementNode): String {
        val name = element.name ?: "unknown"
        val typeInfo = extractTypeFromLetStatement(element)
        
        return buildString {
            append(DocumentationMarkup.DEFINITION_START)
            append("<b>let</b> $name")
            if (typeInfo != null) {
                append(": $typeInfo")
            }
            append(DocumentationMarkup.DEFINITION_END)
            append(DocumentationMarkup.CONTENT_START)
            append("<p>不可变变量声明</p>")
            if (typeInfo != null) {
                append("<p><b>类型:</b> $typeInfo</p>")
            }
            append(DocumentationMarkup.CONTENT_END)
        }
    }
    
    /**
     * 生成类型文档
     */
    private fun generateTypeDocumentation(element: PsiElement, typeName: String): String {
        val name = when (element) {
            is ValkyrieClassDeclaration -> element.name
            is ValkyrieUnionDeclaration -> element.name
            is ValkyrieTraitDeclaration -> element.name
            is ValkyrieNeuralDeclaration -> element.name
            is ValkyrieWidgetDeclaration -> element.name
            is ValkyrieSingletonDeclaration -> element.name
            else -> "unknown"
        } ?: "unknown"
        
        return buildString {
            append(DocumentationMarkup.DEFINITION_START)
            append("<b>$typeName</b> $name")
            append(DocumentationMarkup.DEFINITION_END)
            append(DocumentationMarkup.CONTENT_START)
            append("<p>${getTypeDescription(typeName)}</p>")
            append(DocumentationMarkup.CONTENT_END)
        }
    }
    
    /**
     * 生成函数文档
     */
    private fun generateFunctionDocumentation(element: ValkyrieMethodDeclaration): String {
        val name = element.name ?: "unknown"
        val signature = buildFunctionSignature(element)
        
        return buildString {
            append(DocumentationMarkup.DEFINITION_START)
            append("<b>function</b> $signature")
            append(DocumentationMarkup.DEFINITION_END)
            append(DocumentationMarkup.CONTENT_START)
            append("<p>函数声明</p>")
            append(DocumentationMarkup.CONTENT_END)
        }
    }
    
    /**
     * 生成字段文档
     */
    private fun generateFieldDocumentation(element: ValkyrieFieldDeclaration): String {
        val name = element.name ?: "unknown"
        
        return buildString {
            append(DocumentationMarkup.DEFINITION_START)
            append("<b>field</b> $name")
            append(DocumentationMarkup.DEFINITION_END)
            append(DocumentationMarkup.CONTENT_START)
            append("<p>字段声明</p>")
            append(DocumentationMarkup.CONTENT_END)
        }
    }
    
    /**
     * 生成变体文档
     */
    private fun generateVariantDocumentation(element: ValkyrieVariantDeclaration): String {
        val name = element.name ?: "unknown"
        
        return buildString {
            append(DocumentationMarkup.DEFINITION_START)
            append("<b>variant</b> $name")
            append(DocumentationMarkup.DEFINITION_END)
            append(DocumentationMarkup.CONTENT_START)
            append("<p>联合类型变体</p>")
            append(DocumentationMarkup.CONTENT_END)
        }
    }
    
    /**
     * 生成标识符文档
     */
    private fun generateIdentifierDocumentation(element: ValkyrieIdentifierNode): String? {
        val name = element.name ?: return null
        
        // 尝试查找标识符的定义
        val definition = findIdentifierDefinition(element, name)
        if (definition != null) {
            return generateBasicDocumentation(definition)
        }
        
        return buildString {
            append(DocumentationMarkup.DEFINITION_START)
            append("<b>identifier</b> $name")
            append(DocumentationMarkup.DEFINITION_END)
            append(DocumentationMarkup.CONTENT_START)
            append("<p>标识符引用</p>")
            append(DocumentationMarkup.CONTENT_END)
        }
    }
    
    /**
     * 获取元素信息
     */
    private fun getElementInfo(element: PsiElement): String {
        return when (element) {
            is ValkyrieClassDeclaration -> "class2 ${element.getName()}"
            is ValkyrieUnionDeclaration -> "union ${element.getName()}"
            is ValkyrieTraitDeclaration -> "trait ${element.getName()}"
            is ValkyrieNeuralDeclaration -> "neural ${element.getName()}"
            is ValkyrieWidgetDeclaration -> "widget ${element.getName()}"
            is ValkyrieSingletonDeclaration -> "singleton ${element.getName()}"
            is ValkyrieMethodDeclaration -> "method ${element.getName()}"
            is ValkyrieFieldDeclaration -> "field ${element.getName()}"
            is ValkyrieVariantDeclaration -> "variant ${element.getName()}"
            is ValkyrieLetStatementNode -> "let ${element.getName()}"
            else -> element.toString()
        }
    }
    
    /**
     * 简单的Markdown渲染
     */
    private fun renderMarkdown(content: String): String {
        return content
            .replace(Regex("\\*\\*(.*?)\\*\\*"), "<b>$1</b>")  // **bold**
            .replace(Regex("\\*(.*?)\\*"), "<i>$1</i>")        // *italic*
            .replace(Regex("`(.*?)`"), "<code>$1</code>")      // `code`
            .replace("\n", "<br>")
    }
    
    override fun getQuickNavigateInfo(element: PsiElement?, originalElement: PsiElement?): String? {
        if (element == null) return null
        
        return when (element) {
            is ValkyrieClassDeclaration -> "class1 ${element.name}"
            is ValkyrieUnionDeclaration -> "union ${element.name}"
            is ValkyrieTraitDeclaration -> "trait ${element.name}"
            is ValkyrieMethodDeclaration -> "method ${element.name}"
            is ValkyrieFieldDeclaration -> "field ${element.name}"
            else -> null
        }
    }
    
    /**
     * 查找元素关联的doc comment
     */
    private fun findDocComment(element: PsiElement): ValkyrieDocCommentNode? {
        // 向前查找doc comment
        var prev = PsiTreeUtil.getPrevSiblingOfType(element, PsiElement::class.java)
        
        while (prev != null) {
            when {
                prev is ValkyrieDocCommentNode -> return prev
                prev.node.elementType == WHITE_SPACE -> {
                    prev = PsiTreeUtil.getPrevSiblingOfType(prev, PsiElement::class.java)
                }
                else -> break
            }
        }
        
        return null
    }
    
    /**
     * 获取关键词文档
     */
    private fun getKeywordDocumentation(element: PsiElement): String? {
        val elementType = element.node?.elementType
        
        return when (elementType) {
            // 命名空间和导入
            ValkyrieTokenTypes.NAMESPACE -> {
                buildString {
                    append(DocumentationMarkup.DEFINITION_START)
                    append("<b>namespace</b> keyword")
                    append(DocumentationMarkup.DEFINITION_END)
                    append(DocumentationMarkup.CONTENT_START)
                    append("<p>定义命名空间，用于组织代码和避免命名冲突。</p>")
                    append("<p><b>语法:</b></p>")
                    append("<pre>namespace com.example.project</pre>")
                    append(DocumentationMarkup.CONTENT_END)
                }
            }
            ValkyrieTokenTypes.USING -> {
                buildString {
                    append(DocumentationMarkup.DEFINITION_START)
                    append("<b>using</b> keyword")
                    append(DocumentationMarkup.DEFINITION_END)
                    append(DocumentationMarkup.CONTENT_START)
                    append("<p>导入其他命名空间或模块的内容。</p>")
                    append("<p><b>语法:</b></p>")
                    append("<pre>using std.collections</pre>")
                    append("<pre>using std.io.{File, Path}</pre>")
                    append(DocumentationMarkup.CONTENT_END)
                }
            }
            
            // 变量声明
            ValkyrieTokenTypes.LET -> {
                buildString {
                    append(DocumentationMarkup.DEFINITION_START)
                    append("<b>let</b> keyword")
                    append(DocumentationMarkup.DEFINITION_END)
                    append(DocumentationMarkup.CONTENT_START)
                    append("<p>声明一个不可变变量。</p>")
                    append("<p><b>语法:</b></p>")
                    append("<pre>let name = value</pre>")
                    append("<pre>let name: Type = value</pre>")
                    append(DocumentationMarkup.CONTENT_END)
                }
            }
            
            // 控制流
            ValkyrieTokenTypes.IF -> {
                buildString {
                    append(DocumentationMarkup.DEFINITION_START)
                    append("<b>if</b> keyword")
                    append(DocumentationMarkup.DEFINITION_END)
                    append(DocumentationMarkup.CONTENT_START)
                    append("<p>条件语句，根据条件执行不同的代码分支。</p>")
                    append("<p><b>语法:</b></p>")
                    append("<pre>if condition { ... }</pre>")
                    append("<pre>if condition { ... } else { ... }</pre>")
                    append(DocumentationMarkup.CONTENT_END)
                }
            }
            ValkyrieTokenTypes.ELSE -> {
                buildString {
                    append(DocumentationMarkup.DEFINITION_START)
                    append("<b>else</b> keyword")
                    append(DocumentationMarkup.DEFINITION_END)
                    append(DocumentationMarkup.CONTENT_START)
                    append("<p>与if语句配合使用，定义条件不满足时的执行分支。</p>")
                    append("<p><b>语法:</b></p>")
                    append("<pre>if condition { ... } else { ... }</pre>")
                    append(DocumentationMarkup.CONTENT_END)
                }
            }
            ValkyrieTokenTypes.WHILE -> {
                buildString {
                    append(DocumentationMarkup.DEFINITION_START)
                    append("<b>while</b> keyword")
                    append(DocumentationMarkup.DEFINITION_END)
                    append(DocumentationMarkup.CONTENT_START)
                    append("<p>循环语句，当条件为真时重复执行代码块。</p>")
                    append("<p><b>语法:</b></p>")
                    append("<pre>while condition { ... }</pre>")
                    append(DocumentationMarkup.CONTENT_END)
                }
            }
            ValkyrieTokenTypes.UNTIL -> {
                buildString {
                    append(DocumentationMarkup.DEFINITION_START)
                    append("<b>until</b> keyword")
                    append(DocumentationMarkup.DEFINITION_END)
                    append(DocumentationMarkup.CONTENT_START)
                    append("<p>循环语句，当条件为假时重复执行代码块。</p>")
                    append("<p><b>语法:</b></p>")
                    append("<pre>until condition { ... }</pre>")
                    append(DocumentationMarkup.CONTENT_END)
                }
            }
            ValkyrieTokenTypes.LOOP -> {
                buildString {
                    append(DocumentationMarkup.DEFINITION_START)
                    append("<b>loop</b> keyword")
                    append(DocumentationMarkup.DEFINITION_END)
                    append(DocumentationMarkup.CONTENT_START)
                    append("<p>无限循环语句，需要使用break退出。</p>")
                    append("<p><b>语法:</b></p>")
                    append("<pre>loop { ... }</pre>")
                    append(DocumentationMarkup.CONTENT_END)
                }
            }
            ValkyrieTokenTypes.BREAK -> {
                buildString {
                    append(DocumentationMarkup.DEFINITION_START)
                    append("<b>break</b> keyword")
                    append(DocumentationMarkup.DEFINITION_END)
                    append(DocumentationMarkup.CONTENT_START)
                    append("<p>跳出当前循环。</p>")
                    append("<p><b>语法:</b></p>")
                    append("<pre>break</pre>")
                    append("<pre>break value</pre>")
                    append(DocumentationMarkup.CONTENT_END)
                }
            }
            ValkyrieTokenTypes.CONTINUE -> {
                buildString {
                    append(DocumentationMarkup.DEFINITION_START)
                    append("<b>continue</b> keyword")
                    append(DocumentationMarkup.DEFINITION_END)
                    append(DocumentationMarkup.CONTENT_START)
                    append("<p>跳过当前循环迭代，继续下一次迭代。</p>")
                    append("<p><b>语法:</b></p>")
                    append("<pre>continue</pre>")
                    append(DocumentationMarkup.CONTENT_END)
                }
            }
            ValkyrieTokenTypes.RETURN -> {
                buildString {
                    append(DocumentationMarkup.DEFINITION_START)
                    append("<b>return</b> keyword")
                    append(DocumentationMarkup.DEFINITION_END)
                    append(DocumentationMarkup.CONTENT_START)
                    append("<p>从函数中返回值。</p>")
                    append("<p><b>语法:</b></p>")
                    append("<pre>return</pre>")
                    append("<pre>return value</pre>")
                    append(DocumentationMarkup.CONTENT_END)
                }
            }
            
            // 函数定义
            ValkyrieTokenTypes.MICRO -> {
                buildString {
                    append(DocumentationMarkup.DEFINITION_START)
                    append("<b>micro</b> keyword")
                    append(DocumentationMarkup.DEFINITION_END)
                    append(DocumentationMarkup.CONTENT_START)
                    append("<p>定义一个微函数（小型函数）。</p>")
                    append("<p><b>语法:</b></p>")
                    append("<pre>micro name(params) -> ReturnType { ... }</pre>")
                    append(DocumentationMarkup.CONTENT_END)
                }
            }
            ValkyrieTokenTypes.MEZZO -> {
                buildString {
                    append(DocumentationMarkup.DEFINITION_START)
                    append("<b>mezzo</b> keyword")
                    append(DocumentationMarkup.DEFINITION_END)
                    append(DocumentationMarkup.CONTENT_START)
                    append("<p>定义一个中型函数。</p>")
                    append("<p><b>语法:</b></p>")
                    append("<pre>mezzo name(params) -> ReturnType { ... }</pre>")
                    append(DocumentationMarkup.CONTENT_END)
                }
            }
            ValkyrieTokenTypes.MACRO -> {
                buildString {
                    append(DocumentationMarkup.DEFINITION_START)
                    append("<b>macro</b> keyword")
                    append(DocumentationMarkup.DEFINITION_END)
                    append(DocumentationMarkup.CONTENT_START)
                    append("<p>定义一个宏函数（大型函数）。</p>")
                    append("<p><b>语法:</b></p>")
                    append("<pre>macro name(params) -> ReturnType { ... }</pre>")
                    append(DocumentationMarkup.CONTENT_END)
                }
            }
            
            // 类型定义
            ValkyrieTokenTypes.CLASS -> {
                buildString {
                    append(DocumentationMarkup.DEFINITION_START)
                    append("<b>class</b> keyword")
                    append(DocumentationMarkup.DEFINITION_END)
                    append(DocumentationMarkup.CONTENT_START)
                    append("<p>定义一个类。</p>")
                    append("<p><b>语法:</b></p>")
                    append("<pre>class Name { ... }</pre>")
                    append("<pre>class Name&lt;T&gt; { ... }</pre>")
                    append(DocumentationMarkup.CONTENT_END)
                }
            }
            ValkyrieTokenTypes.NEURAL -> {
                buildString {
                    append(DocumentationMarkup.DEFINITION_START)
                    append("<b>neural</b> keyword")
                    append(DocumentationMarkup.DEFINITION_END)
                    append(DocumentationMarkup.CONTENT_START)
                    append("<p>定义一个神经网络类型。</p>")
                    append("<p><b>语法:</b></p>")
                    append("<pre>neural Name { ... }</pre>")
                    append(DocumentationMarkup.CONTENT_END)
                }
            }
            ValkyrieTokenTypes.WIDGET -> {
                buildString {
                    append(DocumentationMarkup.DEFINITION_START)
                    append("<b>widget</b> keyword")
                    append(DocumentationMarkup.DEFINITION_END)
                    append(DocumentationMarkup.CONTENT_START)
                    append("<p>定义一个UI组件。</p>")
                    append("<p><b>语法:</b></p>")
                    append("<pre>widget Name { ... }</pre>")
                    append(DocumentationMarkup.CONTENT_END)
                }
            }
            ValkyrieTokenTypes.UNION -> {
                buildString {
                    append(DocumentationMarkup.DEFINITION_START)
                    append("<b>union</b> keyword")
                    append(DocumentationMarkup.DEFINITION_END)
                    append(DocumentationMarkup.CONTENT_START)
                    append("<p>定义一个联合类型（枚举）。</p>")
                    append("<p><b>语法:</b></p>")
                    append("<pre>union Name { Variant1, Variant2 }</pre>")
                    append(DocumentationMarkup.CONTENT_END)
                }
            }
            ValkyrieTokenTypes.UNITY -> {
                buildString {
                    append(DocumentationMarkup.DEFINITION_START)
                    append("<b>unity</b> keyword")
                    append(DocumentationMarkup.DEFINITION_END)
                    append(DocumentationMarkup.CONTENT_START)
                    append("<p>定义一个统一类型。</p>")
                    append("<p><b>语法:</b></p>")
                    append("<pre>unity Name { ... }</pre>")
                    append(DocumentationMarkup.CONTENT_END)
                }
            }
            ValkyrieTokenTypes.FLAGS -> {
                buildString {
                    append(DocumentationMarkup.DEFINITION_START)
                    append("<b>flags</b> keyword")
                    append(DocumentationMarkup.DEFINITION_END)
                    append(DocumentationMarkup.CONTENT_START)
                    append("<p>定义一个标志类型（位标志）。</p>")
                    append("<p><b>语法:</b></p>")
                    append("<pre>flags Name { Flag1, Flag2 }</pre>")
                    append(DocumentationMarkup.CONTENT_END)
                }
            }
            ValkyrieTokenTypes.TRAIT -> {
                buildString {
                    append(DocumentationMarkup.DEFINITION_START)
                    append("<b>trait</b> keyword")
                    append(DocumentationMarkup.DEFINITION_END)
                    append(DocumentationMarkup.CONTENT_START)
                    append("<p>定义一个特征（接口）。</p>")
                    append("<p><b>语法:</b></p>")
                    append("<pre>trait Name { ... }</pre>")
                    append(DocumentationMarkup.CONTENT_END)
                }
            }
            ValkyrieTokenTypes.IMPLY -> {
                buildString {
                    append(DocumentationMarkup.DEFINITION_START)
                    append("<b>imply</b> keyword")
                    append(DocumentationMarkup.DEFINITION_END)
                    append(DocumentationMarkup.CONTENT_START)
                    append("<p>为类型实现特征。</p>")
                    append("<p><b>语法:</b></p>")
                    append("<pre>imply TraitName for TypeName { ... }</pre>")
                    append(DocumentationMarkup.CONTENT_END)
                }
            }
            ValkyrieTokenTypes.STRUCTURE -> {
                buildString {
                    append(DocumentationMarkup.DEFINITION_START)
                    append("<b>structure</b> keyword")
                    append(DocumentationMarkup.DEFINITION_END)
                    append(DocumentationMarkup.CONTENT_START)
                    append("<p>定义一个结构体。</p>")
                    append("<p><b>语法:</b></p>")
                    append("<pre>structure Name { field1: Type1, field2: Type2 }</pre>")
                    append(DocumentationMarkup.CONTENT_END)
                }
            }
            ValkyrieTokenTypes.SINGLETON -> {
                buildString {
                    append(DocumentationMarkup.DEFINITION_START)
                    append("<b>singleton</b> keyword")
                    append(DocumentationMarkup.DEFINITION_END)
                    append(DocumentationMarkup.CONTENT_START)
                    append("<p>定义一个单例类型。</p>")
                    append("<p><b>语法:</b></p>")
                    append("<pre>singleton Name { ... }</pre>")
                    append(DocumentationMarkup.CONTENT_END)
                }
            }
            
            // 模式匹配
            ValkyrieTokenTypes.MATCH -> {
                buildString {
                    append(DocumentationMarkup.DEFINITION_START)
                    append("<b>match</b> keyword")
                    append(DocumentationMarkup.DEFINITION_END)
                    append(DocumentationMarkup.CONTENT_START)
                    append("<p>模式匹配语句。</p>")
                    append("<p><b>语法:</b></p>")
                    append("<pre>match value { pattern1 => result1, pattern2 => result2 }</pre>")
                    append(DocumentationMarkup.CONTENT_END)
                }
            }
            ValkyrieTokenTypes.CASE -> {
                buildString {
                    append(DocumentationMarkup.DEFINITION_START)
                    append("<b>case</b> keyword")
                    append(DocumentationMarkup.DEFINITION_END)
                    append(DocumentationMarkup.CONTENT_START)
                    append("<p>在match语句中定义匹配分支。</p>")
                    append("<p><b>语法:</b></p>")
                    append("<pre>case pattern => result</pre>")
                    append(DocumentationMarkup.CONTENT_END)
                }
            }
            ValkyrieTokenTypes.WHEN -> {
                buildString {
                    append(DocumentationMarkup.DEFINITION_START)
                    append("<b>when</b> keyword")
                    append(DocumentationMarkup.DEFINITION_END)
                    append(DocumentationMarkup.CONTENT_START)
                    append("<p>条件匹配语句。</p>")
                    append("<p><b>语法:</b></p>")
                    append("<pre>when condition { ... }</pre>")
                    append(DocumentationMarkup.CONTENT_END)
                }
            }
            
            // 异常处理
            ValkyrieTokenTypes.TRY -> {
                buildString {
                    append(DocumentationMarkup.DEFINITION_START)
                    append("<b>try</b> keyword")
                    append(DocumentationMarkup.DEFINITION_END)
                    append(DocumentationMarkup.CONTENT_START)
                    append("<p>异常处理语句。</p>")
                    append("<p><b>语法:</b></p>")
                    append("<pre>try { ... } catch { ... }</pre>")
                    append(DocumentationMarkup.CONTENT_END)
                }
            }
            ValkyrieTokenTypes.CATCH -> {
                buildString {
                    append(DocumentationMarkup.DEFINITION_START)
                    append("<b>catch</b> keyword")
                    append(DocumentationMarkup.DEFINITION_END)
                    append(DocumentationMarkup.CONTENT_START)
                    append("<p>捕获异常。</p>")
                    append("<p><b>语法:</b></p>")
                    append("<pre>catch ExceptionType { ... }</pre>")
                    append(DocumentationMarkup.CONTENT_END)
                }
            }
            ValkyrieTokenTypes.RAISE -> {
                buildString {
                    append(DocumentationMarkup.DEFINITION_START)
                    append("<b>raise</b> keyword")
                    append(DocumentationMarkup.DEFINITION_END)
                    append(DocumentationMarkup.CONTENT_START)
                    append("<p>抛出异常。</p>")
                    append("<p><b>语法:</b></p>")
                    append("<pre>raise exception</pre>")
                    append(DocumentationMarkup.CONTENT_END)
                }
            }
            
            // 作用域和生成器
            ValkyrieTokenTypes.SCOPE -> {
                buildString {
                    append(DocumentationMarkup.DEFINITION_START)
                    append("<b>scope</b> keyword")
                    append(DocumentationMarkup.DEFINITION_END)
                    append(DocumentationMarkup.CONTENT_START)
                    append("<p>定义一个作用域块，用于限制变量的生命周期和可见性。</p>")
                    append("<p><b>语法:</b></p>")
                    append("<pre>scope { ... }</pre>")
                    append("<pre>scope&lt;T&gt; { ... }</pre>")
                    append(DocumentationMarkup.CONTENT_END)
                }
            }
            ValkyrieTokenTypes.YIELD -> {
                buildString {
                    append(DocumentationMarkup.DEFINITION_START)
                    append("<b>yield</b> keyword")
                    append(DocumentationMarkup.DEFINITION_END)
                    append(DocumentationMarkup.CONTENT_START)
                    append("<p>在生成器中产生一个值。</p>")
                    append("<p><b>语法:</b></p>")
                    append("<pre>yield value</pre>")
                    append(DocumentationMarkup.CONTENT_END)
                }
            }
            ValkyrieTokenTypes.RESUME -> {
                buildString {
                    append(DocumentationMarkup.DEFINITION_START)
                    append("<b>resume</b> keyword")
                    append(DocumentationMarkup.DEFINITION_END)
                    append(DocumentationMarkup.CONTENT_START)
                    append("<p>恢复生成器的执行。</p>")
                    append("<p><b>语法:</b></p>")
                    append("<pre>resume generator</pre>")
                    append(DocumentationMarkup.CONTENT_END)
                }
            }
            
            // 运算符
            ValkyrieTokenTypes.IN -> {
                buildString {
                    append(DocumentationMarkup.DEFINITION_START)
                    append("<b>in</b> operator")
                    append(DocumentationMarkup.DEFINITION_END)
                    append(DocumentationMarkup.CONTENT_START)
                    append("<p>检查元素是否在集合中。</p>")
                    append("<p><b>语法:</b></p>")
                    append("<pre>element in collection</pre>")
                    append(DocumentationMarkup.CONTENT_END)
                }
            }
            ValkyrieTokenTypes.IS -> {
                buildString {
                    append(DocumentationMarkup.DEFINITION_START)
                    append("<b>is</b> operator")
                    append(DocumentationMarkup.DEFINITION_END)
                    append(DocumentationMarkup.CONTENT_START)
                    append("<p>类型检查运算符。</p>")
                    append("<p><b>语法:</b></p>")
                    append("<pre>value is Type</pre>")
                    append(DocumentationMarkup.CONTENT_END)
                }
            }
            ValkyrieTokenTypes.AS -> {
                buildString {
                    append(DocumentationMarkup.DEFINITION_START)
                    append("<b>as</b> operator")
                    append(DocumentationMarkup.DEFINITION_END)
                    append(DocumentationMarkup.CONTENT_START)
                    append("<p>类型转换运算符。</p>")
                    append("<p><b>语法:</b></p>")
                    append("<pre>value as Type</pre>")
                    append(DocumentationMarkup.CONTENT_END)
                }
            }
            
            // 测试
            ValkyrieTokenTypes.TESTS -> {
                buildString {
                    append(DocumentationMarkup.DEFINITION_START)
                    append("<b>tests</b> keyword")
                    append(DocumentationMarkup.DEFINITION_END)
                    append(DocumentationMarkup.CONTENT_START)
                    append("<p>定义测试模块。</p>")
                    append("<p><b>语法:</b></p>")
                    append("<pre>tests { ... }</pre>")
                    append(DocumentationMarkup.CONTENT_END)
                }
            }
            
            else -> null
        }
    }
    
    /**
     * 获取类型描述
     */
    private fun getTypeDescription(typeName: String): String {
        return when (typeName) {
            "class" -> "类定义，用于创建具有字段和方法的对象类型"
            "union" -> "联合类型，表示多种可能的值类型之一"
            "trait" -> "特征定义，描述类型必须实现的行为接口"
            "neural" -> "神经网络类型，用于机器学习模型定义"
            "widget" -> "UI组件类型，用于用户界面元素"
            "singleton" -> "单例类型，全局唯一实例的类型"
            else -> "用户定义类型"
        }
    }
    
    /**
     * 从let语句提取类型信息
     */
    private fun extractTypeFromLetStatement(element: ValkyrieLetStatementNode): String? {
        // 尝试从类型注解获取
        val typeAnnotation = element.children.find { it.text.contains(":") }
        if (typeAnnotation != null) {
            val parts = typeAnnotation.text.split(":")
            if (parts.size > 1) {
                return parts[1].trim()
            }
        }
        
        // 尝试从初始化表达式推断类型
        val initExpression = element.children.find { it.text.contains("=") }
        if (initExpression != null) {
            return inferTypeFromExpression(initExpression.text)
        }
        
        return null
    }
    
    /**
     * 从表达式推断类型
     */
    private fun inferTypeFromExpression(expression: String): String? {
        val trimmed = expression.substringAfter("=").trim()
        return when {
            trimmed.startsWith('"') && trimmed.endsWith('"') -> "String"
            trimmed.startsWith('\'') && trimmed.endsWith('\'') -> "Char"
            trimmed.matches(Regex("\\d+")) -> "i32"
            trimmed.matches(Regex("\\d+\\.\\d+")) -> "f64"
            trimmed == "true" || trimmed == "false" -> "bool"
            trimmed.startsWith("[") && trimmed.endsWith("]") -> "Array"
            else -> null
        }
    }
    
    /**
     * 构建函数签名
     */
    private fun buildFunctionSignature(element: ValkyrieMethodDeclaration): String {
        val name = element.name ?: "unknown"
        val params = extractFunctionParameters(element)
        val returnType = extractReturnType(element)
        
        return buildString {
            append(name)
            append("(")
            append(params.joinToString(", "))
            append(")")
            if (returnType != null) {
                append(" -> ")
                append(returnType)
            }
        }
    }
    
    /**
     * 提取函数参数
     */
    private fun extractFunctionParameters(element: ValkyrieMethodDeclaration): List<String> {
        // 简化实现，实际应该解析PSI树
        return emptyList()
    }
    
    /**
     * 提取返回类型
     */
    private fun extractReturnType(element: ValkyrieMethodDeclaration): String? {
        // 简化实现，实际应该解析PSI树
        return null
    }
    
    /**
     * 查找标识符定义
     */
    private fun findIdentifierDefinition(element: ValkyrieIdentifierNode, name: String): PsiElement? {
        // 简化实现，实际应该使用引用解析
        return null
    }

}