package com.uk.androidrecruitmentapp.error

import retrofit2.Response

data class ApiException(
        val code: Int,
        val url: String,
        override val message: String?,
        override val originalException: Throwable? = null
) : MyException() {

    constructor(response: Response<*>) : this(
            response.code(),
            response.raw().request().url().toString(),
            response.errorBody()?.string()
    )

    override fun toString() = "CODE: $code \nURL: $url \nMESSAGE: $message"
}