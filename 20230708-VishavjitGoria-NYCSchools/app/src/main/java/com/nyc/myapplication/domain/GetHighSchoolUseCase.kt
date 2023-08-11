package com.nyc.myapplication.domain

import com.nyc.myapplication.data.datasource.AppRepoImpl
import com.nyc.myapplication.data.model.HighSchoolList
import retrofit2.Response
import javax.inject.Inject

class GetHighSchoolUseCase @Inject constructor(private val appRepoImpl: AppRepoImpl) {

    suspend operator fun invoke(): Response<HighSchoolList> {
        return appRepoImpl.fetchHighSchools()
    }
}