package com.nearbyfrozencourt.customer.presentation

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nearbyfrozencourt.customer.data.remote.dto.LoggedInUserDto
import com.nearbyfrozencourt.customer.data.repository.DataStoreRepository
import com.nearbyfrozencourt.customer.util.Response
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

open class BaseViewModel (val dataStoreRepository: DataStoreRepository) : ViewModel()  {

    val isLoggedIn : MutableState<Boolean> = mutableStateOf(false)
    val authToken : MutableState<String> = mutableStateOf("")

    init {
        dataStoreRepository.getUserLoggedBoolean.onEach {
            isLoggedIn.value = it
            Log.d("tagged", ": logged $it")

        }.launchIn(viewModelScope)
        dataStoreRepository.getAuthToken.onEach {
            authToken.value = it
            Log.d("tagged", ": token $it ")

        }.launchIn(viewModelScope)
    }
}