package com.uk.androidrecruitmentapp.di.module

import androidx.lifecycle.ViewModel
import com.uk.androidrecruitmentapp.di.ViewModelKey
import com.uk.androidrecruitmentapp.vm.EpisodesViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class ViewModelModule {

    @Provides
    @IntoMap
    @ViewModelKey(EpisodesViewModel::class)
    fun episodesViewModel(viewModel: EpisodesViewModel): ViewModel = viewModel
}