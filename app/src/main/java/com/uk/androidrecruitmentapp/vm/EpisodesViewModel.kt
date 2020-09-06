package com.uk.androidrecruitmentapp.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uk.androidrecruitmentapp.model.ResponseEpisode
import com.uk.androidrecruitmentapp.net.Response
import com.uk.androidrecruitmentapp.repo.Repository
import kotlinx.coroutines.launch
import javax.inject.Inject

class EpisodesViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _episodesData = MutableLiveData<Response<ResponseEpisode>>()
    val episodesData: LiveData<Response<ResponseEpisode>> = _episodesData

    private fun getAllEpisodes() {
        viewModelScope.launch {
            _episodesData.value = repository.getAllEpisodes()
        }
    }

    init {
        getAllEpisodes()
    }
}