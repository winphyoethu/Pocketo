package com.winphyoethu.pocketo.domain


sealed class Response<out T> {

    data class OnSuccess<out T>(val data: T) : Response<T>()

    data class OnError<out T>(val error: Error) : Response<T>()

}

data class Error(
    val code: Int,
    val message: String? = null,
    val cause: Throwable? = null
)

class ErrorThrowable(
    val code :Int,
    override var message: String? = null,
    override val cause: Throwable? = null
): Throwable() {
    fun toError() = Error(code, message, cause)
}

fun Error.toThrowable(): ErrorThrowable {
    return ErrorThrowable(code, message, cause)
}

fun <T> Error.toResponse(): Response<T> {
    return Response.OnError(this)
}

fun <T> Throwable.toErrorResult(): Response<T> {
    return when (this) {
        is ErrorThrowable -> Response.OnError(this.toError())
        else -> Response.OnError(ErrorThrowable(UNKNOWN, this.message, this.cause).toError())
    }
}

// unknown error
const val UNKNOWN = 99000

