package peruapps.movies.ui.navigator.di

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import peruapps.movies.ui.navigator.Navigator
import peruapps.movies.ui.navigator.NavigatorImpl

val navigatorModule = module {
    single<Navigator> { NavigatorImpl(androidContext()) }
}