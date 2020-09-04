package com.uk.androidrecruitmentapp.di.module

import androidx.lifecycle.ViewModel
import com.uk.androidrecruitmentapp.di.ViewModelKey
import com.uk.androidrecruitmentapp.vm.CharactersViewModel
import com.uk.androidrecruitmentapp.vm.EpisodesViewModel
import com.uk.androidrecruitmentapp.vm.LocationsViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class ViewModelModule {

    @Provides
    @IntoMap
    @ViewModelKey(EpisodesViewModel::class)
    fun episodesViewModel(viewModel: EpisodesViewModel): ViewModel = viewModel

    @Provides
    @IntoMap
    @ViewModelKey(LocationsViewModel::class)
    fun locationsViewModel(viewModel: LocationsViewModel): ViewModel = viewModel

    @Provides
    @IntoMap
    @ViewModelKey(CharactersViewModel::class)
    fun charactersViewModel(viewModel: CharactersViewModel): ViewModel = viewModel
}