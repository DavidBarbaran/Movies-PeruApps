package peruapps.movies.data.di

import org.koin.dsl.module
import peruapps.movies.BuildConfig
import peruapps.movies.data.RestApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {

    single {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(RestApi.okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(RestApi::class.java)
    }
}