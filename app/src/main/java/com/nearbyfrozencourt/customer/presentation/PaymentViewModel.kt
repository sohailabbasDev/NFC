package com.nearbyfrozencourt.customer.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.nearbyfrozencourt.customer.data.remote.dto.PaymentDetailsDto
import com.nearbyfrozencourt.customer.data.repository.DataStoreRepository
import com.nearbyfrozencourt.customer.domain.use_cases.payments.PaymentsUseCases
import com.nearbyfrozencourt.customer.util.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PaymentViewModel @Inject constructor(
    dataStoreRepository: DataStoreRepository,
    private val paymentsUseCases: PaymentsUseCases
) : BaseViewModel(dataStoreRepository) {

//    private val _authToken : MutableState<String> = mutableStateOf("")
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

    fun getPaymentDetails(){
        paymentsUseCases.paymentDetailsUseCase(authToken = authToken.value).onEach {
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
//                    Log.d("tagged", "generateToken: ${it.data}")
                }
                is Response.Failure -> {
                    _paymentState.value = Response.Failure(it.message)
                }
            }
        }.launchIn(viewModelScope)
    }

}