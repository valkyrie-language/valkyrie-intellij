package valkyrie.ide.folding

import com.intellij.application.options.editor.CodeFoldingOptionsProvider
import com.intellij.openapi.options.BeanConfigurable

/**
 * Valkyrie 代码折叠选项提供者
 */
class ValkyrieFoldingOptions : BeanConfigurable<ValkyrieFoldingSettings>(ValkyrieFoldingSettings(), "Valkyrie") {
    
    init {
        val settings = ValkyrieFoldingSettings()
        
        checkBox("Union bodies", settings::foldUnionBodies)
        checkBox("Class bodies", settings::foldClassBodies)
        checkBox("Trait bodies", settings::foldTraitBodies)
        checkBox("Domain bodies", settings::foldDomainBodies)
        checkBox("Method bodies", settings::foldMethodBodies)
        checkBox("Block statements", settings::foldBlockStatements)
        checkBox("Import statements", settings::foldImports)
        checkBox("Documentation comments", settings::foldDocComments)
    }
}

/**
 * Valkyrie 折叠设置
 */
class ValkyrieFoldingSettings {
    var foldUnionBodies: Boolean = false
    var foldClassBodies: Boolean = false
    var foldTraitBodies: Boolean = false
    var foldDomainBodies: Boolean = false
    var foldMethodBodies: Boolean = false
    var foldBlockStatements: Boolean = false
    var foldImports: Boolean = true
    var foldDocComments: Boolean = false
}