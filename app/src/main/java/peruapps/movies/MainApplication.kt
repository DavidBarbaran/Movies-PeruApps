package peruapps.movies

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import peruapps.movies.data.di.dataModule
import peruapps.movies.domain.di.domainModule
import peruapps.movies.ui.auth.di.authModule

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@MainApplication)
            modules(listOf(dataModule, domainModule, authModule))
        }
    }
}