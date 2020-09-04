package com.uk.androidrecruitmentapp.di

import androidx.databinding.DataBindingComponent
import com.uk.androidrecruitmentapp.di.module.BindingModule
import com.uk.androidrecruitmentapp.di.scope.DataBindingScoped
import com.uk.androidrecruitmentapp.ui.binding.TextViewBinding
import dagger.Subcomponent

@DataBindingScoped
@Subcomponent(modules = [BindingModule::class])
interface BindingComponent : DataBindingComponent {

    @Subcomponent.Builder
    interface Builder {
        fun build(): BindingComponent
    }

    // Will not compile without overriding
    override fun getTextViewBinding(): TextViewBinding
}