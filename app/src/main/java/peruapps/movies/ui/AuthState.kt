package peruapps.movies.ui

sealed class AuthState {
    object ErrorDisabled : AuthState()
    object EmailInvalid : AuthState()
    object PasswordInvalid : AuthState()
}