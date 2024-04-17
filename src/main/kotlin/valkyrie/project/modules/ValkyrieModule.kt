package valkyrie.project.modules

import com.intellij.diagnostic.ActivityCategory
import com.intellij.openapi.extensions.ExtensionsArea
import com.intellij.openapi.extensions.PluginDescriptor
import com.intellij.openapi.extensions.PluginId
import com.intellij.openapi.module.impl.ModuleEx
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Condition
import com.intellij.openapi.util.Key
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.util.messages.MessageBus
import valkyrie.ide.view.scope.ValkyrieProjectScope
import java.nio.file.Path

class ValkyrieModule(val _project: Project) : ModuleEx {
    override fun <T : Any?> getUserData(key: Key<T>): T? {
        return null
    }

    override fun <T : Any?> putUserData(key: Key<T>, value: T?) {

    }

    override fun dispose() {

    }


    override fun getExtensionArea(): ExtensionsArea {
        TODO("Not yet implemented")
    }

    override fun <T : Any?> getComponent(interfaceClass: Class<T>): T {
        TODO("Not yet implemented")
    }

    override fun hasComponent(interfaceClass: Class<*>): Boolean {
        return false
    }

    override fun isInjectionForExtensionSupported(): Boolean {
        return false
    }

    override fun getMessageBus(): MessageBus {
        TODO("Not yet implemented")
    }

    override fun isDisposed(): Boolean {
        return false
    }

    override fun getDisposed(): Condition<*> {
        TODO("Not yet implemented")
    }

    override fun <T : Any?> getService(serviceClass: Class<T>): T {
        TODO("Not yet implemented")
    }

    override fun <T : Any?> instantiateClass(aClass: Class<T>, pluginId: PluginId): T {
        TODO("Not yet implemented")
    }

    override fun <T : Any?> instantiateClass(className: String, pluginDescriptor: PluginDescriptor): T & Any {
        TODO("Not yet implemented")
    }

    override fun <T : Any?> instantiateClassWithConstructorInjection(aClass: Class<T>, key: Any, pluginId: PluginId): T {
        TODO("Not yet implemented")
    }

    override fun createError(error: Throwable, pluginId: PluginId): RuntimeException {
        TODO("Not yet implemented")
    }

    override fun createError(message: String, pluginId: PluginId): RuntimeException {
        TODO("Not yet implemented")
    }

    override fun createError(
        message: String,
        error: Throwable?,
        pluginId: PluginId,
        attachments: MutableMap<String, String>?,
    ): RuntimeException {
        TODO("Not yet implemented")
    }

    override fun <T : Any?> loadClass(className: String, pluginDescriptor: PluginDescriptor): Class<T> {
        TODO("Not yet implemented")
    }

    override fun getActivityCategory(isExtension: Boolean): ActivityCategory {
        TODO("Not yet implemented")
    }

    override fun getModuleFile(): VirtualFile? {
        return null
    }

    override fun getModuleNioFile(): Path {
        TODO("Not yet implemented")
    }

    override fun getProject(): Project {
        return _project
    }

    override fun getName(): String {
        return "getName"
    }

    override fun isLoaded(): Boolean {
        return true
    }

    override fun setOption(key: String, value: String?) {

    }

    override fun getOptionValue(key: String): String? {
        return "getOptionValue 232"
    }

    override fun getModuleScope(): GlobalSearchScope {
        return ValkyrieProjectScope(_project)
    }

    override fun getModuleScope(includeTests: Boolean): GlobalSearchScope {
        return ValkyrieProjectScope(_project)
    }

    override fun getModuleWithLibrariesScope(): GlobalSearchScope {
        return ValkyrieProjectScope(_project)
    }

    override fun getModuleWithDependenciesScope(): GlobalSearchScope {
        return ValkyrieProjectScope(_project)
    }

    override fun getModuleContentScope(): GlobalSearchScope {
        return ValkyrieProjectScope(_project)
    }

    override fun getModuleContentWithDependenciesScope(): GlobalSearchScope {
        return ValkyrieProjectScope(_project)
    }

    override fun getModuleWithDependenciesAndLibrariesScope(includeTests: Boolean): GlobalSearchScope {
        return ValkyrieProjectScope(_project)
    }

    override fun getModuleWithDependentsScope(): GlobalSearchScope {
        return ValkyrieProjectScope(_project)
    }

    override fun getModuleTestsWithDependentsScope(): GlobalSearchScope {
        TODO("Not yet implemented")
    }

    override fun getModuleRuntimeScope(includeTests: Boolean): GlobalSearchScope {
        TODO("Not yet implemented")
    }

    override fun clearScopesCache() {
        TODO("Not yet implemented")
    }

    override fun getDeprecatedModuleLevelMessageBus(): MessageBus {
        TODO("Not yet implemented")
    }

}