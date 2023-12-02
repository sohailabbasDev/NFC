package com.nearbyfrozencourt.customer.domain.use_cases.user

import com.nearbyfrozencourt.customer.data.remote.dto.LoggedInUserDto
import com.nearbyfrozencourt.customer.domain.NFCRepository
import com.nearbyfrozencourt.customer.util.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetLoggedInUserUseCase @Inject constructor(private val nfcRepository: NFCRepository){

    operator fun invoke(authToken : String) : Flow<Response<LoggedInUserDto>> = flow {
        emit(Response.Loading(loading = true))
        try {
            val result = nfcRepository.loggedInUserDetails(authToken = authToken)
            emit(Response.Success(result))
        }catch (e : Exception){
            emit(Response.Failure(e.localizedMessage ?: "Something went wrong, please restart the application"))
        }
    }
}