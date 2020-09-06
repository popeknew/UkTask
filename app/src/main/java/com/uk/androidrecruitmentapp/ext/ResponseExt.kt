package com.uk.androidrecruitmentapp.ext

import com.uk.androidrecruitmentapp.error.ApiException
import retrofit2.Response

@Suppress("UNCHECKED_CAST")
fun <A : Any?> Response<A>.bodyOrException(): A {
    val body = body()
    return if (isSuccessful) {
        body ?: Unit as A
    } else {
        throw ApiException(this)
    }
}