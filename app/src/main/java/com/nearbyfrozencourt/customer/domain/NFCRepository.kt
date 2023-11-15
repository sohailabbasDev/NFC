package com.nearbyfrozencourt.customer.domain

import com.nearbyfrozencourt.customer.data.remote.dto.GenerateTokenDto
import com.nearbyfrozencourt.customer.data.remote.dto.LoggedInUserDto
import com.nearbyfrozencourt.customer.data.remote.dto.PaymentDetailsDto
import com.nearbyfrozencourt.customer.data.remote.dto.PaymentSuccessDto
import com.nearbyfrozencourt.customer.data.remote.dto.TokenErrorDto
import com.nearbyfrozencourt.customer.util.Response

interface NFCRepository {

    suspend fun generateToken(username : String, password : String) : GenerateTokenDto

    suspend fun paymentDetails(authToken : String) : PaymentDetailsDto

    suspend fun loggedInUserDetails(authToken : String) : LoggedInUserDto

    suspend fun paymentSuccess() : PaymentSuccessDto
}