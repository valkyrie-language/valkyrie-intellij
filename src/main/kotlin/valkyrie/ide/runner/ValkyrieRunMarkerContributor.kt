package valkyrie.ide.runner

import com.intellij.execution.lineMarker.RunLineMarkerContributor
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile

// 该接口非常难用, element 会传入所有 节点, 但是必须是 leaf 节点才能返回 info, 否则会报错
class ValkyrieRunMarkerContributor : RunLineMarkerContributor() {
    override fun getInfo(element: PsiElement): Info? {
        return null
    }

    override fun getSlowInfo(element: PsiElement): Info? {
        return null
    }

    override fun producesAllPossibleConfigurations(file: PsiFile): Boolean {
        return false
    }
}

