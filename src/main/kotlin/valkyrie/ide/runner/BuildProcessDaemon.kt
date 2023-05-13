package valkyrie.ide.runner

import com.intellij.build.BuildTreeConsoleView
import com.intellij.build.DefaultBuildDescriptor
import com.intellij.build.events.impl.*
import com.intellij.execution.process.ProcessHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.io.OutputStream

class BuildProcessDaemon : ProcessHandler {
    val view: BuildTreeConsoleView
    val time: Long = System.currentTimeMillis()
    val eventCounter = 0


    constructor(view: BuildTreeConsoleView) : super() {
        this.view = view

        CoroutineScope(Dispatchers.Default).launch {
            testEvents()
        }
    }

    private suspend fun testEvents() {
        view.onEvent(0, StartBuildEventImpl(DefaultBuildDescriptor(0, 0, "3", "A", time), "Start build stage 1"))
        delay(500)
        view.onEvent(2, StartEventImpl(11, 0, time + 1, "Start1"))
        view.onEvent(3, StartEventImpl(12, 0, time + 1, "Start2"))
        delay(500)

        view.onEvent(4, StartEventImpl(13, 11, time + 2, "Start3"))
        view.onEvent(5, StartEventImpl(14, 11, time + 2, "Start4"))
        delay(500)
        view.onEvent(6, StartEventImpl(15, 12, time + 3, "Start5"))
        view.onEvent(7, StartEventImpl(16, 12, time + 3, "Start6"))
        view.onEvent(8, StartEventImpl(17, 12, time + 3, "Start7"))

        delay(1000)

        view.onEvent(2, FinishEventImpl(18, null, time + 4, "Fniish", DerivedResultImpl()))
        view.onEvent(5, FinishEventImpl(19, null, time + 4, "Fniish", SkippedResultImpl()))

        view.onEvent(0, FinishBuildEventImpl(20, null, time + 4, "FinishBuildEventImpl1", SuccessResultImpl()))
        delay(1000)
        notifyProcessTerminated(0)


    }

    override fun destroyProcessImpl() {

        notifyProcessTerminated(0)
    }

    override fun detachProcessImpl() {
        notifyProcessTerminated(0)
    }

    override fun detachIsDefault(): Boolean {
        return false
    }

    override fun getProcessInput(): OutputStream? {
        return null
    }


}