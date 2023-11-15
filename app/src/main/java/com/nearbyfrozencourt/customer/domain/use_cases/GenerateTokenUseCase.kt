package com.nearbyfrozencourt.customer.domain.use_cases

import android.net.http.HttpException
import android.util.Log
import com.nearbyfrozencourt.customer.data.remote.dto.GenerateTokenDto
import com.nearbyfrozencourt.customer.data.remote.dto.TokenErrorDto
import com.nearbyfrozencourt.customer.domain.NFCRepository
import com.nearbyfrozencourt.customer.util.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GenerateTokenUseCase @Inject constructor(private val nfcRepository: NFCRepository){

    operator fun invoke(username : String, password : String) : Flow<Response<GenerateTokenDto>> = flow{
        emit(Response.Loading(loading = true))
        try {
            val result = nfcRepository.generateToken(username, password)
            emit(Response.Success(result))
            Log.d("tagged", "invoke: $result")
        }catch (e : Exception){
            emit(Response.Failure(e.localizedMessage ?: "Something went wrong"))
            Log.d("tagged", "invoke: ${e.stackTrace}")
            Log.d("tagged", "invoke: ${e.message}")

        }
    }
}