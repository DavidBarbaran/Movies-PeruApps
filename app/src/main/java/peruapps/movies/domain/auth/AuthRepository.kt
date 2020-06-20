package peruapps.movies.domain.auth

import peruapps.movies.data.model.AuthBody
import peruapps.movies.data.model.AuthResponse

interface AuthRepository {
    suspend fun auth(authBody: AuthBody) : AuthResponse?
}