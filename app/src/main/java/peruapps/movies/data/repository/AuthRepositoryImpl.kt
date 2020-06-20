package peruapps.movies.data.repository

import peruapps.movies.data.exception.RequestTimeoutException
import peruapps.movies.data.exception.UnauthorizedException
import peruapps.movies.data.exception.UncaughtErrorException
import peruapps.movies.data.model.AuthBody
import peruapps.movies.data.model.AuthResponse
import peruapps.movies.data.net.RestApi
import peruapps.movies.domain.auth.AuthRepository
import java.lang.Exception

class AuthRepositoryImpl(private val restApi: RestApi) :
    AuthRepository {

    override suspend fun auth(authBody: AuthBody): AuthResponse? {
        val response = restApi.auth(authBody)
        if (response.isSuccessful) {
            return response.body()?.data
        } else {
            throw getExceptionByCode(response.code())
        }
    }

    fun getExceptionByCode(status: Int): Exception {
        return when (status) {
            401 -> UnauthorizedException()
            408 -> RequestTimeoutException()
            else -> UncaughtErrorException()
        }
    }
}