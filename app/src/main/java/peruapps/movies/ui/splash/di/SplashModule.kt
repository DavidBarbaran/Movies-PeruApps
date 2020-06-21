package peruapps.movies.ui.splash.di

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import peruapps.movies.ui.splash.SplashViewModel

val splashModule = module {
    viewModel { SplashViewModel(get()) }
}