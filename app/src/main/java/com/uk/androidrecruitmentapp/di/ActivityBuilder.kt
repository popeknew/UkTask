package com.uk.androidrecruitmentapp.di

import com.uk.androidrecruitmentapp.di.scope.ActivityScoped
import com.uk.androidrecruitmentapp.ui.EpisodesActivity
import com.uk.androidrecruitmentapp.ui.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun bindSplashActivity(): SplashActivity

    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun bindEpisodesActivity(): EpisodesActivity
}