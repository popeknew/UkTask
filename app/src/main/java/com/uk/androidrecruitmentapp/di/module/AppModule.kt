package com.uk.androidrecruitmentapp.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.uk.androidrecruitmentapp.data.remote.ApiService
import com.uk.androidrecruitmentapp.repo.Repository
import com.uk.androidrecruitmentapp.vm.MyViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Provider
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideViewModelFactory(providers: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>): ViewModelProvider.Factory =
            MyViewModelFactory(providers)

    @Provides
    @Singleton
    fun provideRepository(apiService: ApiService): Repository = Repository(apiService)
}