package com.uk.androidrecruitmentapp.vm

import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.uk.androidrecruitmentapp.di.module.ViewModelAssistedFactory
import javax.inject.Inject

class AssistedViewModelFactory @Inject constructor(
        private val viewModelMap: MutableMap<Class<out ViewModel>, ViewModelAssistedFactory<out ViewModel>>,
        owner: SavedStateRegistryOwner
) : AbstractSavedStateViewModelFactory(owner, null) {

    override fun <T : ViewModel?> create(
            key: String,
            modelClass: Class<T>,
            handle: SavedStateHandle
    ): T {
        return viewModelMap[modelClass]?.create(handle) as? T
                ?: throw IllegalStateException("Unknown ViewModel class")
    }
}