package com.nyc.myapplication.data.datasource

import com.nyc.myapplication.data.api.ApiService
import com.nyc.myapplication.data.model.GetSchoolDetails
import com.nyc.myapplication.data.model.HighSchoolList
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton


class AppRepoImpl @Inject constructor(private val apiService: ApiService) : AppRepo {

    override suspend fun fetchHighSchools(): Response<HighSchoolList> {
        return apiService.fetchHighSchools()
    }

    override suspend fun fetchDetailByDBN(dbn:String): Response<GetSchoolDetails> {
        return apiService.fetchSATFromDbn(dbn)
    }
}