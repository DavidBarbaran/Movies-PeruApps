package peruapps.movies.ui.auth

sealed class AuthState {
    object ErrorDisabled : AuthState()
    object EmailInvalid : AuthState()
    object PasswordInvalid : AuthState()
}