package com.uk.androidrecruitmentapp.error

sealed class MyError : MyException() {
    data class ServerUnavailable(override val originalException: Throwable? = null) : MyError()
    data class ServerError(override val originalException: Throwable? = null) : MyError()
    data class Unauthorized(override val originalException: Throwable? = null) : MyError()
    data class NoBody(override val originalException: Throwable? = null) : MyError()
    data class NoNetworkConnection(override val originalException: Throwable? = null) : MyError()
    data class Forbidden(override val originalException: Throwable? = null) : MyError()
}