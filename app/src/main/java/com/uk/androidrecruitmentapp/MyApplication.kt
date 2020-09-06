package com.uk.androidrecruitmentapp

import com.uk.androidrecruitmentapp.di.DaggerAppComponent
import dagger.android.DaggerApplication

class MyApplication : DaggerApplication() {

    private val applicationInjector = DaggerAppComponent
            .builder()
            .application(this)
            .build()

    public override fun applicationInjector() = applicationInjector
}