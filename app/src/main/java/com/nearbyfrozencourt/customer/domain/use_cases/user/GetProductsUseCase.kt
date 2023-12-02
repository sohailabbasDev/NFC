package com.nearbyfrozencourt.customer.domain.use_cases.user

import android.util.Log
import com.nearbyfrozencourt.customer.data.remote.dto.ProductDetailsDto
import com.nearbyfrozencourt.customer.domain.NFCRepository
import com.nearbyfrozencourt.customer.util.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(private val nfcRepository: NFCRepository) {

    operator fun invoke(authToken : String, locationId : String) : Flow<Response<ProductDetailsDto>> = flow {
        emit(Response.Loading(loading = true))
        try {
            val result = nfcRepository.getProductsWithDetails(authToken = authToken, locationId = locationId)
            emit(Response.Success(result))
        }catch (e : Exception){
            Log.d("tagged", "invoke: products error ${e.message} ,${e.localizedMessage}   ")
            emit(Response.Failure(e.localizedMessage ?: "Something went wrong, failed to get the products"))
        }
    }

}