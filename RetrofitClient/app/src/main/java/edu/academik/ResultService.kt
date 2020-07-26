package edu.academik


sealed class ResultService<out T : Any> {

    data class Init(var message: String = "") : ResultService<Nothing>()

    data class Success<out T : Any>(val data: T?) : ResultService<T>()

    data class Error(val exception: Throwable) : ResultService<Nothing>()


    companion object {

        fun <T : Any> processResponseApi(response: ResponseApi<T>): ResultService<T> {
            return if (response.success) Success(response.content) else Error(Exception(response.message))
        }
    }

    override fun toString(): String {
        return when (this) {
            is Init -> "Init[$message]"
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
        }
    }
}
