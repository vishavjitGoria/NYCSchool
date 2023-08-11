package com.nyc.myapplication.data.datasource

import com.nyc.myapplication.data.model.GetSchoolDetails
import com.nyc.myapplication.data.model.HighSchoolList
import retrofit2.Response

interface AppRepo {
    suspend fun fetchHighSchools():Response<HighSchoolList>

    suspend fun fetchDetailByDBN(dbn:String):Response<GetSchoolDetails>
}