package valkyrie.ide.runner

import com.intellij.execution.Executor
import com.intellij.execution.configuration.PersistentAwareRunConfiguration
import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.RunConfiguration
import com.intellij.execution.configurations.RunProfileState
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.project.Project
import com.intellij.ui.dsl.builder.panel
import org.jdom.Element
import valkyrie.language.file.ValkyrieIconProvider
import javax.swing.Icon

