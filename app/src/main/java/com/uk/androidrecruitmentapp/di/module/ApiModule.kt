package com.uk.androidrecruitmentapp.di.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.uk.androidrecruitmentapp.net.ApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApiModule {

    @Provides
    @Singleton
    internal fun providesGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    @Singleton
    internal fun providesOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

    @Provides
    @Singleton
    internal fun providesGsonConverterFactory(gson: Gson): GsonConverterFactory {
        return GsonConverterFactory.create(gson)
    }

    @Provides
    @Singleton
    internal fun provideCoroutineCallAdapterFactory(): CoroutineCallAdapterFactory =
            CoroutineCallAdapterFactory()

    @Provides
    @Singleton
    internal fun providesRetrofit(gsonConverterFactory: GsonConverterFactory, okHttpClient: OkHttpClient,
                                  coroutineCallAdapterFactory: CoroutineCallAdapterFactory): Retrofit {
        return Retrofit.Builder().addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(coroutineCallAdapterFactory)
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .build()
    }

    @Provides
    @Singleton
    internal fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create<ApiService>(ApiService::class.java)
    }

    companion object {
        private const val BASE_URL = "https://rickandmortyapi.com/api/"
    }
}