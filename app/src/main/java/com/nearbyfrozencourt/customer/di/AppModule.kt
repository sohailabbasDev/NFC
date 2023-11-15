package com.nearbyfrozencourt.customer.di

import android.content.Context
import com.nearbyfrozencourt.customer.data.remote.NFCApi
import com.nearbyfrozencourt.customer.data.repository.DataStoreRepository
import com.nearbyfrozencourt.customer.data.repository.NFCRepositoryImpl
import com.nearbyfrozencourt.customer.domain.NFCRepository
import com.nearbyfrozencourt.customer.domain.use_cases.GenerateTokenUseCase
import com.nearbyfrozencourt.customer.domain.use_cases.NFCUseCases
import com.nearbyfrozencourt.customer.domain.use_cases.PaymentDetailsUseCase
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
    fun provideNFCUseCases(nfcRepository: NFCRepository) : NFCUseCases{
        return NFCUseCases(
            generateTokenUseCase = GenerateTokenUseCase(nfcRepository = nfcRepository),
            paymentDetailsUseCase = PaymentDetailsUseCase(nfcRepository = nfcRepository)
            )
    }

    @Provides
    @Singleton
    fun provideDataStoreRepository(
        @ApplicationContext context: Context
    ) = DataStoreRepository(context = context)
}