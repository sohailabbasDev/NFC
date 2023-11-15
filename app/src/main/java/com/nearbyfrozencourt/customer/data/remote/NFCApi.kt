package com.nearbyfrozencourt.customer.data.remote

import com.nearbyfrozencourt.customer.data.remote.body.GenerateTokenBody
import com.nearbyfrozencourt.customer.data.remote.dto.GenerateTokenDto
import com.nearbyfrozencourt.customer.data.remote.dto.PaymentDetailsDto
import com.nearbyfrozencourt.customer.data.remote.body.PaymentSuccessBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface NFCApi {

    @POST("/oauth/token")
    suspend fun generateToken(
    @Body generateTokenBody: GenerateTokenBody
    ) : GenerateTokenDto

    @GET("/connector/api/payment-accounts")
    suspend fun getPaymentDetails(
        @Header("Authorization") authorization : String,
        @Header("Content-Type") contentType : String = "application/json"
    ) : PaymentDetailsDto


    @POST("/connector/api/contactapi-payment")
    suspend fun paymentSuccess(
        @Body paymentSuccessBody: PaymentSuccessBody
    )

    @GET("/connector/api/user/loggedin")
    suspend fun getLoggedInUserDetails(
        @Header("Authorization") authorization : String,
        @Header("Content-Type") contentType : String = "application/json"
    )

    companion object{
        //Change this with your own token, This token may expire
        const val CLIENT_KEY = "RDUqB0dmW9UU9xJKEGqhBliBNwomweQGbGsWzl9L"
        const val CLIENT_ID = 43

        //The API base url
        const val BASE_URL = "http://nearbyfrozencourt.com"
    }
}