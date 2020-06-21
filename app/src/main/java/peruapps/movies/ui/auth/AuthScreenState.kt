package peruapps.movies.ui.auth

sealed class AuthScreenState {
    object Loading : AuthScreenState()
    object NotLoading : AuthScreenState()
    object Success : AuthScreenState()
    class ShowMessage()
}