package com.nearbyfrozencourt.customer.presentation

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nearbyfrozencourt.customer.data.remote.dto.GenerateTokenDto
import com.nearbyfrozencourt.customer.data.remote.dto.PaymentDetailsDto
import com.nearbyfrozencourt.customer.data.repository.DataStoreRepository
import com.nearbyfrozencourt.customer.domain.use_cases.NFCUseCases
import com.nearbyfrozencourt.customer.util.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PaymentViewModel @Inject constructor(
    private val dataStoreRepository: DataStoreRepository,
    private val nfcUseCases: NFCUseCases
) : ViewModel() {

    private val _authToken : MutableState<String> = mutableStateOf("")
//    val authToken : State<String> = _authToken

    private val _paymentState = mutableStateOf<Response<PaymentDetailsDto>>(Response.Loading(false))
    val paymentState : State<Response<PaymentDetailsDto>> = _paymentState

    private val _isDataLoaded : MutableState<Boolean> = mutableStateOf(false)
    val isDataLoaded : State<Boolean> = _isDataLoaded

    var payeeName = mutableStateOf("")
    var payeeVPA = mutableStateOf("")
    var amount = mutableStateOf("")
    var description = mutableStateOf("")

//    var isDataLoaded = false

    init {
        viewModelScope.launch {
            dataStoreRepository.getAuthToken.collect{
                _authToken.value = it
            }
        }
    }

    fun getPaymentDetails(){
        nfcUseCases.paymentDetailsUseCase(authToken = _authToken.value).onEach {
            when(it){
                is Response.Loading -> {
                    _paymentState.value = Response.Loading(it.loading)
                }
                is Response.Success -> {
                    _paymentState.value = Response.Success(it.data)
                    val papName = it.data.data?.get(0)?.name
                    val vpa = it.data.data?.get(0)?.account_details?.get(1)?.value
                    if (vpa != null && papName != null){
                        payeeName.value = papName
                        payeeVPA.value = vpa
                        _isDataLoaded.value = true
                    }
                    Log.d("tagged", "generateToken: ${it.data}")
                }
                is Response.Failure -> {
                    _paymentState.value = Response.Failure(it.message)
                }
            }
        }.launchIn(viewModelScope)
    }

}