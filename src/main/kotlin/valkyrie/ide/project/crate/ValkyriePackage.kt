package valkyrie.ide.project.crate

import com.intellij.diagnostic.ActivityCategory
import com.intellij.openapi.extensions.ExtensionsArea
import com.intellij.openapi.extensions.PluginDescriptor
import com.intellij.openapi.extensions.PluginId
import com.intellij.openapi.module.Module
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Condition
import com.intellij.openapi.util.Key
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.util.messages.MessageBus
import org.picocontainer.PicoContainer
import java.nio.file.Path

class ValkyriePackage(project: Project) : Module {
    private val myProject: Project;

    init {
        this.myProject = project
    }

    override fun <T : Any?> getUserData(key: Key<T>): T? {
        TODO("Not yet implemented")
    }

    override fun <T : Any?> putUserData(key: Key<T>, value: T?) {
        TODO("Not yet implemented")
    }

    override fun dispose() {
        TODO("Not yet implemented")
    }

    override fun getExtensionArea(): ExtensionsArea {
        TODO("Not yet implemented")
    }

    override fun <T : Any?> getComponent(interfaceClass: Class<T>): T {
        TODO("Not yet implemented")
    }

    override fun hasComponent(interfaceClass: Class<*>): Boolean {
        TODO("Not yet implemented")
    }

    override fun getPicoContainer(): PicoContainer {
        TODO("Not yet implemented")
    }

    override fun isInjectionForExtensionSupported(): Boolean {
        TODO("Not yet implemented")
    }

    override fun getMessageBus(): MessageBus {
        TODO("Not yet implemented")
    }

    override fun isDisposed(): Boolean {
        TODO("Not yet implemented")
    }

    override fun getDisposed(): Condition<*> {
        TODO("Not yet implemented")
    }

    override fun <T : Any?> getService(serviceClass: Class<T>): T {
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
        TODO("Not yet implemented")
    }

    override fun getModuleNioFile(): Path {
        TODO("Not yet implemented")
    }

    override fun getProject(): Project {
        return myProject
    }

    override fun getName(): String {
        TODO("Not yet implemented")
    }

    override fun isLoaded(): Boolean {
        TODO("Not yet implemented")
    }

    override fun setOption(key: String, value: String?) {
        TODO("Not yet implemented")
    }

    override fun getOptionValue(key: String): String? {
        TODO("Not yet implemented")
    }

    override fun getModuleScope(): GlobalSearchScope {
        TODO("Not yet implemented")
    }

    override fun getModuleScope(includeTests: Boolean): GlobalSearchScope {
        TODO("Not yet implemented")
    }

    override fun getModuleWithLibrariesScope(): GlobalSearchScope {
        TODO("Not yet implemented")
    }

    override fun getModuleWithDependenciesScope(): GlobalSearchScope {
        TODO("Not yet implemented")
    }

    override fun getModuleContentScope(): GlobalSearchScope {
        TODO("Not yet implemented")
    }

    override fun getModuleContentWithDependenciesScope(): GlobalSearchScope {
        TODO("Not yet implemented")
    }

    override fun getModuleWithDependenciesAndLibrariesScope(includeTests: Boolean): GlobalSearchScope {
        TODO("Not yet implemented")
    }

    override fun getModuleWithDependentsScope(): GlobalSearchScope {
        TODO("Not yet implemented")
    }

    override fun getModuleTestsWithDependentsScope(): GlobalSearchScope {
        TODO("Not yet implemented")
    }

    override fun getModuleRuntimeScope(includeTests: Boolean): GlobalSearchScope {
        TODO("Not yet implemented")
    }
}