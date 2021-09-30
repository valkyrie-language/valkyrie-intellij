package valkyrie.ide.lint

import com.intellij.lang.refactoring.NamesValidator
import com.intellij.openapi.project.Project
import com.intellij.psi.impl.cache.impl.todo.TodoIndexers

class ValkyrieNameValidator : NamesValidator {
    override fun isKeyword(name: String, project: Project?): Boolean {
        return true
    }

    override fun isIdentifier(name: String, project: Project?): Boolean {
        return true
    }
}
