package com.uk.androidrecruitmentapp.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uk.androidrecruitmentapp.model.Episode
import com.uk.androidrecruitmentapp.model.ResponseEpisode
import com.uk.androidrecruitmentapp.net.Response
import com.uk.androidrecruitmentapp.repo.Repository
import kotlinx.coroutines.launch
import javax.inject.Inject

class EpisodesViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private var currentPage = 1
    var allPages = 0

    private val _episodesData = MutableLiveData<Response<ResponseEpisode>>()
    val episodesData: LiveData<Response<ResponseEpisode>> = _episodesData

    val episodeList = mutableListOf<Episode>()

    private fun getEpisodes() {
        viewModelScope.launch {
            _episodesData.value = repository.getEpisodes(currentPage)
        }
    }

    fun getEpisodesFromNextPage() {
        currentPage += 1
        if (currentPage <= allPages) {
            getEpisodes()
        }
    }

    init {
        getEpisodes()
    }
}