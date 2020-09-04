package com.uk.androidrecruitmentapp.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Provider

class MyViewModelFactory(private val providers: Map<Class<out ViewModel>, Provider<ViewModel>>)
    : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return requireNotNull(providers[modelClass]).get() as T
    }
}