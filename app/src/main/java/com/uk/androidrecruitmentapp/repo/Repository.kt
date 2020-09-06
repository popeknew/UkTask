package com.uk.androidrecruitmentapp.repo

import com.uk.androidrecruitmentapp.ext.bodyOrException
import com.uk.androidrecruitmentapp.net.ApiService
import com.uk.androidrecruitmentapp.net.doOnSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Repository(private val apiService: ApiService) : BaseRepository() {

    suspend fun getAllEpisodes() =
            safeCall {
                apiService.getAllEpisodes().bodyOrException()
            }

    suspend fun getAllCharacters() =
            safeCall {
                apiService.getAllCharacters().bodyOrException()
            }

    suspend fun getAllLocations() =
            safeCall {
                apiService.getAllLocations().bodyOrException()
            }
}