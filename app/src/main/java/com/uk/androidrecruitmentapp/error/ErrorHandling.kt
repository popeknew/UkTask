package com.uk.androidrecruitmentapp.error

import java.io.IOException
import java.net.HttpURLConnection.HTTP_UNAUTHORIZED
import java.net.HttpURLConnection.HTTP_NO_CONTENT
import java.net.HttpURLConnection.HTTP_BAD_REQUEST
import java.net.HttpURLConnection.HTTP_INTERNAL_ERROR
import java.net.HttpURLConnection.HTTP_FORBIDDEN
import java.net.UnknownHostException

fun Throwable.toMyError(): MyError =
        when (this) {
            is ApiException -> toMyError()
            is IOException -> toMyError()
            is IllegalStateException -> toMyError()
            else -> throw this
        }

internal fun ApiException.toMyError(): MyError =
        when (code) {
            HTTP_UNAUTHORIZED -> MyError.Unauthorized(this)
            HTTP_NO_CONTENT -> MyError.NoBody(this)
            HTTP_BAD_REQUEST -> badRequestToMyError(this)
            HTTP_INTERNAL_ERROR -> MyError.ServerError(this)
            HTTP_FORBIDDEN -> MyError.Forbidden(this)
            else -> MyError.ServerError(this)
        }

internal fun IOException.toMyError(): MyError = when (this) {
    is UnknownHostException -> MyError.ServerUnavailable()
    else -> throw this
}

internal fun IllegalStateException.toMyError(): MyError =
        MyError.NoNetworkConnection(this)

private fun badRequestToMyError(apiException: ApiException): MyError =
        MyError.ServerError(apiException)