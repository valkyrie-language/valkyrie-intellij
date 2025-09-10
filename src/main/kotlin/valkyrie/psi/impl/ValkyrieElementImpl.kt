package valkyrie.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import valkyrie.psi.ValkyrieElement

/**
 * Valkyrie PSI 元素基础实现
 */
open class ValkyrieElementImpl(node: ASTNode) : ASTWrapperPsiElement(node), ValkyrieElement