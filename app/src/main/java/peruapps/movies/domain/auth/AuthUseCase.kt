package peruapps.movies.domain.auth

interface AuthUseCase {
    suspend fun auth(auth: Auth)
}