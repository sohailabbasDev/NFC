package com.nearbyfrozencourt.customer.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.nearbyfrozencourt.customer.data.remote.dto.LoggedInUserDto
import com.nearbyfrozencourt.customer.data.repository.DataStoreRepository
import com.nearbyfrozencourt.customer.domain.use_cases.user.UserUseCases
import com.nearbyfrozencourt.customer.util.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    dataStoreRepository: DataStoreRepository,
    private val userUseCases: UserUseCases
): BaseViewModel(dataStoreRepository) {

//    private val _loggedInUserState = mutableStateOf<Response<LoggedInUserDto>>(Response.Loading(false))
//    val loggedInUserState : State<Response<LoggedInUserDto>> = _loggedInUserState
//
//    init {
//        viewModelScope.launch {
//            getLoggedInUserDetails()
//            cancel()
//        }
//    }
//    private fun getLoggedInUserDetails(){
//        userUseCases.getLoggedInUserUseCase(authToken.value).onEach {
//            _loggedInUserState.value = it
//        }
//    }




}