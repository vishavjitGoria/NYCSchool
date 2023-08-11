package com.nyc.myapplication.presentation.di

import com.nyc.myapplication.data.api.ApiClient
import com.nyc.myapplication.data.api.ApiService
import com.nyc.myapplication.data.datasource.AppRepoImpl


import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideClient(): ApiService {
        return ApiClient.with()
    }

    @Singleton
    @Provides
    fun provideAppRepo(apiService: ApiService): AppRepoImpl {
        return AppRepoImpl(apiService)
    }

}