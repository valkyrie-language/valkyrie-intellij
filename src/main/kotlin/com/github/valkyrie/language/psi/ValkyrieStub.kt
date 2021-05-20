package com.github.valkyrie.language.psi

import com.github.valkyrie.language.ast.ValkyrieASTBase
import com.intellij.psi.PsiElement
import com.intellij.psi.stubs.IStubElementType
import com.intellij.psi.stubs.StubElement
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet
import com.intellij.util.ArrayFactory

class ValkyrieStub : StubElement<ValkyrieASTBase> {
    override fun getParentStub(): ValkyrieStub {
        TODO("Not yet implemented")
    }

    override fun getChildrenStubs(): MutableList<ValkyrieStub> {
        TODO("Not yet implemented")
    }

    override fun getStubType(): IStubElementType<out ValkyrieStub, *> {
        TODO("Not yet implemented")
    }

    override fun <P : PsiElement?, S : StubElement<P>?> findChildStubByType(elementType: IStubElementType<S, P>): S? {
        TODO("Not yet implemented")
    }

    override fun getPsi(): ValkyrieASTBase {
        TODO("Not yet implemented")
    }

    override fun <E : PsiElement?> getChildrenByType(elementType: IElementType, array: Array<out E>?): Array<E> {
        TODO("Not yet implemented")
    }

    override fun <E : PsiElement?> getChildrenByType(filter: TokenSet, array: Array<out E>?): Array<E> {
        TODO("Not yet implemented")
    }

    override fun <E : PsiElement?> getChildrenByType(elementType: IElementType, f: ArrayFactory<E>): Array<E> {
        TODO("Not yet implemented")
    }

    override fun <E : PsiElement?> getChildrenByType(filter: TokenSet, f: ArrayFactory<E>): Array<E> {
        TODO("Not yet implemented")
    }

    override fun <E : PsiElement?> getParentStubOfType(parentClass: Class<E>): E? {
        TODO("Not yet implemented")
    }

}