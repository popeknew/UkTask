package com.uk.androidrecruitmentapp.error

import java.lang.Exception

abstract class MyException  : Exception() {
    abstract val originalException: Throwable?
}