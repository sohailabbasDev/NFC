package com.nearbyfrozencourt.customer.domain.use_cases.user

import com.nearbyfrozencourt.customer.data.remote.dto.BusinessDetailsDto
import com.nearbyfrozencourt.customer.domain.NFCRepository
import com.nearbyfrozencourt.customer.util.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetBusinessDetailsUseCase @Inject constructor(private val nfcRepository: NFCRepository) {

    operator fun invoke(authToken : String) : Flow<Response<BusinessDetailsDto>> = flow {
        emit(Response.Loading(loading = true))
        try {
            val result = nfcRepository.getBusinessDetails(authToken = authToken)
            emit(Response.Success(result))
        }catch (e : Exception){
            emit(Response.Failure(e.localizedMessage ?: "Something went wrong, failed to get business details"))
        }
    }

}