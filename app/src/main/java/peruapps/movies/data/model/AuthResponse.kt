package peruapps.movies.data.model

import com.google.gson.annotations.SerializedName

class AuthResponse(
    @SerializedName("token")
    val token: String?
)