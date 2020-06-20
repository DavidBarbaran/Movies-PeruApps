package peruapps.movies.domain.auth

import peruapps.movies.data.model.AuthBody
import peruapps.movies.domain.session.SessionRepository

class AuthInteractor(
    private val authRepository: AuthRepository,
    private val sessionRepository: SessionRepository
) :
    AuthUseCase {

    override suspend fun auth(auth: Auth) {
        val authResponse = authRepository.auth(AuthBody(auth.email, auth.password))
        sessionRepository.saveIsLogin(true)
        sessionRepository.saveToken(authResponse?.token)
    }
}