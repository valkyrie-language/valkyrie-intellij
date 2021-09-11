package valkyrie.lsp

import org.junit.Test
import java.net.URI
import java.net.http.HttpClient

class LanguageClient {
    companion object {
        val client: HttpClient = HttpClient.newHttpClient()
        var host: URI = URI.create("http://127.0.0.1:9600/");
        val language: String = "en"
        val libraryPath: String = "F:\\Python\\vk-intellij\\src\\design";
    }

    @Test
    fun startServer() {
        Runtime.getRuntime().exec("git status")
    }
}
