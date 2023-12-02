package com.nearbyfrozencourt.customer.presentation.state

import com.nearbyfrozencourt.customer.data.remote.dto.BusinessDetailsDto
import com.nearbyfrozencourt.customer.data.remote.dto.ProductDetailsDto

data class OrderSectionState(
    val locationList : List<BusinessDetailsDto.LocationX> = emptyList(),
    val productsList : List<ProductDetailsDto.Data> = emptyList(),
    val isBeingLoaded : Boolean = true,
    val failureMessage : String? = null
)