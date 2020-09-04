package com.uk.androidrecruitmentapp.di.module

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

interface ViewModelAssistedFactory<T : ViewModel> {
    fun create(stateHandle: SavedStateHandle): T
}