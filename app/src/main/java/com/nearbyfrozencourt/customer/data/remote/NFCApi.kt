package com.nearbyfrozencourt.customer.data.remote

import com.nearbyfrozencourt.customer.data.remote.body.GenerateTokenBody
import com.nearbyfrozencourt.customer.data.remote.dto.GenerateTokenDto
import com.nearbyfrozencourt.customer.data.remote.dto.PaymentDetailsDto
import com.nearbyfrozencourt.customer.data.remote.body.PaymentSuccessBody
import com.nearbyfrozencourt.customer.data.remote.dto.BusinessDetailsDto
import com.nearbyfrozencourt.customer.data.remote.dto.LoggedInUserDto
import com.nearbyfrozencourt.customer.data.remote.dto.PaymentSuccessDto
import com.nearbyfrozencourt.customer.data.remote.dto.ProductDetailsDto
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

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
    ) : PaymentSuccessDto

    @GET("/connector/api/user/loggedin")
    suspend fun getLoggedInUserDetails(
        @Header("Authorization") authorization : String,
        @Header("Content-Type") contentType : String = "application/json"
    ) : LoggedInUserDto


    @GET("/connector/api/business-details")
    suspend fun getBusinessDetails(
        @Header("Authorization") authorization : String,
        @Header("Content-Type") contentType : String = "application/json"
    ) : BusinessDetailsDto

//    @FormUrlEncoded
    @GET("/connector/api/product")
    suspend fun getProducts(
        @Header("Authorization") authorization : String,
        @Header("Content-Type") contentType : String = "application/json",
        @Query("order_by") orderBy : String = "",
        @Query("order_direction") orderDirection : String = "",
        @Query("brand_id") brandId : String = "",
        @Query("category_id") categoryId : String = "",
        @Query("sub_category_id") subCategoryId : String = "",
        @Query("location_id") locationId : String = "",
        @Query("selling_price_group") sellingPriceGroup : String = "",
        @Query("send_lot_detail") sendLotDetail : String = "",
        @Query("name") name : String = "",
        @Query("sku") sku : String = "",
        @Query("per_page") perPage : String = "",
    ) : ProductDetailsDto

    companion object{
        //Change this with your own token, This token may expire
        const val CLIENT_KEY = "RDUqB0dmW9UU9xJKEGqhBliBNwomweQGbGsWzl9L"
        const val CLIENT_ID = 43

        //The API base url
        const val BASE_URL = "http://nearbyfrozencourt.com"
    }
}