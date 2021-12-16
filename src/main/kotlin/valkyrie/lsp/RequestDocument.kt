package valkyrie.lsp

import com.intellij.remoteDev.util.addPathSuffix
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.net.http.HttpRequest
import java.net.http.HttpResponse


//@Serializable
data class RequestDocument(
    val kind: String,
    val namepath: List<String>,
    val language: String,
    val format: String = "jetbrain",
) {
    companion object {
        fun keyword(name: String): RequestDocument {
            return RequestDocument("keyword", listOf(name), LanguageClient.language)
        }

        fun operator(name: String): RequestDocument {
            return RequestDocument("operator", listOf(name), LanguageClient.language)
        }

        fun modifier(name: String): RequestDocument {
            return RequestDocument("modifier", listOf(name), LanguageClient.language)
        }
    }

    fun send(): String {
//        val httpRequest = HttpRequest.newBuilder()
//            .uri(LanguageClient.host.addPathSuffix("document"))
//            .header("Content-Type", "application/json")
//            .POST(HttpRequest.BodyPublishers.ofString(Json.encodeToString(this)))
//            .build()
//        val response = LanguageClient.client.send(httpRequest, HttpResponse.BodyHandlers.ofString())
//        if (response.body().isEmpty()) {
//            return "Document not found"
//        }
//        val body = Json.decodeFromString<ResponseDocument>(response.body());
//        return body.content
        return "";
    }
}

//@Serializable
private data class ResponseDocument(val content: String) {

}
