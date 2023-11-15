package com.nearbyfrozencourt.customer.data.remote.dto

data class TokenErrorDto(
    val error: String,
    val error_description: String,
    val hint: String,
    val message: String
)