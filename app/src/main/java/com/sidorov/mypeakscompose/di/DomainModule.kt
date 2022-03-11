package com.sidorov.mypeakscompose.di

import android.content.Context
import com.sidorov.mypeakscompose.data.network.ApiService
import com.sidorov.mypeakscompose.data.repository.mock.MockRoutesRepository
import com.sidorov.mypeakscompose.data.repository.remote.RemoteRoutesRepository
import com.sidorov.mypeakscompose.domain.usecase.RoutesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DomainModule {

    @Singleton
    @Provides
    fun provideRoutesUseCase(routesRepository: RemoteRoutesRepository) =
        RoutesUseCase(routesRepository)

    @Singleton
    @Provides
    @Named("remote")
    fun provideRemoteRoutesRepository(api: ApiService, context: Context) =
        RemoteRoutesRepository(api, context)

    @Singleton
    @Provides
    @Named("mock")
    fun provideMockRoutesRepository() = MockRoutesRepository()
}
