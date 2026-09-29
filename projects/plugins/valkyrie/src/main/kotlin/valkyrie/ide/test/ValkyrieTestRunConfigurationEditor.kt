package valkyrie.ide.test

import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.ui.TextFieldWithBrowseButton
import com.intellij.ui.components.JBLabel
import com.intellij.ui.components.JBTextField
import com.intellij.util.ui.FormBuilder
import javax.swing.JComponent
import javax.swing.JPanel

/**
 * Valkyrie 测试运行配置编辑器
 */
class ValkyrieTestRunConfigurationEditor : SettingsEditor<ValkyrieTestRunConfiguration>() {
    
    private val testFilePathField = TextFieldWithBrowseButton().apply {
        addBrowseFolderListener(
            "Select Test File",
            "Choose the Valkyrie test file to run",
            null,
            FileChooserDescriptorFactory.createSingleFileDescriptor("vk")
        )
    }
    
    private val testNameField = JBTextField()
    
    override fun createEditor(): JComponent {
        return FormBuilder.createFormBuilder()
            .addLabeledComponent(JBLabel("Test file:"), testFilePathField, 1, false)
            .addLabeledComponent(JBLabel("Test name:"), testNameField, 1, false)
            .addComponentFillVertically(JPanel(), 0)
            .panel
    }
    
    override fun resetEditorFrom(configuration: ValkyrieTestRunConfiguration) {
        testFilePathField.text = configuration.getOptions().testFilePath
        testNameField.text = configuration.getOptions().testName
    }
    
    override fun applyEditorTo(configuration: ValkyrieTestRunConfiguration) {
        configuration.getOptions().testFilePath = testFilePathField.text
        configuration.getOptions().testName = testNameField.text
    }
}