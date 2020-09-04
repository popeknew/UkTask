package com.uk.androidrecruitmentapp

sealed class Response<out T> {

    data class Success<out T>(val data: T) : Response<T>()
    data class Loading(val isLoading: Boolean) : Response<Nothing>()
}

fun <T : Any, R> Response<T>.doOnSuccess(action: (T) -> R): Response<T> = when (this) {
    is Response.Success -> {
        action.invoke(data)
        this
    }
    else -> this
}