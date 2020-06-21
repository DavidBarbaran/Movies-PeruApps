package peruapps.movies.data.net

import com.google.gson.JsonObject
import peruapps.movies.data.model.AuthBody
import peruapps.movies.data.model.AuthResponse
import peruapps.movies.data.model.BaseResponse
import retrofit2.Response
import retrofit2.http.*

interface RestApi {

    @POST("v1/auth/login")
    suspend fun auth(@Body authBody: AuthBody): Response<BaseResponse<AuthResponse>>

    @GET("v1/movies")
    suspend fun getMovies(
        @Header("Authorization") token: String,
        @Query("page") page: Int = 0
    ): JsonObject
}