package com.uk.androidrecruitmentapp.data.remote

import com.uk.androidrecruitmentapp.data.local.Episodes
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    @GET("episode/")
    fun getAllEpisodes(): Single<Episodes>
}