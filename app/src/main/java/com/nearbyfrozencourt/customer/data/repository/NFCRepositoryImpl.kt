package com.nearbyfrozencourt.customer.data.repository

import com.nearbyfrozencourt.customer.data.remote.NFCApi
import com.nearbyfrozencourt.customer.data.remote.body.GenerateTokenBody
import com.nearbyfrozencourt.customer.data.remote.body.PaymentSuccessBody
import com.nearbyfrozencourt.customer.data.remote.dto.BusinessDetailsDto
import com.nearbyfrozencourt.customer.data.remote.dto.GenerateTokenDto
import com.nearbyfrozencourt.customer.data.remote.dto.LoggedInUserDto
import com.nearbyfrozencourt.customer.data.remote.dto.PaymentDetailsDto
import com.nearbyfrozencourt.customer.data.remote.dto.PaymentSuccessDto
import com.nearbyfrozencourt.customer.data.remote.dto.ProductDetailsDto
import com.nearbyfrozencourt.customer.domain.NFCRepository
import javax.inject.Inject

class NFCRepositoryImpl @Inject constructor(private val nfcApi: NFCApi) : NFCRepository{

    override suspend fun generateToken(username : String, password : String): GenerateTokenDto {
        return nfcApi.generateToken(
            GenerateTokenBody(
                username = username,
                password = password
            )
        )
    }

    override suspend fun paymentDetails(authToken : String): PaymentDetailsDto {
        return nfcApi.getPaymentDetails(
            authorization = "Bearer $authToken"
        )
    }

    override suspend fun loggedInUserDetails(authToken: String): LoggedInUserDto {
        return nfcApi.getLoggedInUserDetails(
            authorization = "Bearer $authToken"
        )
    }

    override suspend fun paymentSuccess(paymentSuccessBody: PaymentSuccessBody): PaymentSuccessDto {
        return nfcApi.paymentSuccess(
            paymentSuccessBody = paymentSuccessBody
        )
    }

    override suspend fun getBusinessDetails(authToken: String) : BusinessDetailsDto {
        return nfcApi.getBusinessDetails(
            authorization = "Bearer $authToken"
        )
    }

    override suspend fun getProductsWithDetails(
        authToken: String,
        locationId: String
    ): ProductDetailsDto {
        return nfcApi.getProducts(
            authorization = "Bearer $authToken",
            locationId = locationId
        )
    }


}