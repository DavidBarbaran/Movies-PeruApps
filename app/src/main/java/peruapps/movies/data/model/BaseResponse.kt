package peruapps.movies.data.model

import com.google.gson.annotations.SerializedName

class BaseResponse<T>(
    @SerializedName("status")
    val status: Int,
    @SerializedName("message")
    val message: String?,
    @SerializedName("data")
    val data: T?
) {
    fun isSuccess(): Boolean = status in 200..299
}