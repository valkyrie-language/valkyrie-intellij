package valkyrie.lsp

import kotlinx.serialization.Serializable

//@Serializable
data class ResponseMessage<T>(
    val code: Int,
    val message: String,
    val data: T,
)