package com.github.valkyrie.language.psi

import com.github.valkyrie.ValkyrieLanguage
import com.intellij.psi.PsiElement
import com.intellij.psi.stubs.*

class ValkyrieElementType(debugName: String) : IStubElementType<ValkyrieStub, PsiElement>(debugName, ValkyrieLanguage) {
    override fun getExternalId(): String {
        TODO("Not yet implemented")
    }

    override fun deserialize(dataStream: StubInputStream, parentStub: StubElement<*>?): ValkyrieStub {
        TODO("Not yet implemented")
    }

    override fun createStub(psi: PsiElement, parentStub: StubElement<out PsiElement>?): ValkyrieStub {
        TODO("Not yet implemented")
    }

    override fun createPsi(stub: ValkyrieStub): PsiElement {
        TODO("Not yet implemented")
    }

    override fun indexStub(stub: ValkyrieStub, sink: IndexSink) {
        TODO("Not yet implemented")
    }

    override fun serialize(stub: ValkyrieStub, dataStream: StubOutputStream) {
        TODO("Not yet implemented")
    }
}