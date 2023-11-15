package com.nearbyfrozencourt.customer.util

sealed class Response<out T> {
    data class Loading(val loading: Boolean): Response<Nothing>()

    data class Success<out T>(
        val data: T
    ): Response<T>()

    data class Failure(
        val message: String?,
//        val data: T? = null
    ): Response<Nothing>()
}