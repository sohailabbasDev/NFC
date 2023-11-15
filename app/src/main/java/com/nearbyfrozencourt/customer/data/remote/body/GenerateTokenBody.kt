package com.nearbyfrozencourt.customer.data.remote.body

import com.nearbyfrozencourt.customer.data.remote.NFCApi

data class GenerateTokenBody(
    val grant_type : String = "password",
    val client_id : Int = NFCApi.CLIENT_ID,
    val client_secret: String = NFCApi.CLIENT_KEY,
    val username: String,
    val password: String
)