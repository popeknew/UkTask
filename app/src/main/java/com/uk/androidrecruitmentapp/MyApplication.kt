package com.uk.androidrecruitmentapp

import androidx.databinding.DataBindingUtil
import com.uk.androidrecruitmentapp.di.DaggerAppComponent
import dagger.android.DaggerApplication

class MyApplication : DaggerApplication() {

    private val applicationInjector = DaggerAppComponent
            .builder()
            .application(this)
            .build()

    public override fun applicationInjector() = applicationInjector

    override fun onCreate() {
        super.onCreate()

        setupDagger()
    }

    private fun setupDagger() {
        DataBindingUtil.setDefaultComponent(
                applicationInjector.bindingComponentBuilder().build()
        )
    }
}