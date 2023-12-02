package com.nearbyfrozencourt.customer.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nearbyfrozencourt.customer.data.remote.dto.BusinessDetailsDto
import com.nearbyfrozencourt.customer.data.remote.dto.LoggedInUserDto
import com.nearbyfrozencourt.customer.data.remote.dto.ProductDetailsDto
import com.nearbyfrozencourt.customer.data.repository.DataStoreRepository
import com.nearbyfrozencourt.customer.domain.use_cases.user.UserUseCases
import com.nearbyfrozencourt.customer.presentation.state.OrderSectionState
import com.nearbyfrozencourt.customer.util.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OrdersViewModel @Inject constructor(
    dataStoreRepository: DataStoreRepository,
    private val userUseCases: UserUseCases
): BaseViewModel(dataStoreRepository) {

//    private val _loggedInUserState = mutableStateOf<Response<LoggedInUserDto>>(Response.Loading(false))
//    val loggedInUserState : State<Response<LoggedInUserDto>> = _loggedInUserState

    private val _businessDetailsState = mutableStateOf<Response<BusinessDetailsDto>>(Response.Loading(false))
    val businessDetailsState : State<Response<BusinessDetailsDto>> = _businessDetailsState

    private val _productsState = mutableStateOf<Response<ProductDetailsDto>>(Response.Loading(false))
    val productsState : State<Response<ProductDetailsDto>> = _productsState

//    private val _orderSectionState = mutableStateOf(OrderSectionState())
//    val orderSectionState: State<OrderSectionState> = _orderSectionState

    private var getProductsJob: Job? = null

    init {
//        userUseCases.getLoggedInUserUseCase(authToken.value).onEach {
//            _loggedInUserState.value = it
//        }.launchIn(viewModelScope)
        userUseCases.getBusinessDetailsUseCase(authToken.value).onEach {
            _businessDetailsState.value = it
        }.launchIn(viewModelScope)
        userUseCases.getProductsUseCase(authToken = authToken.value, locationId = "").onEach {
            _productsState.value = it
        }.launchIn(viewModelScope)
    }

    fun getProductsAsPerLocation(locationId : String){
        getProductsJob?.cancel()
        getProductsJob = userUseCases.getProductsUseCase(authToken = authToken.value, locationId = locationId).onEach {
            _productsState.value = it
        }.launchIn(viewModelScope)
    }

}