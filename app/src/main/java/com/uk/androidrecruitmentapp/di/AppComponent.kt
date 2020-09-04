package com.uk.androidrecruitmentapp.di

import android.app.Application
import com.uk.androidrecruitmentapp.MyApplication
import com.uk.androidrecruitmentapp.di.module.ApiModule
import com.uk.androidrecruitmentapp.di.module.AppModule
import com.uk.androidrecruitmentapp.di.module.ViewModelAssistedFactoriesModule
import com.uk.androidrecruitmentapp.di.module.ViewModelModule
import com.uk.androidrecruitmentapp.ui.EpisodesActivity
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
            AndroidInjectionModule::class,
            ActivityBuilder::class,
            AppModule::class,
            ApiModule::class,
            ViewModelAssistedFactoriesModule::class,
            ViewModelModule::class
        ]
)
interface AppComponent : AndroidInjector<MyApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

   // fun inject(activity: EpisodesActivity)

    fun bindingComponentBuilder(): BindingComponent.Builder
}