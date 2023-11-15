package com.nearbyfrozencourt.customer.domain.use_cases

import android.util.Log
import com.nearbyfrozencourt.customer.data.remote.dto.PaymentDetailsDto
import com.nearbyfrozencourt.customer.domain.NFCRepository
import com.nearbyfrozencourt.customer.util.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PaymentDetailsUseCase @Inject constructor(private val nfcRepository: NFCRepository) {

    operator fun invoke(authToken : String) : Flow<Response<PaymentDetailsDto>> = flow {
        emit(Response.Loading(loading = true))
        try {
            val result = nfcRepository.paymentDetails(authToken = authToken)
            emit(Response.Success(result))
            Log.d("tagged", "invoke: $result")
        }catch (e : Exception){
            emit(Response.Failure(e.localizedMessage ?: "Something went wrong"))
            Log.d("tagged", "invoke: ${e.stackTrace}")
            Log.d("tagged", "invoke: ${e.message}")
        }
    }

}