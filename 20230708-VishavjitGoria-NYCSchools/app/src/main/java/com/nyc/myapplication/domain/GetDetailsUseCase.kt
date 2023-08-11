package com.nyc.myapplication.domain

import com.nyc.myapplication.data.datasource.AppRepoImpl
import com.nyc.myapplication.data.model.GetSchoolDetails
import retrofit2.Response
import javax.inject.Inject

class GetDetailsUseCase @Inject constructor(private val appRepoImpl: AppRepoImpl) {

    suspend operator fun invoke(dbn: String): Response<GetSchoolDetails> {
        return appRepoImpl.fetchDetailByDBN(dbn)
    }
}