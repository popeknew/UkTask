package com.uk.androidrecruitmentapp.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uk.androidrecruitmentapp.data.local.Episodes
import com.uk.androidrecruitmentapp.model.ResponseCharacter
import com.uk.androidrecruitmentapp.model.ResponseEpisode
import com.uk.androidrecruitmentapp.model.ResponseLocation
import com.uk.androidrecruitmentapp.repo.Repository
import kotlinx.coroutines.launch
import javax.inject.Inject

class EpisodesViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    val data = MutableLiveData<ResponseEpisode>()
    val data2 = MutableLiveData<ResponseCharacter>()
    val data3 = MutableLiveData<ResponseLocation>()

    fun getAllEpisodes() {
        viewModelScope.launch {
            val response = repository.getAllEpisodes()
            if (response.isSuccessful) {
                data.value = response.body()
            }
        }
    }

    fun getAllCharacters() {
        viewModelScope.launch {
            val response = repository.getAllCharacaters()
            if (response.isSuccessful) {
                data2.value = response.body()
            }
        }
    }

    fun getAllLocations() {
        viewModelScope.launch {
            val response = repository.getAllLocations()
            if (response.isSuccessful) {
                data3.value = response.body()
            }
        }
    }
}