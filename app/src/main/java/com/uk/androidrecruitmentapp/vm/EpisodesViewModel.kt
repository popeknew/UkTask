package com.uk.androidrecruitmentapp.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uk.androidrecruitmentapp.data.local.Episodes
import com.uk.androidrecruitmentapp.model.Episode
import com.uk.androidrecruitmentapp.model.ResponseCharacter
import com.uk.androidrecruitmentapp.model.ResponseEpisode
import com.uk.androidrecruitmentapp.model.ResponseLocation
import com.uk.androidrecruitmentapp.repo.Repository
import kotlinx.coroutines.launch
import javax.inject.Inject

class EpisodesViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _episodesData = MutableLiveData<List<Episode>>()
    val episodesData: LiveData<List<Episode>> = _episodesData

    private fun getAllEpisodes() {
        viewModelScope.launch {
            val response = repository.getAllEpisodes()
            if (response.isSuccessful) {
                _episodesData.value = response.body()?.results
            }
        }
    }

    init {
        getAllEpisodes()
    }
}