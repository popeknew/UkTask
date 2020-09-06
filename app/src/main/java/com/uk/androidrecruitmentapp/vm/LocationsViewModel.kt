package com.uk.androidrecruitmentapp.vm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uk.androidrecruitmentapp.model.Location
import com.uk.androidrecruitmentapp.model.ResponseLocation
import com.uk.androidrecruitmentapp.net.Response
import com.uk.androidrecruitmentapp.repo.Repository
import kotlinx.coroutines.launch
import javax.inject.Inject

class LocationsViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private var currentPage = 1
    var allPages = 0

    private val _locationsData = MutableLiveData<Response<ResponseLocation>>()
    val locationsData: LiveData<Response<ResponseLocation>> = _locationsData

    val locationList = mutableListOf<Location>()

    private fun getLocations() {
        viewModelScope.launch {
            _locationsData.value = repository.getLocations(currentPage)
        }
    }

    fun getLocationsFromNextPage() {
        currentPage += 1
        if (currentPage <= allPages) {
            getLocations()
        }
    }

    init {
        getLocations()
    }
}