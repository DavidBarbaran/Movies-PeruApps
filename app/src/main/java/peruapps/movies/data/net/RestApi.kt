package peruapps.movies.data.net

import com.google.gson.JsonObject
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import peruapps.movies.BuildConfig
import peruapps.movies.data.model.AuthBody
import peruapps.movies.data.model.AuthResponse
import peruapps.movies.data.model.BaseResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import java.util.concurrent.TimeUnit

interface RestApi {

    @POST("v1/auth/login")
    suspend fun auth(@Body authBody: AuthBody): Response<BaseResponse<AuthResponse>>

    @GET("v1/movies")
    suspend fun getMovies(): JsonObject

    companion object {
        private const val TIMEOUT_READ = 40L
        private const val TIMEOUT_WRITE = 40L
        private const val TIMEOUT_CONNECT = 30L

        val okHttpClient: OkHttpClient = OkHttpClient
            .Builder()
            .readTimeout(TIMEOUT_READ, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT_WRITE, TimeUnit.SECONDS)
            .addInterceptor(getInterceptor())
            .connectTimeout(TIMEOUT_CONNECT, TimeUnit.SECONDS)
            .build()

        private fun getInterceptor(): HttpLoggingInterceptor {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level =
                if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
            return interceptor
        }
    }
}