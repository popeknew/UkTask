package com.uk.androidrecruitmentapp.repo

import com.uk.androidrecruitmentapp.data.remote.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Repository(private val apiService: ApiService) {

    suspend fun getAllEpisodes() = withContext(Dispatchers.IO) {
        apiService.getAllEpisodes()
    }

    suspend fun getAllCharacaters() = withContext(Dispatchers.IO) {
        apiService.getAllCharacters()
    }

    suspend fun getAllLocations() = withContext(Dispatchers.IO) {
        apiService.getAllLocations()
    }
}