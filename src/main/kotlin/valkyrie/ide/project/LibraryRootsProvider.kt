package valkyrie.ide.project

import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.AdditionalLibraryRootsProvider
import com.intellij.openapi.roots.SyntheticLibrary
import com.intellij.openapi.vfs.VirtualFile

class LibraryRootsProvider : AdditionalLibraryRootsProvider() {
    var dependences = mutableListOf<ValkyrieDependenceLibrary>()
    override fun getAdditionalProjectLibraries(project: Project): MutableCollection<SyntheticLibrary> {
        println(project.basePath)
        // TODO: std must at top
        dependences.clear()
        var std = ValkyrieDependenceLibrary("std");
        std.version = "0.0.1";
        dependences.add(std);
        dependences.add(ValkyrieDependenceLibrary("core"));
        dependences.add(ValkyrieDependenceLibrary("io"));
        dependences.add(ValkyrieDependenceLibrary("math"));
        dependences.add(ValkyrieDependenceLibrary("net"));
        return dependences.toMutableList();
    }

    override fun getRootsToWatch(project: Project): MutableCollection<VirtualFile> {
        return dependences.filter { it.path != null }.map { it.path!! }.toMutableList();
    }
}

