package com.nyc.myapplication.data.api

import com.nyc.myapplication.data.model.GetSchoolDetails
import com.nyc.myapplication.data.model.HighSchoolList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("s3k6-pzi2.json")
    suspend fun fetchHighSchools(): Response<HighSchoolList>

    @GET("f9bf-2cp4.json")
    suspend fun fetchSATFromDbn(
        @Query("dbn") dbn: String
    ): Response<GetSchoolDetails>

}