package com.uk.androidrecruitmentapp.repo

import com.uk.androidrecruitmentapp.ext.bodyOrException
import com.uk.androidrecruitmentapp.net.ApiService

class Repository(private val apiService: ApiService) : BaseRepository() {

    suspend fun getEpisodes(pageNumber: Int) =
            safeCall {
                apiService.getEpisodes(pageNumber).bodyOrException()
            }

    suspend fun getCharacter(pageNumber: Int) =
            safeCall {
                apiService.getCharacters(pageNumber).bodyOrException()
            }

    suspend fun getLocations(pageNumber: Int) =
            safeCall {
                apiService.getLocations(pageNumber).bodyOrException()
            }
}