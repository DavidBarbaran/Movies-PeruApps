package peruapps.movies.data.model

import com.google.gson.annotations.SerializedName

class AuthBody(
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String
)