package com.nearbyfrozencourt.customer.data.remote.dto

data class GenerateTokenDto(
    val access_token: String,
    val expires_in: Int,
    val refresh_token: String,
    val token_type: String
)