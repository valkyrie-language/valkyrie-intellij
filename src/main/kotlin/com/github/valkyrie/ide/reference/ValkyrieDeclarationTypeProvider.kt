package com.github.valkyrie.ide.reference

import com.github.valkyrie.language.psi.ValkyrieClassStatement
import com.github.valkyrie.language.psi_node.ValkyrieTypeStatementNode
import com.intellij.codeInsight.navigation.actions.TypeDeclarationProvider
import com.intellij.psi.PsiElement

/// 带类型的声明右边的东西
/// a: T
/// def a() -> T
class ValkyrieDeclarationTypeProvider : TypeDeclarationProvider {
    override fun getSymbolTypeDeclarations(element: PsiElement): Array<PsiElement>? {
        val type = when (element) {
            is ValkyrieTypeStatementNode -> element.symbol
            else -> null
        } ?: return null

//        val typeDeclaration = type.baseTypeDeclaration() ?: return null
        return arrayOf(type)
    }

//    private tailrec fun Ty.baseTypeDeclaration(): RsElement? {
//        return when (this) {
//            is TyAdt -> item
//            is TyTraitObject -> traits.firstOrNull()?.element
//            is TyTypeParameter -> {
//                when (parameter) {
//                    is TyTypeParameter.Named -> parameter.parameter
//                    // TODO: support self type parameter
//                    else -> null
//                }
//            }
//            is TyProjection -> target
//            is TyReference -> referenced.baseTypeDeclaration()
//            is TyPointer -> referenced.baseTypeDeclaration()
//            is TyArray -> base.baseTypeDeclaration()
//            is TySlice -> elementType.baseTypeDeclaration()
//            is TyAnon -> traits.firstOrNull()?.element
//            else -> null
//        }
//    }
}