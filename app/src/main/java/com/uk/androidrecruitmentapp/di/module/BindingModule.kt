package com.uk.androidrecruitmentapp.di.module

import com.uk.androidrecruitmentapp.di.scope.DataBindingScoped
import com.uk.androidrecruitmentapp.ui.binding.TextViewBinding
import dagger.Module
import dagger.Provides

@Module
class BindingModule {

    @Provides
    @DataBindingScoped
    fun provideTextViewBinding() = TextViewBinding()
}