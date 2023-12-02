package com.nearbyfrozencourt.customer.presentation

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nearbyfrozencourt.customer.data.remote.dto.GenerateTokenDto
import com.nearbyfrozencourt.customer.data.repository.DataStoreRepository
import com.nearbyfrozencourt.customer.domain.use_cases.nfc.NFCUseCases
import com.nearbyfrozencourt.customer.util.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    dataStoreRepository: DataStoreRepository,
    private val nfcUseCases: NFCUseCases
) : BaseViewModel(dataStoreRepository) {

    private val _loginState = mutableStateOf<Response<GenerateTokenDto>>(Response.Loading(false))
    val state : State<Response<GenerateTokenDto>> = _loginState

    var username = mutableStateOf("")
        private set
    var password = mutableStateOf("")
        private set

    fun generateToken(){
        nfcUseCases.generateTokenUseCase(username = username.value.trim(), password = password.value.trim()).onEach {
            when(it){
                is Response.Loading -> {
                    _loginState.value = Response.Loading(it.loading)
                }
                is Response.Success -> {
                    dataStoreRepository.saveUserLoggedBoolean(true)
                    dataStoreRepository.setAuthToken(it.data.access_token)
                    _loginState.value = Response.Success(it.data)
//                    Log.d("tagged", "generateToken: ${it.data}")
                }
                is Response.Failure -> {
                    _loginState.value = Response.Failure(it.message)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun username(name : String){
        username.value = name
    }

    fun password(pass: String){
        password.value= pass
    }
}