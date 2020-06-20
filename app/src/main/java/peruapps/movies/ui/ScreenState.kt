package peruapps.movies.ui

sealed class ScreenState {
    object Loading : ScreenState()
    object NotLoading : ScreenState()
    object Success : ScreenState()
}