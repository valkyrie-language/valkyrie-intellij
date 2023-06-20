package valkyrie.project

import com.intellij.openapi.roots.ModuleExtension

class moduleExtension : ModuleExtension() {
    override fun getModifiableModel(writable: Boolean): ModuleExtension {
        return this
    }

    override fun commit() {

    }

    override fun isChanged(): Boolean {
        return false
    }
}
