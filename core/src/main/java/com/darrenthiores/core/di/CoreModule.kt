package com.darrenthiores.core.di

import androidx.paging.ExperimentalPagingApi
import androidx.room.Room
import com.darrenthiores.core.data.local.LocalDataSource
import com.darrenthiores.core.data.local.MovieDb
import com.darrenthiores.core.data.remote.RemoteDataSource
import com.darrenthiores.core.data.remote.ktor.MovieService
import com.darrenthiores.core.data.remote.ktor.MovieServiceImpl
import com.darrenthiores.core.data.repository.IMovieRepository
import com.darrenthiores.core.data.repository.MovieRepository
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {

    single {

        Room.databaseBuilder(
            androidContext(),
            MovieDb::class.java,
            "Movie.db"
        ).fallbackToDestructiveMigration()
            .build()

    }

}

val networkModule = module {
    single {
        val json = kotlinx.serialization.json.Json {
            ignoreUnknownKeys = true
            isLenient = true
            encodeDefaults = false
        }
        HttpClient(Android) {
            install(Logging) {
                level = LogLevel.ALL
            }
            install(HttpTimeout) { // Timeout
                requestTimeoutMillis = 15000L
                connectTimeoutMillis = 15000L
                socketTimeoutMillis = 15000L
            }
            install(JsonFeature) {
                serializer = KotlinxSerializer(json)
            }
        }
    }
    single<MovieService> { MovieServiceImpl(get()) }
}

@OptIn(ExperimentalPagingApi::class)
val repositoryModule = module {

    single { RemoteDataSource(get()) }
    single { LocalDataSource(get()) }

    single<IMovieRepository> { MovieRepository(get(), get()) }

}