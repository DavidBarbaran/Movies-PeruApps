package peruapps.movies.ui.splash

sealed class SplashScreenState {
    object AuthRequired : SplashScreenState()
    object AuthNotRequired : SplashScreenState()
}