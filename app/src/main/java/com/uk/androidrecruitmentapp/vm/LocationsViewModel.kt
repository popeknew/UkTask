package com.uk.androidrecruitmentapp.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uk.androidrecruitmentapp.model.Location
import com.uk.androidrecruitmentapp.repo.Repository
import kotlinx.coroutines.launch
import javax.inject.Inject

class LocationsViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _locationsData = MutableLiveData<List<Location>>()
    val locationsData: LiveData<List<Location>> = _locationsData

    private fun getAllLocations() {
        viewModelScope.launch {
            val response = repository.getAllLocations()
            if (response.isSuccessful) {
                _locationsData.value = response.body()?.results
            }
        }
    }

    init {
        getAllLocations()
    }
}