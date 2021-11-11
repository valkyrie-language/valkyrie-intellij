package valkyrie.ide.runner

import com.intellij.execution.testframework.sm.runner.GeneralTestEventsProcessor
import com.intellij.execution.testframework.sm.runner.history.ImportTestOutputExtension
import org.xml.sax.helpers.DefaultHandler
import java.io.Reader

class TestOutput : ImportTestOutputExtension {
    override fun createHandler(reader: Reader?, processor: GeneralTestEventsProcessor?): DefaultHandler? {
        TODO("Not yet implemented")
    }
}