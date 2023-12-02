package com.nearbyfrozencourt.customer.domain.use_cases.user

data class UserUseCases(
    val getLoggedInUserUseCase: GetLoggedInUserUseCase,
    val getBusinessDetailsUseCase: GetBusinessDetailsUseCase,
    val getProductsUseCase: GetProductsUseCase
)