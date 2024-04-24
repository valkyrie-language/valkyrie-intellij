package valkyrie.project.modules

import com.intellij.diagnostic.ActivityCategory
import com.intellij.ide.plugins.IdeaPluginDescriptor
import com.intellij.ide.plugins.IdeaPluginDescriptorImpl
import com.intellij.openapi.application.Application
import com.intellij.openapi.client.ClientKind
import com.intellij.openapi.extensions.ExtensionsArea
import com.intellij.openapi.extensions.PluginDescriptor
import com.intellij.openapi.extensions.PluginId
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Condition
import com.intellij.openapi.util.Key
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.platform.workspace.jps.entities.ModuleId
import com.intellij.platform.workspace.storage.MutableEntityStorage
import com.intellij.platform.workspace.storage.VersionedEntityStorage
import com.intellij.platform.workspace.storage.url.VirtualFileUrl
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.serviceContainer.PrecomputedExtensionModel
import com.intellij.util.messages.MessageBus
import com.intellij.workspaceModel.ide.legacyBridge.ModuleBridge
import java.nio.file.Path

class ValkyrieModule(val _project: Project) : ModuleBridge {
    override var diff: MutableEntityStorage?
        get() = TODO("Not yet implemented")
        set(value) {}
    override var entityStorage: VersionedEntityStorage
        get() = TODO("Not yet implemented")
        set(value) {}
    override val moduleEntityId: ModuleId
        get() = TODO("Not yet implemented")

    override fun callCreateComponents() {
        TODO("Not yet implemented")
    }

    override suspend fun callCreateComponentsNonBlocking() {
        TODO("Not yet implemented")
    }

    override fun clearScopesCache() {
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

    override fun dispose() {
        TODO("Not yet implemented")
    }

    override fun getActivityCategory(isExtension: Boolean): ActivityCategory {
        TODO("Not yet implemented")
    }

    override fun hasComponent(interfaceClass: Class<*>): Boolean {
        return false
    }

    override fun <T : Any?> getComponent(interfaceClass: Class<T>): T? {
        return null
    }


    override fun getDeprecatedModuleLevelMessageBus(): MessageBus {
        TODO("Not yet implemented")
    }

    override fun getDisposed(): Condition<*> {
        TODO("Not yet implemented")
    }

    override fun getExtensionArea(): ExtensionsArea {
        TODO("Not yet implemented")
    }

    override fun getMessageBus(): MessageBus {
        TODO("Not yet implemented")
    }

    override fun getModuleContentScope(): GlobalSearchScope {
        TODO("Not yet implemented")
    }

    override fun getModuleContentWithDependenciesScope(): GlobalSearchScope {
        TODO("Not yet implemented")
    }

    override fun getModuleFile(): VirtualFile? {
        TODO("Not yet implemented")
    }

    override fun getModuleNioFile(): Path {
        TODO("Not yet implemented")
    }

    override fun getModuleRuntimeScope(includeTests: Boolean): GlobalSearchScope {
        TODO("Not yet implemented")
    }

    override fun getModuleScope(): GlobalSearchScope {
        TODO("Not yet implemented")
    }

    override fun getModuleScope(includeTests: Boolean): GlobalSearchScope {
        TODO("Not yet implemented")
    }

    override fun getModuleTestsWithDependentsScope(): GlobalSearchScope {
        TODO("Not yet implemented")
    }

    override fun getModuleWithDependenciesAndLibrariesScope(includeTests: Boolean): GlobalSearchScope {
        TODO("Not yet implemented")
    }

    override fun getModuleWithDependenciesScope(): GlobalSearchScope {
        TODO("Not yet implemented")
    }

    override fun getModuleWithDependentsScope(): GlobalSearchScope {
        TODO("Not yet implemented")
    }

    override fun getModuleWithLibrariesScope(): GlobalSearchScope {
        TODO("Not yet implemented")
    }

    override fun getName(): String {
        return "ValkyrieModule"
    }

    override fun getOptionValue(key: String): String? {
        TODO("Not yet implemented")
    }

    override fun getProject(): Project {
        return _project
    }

    override fun <T : Any?> getService(serviceClass: Class<T>): T {
        TODO("Not yet implemented")
    }

    override fun <T : Any?> getUserData(key: Key<T>): T? {
        TODO("Not yet implemented")
    }


    override fun initFacets() {
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

    override fun isDisposed(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isInjectionForExtensionSupported(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isLoaded(): Boolean {
        TODO("Not yet implemented")
    }

    override fun <T : Any?> loadClass(className: String, pluginDescriptor: PluginDescriptor): Class<T> {
        TODO("Not yet implemented")
    }

    override fun onImlFileMoved(newModuleFileUrl: VirtualFileUrl) {
        TODO("Not yet implemented")
    }

    override fun <T : Any?> putUserData(key: Key<T>, value: T?) {
        TODO("Not yet implemented")
    }

    override fun registerComponents(
        corePlugin: IdeaPluginDescriptor?,
        modules: List<IdeaPluginDescriptorImpl>,
        precomputedExtensionModel: PrecomputedExtensionModel?,
        app: Application?,
        listenerCallbacks: MutableList<in Runnable>?,
    ) {
        TODO("Not yet implemented")
    }

    override fun rename(newName: String, newModuleFileUrl: VirtualFileUrl?, notifyStorage: Boolean) {
        TODO("Not yet implemented")
    }

    override fun setOption(key: String, value: String?) {
        TODO("Not yet implemented")
    }

    override fun getModuleTypeName(): String? {
        return super.getModuleTypeName()
    }

    override fun getModuleProductionSourceScope(): GlobalSearchScope {
        return super.getModuleProductionSourceScope()
    }

    override fun getModuleTestSourceScope(): GlobalSearchScope {
        return super.getModuleTestSourceScope()
    }

    override fun getModuleFilePath(): String {
        return super.getModuleFilePath()
    }

    override fun <T : Any?> getServices(serviceClass: Class<T>, client: ClientKind?): MutableList<T> {
        return super.getServices(serviceClass, client)
    }

    override fun <T : Any?> getServiceIfCreated(serviceClass: Class<T>): T? {
        return super.getServiceIfCreated(serviceClass)
    }
}