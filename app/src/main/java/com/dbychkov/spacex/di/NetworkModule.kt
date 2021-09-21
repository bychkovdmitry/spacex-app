package com.dbychkov.spacex.di

import com.dbychkov.spacex.BuildConfig
import com.dbychkov.spacex.ZonedDateTimeAdapter
import com.dbychkov.spacex.data.remote.LaunchApi
import com.dbychkov.spacex.data.repository.LaunchRepositoryImpl
import com.dbychkov.spacex.domain.repository.LaunchRepository
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BASIC
            } else {
                HttpLoggingInterceptor.Level.BODY
            }
        }
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .apply { addInterceptor(httpLoggingInterceptor) }
            .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(ZonedDateTimeAdapter())
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit {
        return Retrofit.Builder()
            .baseUrl(API_URL)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .validateEagerly(BuildConfig.DEBUG)
            .build()
    }

    @Provides
    @Singleton
    fun provideLaunchApi(retrofit: Retrofit): LaunchApi {
        return retrofit.create(LaunchApi::class.java)
    }

    @Provides
    @Singleton
    fun provideLaunchRepository(launchApi: LaunchApi): LaunchRepository {
        return LaunchRepositoryImpl(launchApi)
    }

    private const val API_URL = "https://api.spacexdata.com/v4/"
    private const val CONNECTION_TIMEOUT = 20L
}
