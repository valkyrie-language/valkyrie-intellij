package valkyrie.lsp

import org.junit.Test
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class LanguageClient {
    companion object {
        val client: HttpClient = HttpClient.newHttpClient()
        var host: URI = URI.create("http://127.0.0.1:9600/");
        val language: String = "en"
    }

    @Test
    fun startServer() {
        Runtime.getRuntime().exec("git status")
    }
}
