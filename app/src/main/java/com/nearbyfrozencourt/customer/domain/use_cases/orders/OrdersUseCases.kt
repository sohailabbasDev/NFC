package com.nearbyfrozencourt.customer.domain.use_cases.orders

import com.nearbyfrozencourt.customer.domain.use_cases.user.GetBusinessDetailsUseCase

data class OrdersUseCases(
    val getBusinessDetailsUseCase: GetBusinessDetailsUseCase
)
