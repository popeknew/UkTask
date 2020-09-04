package com.uk.androidrecruitmentapp.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uk.androidrecruitmentapp.data.local.Episodes
import com.uk.androidrecruitmentapp.model.ResponseEpisode
import com.uk.androidrecruitmentapp.repo.Repository
import kotlinx.coroutines.launch
import javax.inject.Inject

class EpisodesViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    val data = MutableLiveData<ResponseEpisode>()

    fun getAllEpisodes() {
        viewModelScope.launch {
            val response = repository.getAllEpisodes()
            if (response.isSuccessful) {
                data.value = response.body()
            }
        }
    }
}