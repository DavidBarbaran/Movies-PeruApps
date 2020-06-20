package peruapps.movies.domain.di

import org.koin.dsl.module
import peruapps.movies.data.repository.AuthRepositoryImpl
import peruapps.movies.data.repository.SessionRepositoryImpl
import peruapps.movies.domain.auth.AuthInteractor
import peruapps.movies.domain.auth.AuthRepository
import peruapps.movies.domain.auth.AuthUseCase
import peruapps.movies.domain.session.SessionRepository

val domainModule = module {
    factory<SessionRepository> { SessionRepositoryImpl(get()) }

    factory<AuthRepository> { AuthRepositoryImpl(get()) }
    factory<AuthUseCase> { AuthInteractor(get(), get()) }
}