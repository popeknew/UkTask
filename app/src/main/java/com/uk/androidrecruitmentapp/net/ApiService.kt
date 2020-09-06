package com.uk.androidrecruitmentapp.net

import com.uk.androidrecruitmentapp.model.ResponseCharacter
import com.uk.androidrecruitmentapp.model.ResponseEpisode
import com.uk.androidrecruitmentapp.model.ResponseLocation
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("episode/")
    suspend fun getEpisodes(@Query("page") page: Int): Response<ResponseEpisode>

    @GET("character/")
    suspend fun getCharacters(@Query("page") page: Int): Response<ResponseCharacter>

    @GET("location/")
    suspend fun getLocations(@Query("page") page: Int): Response<ResponseLocation>
}