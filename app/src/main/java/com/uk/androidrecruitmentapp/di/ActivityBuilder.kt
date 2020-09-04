package com.uk.androidrecruitmentapp.di

import com.uk.androidrecruitmentapp.di.scope.ActivityScoped
import com.uk.androidrecruitmentapp.di.scope.FragmentScoped
import com.uk.androidrecruitmentapp.ui.*
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

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun bindEpisodesFragment(): EpisodesFragment

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun bindLocationsFragment(): LocationsFragment

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun bindCharactersFragment(): CharactersFragment
}