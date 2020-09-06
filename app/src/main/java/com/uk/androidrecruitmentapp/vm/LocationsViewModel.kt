package com.uk.androidrecruitmentapp.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uk.androidrecruitmentapp.model.ResponseLocation
import com.uk.androidrecruitmentapp.net.Response
import com.uk.androidrecruitmentapp.repo.Repository
import kotlinx.coroutines.launch
import javax.inject.Inject

class LocationsViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _locationsData = MutableLiveData<Response<ResponseLocation>>()
    val locationsData: LiveData<Response<ResponseLocation>> = _locationsData

    private fun getAllLocations() {
        viewModelScope.launch {
            _locationsData.value = repository.getAllLocations()
        }
    }

    init {
        getAllLocations()
    }
}