package com.nearbyfrozencourt.customer.domain.use_cases

data class NFCUseCases(
    val generateTokenUseCase: GenerateTokenUseCase,
    val paymentDetailsUseCase: PaymentDetailsUseCase
)
