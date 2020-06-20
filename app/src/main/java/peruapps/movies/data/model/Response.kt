package peruapps.movies.data.model

import com.google.gson.annotations.SerializedName

class Response<T>(
    @SerializedName("status")
    val status: Int?,
    @SerializedName("data")
    val data: T?
)