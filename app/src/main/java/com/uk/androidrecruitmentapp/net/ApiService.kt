package com.uk.androidrecruitmentapp.net

import com.uk.androidrecruitmentapp.model.ResponseCharacter
import com.uk.androidrecruitmentapp.model.ResponseEpisode
import com.uk.androidrecruitmentapp.model.ResponseLocation
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("episode/")
    suspend fun getAllEpisodes(): Response<ResponseEpisode>

    @GET("character/")
    suspend fun getAllCharacters(): Response<ResponseCharacter>

    @GET("location/")
    suspend fun getAllLocations(): Response<ResponseLocation>
}