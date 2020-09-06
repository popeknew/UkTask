package com.uk.androidrecruitmentapp.repo

import com.uk.androidrecruitmentapp.error.toMyError
import com.uk.androidrecruitmentapp.net.Response

open class BaseRepository {

    suspend fun <T> safeCall(call: suspend () -> T): Response<T> =
            try {
                Response.Success(call.invoke())
            } catch (exception: Exception) {
                Response.Failure(exception.toMyError())
            }
}