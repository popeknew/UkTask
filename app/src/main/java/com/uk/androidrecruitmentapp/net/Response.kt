package com.uk.androidrecruitmentapp.net

import com.uk.androidrecruitmentapp.error.MyError

sealed class Response<out T> {

    data class Success<out T>(val data: T) : Response<T>()
    data class Failure(val error: MyError) : Response<Nothing>()
}

fun <T : Any, R> Response<T>.doOnSuccess(action: (T) -> R): Response<T> = when (this) {
    is Response.Success -> {
        action.invoke(data)
        this
    }
    else -> this
}