package com.nearbyfrozencourt.customer.di

import android.content.Context
import com.nearbyfrozencourt.customer.data.remote.NFCApi
import com.nearbyfrozencourt.customer.data.repository.DataStoreRepository
import com.nearbyfrozencourt.customer.data.repository.NFCRepositoryImpl
import com.nearbyfrozencourt.customer.domain.NFCRepository
import com.nearbyfrozencourt.customer.domain.use_cases.nfc.GenerateTokenUseCase
import com.nearbyfrozencourt.customer.domain.use_cases.nfc.NFCUseCases
import com.nearbyfrozencourt.customer.domain.use_cases.orders.OrdersUseCases
import com.nearbyfrozencourt.customer.domain.use_cases.payments.PaymentDetailsUseCase
import com.nearbyfrozencourt.customer.domain.use_cases.payments.PaymentsUseCases
import com.nearbyfrozencourt.customer.domain.use_cases.user.GetBusinessDetailsUseCase
import com.nearbyfrozencourt.customer.domain.use_cases.user.GetLoggedInUserUseCase
import com.nearbyfrozencourt.customer.domain.use_cases.user.GetProductsUseCase
import com.nearbyfrozencourt.customer.domain.use_cases.user.UserUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNFCApi() : NFCApi {
        return Retrofit.Builder()
            .baseUrl(NFCApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideNFCRepositoryImpl(nfcApi: NFCApi) : NFCRepository{
        return NFCRepositoryImpl(nfcApi = nfcApi)
    }

    @Provides
    @Singleton
    fun provideNFCUseCases(nfcRepository: NFCRepository) : NFCUseCases {
        return NFCUseCases(
                generateTokenUseCase = GenerateTokenUseCase(nfcRepository = nfcRepository),
            )
    }

    @Provides
    @Singleton
    fun providePaymentsUseCases(nfcRepository: NFCRepository) : PaymentsUseCases {
        return PaymentsUseCases(
            paymentDetailsUseCase = PaymentDetailsUseCase(nfcRepository = nfcRepository)
        )
    }

    @Provides
    @Singleton
    fun provideUserUseCases(nfcRepository: NFCRepository) : UserUseCases{
        return UserUseCases(
            getLoggedInUserUseCase = GetLoggedInUserUseCase(nfcRepository = nfcRepository),
            getBusinessDetailsUseCase = GetBusinessDetailsUseCase(nfcRepository = nfcRepository),
            getProductsUseCase = GetProductsUseCase(nfcRepository = nfcRepository)
        )
    }

    @Provides
    @Singleton
    fun provideOrdersUseCases(nfcRepository: NFCRepository) : OrdersUseCases{
        return OrdersUseCases(
            getBusinessDetailsUseCase = GetBusinessDetailsUseCase(nfcRepository = nfcRepository)
        )
    }

    @Provides
    @Singleton
    fun provideDataStoreRepository(
        @ApplicationContext context: Context
    ) = DataStoreRepository(context = context)
}